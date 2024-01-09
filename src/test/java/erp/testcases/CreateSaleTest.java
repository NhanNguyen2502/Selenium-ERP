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

    @Test(priority = 2)
    @Parameters({"language"})
    public void verifyInstallmentInvoiceDemo(@Optional("English") String language) {
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

    @Test(priority = 2)
    @Parameters({"language"})
    public void verifyInstallmentInvoiceReal(@Optional("English") String language) {
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

    @Test(priority = 3)
    @Parameters({"language"})
    public void verifyCashSaleInvoiceDemo(@Optional("English") String language) {
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
        createSalePage.selectFee();
        validateHelpers.waitForLoadJs();
        createSalePage.clickCreateButton();
        validateHelpers.waitForLoadJs();
        validateHelpers.logout();
    }

    @Test(priority = 3)
    @Parameters({"language"})
    public void verifyCashSaleInvoiceReal(@Optional("English") String language) {
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
        createSalePage.selectFee();
        validateHelpers.waitForLoadJs();
        createSalePage.clickCreateButton();
        validateHelpers.waitForLoadJs();
        validateHelpers.logout();
    }

}
