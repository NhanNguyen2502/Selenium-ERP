package erp.pages;

import erp.common.helpers.ValidateHelpers;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CreateRealCompanyPage {
    private WebDriverWait wait;
    private WebDriver driver;
    private ValidateHelpers validateHelpers;
    private Actions actions;

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
    private By mainCurrencyErrorMessage = By.xpath("//span[@data-cy='main-currency-required']");
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
    private By ctWebsitetitle = By.xpath("(//span[@class='label'])[6]");
    private By ctWebSiteField = By.xpath("//input[@data-cy='website']");
    private By addressSectionTitle = By.xpath("(//div[@formgroupname='address']//label)[1]");
    private By addFirst = By.xpath("(//div[@formgroupname='address']//label)[2]");
    private By addFirstField = By.xpath("//input[@data-cy='city-input']");
    private By addSecond = By.xpath("(//div[@formgroupname='address']//label)[3]");
    private By addSecondField = By.xpath("//input[@data-cy='secondStreetAddress']");
    private By addThird = By.xpath("(//div[@formgroupname='address']//label)[4]");
    private By addThirdField = By.xpath("//input[@data-cy='thirdStreetAddress']");
    private By addCountry = By.xpath("(//div[@formgroupname='address']//label)[5]");
    private By addCountryField = By.xpath("//input[@data-cy='country-input']");
    private By addCountryButton = By.xpath("//app-country//button[@data-cy='drop-down-button']");
    private By addZipCode = By.xpath("(//div[@class='input-field-wrapper w-100']//label)[4]");
    private By addZipCodeField = By.xpath("//input[@data-cy='postal-code-input']");
    private By addCity = By.xpath("(//div[@class='input-field-wrapper w-100']//label)[2]");
    private By addCityField = By.xpath("//input[@data-cy='city-input']");
    private By addTimeZone = By.xpath("(//div[@class='input-field-wrapper w-100']//label)[5]");
    private By addTimeZoneField = By.xpath("//input[@data-cy='timezone-input']");
    private By addTimeZoneButton = By.xpath("//app-timezone//button");
    private By cancelCreateButton = By.xpath("//button[@data-cy='cancel-company-button']");
    private By createButton = By.xpath("//button[@data-cy='create-legal-company-button']");
    private By leaveButton = By.xpath("//button[@data-cy='dialog-yes-button']");
    private By demoCompanyButton = By.xpath("//button[@data-cy='move-to-create-test-company-button']");

    public CreateRealCompanyPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        validateHelpers = new ValidateHelpers(driver);
        actions = new Actions(driver);
    }


    public void verifyTextOfContactSection(String ctTitle, String emailTitle, String phoneTitle, String websitetitle,
                                           String addressTitleText, String addFirstText, String addSecondText, String addThirdText, String addCountryText, String zipCodeText, String addCityText, String addTimeZoneText) {


        actions.moveToElement(driver.findElement(companyContactInfor)).build().perform();
        Assert.assertTrue(validateHelpers.checkDisplayed(companyContactInfor), "Error at verifyTextOfContactSection row 1");
        Assert.assertTrue(validateHelpers.checkDisplayed(companyContactInforTitle), "Error at verifyTextOfContactSection row 2");
        Assert.assertTrue(validateHelpers.checkDisplayed(ctEmailTitle), "Error at verifyTextOfContactSection row 3");
        Assert.assertTrue(validateHelpers.checkDisplayed(ctEmailField), "Error at verifyTextOfContactSection row 4");
        Assert.assertTrue(validateHelpers.checkDisplayed(ctPhoneTitle), "Error at verifyTextOfContactSection row 5");
        Assert.assertTrue(validateHelpers.checkDisplayed(ctPhoneCodefield), "Error at verifyTextOfContactSection row 6");
        Assert.assertTrue(validateHelpers.checkDisplayed(ctPhonenumberField), "Error at verifyTextOfContactSection row 7");
        Assert.assertTrue(validateHelpers.checkDisplayed(ctWebsitetitle), "Error at verifyTextOfContactSection row 8");
        Assert.assertTrue(validateHelpers.checkDisplayed(ctWebSiteField), "Error at verifyTextOfContactSection row 9");
        Assert.assertTrue(validateHelpers.checkDisplayed(addressSectionTitle), "Error at verifyTextOfContactSection row 10");
        Assert.assertTrue(validateHelpers.checkDisplayed(addFirst), "Error at verifyTextOfContactSection row 11");
        Assert.assertTrue(validateHelpers.checkDisplayed(addFirstField), "Error at verifyTextOfContactSection row 12");
        Assert.assertEquals(validateHelpers.getMessage(companyContactInforTitle), ctTitle, "Error at verifyTextOfContactSection row 12");
        Assert.assertEquals(validateHelpers.getMessage(ctEmailTitle), emailTitle, "Error at verifyTextOfContactSection row 13");
        Assert.assertEquals(validateHelpers.getMessage(ctPhoneTitle), phoneTitle, "Error at verifyTextOfContactSection row 14");
        Assert.assertEquals(validateHelpers.getMessage(ctWebsitetitle), websitetitle, "Error at verifyTextOfContactSection row 15");
        Assert.assertEquals(validateHelpers.getMessage(addressSectionTitle), addressTitleText, "Error at verifyTextOfContactSection row 16");
        Assert.assertEquals(validateHelpers.getMessage(addFirst), addFirstText, "Error at verifyTextOfContactSection row 17");
        Assert.assertEquals(validateHelpers.getMessage(addSecond), addSecondText, "Error at verifyTextOfContactSection row 18");
        Assert.assertEquals(validateHelpers.getMessage(addThird), addThirdText, "Error at verifyTextOfContactSection row 19");
        Assert.assertEquals(validateHelpers.getMessage(addCountry), addCountryText, "Error at verifyTextOfContactSection row 20");
        Assert.assertEquals(validateHelpers.getMessage(addZipCode), zipCodeText, "Error at verifyTextOfContactSection row 21");
        Assert.assertEquals(validateHelpers.getMessage(addCity), addCityText, "Error at verifyTextOfContactSection row 22");
        Assert.assertEquals(validateHelpers.getMessage(addTimeZone), addTimeZoneText, "Error at verifyTextOfContactSection row 23");
    }

    public void verifyTextofheaderPage(String breadcrumtitle, String createCompanyTitlePage, String appDescription) {
        Assert.assertTrue(validateHelpers.checkDisplayed(breadcrumbTitle));
        Assert.assertTrue(validateHelpers.checkDisplayed(createCompanyTitle));
        Assert.assertTrue(validateHelpers.checkDisplayed(appPageDescription));
        Assert.assertEquals(validateHelpers.getMessage(step1Completed), "Completed", "verifyTextofheaderPage wrong text 1");
        Assert.assertEquals(validateHelpers.getMessage(breadcrumbTitle), breadcrumtitle, "verifyTextofheaderPage wrong text 2");
        Assert.assertEquals(validateHelpers.getMessage(createCompanyTitle), createCompanyTitlePage, "verifyTextofheaderPage wrong text 3");
        Assert.assertEquals(validateHelpers.getMessage(appPageDescription), appDescription, "verifyTextofheaderPage wrong text 4");
    }

    public void verifyTextofCompanySection(String companytitle, String organization, String orWarning, String coTitle, String mainTitle, String mainWarning,
                                           String esTitle) {
        Assert.assertTrue(validateHelpers.checkDisplayed(companyInformation));
        Assert.assertTrue(validateHelpers.checkDisplayed(companyInformationTitle));
        Assert.assertTrue(validateHelpers.checkDisplayed(organizationNo));
        Assert.assertTrue(validateHelpers.checkDisplayed(organizationNoField));
        //Assert.assertTrue(validateHelpers.checkDisplayed(organisationWarning));
        Assert.assertTrue(validateHelpers.checkDisplayed(companyTitle));
        Assert.assertTrue(validateHelpers.checkDisplayed(companyFiled));
        Assert.assertTrue(validateHelpers.checkDisplayed(maincurrencyTitle));
        Assert.assertTrue(validateHelpers.checkDisplayed(mainCurrencyField));
        //Assert.assertTrue(validateHelpers.checkDisplayed(mainCurrencyWarning));
        //Assert.assertTrue(validateHelpers.checkDisplayed(establishedTitle));
        Assert.assertTrue(validateHelpers.checkDisplayed(establishedDate));
        Assert.assertTrue(validateHelpers.checkDisplayed(establishedDateButton));
        Assert.assertEquals(validateHelpers.getMessage(companyInformationTitle), companytitle);
        Assert.assertEquals(validateHelpers.getMessage(organizationNo), organization);
        //Assert.assertEquals(validateHelpers.getMessage(organisationWarning), orWarning);
        //Assert.assertEquals(validateHelpers.getMessage(organisationWarning), orWarning);
        Assert.assertEquals(validateHelpers.getMessage(companyTitle), coTitle);
        Assert.assertEquals(validateHelpers.getMessage(maincurrencyTitle), mainTitle);
        //Assert.assertEquals(validateHelpers.getMessage(mainCurrencyWarning), mainWarning);
        //Assert.assertEquals(validateHelpers.getMessage(establishedTitle), esTitle);
    }

    public void verifyFieldIsRequiredAndErrorMessage(String orErrorMessage, String comErrormessage, String mainErrorMessage) {
        Assert.assertTrue(validateHelpers.checkDisplayed(companyFiled));
        Assert.assertTrue(validateHelpers.checkDisplayed(organizationNoField));
        Assert.assertTrue(validateHelpers.checkDisplayed(mainCurrencyField));
        validateHelpers.clickElement(companyFiled);
        validateHelpers.clickElement(organizationNoField);
        validateHelpers.clickElement(mainCurrencyField);
        //validateHelpers.clickElement(mainCurrencyWarning);
        validateHelpers.clickOutside();
        // Assert.assertEquals(validateHelpers.getMessage(orgaisationErrorMessage), orErrorMessage);
        Assert.assertEquals(validateHelpers.getMessage(companyErrorMessage), comErrormessage);
        Assert.assertEquals(validateHelpers.getMessage(mainCurrencyErrorMessage), mainErrorMessage);
    }

    public void verifyTextAndFormatDateOfEstablished(String esErrorMessage) {
        //actions.moveToElement(establishedDate).build().perform();
        //validateHelpers.clearElement(establishedDate);
        validateHelpers.setText(establishedDate, "asdasd");
        validateHelpers.clickOutside();
        Assert.assertEquals(validateHelpers.getMessage(estabErrorMessage), esErrorMessage, "Wrong established error message");
    }


    public void waitForLoadPage() {
        ExpectedCondition<Boolean> expectedCondition = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
                        .equals("complete");
            }
        };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(expectedCondition);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }

}
