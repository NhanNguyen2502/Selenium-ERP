package erp.testcases.UpdatePaymentAccount.RealCompany;

import erp.base.BaseSetup;
import erp.base.ReportListener;
import erp.common.helpers.ValidateHelpers;
import erp.pages.PaymentAccountPage.UpdatePaymentAccount;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

@Listeners(ReportListener.class)
public class UpdateBankTest extends BaseSetup {

    private WebDriver driver;
    private UpdatePaymentAccount updatePaymentAccount;
    private ValidateHelpers validateHelpers;


    @BeforeClass
    public void setup() {
        this.driver = getDriver();
        updatePaymentAccount = new UpdatePaymentAccount(driver);
        validateHelpers = new ValidateHelpers(driver);
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void updatePaymentAccountName_then_updateSuccess(@Optional("English") String language) {
        updatePaymentAccount.loginAndGoToPaymentAccountTable(language);
        updatePaymentAccount.selectPaymentAccountToUpdateByType(language, "Bank");
        updatePaymentAccount.updatePaymentAccountName();
        updatePaymentAccount.saveSuccessAfterClickOnSaveButton();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void updatePaymentAccountNameAndOpeningBalance_then_updateSuccess(@Optional("English") String language) {
        updatePaymentAccount.loginAndGoToPaymentAccountTable(language);
        updatePaymentAccount.selectPaymentAccountToUpdateByType(language, "Bank");
        updatePaymentAccount.updatePaymentAccountName();
        updatePaymentAccount.updateOpeningBalance();
        updatePaymentAccount.saveSuccessAfterClickOnSaveButton();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void updateDeletePaymentAccountWithConfirm_then_updateSuccess(@Optional("English") String language) {
        updatePaymentAccount.loginAndGoToPaymentAccountTable(language);
        updatePaymentAccount.deletePaymentAccountWithConfirm(language, "Bank");
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void updateDisablePaymentAccountWithConfirm_then_updateSuccess(@Optional("English") String language) {
        updatePaymentAccount.loginAndGoToPaymentAccountTable(language);
        updatePaymentAccount.disablePaymentAccountWithConfirm(language, "Bank");
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void updateDisablePaymentAccountWithCancel_then_updateSuccess(@Optional("English") String language) {
        updatePaymentAccount.loginAndGoToPaymentAccountTable(language);
        updatePaymentAccount.disablePaymentAccountWithCancel(language, "Bank");
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void updateIbanOfPaymentAccount_then_updateSuccess(@Optional("English") String language) {
        updatePaymentAccount.loginAndGoToPaymentAccountTable(language);
        updatePaymentAccount.updateIbanOfPaymentAccount(language, "Bank");
        updatePaymentAccount.saveSuccessAfterClickOnSaveButton();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void updateSwiftBicOfPaymentAccount_then_updateSuccess(@Optional("English") String language) {
        updatePaymentAccount.loginAndGoToPaymentAccountTable(language);
        updatePaymentAccount.updateSwiftBicOfPaymentAccount(language, "Bank");
        updatePaymentAccount.saveSuccessAfterClickOnSaveButton();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void updateSwiftBicAndIBanOfPaymentAccount_then_updateSuccess(@Optional("English") String language) {
        updatePaymentAccount.loginAndGoToPaymentAccountTable(language);
        updatePaymentAccount.updateSwiftIbanOfPaymentAccount(language, "Bank");
        updatePaymentAccount.saveSuccessAfterClickOnSaveButton();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void updatePaymentAccountNumber_then_updateSuccess(@Optional("English") String language) {
        updatePaymentAccount.loginAndGoToPaymentAccountTable(language);
        updatePaymentAccount.updatePaymentAccountNumber(language, "Bank");
        updatePaymentAccount.saveSuccessAfterClickOnSaveButton();
        validateHelpers.logout();
    }
    @Test(priority = 0)
    @Parameters({"language"})
    public void updateNameAccountNumberAndOpeningBalance_then_updateSuccess(@Optional("English") String language) {
        updatePaymentAccount.loginAndGoToPaymentAccountTable(language);
        updatePaymentAccount.selectPaymentAccountToUpdateByType(language, "Bank");
        updatePaymentAccount.updatePaymentAccountName();
        updatePaymentAccount.updateAccountNumber(language);
        updatePaymentAccount.updateOpeningBalance();
        updatePaymentAccount.saveSuccessAfterClickOnSaveButton();
        validateHelpers.logout();
    }

    @Test(priority = 2)
    @Parameters({"language"})
    public void updateEnablePaymentAccountWithConfirm_then_updateSuccess(@Optional("English") String language) {
        updatePaymentAccount.loginAndGoToPaymentAccountTable(language);
        updatePaymentAccount.enablePaymentAccountWithConfirm(language, "Bank");
        validateHelpers.logout();
    }
}
