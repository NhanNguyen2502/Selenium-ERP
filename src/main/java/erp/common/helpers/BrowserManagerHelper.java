package erp.common.helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class BrowserManagerHelper {
    private WebDriver driver;
    private ValidateHelpers validateHelpers;

    public BrowserManagerHelper(WebDriver driver) {
        this.driver = driver;
        validateHelpers = new ValidateHelpers(driver);
    }

    public void openNewTab(String url) {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> _tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(_tabs.get(1));
        driver.get(url);
        validateHelpers.waitForLoadJs();
    }

    public void backToFirstTab() {
        ArrayList<String> _tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(_tabs.get(0));
        validateHelpers.waitAfterChoseOrClickElement();
    }

    public void closingTab1(){
        ArrayList<String> _tabs = new ArrayList<>(driver.getWindowHandles());
        if(_tabs.size()>1)
        {
            driver.switchTo().window(_tabs.get(1));
            driver.close();
            driver.switchTo().window(_tabs.get(0));
        }
    }
}
