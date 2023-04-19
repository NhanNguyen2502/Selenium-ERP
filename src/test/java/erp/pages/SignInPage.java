package erp.pages;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import erp.common.helpers.ValidateHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;


public class SignInPage {
    private WebDriver driver = null;
    private WebDriverWait wait = null;
    private final int timeout = 20;
    //private By headerText = By.xpath("//h1[text()='Welcome']");
    @FindBy(xpath = ("//h1[text()='Welcome']"))
    private WebElement headerText;
    private By formtitle = By.xpath("//h1[normalize-space()='Welcome']");
    private By usernameTextBox = By.xpath("//input[@id='mat-input-0']");
    private By passwordTextBox = By.xpath("//input[@data-cy='password']");
    private By loginButton = By.xpath("//span[text()='Sign In']");
    private By logoAccountia = By.xpath("//a[@class='text-decoration-none']");
    private By forgetPassword = By.xpath("//a[text()=' Forgot your password? ']");
    private By signUpText = By.xpath("//span[text()=' Sign up ']");
    private By userInform = By.xpath("//div[@data-cy='usernameRequiredErrorMessage']");
    private By userInvalidInform = By.xpath("//div[@data-cy='usernamePatternErrorMessage']");
    private By passwordInform = By.xpath("//div[@data-cy='passwordErrorMessage']");
    private By wrongUsernameOrPass = By.xpath("//mat-card[@data-cy='errorMessage']");
    private By resendEmailActiveDialog = By.xpath("//app-resend-email-dialog");
    private By resendTitle = By.xpath("//h4[@data-cy='resend-email-title']");
    private By resendContent = By.xpath("//p[@data-cy='resend-email-message']");
    private By cancleButtonResendDialog = By.xpath("//button[@data-cy='dialog-cancel-button']");
    private By closeResendDialog = By.xpath("//button[@data-cy='dialog-close-button']");
    private By resnedEmailButton = By.xpath("//button[@data-cy='dialog-resend-button']");

    public ValidateHelper validateHelper;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        validateHelper = new ValidateHelper(driver);
        PageFactory.initElements(driver, this);
    }


    public boolean verifyForgotPassword() {
        WebElement element = driver.findElement(forgetPassword);
        return element.isDisplayed();
    }

    public boolean verifySignupText() {
        WebElement element = driver.findElement(signUpText);
        return element.isDisplayed();
    }

    public boolean verifyTitle() {
        wait.until(ExpectedConditions.elementToBeClickable(headerText));
        return headerText.getText().contains("Welcome");
    }

    public boolean verifyUsernameTextBox() {
        WebElement element = driver.findElement(usernameTextBox);
        return element.isDisplayed();
    }

    public boolean verifyLogo() {
        WebElement element = driver.findElement(logoAccountia);
        return element.isDisplayed();
    }

    public boolean verifyPasswordTextBox() {
        WebElement element = driver.findElement(passwordTextBox);
        return element.isDisplayed();
    }

    public CompanyListPage login(String Username, String Password) {
        //validateHelper.setText(usernameTextBox, "testdeferp@yopmail.com");
        validateHelper.setText(usernameTextBox, Username);
        validateHelper.setText(passwordTextBox, Password);
        validateHelper.clickElement(loginButton);
        return new CompanyListPage(driver);
    }

    public String verifyEmailnull() throws Exception {

        validateHelper.setText(usernameTextBox, "");
        validateHelper.clickElement(formtitle);
        Thread.sleep(1000);
        return driver.findElement(userInform).getText();

    }

    public String verifyPasswordNUll() throws Exception {

        validateHelper.setText(passwordTextBox, "");
        validateHelper.clickElement(formtitle);
        Thread.sleep(1000);
        return driver.findElement(passwordInform).getText();
    }

    public String verifyWrongEmailOrPassword(String Email, String Password) throws Exception {
        validateHelper.setText(usernameTextBox, Email);
        validateHelper.setText(passwordTextBox, Password);
        validateHelper.clickElement(loginButton);
        Thread.sleep(1000);
        return validateHelper.getMessage(wrongUsernameOrPass);
    }

    public void verifyAccountInactive(String Email, String Pass, String ContentOfInform) {
        validateHelper.setText(usernameTextBox, Email);
        validateHelper.setText(passwordTextBox, Pass);
        validateHelper.clickElement(loginButton);
        wait.until(ExpectedConditions.elementToBeClickable(resendEmailActiveDialog));
        Assert.assertEquals(validateHelper.getMessage(resendTitle), "Email not verified");
        Assert.assertEquals(validateHelper.getMessage(resendContent), ContentOfInform);
        Assert.assertTrue(validateHelper.checkDisplayed(cancleButtonResendDialog),"The cancel button doesn't display!");
        Assert.assertTrue(validateHelper.checkDisplayed(resnedEmailButton),"The resend button doesn't display!");
        Assert.assertTrue(validateHelper.checkDisplayed(closeResendDialog),"The close button not display!");
        validateHelper.clickElement(cancleButtonResendDialog);
    }


    public void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
                        .equals("complete");
            }
        };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }
}
