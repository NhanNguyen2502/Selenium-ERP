package erp.pages;

import erp.common.helpers.PropertiesHelper;
import erp.common.helpers.TranslationHelpers;
import erp.common.helpers.ValidateHelpers;
import io.qameta.allure.Step;
import org.apache.commons.collections.map.HashedMap;
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
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SignInPage {
    private WebDriver driver = null;
    private WebDriverWait wait = null;
    private final int timeout = 20;
    //private By headerText = By.xpath("//h1[text()='Welcome']");
    @FindBy(xpath = ("//h1[@id='kc-page-title']"))
    private WebElement headerText;
    private By formtitle = By.xpath("//h1[@id='kc-page-title']");
    private By usernameTextBox = By.xpath("//input[@id='username']");
    private By passwordTextBox = By.xpath("//input[@id='password']");
    private By loginButton = By.xpath("//div[@id='kc-form-buttons']");
    private By logoAccountia = By.xpath("//a[@id='kc-app-logo']");
    private By forgetPassword = By.xpath("//a[text()=' Forgot your password? ']");
    private By signUpText = By.xpath("//span[text()=' Sign up ']");
    private By usernameRequied = By.xpath("//span[@id='input-error-email-required']");
    private By userInvalidInform = By.xpath("//div[@data-cy='usernamePatternErrorMessage']");
    private By passwordRequied = By.xpath("//span[@id='input-error-password-required']");
    private By wrongUsernameOrPass = By.xpath("//span[@id='input-error']");
    private By resendEmailContent = By.xpath("(//p[@class='instruction'])[1]");
    private By resendTitle = By.xpath("//h1[@id='kc-page-title']");
    private By warningContent = By.xpath("//div[@class='alert-warning pf-c-alert pf-m-inline pf-m-warning']//span");
    private By cancleButtonResendDialog = By.xpath("//button[@data-cy='dialog-cancel-button']");
    private By closeResendDialog = By.xpath("//button[@data-cy='dialog-close-button']");
    private By resnedEmailButton = By.xpath("//button[@data-cy='dialog-resend-button']");
    private By languageButton = By.xpath("//button[@id='kc-chevron-btn']");
    private By languageOptions = By.xpath("//li//div//a[@id='kc-locale-option']");
    private By signinButton = By.xpath("//div[@id='kc-back-to-sign-in']//span");
    public ValidateHelpers validateHelpers;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        validateHelpers = new ValidateHelpers(driver);
        PageFactory.initElements(driver, this);
    }

    public void verifylanguage(String language) {
        validateHelpers.waitForLoadJs();
        validateHelpers.clickElement(languageButton);
        validateHelpers.waitForLoadJs();
        var options = driver.findElements(languageOptions);
        String key = "$.languageSelect.option.english";
        switch (language) {
            case "English" -> key = "$.languageSelect.option.english";
            case "Arabic" -> key = "$.languageSelect.option.arabic";
            case "Kurdish - Badini" -> key = "$.languageSelect.option.badini";
            case "Kurdish - Sorani" -> key = "$.languageSelect.option.sorani";
            default -> System.out.println("default");
        }
        for (WebElement o : options) {
            if (o.getText().contains(language) || o.getText().contains(TranslationHelpers.setFile(language, key))) {
                System.out.println("Test with language: "+ language);
                o.click();
                break;
            }
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

    @Step("verify email null")
    public String verifyEmailnull()  {

        validateHelpers.setText(usernameTextBox, "");
        validateHelpers.clickOutside();
        validateHelpers.waitForLoadJs();
        return driver.findElement(usernameRequied).getText();

    }

    public String verifyPasswordNUll() throws Exception {

        validateHelpers.setText(passwordTextBox, "");
        validateHelpers.clickElement(formtitle);
        Thread.sleep(1000);
        return driver.findElement(passwordRequied).getText();
    }

    public String verifyWrongEmailOrPassword(String Email, String Password) throws Exception {
        validateHelpers.setText(usernameTextBox, Email);
        validateHelpers.setText(passwordTextBox, Password);
        validateHelpers.clickElement(loginButton);
        Thread.sleep(1000);
        return validateHelpers.getMessage(wrongUsernameOrPass);
    }

    public void verifyAccountInactive(String email, String Pass, String resendmailTitle, String warContent, String explainContent) {
        validateHelpers.setText(usernameTextBox, email);
        validateHelpers.setText(passwordTextBox, Pass);
        validateHelpers.clickElement(loginButton);
        waitForPageLoaded();
        Assert.assertEquals(validateHelpers.getMessage(resendTitle), resendmailTitle);
        Assert.assertEquals(validateHelpers.getMessage(warningContent), warContent);
        Map<String, String> data = new HashMap<>();
        data.put("email", email);
        Assert.assertEquals(
                validateHelpers.removeHtmlTags(validateHelpers.getMessage(resendEmailContent)),
                validateHelpers.removeHtmlTags(TranslationHelpers.getContent(explainContent, data)), "Wrong here"
        );
        validateHelpers.clickElement(signinButton);
        //Assert.assertTrue(validateHelpers.checkDisplayed(cancleButtonResendDialog), "The cancel button doesn't display!");
        //Assert.assertTrue(validateHelpers.checkDisplayed(resnedEmailButton), "The resend button doesn't display!");
        //Assert.assertTrue(validateHelpers.checkDisplayed(closeResendDialog), "The close button not display!");
        //validateHelpers.clickElement(logoAccountia);
    }

    public CreateCompanyPage signinWithCreateCompany(String email, String password) {
        validateHelpers.setText(usernameTextBox, email);
        validateHelpers.setText(passwordTextBox, password);
        validateHelpers.clickElement(loginButton);
        return new CreateCompanyPage(driver);
    }


    public void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
                        .equals("complete");
            }
        };
        try {
            Thread.sleep(10000);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }
}
