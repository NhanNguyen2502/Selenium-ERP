package erp.testcases.CreatePaymentAccount.RealCompany;

import erp.base.BaseSetup;
import erp.base.ReportListener;
import erp.common.helpers.GetTypeOfCompanyHelper;
import erp.common.helpers.PropertiesHelper;
import erp.common.helpers.ValidateHelpers;
import erp.pages.CompanyListPage;
import erp.pages.PaymentAccountPage.CreatePaymentAccount;
import erp.pages.SignInPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

@Listeners(ReportListener.class)
public class CreatePaymentAccountWithBankTypeTest extends BaseSetup {
    private WebDriver driver;
    private ValidateHelpers validateHelpers;
    private SignInPage signInPage;
    private CreatePaymentAccount createPaymentAccount;
    private CompanyListPage companyListPage;

    @BeforeClass
    public void setup() {
        this.driver = getDriver();
        validateHelpers = new ValidateHelpers(driver);
        signInPage = new SignInPage(driver);
        createPaymentAccount = new CreatePaymentAccount(driver);
        companyListPage = new CompanyListPage(driver);
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void createBankAccountWithValidInformation_then_createSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        createPaymentAccount.goToPaymentTable();
        validateHelpers.waitForLoadJs();
        createPaymentAccount.goToCreatePaymentAccountPage();
        validateHelpers.waitForLoadJs();
        createPaymentAccount.enterPaymentName();
        validateHelpers.waitAfterChoseOrClickElement();
        createPaymentAccount.enterAccountNumber();
        validateHelpers.waitAfterChoseOrClickElement();
        createPaymentAccount.clickOnCreateButton();
        validateHelpers.waitForLoadJs();
        createPaymentAccount.verifyCreateSuccess();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void createBankAccountWithNameAndAccountNumberNull_then_createFail(@Optional("English") String language) {
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        createPaymentAccount.goToPaymentTable();
        validateHelpers.waitForLoadJs();
        createPaymentAccount.goToCreatePaymentAccountPage();
        validateHelpers.waitForLoadJsCreatePage();
        createPaymentAccount.clickOnCreateButton();
        validateHelpers.waitAfterChoseOrClickElement();
        createPaymentAccount.checkAccountNameRequired();
        validateHelpers.waitAfterChoseOrClickElement();
        createPaymentAccount.checkAccountNumberRequired();
        validateHelpers.waitAfterChoseOrClickElement();
        createPaymentAccount.verifyFailed();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void createBankAccountWithBalance_then_createSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        createPaymentAccount.goToPaymentTable();
        validateHelpers.waitForLoadJs();
        createPaymentAccount.goToCreatePaymentAccountPage();
        validateHelpers.waitForLoadJsCreatePage();
        createPaymentAccount.enterPaymentName();
        validateHelpers.waitAfterChoseOrClickElement();
        createPaymentAccount.enterAccountNumber();
        validateHelpers.waitAfterChoseOrClickElement();
        createPaymentAccount.enterOpeningBalance();
        createPaymentAccount.clickOnCreateButton();
        validateHelpers.waitAfterChoseOrClickElement();
        createPaymentAccount.checkBalanceDateRequired();
        validateHelpers.waitAfterChoseOrClickElement();
        createPaymentAccount.enterBalanceDate();
        validateHelpers.waitAfterChoseOrClickElement();
        createPaymentAccount.clickOnCreateButton();
        validateHelpers.waitForLoadJs();
        createPaymentAccount.verifyCreateSuccess();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void createBankAccountWithInternational_then_createSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        createPaymentAccount.goToPaymentTable();
        validateHelpers.waitForLoadJs();
        createPaymentAccount.goToCreatePaymentAccountPage();
        validateHelpers.waitForLoadJsCreatePage();
        createPaymentAccount.enterPaymentName();
        validateHelpers.waitAfterChoseOrClickElement();
        createPaymentAccount.enterAccountNumber();
        validateHelpers.waitAfterChoseOrClickElement();
        createPaymentAccount.clickOnInternational();
        createPaymentAccount.clickOnCreateButton();
        validateHelpers.waitForLoadJs();
        createPaymentAccount.verifyCreateSuccess();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void createBankAccountWithInternationalIban_then_createSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        createPaymentAccount.goToPaymentTable();
        validateHelpers.waitForLoadJs();
        createPaymentAccount.goToCreatePaymentAccountPage();
        validateHelpers.waitForLoadJsCreatePage();
        createPaymentAccount.enterPaymentName();
        validateHelpers.waitAfterChoseOrClickElement();
        createPaymentAccount.enterAccountNumber();
        validateHelpers.waitAfterChoseOrClickElement();
        createPaymentAccount.clickOnInternational();
        validateHelpers.waitAfterChoseOrClickElement();
        createPaymentAccount.enterIban();
        validateHelpers.waitAfterChoseOrClickElement();
        createPaymentAccount.clickOnCreateButton();
        validateHelpers.waitForLoadJs();
        createPaymentAccount.verifyCreateSuccess();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void createBankAccountWithInternationalIbanAndSwift_then_createSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        createPaymentAccount.goToPaymentTable();
        validateHelpers.waitForLoadJs();
        createPaymentAccount.goToCreatePaymentAccountPage();
        validateHelpers.waitForLoadJsCreatePage();
        createPaymentAccount.enterPaymentName();
        validateHelpers.waitAfterChoseOrClickElement();
        createPaymentAccount.enterAccountNumber();
        validateHelpers.waitAfterChoseOrClickElement();
        createPaymentAccount.clickOnInternational();
        validateHelpers.waitAfterChoseOrClickElement();
        createPaymentAccount.enterIban();
        validateHelpers.waitAfterChoseOrClickElement();
        createPaymentAccount.enterBicOrSwift();
        validateHelpers.waitAfterChoseOrClickElement();
        createPaymentAccount.clickOnCreateButton();
        validateHelpers.waitForLoadJs();
        createPaymentAccount.verifyCreateSuccess();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }
}
