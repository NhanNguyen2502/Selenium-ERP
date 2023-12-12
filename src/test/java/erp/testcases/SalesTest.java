package erp.testcases;

import erp.base.BaseSetup;
import erp.base.ReportListener;
import erp.common.helpers.PropertiesHelper;
import erp.common.helpers.TranslationHelpers;
import erp.common.helpers.ValidateHelpers;
import erp.pages.CompanyListPage;
import erp.pages.DashBoardPage;
import erp.pages.SalePage;
import erp.pages.SignInPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ulitilities.Log;

//@Listeners(TestListener.class)
@Listeners(ReportListener.class)
public class SalesTest extends BaseSetup {
  private static final Logger logger = Logger.getLogger(SalesTest.class);
    private DashBoardPage dashBoardPage;
    private WebDriver driver;
    private SignInPage signInPage;
    private CompanyListPage companyListPage;
    private ValidateHelpers validateHelpers;
    private SalePage salePage;


    @BeforeClass
    public void setup() {
        this.driver = getDriver();
        dashBoardPage = new DashBoardPage(driver);
        signInPage = new SignInPage(driver);
        companyListPage = new CompanyListPage(driver);
        validateHelpers = new ValidateHelpers(driver);
    }

    @Test(priority = 1)
    public void goToCreateSalePageWithRealCompany() {
        signInPage.verifylanguage(PropertiesHelper.getLanguageToTest());
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        validateHelpers.verifylanguage(PropertiesHelper.getLanguageToTest());
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(TranslationHelpers.setFile(PropertiesHelper.getLanguageToTest(), "$.company.listPage.text.real"));
        validateHelpers.waitForLoadJs();
        salePage = dashBoardPage.goSaleTable();
    }
    @Test(priority = 1)
    public void goToCreateSalePageWithDemoCompany() {
        signInPage.verifylanguage(PropertiesHelper.getLanguageToTest());
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        validateHelpers.verifylanguage(PropertiesHelper.getLanguageToTest());
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(TranslationHelpers.setFile(PropertiesHelper.getLanguageToTest(), "$.company.listPage.text.demo"));
        validateHelpers.waitForLoadJs();
        salePage = dashBoardPage.goSaleTable();
    }

}
