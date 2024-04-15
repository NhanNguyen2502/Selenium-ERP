package erp.pages;

import erp.common.helpers.PropertiesHelper;
import erp.common.helpers.TranslationHelpers;
import erp.common.helpers.ValidateHelpers;
import erp.pages.SalePage.SaleTable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class DashBoardPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private ValidateHelpers validateHelpers;

    private By languageButton = By.xpath("(//div//app-language-option//button[@data-cy='language-option-btn'])[2]");
    private By languageOptions = By.xpath("//div[@data-cy='language-option-item']");
    //left menu
    private By dashboardLink = By.xpath("//a[@data-cy='sidebar-dashboard-link']");
    private By salesLink = By.xpath("//a[@data-cy='sidebar-invoice-link']");
    private By customersLink = By.xpath("//a[@data-cy='sidebar-customer-link']");
    private By productsLink = By.xpath("//a[@data-cy='sidebar-product-link']");
    private By feesLink = By.xpath("//a[@data-cy='sidebar-fee-link']");
    private By employees = By.xpath("//a[@data-cy='sidebar-employee-link']");
    private By companySettingLink = By.xpath("//a[@data-cy='sidebar-company-setting-link']");
    //body Chart
    private By charttable = By.xpath("//div[@id='invoice-chart-container']//app-invoice-chart");
    private By chartTitle = By.xpath("//app-year-picker");
    private By chartYearPicker = By.xpath("//button[@data-cy='drop-down-button']");
    private By keyData = By.xpath("//app-key-data");
    private By chart = By.xpath("//app-invoice-chart");
    private By poppularProducts = By.xpath("//app-most-popular-product");
    private By topCustomers = By.xpath("//app-top-customers");
    private By period = By.xpath("//app-period-stats");
    private By keydataTitle = By.xpath("//app-key-data//div[@class='key-item-title']");
    private By currencyName = By.xpath("//app-key-data//div[contains(@class,'currency-text')]");
    //Account section
    private By accountSection = By.xpath("//app-accounts-section");
    private By accountList = By.xpath("//mat-card-content//div[contains(@class,'accounts-section-content')]");
    private By eachAccounts = By.xpath(accountList+"/div");
    private By saleButton = By.xpath("//a[@data-cy='sidebar-invoice-link']");

    public DashBoardPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        validateHelpers = new ValidateHelpers(driver);
    }
    public SaleTable goSaleTable()
    {
        validateHelpers.clickElement(saleButton);
        return  new SaleTable(driver);
    }

    public void verifyAccountSection() {
        validateHelpers.checkDisplayed(accountSection);
    }

    public void verifyChartSection() {
        Assert.assertTrue(validateHelpers.checkDisplayed(charttable));
        Assert.assertTrue(validateHelpers.checkDisplayed(chartTitle));
        Assert.assertTrue(validateHelpers.checkDisplayed(chartYearPicker));
        Assert.assertTrue(validateHelpers.checkDisplayed(keyData));
        Assert.assertTrue(validateHelpers.checkDisplayed(chart));
        Assert.assertTrue(validateHelpers.checkDisplayed(poppularProducts));
        Assert.assertTrue(validateHelpers.checkDisplayed(topCustomers));
        Assert.assertTrue(validateHelpers.checkDisplayed(period));
    }

    public void verifyLeftMenu(String daText, String saleText, String cuText, String proText, String feeText, String emplText, String coText) {
        Assert.assertTrue(validateHelpers.checkDisplayed(dashboardLink));
        Assert.assertTrue(validateHelpers.checkDisplayed(salesLink));
        Assert.assertTrue(validateHelpers.checkDisplayed(customersLink));
        Assert.assertTrue(validateHelpers.checkDisplayed(productsLink));
        Assert.assertTrue(validateHelpers.checkDisplayed(feesLink));
        Assert.assertTrue(validateHelpers.checkDisplayed(employees));
        Assert.assertTrue(validateHelpers.checkDisplayed(companySettingLink));
        Assert.assertEquals(validateHelpers.getMessage(dashboardLink), daText, " verifyLeftMenu 1");
        Assert.assertEquals(validateHelpers.getMessage(salesLink), saleText, "verifyLeftMenu 2");
        Assert.assertEquals(validateHelpers.getMessage(customersLink), cuText, "verifyLeftMenu 3");
        Assert.assertEquals(validateHelpers.getMessage(productsLink), proText, "verifyLeftMenu 4");
        Assert.assertEquals(validateHelpers.getMessage(feesLink), feeText, "verifyLeftMenu 5");
        Assert.assertEquals(validateHelpers.getMessage(employees), emplText, "verifyLeftMenu 6");
        Assert.assertEquals(validateHelpers.getMessage(companySettingLink), coText, "verifyLeftMenu 6");
    }

    public void verifylanguage(String language) {
        validateHelpers.clickElement(languageButton);
        wait.until(ExpectedConditions.elementToBeClickable(languageOptions));
        List<WebElement> options = driver.findElements(languageOptions);
        String key = "$.languageSelect.option.english";
        switch (language) {
            case "English" -> key = "$.languageSelect.option.english";
            case "Arabic" -> key = "$.languageSelect.option.arabic";
            case "Kurdish - Badini" -> key = "$.languageSelect.option.badini";
            case "Kurdish - Sorani" -> key = "$.languageSelect.option.sorani";
            default -> System.out.println("default");
        }
        for (WebElement o : options) {
            if (o.getText().contains(language) || o.getText().contains(TranslationHelpers.setFile(PropertiesHelper.getLanguageToTest(), key))) {
                System.out.println(o.getText());
                o.click();
            }
        }
    }


    public void waiForLoadingPage() {
        ExpectedCondition<Boolean> expectedCondition = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
            }
        };
        try {
            Thread.sleep(2000);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(expectedCondition);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }
}
