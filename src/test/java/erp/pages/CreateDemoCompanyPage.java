package erp.pages;

import erp.common.helpers.ValidateHelpers;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CreateDemoCompanyPage {
    private WebDriver driver;
    private ValidateHelpers validateHelpers;
    private Actions actions;
    private WebDriverWait wait;

    public CreateDemoCompanyPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        validateHelpers = new ValidateHelpers(driver);
        actions = new Actions(driver);
    }

    public void waitForPageLoaded(){
        ExpectedCondition<Boolean> expectedCondition = new ExpectedCondition<>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor)driver).executeScript("return document.readyState").toString()
                        .equals("complete");
            }
        };
        try{
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
            wait.until(expectedCondition);

        }catch (Throwable error)
        {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }
}
