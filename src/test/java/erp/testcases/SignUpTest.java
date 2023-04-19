package erp.testcases;

import erp.base.BaseSetup;
import erp.pages.SignUpPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SignUpTest extends BaseSetup {
    private WebDriver driver;
    public SignUpPage signUpPage;

    @BeforeClass
    public void setup() {
        this.driver = getDriver();
    }

    @Test(priority = 1)
    public void signUpPage() {
        signUpPage = new SignUpPage(driver);
        signUpPage.goToSignUpPage();
        signUpPage.waitForPageLoaded();
        signUpPage.verifyAllElements();
        signUpPage.verifyEyeOpen();
    }

    @Test(priority = 2)
    public void generatePassword() throws InterruptedException {
        signUpPage.verifyGeneratePassword();
    }
}
