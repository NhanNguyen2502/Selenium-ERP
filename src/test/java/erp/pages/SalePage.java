package erp.pages;

import erp.common.helpers.ValidateHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class SalePage {
    private WebDriver driver;
    private WebDriverWait wait;
    ValidateHelpers validateHelpers;

    private By saleButton = By.xpath("//a[@data-cy='sidebar-invoice-link']");
    private By salesTab = By.xpath("(//div//label[@data-cy='draft-invoice-tab-label'])[1]");
    private By draftSalebutton = By.xpath("(//div//label[@data-cy='draft-invoice-tab-label'])[2]");
    private By crSalebutton = By.xpath("//button[@data-cy='new-invoice-button']");
    private By rowsButton = By.xpath("//button[@data-cy='drop-down-button']");
    private By rowOptions = By.xpath("//button[@data-cy='drop-down-button']");
    private By filterButton = By.xpath("//button[@data-cy='filter-button']");
    private By collumnConfig = By.xpath("//button[@data-cy='table-column-config-button']");
    private By searchField = By.xpath("//input[@data-cy='search-input-field']");
    private By emtyList = By.xpath("//app-no-item");
    private By keyData = By.xpath("//app-invoice-key-data-item");
    private By crSaleShortcut = By.xpath("//a[@data-cy='contact-us-link'][1]");


    public SalePage(WebDriver driver) {
        this.driver = driver;
        validateHelpers = new ValidateHelpers(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void verifyElementsOnSaleTable() {
        Assert.assertTrue(validateHelpers.checkDisplayed(saleButton));
        Assert.assertTrue(validateHelpers.checkDisplayed(salesTab));
        Assert.assertTrue(validateHelpers.checkDisplayed(draftSalebutton));
        Assert.assertTrue(validateHelpers.checkDisplayed(crSalebutton));
        Assert.assertTrue(validateHelpers.checkDisplayed(rowsButton));
        Assert.assertTrue(validateHelpers.checkDisplayed(rowOptions));
        Assert.assertTrue(validateHelpers.checkDisplayed(filterButton));
        Assert.assertTrue(validateHelpers.checkDisplayed(collumnConfig));
        Assert.assertTrue(validateHelpers.checkDisplayed(searchField));
        Assert.assertTrue(validateHelpers.checkDisplayed(searchField));
        Assert.assertTrue(validateHelpers.checkDisplayed(keyData));
    }

    public CreateSalePage gtoSaleViaShortCut() {
        Assert.assertTrue(validateHelpers.checkDisplayed(crSaleShortcut));
        validateHelpers.clickElement(crSaleShortcut);
        return  new CreateSalePage(driver);
    }

    public CreateSalePage gtoSaleViaCrButton() {
        Assert.assertTrue(validateHelpers.checkDisplayed(crSalebutton));
        validateHelpers.clickElement(crSalebutton);
        return  new CreateSalePage(driver);
    }


}
