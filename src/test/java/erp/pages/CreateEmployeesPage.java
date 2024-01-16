package erp.pages;

import erp.common.helpers.FakeDataHelper;
import erp.common.helpers.PropertiesHelper;
import erp.common.helpers.ValidateHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.time.Duration;

public class CreateEmployeesPage {
    private WebDriver driver;
    private ValidateHelpers validateHelpers;
    //Create Employee on the create invoice page
    private By invoiceAddEmployeeButton = By.xpath("(//button[@apptooltip='regularInvoice.button.createEmployeeTooltip'])[2]");
    private By invoiceEmployeeNameField = By.xpath("//app-create-edit-employee-dialog//input[@data-cy='name']");
    private By invoicePhoneNumberfield = By.xpath("//app-create-edit-employee-dialog//input[@data-cy='phone-number-input']");
    private By invoiceCreateEmployeeButton = By.xpath("//app-create-edit-employee-dialog//button[@data-cy='dialog-confirm-button']");
    private By invoicePhoneNumberWarning = By.xpath("//div[@data-cy='phone-invalid-error-message']");


    public CreateEmployeesPage(WebDriver driver) {
        this.driver = driver;
        validateHelpers = new ValidateHelpers(driver);
    }



    public void createEmployeeOnCreateInvoicePage(String phoneNUmberWarningText) {

        Assert.assertTrue(validateHelpers.checkDisplayed(invoiceAddEmployeeButton));
        validateHelpers.clickElement(invoiceAddEmployeeButton);
        validateHelpers.waitForLoadJs();
        Assert.assertTrue(validateHelpers.checkDisplayed(invoiceEmployeeNameField));
        Assert.assertTrue(validateHelpers.checkDisplayed(invoicePhoneNumberfield));
        Assert.assertTrue(validateHelpers.checkDisplayed(invoiceCreateEmployeeButton));
        validateHelpers.setText(invoiceEmployeeNameField, FakeDataHelper.getFakedata().name().fullName());
        validateHelpers.setText(invoicePhoneNumberfield, FakeDataHelper.createFakeByLocate(PropertiesHelper.getValue("LOCATE1")).phoneNumber().cellPhone()
                .replace("(", "").replace(")", "").replace("-", "").replace(".", ""));
        System.out.println(FakeDataHelper.createFakeByLocate(PropertiesHelper.getValue("LOCATE1")).phoneNumber().cellPhone());
        String warning = validateHelpers.getMessage(invoicePhoneNumberWarning);
        Assert.assertEquals(warning, phoneNUmberWarningText);
        for (int i = 0; ; i++) {
            if (warning.contains(phoneNUmberWarningText)) {
                validateHelpers.clearElement(invoicePhoneNumberfield);
                validateHelpers.setText(invoicePhoneNumberfield, "0" + FakeDataHelper.createFakeByLocate(PropertiesHelper.getValue("LOCATE1")).phoneNumber().cellPhone()
                        .replace("(", "").replace(")", "").replace("-", "").replace(".", ""));
                System.out.println("0" + FakeDataHelper.createFakeByLocate(PropertiesHelper.getValue("LOCATE1")).phoneNumber().cellPhone()
                        .replace("(", "").replace(")", "").replace("-", "").replace(".", ""));
                validateHelpers.waitAfterChoseOrClickElement();
                try {
                    warning = driver.findElement(invoicePhoneNumberWarning).getText();
                } catch (NoSuchElementException a) {
                    warning = "null";
                }
            } else {
                validateHelpers.clickElement(invoiceCreateEmployeeButton);
                break;
            }

        }
    }
}
