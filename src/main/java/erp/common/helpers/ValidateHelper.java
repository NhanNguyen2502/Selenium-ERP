package erp.common.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ValidateHelper {
    private WebDriver driver;
    private WebDriverWait wait;


    public ValidateHelper(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void setText(By element, String text) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).sendKeys(text);
    }

    public void clickElement(By element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).click();
        // ((JavascriptExecutor) Js).executeScript("arguments[0].click()", driver.findElement(element));
    }

    public void clearElement(By element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).clear();
    }

    public String getMessage(By element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return driver.findElement(element).getText();
    }

    public boolean checkDisplayed(By element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        if (driver.findElement(element).isDisplayed())
            return true;
        return false;
    }

    public String getLanguageToTest() {
        PropertiesHelper.loadAllFile();
         return  PropertiesHelper.getValue("language");
    }
}
