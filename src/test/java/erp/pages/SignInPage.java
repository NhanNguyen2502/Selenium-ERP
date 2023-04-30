package erp.pages;

import erp.common.helpers.TranslationHelpers;
import erp.common.helpers.ValidateHelpers;
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
import java.util.List;


public class SignInPage {
    private WebDriver driver = null;
    private WebDriverWait wait = null;
    private final int timeout = 20;
    //private By headerText = By.xpath("//h1[text()='Welcome']");
    @FindBy(xpath = ("//h1[@data-cy='formTitle']"))
    private WebElement headerText;
    private By formtitle = By.xpath("//h1[@data-cy='formTitle']");
    private By usernameTextBox = By.xpath("//input[@id='mat-input-0']");
    private By passwordTextBox = By.xpath("//input[@data-cy='password']");
    private By loginButton = By.xpath("//button[@data-cy='linkToDashboard']");
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
    private By languageButton = By.xpath("//app-language-option[@class='ng-tns-c166-1 ng-star-inserted']//button[@id='language-option-btn']");
    private By languageOptions = By.xpath("//div[@data-cy='language-option-item']");

    public ValidateHelpers validateHelpers;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        validateHelpers = new ValidateHelpers(driver);
        PageFactory.initElements(driver, this);
    }

    public void verifylanguage(String language) {
        switch (language) {
            case "english":
                System.out.println("Language is english");
                break;
            case "Arabic": {
                validateHelpers.clickElement(languageButton);
                wait.until(ExpectedConditions.elementToBeClickable(languageOptions));
                List<WebElement> options = driver.findElements(languageOptions);
                for (WebElement o : options) {
                    if (o.getText().contains("Arabic")) {
                        System.out.println(o.getText());
                        o.click();
                    }
                }
            }
            break;
            case "Kurdish - Badini": {
                validateHelpers.clickElement(languageButton);
                wait.until(ExpectedConditions.elementToBeClickable(languageOptions));
                List<WebElement> options = driver.findElements(languageOptions);
                for (WebElement o : options) {
                    if (o.getText().contains("Kurdish - Badini")) {
                        System.out.println(o.getText());
                        o.click();
                    }
                }
            }
            break;
            case "Kurdish - Sorani": {
                validateHelpers.clickElement(languageButton);
                wait.until(ExpectedConditions.elementToBeClickable(languageOptions));
                List<WebElement> options = driver.findElements(languageOptions);
                for (WebElement o : options) {
                    if (o.getText().contains("Kurdish - Sorani")) {
                        System.out.println(o.getText());
                        o.click();
                    }
                }
            }
            break;
            default:
                System.out.println("default");

        }
    }


    public boolean verifyForgotPassword() {
        WebElement element = driver.findElement(forgetPassword);
        return element.isDisplayed();
    }

    public boolean verifySignupText() {
        WebElement element = driver.findElement(signUpText);
        return element.isDisplayed();
    }

    public boolean verifyTitle(String content) {
        wait.until(ExpectedConditions.elementToBeClickable(headerText));
        return headerText.getText().contains(content);
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
        validateHelpers.setText(usernameTextBox, Username);
        validateHelpers.setText(passwordTextBox, Password);
        validateHelpers.clickElement(loginButton);
        return new CompanyListPage(driver);
    }

    public String verifyEmailnull() throws Exception {

        validateHelpers.setText(usernameTextBox, "");
        validateHelpers.clickElement(formtitle);
        Thread.sleep(1000);
        return driver.findElement(userInform).getText();

    }

    public String verifyPasswordNUll() throws Exception {

        validateHelpers.setText(passwordTextBox, "");
        validateHelpers.clickElement(formtitle);
        Thread.sleep(1000);
        return driver.findElement(passwordInform).getText();
    }

    public String verifyWrongEmailOrPassword(String Email, String Password) throws Exception {
        validateHelpers.setText(usernameTextBox, Email);
        validateHelpers.setText(passwordTextBox, Password);
        validateHelpers.clickElement(loginButton);
        Thread.sleep(1000);
        return validateHelpers.getMessage(wrongUsernameOrPass);
    }

    public void verifyAccountInactive(String Email, String Pass, String ContentOfInform, String language) {
        validateHelpers.setText(usernameTextBox, Email);
        validateHelpers.setText(passwordTextBox, Pass);
        validateHelpers.clickElement(loginButton);
        wait.until(ExpectedConditions.elementToBeClickable(resendEmailActiveDialog));
        Assert.assertEquals(validateHelpers.getMessage(resendTitle), TranslationHelpers.setFile(language, "$.auth.resendVerificationEmail.text.header"));
        Assert.assertEquals(validateHelpers.getMessage(resendContent), ContentOfInform);
        Assert.assertTrue(validateHelpers.checkDisplayed(cancleButtonResendDialog), "The cancel button doesn't display!");
        Assert.assertTrue(validateHelpers.checkDisplayed(resnedEmailButton), "The resend button doesn't display!");
        Assert.assertTrue(validateHelpers.checkDisplayed(closeResendDialog), "The close button not display!");
        validateHelpers.clickElement(cancleButtonResendDialog);
    }

    public  CreateCompanyPage signinWithCreateCompany(String email, String password){
        validateHelpers.setText(usernameTextBox, email);
        validateHelpers.setText(passwordTextBox, password);
        validateHelpers.clickElement(loginButton);
        return  new CreateCompanyPage(driver);
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
