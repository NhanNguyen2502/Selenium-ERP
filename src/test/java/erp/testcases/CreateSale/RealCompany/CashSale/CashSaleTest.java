package erp.testcases.CreateSale.RealCompany.CashSale;

import erp.base.BaseSetup;
import erp.base.ReportListener;
import erp.common.helpers.*;
import erp.pages.CompanyListPage;
import erp.pages.Customer.CreateCustomerPage;
import erp.pages.Customer.CustomerTable;
import erp.pages.Customer.UpdateCustomerPage;
import erp.pages.EmployeePage.CreateEmployeesPage;
import erp.pages.EmployeePage.UpdateEmployeePage;
import erp.pages.FeePage.CreateFeePage;
import erp.pages.FeePage.UpdateFeePage;
import erp.pages.ProductPage.CreateProductPage;
import erp.pages.ProductPage.UpdateProductPage;
import erp.pages.SalePage.CreateSalePage;
import erp.pages.SalePage.SaleTable;
import erp.pages.SignInPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

@Listeners(ReportListener.class)
public class CashSaleTest extends BaseSetup {
    private WebDriver driver;
    private ValidateHelpers validateHelpers;
    private SignInPage signInPage;
    private CreateSalePage createSalePage;
    private CompanyListPage companyListPage;
    private SaleTable saleTable;
    private BrowserManagerHelper browserManagerHelper;
    private CustomerTable customerTable;
    private CreateCustomerPage createCustomerPage;
    private UpdateCustomerPage updateCustomerPage;
    private CreateProductPage createProductPage;
    private UpdateProductPage updateProductPage;
    private CreateEmployeesPage createEmployeesPage;
    private UpdateEmployeePage updateEmployeePage;
    private CreateFeePage createFeePage;
    private UpdateFeePage updateFeePage;

    @BeforeClass
    public void setup() {
        this.driver = getDriver();
        validateHelpers = new ValidateHelpers(driver);
        signInPage = new SignInPage(driver);
        createSalePage = new CreateSalePage(driver);
        companyListPage = new CompanyListPage(driver);
        saleTable = new SaleTable(driver);
        browserManagerHelper = new BrowserManagerHelper(driver);
        customerTable = new CustomerTable(driver);
        createCustomerPage = new CreateCustomerPage(driver);
        updateCustomerPage = new UpdateCustomerPage(driver);
        createProductPage = new CreateProductPage(driver);
        updateProductPage = new UpdateProductPage(driver);
        createEmployeesPage = new CreateEmployeesPage(driver);
        updateEmployeePage = new UpdateEmployeePage(driver);
        createFeePage = new CreateFeePage(driver);
        updateFeePage = new UpdateFeePage(driver);
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void when_createWithAnonymousCustomer_then_createSuccess(@Optional("English") String language) {
        createSalePage.loginAndGoToTheCreateSalePage(language);
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getCashSale(language));
        createSalePage.selectEmployeeAnonymousCustomerProductAndCancelChangeCurrencyOfCustomer(language);
        createSalePage.createInvoiceAndVerifyAfterCreate();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void when_createWithAnonymousCustomerAndManyProducts_then_createSuccess(@Optional("English") String language) {
        createSalePage.loginAndGoToTheCreateSalePage(language);
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getCashSale(language));
        createSalePage.selectEmployeeAnonymousCustomerManyProductAndCancelChangeCurrencyOfCustomer(language);
        createSalePage.createInvoiceAndVerifyAfterCreate();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void when_createWithAllInformationCorrect_then_createSuccess(@Optional("English") String language) {
        createSalePage.loginAndGoToTheCreateSalePage(language);
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getCashSale(language));
        createSalePage.selectEmployeeCustomerProductAndCancelChangeCurrencyOfCustomer(language);
        createSalePage.createInvoiceAndVerifyAfterCreate();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void when_createWithManyProducts_then_createSuccess(@Optional("English") String language) {
        createSalePage.loginAndGoToTheCreateSalePage(language);
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getCashSale(language));
        createSalePage.selectEmployeeCustomerManyProductAndCancelChangeCurrencyOfCustomer(language);
        createSalePage.createInvoiceAndVerifyAfterCreate();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void when_createWithManyProductAndUpdateAllQuantity_then_createSuccess(@Optional("English") String language) {
        createSalePage.loginAndGoToTheCreateSalePage(language);
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getCashSale(language));
        createSalePage.selectEmployeeCustomerManyProductAndCancelChangeCurrencyOfCustomer(language);
        createSalePage.updateQuantityAllProduct();
        createSalePage.createInvoiceAndVerifyAfterCreate();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void when_createWithUpdateQuantity_then_createSuccess(@Optional("English") String language) {
        createSalePage.loginAndGoToTheCreateSalePage(language);
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getCashSale(language));
        createSalePage.selectEmployeeCustomerProductAndCancelChangeCurrencyOfCustomer(language);
        createSalePage.updateQuantityOfProduct();
        createSalePage.createInvoiceAndVerifyAfterCreate();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void when_createWithUpdateDiscount_then_createSuccess(@Optional("English") String language) {
        createSalePage.loginAndGoToTheCreateSalePage(language);
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getCashSale(language));
        createSalePage.selectEmployeeCustomerProductAndCancelChangeCurrencyOfCustomer(language);
        createSalePage.updateDiscountOfProductOnProductLine();
        createSalePage.createInvoiceAndVerifyAfterCreate();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void when_createWithManyProductAndUpdateAllDiscount_then_createSuccess(@Optional("English") String language) {
        createSalePage.loginAndGoToTheCreateSalePage(language);
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getCashSale(language));
        createSalePage.selectEmployeeCustomerManyProductAndCancelChangeCurrencyOfCustomer(language);
        createSalePage.updateDiscountOfAllProducts();
        createSalePage.createInvoiceAndVerifyAfterCreate();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void when_createWithManyProductAndUpdateDiscountOfProduct_then_createSuccess(@Optional("English") String language) {

        createSalePage.loginAndGoToTheCreateSalePage(language);
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getCashSale(language));
        createSalePage.selectEmployeeCustomerManyProductAndCancelChangeCurrencyOfCustomer(language);
        createSalePage.updateDiscountOfProductOnProductLine();
        createSalePage.createInvoiceAndVerifyAfterCreate();
        validateHelpers.logout();
    }

//    @Test(priority = 2)
//    @Parameters({"language"})
//    public void when_createWithDisableCustomer_then_createFail(@Optional("English") String language) {
//        createSalePage.loginAndGoToTheCreateSalePage(language);
//        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getCashSale(language));
//        createSalePage.selectEmployeeCustomerProductAndCancelChangeCurrencyOfCustomer(language);
//        var  _customerName = createSalePage.getCustomerName();
//        validateHelpers.waitAfterChoseOrClickElement();
//        browserManagerHelper.openNewTab(url);
//        createSalePage.disableCustomer(_customerName);
//        browserManagerHelper.backToFirstTab();
//        createSalePage.createInvoiceAndVerifyAfterCreate();
//        validateHelpers.logout();
//    }

