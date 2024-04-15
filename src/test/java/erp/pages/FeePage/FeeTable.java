package erp.pages.FeePage;

import erp.common.helpers.AttachmentDocumentHelper;
import erp.common.helpers.ValidateHelpers;
import erp.pages.EmployeePage.CreateEmployeesPage;
import org.openqa.selenium.*;
import org.testng.Assert;

import java.util.Random;

public class FeeTable {
    private WebDriver driver;
    private ValidateHelpers validateHelpers;
    private Random ran;
    private AttachmentDocumentHelper attachmentDocumentHelper;

    public FeeTable(WebDriver driver) {
        this.driver = driver;
        ran = new Random();
        attachmentDocumentHelper = new AttachmentDocumentHelper(driver);
        validateHelpers = new ValidateHelpers(driver);
    }

    private By feeStatusField = By.xpath("//app-select[@prefix='fee.listPage']");
    private By feeEnable = By.xpath("//mat-option[@data-cy='option-1']");
    private By feeDisable = By.xpath("//mat-option[@data-cy='option-2']");
    private By feeStatusAll = By.xpath("//mat-option[@data-cy='option-0']");
    private By feeSearch = By.xpath("(//input[@data-cy='search-input-field'])[1]");
    private By feeSearchField = By.xpath("(//input[@data-placeholder='Search'])[3]");

    public void filterAll() {
        validateHelpers.clickElement(feeStatusField);
        validateHelpers.clickElement(feeStatusAll);
    }

    public void filterEnable() {
        validateHelpers.clickElement(feeStatusField);
        validateHelpers.clickElement(feeEnable);
    }

    public void filterDisabled() {
        validateHelpers.clickElement(feeStatusField);
        validateHelpers.clickElement(feeDisable);
    }

    public void searchFeeName(String feeName) {
        try {
            validateHelpers.clickElement(feeSearch);
            WebElement a = driver.findElement(feeSearchField);
            a.click();
            a.sendKeys(feeName);
            a.sendKeys(Keys.ENTER);
        } catch (NoSuchElementException e) {
            Assert.fail("Search Customer Name Failed!");
        }
    }
}
