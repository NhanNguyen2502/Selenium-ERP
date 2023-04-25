package erp.testcases;

import erp.base.BaseSetup;
import erp.common.helpers.PropertiesHelper;
import erp.pages.SignInPage;
import erp.pages.SignUpPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SignUpTest extends BaseSetup {
    private WebDriver driver;
    public SignUpPage signUpPage;
    public SignInPage signInPage;

    @BeforeClass
    public void setup() {
        this.driver = getDriver();
        signInPage = new SignInPage(driver);
        signUpPage = new SignUpPage(driver);
        signInPage.verifylanguage(PropertiesHelper.getValue("language"));
        signUpPage.goToSignUpPage();
    }

    @Test(priority = 1)
    public void signUpPage() {
        signUpPage.waitForPageLoaded();
        signUpPage.verifyEyeOpen();
    }

    @Test(priority = 2)
    public void generatePassword() throws InterruptedException {
        signUpPage.verifyGeneratePassword();
    }
}
