package erp.pages;

import erp.common.helpers.ValidateHelpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CreateSalePage {
    private WebDriver driver;
    private WebDriverWait wait;
    ValidateHelpers validateHelpers;

    public  CreateSalePage(WebDriver driver){
        this.driver = driver;
        validateHelpers = new ValidateHelpers(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
}
