package erp.testcases.CreateSale;

import erp.base.BaseSetup;
import erp.base.ReportListener;
import erp.common.helpers.GetKeyOfSaleTypeByLanguageHelpers;
import erp.common.helpers.PropertiesHelper;
import erp.common.helpers.TranslationHelpers;
import erp.common.helpers.ValidateHelpers;
import erp.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(ReportListener.class)
public class CreateSaleTest extends BaseSetup {
    private WebDriver driver;
    private ValidateHelpers validateHelpers;
    private SignInPage signInPage;
    private CreateSalePage createSalePage;
    private DashBoardPage dashBoardPage;
    private CompanyListPage companyListPage;
    private SalePage salePage;


    @BeforeClass
    public void setUp() {
        this.driver = getDriver();
        validateHelpers = new ValidateHelpers(driver);
        signInPage = new SignInPage(driver);
        createSalePage = new CreateSalePage(driver);
        dashBoardPage = new DashBoardPage(driver);
        companyListPage = new CompanyListPage(driver);
        salePage = new SalePage(driver);
    }


    @Test(priority = 1)
    @Parameters({"language"})
    public void verifyStandardInvoiceDemo(@Optional("English") String language) {
        signInPage.waitForPageLoaded();
        signInPage.verifylanguage(language);
        companyListPage = signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(TranslationHelpers.setFile(language, "$.company.listPage.text.demo"));
        validateHelpers.waitForLoadJs();
        salePage = dashBoardPage.goSaleTable();
        validateHelpers.waitForLoadJs();
        salePage.gtoSaleViaShortCut();
        validateHelpers.waitForLoadJs();
        createSalePage.checkDateAndTypeSection(TranslationHelpers.setFile(language, "$.regularInvoice.select.option.standard")
                , TranslationHelpers.setFile(language, "$.regularInvoice.select.option.standard")
                , TranslationHelpers.setFile(language, "$.regularInvoice.select.option.installment"));
        createSalePage.checkAccountSection();
        createSalePage.checkCustomerSection();
        createSalePage.checkProductionSection( language);
        createSalePage.checkFeeSection();
        createSalePage.selectAccountNumber();
        validateHelpers.waitForLoadJs();
        createSalePage.selectEmployee(TranslationHelpers.setFile(language, "$.phoneNumber.error.phoneInvalid"));
        validateHelpers.waitForLoadJs();
        createSalePage.selectCustomer(TranslationHelpers.setFile(language, "$.invoicesCommon.dialog.createEditContact.text.language"));
        validateHelpers.waitForLoadJs();
        createSalePage.selectProduct();
        validateHelpers.waitForLoadJs();
        createSalePage.selectFee();
        validateHelpers.waitForLoadJs();
        createSalePage.clickCreateButton();
        validateHelpers.waitForLoadJs();
        validateHelpers.logout();

    }

    @Test(priority = 1)
    @Parameters({"language"})
    public void verifyStandardInvoiceReal(@Optional("English") String language) {
        signInPage.waitForPageLoaded();
        signInPage.verifylanguage(language);
        companyListPage = signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(TranslationHelpers.setFile(language, "$.company.listPage.text.real"));
        validateHelpers.waitForLoadJs();
        salePage = dashBoardPage.goSaleTable();
        validateHelpers.waitForLoadJs();
        salePage.gtoSaleViaShortCut();
        validateHelpers.waitForLoadJs();
        createSalePage.checkDateAndTypeSection(TranslationHelpers.setFile(language, "$.regularInvoice.select.option.standard")
                , TranslationHelpers.setFile(language, "$.regularInvoice.select.option.standard")
                , TranslationHelpers.setFile(language, "$.regularInvoice.select.option.installment"));
        createSalePage.checkAccountSection();
        createSalePage.checkCustomerSection();
        createSalePage.checkProductionSection(language);
        createSalePage.checkFeeSection();
        createSalePage.selectAccountNumber();
        validateHelpers.waitForLoadJs();
        createSalePage.selectEmployee(TranslationHelpers.setFile(language, "$.phoneNumber.error.phoneInvalid"));
        validateHelpers.waitForLoadJs();
        createSalePage.selectCustomer(TranslationHelpers.setFile(language, "$.invoicesCommon.dialog.createEditContact.text.language"));
        validateHelpers.waitForLoadJs();
        createSalePage.selectProduct();
        validateHelpers.waitForLoadJs();
        createSalePage.selectFee();
        validateHelpers.waitForLoadJs();
        createSalePage.clickCreateButton();
        validateHelpers.waitForLoadJs();
        validateHelpers.logout();
    }

