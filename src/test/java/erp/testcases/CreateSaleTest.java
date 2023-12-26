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
    public void  verifyTypeAndDateSectionStandard(@Optional("English") String language){
        signInPage.waitForPageLoaded();
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
        createSalePage.checkDateAndTypeSection(TranslationHelpers.setFile(language,"$.regularInvoice.select.option.standard")
                ,TranslationHelpers.setFile(language,"$.regularInvoice.select.option.standard")
                ,TranslationHelpers.setFile(language,"$.regularInvoice.select.option.installment"));
        createSalePage.checkAccountSection();
        validateHelpers.logout();

    }

    @Test(priority = 1)
    @Parameters({"language"})
    public void  verifyTypeAndDateSectionInstallment(@Optional("English") String language){
        signInPage.waitForPageLoaded();
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
        createSalePage.checkDateAndTypeSection(TranslationHelpers.setFile(language,"$.regularInvoice.select.option.installment")
                ,TranslationHelpers.setFile(language,"$.regularInvoice.select.option.standard")
                ,TranslationHelpers.setFile(language,"$.regularInvoice.select.option.installment"));
        createSalePage.checkAccountSection();
        validateHelpers.logout();
    }
    @Test(priority = 1)
    @Parameters({"language"})
    public void  verifyTypeAndDateSectionCashSale(@Optional("English") String language){
        signInPage.waitForPageLoaded();
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
        createSalePage.checkDateAndTypeSection(TranslationHelpers.setFile(language,"$.regularInvoice.select.option.cashSale")
                ,TranslationHelpers.setFile(language,"$.regularInvoice.select.option.standard")
                ,TranslationHelpers.setFile(language,"$.regularInvoice.select.option.installment"));
        createSalePage.checkAccountSection();
        validateHelpers.logout();
    }

}
