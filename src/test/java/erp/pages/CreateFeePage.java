package erp.pages;

import erp.common.helpers.FakeDataHelper;
import erp.common.helpers.ValidateHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CreateFeePage {
    private WebDriver driver;
    private ValidateHelpers validateHelpers;

    public CreateFeePage(WebDriver driver) {
        this.driver = driver;
        validateHelpers = new ValidateHelpers(driver);
    }

    //Create fee on the create invoice page
    private By invoiceAddNewFeeOnFeeLineButton = By.xpath("//button[@data-cy='new-fee-row-button']");
    private By invoiceFeeField = By.xpath("//input[@data-cy='select-fee']");
    private By invoiceAddNewFeeButton = By.xpath("(//button[@apptooltip='regularInvoice.button.createFeeTooltip'])[2]");
    private By invoiceFeeList = By.xpath("//mat-option");
    private By invoiceFeeError = By.xpath("//div[@data-cy='fee-name-required-error']");
    private By invoiceFeeNameField = By.xpath("//input[@data-cy='fee-name-input']");
    private By invoiceMainPricefield = By.xpath("//input[@data-cy='fee-amount-company-main-currecny']");
    private By invoiceCreateButton = By.xpath("//mat-dialog-actions//button[@data-cy='dialog-confirm-button']");

    public void createFeeOnInvoice() {

        Assert.assertTrue(validateHelpers.checkDisplayed(invoiceAddNewFeeOnFeeLineButton));
        Assert.assertTrue(validateHelpers.checkDisplayed(invoiceAddNewFeeButton));
        Assert.assertTrue(validateHelpers.checkDisplayed(invoiceFeeField));
        validateHelpers.clickElement(invoiceAddNewFeeButton);
        validateHelpers.setText(invoiceFeeNameField, FakeDataHelper.getFakedata().job().title());
        validateHelpers.clearElement(invoiceMainPricefield);
        validateHelpers.setText(invoiceMainPricefield,String.valueOf(FakeDataHelper.getFakedata().number().numberBetween(0,100)));
        validateHelpers.clickElement(invoiceCreateButton);
    }
}