    @Test(priority = 1)
    @Parameters({"language"})
    public void verifyInstallmentInvoiceDemo_createSuccess(@Optional("English") String language) {
        signInPage.waitForPageLoaded();
        signInPage.verifylanguage(language);
        companyListPage = signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(TranslationHelpers.setFile(language, "$.company.listPage.text.demo"));
        validateHelpers.waitForLoadJs();
        salePage = dashBoardPage.goSaleTable();
        validateHelpers.waitForLoadJs();
        salePage.gtoSaleViaShortCut();
        validateHelpers.waitForLoadJs();
        createSalePage.checkDateAndTypeSection(TranslationHelpers.setFile(language, "$.regularInvoice.select.option.installment")
                , TranslationHelpers.setFile(language, "$.regularInvoice.select.option.standard")
                , TranslationHelpers.setFile(language, "$.regularInvoice.select.option.installment"));
        createSalePage.checkAccountSection();
        createSalePage.checkCustomerSection();
        createSalePage.checkProductionSection( language);
        createSalePage.checkFeeSection();
        createSalePage.selectAccountNumber();
        validateHelpers.waitForLoadJs();
        createSalePage.selectEmployee(TranslationHelpers.setFile(language, "$.phoneNumber.error.phoneInvalid"));
        validateHelpers.waitForLoadJs();
        createSalePage.selectCustomer(TranslationHelpers.setFile(language, "$.invoicesCommon.dialog.createEditContact.text.language"));
        validateHelpers.waitForLoadJs();
        createSalePage.selectProduct();
        validateHelpers.waitForLoadJs();
        createSalePage.selectFee();
        validateHelpers.waitForLoadJs();
        createSalePage.clickCreateButton();
        validateHelpers.waitForLoadJs();
        validateHelpers.logout();
    }

    @Test(priority = 1)
    @Parameters({"language"})
    public void verifyInstallmentInvoiceReal_createSuccess(@Optional("English") String language) {
        signInPage.waitForPageLoaded();
        signInPage.verifylanguage(language);
        companyListPage = signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(TranslationHelpers.setFile(language, "$.company.listPage.text.real"));
        validateHelpers.waitForLoadJs();
        salePage = dashBoardPage.goSaleTable();
        validateHelpers.waitForLoadJs();
        salePage.gtoSaleViaShortCut();
        validateHelpers.waitForLoadJs();
        createSalePage.checkDateAndTypeSection(TranslationHelpers.setFile(language, "$.regularInvoice.select.option.installment")
                , TranslationHelpers.setFile(language, "$.regularInvoice.select.option.standard")
                , TranslationHelpers.setFile(language, "$.regularInvoice.select.option.installment"));
        createSalePage.checkAccountSection();
        createSalePage.checkCustomerSection();
        createSalePage.checkProductionSection( language);
        createSalePage.checkFeeSection();
        createSalePage.selectAccountNumber();
        validateHelpers.waitForLoadJs();
        createSalePage.selectEmployee(TranslationHelpers.setFile(language, "$.phoneNumber.error.phoneInvalid"));
        validateHelpers.waitForLoadJs();
        createSalePage.selectCustomer(TranslationHelpers.setFile(language, "$.invoicesCommon.dialog.createEditContact.text.language"));
        validateHelpers.waitForLoadJs();
        createSalePage.selectProduct();
        validateHelpers.waitForLoadJs();
        createSalePage.selectFee();
        validateHelpers.waitForLoadJs();
        createSalePage.clickCreateButton();
        validateHelpers.waitForLoadJs();
        validateHelpers.logout();
    }

