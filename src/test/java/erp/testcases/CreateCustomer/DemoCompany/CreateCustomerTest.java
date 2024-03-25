package erp.testcases.CreateCustomer.DemoCompany;

import erp.base.BaseSetup;
import erp.base.ReportListener;
import erp.common.helpers.GetTypeOfCompanyHelper;
import erp.common.helpers.PropertiesHelper;
import erp.common.helpers.ValidateHelpers;
import erp.pages.CompanyListPage;
import erp.pages.Customer.CreateCustomerPage;
import erp.pages.SignInPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

@Listeners(ReportListener.class)
public class CreateCustomerTest extends BaseSetup {
    private WebDriver driver;
    private ValidateHelpers validateHelpers;
    private SignInPage signInPage;
    private CompanyListPage companyListPage;
    private CreateCustomerPage createCustomerPage;

    @BeforeClass
    public void setup() {
        this.driver = getDriver();
        validateHelpers = new ValidateHelpers(driver);
        signInPage = new SignInPage(driver);
        companyListPage = new CompanyListPage(driver);
        createCustomerPage = new CreateCustomerPage(driver);
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void createCustomerWithValidInformation_then_createSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJs();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfDemoCompany(language));
        validateHelpers.waitForLoadJs();
        createCustomerPage.goToTheCustomerTable();
        validateHelpers.waitForLoadJs();
        createCustomerPage.goToCreateCustomerPage();
        validateHelpers.waitForLoadJs();
        createCustomerPage.enterCustomerName();
        validateHelpers.waitAfterChoseOrClickElement();
        createCustomerPage.enterEmail();
        validateHelpers.waitAfterChoseOrClickElement();
        createCustomerPage.enterPhoneNumberArabic();
        validateHelpers.waitAfterChoseOrClickElement();
        createCustomerPage.clickOnCreateButton();
        validateHelpers.waitForLoadJs();
        createCustomerPage.verifyCreate();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();

    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void createCustomerWithGroup_then_createSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJs();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfDemoCompany(language));
        validateHelpers.waitForLoadJs();
        createCustomerPage.goToTheCustomerTable();
        validateHelpers.waitForLoadJs();
        createCustomerPage.goToCreateCustomerPage();
        validateHelpers.waitForLoadJs();
        createCustomerPage.enterCustomerName();
        validateHelpers.waitAfterChoseOrClickElement();
        createCustomerPage.enterGroupForCustomer();
        validateHelpers.waitAfterChoseOrClickElement();
        createCustomerPage.enterEmail();
        validateHelpers.waitAfterChoseOrClickElement();
        createCustomerPage.enterPhoneNumberArabic();
        validateHelpers.waitAfterChoseOrClickElement();
        createCustomerPage.clickOnCreateButton();
        validateHelpers.waitForLoadJs();
        createCustomerPage.verifyCreate();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void createCustomerWithDiscount_then_createSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJs();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfDemoCompany(language));
        validateHelpers.waitForLoadJs();
        createCustomerPage.goToTheCustomerTable();
        validateHelpers.waitForLoadJs();
        createCustomerPage.goToCreateCustomerPage();
        validateHelpers.waitForLoadJs();
        createCustomerPage.enterCustomerName();
        validateHelpers.waitAfterChoseOrClickElement();
        createCustomerPage.enterGroupForCustomer();
        validateHelpers.waitAfterChoseOrClickElement();
        createCustomerPage.enterDiscount();
        validateHelpers.waitAfterChoseOrClickElement();
        createCustomerPage.enterEmail();
        validateHelpers.waitAfterChoseOrClickElement();
        createCustomerPage.enterPhoneNumberArabic();
        validateHelpers.waitAfterChoseOrClickElement();
        createCustomerPage.clickOnCreateButton();
        validateHelpers.waitForLoadJs();
        createCustomerPage.verifyCreate();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void createCustomerWithAnotherCurrency_then_createSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJs();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfDemoCompany(language));
        validateHelpers.waitForLoadJs();
        createCustomerPage.goToTheCustomerTable();
        validateHelpers.waitForLoadJs();
        createCustomerPage.goToCreateCustomerPage();
        validateHelpers.waitForLoadJs();
        createCustomerPage.enterCustomerName();
        validateHelpers.waitAfterChoseOrClickElement();
        createCustomerPage.enterGroupForCustomer();
        validateHelpers.waitAfterChoseOrClickElement();
        createCustomerPage.enterAnotherCurrency();
        validateHelpers.waitAfterChoseOrClickElement();
        createCustomerPage.enterDiscount();
        validateHelpers.waitAfterChoseOrClickElement();
        createCustomerPage.enterEmail();
        validateHelpers.waitAfterChoseOrClickElement();
        createCustomerPage.enterPhoneNumberArabic();
        validateHelpers.waitAfterChoseOrClickElement();
        createCustomerPage.clickOnCreateButton();
        validateHelpers.waitForLoadJs();
        createCustomerPage.verifyCreate();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }
    @Test(priority = 0)
    @Parameters({"language"})
    public void createCustomerWithAnotherLanguage_then_createSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJs();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfDemoCompany(language));
        validateHelpers.waitForLoadJs();
        createCustomerPage.goToTheCustomerTable();
        validateHelpers.waitForLoadJs();
        createCustomerPage.goToCreateCustomerPage();
        validateHelpers.waitForLoadJs();
        createCustomerPage.enterCustomerName();
        validateHelpers.waitAfterChoseOrClickElement();
        createCustomerPage.enterAnotherLanguage();
        validateHelpers.waitAfterChoseOrClickElement();
        createCustomerPage.enterGroupForCustomer();
        validateHelpers.waitAfterChoseOrClickElement();
        createCustomerPage.enterAnotherCurrency();
        validateHelpers.waitAfterChoseOrClickElement();
        createCustomerPage.enterDiscount();
        validateHelpers.waitAfterChoseOrClickElement();
        createCustomerPage.enterEmail();
        validateHelpers.waitAfterChoseOrClickElement();
        createCustomerPage.enterPhoneNumberArabic();
        validateHelpers.waitAfterChoseOrClickElement();
        createCustomerPage.clickOnCreateButton();
        validateHelpers.waitForLoadJs();
        createCustomerPage.verifyCreate();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void createCustomerWithCustomerNameNull_then_createFailed(@Optional("English") String language) {
        validateHelpers.waitForLoadJs();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfDemoCompany(language));
        validateHelpers.waitForLoadJs();
        createCustomerPage.goToTheCustomerTable();
        validateHelpers.waitForLoadJs();
        createCustomerPage.goToCreateCustomerPage();
        validateHelpers.waitForLoadJs();
        createCustomerPage.clickOnCreateButton();
        validateHelpers.waitAfterChoseOrClickElement();
        createCustomerPage.checkCustomerNameNull();
        validateHelpers.waitAfterChoseOrClickElement();
        createCustomerPage.verifyCreate();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }
    @Test(priority = 0)
    @Parameters({"language"})
    public void createCustomerWithSelectGroupInList_then_createFailed(@Optional("English") String language) {
        validateHelpers.waitForLoadJs();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfDemoCompany(language));
        validateHelpers.waitForLoadJs();
        createCustomerPage.goToTheCustomerTable();
        validateHelpers.waitForLoadJs();
        createCustomerPage.goToCreateCustomerPage();
        validateHelpers.waitForLoadJs();
        createCustomerPage.enterCustomerName();
        validateHelpers.waitAfterChoseOrClickElement();
        createCustomerPage.selectGroupAlreadyExist();
        validateHelpers.waitAfterChoseOrClickElement();
        createCustomerPage.clickOnCreateButton();
        validateHelpers.waitAfterChoseOrClickElement();
        createCustomerPage.checkCustomerNameNull();
        validateHelpers.waitAfterChoseOrClickElement();
        createCustomerPage.verifyCreate();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void createCustomerWithUploadAvatar_then_createSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJs();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfDemoCompany(language));
        validateHelpers.waitForLoadJs();
        createCustomerPage.goToTheCustomerTable();
        validateHelpers.waitForLoadJs();
        createCustomerPage.goToCreateCustomerPage();
        validateHelpers.waitForLoadJs();
        createCustomerPage.uploadAvatar();
        validateHelpers.waitAfterChoseOrClickElement();
        createCustomerPage.confirmDropAvatar();
        validateHelpers.waitAfterChoseOrClickElement();
        createCustomerPage.enterCustomerName();
        validateHelpers.waitAfterChoseOrClickElement();
        createCustomerPage.clickOnCreateButton();
        validateHelpers.waitAfterChoseOrClickElement();
        createCustomerPage.verifyCreate();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void createCustomerWithCancelUploadAvatar_then_createSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJs();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfDemoCompany(language));
        validateHelpers.waitForLoadJs();
        createCustomerPage.goToTheCustomerTable();
        validateHelpers.waitForLoadJs();
        createCustomerPage.goToCreateCustomerPage();
        validateHelpers.waitForLoadJs();
        createCustomerPage.uploadAvatar();
        validateHelpers.waitAfterChoseOrClickElement();
        createCustomerPage.cancelUploadAvatar();
        validateHelpers.waitAfterChoseOrClickElement();
        createCustomerPage.enterCustomerName();
        validateHelpers.waitAfterChoseOrClickElement();
        createCustomerPage.clickOnCreateButton();
        validateHelpers.waitAfterChoseOrClickElement();
        createCustomerPage.verifyCreate();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void createCustomerWithSameName_then_createFailed(@Optional("English") String language) {
        validateHelpers.waitForLoadJs();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfDemoCompany(language));
        validateHelpers.waitForLoadJs();
        createCustomerPage.goToTheCustomerTable();
        validateHelpers.waitForLoadJs();
        createCustomerPage.getNameAlreadyExist();
        validateHelpers.waitAfterChoseOrClickElement();
        createCustomerPage.goToCreateCustomerPage();
        validateHelpers.waitForLoadJs();
        createCustomerPage.enterNameAlreadyExist();
        validateHelpers.waitAfterChoseOrClickElement();
        createCustomerPage.clickOnCreateButton();
        validateHelpers.waitAfterChoseOrClickElement();
        createCustomerPage.verifyCustomerNameExist();
        validateHelpers.waitAfterChoseOrClickElement();
        createCustomerPage.verifyCreate();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }
}

