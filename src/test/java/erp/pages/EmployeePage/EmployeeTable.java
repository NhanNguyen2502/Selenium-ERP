package erp.pages.EmployeePage;

import erp.common.helpers.AttachmentDocumentHelper;
import erp.common.helpers.ValidateHelpers;
import erp.pages.Customer.CreateCustomerPage;
import org.openqa.selenium.*;
import org.testng.Assert;

import java.util.Random;

public class EmployeeTable {
    private WebDriver driver;
    private ValidateHelpers validateHelpers;
    private Random ran;
    private AttachmentDocumentHelper attachmentDocumentHelper;
    private CreateEmployeesPage createEmployeesPage;

    public EmployeeTable(WebDriver driver)
    {
        this.driver= driver;
        ran = new Random();
        attachmentDocumentHelper = new AttachmentDocumentHelper(driver);
        createEmployeesPage = new CreateEmployeesPage(driver);
        validateHelpers = new ValidateHelpers(driver);
    }

    private By employeeStatusField = By.xpath("//app-select[@data-cy='select-employee-status']//input");
    private By employeeEnable = By.xpath("//mat-option[@data-cy='option-1']");
    private By employeeDisable = By.xpath("//mat-option[@data-cy='option-2']");
    private By employeeStatusAll = By.xpath("//mat-option[@data-cy='option-0']");
    private By employeeSearch = By.xpath("(//input[@data-cy='search-input-field'])[1]");
    private By employeeSearchField = By.xpath("(//input[@data-placeholder='Search'])[3]");

    public void filterAll() {
        validateHelpers.clickElement(employeeStatusField);
        validateHelpers.clickElement(employeeStatusAll);
    }

    public void filterEnable() {
        validateHelpers.clickElement(employeeStatusField);
        validateHelpers.clickElement(employeeEnable);
    }

    public void filterDisabled() {
        validateHelpers.clickElement(employeeStatusField);
        validateHelpers.clickElement(employeeDisable);
    }

    public void searchEmployeeName(String employeeName)
    {
        try{
            validateHelpers.clickElement(employeeSearch);
            WebElement a = driver.findElement(employeeSearchField);
            a.click();
            a.sendKeys(employeeName);
            a.sendKeys(Keys.ENTER);
        }catch (NoSuchElementException e)
        {
            Assert.fail("Search Customer Name Failed!");
        }
    }

}
