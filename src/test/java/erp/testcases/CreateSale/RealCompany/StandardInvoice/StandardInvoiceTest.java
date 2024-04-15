package erp.testcases.CreateSale.RealCompany.StandardInvoice;

import erp.base.BaseSetup;
import erp.base.ReportListener;
import erp.common.helpers.*;
import erp.pages.*;
import erp.pages.SalePage.CreateSalePage;
import erp.pages.SalePage.SaleTable;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

@Listeners(ReportListener.class)
public class StandardInvoiceTest extends BaseSetup {
    private WebDriver driver;
    private ValidateHelpers validateHelpers;
    private SignInPage signInPage;
    private CreateSalePage createSalePage;
    private DashBoardPage dashBoardPage;
    private CompanyListPage companyListPage;
    private SaleTable saleTable;

    @BeforeClass
    public void setUp() {
        this.driver = getDriver();
        validateHelpers = new ValidateHelpers(driver);
        signInPage = new SignInPage(driver);
        createSalePage = new CreateSalePage(driver);
        dashBoardPage = new DashBoardPage(driver);
        companyListPage = new CompanyListPage(driver);
        saleTable = new SaleTable(driver);
    }

    @Test(priority = 1)
    @Parameters({"language"})
    public void when_createWithAllInformationCorrect_then_createSuccess(@Optional("English") String language) {
        createSalePage.loginAndGoToTheCreateSalePage(language);
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getStandard(language));
        createSalePage.selectPaymentAccountEmployeeCustomerProductFeeAndCancelChangeCurrencyOfCustomer(language);
        createSalePage.createInvoiceAndVerifyAfterCreate();
        validateHelpers.logout();
    }

    @Test(priority = 2)
    @Parameters({"language"})
    public void when_createInvoiceWithoutCustomerOnStandardInvoiceInRealCompany_then_createFail(@Optional("English") String language) {
        createSalePage.loginAndGoToTheCreateSalePage(language);
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getStandard(language));
        createSalePage.selectEmployeeProductAndCancelChangeCurrencyOfCustomer(language);
        createSalePage.createInvoiceAndVerifyAfterCreate();
        validateHelpers.logout();

    }

    @Test(priority = 2)
    @Parameters({"language"})
    public void when_createInvoiceWithoutProductOnStandardInvoiceInRealCompany_then_createFail(@Optional("English") String language) {
        createSalePage.loginAndGoToTheCreateSalePage(language);
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getStandard(language));
        createSalePage.selectEmployeeCustomerAndCancelChangeCurrencyOfCustomer(language);
        createSalePage.createInvoiceAndVerifyAfterCreate();
        validateHelpers.logout();
    }

    @Test(priority = 2)
    @Parameters({"language"})
    public void createInvoiceWithAnotherCurrencyOnStandardInvoiceChoseCustomerFirst_then_createSuccess(@Optional("English") String language) {
        createSalePage.loginAndGoToTheCreateSalePage(language);
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getStandard(language));
        createSalePage.selectPaymentAccountEmployeeCustomerProductFeeAndCancelChangeCurrencyOfCustomer(language);
        createSalePage.changeCurrencyOfCustomer();
        createSalePage.createInvoiceAndVerifyAfterCreate();
        validateHelpers.logout();
    }

    @Test(priority = 2)
    @Parameters({"language"})
    public void createInvoiceWithAnotherCurrencyOnStandardInvoiceChoseCustomerLast_then_createSuccess(@Optional("English") String language) {
        createSalePage.loginAndGoToTheCreateSalePage(language);
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getStandard(language));
        createSalePage.changeCurrencyOfCustomer();
        createSalePage.selectPaymentAccountEmployeeCustomerProductFeeAndCancelChangeCurrencyOfCustomer(language);
        createSalePage.createInvoiceAndVerifyAfterCreate();
        validateHelpers.logout();
    }

    @Test(priority = 3)
    @Parameters({"language"})
    public void createInvoiceWithAnotherReceiptLanguageChoseCustomerFirst_then_createSuccess(@Optional("English") String language) {
        createSalePage.loginAndGoToTheCreateSalePage(language);
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getStandard(language));
        createSalePage.selectPaymentAccountEmployeeCustomerProductFeeAndCancelChangeCurrencyOfCustomer(language);
        createSalePage.changeLanguageOfCustomerOnInvoiceCreatePage();
        createSalePage.createInvoiceAndVerifyAfterCreate();
        validateHelpers.logout();

    }

    @Test(priority = 3)
    @Parameters({"language"})
    public void createInvoiceWithChangePriceOfProduct_then_createSuccess(@Optional("English") String language) {
        createSalePage.loginAndGoToTheCreateSalePage(language);
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getStandard(language));
        createSalePage.selectPaymentAccountEmployeeCustomerProductFeeAndCancelChangeCurrencyOfCustomer(language);
        createSalePage.changeProductPriceRandomPrice();
        createSalePage.createInvoiceAndVerifyAfterCreate();
        validateHelpers.logout();
    }

    @Test(priority = 3)
    @Parameters({"language"})
    public void createInvoiceWithManyProduct_then_createSuccess(@Optional("English") String language) {
        createSalePage.loginAndGoToTheCreateSalePage(language);
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getStandard(language));
        createSalePage.selectEmployeeCustomerManyProductAndCancelChangeCurrencyOfCustomer(language);
        createSalePage.createInvoiceAndVerifyAfterCreate();
        validateHelpers.logout();
    }

    @Test(priority = 3)
    @Parameters({"language"})
    public void createInvoiceWithManyProductsAndChangeAnyProductPrice_then_createSuccess(@Optional("English") String language) {
        createSalePage.loginAndGoToTheCreateSalePage(language);
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getStandard(language));
        createSalePage.selectEmployeeCustomerManyProductAndCancelChangeCurrencyOfCustomer(language);
        createSalePage.changePriceOfAnyProductInProductLines();
        createSalePage.createInvoiceAndVerifyAfterCreate();
        validateHelpers.logout();
    }

    @Test(priority = 3)
    @Parameters({"language"})
    public void createInvoiceWithAnProductLineNullWithOutClickOnIt_then_createSuccess(@Optional("English") String language) {
        createSalePage.loginAndGoToTheCreateSalePage(language);
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getStandard(language));
        createSalePage.selectEmployeeCustomerProductAndCancelChangeCurrencyOfCustomer(language);
        createSalePage.addAProductLineIntoProductSection();
        createSalePage.createInvoiceAndVerifyAfterCreate();
        validateHelpers.logout();
    }

    @Test(priority = 3)
    @Parameters({"language"})
    public void createInvoiceWithUpdateQuantityOfProduct_then_createSuccess(@Optional("English") String language) {
        createSalePage.loginAndGoToTheCreateSalePage(language);
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getStandard(language));
        createSalePage.selectEmployeeCustomerProductAndCancelChangeCurrencyOfCustomer(language);
        createSalePage.updateQuantityOfProduct();
        createSalePage.createInvoiceAndVerifyAfterCreate();
        validateHelpers.logout();
    }

    @Test(priority = 3)
    @Parameters({"language"})
    public void createInvoiceWithUpdateQuantityOfManyProducts_then_createSuccess(@Optional("English") String language) {
        createSalePage.loginAndGoToTheCreateSalePage(language);
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getStandard(language));
        createSalePage.selectEmployeeCustomerManyProductAndCancelChangeCurrencyOfCustomer(language);
        createSalePage.updateQuantityAllProduct();
        createSalePage.createInvoiceAndVerifyAfterCreate();
        validateHelpers.logout();
    }

    @Test(priority = 3)
    @Parameters({"language"})
    public void createInvoiceWithUpdateQuantityOfAnyProducts_then_createSuccess(@Optional("English") String language) {
        createSalePage.loginAndGoToTheCreateSalePage(language);
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getStandard(language));
        createSalePage.selectEmployeeCustomerManyProductAndCancelChangeCurrencyOfCustomer(language);
        createSalePage.updateQuantityOfAnyProduct();
        createSalePage.createInvoiceAndVerifyAfterCreate();
        validateHelpers.logout();
    }

    @Test(priority = 3)
    @Parameters({"language"})
    public void createInvoiceWithUpdateDiscountOfProduct_then_createSuccess(@Optional("English") String language) {
        createSalePage.loginAndGoToTheCreateSalePage(language);
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getStandard(language));
        createSalePage.selectEmployeeCustomerProductAndCancelChangeCurrencyOfCustomer(language);
        createSalePage.updateQuantityOfAnyProduct();
        createSalePage.createInvoiceAndVerifyAfterCreate();
        validateHelpers.logout();
    }

    @Test(priority = 3)
    @Parameters({"language"})
    public void createInvoiceWithUpdateDiscountOfAnyProduct_then_createSuccess(@Optional("English") String language) {
        createSalePage.loginAndGoToTheCreateSalePage(language);
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getStandard(language));
        createSalePage.selectEmployeeCustomerManyProductAndCancelChangeCurrencyOfCustomer(language);
        createSalePage.updateDiscountOfProductOnProductLine();
        createSalePage.createInvoiceAndVerifyAfterCreate();
        validateHelpers.logout();
    }

    @Test(priority = 3)
    @Parameters({"language"})
    public void createInvoiceWithUpdateDiscountOfAllProducts_then_createSuccess(@Optional("English") String language) {
        createSalePage.loginAndGoToTheCreateSalePage(language);
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getStandard(language));
        createSalePage.selectEmployeeCustomerManyProductAndCancelChangeCurrencyOfCustomer(language);
        createSalePage.updateDiscountOfAllProducts();
        createSalePage.createInvoiceAndVerifyAfterCreate();
        validateHelpers.logout();
    }

    @Test(priority = 3)
    @Parameters({"language"})
    public void createInvoiceWithProductOnPopularProductSection_then_createSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        saleTable.gtoSaleViaShortCut();
        validateHelpers.waitForLoadJs();
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getStandard(language));
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.selectCustomer(TranslationHelpers.setFile(language, "$.invoicesCommon.dialog.createEditContact.text.language"));
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.checkConfirmChangeCurrencyDialog();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.cancelChangeCurrency();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.selectProductOnPopularProductSection();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.clickCreateButton();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.checkConfirmCreateInvoiceWith0Mount();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.confirmCreateInvoiceAmout0();
        validateHelpers.waitForLoadJs();
        createSalePage.checkInvoiceAfterClickCreateButton();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

    @Test(priority = 4)
    @Parameters({"language"})
    public void createInvoiceWithComment_then_createSuccess(@Optional("English") String language) {
        createSalePage.loginAndGoToTheCreateSalePage(language);
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getStandard(language));
        createSalePage.selectEmployeeCustomerManyProductAndCancelChangeCurrencyOfCustomer(language);
        createSalePage.addCommentOnInvoice();
        createSalePage.createInvoiceAndVerifyAfterCreate();
        validateHelpers.logout();
    }

    @Test(priority = 4)
    @Parameters({"language"})
    public void createInvoiceAttachmentImage_then_createSuccess(@Optional("English") String language) {
        createSalePage.loginAndGoToTheCreateSalePage(language);
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getStandard(language));
        createSalePage.selectEmployeeCustomerManyProductAndCancelChangeCurrencyOfCustomer(language);
        createSalePage.attachmentImage();
        createSalePage.createInvoiceAndVerifyAfterCreate();
        validateHelpers.logout();
    }

    @Test(priority = 4)
    @Parameters({"language"})
    public void createInvoiceAttachmentImageAndAddComment_then_createSuccess(@Optional("English") String language) {
        createSalePage.loginAndGoToTheCreateSalePage(language);
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getStandard(language));
        createSalePage.selectEmployeeCustomerManyProductAndCancelChangeCurrencyOfCustomer(language);
        createSalePage.addCommentOnInvoice();
        createSalePage.attachmentImage();
        createSalePage.createInvoiceAndVerifyAfterCreate();
        validateHelpers.logout();
    }

    @Test(priority = 5)
    @Parameters({"language"})
    public void createInvoiceWithManyFees_then_createSuccess(@Optional("English") String language) {
        createSalePage.loginAndGoToTheCreateSalePage(language);
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getStandard(language));
        createSalePage.selectPaymentAccountEmployeeCustomerProductManyFeeAndCancelChangeCurrencyOfCustomer(language);
        createSalePage.createInvoiceAndVerifyAfterCreate();
        validateHelpers.logout();
    }

    @Test(priority = 5)
    @Parameters({"language"})
    public void createInvoiceAmoutFeeHasBeenUpdate_then_createSuccess(@Optional("English") String language) {
        createSalePage.loginAndGoToTheCreateSalePage(language);
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getStandard(language));
        createSalePage.selectPaymentAccountEmployeeCustomerProductFeeAndCancelChangeCurrencyOfCustomer(language);
        createSalePage.updateAmountOfFee();
        createSalePage.createInvoiceAndVerifyAfterCreate();
        validateHelpers.logout();
    }

    @Test(priority = 5)
    @Parameters({"language"})
    public void createInvoiceWithManyFeeAndManyProduct_then_createSuccess(@Optional("English") String language) {
        createSalePage.loginAndGoToTheCreateSalePage(language);
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getStandard(language));
        createSalePage.selectPaymentAccountCustomerManyProductManyFee(language);
        createSalePage.createInvoiceAndVerifyAfterCreate();
        validateHelpers.logout();
    }

}
