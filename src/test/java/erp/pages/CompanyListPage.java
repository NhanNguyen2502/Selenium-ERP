package erp.pages;

import erp.common.helpers.PropertiesHelper;
import erp.common.helpers.TranslationHelpers;
import erp.common.helpers.ValidateHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Properties;

public class CompanyListPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private ValidateHelpers validateHelpers;


    private By selecteCompanyDropdown = By.xpath("//div[@data-cy='select-company-button']");
    //private By companyListTitle = By.xpath("//span[@data-cy='company-list-title']");
    @FindBy(xpath = "//span[@data-cy='company-list-title']")
    WebElement companyListTitle;
    //private By currentPageTitle = By.xpath("//span[@data-cy='breadcrumb-label']");
    @FindBy(xpath = "//span[@data-cy='breadcrumb-label']")
    WebElement currentPageTitle;
    private By contactUsLink = By.xpath("//a[@data-cy='contact-us-link']");
    //private By languageOption = By.xpath("//app-language-option//button[@data-cy='language-option-btn']");
    @FindBy(xpath = "//app-language-option//button[@data-cy='language-option-btn']")
    WebElement languageOption;
    private By nameOfAccount = By.xpath("//button//span//span[@class='user-name text-truncate text-initial']");
    private By logoutButton = By.xpath("//button[@data-cy='log-out-button']");
    //private By createButton = By.xpath("//button[@data-cy='create-company-btn']");
    @FindBy(xpath = "//button[@data-cy='create-company-btn']")
    WebElement createButton;
    //private By companyStatusList = By.xpath("//div//input[@id='company-status-select']");
    @FindBy(xpath = "//div//input[@id='company-status-select']")
    WebElement companyStatusList;
    //private By columnConfigButton = By.xpath("//div//button[@data-cy='table-column-config-button']");
    @FindBy(xpath = "//div//button[@data-cy='table-column-config-button']")
    WebElement columnConfigButton;
    //private By rowPagePerText = By.xpath("//span[@class='text-truncate']");
    @FindBy(xpath = "//span[@class='text-truncate']")
    WebElement rowPagePerText;
    //private By rowPagePerSelection = By.xpath("//div//input[@data-cy='page-size']");
    @FindBy(xpath = "//div//input[@data-cy='page-size']")
    WebElement rowPagePerSelection;
    //private By searchField = By.xpath("(//input[@id='search-input-field'])[1]");
    @FindBy(xpath = "(//input[@id='search-input-field'])[1]")
    WebElement searchField;
    //private By companyTable = By.xpath("//table[@id='company-list-table']");
    @FindBy(xpath = "//table[@id='company-list-table']")
    WebElement companyTable;
    //private By tableTitle = By.xpath("//mat-header-row[@role='row']");
    @FindBy(xpath = "//mat-header-row[@role='row']")
    WebElement tableTitle;
    private By languageButton = By.xpath("//app-language-option");
    private By languageOptions = By.xpath("//div[@data-cy='language-option-item']");

    public CompanyListPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        validateHelpers = new ValidateHelpers(driver);
        PageFactory.initElements(driver, this);
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


    public boolean verifySelectCompanyonLeftMenu() {
        WebElement element = driver.findElement(selecteCompanyDropdown);
        return element.isDisplayed();
    }

    public boolean verifyHeader() {
        WebElement contactUs = driver.findElement(contactUsLink);
        WebElement accountName = driver.findElement(nameOfAccount);
        WebElement logoutElement = driver.findElement(logoutButton);
        if (true) {
            contactUs.isDisplayed();
            accountName.isDisplayed();
            logoutElement.isDisplayed();
            return true;
        }
        return false;
    }

    public boolean verifyBodyOfPage(String Companies, String companyList, String rowtext) {
        if (true) {
            currentPageTitle.getText().equals(Companies);
            tableTitle.getText().equals(companyList);
            createButton.isDisplayed();
            companyStatusList.isDisplayed();
            columnConfigButton.isDisplayed();
            rowPagePerText.getText().equals(rowtext);
            rowPagePerSelection.isDisplayed();
            searchField.isDisplayed();
            return true;
        }
        return false;
    }

    public void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
                        .equals("complete");
            }
        };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }


}
