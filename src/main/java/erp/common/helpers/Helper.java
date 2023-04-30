package erp.common.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Helper {
    private WebDriver driver;
    private ValidateHelpers validateHelpers;
    private WebDriverWait wait;


    public Helper(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        validateHelpers = new ValidateHelpers(driver);
    }


    public static String getcurrentDir() {
        String current = System.getProperty("user.dir") + "/";
        return current;
    }
}
