package erp.testcases.CreateSale.RealCompany.InstallmentInvoice;

import erp.base.BaseSetup;
import erp.base.ReportListener;
import erp.common.helpers.*;
import erp.pages.CompanyListPage;
import erp.pages.DashBoardPage;
import erp.pages.SalePage.CreateSalePage;
import erp.pages.SalePage.SalePage;
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
    public void when_createWithAllInformationCorrect_then_createSuccess(@Optional("English") String language) {
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
    public void when_createWithPeriodWeekly_then_createSuccess(@Optional("English") String language) {
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
        createSalePage.changeInstalmentPeriod(GetPeriodForInstalmentInvoice.getWekkly(language));
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
    public void when_createWithPeriodQuarterly_then_createSuccess(@Optional("English") String language) {
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
        createSalePage.changeInstalmentPeriod(GetPeriodForInstalmentInvoice.getQuarterly(language));
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
    public void when_createWithPeriodYearly_then_createSuccess(@Optional("English") String language) {
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
        createSalePage.changeInstalmentPeriod(GetPeriodForInstalmentInvoice.getYearly(language));
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
    public void when_createWithAddPrePayment_then_createSuccess(@Optional("English") String language) {
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
        createSalePage.addPrePayment();
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
    public void when_createWithOutFee_then_createSuccess(@Optional("English") String language) {
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

    @Test(priority = 1)
    @Parameters({"language"})
    public void when_createWithoutCustomer_then_createFail(@Optional("English") String language) {
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
        createSalePage.checkConfirmChangeCurrencyDialog();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.cancelChangeCurrency();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.selectProduct();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.selectFee();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.addInstallmentPlan();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.clickCreateButton();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.checkInvoiceAfterClickCreateButton_Failed();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

    @Test(priority = 1)
    @Parameters({"language"})
    public void when_createWithoutProduct_then_createFail(@Optional("English") String language) {
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
        createSalePage.selectFee();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.clickCreateButton();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.checkInvoiceAfterClickCreateButton_Failed();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

    @Test(priority = 1)
    @Parameters({"language"})
    public void when_createWithoutInstalmentPlan_then_createFail(@Optional("English") String language) {
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
        createSalePage.clickCreateButton();
        validateHelpers.waitAfterChoseOrClickElement();
        createSalePage.checkInvoiceAfterClickCreateButton_Failed();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }
}
