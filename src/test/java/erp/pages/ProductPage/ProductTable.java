package erp.pages.ProductPage;

import erp.common.helpers.AttachmentDocumentHelper;
import erp.common.helpers.ValidateHelpers;
import erp.pages.EmployeePage.CreateEmployeesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Random;

public class ProductTable {
    private WebDriver driver;
    private ValidateHelpers validateHelpers;
    private Random ran;
    private AttachmentDocumentHelper attachmentDocumentHelper;

    public ProductTable(WebDriver driver)
    {
        this.driver= driver;
        ran = new Random();
        attachmentDocumentHelper = new AttachmentDocumentHelper(driver);
        validateHelpers = new ValidateHelpers(driver);
    }

    private By productStatusField = By.xpath("//app-select[@data-cy='select-product-status']//input");
    private By productEnable = By.xpath("//mat-option[@data-cy='option-1']");
    private By productDisable = By.xpath("//mat-option[@data-cy='option-2']");
    private By productStatusAll = By.xpath("//mat-option[@data-cy='option-0']");

    public void filterAll() {
        validateHelpers.clickElement(productStatusField);
        validateHelpers.clickElement(productStatusAll);
    }

    public void filterEnable() {
        validateHelpers.clickElement(productStatusField);
        validateHelpers.clickElement(productEnable);
    }

    public void filterDisabled() {
        validateHelpers.clickElement(productStatusField);
        validateHelpers.clickElement(productDisable);
    }
}
