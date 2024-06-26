package erp.pages.ProductPage;

import com.ibm.icu.impl.UResource;
import erp.common.helpers.AttachmentDocumentHelper;
import erp.common.helpers.ValidateHelpers;
import erp.pages.EmployeePage.CreateEmployeesPage;
import org.openqa.selenium.*;
import org.testng.Assert;

import java.util.Random;

public class ProductTable {
    private WebDriver driver;
    private ValidateHelpers validateHelpers;
    private Random ran;
    private AttachmentDocumentHelper attachmentDocumentHelper;

    public ProductTable(WebDriver driver) {
        this.driver = driver;
        ran = new Random();
        attachmentDocumentHelper = new AttachmentDocumentHelper(driver);
        validateHelpers = new ValidateHelpers(driver);
    }

    private By productStatusField = By.xpath("//app-select[@data-cy='select-product-status']//input");
    private By productEnable = By.xpath("//mat-option[@data-cy='option-1']");
    private By productDisable = By.xpath("//mat-option[@data-cy='option-2']");
    private By productStatusAll = By.xpath("//mat-option[@data-cy='option-0']");
    private By productSearch = By.xpath("(//input[@data-cy='search-input-field'])[1]");
    private By productSearchField = By.xpath("(//input[@data-placeholder='Search'])[3]");

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

    public void searchProductName(String productName) {
        try {
            validateHelpers.clickElement(productSearch);
            //validateHelpers.clearElement(productSearch);
            //validateHelpers.setText(productSearch, productName);
            WebElement a = driver.findElement(productSearchField);
            a.click();
            a.sendKeys(productName);
            a.sendKeys(Keys.ENTER);
            //validateHelpers.clickElement(a);
        } catch (NoSuchElementException e) {
            Assert.fail("Search Product Name Failed.");
        }

    }
}
