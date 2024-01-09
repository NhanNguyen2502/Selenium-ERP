package erp.pages;

import erp.common.helpers.FakeDataHelper;
import erp.common.helpers.ValidateHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CreateProductPage {
    private WebDriver driver;
    private ValidateHelpers validateHelpers;

    //Create product on the invoice page
    private By invoiceAddProductButton = By.xpath("(//button[@data-cy='add-product-button'])[2]");
    private By invoiceProductDropdownButton = By.xpath("//input[@data-cy='select-product']");
    private By invoiceProductList = By.xpath("//mat-option");
    private By invoiceProductName = By.xpath("//input[@apptooltip='invoicesCommon.dialog.createEditProduct.inputField.productNameTooltip']");
    private By invoiceProuctPrice = By.xpath("//input[@apptooltip='invoicesCommon.dialog.createEditProduct.inputField.standardPriceTooltip']");
    private By invoiceCreateProductButton = By.xpath("//button[@data-cy='dialog-confirm-button']");

    public CreateProductPage(WebDriver driver) {
        this.driver = driver;
        validateHelpers = new ValidateHelpers(driver);
    }

    public void createProductOnInvoice() {
        Assert.assertTrue(validateHelpers.checkDisplayed(invoiceAddProductButton));
        Assert.assertTrue(validateHelpers.checkDisplayed(invoiceProductDropdownButton));
        validateHelpers.clickElement(invoiceAddProductButton);
        validateHelpers.setText(invoiceProductName, FakeDataHelper.getFakedata().tea().variety());
        validateHelpers.clearElement(invoiceProuctPrice);
        validateHelpers.setText(invoiceProuctPrice, String.valueOf(FakeDataHelper.getFakedata().number().numberBetween(0, 100)));
        validateHelpers.clickElement(invoiceCreateProductButton);


    }
}