    @Test(priority = 1)
    @Parameters({"language"})
    public void verifyCashSaleInvoiceDemo_createSuccess(@Optional("English") String language) {
        signInPage.waitForPageLoaded();
        signInPage.verifylanguage(language);
        companyListPage = signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(TranslationHelpers.setFile(language, "$.company.listPage.text.demo"));
        validateHelpers.waitForLoadJs();
        salePage = dashBoardPage.goSaleTable();
        validateHelpers.waitForLoadJs();
        salePage.gtoSaleViaShortCut();
        validateHelpers.waitForLoadJs();
        createSalePage.checkDateAndTypeSection(TranslationHelpers.setFile(language, "$.regularInvoice.select.option.cashSale")
                , TranslationHelpers.setFile(language, "$.regularInvoice.select.option.standard")
                , TranslationHelpers.setFile(language, "$.regularInvoice.select.option.installment"));
        createSalePage.checkAccountSection();
        createSalePage.checkCustomerSection();
        createSalePage.checkProductionSection( language);
        createSalePage.selectAccountNumber();
        validateHelpers.waitForLoadJs();
        createSalePage.selectEmployee(TranslationHelpers.setFile(language, "$.phoneNumber.error.phoneInvalid"));
        validateHelpers.waitForLoadJs();
        createSalePage.selectCustomer(TranslationHelpers.setFile(language, "$.invoicesCommon.dialog.createEditContact.text.language"));
        validateHelpers.waitForLoadJs();
        createSalePage.selectProduct();
        validateHelpers.waitForLoadJs();
        validateHelpers.waitForLoadJs();
        createSalePage.clickCreateButton();
        validateHelpers.waitForLoadJs();
        validateHelpers.logout();
    }

    @Test(priority = 1)
    @Parameters({"language"})
    public void verifyCashSaleInvoiceReal_createSuccess(@Optional("English") String language) {
        signInPage.waitForPageLoaded();
        signInPage.verifylanguage(language);
        companyListPage = signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(TranslationHelpers.setFile(language, "$.company.listPage.text.real"));
        validateHelpers.waitForLoadJs();
        salePage = dashBoardPage.goSaleTable();
        validateHelpers.waitForLoadJs();
        salePage.gtoSaleViaShortCut();
        validateHelpers.waitForLoadJs();
        createSalePage.checkDateAndTypeSection(TranslationHelpers.setFile(language, "$.regularInvoice.select.option.cashSale")
                , TranslationHelpers.setFile(language, "$.regularInvoice.select.option.standard")
                , TranslationHelpers.setFile(language, "$.regularInvoice.select.option.installment"));
        createSalePage.checkAccountSection();
        createSalePage.checkCustomerSection();
        createSalePage.checkProductionSection( language);
        createSalePage.selectAccountNumber();
        validateHelpers.waitForLoadJs();
        createSalePage.selectEmployee(TranslationHelpers.setFile(language, "$.phoneNumber.error.phoneInvalid"));
        validateHelpers.waitForLoadJs();
        createSalePage.selectCustomer(TranslationHelpers.setFile(language, "$.invoicesCommon.dialog.createEditContact.text.language"));
        validateHelpers.waitForLoadJs();
        createSalePage.selectProduct();
        validateHelpers.waitForLoadJs();
        validateHelpers.waitForLoadJs();
        createSalePage.clickCreateButton();
        validateHelpers.waitForLoadJs();
        validateHelpers.logout();
    }

    @Test(priority = 2)
    @Parameters({"language"})
    public void when_createInvoiceWithoutCustomerOnStandardInvoiceInRealCompany_then_createFail(@Optional("English") String language)
    {
        validateHelpers.waitForLoadJs();
        signInPage.verifylanguage(language);
        signInPage.login(PropertiesHelper.getValue("email"),PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        validateHelpers.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(TranslationHelpers.setFile(language, "$.company.listPage.text.real"));
        salePage.gtoSaleViaShortCut();
        validateHelpers.waitForLoadJs();
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getStandard(language));
        validateHelpers.waitForLoadJs();
        createSalePage.selectProduct();
        createSalePage.selectFee();
        createSalePage.clickCreateButton();
        validateHelpers.waitForLoadJs();
        createSalePage.getCustomerError();
        validateHelpers.logout();

    }

}
