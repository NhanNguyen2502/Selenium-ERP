package erp.testcases;

import erp.base.BaseSetup;
import erp.base.ReportListener;
import erp.common.helpers.PropertiesHelper;
import erp.common.helpers.TranslationHelpers;
import erp.common.helpers.ValidateHelpers;
import erp.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

@Listeners(ReportListener.class)
public class CreateSaleTest extends BaseSetup {
    private  WebDriver driver;
    private ValidateHelpers validateHelpers;
    private SignInPage signInPage;
    private CreateSalePage createSalePage;
    private DashBoardPage dashBoardPage;
    private CompanyListPage companyListPage;
    private SalePage salePage;

    @BeforeClass
    public void setUp(){
        this.driver = getDriver();
        validateHelpers = new ValidateHelpers(driver);
        signInPage = new SignInPage(driver);
        createSalePage = new CreateSalePage(driver);
        dashBoardPage = new DashBoardPage(driver);
    }

    @Test(priority = 1)
    @Parameters({"language"})
    public void  checkinformationpage(@Optional("English") String language){
        signInPage.verifylanguage(language);
        companyListPage =  signInPage.login(PropertiesHelper.getValue("email"),PropertiesHelper.getValue("password"));
        validateHelpers.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(TranslationHelpers.setFile(language,"$.company.listPage.text.demo"));
        validateHelpers.waitForLoadJs();
        salePage = dashBoardPage.goSaleTable();
        validateHelpers.waitForLoadJs();
        salePage.gtoSaleViaShortCut();
        validateHelpers.waitForLoadJs();
        createSalePage.checkDateandtypeSection(TranslationHelpers.setFile(language,"$.invoicesCommon.chip.standard")
                ,TranslationHelpers.setFile(language,"$.invoicesCommon.chip.installment"));
        validateHelpers.logout();

    }

}
