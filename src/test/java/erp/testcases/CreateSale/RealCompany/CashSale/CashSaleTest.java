package erp.testcases.CreateSale.RealCompany.CashSale;

import erp.base.BaseSetup;
import erp.base.ReportListener;
import erp.common.helpers.*;
import erp.pages.CompanyListPage;
import erp.pages.SalePage.CreateSalePage;
import erp.pages.SalePage.SalePage;
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
    private SalePage salePage;

    @BeforeClass
    public void setup() {
        this.driver = getDriver();
        validateHelpers = new ValidateHelpers(driver);
        signInPage = new SignInPage(driver);
        createSalePage = new CreateSalePage(driver);
        companyListPage = new CompanyListPage(driver);
        salePage = new SalePage(driver);
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void when_createWithAnonymousCustomer_then_createSuccess(@Optional("English") String language) {
        signInPage.waitForPageLoaded();
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        validateHelpers.verifylanguage(language);
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        salePage.gtoSaleViaShortCut();
        validateHelpers.waitForLoadJsCreatePage();
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getCashSale(language));
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.selectEmployee(TranslationHelpers.setFile(language, "$.phoneNumber.error.phoneInvalid"));
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.selectProduct();
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

    @Test(priority = 0)
    @Parameters({"language"})
    public void when_createWithAnonymousCustomerAndManyProducts_then_createSuccess(@Optional("English") String language) {
        signInPage.waitForPageLoaded();
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        validateHelpers.verifylanguage(language);
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        salePage.gtoSaleViaShortCut();
        validateHelpers.waitForLoadJsCreatePage();
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getCashSale(language));
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.selectEmployee(TranslationHelpers.setFile(language, "$.phoneNumber.error.phoneInvalid"));
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
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.skipSetFirstInvoiceNumber();
        validateHelpers.waitForLoadJs();
        createSalePage.checkInvoiceAfterClickCreateButton();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void when_createWithAllInformationCorrect_then_createSuccess(@Optional("English") String language) {
        signInPage.waitForPageLoaded();
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        validateHelpers.verifylanguage(language);
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        salePage.gtoSaleViaShortCut();
        validateHelpers.waitForLoadJsCreatePage();
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getCashSale(language));
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
        createSalePage.clickCreateButton();
        validateHelpers.waitAfterChoseOrClickElement();
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

    @Test(priority = 0)
    @Parameters({"language"})
    public void when_createWithManyProducts_then_createSuccess(@Optional("English") String language) {
        signInPage.waitForPageLoaded();
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        validateHelpers.verifylanguage(language);
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        salePage.gtoSaleViaShortCut();
        validateHelpers.waitForLoadJsCreatePage();
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getCashSale(language));
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
        createSalePage.clickCreateButton();
        validateHelpers.waitAfterChoseOrClickElement();
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

    @Test(priority = 0)
    @Parameters({"language"})
    public void when_createWithManyProductAndUpdateAllQuantity_then_createSuccess(@Optional("English") String language) {
        signInPage.waitForPageLoaded();
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        validateHelpers.verifylanguage(language);
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        salePage.gtoSaleViaShortCut();
        validateHelpers.waitForLoadJsCreatePage();
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getCashSale(language));
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
        createSalePage.updateQuantityAllProduct();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.clickCreateButton();
        validateHelpers.waitAfterChoseOrClickElement();
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

    @Test(priority = 0)
    @Parameters({"language"})
    public void when_createWithUpdateQuantity_then_createSuccess(@Optional("English") String language) {
        signInPage.waitForPageLoaded();
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        validateHelpers.verifylanguage(language);
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        salePage.gtoSaleViaShortCut();
        validateHelpers.waitForLoadJsCreatePage();
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getCashSale(language));
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
        createSalePage.updateQuantityOfProduct();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.clickCreateButton();
        validateHelpers.waitAfterChoseOrClickElement();
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

    @Test(priority = 0)
    @Parameters({"language"})
    public void when_createWithUpdateDiscount_then_createSuccess(@Optional("English") String language) {
        signInPage.waitForPageLoaded();
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        validateHelpers.verifylanguage(language);
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        salePage.gtoSaleViaShortCut();
        validateHelpers.waitForLoadJsCreatePage();
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getCashSale(language));
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
        createSalePage.updateDiscountOfProductOnProductLine();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.clickCreateButton();
        validateHelpers.waitAfterChoseOrClickElement();
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

    @Test(priority = 0)
    @Parameters({"language"})
    public void when_createWithManyProductAndUpdateAllDiscount_then_createSuccess(@Optional("English") String language) {
        signInPage.waitForPageLoaded();
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        validateHelpers.verifylanguage(language);
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        salePage.gtoSaleViaShortCut();
        validateHelpers.waitForLoadJsCreatePage();
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getCashSale(language));
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
        createSalePage.clickCreateButton();
        validateHelpers.waitAfterChoseOrClickElement();
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

    @Test(priority = 0)
    @Parameters({"language"})
    public void when_createWithManyProductAndUpdateDiscountOfProduct_then_createSuccess(@Optional("English") String language) {
        signInPage.waitForPageLoaded();
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        validateHelpers.verifylanguage(language);
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        salePage.gtoSaleViaShortCut();
        validateHelpers.waitForLoadJsCreatePage();
        createSalePage.selectSaleType(GetKeyOfSaleTypeByLanguageHelpers.getCashSale(language));
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
        createSalePage.updateDiscountOfProductOnProductLine();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.clickCreateButton();
        validateHelpers.waitAfterChoseOrClickElement();
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
}
