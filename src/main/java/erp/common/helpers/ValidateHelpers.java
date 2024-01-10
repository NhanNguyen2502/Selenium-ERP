package erp.common.helpers;


import org.jsoup.Jsoup;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import py4j.ClientServer;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;


public class ValidateHelpers {
    private WebDriver driver;
    private WebDriverWait wait;
    private By logoutButton = By.xpath("//button[@data-cy='log-out-button']");
    private By languageButton = By.xpath("//app-language-option");
    private By languageOptions = By.xpath("//div[@data-cy='language-option-item']");

    private Actions actions;


    public ValidateHelpers(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        actions = new Actions(driver);
    }

    public boolean selectRandom(By dropdownButton, By elements){
        try{
            clickElement(dropdownButton);
            var list = driver.findElements(elements);
            if(!list.isEmpty())
            {
                Random ran = new Random();
                var randomNumber = ran.nextInt(list.size());
                System.out.println(randomNumber);
                list.get(randomNumber).click();
//            for (int  i=0; i<list.size();i++)
//            {
//                list.get(randomNumber).click();
//            }
                return true;
            }else
                return false;

        }catch (NoSuchElementException a)
        {
            return false;
        }

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
        return driver.findElement(element).isDisplayed();

    }

    public void clickOutside() {
        actions.moveByOffset(0, 0).click().build().perform();
    }

    public void logout() {
       clickElement(logoutButton);
    }

    public String removeHtmlTags(String content) {
        return Jsoup.parse(content).text();
    }

    public void waitForLoadJs() {
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
            }
        };
        try {
            Thread.sleep(30000);
            wait.until(jsLoad);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");

        }
    }

    public boolean checkElementDisabled(By element)
    {
        //wait.until(ExpectedConditions.elementToBeClickable(element));
        if(driver.findElement(element).isEnabled())
        {
            return false;
        }
        return  true;
    }

    public void verifylanguage(String language) {
        waitForLoadJs();
        clickElement(languageButton);
        wait.until(ExpectedConditions.elementToBeClickable(languageOptions));
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
}
