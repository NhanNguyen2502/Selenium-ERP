package erp.pages.EmployeePage;

import erp.common.helpers.AttachmentDocumentHelper;
import erp.common.helpers.ValidateHelpers;
import erp.pages.Customer.CreateCustomerPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

}
