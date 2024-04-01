package erp.pages.FeePage;

import erp.common.helpers.AttachmentDocumentHelper;
import erp.common.helpers.ValidateHelpers;
import erp.pages.EmployeePage.CreateEmployeesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
}
