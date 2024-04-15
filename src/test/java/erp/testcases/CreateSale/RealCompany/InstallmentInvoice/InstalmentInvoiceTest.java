package erp.testcases.CreateSale.RealCompany.InstallmentInvoice;

import erp.base.BaseSetup;
import erp.base.ReportListener;
import erp.common.helpers.*;
import erp.pages.CompanyListPage;
import erp.pages.SalePage.CreateSalePage;
import erp.pages.SalePage.SaleTable;
import erp.pages.SignInPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

@Listeners(ReportListener.class)
public class InstalmentInvoiceTest extends BaseSetup {
    private WebDriver driver;
    private ValidateHelpers validateHelpers;
    private SignInPage signInPage;
    private CreateSalePage createSalePage;
    private CompanyListPage companyListPage;
    private SaleTable saleTable;
    private BrowserManagerHelper browserManagerHelper;

    @BeforeClass
    public void setup() {
        this.driver = getDriver();
        validateHelpers = new ValidateHelpers(driver);
        signInPage = new SignInPage(driver);
        createSalePage = new CreateSalePage(driver);
        companyListPage = new CompanyListPage(driver);
        saleTable = new SaleTable(driver);
        browserManagerHelper = new BrowserManagerHelper(driver);
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void when_createWithAllInformationCorrect_then_createSuccess(@Optional("English") String language) {
        createSalePage.loginAndGoToTheCreateSalePage(language);
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getInstallment(language));
        createSalePage.selectPaymentAccountEmployeeCustomerProductFeeAndCancelChangeCurrencyOfCustomer(language);
        createSalePage.addInstallmentPlan();
        createSalePage.instalmentVerifyAfterCreate();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void when_createWithUpdateDiscount_then_createSuccess(@Optional("English") String language) {
        createSalePage.loginAndGoToTheCreateSalePage(language);
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getInstallment(language));
        createSalePage.selectPaymentAccountEmployeeCustomerProductFeeAndCancelChangeCurrencyOfCustomer(language);
        createSalePage.updateDiscountOfProductOnProductLine();
        createSalePage.addInstallmentPlan();
        createSalePage.instalmentVerifyAfterCreate();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void when_createWithManyProductAndUpdateAllDiscount_then_createSuccess(@Optional("English") String language) {
        createSalePage.loginAndGoToTheCreateSalePage(language);
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getInstallment(language));
        createSalePage.selectEmployeeCustomerManyProductAndCancelChangeCurrencyOfCustomer(language);
        createSalePage.updateDiscountOfAllProducts();
        createSalePage.addInstallmentPlan();
        createSalePage.instalmentVerifyAfterCreate();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void when_createWithUpdateDiscount_then_createSuccess(@Optional("English") String language) {
        signInPage.waitForPageLoaded();
        signInPage.verifylanguage(language);
        companyListPage = signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        salePage.gtoSaleViaShortCut();
        validateHelpers.waitForLoadJsCreatePage();
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getInstallment(language));
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.selectAccountNumber();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.selectEmployee(TranslationHelpers.setFile(language, "$.phoneNumber.error.phoneInvalid"));
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.selectCustomer(TranslationHelpers.setFile(language, "$.invoicesCommon.dialog.createEditContact.text.language"));
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.checkConfirmChangeCurrencyDialog();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.cancelChangeCurrency();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.selectProduct();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.selectFee();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.updateDiscountOfProductOnProductLine();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.addInstallmentPlan();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.clickCreateButton();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.skipSetFirstInvoiceNumber();
        validateHelpers.waitForLoadJs();
        createSalePage.checkInvoiceAfterClickCreateButton();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void when_createWithManyProductAndUpdateAllDiscount_then_createSuccess(@Optional("English") String language) {
        signInPage.waitForPageLoaded();
        signInPage.verifylanguage(language);
        companyListPage = signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        salePage.gtoSaleViaShortCut();
        validateHelpers.waitForLoadJsCreatePage();
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getInstallment(language));
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.selectAccountNumber();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.selectEmployee(TranslationHelpers.setFile(language, "$.phoneNumber.error.phoneInvalid"));
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.selectCustomer(TranslationHelpers.setFile(language, "$.invoicesCommon.dialog.createEditContact.text.language"));
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.checkConfirmChangeCurrencyDialog();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.cancelChangeCurrency();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.addManyProductInProductLine();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.fillProductIntoProductlines();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.updateDiscountOfAllProducts();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.selectFee();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.addInstallmentPlan();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.clickCreateButton();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.skipSetFirstInvoiceNumber();
        validateHelpers.waitForLoadJs();
        createSalePage.checkInvoiceAfterClickCreateButton();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void when_createWithManyProductAndUpdateQuantityAfterCreateInstalmentPlan_then_createSuccess(@Optional("English") String language) {
        createSalePage.loginAndGoToTheCreateSalePage(language);
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getInstallment(language));
        createSalePage.selectEmployeeCustomerManyProductAndCancelChangeCurrencyOfCustomer(language);
        createSalePage.addInstallmentPlan();
        createSalePage.updateQuantityAllProduct();
        createSalePage.addInstallmentPlan();
        createSalePage.confirmUpdadateInstalmentPlanAfterChangeInstalmentAmount();
        createSalePage.instalmentVerifyAfterCreate();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void when_createWithManyProductAndUpdateDiscountAfterCreateInstalmentPlan_then_createSuccess(@Optional("English") String language) {
        createSalePage.loginAndGoToTheCreateSalePage(language);
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getInstallment(language));
        createSalePage.selectEmployeeCustomerManyProductAndCancelChangeCurrencyOfCustomer(language);
        createSalePage.addInstallmentPlan();
        createSalePage.updateDiscountOfAllProducts();
        createSalePage.addInstallmentPlan();
        createSalePage.confirmUpdadateInstalmentPlanAfterChangeInstalmentAmount();
        createSalePage.instalmentVerifyAfterCreate();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void when_createWithManyProductAndUpdateDiscountAfterCreateInstalmentPlan_then_createSuccess(@Optional("English") String language) {
        signInPage.waitForPageLoaded();
        signInPage.verifylanguage(language);
        companyListPage = signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        salePage.gtoSaleViaShortCut();
        validateHelpers.waitForLoadJsCreatePage();
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getInstallment(language));
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.selectAccountNumber();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.selectEmployee(TranslationHelpers.setFile(language, "$.phoneNumber.error.phoneInvalid"));
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.selectCustomer(TranslationHelpers.setFile(language, "$.invoicesCommon.dialog.createEditContact.text.language"));
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.checkConfirmChangeCurrencyDialog();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.cancelChangeCurrency();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.addManyProductInProductLine();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.fillProductIntoProductlines();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.selectFee();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.addInstallmentPlan();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.updateDiscountOfAllProducts();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.addInstallmentPlan();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.confirmUpdadateInstalmentPlanAfterChangeInstalAmount();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.clickCreateButton();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.skipSetFirstInvoiceNumber();
        validateHelpers.waitForLoadJs();
        createSalePage.checkInvoiceAfterClickCreateButton();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void when_createWithAddManyProducts_then_createSuccess(@Optional("English") String language) {
        createSalePage.loginAndGoToTheCreateSalePage(language);
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getInstallment(language));
        createSalePage.selectPaymentAccountEmployeeCustomerProductManyFeeAndCancelChangeCurrencyOfCustomer(language);
        createSalePage.addInstallmentPlan();
        createSalePage.instalmentVerifyAfterCreate();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void when_createWithAddManyFees_then_createSuccess(@Optional("English") String language) {
        createSalePage.loginAndGoToTheCreateSalePage(language);
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getInstallment(language));
        createSalePage.selectEmployeeCustomerManyProductAndCancelChangeCurrencyOfCustomer(language);
        createSalePage.addInstallmentPlan();
        createSalePage.instalmentVerifyAfterCreate();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void when_createWithAnotherCurrency_then_createSuccess(@Optional("English") String language) {
        createSalePage.loginAndGoToTheCreateSalePage(language);
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getInstallment(language));
        createSalePage.selectPaymentAccountEmployeeCustomerProductFeeAndCancelChangeCurrencyOfCustomer(language);
        createSalePage.changeCurrencyOfCustomer();
        createSalePage.addInstallmentPlan();
        createSalePage.instalmentVerifyAfterCreate();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void when_createWithAddManyFeesAndManyProducts_then_createSuccess(@Optional("English") String language) {
        createSalePage.loginAndGoToTheCreateSalePage(language);
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getInstallment(language));
        createSalePage.selectPaymentAccountCustomerManyProductManyFee(language);
        createSalePage.addInstallmentPlan();
        createSalePage.instalmentVerifyAfterCreate();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void when_createWithAddInstalmentPlanViaPlusIcon_then_createSuccess(@Optional("English") String language) {
        createSalePage.loginAndGoToTheCreateSalePage(language);
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getInstallment(language));
        createSalePage.selectPaymentAccountEmployeeCustomerProductFeeAndCancelChangeCurrencyOfCustomer(language);
        createSalePage.addInstalmentPlanViaPlusIconOnInstalmentPlanSection();
        createSalePage.instalmentVerifyAfterCreate();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void when_createWithRemoveAndReAddInstalmentLine_then_createSuccess(@Optional("English") String language) {
        createSalePage.loginAndGoToTheCreateSalePage(language);
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getInstallment(language));
        createSalePage.selectPaymentAccountEmployeeCustomerProductFeeAndCancelChangeCurrencyOfCustomer(language);
        createSalePage.addInstallmentPlan();
        createSalePage.reAddInstalmentLineViaPlusIcon();
        createSalePage.instalmentVerifyAfterCreate();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void when_createWithConfirmUpdateInstalmentPlanAfterChangeInstalmentAmount_then_createSuccess(@Optional("English") String language) {
        createSalePage.loginAndGoToTheCreateSalePage(language);
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getInstallment(language));
        createSalePage.selectPaymentAccountEmployeeCustomerProductFeeAndCancelChangeCurrencyOfCustomer(language);
        createSalePage.addInstallmentPlan();
        createSalePage.confirmUpdateInstalmentPlanAfterEnterAnotherAmountToInstalmentAmount();
        createSalePage.instalmentVerifyAfterCreate();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void when_createWithCancelUpdateInstalmentPlan_then_createFail(@Optional("English") String language) {
        createSalePage.loginAndGoToTheCreateSalePage(language);
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getInstallment(language));
        createSalePage.selectPaymentAccountEmployeeCustomerProductFeeAndCancelChangeCurrencyOfCustomer(language);
        createSalePage.addInstallmentPlan();
        createSalePage.cancelUpdateInstalmentPlanAfterEnterAnotherAmountToInstalmentAmount();
        createSalePage.instalmentVerifyAfterCreate();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void when_createWithPeriodWeekly_then_createSuccess(@Optional("English") String language) {
        createSalePage.loginAndGoToTheCreateSalePage(language);
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getInstallment(language));
        createSalePage.selectPaymentAccountEmployeeCustomerProductFeeAndCancelChangeCurrencyOfCustomer(language);
        createSalePage.selectInstalmentPeriodWekkly(language);
        createSalePage.instalmentVerifyAfterCreate();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void when_createWithPeriodQuarterly_then_createSuccess(@Optional("English") String language) {
        createSalePage.loginAndGoToTheCreateSalePage(language);
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getInstallment(language));
        createSalePage.selectPaymentAccountEmployeeCustomerProductFeeAndCancelChangeCurrencyOfCustomer(language);
        createSalePage.selectInstalmentPeriodYearly(language);
        createSalePage.instalmentVerifyAfterCreate();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void when_createWithPeriodYearly_then_createSuccess(@Optional("English") String language) {
        createSalePage.loginAndGoToTheCreateSalePage(language);
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getInstallment(language));
        createSalePage.selectPaymentAccountEmployeeCustomerProductFeeAndCancelChangeCurrencyOfCustomer(language);
        createSalePage.selectInstalmentPeriodQuarterly(language);
        createSalePage.instalmentVerifyAfterCreate();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void when_createWithAddPrePayment_then_createSuccess(@Optional("English") String language) {
        createSalePage.loginAndGoToTheCreateSalePage(language);
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getInstallment(language));
        createSalePage.selectPaymentAccountEmployeeCustomerProductFeeAndCancelChangeCurrencyOfCustomer(language);
        createSalePage.addPrePayment();
        createSalePage.addInstallmentPlan();
        createSalePage.instalmentVerifyAfterCreate();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void when_createWithOutFee_then_createSuccess(@Optional("English") String language) {
        createSalePage.loginAndGoToTheCreateSalePage(language);
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getInstallment(language));
        createSalePage.selectEmployeeCustomerProductAndCancelChangeCurrencyOfCustomer(language);
        createSalePage.addInstallmentPlan();
        createSalePage.instalmentVerifyAfterCreate();
        validateHelpers.logout();
    }

