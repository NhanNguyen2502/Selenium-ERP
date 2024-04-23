package erp.testcases.UpdatePaymentAccount.RealCompany;

import erp.base.BaseSetup;
import erp.base.ReportListener;
import erp.common.helpers.ValidateHelpers;
import erp.pages.PaymentAccountPage.UpdatePaymentAccount;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

@Listeners(ReportListener.class)
public class UpdatePaymentServiceTest extends BaseSetup {
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
        updatePaymentAccount.selectPaymentAccountToUpdateByType(language, "Payment service");
        updatePaymentAccount.updatePaymentAccountName();
        updatePaymentAccount.saveSuccessAfterClickOnSaveButton();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void updatePaymentAccountNameAndOpeningBalance_then_updateSuccess(@Optional("English") String language) {
        updatePaymentAccount.loginAndGoToPaymentAccountTable(language);
        updatePaymentAccount.selectPaymentAccountToUpdateByType(language, "Payment service");
        updatePaymentAccount.updatePaymentAccountName();
        updatePaymentAccount.updateOpeningBalance();
        updatePaymentAccount.saveSuccessAfterClickOnSaveButton();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void updatePaymentAccountNumber_then_updateSuccess(@Optional("English") String language) {
        updatePaymentAccount.loginAndGoToPaymentAccountTable(language);
        updatePaymentAccount.updatePaymentAccountNumber(language, "Payment service");
        updatePaymentAccount.saveSuccessAfterClickOnSaveButton();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void updateNameAccountNumberAndOpeningBalance_then_updateSuccess(@Optional("English") String language) {
        updatePaymentAccount.loginAndGoToPaymentAccountTable(language);
        updatePaymentAccount.selectPaymentAccountToUpdateByType(language, "Payment service");
        updatePaymentAccount.updatePaymentAccountName();
        updatePaymentAccount.updateAccountNumber(language);
        updatePaymentAccount.updateOpeningBalance();
        updatePaymentAccount.saveSuccessAfterClickOnSaveButton();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void updateDeletePaymentAccountWithConfirm_then_updateSuccess(@Optional("English") String language) {
        updatePaymentAccount.loginAndGoToPaymentAccountTable(language);
        updatePaymentAccount.deletePaymentAccountWithConfirm(language, "Payment service");
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void updateDisablePaymentAccountWithConfirm_then_updateSuccess(@Optional("English") String language) {
        updatePaymentAccount.loginAndGoToPaymentAccountTable(language);
        updatePaymentAccount.disablePaymentAccountWithConfirm(language, "Payment service");
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void updateDisablePaymentAccountWithCancel_then_updateSuccess(@Optional("English") String language) {
        updatePaymentAccount.loginAndGoToPaymentAccountTable(language);
        updatePaymentAccount.disablePaymentAccountWithCancel(language, "Payment service");
        validateHelpers.logout();
    }

    @Test(priority = 2)
    @Parameters({"language"})
    public void updateEnablePaymentAccountWithConfirm_then_updateSuccess(@Optional("English") String language) {
        updatePaymentAccount.loginAndGoToPaymentAccountTable(language);
        updatePaymentAccount.enablePaymentAccountWithConfirm(language, "Payment service");
        validateHelpers.logout();
    }
}
