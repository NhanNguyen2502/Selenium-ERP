package erp.common.helpers;


import org.jsoup.Jsoup;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Key;
import org.testng.Assert;


import java.time.Duration;
import java.util.*;
import java.util.NoSuchElementException;


public class ValidateHelpers {
    private WebDriver driver;
    private WebDriverWait wait;
    private By logoutButton = By.xpath("//button[@data-cy='log-out-button']");
    private By languageButton = By.xpath("//app-language-option");
    private By languageOptions = By.xpath("//div[@data-cy='language-option-item']");
    private Actions actions;


    public ValidateHelpers(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
    }

    public boolean checkElemenNull(By element) {
        try {
            var a = driver.findElements(element);
            if (a.isEmpty())
            {
                return true;
            }
            return false;
        } catch (NoSuchElementException e) {
            return true;
        }
    }

    public void moveToElement(By element) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
            actions.moveToElement(driver.findElement(element));
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }

    }

    public String getValueByAttribute(By element) {
        return driver.findElement(element).getAttribute("value");
    }

    public String getValueByJSByID(String elementID) {
        return ((JavascriptExecutor) driver).executeScript("return document.getElementById('" + elementID + "').value").toString();
    }

    public List<WebElement> getList(By element) {
        List<WebElement> list = null;
        try {
            list = driver.findElements(element);
        } catch (NoSuchElementException e) {
            System.out.println(e.toString());
        }
        return list;
    }

    public boolean selectRandom(By dropdownButton, By elements) {
        try {
            clickElement(dropdownButton);
            var list = driver.findElements(elements);
            if (!list.isEmpty()) {
                Random ran = new Random();
                var randomNumber = ran.nextInt(list.size());
                list.get(randomNumber).click();
//            for (int  i=0; i<list.size();i++)
//            {
//                list.get(randomNumber).click();
//            }
                return true;
            } else
                return false;

        } catch (NoSuchElementException a) {
            return false;
        }

    }

    public void setText(By element, String text) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).sendKeys(text);
    }

    public void clickElement(By element) {
        waitVisibility(element);
        //actions.moveToElement(driver.findElement(element));
        driver.findElement(element).click();
//        if (driver.findElement(element).isDisplayed()) {
//            driver.findElement(element).click();
//        }else {
//            System.out.println("can not click on: " + element);
//        }
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
        try {
            return driver.findElement(element).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void clickOutside() {
        actions.moveByOffset(0, 0).click().build().perform();
    }

    public void logout() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
            clickElement(logoutButton);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }

    }

    public String removeHtmlTags(String content) {
        return Jsoup.parse(content).text();
    }

    public void waitVisibility(By element) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void waitAfterChoseOrClickElement() {
        ExpectedCondition<Boolean> jsWait = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
            }
        };
        try {
            Thread.sleep(3000);
            wait.until(jsWait);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete after click or chose element");
        }
    }

    public void waitForLoadJsCreatePage() {
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
            }
        };
        try {
            Thread.sleep(10000);
            wait.until(jsLoad);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");

        }
    }

    public void waitForLoadJsLoginPage() {
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
            }
        };
        try {
            Thread.sleep(50000);
            wait.until(jsLoad);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");

        }
    }

    public void waitForLoadJs() {
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
            }
        };
        try {
            Thread.sleep(10000);
            wait.until(jsLoad);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");

        }
    }

    public boolean checkElementDisabled(By element) {
        //wait.until(ExpectedConditions.elementToBeClickable(element));
        if (driver.findElement(element).isEnabled()) {
            return false;
        }
        return true;
    }

    public void verifylanguage(String language) {
        waitForLoadJsCreatePage();
        clickElement(languageButton);
        wait.until(ExpectedConditions.elementToBeClickable(languageOptions));
        var options = getList(languageOptions);
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
                System.out.println("Test with language: " + language);
                o.click();
                break;
            }
        }
    }

}
