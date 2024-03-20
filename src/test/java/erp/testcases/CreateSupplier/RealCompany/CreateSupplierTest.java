package erp.testcases.CreateSupplier.RealCompany;

import erp.base.BaseSetup;
import erp.common.helpers.GetTypeOfCompanyHelper;
import erp.common.helpers.PropertiesHelper;
import erp.common.helpers.ValidateHelpers;
import erp.pages.CompanyListPage;
import erp.pages.CreateSupplierPage;
import erp.pages.SignInPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CreateSupplierTest extends BaseSetup {
    private WebDriver driver;
    private ValidateHelpers validateHelpers;
    private SignInPage signInPage;
    private CompanyListPage companyListPage;
    private CreateSupplierPage createSupplierPage;

    @BeforeClass
    public void setup() {
        this.driver = getDriver();
        validateHelpers = new ValidateHelpers(driver);
        signInPage = new SignInPage(driver);
        companyListPage = new CompanyListPage(driver);
        createSupplierPage = new CreateSupplierPage(driver);
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void createSupplierWithValidInformation_then_createSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJs();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        createSupplierPage.gotoSupplierTable();
        validateHelpers.waitForLoadJs();
        createSupplierPage.goToCreateSupplierPage();
        validateHelpers.waitForLoadJs();
        createSupplierPage.enterSupplierName();
        validateHelpers.waitAfterChoseOrClickElement();
        createSupplierPage.enterEmail();
        validateHelpers.waitAfterChoseOrClickElement();
        createSupplierPage.enterPhoneNumberArabic();
        validateHelpers.waitAfterChoseOrClickElement();
        createSupplierPage.clickOnCreateButton();
        validateHelpers.waitForLoadJs();
        createSupplierPage.verifyCreate();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();

    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void createSupplierWithGroup_then_createSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJs();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        createSupplierPage.gotoSupplierTable();
        validateHelpers.waitForLoadJs();
        createSupplierPage.goToCreateSupplierPage();
        validateHelpers.waitForLoadJs();
        createSupplierPage.enterSupplierName();
        validateHelpers.waitAfterChoseOrClickElement();
        createSupplierPage.enterGroupForSupplier();
        validateHelpers.waitAfterChoseOrClickElement();
        createSupplierPage.enterEmail();
        validateHelpers.waitAfterChoseOrClickElement();
        createSupplierPage.enterPhoneNumberArabic();
        validateHelpers.waitAfterChoseOrClickElement();
        createSupplierPage.clickOnCreateButton();
        validateHelpers.waitForLoadJs();
        createSupplierPage.verifyCreate();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void createSupplierWithDiscount_then_createSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJs();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        createSupplierPage.gotoSupplierTable();
        validateHelpers.waitForLoadJs();
        createSupplierPage.goToCreateSupplierPage();
        validateHelpers.waitForLoadJs();
        createSupplierPage.enterSupplierName();
        validateHelpers.waitAfterChoseOrClickElement();
        createSupplierPage.enterGroupForSupplier();
        validateHelpers.waitAfterChoseOrClickElement();
        createSupplierPage.enterDiscount();
        validateHelpers.waitAfterChoseOrClickElement();
        createSupplierPage.enterEmail();
        validateHelpers.waitAfterChoseOrClickElement();
        createSupplierPage.enterPhoneNumberArabic();
        validateHelpers.waitAfterChoseOrClickElement();
        createSupplierPage.clickOnCreateButton();
        validateHelpers.waitForLoadJs();
        createSupplierPage.verifyCreate();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void createSupplierWithAnotherCurrency_then_createSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJs();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        createSupplierPage.gotoSupplierTable();
        validateHelpers.waitForLoadJs();
        createSupplierPage.goToCreateSupplierPage();
        validateHelpers.waitForLoadJs();
        createSupplierPage.enterSupplierName();
        validateHelpers.waitAfterChoseOrClickElement();
        createSupplierPage.enterGroupForSupplier();
        validateHelpers.waitAfterChoseOrClickElement();
        createSupplierPage.enterAnotherCurrency();
        validateHelpers.waitAfterChoseOrClickElement();
        createSupplierPage.enterDiscount();
        validateHelpers.waitAfterChoseOrClickElement();
        createSupplierPage.enterEmail();
        validateHelpers.waitAfterChoseOrClickElement();
        createSupplierPage.enterPhoneNumberArabic();
        validateHelpers.waitAfterChoseOrClickElement();
        createSupplierPage.clickOnCreateButton();
        validateHelpers.waitForLoadJs();
        createSupplierPage.verifyCreate();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void createSupplierWithAnotherLanguage_then_createSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJs();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        createSupplierPage.gotoSupplierTable();
        validateHelpers.waitForLoadJs();
        createSupplierPage.goToCreateSupplierPage();
        validateHelpers.waitForLoadJs();
        createSupplierPage.enterSupplierName();
        validateHelpers.waitAfterChoseOrClickElement();
        createSupplierPage.enterAnotherLanguage();
        validateHelpers.waitAfterChoseOrClickElement();
        createSupplierPage.enterGroupForSupplier();
        validateHelpers.waitAfterChoseOrClickElement();
        createSupplierPage.enterAnotherCurrency();
        validateHelpers.waitAfterChoseOrClickElement();
        createSupplierPage.enterDiscount();
        validateHelpers.waitAfterChoseOrClickElement();
        createSupplierPage.enterEmail();
        validateHelpers.waitAfterChoseOrClickElement();
        createSupplierPage.enterPhoneNumberArabic();
        validateHelpers.waitAfterChoseOrClickElement();
        createSupplierPage.clickOnCreateButton();
        validateHelpers.waitForLoadJs();
        createSupplierPage.verifyCreate();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void createSupplierWithSupplierNameNull_then_createFailed(@Optional("English") String language) {
        validateHelpers.waitForLoadJs();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        createSupplierPage.gotoSupplierTable();
        validateHelpers.waitForLoadJs();
        createSupplierPage.goToCreateSupplierPage();
        validateHelpers.waitForLoadJs();
        createSupplierPage.clickOnCreateButton();
        validateHelpers.waitAfterChoseOrClickElement();
        createSupplierPage.checkSupplierNameNull();
        validateHelpers.waitAfterChoseOrClickElement();
        createSupplierPage.verifyCreate();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void createSupplierWithSelectGroupInList_then_createFailed(@Optional("English") String language) {
        validateHelpers.waitForLoadJs();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        createSupplierPage.gotoSupplierTable();
        validateHelpers.waitForLoadJs();
        createSupplierPage.goToCreateSupplierPage();
        validateHelpers.waitForLoadJs();
        createSupplierPage.enterSupplierName();
        validateHelpers.waitAfterChoseOrClickElement();
        createSupplierPage.selectGroupAlreadyExist();
        validateHelpers.waitAfterChoseOrClickElement();
        createSupplierPage.clickOnCreateButton();
        validateHelpers.waitAfterChoseOrClickElement();
        createSupplierPage.checkSupplierNameNull();
        validateHelpers.waitAfterChoseOrClickElement();
        createSupplierPage.verifyCreate();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void createSupplierWithUploadAvatar_then_createSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJs();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        createSupplierPage.gotoSupplierTable();
        validateHelpers.waitForLoadJs();
        createSupplierPage.goToCreateSupplierPage();
        validateHelpers.waitForLoadJs();
        createSupplierPage.uploadAvatar();
        validateHelpers.waitAfterChoseOrClickElement();
        createSupplierPage.confirmDropAvatar();
        validateHelpers.waitAfterChoseOrClickElement();
        createSupplierPage.enterSupplierName();
        validateHelpers.waitAfterChoseOrClickElement();
        createSupplierPage.clickOnCreateButton();
        validateHelpers.waitAfterChoseOrClickElement();
        createSupplierPage.verifyCreate();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void createSupplierWithCancelUploadAvatar_then_createSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJs();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        createSupplierPage.gotoSupplierTable();
        validateHelpers.waitForLoadJs();
        createSupplierPage.goToCreateSupplierPage();
        validateHelpers.waitForLoadJs();
        createSupplierPage.uploadAvatar();
        validateHelpers.waitAfterChoseOrClickElement();
        createSupplierPage.cancelUploadAvatar();
        validateHelpers.waitAfterChoseOrClickElement();
        createSupplierPage.enterSupplierName();
        validateHelpers.waitAfterChoseOrClickElement();
        createSupplierPage.clickOnCreateButton();
        validateHelpers.waitAfterChoseOrClickElement();
        createSupplierPage.verifyCreate();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void createSupplierWithSameName_then_createFailed(@Optional("English") String language) {
        validateHelpers.waitForLoadJs();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        createSupplierPage.gotoSupplierTable();
        validateHelpers.waitForLoadJs();
        createSupplierPage.getNameAlreadyExist();
        validateHelpers.waitAfterChoseOrClickElement();
        createSupplierPage.goToCreateSupplierPage();
        validateHelpers.waitForLoadJs();
        createSupplierPage.enterNameAlreadyExist();
        validateHelpers.waitAfterChoseOrClickElement();
        createSupplierPage.clickOnCreateButton();
        validateHelpers.waitAfterChoseOrClickElement();
        createSupplierPage.verifySupplierNameExist();
        validateHelpers.waitAfterChoseOrClickElement();
        createSupplierPage.verifyCreate();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }
}
