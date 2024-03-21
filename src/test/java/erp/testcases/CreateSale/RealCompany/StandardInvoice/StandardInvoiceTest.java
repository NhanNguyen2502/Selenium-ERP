package erp.testcases.CreateSale.RealCompany.StandardInvoice;

import erp.base.BaseSetup;
import erp.base.ReportListener;
import erp.common.helpers.*;
import erp.pages.*;
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
    public void when_createWithAllInformationCorrect_then_createSuccess(@Optional("English") String language) {
        signInPage.waitForPageLoaded();
        signInPage.verifylanguage(language);
        companyListPage = signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        salePage.gtoSaleViaShortCut();
        validateHelpers.waitForLoadJs();
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getStandard(language));
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
        createSalePage.clickCreateButton();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.checkConfirmCreateInvoiceWith0Mount();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.confirmCreateInvoiceAmout0();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.skipSetFirstInvoiceNumber();
        validateHelpers.waitForLoadJs();
        createSalePage.checkInvoiceAfterClickCreateButton();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

    @Test(priority = 2)
    @Parameters({"language"})
    public void when_createInvoiceWithoutCustomerOnStandardInvoiceInRealCompany_then_createFail(@Optional("English") String language) {
        validateHelpers.waitForLoadJs();
        signInPage.verifylanguage(language);
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        validateHelpers.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        salePage.gtoSaleViaShortCut();
        validateHelpers.waitForLoadJs();
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getStandard(language));
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.selectProduct();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.selectFee();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.clickCreateButton();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.getCustomerError();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.checkInvoiceAfterClickCreateButton();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();

    }

    @Test(priority = 2)
    @Parameters({"language"})
    public void when_createInvoiceWithoutProductOnStandardInvoiceInRealCompany_then_createFail(@Optional("English") String language) {
        validateHelpers.waitForLoadJs();
        signInPage.verifylanguage(language);
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        validateHelpers.verifylanguage(language);
        validateHelpers.waitAfterChoseOrClickElement();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        salePage.gtoSaleViaShortCut();
        validateHelpers.waitForLoadJs();
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getStandard(language));
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.selectCustomer(TranslationHelpers.setFile(language, "$.invoicesCommon.dialog.createEditContact.text.language"));
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.checkConfirmChangeCurrencyDialog();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.cancelChangeCurrency();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.selectFee();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.clickCreateButton();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.getProductError();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.checkInvoiceAfterClickCreateButton();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

    @Test(priority = 2)
    @Parameters({"language"})
    public void createInvoiceWithAnotherCurrencyOnStandardInvoiceChoseCustomerFirst_then_createSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        salePage.gtoSaleViaShortCut();
        validateHelpers.waitForLoadJs();
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getStandard(language));
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.selectCustomer(TranslationHelpers.setFile(language, "$.invoicesCommon.dialog.createEditContact.text.language"));
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.changeCurrencyOnInvoice();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.checkConfirmChangeCurrencyDialog();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.confirmChangeCurrency();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.fillRate();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.selectProduct();
        createSalePage.changeProductPriceOtherThan0();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.clickCreateButton();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.checkConfirmCreateInvoiceWith0Mount();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.confirmCreateInvoiceAmout0();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.confirmSetFirstInvoiceNumber();
        validateHelpers.waitForLoadJs();
        createSalePage.checkInvoiceAfterClickCreateButton();
        validateHelpers.logout();
    }

    @Test(priority = 2)
    @Parameters({"language"})
    public void createInvoiceWithAnotherCurrencyOnStandardInvoiceChoseCustomerLast_then_createSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        salePage.gtoSaleViaShortCut();
        validateHelpers.waitForLoadJs();
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getStandard(language));
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.changeCurrencyOnInvoice();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.selectCustomer(TranslationHelpers.setFile(language, "$.invoicesCommon.dialog.createEditContact.text.language"));
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.checkConfirmChangeCurrencyDialog();
        createSalePage.cancelChangeCurrency();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.fillRate();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.selectProduct();
        createSalePage.changeProductPriceOtherThan0();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.clickCreateButton();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.checkConfirmCreateInvoiceWith0Mount();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.confirmCreateInvoiceAmout0();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.confirmSetFirstInvoiceNumber();
        validateHelpers.waitForLoadJs();
        createSalePage.checkInvoiceAfterClickCreateButton();
        validateHelpers.waitForLoadJs();
        validateHelpers.logout();
    }

    @Test(priority = 3)
    @Parameters({"language"})
    public void createInvoiceWithAnotherReceiptLanguageChoseCustomerFirst_then_createSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        salePage.gtoSaleViaShortCut();
        validateHelpers.waitForLoadJs();
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getStandard(language));
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.selectCustomer(TranslationHelpers.setFile(language, "$.invoicesCommon.dialog.createEditContact.text.language"));
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.checkConfirmChangeCurrencyDialog();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.cancelChangeCurrency();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.changeLanguageOfCustomerOnInvoiceCreatePage();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.selectProduct();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.changeProductPriceOtherThan0();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.clickCreateButton();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.checkConfirmCreateInvoiceWith0Mount();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.confirmCreateInvoiceAmout0();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.confirmSetFirstInvoiceNumber();
        validateHelpers.waitForLoadJs();
        createSalePage.checkInvoiceAfterClickCreateButton();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();

    }

    @Test(priority = 3)
    @Parameters({"language"})
    public void createInvoiceWithAnotherReceiptLanguage_then_createSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        salePage.gtoSaleViaShortCut();
        validateHelpers.waitForLoadJs();
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getStandard(language));
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.selectCustomer(TranslationHelpers.setFile(language, "$.invoicesCommon.dialog.createEditContact.text.language"));
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.checkConfirmChangeCurrencyDialog();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.cancelChangeCurrency();
        createSalePage.changeLanguageOfCustomerOnInvoiceCreatePage();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.selectProduct();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.changeProductPriceOtherThan0();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.clickCreateButton();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.checkConfirmCreateInvoiceWith0Mount();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.confirmCreateInvoiceAmout0();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.confirmSetFirstInvoiceNumber();
        validateHelpers.waitForLoadJs();
        createSalePage.checkInvoiceAfterClickCreateButton();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();

    }

    @Test(priority = 3)
    @Parameters({"language"})
    public void createInvoiceWithChangePriceOfProduct_then_createSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        salePage.gtoSaleViaShortCut();
        validateHelpers.waitForLoadJs();
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getStandard(language));
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.selectCustomer(TranslationHelpers.setFile(language, "$.invoicesCommon.dialog.createEditContact.text.language"));
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.checkConfirmChangeCurrencyDialog();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.cancelChangeCurrency();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.selectProduct();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.changeProductPriceRandomPrice();
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

    @Test(priority = 3)
    @Parameters({"language"})
    public void createInvoiceWithManyProduct_then_createSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        salePage.gtoSaleViaShortCut();
        validateHelpers.waitForLoadJs();
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getStandard(language));
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

    @Test(priority = 3)
    @Parameters({"language"})
    public void createInvoiceWithManyProductsAndChangeAnyProductPrice_then_createSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        salePage.gtoSaleViaShortCut();
        validateHelpers.waitForLoadJs();
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getStandard(language));
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
        createSalePage.changePriceOfAnyProductInProductLines();
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

    @Test(priority = 3)
    @Parameters({"language"})
    public void createInvoiceWithAnProductLineNullWithOutClickOnIt_then_createSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        salePage.gtoSaleViaShortCut();
        validateHelpers.waitForLoadJs();
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getStandard(language));
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.selectCustomer(TranslationHelpers.setFile(language, "$.invoicesCommon.dialog.createEditContact.text.language"));
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.checkConfirmChangeCurrencyDialog();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.cancelChangeCurrency();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.selectProduct();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.addAProductLineIntoProductSection();
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

    @Test(priority = 3)
    @Parameters({"language"})
    public void createInvoiceWithUpdateQuantityOfProduct_then_createSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        salePage.gtoSaleViaShortCut();
        validateHelpers.waitForLoadJs();
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getStandard(language));
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.selectCustomer(TranslationHelpers.setFile(language, "$.invoicesCommon.dialog.createEditContact.text.language"));
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.checkConfirmChangeCurrencyDialog();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.cancelChangeCurrency();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.selectProduct();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.updateQuantityOfProduct();
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

    @Test(priority = 3)
    @Parameters({"language"})
    public void createInvoiceWithUpdateQuantityOfManyProducts_then_createSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        salePage.gtoSaleViaShortCut();
        validateHelpers.waitForLoadJs();
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getStandard(language));
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
        createSalePage.updateQuantityAllProduct();
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

    @Test(priority = 3)
    @Parameters({"language"})
    public void createInvoiceWithUpdateQuantityOfAnyProducts_then_createSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        salePage.gtoSaleViaShortCut();
        validateHelpers.waitForLoadJs();
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getStandard(language));
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
        createSalePage.updateQuantityOfAnyProduct();
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

    @Test(priority = 3)
    @Parameters({"language"})
    public void createInvoiceWithUpdateDiscountOfProduct_then_createSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        salePage.gtoSaleViaShortCut();
        validateHelpers.waitForLoadJs();
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getStandard(language));
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.selectCustomer(TranslationHelpers.setFile(language, "$.invoicesCommon.dialog.createEditContact.text.language"));
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.checkConfirmChangeCurrencyDialog();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.cancelChangeCurrency();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.selectProduct();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.updateDiscountOfProductOnProductLine();
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

    @Test(priority = 3)
    @Parameters({"language"})
    public void createInvoiceWithUpdateDiscountOfAnyProduct_then_createSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        salePage.gtoSaleViaShortCut();
        validateHelpers.waitForLoadJs();
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getStandard(language));
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
        createSalePage.updateDiscountOfProductOnProductLine();
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

    @Test(priority = 3)
    @Parameters({"language"})
    public void createInvoiceWithUpdateDiscountOfAllProducts_then_createSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        salePage.gtoSaleViaShortCut();
        validateHelpers.waitForLoadJs();
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getStandard(language));
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

    @Test(priority = 3)
    @Parameters({"language"})
    public void createInvoiceWithProductOnPopularProductSection_then_createSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        salePage.gtoSaleViaShortCut();
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
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        salePage.gtoSaleViaShortCut();
        validateHelpers.waitForLoadJs();
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getStandard(language));
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.selectCustomer(TranslationHelpers.setFile(language, "$.invoicesCommon.dialog.createEditContact.text.language"));
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.checkConfirmChangeCurrencyDialog();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.cancelChangeCurrency();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.selectProduct();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.addCommentOnInvoice();
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
    public void createInvoiceAttachmentImage_then_createSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        salePage.gtoSaleViaShortCut();
        validateHelpers.waitForLoadJs();
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getStandard(language));
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.selectCustomer(TranslationHelpers.setFile(language, "$.invoicesCommon.dialog.createEditContact.text.language"));
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.checkConfirmChangeCurrencyDialog();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.cancelChangeCurrency();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.selectProduct();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.attachmentImage();
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
    public void createInvoiceAttachmentImageAndAddComment_then_createSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        salePage.gtoSaleViaShortCut();
        validateHelpers.waitForLoadJs();
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getStandard(language));
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.selectCustomer(TranslationHelpers.setFile(language, "$.invoicesCommon.dialog.createEditContact.text.language"));
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.checkConfirmChangeCurrencyDialog();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.cancelChangeCurrency();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.selectProduct();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.addCommentOnInvoice();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.attachmentImage();
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

    @Test(priority = 5)
    @Parameters({"language"})
    public void createInvoiceWithManyFees_then_createSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        salePage.gtoSaleViaShortCut();
        validateHelpers.waitForLoadJs();
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getStandard(language));
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.selectCustomer(TranslationHelpers.setFile(language, "$.invoicesCommon.dialog.createEditContact.text.language"));
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.checkConfirmChangeCurrencyDialog();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.cancelChangeCurrency();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.selectProduct();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.addManyFeeLineOnFeeSection();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.fillAllFeesOnFeeSection();
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

    @Test(priority = 5)
    @Parameters({"language"})
    public void createInvoiceAmoutFeeHasBeenUpdate_then_createSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        salePage.gtoSaleViaShortCut();
        validateHelpers.waitForLoadJs();
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getStandard(language));
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
        createSalePage.updateAmountOfFee();
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

    @Test(priority = 5)
    @Parameters({"language"})
    public void createInvoiceWithManyFeeAndManyProduct_then_createSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        salePage.gtoSaleViaShortCut();
        validateHelpers.waitForLoadJs();
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getStandard(language));
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.selectCustomer(TranslationHelpers.setFile(language, "$.invoicesCommon.dialog.createEditContact.text.language"));
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.checkConfirmChangeCurrencyDialog();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.cancelChangeCurrency();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.addAProductLineIntoProductSection();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.fillProductIntoProductlines();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.addManyFeeLineOnFeeSection();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.fillAllFeesOnFeeSection();
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

}
