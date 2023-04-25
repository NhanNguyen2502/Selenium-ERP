package erp.testcases;

import erp.base.BaseSetup;
import erp.common.helpers.ExcelHelper;
import erp.common.helpers.PropertiesHelper;
import erp.common.helpers.TranslationHelpers;
import erp.common.helpers.ValidateHelper;
import erp.pages.CompanyListPage;
import erp.pages.SignInPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CompanyListTest extends BaseSetup {
    private WebDriver driver;
    public SignInPage signInPage;
    public CompanyListPage companyListPage;
    private ExcelHelper excelHelper;
    private ValidateHelper validateHelper;

    @BeforeClass
    public void setUp() {
        this.driver = getDriver();
        signInPage = new SignInPage(driver);
        excelHelper = new ExcelHelper();
        validateHelper = new ValidateHelper(driver);
        PropertiesHelper.loadAllFile();
        signInPage.verifylanguage(validateHelper.getLanguageToTest());
        companyListPage = signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
    }

    @Test(priority = 1)
    public void login() throws Exception {
        ((JavascriptExecutor) driver).executeScript("localStorage.clear");
        excelHelper.setExcelFile("src/test/java/resources/Book1.xlsx", "Sheet1");

    }

    @Test(priority = 2)
    public void verifyElements() throws Exception {
        Thread.sleep(2000);
        companyListPage.waitForPageLoaded();
        companyListPage.verifylanguage(validateHelper.getLanguageToTest());
        companyListPage.verifySelectCompanyonLeftMenu();
        companyListPage.verifyHeader();
        Assert.assertTrue(companyListPage.verifyBodyOfPage(TranslationHelpers.setFile(validateHelper.getLanguageToTest(), "$.general.pageTitle.companies"),
                TranslationHelpers.setFile(validateHelper.getLanguageToTest(), "$.header.breadcrumb.companyList"),
                TranslationHelpers.setFile(validateHelper.getLanguageToTest(), "$.pagination.inputField.rowsPerPage") + ":"), "False");
    }


}
