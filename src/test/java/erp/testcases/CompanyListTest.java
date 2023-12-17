package erp.testcases;

import erp.base.BaseSetup;
import erp.common.helpers.ExcelHelper;
import erp.common.helpers.PropertiesHelper;
import erp.common.helpers.TranslationHelpers;
import erp.common.helpers.ValidateHelpers;
import erp.pages.CompanyListPage;
import erp.pages.SignInPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CompanyListTest extends BaseSetup {
    private WebDriver driver;
    public SignInPage signInPage;
    public CompanyListPage companyListPage;
    private ExcelHelper excelHelper;
    private ValidateHelpers validateHelpers;

    @BeforeClass
    public void setUp() {
        this.driver = getDriver();
        signInPage = new SignInPage(driver);
        excelHelper = new ExcelHelper();
        validateHelpers = new ValidateHelpers(driver);
        PropertiesHelper.loadAllFile();
    }

//    @Test(priority = 1)
//    public void login() throws Exception {
//        ((JavascriptExecutor) driver).executeScript("localStorage.clear");
//        excelHelper.setExcelFile("src/test/java/resources/Book1.xlsx", "Sheet1");
//
//    }

    @Test(priority = 1)
    @Parameters({"language"})
    public void verifyElements(@Optional("English") String language) throws Exception {
        validateHelpers.waitForLoadJs();
        signInPage.verifylanguage(language);
        companyListPage = signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        validateHelpers.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        companyListPage.gotoCompnyList();
        companyListPage.verifyHeader();
        companyListPage.verifyBodyOfPage(TranslationHelpers.setFile(language, "$.general.pageTitle.companies"),
                TranslationHelpers.setFile(language, "$.company.listPage.title"),
                TranslationHelpers.setFile(language, "$.pagination.inputField.rowsPerPage"));
        validateHelpers.logout();
    }

    @Test(priority = 2)
    @Parameters({"language"})
    public void verifyCompanyListNull(@Optional("English") String language) {
        signInPage.waitForPageLoaded();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        companyListPage = signInPage.login(PropertiesHelper.getValue("notCompanyEmail"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        validateHelpers.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        companyListPage.gotoCompnyList();
        companyListPage.checkCompaniesList();
        validateHelpers.logout();
    }

    @Test(priority = 2)
    @Parameters({"language"})
    public void verifyCompanyListNotNull(@Optional("English") String language) {
        signInPage.waitForPageLoaded();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        companyListPage = signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        validateHelpers.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        companyListPage.gotoCompnyList();
        companyListPage.checkCompaniesList();
        companyListPage.checkTypeOfCompany(
                TranslationHelpers.setFile(language, "$.company.listPage.text.real"));
        companyListPage.checkMoreOptions(
                TranslationHelpers.setFile(language, "$.company.listPage.button.edit"),
                TranslationHelpers.setFile(language, "$.company.listPage.button.delete")
        );
        validateHelpers.logout();

    }

    @Test(priority = 3)
    @Parameters({"language"})
    public void verifyGoToEditRealCompanyPage(@Optional("English") String language) {
        signInPage.waitForPageLoaded();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        companyListPage = signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        validateHelpers.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        companyListPage.gotoCompnyList();
        companyListPage.goToEditPage(TranslationHelpers.setFile(language, "$.company.listPage.text.real"));
        validateHelpers.waitForLoadJs();
        validateHelpers.logout();
    }

    @Test(priority = 3)
    @Parameters({"language"})
    public void verifyGoToEditDemoCompanyPage(@Optional("English") String language) {
        signInPage.waitForPageLoaded();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        companyListPage = signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        validateHelpers.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        companyListPage.gotoCompnyList();
        companyListPage.goToEditPage(TranslationHelpers.setFile(language, "$.company.listPage.text.demo"));
        validateHelpers.waitForLoadJs();
        validateHelpers.logout();
    }

    @Test(priority = 4)
    @Parameters({"language"})
    public void verifyDeleteDemoCompany(@Optional("English") String language) {
        signInPage.waitForPageLoaded();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        companyListPage = signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        validateHelpers.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        companyListPage.gotoCompnyList();
        companyListPage.deleteCompany(TranslationHelpers.setFile(language, "$.company.listPage.text.demo"),
                TranslationHelpers.setFile(language, "$.company.dialog.deleteCompany.title"),
                TranslationHelpers.setFile(language, "$.company.dialog.deleteDemoCompany.confirmMessage"));
        validateHelpers.waitForLoadJs();
        validateHelpers.logout();
    }
    @Test(priority = 4)
    @Parameters({"language"})
    public void verifyDeleteRealCompany(@Optional("English") String language) {
        signInPage.waitForPageLoaded();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        companyListPage = signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        companyListPage.gotoCompnyList();
        companyListPage.deleteCompany(TranslationHelpers.setFile(language, "$.company.listPage.text.real"),
                TranslationHelpers.setFile(language, "$.company.dialog.deleteCompany.title"),
                TranslationHelpers.setFile(language, "$.company.dialog.deleteRealCompany.confirmMessage"));
        validateHelpers.waitForLoadJs();
        validateHelpers.logout();
    }


}
