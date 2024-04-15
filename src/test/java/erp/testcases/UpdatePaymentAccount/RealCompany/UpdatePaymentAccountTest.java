package erp.testcases.UpdatePaymentAccount.RealCompany;

import erp.base.BaseSetup;
import erp.common.helpers.ValidateHelpers;
import erp.pages.PaymentAccountPage.UpdatePaymentAccount;
import org.apache.logging.log4j.core.tools.picocli.CommandLine;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class UpdatePaymentAccountTest extends BaseSetup {

    private WebDriver driver;
    private UpdatePaymentAccount updatePaymentAccount;
    private ValidateHelpers validateHelpers;

    @BeforeClass
    public void setup()
    {
        this.driver = getDriver();
        updatePaymentAccount = new UpdatePaymentAccount(driver);
        validateHelpers = new ValidateHelpers(driver);
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void a (@Optional("English") String language)
    {
        updatePaymentAccount.loginAndGoToPaymentAccountTable(language);
        updatePaymentAccount.selectRandomPaymentAccountToUpdate();
    }
}
