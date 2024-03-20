package erp.testcases.CreatePaymentAccount.RealCompany;

import erp.base.BaseSetup;
import erp.common.helpers.GetTypeOfCompanyHelper;
import erp.common.helpers.GetTypeOfPaymentAccountHelper;
import erp.common.helpers.PropertiesHelper;
import erp.common.helpers.ValidateHelpers;
import erp.pages.CompanyListPage;
import erp.pages.CreatePaymentAccount;
import erp.pages.SignInPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CreatePaymentAccountWithPaymentServiceType extends BaseSetup {
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
        createPaymentAccount.selectTypeOfPaymentAccount(GetTypeOfPaymentAccountHelper.getPaymentServiceType(language));
        validateHelpers.waitAfterChoseOrClickElement();
        createPaymentAccount.enterPaymentName();
        validateHelpers.waitAfterChoseOrClickElement();
        createPaymentAccount.selectRandomPaymentServiceOption();
        validateHelpers.waitAfterChoseOrClickElement();
        createPaymentAccount.enterAccountNumber();
        validateHelpers.waitAfterChoseOrClickElement();
        createPaymentAccount.clickOnCreateButton();
        validateHelpers.waitForLoadJs();
        createPaymentAccount.verifyCreateSuccess();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

}
