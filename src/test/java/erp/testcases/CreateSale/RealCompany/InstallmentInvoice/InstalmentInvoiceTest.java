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
        validateHelpers.waitForLoadJs();
//        createSalePage.clickCreateButton();
//        validateHelpers.waitAfterChoseOrClickElement();
//        createSalePage.checkConfirmCreateInvoiceWith0Mount();
//        validateHelpers.waitAfterChoseOrClickElement();
//        createSalePage.confirmCreateInvoiceAmout0();
//        validateHelpers.waitAfterChoseOrClickElement();
//        createSalePage.skipSetFirstInvoiceNumber();
//        validateHelpers.waitForLoadJs();
//        createSalePage.checkInvoiceAfterClickCreateButton();
//        validateHelpers.waitAfterChoseOrClickElement();
//        validateHelpers.logout();
    }
}
