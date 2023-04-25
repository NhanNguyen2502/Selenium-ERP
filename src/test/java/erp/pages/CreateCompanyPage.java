package erp.pages;

import erp.base.BaseSetup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import java.sql.Driver;
import java.time.Duration;

public class CreateCompanyPage extends BaseSetup {
    private WebDriver driver;
    private WebDriverWait wait;
    private SignInPage signInPage;
    private CompanyListPage companyListPage;

    public void setCompanyListPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }



}
