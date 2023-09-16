package erp.base;

import erp.common.helpers.PropertiesHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseSetup {
    private WebDriver driver;

    public WebDriver getDriver() {

        return driver;
    }


    private WebDriver innitChrome(String url) {
        System.out.println("Launching Chrome browser...");
        WebDriverManager.chromedriver().setup();
        WebDriverManager.chromedriver().clearDriverCache().setup();
        WebDriverManager.chromedriver().clearResolutionCache().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        return driver;
    }

    private static WebDriver initFirefoxDriver(String url) {
        System.out.println("Launching Firefox browser...");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        return driver;
    }

    @BeforeClass
    public void Setup() {
        PropertiesHelper.loadAllFile();
        String browser = PropertiesHelper.getValue("browser");
        switch (browser) {
            case "Chrome":
                driver = innitChrome(PropertiesHelper.getValue("url_preprod"));
                break;
            case "Firefox":
                driver = initFirefoxDriver(PropertiesHelper.getValue("url_preprod"));
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

    @AfterClass
    public void TearDown() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }
}
