package erp.pages;

import erp.common.helpers.FakeDataHelper;
import erp.common.helpers.ValidateHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CreateCustomerPage {
    private WebDriver driver;
    private ValidateHelpers validateHelpers;
    //Create Customer on the create Invoice Page
    private By invoiceAddCustomerButton = By.xpath("(//button[@apptooltip='regularInvoice.button.createContactTooltip'])[2]");
    private By invoiceCustomerNamefield = By.xpath("//input[@apptooltip='invoicesCommon.dialog.createEditContact.inputField.contactNameTooltip']");
    private By invoiceCreateCustomerButton = By.xpath("//app-create-edit-contact-dialog//button[@data-cy='dialog-confirm-button']");
    private By invoiceCustomerNameError = By.xpath("//mat-error//div");

    public CreateCustomerPage(WebDriver driver) {
        this.driver = driver;
        validateHelpers = new ValidateHelpers(driver);
    }

    public void createCustomerOnCreateInvoicePage(String customerNameError) {
        var message = "null";
        Assert.assertTrue(validateHelpers.checkDisplayed(invoiceAddCustomerButton));
        validateHelpers.clickElement(invoiceAddCustomerButton);
        validateHelpers.waitForLoadJs();
        Assert.assertTrue(validateHelpers.checkDisplayed(invoiceCustomerNamefield));
        validateHelpers.setText(invoiceCustomerNamefield, FakeDataHelper.getFakedata().name().fullName());
        validateHelpers.clickElement(invoiceCreateCustomerButton);
        try {
            message = driver.findElement(invoiceCustomerNameError).getText();
            for (int i = 0; ; i++) {
                if (message.contains(customerNameError)) {
                    validateHelpers.clearElement(invoiceCustomerNamefield);
                    validateHelpers.setText(invoiceCustomerNamefield, FakeDataHelper.getFakedata().name().fullName());
                    message = driver.findElement(invoiceCustomerNameError).getText();
                    validateHelpers.clickElement(invoiceCreateCustomerButton);
                    break;
                }
            }
        } catch (NoSuchElementException a) {
            message = "null";
        }

    }
}
