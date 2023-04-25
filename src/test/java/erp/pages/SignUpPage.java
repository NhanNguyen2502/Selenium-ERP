package erp.pages;

import erp.common.helpers.ValidateHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class SignUpPage {
    private WebDriver driver;
    private WebDriverWait wait;
    public ValidateHelper validateHelper;

    @FindBy(xpath = "//img[@src='assets/images/erp-logo.svg']")
    private WebElement logoAccountia;
    @FindBy(xpath = "//a//div//span[text()='Accountia']")
    private WebElement nameAccountia;
    @FindBy(xpath = "//h1[@data-cy='formTitle']")
    private WebElement formTitle;
    @FindBy(xpath = "//input[@data-cy='email']")
    private WebElement emailField;
    @FindBy(xpath = "//input[@data-cy='password']")
    private WebElement passwordField;
    @FindBy(xpath = "//mat-icon[@data-mat-icon-name='erp-eye-closed']")
    private WebElement eyeCloseIcon;
    @FindBy(xpath = "//mat-icon[@data-mat-icon-name='erp-eye']")
    private WebElement eyeOpenIcon;
    @FindBy(xpath = "//button[@data-cy='onSignUpClick']")
    private WebElement signUpButton;
    @FindBy(xpath = "//iframe[@title='reCAPTCHA']")
    private WebElement reCaptcha;
    @FindBy(xpath = "//button[@id='password-generate-button']")
    private WebElement generateButton;
    @FindBy(xpath = "//div[@class='password-required-text text-small']")
    private WebElement passwordConditonBox;
    @FindBys(@FindBy(how = How.XPATH, using = "//div[@fxlayoutalign='start center']"))
    private List<WebElement> passwordConditions;
    private By signUpLink = By.xpath("//a[@routerlink='/auth/signup']");

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
        validateHelper = new ValidateHelper(driver);
    }


    public void goToSignUpPage() {
        validateHelper.clickElement(signUpLink);
    }

    public void verifyEyeOpen() {
        wait.until(ExpectedConditions.elementToBeClickable(eyeCloseIcon));
        eyeCloseIcon.click();
        wait.until(ExpectedConditions.elementToBeClickable(eyeOpenIcon));
        eyeOpenIcon.isDisplayed();
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

    public void verifyGeneratePassword() throws InterruptedException {
        generateButton.click();
        Thread.sleep(1000);
        String passWord = ((JavascriptExecutor)driver).executeScript("return document.getElementById('new-password').value").toString();
        System.out.println(passWord);
    }

//    public Boolean wait(WebDriver driver) {
//        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
//
//    }

}
