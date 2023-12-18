package erp.pages;

import erp.base.BaseSetup;
import erp.common.helpers.PropertiesHelper;
import erp.common.helpers.TranslationHelpers;
import erp.common.helpers.ValidateHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class CreateCompanyPage extends BaseSetup {
    private WebDriver driver;
    private WebDriverWait wait;
    private ValidateHelpers validateHelpers;
    private Actions action;

    private  By createBt = By.xpath("//button[@data-cy='create-company-btn']");
    private By markstep1 = By.xpath("//mat-step-header[@aria-posinset='1']");
    private By markstep1Content = By.xpath("//mat-step-header[@aria-posinset='1']//div[3]");
    private By markstep2 = By.xpath("//mat-step-header[@aria-posinset='2']");
    private By markstep2Content = By.xpath("//mat-step-header[@aria-posinset='2']//div[3]");
    private By markstep3 = By.xpath("//mat-step-header[@aria-posinset='3']");
    private By markstep3Content = By.xpath("//mat-step-header[@aria-posinset='3']//div[3]");
    private By createRealCompanySection = By.xpath("//mat-card[1]");
    private By createRealCompanyHeader = By.xpath("//mat-card[1]//mat-card-header//.//div");
    private By createRealCompanyContent = By.xpath("//mat-card[1]//mat-card-content//span");
    private By createRealCompanyButton = By.xpath("//mat-card[1]//mat-card-content//div/div//div");
    private By createDemoCompanySection = By.xpath("//mat-card[2]");
    private By createDemoCompanyHeader = By.xpath("//mat-card[2]//mat-card-header//.//div");
    private By createDemoCompanyContent = By.xpath("//mat-card[2]//mat-card-content//span");
    private By createDemoCompanyButton = By.xpath("//mat-card[2]//mat-card-content//div/div//div");
    private By languageButton = By.xpath("//app-language-option");
    private By languageOptions = By.xpath("//div[@data-cy='language-option-item']");
    private By step1Completed = By.xpath("//mat-step-header[1]//div[2]//span[1]");
    private By breadcrumbTitle = By.xpath("//app-breadcrumb//.//span[@data-cy='breadcrumb-label']");
    private By createCompanyTitle = By.xpath("//app-page-title[@data-cy='createCompanyTitle']");
    private By appPageDescription = By.xpath("//app-page-content//app-erp-description");
    private By companyInformation = By.xpath("//app-company-basic-info//form");
    private By companyInformationTitle = By.xpath("//app-company-basic-info//span//mat-panel-title//div");
    private By cpCollapSectionButton = By.xpath("(//button[@data-cy='expandable-buton'])[1]");
    private By organizationNo = By.xpath("(//app-company-basic-info//div[@class='input-field-wrapper'])[1]//label//span[1]");
    private By organizationNoField = By.xpath("//input[@formcontrolname='organisationNumber']");
    private By organisationWarning = By.xpath("//app-company-basic-info//div[@class='organisation-warning']");
    private By orgaisationErrorMessage = By.xpath("//div[@data-cy='organisationNumberRequiredErrorMessage']");
    private By companyTitle = By.xpath("//app-company-basic-info//div[@role='region']//div//div[2]//span[@class='label'][1]");
    private By companyFiled = By.xpath("//input[@data-cy='companyName']");
    private By companyErrorMessage = By.xpath("//div[@data-cy='companyNameRequiredErrorMessage']");
    private By maincurrencyTitle = By.xpath("//app-company-basic-info//mat-accordion//div[@role='region']//div//div//div[3]//div//label//span[1]");
    private By mainCurrencyField = By.xpath("(//mat-form-field//input[@type='text'])[1]");
    private By mainCurrencyButtonDropDown = By.xpath("(//button[@data-cy='drop-down-button'])[1]");
    private By currencyOptions = By.xpath("//mat-option//span//span");
    private By mainCurrencyErrorMessage = By.xpath("//div[@data-cy='main-currency-required']");
    private By mainCurrencyWarning = By.xpath("//div[@class='main-currency-warning']");
    private By establishedTitle = By.xpath("//div[@class='main-currency-warning']//following::label[1]");
    private By establishedDate = By.xpath("//input[@data-cy='establishDate']");
    private By establishedDateButton = By.xpath("//button[@aria-label='Open calendar']");
    private By estabErrorMessage = By.xpath("(//mat-form-field)[4]//div[2]//div//mat-error//span");
    private By companyContactInfor = By.xpath("//app-company-contact-info");
    private By ctCollapSectionButton = By.xpath("(//button[@data-cy='expandable-buton'])[2]");
    private By companyContactInforTitle = By.xpath("(//mat-expansion-panel-header//span//mat-panel-title//div)[2]");
    private By ctEmailTitle = By.xpath("(//app-company-contact-info//div[@role='region']//div[1]//div[1]//div[1]//label)[1]//span");
    private By ctEmailField = By.xpath("//input[@data-cy='email']");
    private By ctPhoneTitle = By.xpath("//div[@class='company-phone']//label");
    private By ctPhoneCodefield = By.xpath("//input[@data-cy='phone-dial-code-input']");
    private By ctPhoneCodeButton = By.xpath("//app-phone-dial-code-select//input[@data-cy='phone-dial-code-input']");
    private By ctPhoneCodeList = By.xpath("//mat-option[@data-cy='phone-dial-code-option']");
    private By ctPhonenumberField = By.xpath("//input[@data-cy='phone-number-input']");
    private By ctWebsitetitle = By.xpath("(//span[@class='label'])[5]");
    private By ctWebSiteField = By.xpath("//input[@data-cy='website']");
    private By addressSectionTitle = By.xpath("(//div[@formgroupname='address']//label)[1]");
    private By addFirst = By.xpath("(//div[@formgroupname='address']//label)[2]");
    private By addFirstField = By.xpath("//input[@data-cy='firstStreetAddress']");
    private By addSecond = By.xpath("(//div[@formgroupname='address']//label)[3]");
    private By addSecondField = By.xpath("//input[@data-cy='secondStreetAddress']");
    private By addThird = By.xpath("(//div[@formgroupname='address']//label)[4]");
    private By addThirdField = By.xpath("//input[@data-cy='thirdStreetAddress']");
    private By addCountry = By.xpath("(//div[@formgroupname='address']//label)[5]");
    private By addCountryField = By.xpath("//input[@data-cy='country-input']");
    private By addCountryButton = By.xpath("//app-country//button[@data-cy='drop-down-button']");
    private By addZipCode = By.xpath("(//div[@formgroupname='address']//label)[6]");
    private By addZipCodeField = By.xpath("//input[@data-cy='postal-code-input']");
    private By addCity = By.xpath("(//div[@formgroupname='address']//label)[7]");
    private By addCityField = By.xpath("//input[@data-cy='city-input']");
    private By addTimeZone = By.xpath("(//div[@formgroupname='address']//label)[8]");
    private By addTimeZoneField = By.xpath("//input[@data-cy='timezone-input']");
    private By addTimeZoneButton = By.xpath("//app-timezone//button");
    private By cancelCreateButton = By.xpath("//button[@data-cy='cancel-company-button']");
    private By createButton = By.xpath("//button[@data-cy='create-legal-company-button']");
    private By leaveButton = By.xpath("//button[@data-cy='dialog-yes-button']");
    private By demoCompanyButton = By.xpath("//button[@data-cy='move-to-create-test-company-button']");


    public CreateCompanyPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
        validateHelpers = new ValidateHelpers(driver);
        action = new Actions(driver);
    }

   public void  goToCreateCompany()
   {
       validateHelpers.clickElement(createBt);
   }

    public CreateDemoCompanyPage goToCreateDemoCompanyForm() {
        validateHelpers.clickElement(demoCompanyButton);
        return new CreateDemoCompanyPage(driver);
    }

    public void leaveFormcreate() {
        action.moveToElement(driver.findElement(cancelCreateButton)).build().perform();
        WebElement a = driver.findElement(cancelCreateButton);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", a);
        validateHelpers.clickElement(leaveButton);
    }

    public void verifyTextOfStep(String ContentOfStep1, String ContentOfStep2, String ContentOfStep3) {
        Assert.assertTrue(validateHelpers.checkDisplayed(markstep1));
        Assert.assertTrue(validateHelpers.checkDisplayed(markstep2));
        Assert.assertTrue(validateHelpers.checkDisplayed(markstep3));
        Assert.assertEquals(validateHelpers.getMessage(markstep1Content), ContentOfStep1, "Mark1 wrong text");
        Assert.assertEquals(validateHelpers.getMessage(markstep2Content), ContentOfStep2, "Mark2 wrong text");
        Assert.assertEquals(validateHelpers.getMessage(markstep3Content), ContentOfStep3, "Mark3 wrong text");
    }

    public void verifyTextOfCreateSection(String realHeader, String realContent,
                                          String realButtonText, String demoHeader, String demoContent,
                                          String demoButtonText) {
        Assert.assertTrue(validateHelpers.checkDisplayed(createRealCompanySection));
        Assert.assertTrue(validateHelpers.checkDisplayed(createDemoCompanySection));
        Assert.assertEquals(validateHelpers.getMessage(createRealCompanyHeader), realHeader, "Create real section title wrong");
        Assert.assertEquals(validateHelpers.getMessage(createRealCompanyContent), realContent, "Create real content section title wrong");
        Assert.assertEquals(validateHelpers.getMessage(createRealCompanyButton), realButtonText, "Real button text wrong");
        Assert.assertEquals(validateHelpers.getMessage(createDemoCompanyHeader), demoHeader, "Header demo wrong");
        Assert.assertEquals(validateHelpers.getMessage(createDemoCompanyContent), demoContent, "demo content wrong");
        Assert.assertEquals(validateHelpers.getMessage(createDemoCompanyButton), demoButtonText, "demo button wrong");

    }

    public CreateRealCompanyPage goToCreatecRealCompanyPage() {
        validateHelpers.clickElement(createRealCompanyButton);
        return new CreateRealCompanyPage(driver);
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
            default -> key = "$.languageSelect.option.english";
        }
        for (WebElement o : options) {
            if (o.getText().contains(language) || o.getText().contains(TranslationHelpers.setFile(PropertiesHelper.getLanguageToTest(), key))) {
                System.out.println(o.getText());
                o.click();
            }
        }
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
