package erp.testcases.UpdateEmployee.RealCompany;

import erp.base.BaseSetup;
import erp.base.ReportListener;
import erp.common.helpers.GetTypeOfCompanyHelper;
import erp.common.helpers.PropertiesHelper;
import erp.common.helpers.ValidateHelpers;
import erp.pages.CompanyListPage;
import erp.pages.EmployeePage.EmployeeTable;
import erp.pages.EmployeePage.UpdateEmployeePage;
import erp.pages.SignInPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

@Listeners(ReportListener.class)
public class UpdateEmployeeTest extends BaseSetup {
    private WebDriver driver;
    private UpdateEmployeePage updateEmployeePage;
    private ValidateHelpers validateHelpers;
    private SignInPage signInPage;
    private CompanyListPage companyListPage;
    private EmployeeTable employeeTable;

    @BeforeClass
    public void setup() {
        this.driver = getDriver();
        updateEmployeePage = new UpdateEmployeePage(driver);
        signInPage = new SignInPage(driver);
        companyListPage = new CompanyListPage(driver);
        validateHelpers = new ValidateHelpers(driver);
        employeeTable = new EmployeeTable(driver);
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void updateEmployeeName_then_updateSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        validateHelpers.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        updateEmployeePage.gotoEmployeeTable();
        validateHelpers.waitForLoadJs();
        updateEmployeePage.selectEmployeeToUpdate();
        validateHelpers.waitForLoadJsCreatePage();
        updateEmployeePage.updateEmployeeName();
        validateHelpers.waitAfterChoseOrClickElement();
        updateEmployeePage.clickOnSaveEmployeeButton();
        validateHelpers.waitForLoadJs();
        updateEmployeePage.verifyUpdateSuccess();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();

    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void updateEmployeePhone_then_updateSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        validateHelpers.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        updateEmployeePage.gotoEmployeeTable();
        validateHelpers.waitForLoadJs();
        updateEmployeePage.selectEmployeeToUpdate();
        validateHelpers.waitForLoadJsCreatePage();
        updateEmployeePage.updatePhoneNumberArabic();
        validateHelpers.waitAfterChoseOrClickElement();
        updateEmployeePage.clickOnSaveEmployeeButton();
        validateHelpers.waitForLoadJs();
        updateEmployeePage.verifyUpdateSuccess();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void updateEmployeeNameAndPhone_then_updateSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        validateHelpers.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        updateEmployeePage.gotoEmployeeTable();
        validateHelpers.waitForLoadJs();
        updateEmployeePage.selectEmployeeToUpdate();
        validateHelpers.waitForLoadJsCreatePage();
        updateEmployeePage.updateEmployeeName();
        validateHelpers.waitAfterChoseOrClickElement();
        updateEmployeePage.updatePhoneNumberArabic();
        validateHelpers.waitAfterChoseOrClickElement();
        updateEmployeePage.clickOnSaveEmployeeButton();
        validateHelpers.waitForLoadJs();
        updateEmployeePage.verifyUpdateSuccess();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void updateEmployeeDisable_then_updateSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        validateHelpers.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        updateEmployeePage.gotoEmployeeTable();
        validateHelpers.waitForLoadJs();
        employeeTable.filterEnable();
        validateHelpers.waitForLoadJs();
        updateEmployeePage.selectEmployeeToUpdate();
        validateHelpers.waitForLoadJsCreatePage();
        updateEmployeePage.disableEmployee();
        validateHelpers.waitAfterChoseOrClickElement();
        updateEmployeePage.confirmDisableEmployee();
        validateHelpers.waitAfterChoseOrClickElement();
        updateEmployeePage.clickOnSaveEmployeeButton();
        validateHelpers.waitForLoadJs();
        updateEmployeePage.verifyUpdateSuccess();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void updateEmployeeCancelDisable_then_updateSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        validateHelpers.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        updateEmployeePage.gotoEmployeeTable();
        validateHelpers.waitForLoadJs();
        employeeTable.filterEnable();
        validateHelpers.waitForLoadJs();
        updateEmployeePage.selectEmployeeToUpdate();
        validateHelpers.waitForLoadJsCreatePage();
        updateEmployeePage.disableEmployee();
        validateHelpers.waitAfterChoseOrClickElement();
        updateEmployeePage.cancelDisableEmployee();
        validateHelpers.waitAfterChoseOrClickElement();
        updateEmployeePage.clickOnSaveEmployeeButton();
        validateHelpers.waitForLoadJs();
        updateEmployeePage.verifyUpdateSuccess();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

    @Test(priority = 2)
    @Parameters({"language"})
    public void updateEmployeeEnable_then_updateSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        validateHelpers.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        updateEmployeePage.gotoEmployeeTable();
        validateHelpers.waitForLoadJs();
        employeeTable.filterDisabled();
        validateHelpers.waitForLoadJs();
        updateEmployeePage.selectEmployeeToUpdate();
        validateHelpers.waitForLoadJsCreatePage();
        updateEmployeePage.enableEmployee();
        validateHelpers.waitAfterChoseOrClickElement();
        updateEmployeePage.confirmEnableEmployee();
        validateHelpers.waitAfterChoseOrClickElement();
        updateEmployeePage.clickOnSaveEmployeeButton();
        validateHelpers.waitForLoadJs();
        updateEmployeePage.verifyUpdateSuccess();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

    @Test(priority = 2)
    @Parameters({"language"})
    public void updateEmployeeCancelEnable_then_updateSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        validateHelpers.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        updateEmployeePage.gotoEmployeeTable();
        validateHelpers.waitForLoadJs();
        employeeTable.filterDisabled();
        validateHelpers.waitForLoadJs();
        updateEmployeePage.selectEmployeeToUpdate();
        validateHelpers.waitForLoadJsCreatePage();
        updateEmployeePage.enableEmployee();
        validateHelpers.waitAfterChoseOrClickElement();
        updateEmployeePage.cancelEnableEmployee();
        validateHelpers.waitAfterChoseOrClickElement();
        updateEmployeePage.clickOnSaveEmployeeButton();
        validateHelpers.waitForLoadJs();
        updateEmployeePage.verifyUpdateSuccess();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }
    @Test(priority = 0)
    @Parameters({"language"})
    public void updateEmployeeAddManyPhone_then_updateSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        validateHelpers.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        updateEmployeePage.gotoEmployeeTable();
        validateHelpers.waitForLoadJs();
        updateEmployeePage.selectEmployeeToUpdate();
        validateHelpers.waitForLoadJsCreatePage();
        updateEmployeePage.addManyPhone();
        validateHelpers.waitAfterChoseOrClickElement();
        updateEmployeePage.changeAllDialCodeToArabicDialCode();
        validateHelpers.waitAfterChoseOrClickElement();
        updateEmployeePage.enterArabicPhoneAllLines();
        validateHelpers.waitAfterChoseOrClickElement();
        updateEmployeePage.clickOnSaveEmployeeButton();
        validateHelpers.waitForLoadJs();
        updateEmployeePage.verifyUpdateSuccess();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void updateEmployeeDelete_then_updateSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        validateHelpers.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        updateEmployeePage.gotoEmployeeTable();
        validateHelpers.waitForLoadJs();
        updateEmployeePage.selectEmployeeToUpdate();
        validateHelpers.waitForLoadJsCreatePage();
        updateEmployeePage.deleteEmployee();
        validateHelpers.waitAfterChoseOrClickElement();
        updateEmployeePage.confirmDeleteButton();
        validateHelpers.waitForLoadJs();
        updateEmployeePage.verifyUpdateSuccess();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

}
