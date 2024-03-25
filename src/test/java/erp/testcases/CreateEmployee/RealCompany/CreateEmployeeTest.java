package erp.testcases.CreateEmployee.RealCompany;

import erp.base.BaseSetup;
import erp.base.ReportListener;
import erp.common.helpers.GetTypeOfCompanyHelper;
import erp.common.helpers.PropertiesHelper;
import erp.common.helpers.ValidateHelpers;
import erp.pages.CompanyListPage;
import erp.pages.EmployeePage.CreateEmployeesPage;
import erp.pages.SignInPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

@Listeners(ReportListener.class)
public class CreateEmployeeTest extends BaseSetup {
    private WebDriver driver;
    private CreateEmployeesPage createEmployeesPage;
    private ValidateHelpers validateHelpers;
    private SignInPage signInPage;
    private CompanyListPage companyListPage;

    @BeforeClass
    public void setup() {
        this.driver = getDriver();
        createEmployeesPage = new CreateEmployeesPage(driver);
        validateHelpers = new ValidateHelpers(driver);
        signInPage = new SignInPage(driver);
        companyListPage = new CompanyListPage(driver);
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void createEmployeeWithValidInformation_then_createSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        createEmployeesPage.gotoEmployeeTable();
        validateHelpers.waitForLoadJs();
        createEmployeesPage.gotoCreateEmployeePage();
        validateHelpers.waitForLoadJs();
        createEmployeesPage.enterEmployeeName();
        validateHelpers.waitAfterChoseOrClickElement();
        createEmployeesPage.enterPhoneNumberArabic();
        validateHelpers.waitAfterChoseOrClickElement();
        createEmployeesPage.clickOnCreateEmployeeButton();
        validateHelpers.waitForLoadJs();
        createEmployeesPage.verifyAfterCreate();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();

    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void createEmployeeWithConfirmUploadAvatar_then_createSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        createEmployeesPage.gotoEmployeeTable();
        validateHelpers.waitForLoadJs();
        createEmployeesPage.gotoCreateEmployeePage();
        validateHelpers.waitForLoadJs();
        createEmployeesPage.uploadAvatar();
        validateHelpers.waitAfterChoseOrClickElement();
        createEmployeesPage.confirmUploadAvatar();
        validateHelpers.waitAfterChoseOrClickElement();
        createEmployeesPage.enterEmployeeName();
        validateHelpers.waitAfterChoseOrClickElement();
        createEmployeesPage.enterPhoneNumberArabic();
        validateHelpers.waitAfterChoseOrClickElement();
        createEmployeesPage.clickOnCreateEmployeeButton();
        validateHelpers.waitForLoadJs();
        createEmployeesPage.verifyAfterCreate();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void createEmployeeWithCancelUploadAvatar_then_createSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        createEmployeesPage.gotoEmployeeTable();
        validateHelpers.waitForLoadJs();
        createEmployeesPage.gotoCreateEmployeePage();
        validateHelpers.waitForLoadJs();
        createEmployeesPage.uploadAvatar();
        validateHelpers.waitAfterChoseOrClickElement();
        createEmployeesPage.cancelUploadAvatar();
        validateHelpers.waitAfterChoseOrClickElement();
        createEmployeesPage.enterEmployeeName();
        validateHelpers.waitAfterChoseOrClickElement();
        createEmployeesPage.enterPhoneNumberArabic();
        validateHelpers.waitAfterChoseOrClickElement();
        createEmployeesPage.clickOnCreateEmployeeButton();
        validateHelpers.waitForLoadJs();
        createEmployeesPage.verifyAfterCreate();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void createEmployeeWithAddManyPhoneNumber_then_createSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        createEmployeesPage.gotoEmployeeTable();
        validateHelpers.waitForLoadJs();
        createEmployeesPage.gotoCreateEmployeePage();
        validateHelpers.waitForLoadJs();
        createEmployeesPage.enterEmployeeName();
        validateHelpers.waitAfterChoseOrClickElement();
        createEmployeesPage.clickOnAddPhone();
        validateHelpers.waitAfterChoseOrClickElement();
        createEmployeesPage.addPhoneNumbers();
        validateHelpers.waitAfterChoseOrClickElement();
        createEmployeesPage.clickOnCreateEmployeeButton();
        validateHelpers.waitForLoadJs();
        createEmployeesPage.verifyAfterCreate();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void createEmployeeWithEmployeeNameNull_then_createFail(@Optional("English") String language) {
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        createEmployeesPage.gotoEmployeeTable();
        validateHelpers.waitForLoadJs();
        createEmployeesPage.gotoCreateEmployeePage();
        validateHelpers.waitForLoadJsCreatePage();
        createEmployeesPage.checkEmployeeNameRequired();
        validateHelpers.waitAfterChoseOrClickElement();
        createEmployeesPage.clickOnCreateEmployeeButton();
        validateHelpers.waitAfterChoseOrClickElement();
        createEmployeesPage.verifyAfterCreate();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void createEmployeeWithPhoneNumberNull_then_createFail(@Optional("English") String language) {
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        createEmployeesPage.gotoEmployeeTable();
        validateHelpers.waitForLoadJs();
        createEmployeesPage.gotoCreateEmployeePage();
        validateHelpers.waitForLoadJsCreatePage();
        createEmployeesPage.enterEmployeeName();
        validateHelpers.waitAfterChoseOrClickElement();
        createEmployeesPage.clickOnCreateEmployeeButton();
        validateHelpers.waitAfterChoseOrClickElement();
        createEmployeesPage.checkPhoneRequired();
        validateHelpers.waitAfterChoseOrClickElement();
        createEmployeesPage.verifyAfterCreate();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void createEmployeeWithNameAndPhoneNull_then_createFail(@Optional("English") String language) {
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        createEmployeesPage.gotoEmployeeTable();
        validateHelpers.waitForLoadJs();
        createEmployeesPage.gotoCreateEmployeePage();
        validateHelpers.waitForLoadJsCreatePage();
        createEmployeesPage.clickOnCreateEmployeeButton();
        validateHelpers.waitAfterChoseOrClickElement();
        createEmployeesPage.checkNameAndPhoneRequired();
        validateHelpers.waitAfterChoseOrClickElement();
        createEmployeesPage.verifyAfterCreate();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }
}
