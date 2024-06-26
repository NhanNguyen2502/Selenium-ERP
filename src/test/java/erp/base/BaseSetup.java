package erp.base;

import erp.common.helpers.CaptureHelper;
import erp.common.helpers.PropertiesHelper;
import erp.common.helpers.ValidateHelpers;
import io.qameta.allure.Allure;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;
import ulitilities.Log;

import java.io.ByteArrayInputStream;
import java.lang.reflect.Method;
import java.time.Duration;

public class BaseSetup {
    private static WebDriver driver;
    public static String url = PropertiesHelper.getValue("url_dev");

    public static WebDriver getDriver() {

        return driver;
    }

//    private WebDriver a() {
//        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver.exe");
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//        //options.addArguments("--headless");
//        //options.setBinary("D:\\chromedriver-win64\\chromedriver.exe");
//        options.addArguments("--window-size=1920,1080");
//
//        WebDriver driver = new ChromeDriver(options);
//        driver.get("https://dev.accountia.no");
//        return driver;
//    }

    private WebDriver innitChrome(String environment, String url) {
        System.out.println("Launching Chrome browser...");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
//        //options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        //System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/java/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        return driver;
    }

    private static WebDriver initFirefoxDriver(String url) {
        System.out.println("Launching Firefox browser...");
        System.setProperty("webdriver.gecko.driver", "D:\\ERP\\Selenium-ERP\\src\\test\\java\\erp\\base\\geckodriver-v0.33.0-win64");
        FirefoxOptions options = new FirefoxOptions();
        //options.setBinary("D:\\ERP\\Selenium-ERP\\src\\test\\java\\erp\\base\\geckodriver-v0.33.0-win64");
        //FirefoxDriver driver = new FirefoxDriver(options);
        //driver.manage().window().maximize();
        //driver.get(url);
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        return driver;
    }

    public void statusTest(ITestResult result, String language) {
        if (ITestResult.SUCCESS == result.getStatus()) {
            System.out.println("Passed case: " + result.getName());
            Log.info("Passed: " + result.getName());
            //CaptureHelper.takeScreenshot(result.getName(), result.getName(), driver,language);
        } else if (ITestResult.FAILURE == result.getStatus()) {
            System.out.println("Failed: " + result.getName());
            System.out.println(result.getThrowable().toString());
            CaptureHelper.takeScreenshot(result.getName(), result.getName(), driver, language);
            Allure.addAttachment("_Failed_Screenshot", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
            //captureHelper.takeScreenshot(result.getName(),result.getName(),driver);

        } else {
            System.out.println("Passed Skiped: " + result.getName());
        }
        // CaptureHelper.stopRecord();
    }


    @BeforeClass
    @Parameters({"environment"})
    public void Setup(@Optional("dev") String environment) {
        PropertyConfigurator.configure("./src/main/java/resources/log4j.properties");
        PropertiesHelper.loadAllFile();
        String browser = PropertiesHelper.getValue("browser");
        switch (browser) {
            case "Chrome":
                driver = innitChrome(environment, url);
                break;
            case "Firefox":
                driver = initFirefoxDriver(url);
                break;
            default:
                System.out.println("default");
        }
//        System.out.println("Launching Chrome browser...");
//        WebDriverManager.chromedriver().setup();
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//        driver = new ChromeDriver(options);
//        driver.manage().window().maximize();
//        //driver.get("https://accountiadev.eztek-testing.com");
//        driver.get("https://preprod.accountia.no");
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
    }

    @BeforeMethod
    @Parameters({"language"})
    public void beforMethod(Method method, @Optional("English") String language) {
        System.out.println("\n");
        System.out.println("<========================= RUN TEST CASE =========================>");
        Log.info("Run test: " + method.getName());
        Log.info("Test on Language:" + language);
        //CaptureHelper.startRecord(method.getName());
    }

    @AfterMethod
    @Parameters({"language"})
    public void afterMetod(ITestResult result, @Optional("English") String language) {
        statusTest(result, language);
        System.out.println("<========================= FINISH TEST CASE =========================> \n");
        if (!result.isSuccess() || ITestResult.FAILURE == result.getStatus()) {
            driver.get(url);
            ValidateHelpers validateHelpers = new ValidateHelpers(driver);
            validateHelpers.logout();
        }
    }

    @AfterClass
    public void TearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }
}
