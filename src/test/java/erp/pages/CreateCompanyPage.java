package erp.pages;

import erp.base.BaseSetup;
import erp.common.helpers.PropertiesHelper;
import erp.common.helpers.TranslationHelpers;
import erp.common.helpers.ValidateHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.python.antlr.ast.Str;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class CreateCompanyPage extends BaseSetup {
    private WebDriver driver;
    private WebDriverWait wait;
    private ValidateHelpers validateHelpers;

    private By markstep1 = By.xpath("//mat-step-header[@aria-posinset='1']");
    private By markstep1Content = By.xpath("//mat-step-header[@aria-posinset='1']//div[3]");
    private By markstep2 = By.xpath("//mat-step-header[@aria-posinset='2']");
    private By markstep2Content = By.xpath("//mat-step-header[@aria-posinset='2']//div[3]");
    private By markstep3 = By.xpath("//mat-step-header[@aria-posinset='3']");
    private By markstep3Content = By.xpath("//mat-step-header[@aria-posinset='3']//div[3]");
    private By createRealCompanySection = By.xpath("//mat-card[1]");
    private By createRealCompanyHeader = By.xpath("//mat-card[1]//mat-card-header//.//div");
    private By createRealCompanyContent = By.xpath("//mat-card[1]//mat-card-content//span");
    private By createRealCompanyButton = By.xpath("//mat-card[1]//mat-card-content//div/div//div");
    private By createDemoCompanySection = By.xpath("//mat-card[2]");
    private By createDemoCompanyHeader = By.xpath("//mat-card[2]//mat-card-header//.//div");
    private By createDemoCompanyContent = By.xpath("//mat-card[2]//mat-card-content//span");
    private By createDemoCompanyButton = By.xpath("//mat-card[2]//mat-card-content//div/div//div");
    private By languageButton = By.xpath("//app-language-option");
    private By languageOptions = By.xpath("//div[@data-cy='language-option-item']");


    public CreateCompanyPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
        validateHelpers = new ValidateHelpers(driver);
    }

    public void verifyTextOfStep(String ContentOfStep1, String ContentOfStep2, String ContentOfStep3) {
        validateHelpers.checkDisplayed(markstep1);
        validateHelpers.checkDisplayed(markstep2);
        validateHelpers.checkDisplayed(markstep3);
        validateHelpers.getMessage(markstep1Content).contains(ContentOfStep1);
        validateHelpers.getMessage(markstep2Content).contains(ContentOfStep2);
        validateHelpers.getMessage(markstep3Content).contains(ContentOfStep3);
    }

    public void verifyTextOfCreateSection(String realHeader, String realContent,
                                          String realButtonText,String demoHeader, String demoContent,
                                          String demoButtonText) {
        validateHelpers.checkDisplayed(createRealCompanySection);
        validateHelpers.checkDisplayed(createDemoCompanySection);
        validateHelpers.getMessage(createRealCompanyHeader).contains(realHeader);
        validateHelpers.getMessage(createRealCompanyContent).contains(realContent);
        validateHelpers.getMessage(createRealCompanyButton).contains(realButtonText);
        validateHelpers.getMessage(createDemoCompanyHeader).contains(demoContent);
        validateHelpers.getMessage(createDemoCompanyContent).contains(demoContent);
        validateHelpers.getMessage(createDemoCompanyButton).contains(demoButtonText);

    }

    public void verifylanguage(String language) {
        validateHelpers.clickElement(languageButton);
        wait.until(ExpectedConditions.elementToBeClickable(languageOptions));
        List<WebElement> options = driver.findElements(languageOptions);
        String key = "$.languageSelect.option.english";
        switch (language) {
            case "English" -> key = "$.languageSelect.option.english";
            case "Arabic" -> key = "$.languageSelect.option.arabic";
            case "Kurdish - Badini" -> key = "$.languageSelect.option.badini";
            case "Kurdish - Sorani" -> key = "$.languageSelect.option.sorani";
            default -> System.out.println("default");
        }

        for (WebElement o : options) {
            if (o.getText().contains(language) || o.getText().contains(TranslationHelpers.setFile(PropertiesHelper.getLanguageToTest(), key))) {
                System.out.println(o.getText());
                o.click();
            }
        }
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
