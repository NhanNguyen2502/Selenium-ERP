package erp.pages.Customer;

import erp.common.helpers.AttachmentDocumentHelper;
import erp.common.helpers.ValidateHelpers;
import org.openqa.selenium.*;
import org.testng.Assert;

import java.util.Random;

public class CustomerTable {
    private WebDriver driver;
    private ValidateHelpers validateHelpers;
    private Random ran;
    private AttachmentDocumentHelper attachmentDocumentHelper;
    private CreateCustomerPage createCustomerPage;

    public CustomerTable(WebDriver driver) {
        this.driver = driver;
        validateHelpers = new ValidateHelpers(driver);
        ran = new Random();
        attachmentDocumentHelper = new AttachmentDocumentHelper(driver);
        createCustomerPage = new CreateCustomerPage(driver);
    }

    private By customorStatusField = By.xpath("(//app-select[@data-cy='select-contact-status'])[1]");
    private By customerStatusAll = By.xpath("//mat-option[@data-cy='option-0']");
    private By customerStatusEnable = By.xpath("//mat-option[@data-cy='option-1']");
    private By customerStatusDisable = By.xpath("//mat-option[@data-cy='option-2']");
    private By customerNameList = By.xpath("//div[@data-cy='contact-name']");
    private By customerSearch = By.xpath("(//input[@data-cy='search-input-field'])[1]");
    private By customerSearchField = By.xpath("(//input[@data-placeholder='Search'])[3]");

    public void filterAll() {
        validateHelpers.clickElement(customorStatusField);
        validateHelpers.clickElement(customerStatusAll);
    }

    public void filterEnable() {
        validateHelpers.clickElement(customorStatusField);
        validateHelpers.clickElement(customerStatusEnable);
    }

    public void filterDisabled() {
        validateHelpers.clickElement(customorStatusField);
        validateHelpers.clickElement(customerStatusDisable);
    }

    public void searchCustomerName(String customerName)
    {
        try{
            validateHelpers.clickElement(customerSearch);
            WebElement a = driver.findElement(customerSearchField);
            a.click();
            a.sendKeys(customerName);
            a.sendKeys(Keys.ENTER);
        }catch (NoSuchElementException e)
        {
            Assert.fail("Search Customer Name Failed!");
        }
    }
}
