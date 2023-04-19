package erp.testcases;

import erp.base.BaseSetup;
import erp.common.helpers.ExcelHelper;
import erp.common.helpers.PropertiesHelper;
import erp.pages.CompanyListPage;
import erp.pages.SignInPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CompanyListTest extends BaseSetup {
    private WebDriver driver;
    public SignInPage signInPage;
    public CompanyListPage companyListPage;
    private ExcelHelper excelHelper;

    @BeforeClass
    public void setUp() {
        this.driver = getDriver();
        signInPage = new SignInPage(driver);
        excelHelper = new ExcelHelper();
        PropertiesHelper.loadAllFile();
    }

    @Test(priority = 1)
    public void login() throws  Exception {
        ((JavascriptExecutor) driver).executeScript("localStorage.clear");
        excelHelper.setExcelFile("src/test/java/resources/Book1.xlsx","Sheet1");
        companyListPage = signInPage.login(PropertiesHelper.getValue("email"),PropertiesHelper.getValue("password"));
    }

    @Test(priority = 2)
    public void verifyElements() {
        companyListPage.waitForPageLoaded();
        companyListPage.verifySelectCompanyonLeftMenu();
        companyListPage.verifyHeader();
        companyListPage.verifyBodyOfPage();
    }



}