    @Test(priority = 1)
    @Parameters({"language"})
    public void when_createWithoutCustomer_then_createFail(@Optional("English") String language) {
        createSalePage.loginAndGoToTheCreateSalePage(language);
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getInstallment(language));
        createSalePage.selectEmployeeProductAndCancelChangeCurrencyOfCustomer(language);
        createSalePage.addInstallmentPlan();
        createSalePage.instalmentVerifyAfterCreate();
        validateHelpers.logout();
    }

    @Test(priority = 1)
    @Parameters({"language"})
    public void when_createWithoutProduct_then_createFail(@Optional("English") String language) {
        createSalePage.loginAndGoToTheCreateSalePage(language);
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getInstallment(language));
        createSalePage.selectEmployeeCustomerAndCancelChangeCurrencyOfCustomer(language);
        createSalePage.addInstallmentPlan();
        createSalePage.instalmentVerifyAfterCreate();
        validateHelpers.logout();
    }

    @Test(priority = 1)
    @Parameters({"language"})
    public void when_createWithoutInstalmentPlan_then_createFail(@Optional("English") String language) {
        createSalePage.loginAndGoToTheCreateSalePage(language);
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getInstallment(language));
        createSalePage.selectEmployeeCustomerProductAndCancelChangeCurrencyOfCustomer(language);
        createSalePage.instalmentVerifyAfterCreate();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void when_createWithRemoveAllProductsAfterAddInstalmentPlan_then_createFail(@Optional("English") String language) {
        createSalePage.loginAndGoToTheCreateSalePage(language);
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getInstallment(language));
        createSalePage.selectEmployeeCustomerProductAndCancelChangeCurrencyOfCustomer(language);
        createSalePage.addInstallmentPlan();
        createSalePage.removeAllProducts();
        createSalePage.instalmentVerifyAfterCreate();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void when_createWithUpdateQuantityOfProductAfterAddInstalmentPlan_then_createFail(@Optional("English") String language) {
        createSalePage.loginAndGoToTheCreateSalePage(language);
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getInstallment(language));
        createSalePage.selectEmployeeCustomerProductAndCancelChangeCurrencyOfCustomer(language);
        createSalePage.addInstallmentPlan();
        createSalePage.updateQuantityAllProduct();
        createSalePage.instalmentVerifyAfterCreate();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void when_createWithManyProductAndUpdateQuantityAfterCreateInstalmentPlanWithCancelUpdatePlan_then_createFail(@Optional("English") String language) {
        createSalePage.loginAndGoToTheCreateSalePage(language);
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getInstallment(language));
        createSalePage.selectEmployeeCustomerManyProductAndCancelChangeCurrencyOfCustomer(language);
        createSalePage.addInstallmentPlan();
        createSalePage.updateQuantityAllProduct();
        createSalePage.addInstallmentPlan();
        createSalePage.cancelUpdadateInstalmentPlanAfterChangeInstalAmount();
        createSalePage.instalmentVerifyAfterCreate();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void when_createWithDisableCustomer_then_createFail(@Optional("English") String language) {
        createSalePage.loginAndGoToTheCreateSalePage(language);
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getInstallment(language));
        createSalePage.selectEmployeeCustomerProductAndCancelChangeCurrencyOfCustomer(language);
        createSalePage.addInstallmentPlan();
        var _customerName = createSalePage.getCustomerName();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.addInstallmentPlan();
        browserManagerHelper.openNewTab(url);
        createSalePage.disableCustomer(_customerName);
        browserManagerHelper.backToFirstTab();
        createSalePage.instalmentVerifyAfterCreate();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void when_createWithDisableProduct_then_createFail(@Optional("English") String language) {

        createSalePage.loginAndGoToTheCreateSalePage(language);
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getInstallment(language));
        createSalePage.selectEmployeeCustomerProductAndCancelChangeCurrencyOfCustomer(language);
        validateHelpers.waitAfterChoseOrClickElement();
        var _productName = createSalePage.getProductName();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.addInstallmentPlan();
        browserManagerHelper.openNewTab(url);
        createSalePage.disableProduct(_productName);
        browserManagerHelper.backToFirstTab();
        createSalePage.instalmentVerifyAfterCreate();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void when_createWithDisableEmployee_then_createFail(@Optional("English") String language) {
        createSalePage.loginAndGoToTheCreateSalePage(language);
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getInstallment(language));
        createSalePage.selectEmployeeCustomerProductAndCancelChangeCurrencyOfCustomer(language);
        validateHelpers.waitAfterChoseOrClickElement();
        var _employeeName = createSalePage.getEmployeeName();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.addInstallmentPlan();
        browserManagerHelper.openNewTab(url);
        createSalePage.disableEmployee(_employeeName);
        browserManagerHelper.backToFirstTab();
        createSalePage.instalmentVerifyAfterCreate();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void when_createWithDisableEmployeeAndCustomer_then_createFail(@Optional("English") String language) {
        createSalePage.loginAndGoToTheCreateSalePage(language);
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getInstallment(language));
        createSalePage.selectEmployeeCustomerProductAndCancelChangeCurrencyOfCustomer(language);
        var _customerName = createSalePage.getCustomerName();
        validateHelpers.waitAfterChoseOrClickElement();
        var _employeeName = createSalePage.getEmployeeName();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.addInstallmentPlan();
        browserManagerHelper.openNewTab(url);
        createSalePage.disableEmployee(_employeeName);
        createSalePage.disableCustomer(_customerName);
        browserManagerHelper.backToFirstTab();
        createSalePage.instalmentVerifyAfterCreate();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void when_createWithDisableFee_then_createFail(@Optional("English") String language) {
        createSalePage.loginAndGoToTheCreateSalePage(language);
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getInstallment(language));
        createSalePage.selectPaymentAccountEmployeeCustomerProductFeeAndCancelChangeCurrencyOfCustomer(language);
        var _feeName = createSalePage.getFeeName();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.addInstallmentPlan();
        browserManagerHelper.openNewTab(url);
        createSalePage.disableFee(_feeName);
        browserManagerHelper.backToFirstTab();
        createSalePage.instalmentVerifyAfterCreate();
        validateHelpers.logout();
    }
}
