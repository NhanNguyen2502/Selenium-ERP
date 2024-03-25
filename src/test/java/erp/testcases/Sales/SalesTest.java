package erp.testcases.Sales;

import erp.base.BaseSetup;
import erp.base.ReportListener;
import erp.common.helpers.PropertiesHelper;
import erp.common.helpers.TranslationHelpers;
import erp.common.helpers.ValidateHelpers;
import erp.pages.CompanyListPage;
import erp.pages.DashBoardPage;
import erp.pages.SalePage.SalePage;
import erp.pages.SignInPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

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
    @Parameters({"language"})
    public void goToCreateSalePageWithRealCompany(@Optional("English") String language) {
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        validateHelpers.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(TranslationHelpers.setFile(language, "$.company.listPage.text.real"));
        validateHelpers.waitForLoadJs();
        salePage = dashBoardPage.goSaleTable();
        validateHelpers.logout();
    }
    @Test(priority = 1)
    @Parameters({"language"})
    public void goToCreateSalePageWithDemoCompany(@Optional("English") String language) {
        validateHelpers.waitForLoadJs();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        validateHelpers.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(TranslationHelpers.setFile(language, "$.company.listPage.text.demo"));
        validateHelpers.waitForLoadJs();
        salePage = dashBoardPage.goSaleTable();
        validateHelpers.logout();
    }
    @Test(priority = 1)
    @Parameters({"language"})
    public void gotoCreateInvoicePageViaShortCutwithDmoCompany(@Optional("English") String language){
        validateHelpers.waitForLoadJs();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"),PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        validateHelpers.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(TranslationHelpers.setFile(language,"$.company.listPage.text.demo"));
        validateHelpers.waitForLoadJs();
        salePage = dashBoardPage.goSaleTable();
        salePage.gtoSaleViaShortCut();
        validateHelpers.logout();
    }

    @Test(priority = 1)
    @Parameters({"language"})
    public void gotoCreateInvoicePageViaShortCutwithRealCompany(@Optional("English") String language){
        validateHelpers.waitForLoadJs();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"),PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        validateHelpers.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(TranslationHelpers.setFile(language,"$.company.listPage.text.real"));
        validateHelpers.waitForLoadJs();
        salePage = dashBoardPage.goSaleTable();
        salePage.gtoSaleViaShortCut();
        validateHelpers.logout();
    }

    @Test(priority = 2)
    @Parameters({"language"})
    public void  verifyElementsOnSaleTable(@Optional("English") String language)
    {
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        validateHelpers.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(TranslationHelpers.setFile(language, "$.company.listPage.text.demo"));
        validateHelpers.waitForLoadJs();
        salePage = dashBoardPage.goSaleTable();
        validateHelpers.waitForLoadJs();
        salePage.verifyElementsOnSaleTable();
        validateHelpers.logout();
    }

}
