package erp.testcases.UpdateCustomer.RealCompany;

import erp.base.BaseSetup;
import erp.base.ReportListener;
import erp.common.helpers.GetTypeOfCompanyHelper;
import erp.common.helpers.PropertiesHelper;
import erp.common.helpers.ValidateHelpers;
import erp.pages.CompanyListPage;
import erp.pages.Customer.CreateCustomerPage;
import erp.pages.Customer.CustomerTable;
import erp.pages.Customer.UpdateCustomerPage;
import erp.pages.SignInPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

@Listeners(ReportListener.class)
public class UpdateCustomerTest extends BaseSetup {
    private WebDriver driver;
    private ValidateHelpers validateHelpers;
    private SignInPage signInPage;
    private CompanyListPage companyListPage;
    private CustomerTable customerTable;
    private UpdateCustomerPage updateCustomerPage;


    @BeforeClass
    public void setUp() {
        this.driver = getDriver();
        validateHelpers = new ValidateHelpers(driver);
        signInPage = new SignInPage(driver);
        companyListPage = new CompanyListPage(driver);
        customerTable = new CustomerTable(driver);
        updateCustomerPage = new UpdateCustomerPage(driver);
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void updateCustomerName_then_updateSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        validateHelpers.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        updateCustomerPage.goToTheCustomerTable();
        validateHelpers.waitForLoadJs();
        updateCustomerPage.selectCustomerToUpdate();
        validateHelpers.waitForLoadJsCreatePage();
        updateCustomerPage.editCustomerName();
        validateHelpers.waitAfterChoseOrClickElement();
        updateCustomerPage.clickOnSaveButton();
        validateHelpers.waitForLoadJs();
        updateCustomerPage.verifyUpdateSuccess();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void updateDeleteCustomerAvatar_then_updateSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        validateHelpers.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        updateCustomerPage.goToTheCustomerTable();
        validateHelpers.waitForLoadJs();
        updateCustomerPage.selectCustomerToUpdate();
        validateHelpers.waitForLoadJsCreatePage();
        updateCustomerPage.deleteAvatar();
        validateHelpers.waitAfterChoseOrClickElement();
        updateCustomerPage.confirmDeleteAvatar();
        validateHelpers.waitAfterChoseOrClickElement();
        updateCustomerPage.clickOnSaveButton();
        validateHelpers.waitForLoadJs();
        updateCustomerPage.verifyUpdateSuccess();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void updateDeleteCustomerDisable_then_updateSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        validateHelpers.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        updateCustomerPage.goToTheCustomerTable();
        validateHelpers.waitForLoadJs();
        customerTable.filterEnable();
        validateHelpers.waitForLoadJs();
        updateCustomerPage.selectCustomerToUpdate();
        validateHelpers.waitForLoadJsCreatePage();
        updateCustomerPage.disableCustomer();
        validateHelpers.waitAfterChoseOrClickElement();
        updateCustomerPage.confirmDisableCustomer();
        validateHelpers.waitAfterChoseOrClickElement();
        updateCustomerPage.clickOnSaveButton();
        validateHelpers.waitForLoadJs();
        updateCustomerPage.verifyUpdateSuccess();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

    @Test(priority = 1)
    @Parameters({"language"})
    public void updateDeleteCustomerEnable_then_updateSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        validateHelpers.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        updateCustomerPage.goToTheCustomerTable();
        validateHelpers.waitForLoadJs();
        customerTable.filterDisabled();
        validateHelpers.waitForLoadJs();
        updateCustomerPage.selectCustomerToUpdate();
        validateHelpers.waitForLoadJsCreatePage();
        updateCustomerPage.enableCustomer();
        validateHelpers.waitAfterChoseOrClickElement();
        updateCustomerPage.confirmEnableCustomer();
        validateHelpers.waitAfterChoseOrClickElement();
        updateCustomerPage.clickOnSaveButton();
        validateHelpers.waitForLoadJs();
        updateCustomerPage.verifyUpdateSuccess();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void updateCustomerLanguage_then_updateSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        validateHelpers.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        updateCustomerPage.goToTheCustomerTable();
        validateHelpers.waitForLoadJs();
        updateCustomerPage.selectCustomerToUpdate();
        validateHelpers.waitForLoadJsCreatePage();
        updateCustomerPage.updateAnotherLanguage();
        validateHelpers.waitAfterChoseOrClickElement();
        updateCustomerPage.clickOnSaveButton();
        validateHelpers.waitForLoadJs();
        updateCustomerPage.verifyUpdateSuccess();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void updateCustomerCurrency_then_updateSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        validateHelpers.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        updateCustomerPage.goToTheCustomerTable();
        validateHelpers.waitForLoadJs();
        updateCustomerPage.selectCustomerToUpdate();
        validateHelpers.waitForLoadJsCreatePage();
        updateCustomerPage.updateAnotherCurrency();
        validateHelpers.waitAfterChoseOrClickElement();
        updateCustomerPage.clickOnSaveButton();
        validateHelpers.waitForLoadJs();
        updateCustomerPage.verifyUpdateSuccess();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void updateCustomerGroup_then_updateSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        validateHelpers.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        updateCustomerPage.goToTheCustomerTable();
        validateHelpers.waitForLoadJs();
        updateCustomerPage.selectCustomerToUpdate();
        validateHelpers.waitForLoadJsCreatePage();
        updateCustomerPage.updatetGroupAlreadyExist();
        validateHelpers.waitAfterChoseOrClickElement();
        updateCustomerPage.clickOnSaveButton();
        validateHelpers.waitForLoadJs();
        updateCustomerPage.verifyUpdateSuccess();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void updateCustomerUpdateDiscount_then_updateSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        validateHelpers.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        updateCustomerPage.goToTheCustomerTable();
        validateHelpers.waitForLoadJs();
        updateCustomerPage.selectCustomerToUpdate();
        validateHelpers.waitForLoadJsCreatePage();
        updateCustomerPage.updateDiscount();
        validateHelpers.waitAfterChoseOrClickElement();
        updateCustomerPage.clickOnSaveButton();
        validateHelpers.waitForLoadJs();
        updateCustomerPage.verifyUpdateSuccess();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void updateCustomerUpdateMail_then_updateSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        validateHelpers.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        updateCustomerPage.goToTheCustomerTable();
        validateHelpers.waitForLoadJs();
        updateCustomerPage.selectCustomerToUpdate();
        validateHelpers.waitForLoadJsCreatePage();
        updateCustomerPage.updateEmail();
        validateHelpers.waitAfterChoseOrClickElement();
        updateCustomerPage.clickOnSaveButton();
        validateHelpers.waitForLoadJs();
        updateCustomerPage.verifyUpdateSuccess();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void updateCustomerUpdatePhone_then_updateSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        validateHelpers.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        updateCustomerPage.goToTheCustomerTable();
        validateHelpers.waitForLoadJs();
        updateCustomerPage.selectCustomerToUpdate();
        validateHelpers.waitForLoadJsCreatePage();
        updateCustomerPage.updatePhoneNumberArabic();
        validateHelpers.waitAfterChoseOrClickElement();
        updateCustomerPage.clickOnSaveButton();
        validateHelpers.waitForLoadJs();
        updateCustomerPage.verifyUpdateSuccess();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void updateCustomerUpdatePhone_then_updateFailed(@Optional("English") String language) {
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        validateHelpers.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        updateCustomerPage.goToTheCustomerTable();
        validateHelpers.waitForLoadJs();
        updateCustomerPage.selectCustomerToUpdate();
        validateHelpers.waitForLoadJsCreatePage();
        updateCustomerPage.updatePhoneNumberArabic();
        validateHelpers.waitAfterChoseOrClickElement();
        updateCustomerPage.clickOnSaveButton();
        validateHelpers.waitForLoadJs();
        updateCustomerPage.verifyUpdateSuccess();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

    //    @Test(priority = 0)
//    @Parameters({"language"})
//    public void updateCustomerNameNull_then_updateFailed(@Optional("English") String language) {
//        validateHelpers.waitForLoadJsLoginPage();
//        signInPage.verifylanguage(language);
//        validateHelpers.waitForLoadJs();
//        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
//        validateHelpers.waitForLoadJs();
//        validateHelpers.verifylanguage(language);
//        validateHelpers.waitForLoadJs();
//        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
//        validateHelpers.waitForLoadJs();
//        updateCustomerPage.goToTheCustomerTable();
//        validateHelpers.waitForLoadJs();
//        updateCustomerPage.selectCustomerToUpdate();
//        validateHelpers.waitForLoadJsCreatePage();
//        updateCustomerPage.updateCustomerNameNull();
//        validateHelpers.waitAfterChoseOrClickElement();
//        updateCustomerPage.clickOnSaveButton();
//        validateHelpers.waitAfterChoseOrClickElement();
//        updateCustomerPage.checkCustomerNameNull();
//        validateHelpers.waitForLoadJs();
//        updateCustomerPage.verifyUpdateFailed();
//        validateHelpers.waitAfterChoseOrClickElement();
//        validateHelpers.logout();
//    }
    @Test(priority = 0)
    @Parameters({"language"})
    public void updateCustomerConfirmDelete_then_deleteSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        validateHelpers.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        updateCustomerPage.goToTheCustomerTable();
        validateHelpers.waitForLoadJs();
        updateCustomerPage.selectCustomerToUpdate();
        validateHelpers.waitForLoadJsCreatePage();
        updateCustomerPage.deleteCustomer();
        validateHelpers.waitAfterChoseOrClickElement();
        updateCustomerPage.confirmDelete();
        validateHelpers.waitForLoadJs();
        updateCustomerPage.verifyDeleteSuccess();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }
    @Test(priority = 0)
    @Parameters({"language"})
    public void updateCustomerCancelDelete_then_deleteFailed(@Optional("English") String language) {
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        validateHelpers.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        updateCustomerPage.goToTheCustomerTable();
        validateHelpers.waitForLoadJs();
        updateCustomerPage.selectCustomerToUpdate();
        validateHelpers.waitForLoadJsCreatePage();
        updateCustomerPage.deleteCustomer();
        validateHelpers.waitAfterChoseOrClickElement();
        updateCustomerPage.cancelDelete();
        validateHelpers.waitForLoadJs();
        updateCustomerPage.verifyDeleteFailed();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }
}