    @Test(priority = 2)
    @Parameters({"language"})
    public void when_createWithDisableProduct_then_createFail(@Optional("English") String language) {
        createSalePage.loginAndGoToTheCreateSalePage(language);
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getCashSale(language));
        createSalePage.selectEmployeeCustomerProductAndCancelChangeCurrencyOfCustomer(language);
        validateHelpers.waitAfterChoseOrClickElement();
        var _productName = createSalePage.getProductName();
        validateHelpers.waitAfterChoseOrClickElement();
        browserManagerHelper.openNewTab(url);
        createSalePage.disableProduct(_productName);
        browserManagerHelper.backToFirstTab();
        createSalePage.createInvoiceAndVerifyAfterCreate();
        validateHelpers.logout();
    }

    @Test(priority = 2)
    @Parameters({"language"})
    public void when_createWithDisableEmployee_then_createFail(@Optional("English") String language) {
        createSalePage.loginAndGoToTheCreateSalePage(language);
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getCashSale(language));
        createSalePage.selectEmployeeCustomerProductAndCancelChangeCurrencyOfCustomer(language);
        validateHelpers.waitAfterChoseOrClickElement();
        var _employeeName = createSalePage.getEmployeeName();
        validateHelpers.waitAfterChoseOrClickElement();
        browserManagerHelper.openNewTab(url);
        createSalePage.disableEmployee(_employeeName);
        browserManagerHelper.backToFirstTab();
        createSalePage.createInvoiceAndVerifyAfterCreate();
        validateHelpers.logout();
    }

    @Test(priority = 2)
    @Parameters({"language"})
    public void when_createWithDisableEmployeeAndCustomer_then_createFail(@Optional("English") String language) {
        createSalePage.loginAndGoToTheCreateSalePage(language);
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getCashSale(language));
        createSalePage.selectEmployeeCustomerProductAndCancelChangeCurrencyOfCustomer(language);
        var  _customerName = createSalePage.getCustomerName();
        validateHelpers.waitAfterChoseOrClickElement();
        var _employeeName = createSalePage.getEmployeeName();
        validateHelpers.waitAfterChoseOrClickElement();
        browserManagerHelper.openNewTab(url);
        createSalePage.disableEmployee(_employeeName);
        createSalePage.disableCustomer(_customerName);
        browserManagerHelper.backToFirstTab();
        createSalePage.createInvoiceAndVerifyAfterCreate();
        validateHelpers.logout();
    }

}
