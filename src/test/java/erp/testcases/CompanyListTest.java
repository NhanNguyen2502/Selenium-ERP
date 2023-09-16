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
    }

//    @Test(priority = 1)
//    public void login() throws Exception {
//        ((JavascriptExecutor) driver).executeScript("localStorage.clear");
//        excelHelper.setExcelFile("src/test/java/resources/Book1.xlsx", "Sheet1");
//
//    }

    @Test(priority = 1)
    public void verifyElements() throws Exception {
        validateHelpers.waitForLoadJs();
        signInPage.verifylanguage(PropertiesHelper.getLanguageToTest());
        companyListPage = signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        validateHelpers.verifylanguage(PropertiesHelper.getLanguageToTest());
        validateHelpers.waitForLoadJs();
        companyListPage.gotoCompnyList();
        companyListPage.verifyHeader();
        companyListPage.verifyBodyOfPage(TranslationHelpers.setFile(PropertiesHelper.getLanguageToTest(), "$.general.pageTitle.companies"),
                TranslationHelpers.setFile(PropertiesHelper.getLanguageToTest(), "$.company.listPage.title"),
                TranslationHelpers.setFile(PropertiesHelper.getLanguageToTest(), "$.pagination.inputField.rowsPerPage"));
        validateHelpers.logout();
    }

    @Test(priority = 2)
    public void verifyCompanyListNull() {
        signInPage.waitForPageLoaded();
        signInPage.verifylanguage(PropertiesHelper.getLanguageToTest());
        companyListPage = signInPage.login(PropertiesHelper.getValue("notCompanyEmail"), PropertiesHelper.getValue("password"));
        companyListPage.verifylanguage(PropertiesHelper.getLanguageToTest());
        companyListPage.waitForPageLoaded();
        companyListPage.gotoCompnyList();
        companyListPage.checkCompaniesList();
        validateHelpers.logout();
    }

    @Test(priority = 2)
    public void verifyCompanyListNotNull() {
        signInPage.waitForPageLoaded();
        signInPage.verifylanguage(PropertiesHelper.getLanguageToTest());
        companyListPage = signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        companyListPage.verifylanguage(PropertiesHelper.getLanguageToTest());
        companyListPage.waitForPageLoaded();
        companyListPage.gotoCompnyList();
        companyListPage.checkCompaniesList();
        companyListPage.checkTypeOfCompany(
                TranslationHelpers.setFile(PropertiesHelper.getLanguageToTest(), "$.company.listPage.text.real"));
        companyListPage.checkMoreOptions(
                TranslationHelpers.setFile(PropertiesHelper.getLanguageToTest(), "$.company.listPage.button.edit"),
                TranslationHelpers.setFile(PropertiesHelper.getLanguageToTest(), "$.company.listPage.button.delete")
        );
        validateHelpers.logout();

    }

    @Test(priority = 3)
    public void verifyGoToEditRealCompanyPage() {
        signInPage.waitForPageLoaded();
        signInPage.verifylanguage(PropertiesHelper.getLanguageToTest());
        companyListPage = signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        companyListPage.verifylanguage(PropertiesHelper.getLanguageToTest());
        companyListPage.waitForPageLoaded();
        companyListPage.gotoCompnyList();
        companyListPage.goToEditPage(TranslationHelpers.setFile(PropertiesHelper.getLanguageToTest(), "$.company.listPage.text.real"));
        validateHelpers.logout();
    }

    @Test(priority = 3)
    public void verifyGoToEditDemoCompanyPage() {
        signInPage.waitForPageLoaded();
        signInPage.verifylanguage(PropertiesHelper.getLanguageToTest());
        companyListPage = signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        companyListPage.verifylanguage(PropertiesHelper.getLanguageToTest());
        companyListPage.waitForPageLoaded();
        companyListPage.gotoCompnyList();
        companyListPage.goToEditPage(TranslationHelpers.setFile(PropertiesHelper.getLanguageToTest(), "$.company.listPage.text.demo"));
        validateHelpers.logout();
    }

    @Test(priority = 4)
    public void verifyDeleteDemoCompany() {
        signInPage.waitForPageLoaded();
        signInPage.verifylanguage(PropertiesHelper.getLanguageToTest());
        companyListPage = signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        companyListPage.verifylanguage(PropertiesHelper.getLanguageToTest());
        companyListPage.waitForPageLoaded();
        companyListPage.gotoCompnyList();
        companyListPage.deleteCompany(TranslationHelpers.setFile(PropertiesHelper.getLanguageToTest(), "$.company.listPage.text.demo"),
                TranslationHelpers.setFile(PropertiesHelper.getLanguageToTest(), "$.company.dialog.deleteCompany.title"),
                TranslationHelpers.setFile(PropertiesHelper.getLanguageToTest(), "$.company.dialog.deleteDemoCompany.confirmMessage"));
        validateHelpers.logout();
    }
    @Test(priority = 4)
    public void verifyDeleteRealCompany() {
        signInPage.waitForPageLoaded();
        signInPage.verifylanguage(PropertiesHelper.getLanguageToTest());
        companyListPage = signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        companyListPage.verifylanguage(PropertiesHelper.getLanguageToTest());
        companyListPage.waitForPageLoaded();
        companyListPage.gotoCompnyList();
        companyListPage.deleteCompany(TranslationHelpers.setFile(PropertiesHelper.getLanguageToTest(), "$.company.listPage.text.real"),
                TranslationHelpers.setFile(PropertiesHelper.getLanguageToTest(), "$.company.dialog.deleteCompany.title"),
                TranslationHelpers.setFile(PropertiesHelper.getLanguageToTest(), "$.company.dialog.deleteRealCompany.confirmMessage"));
        validateHelpers.logout();
    }


}
