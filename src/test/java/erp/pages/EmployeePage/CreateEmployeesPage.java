package erp.pages.EmployeePage;

import erp.base.ReportListener;
import erp.common.helpers.AttachmentDocumentHelper;
import erp.common.helpers.FakeDataHelper;
import erp.common.helpers.PropertiesHelper;
import erp.common.helpers.ValidateHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.python.modules._threading._threading;
import org.testng.Assert;
import org.testng.annotations.Listeners;

import java.time.Duration;
import java.util.Random;

public class CreateEmployeesPage {
    private WebDriver driver;
    private ValidateHelpers validateHelpers;
    private AttachmentDocumentHelper attachmentDocumentHelper;
    private Random random;
    private String _employeeName;
    //Create Employee on the create invoice page
    private By invoiceAddEmployeeButton = By.xpath("(//button[@apptooltip='regularInvoice.button.createEmployeeTooltip'])[2]");
    private By invoiceEmployeeNameField = By.xpath("//app-create-edit-employee-dialog//input[@data-cy='name']");
    private By invoicePhoneNumberfield = By.xpath("//app-create-edit-employee-dialog//input[@data-cy='phone-number-input']");
    private By invoiceCreateEmployeeButton = By.xpath("//app-create-edit-employee-dialog//button[@data-cy='dialog-confirm-button']");
    private By invoicePhoneNumberWarning = By.xpath("//div[@data-cy='phone-invalid-error-message']");
    private By employeeLeftMenu = By.xpath("//a[@data-cy='sidebar-employee-link']");
    private By tableEmployeeCreateButton = By.xpath("//button[@data-cy='create-employee-button']");
    private By employeeName = By.xpath("//input[@data-cy='name-input']");
    private By phoneDialCodeField = By.xpath("//input[@data-cy='phone-dial-code-input']");
    private By phonenumberField = By.xpath("//input[@data-cy='phone-number-input']");
    private By phoneNumberWarning = By.xpath("//div[@data-cy='phone-invalid-error-message']");
    private By employeePageCreateButton = By.xpath("//button[@data-cy='create-employee-button']");
    private By employeeTabledTitle = By.xpath("//span[@data-cy='employee-list-title']");
    private By employeeAvatarInput = By.xpath("//input[@apptooltip='avatar.tooltips.uploadImageTooltip']");
    private By employeeConfirmUpload = By.xpath("//button[@data-cy='save-imapge-uplaod-button']");
    private By employeeCancelUpload = By.xpath("//button[@data-cy='cancel-image-uplaod-button']");
    private By employeeAddPhoneNumberButton = By.xpath("//button[@data-cy='add-phone-number-button']");
    private By employeeNameRequired = By.xpath("//div[@data-cy='duplicate-phone-number-and-name']");
    private By employeePhoneRequired = By.xpath("//div[@data-cy='phone-required-error-message']");
    private By employeePhoneDial = By.xpath("//mat-option[@data-cy='phone-dial-code-option']");


    public CreateEmployeesPage(WebDriver driver) {
        this.driver = driver;
        validateHelpers = new ValidateHelpers(driver);
        attachmentDocumentHelper = new AttachmentDocumentHelper(driver);
        random = new Random();
    }

    public  void checkNameAndPhoneRequired()
    {
        try {
            Assert.assertTrue(driver.findElement(employeeNameRequired).isDisplayed(),"Employee Name required.");
            Assert.assertTrue(driver.findElement(employeePhoneRequired).isDisplayed(),"Employee phone required.");
        }catch (NoSuchElementException e)
        {
            Assert.fail("Name or Phone are not required.");
        }
    }

    public void checkPhoneRequired()
    {
        try {
            Assert.assertTrue(driver.findElement(employeePhoneRequired).isDisplayed(),"Phone is Required.");
        }catch (NoSuchElementException e)
        {
            Assert.fail("Phone number is not required.");
        }
    }
    public void checkEmployeeNameRequired() {
        try {
            validateHelpers.clickElement(employeeName);
            validateHelpers.clickOutside();
            Assert.assertTrue(driver.findElement(employeeNameRequired).isDisplayed(),"Employee name is required!");
        }catch (NoSuchElementException e)
        {
            Assert.fail("Employee name is not required.");
        }
    }

    public void addPhoneNumbers() {
        var _phoneDialList = validateHelpers.getList(phoneDialCodeField);
        var _phoneFieldList = validateHelpers.getList(phonenumberField);
        for (int i = 0; i <= _phoneDialList.size(); i++) {
            if (!_phoneDialList.get(i).getText().contains("+964")) {
                _phoneDialList.get(i).sendKeys("+964");
            }
            try {
                _phoneFieldList.get(i).sendKeys("0" + FakeDataHelper.createFakeByLocate(PropertiesHelper.getValue("LOCATE1")).phoneNumber().cellPhone()
                        .replace("(", "").replace(")", "").replace("-", "").replace(".", ""));
                for (int ii = 0; ; i++) {
                    if (driver.findElement(phoneNumberWarning).isDisplayed()) {
                        validateHelpers.clearElement(phonenumberField);
                        validateHelpers.setText(phonenumberField, "0" + FakeDataHelper.createFakeByLocate(PropertiesHelper.getValue("LOCATE1")).phoneNumber().cellPhone()
                                .replace("(", "").replace(")", "").replace("-", "").replace(".", ""));
                        validateHelpers.waitAfterChoseOrClickElement();

                    } else {
                        break;
                    }

                }
            } catch (NoSuchElementException e) {
                System.out.println("Phone number warning does not exist!");
            }
        }
    }

    public void clickOnAddPhone() {
        var _lineNumber = random.nextInt(2);
        for (int i = 0; i < _lineNumber; i++) {
            validateHelpers.clickElement(employeeAddPhoneNumberButton);
            validateHelpers.waitAfterChoseOrClickElement();
        }

    }

    public void cancelUploadAvatar() {
        validateHelpers.clickElement(employeeCancelUpload);
    }

    public void confirmUploadAvatar() {
        validateHelpers.clickElement(employeeConfirmUpload);
    }

    public void uploadAvatar() {
        attachmentDocumentHelper.addAvatar(employeeAvatarInput);
    }

    public void verifyAfterCreate() {
        try {

            if (driver.findElement(employeeTabledTitle).isDisplayed()) {
                System.out.println("Employee has been created success, employee Name: " + _employeeName);
            }
        } catch (NoSuchElementException e) {
            System.out.println("Create employee failed!");
        }
    }

    public void clickOnCreateEmployeeButton() {
        validateHelpers.clickElement(employeePageCreateButton);
    }

    public void enterPhoneNumberArabic() {
        var _phoneDial = validateHelpers.getValueByAttribute(phoneDialCodeField);
        if (!_phoneDial.contains("+964")) {
            validateHelpers.clearElement(phoneDialCodeField);
            validateHelpers.setText(phoneDialCodeField, "+964");
            validateHelpers.clickElement(employeePhoneDial);
        }
        try {
            validateHelpers.setText(phonenumberField, "0" + FakeDataHelper.createFakeByLocate(PropertiesHelper.getValue("LOCATE1")).phoneNumber().cellPhone()
                    .replace("(", "").replace(")", "").replace("-", "").replace(".", ""));
            for (int i = 0; ; i++) {
                if (driver.findElement(phoneNumberWarning).isDisplayed()) {
                    validateHelpers.clearElement(phonenumberField);
                    validateHelpers.setText(phonenumberField, "0" + FakeDataHelper.createFakeByLocate(PropertiesHelper.getValue("LOCATE1")).phoneNumber().cellPhone()
                            .replace("(", "").replace(")", "").replace("-", "").replace(".", ""));
                    validateHelpers.waitAfterChoseOrClickElement();

                } else {
                    break;
                }

            }
        } catch (NoSuchElementException e) {
            System.out.println("Phone number warning does not exist!");
        }

    }

    public void enterEmployeeName() {
        _employeeName = FakeDataHelper.getFakedata().name().name();
        validateHelpers.setText(employeeName, _employeeName);
    }

    public void gotoCreateEmployeePage() {
        validateHelpers.clickElement(tableEmployeeCreateButton);
    }

    public void gotoEmployeeTable() {
        validateHelpers.clickElement(employeeLeftMenu);
    }

    public void createEmployeeOnCreateInvoicePage(String phoneNUmberWarningText) {

        Assert.assertTrue(validateHelpers.checkDisplayed(invoiceAddEmployeeButton));
        validateHelpers.clickElement(invoiceAddEmployeeButton);
        validateHelpers.waitForLoadJs();
        Assert.assertTrue(validateHelpers.checkDisplayed(invoiceEmployeeNameField));
        Assert.assertTrue(validateHelpers.checkDisplayed(invoicePhoneNumberfield));
        Assert.assertTrue(validateHelpers.checkDisplayed(invoiceCreateEmployeeButton));
        validateHelpers.setText(invoiceEmployeeNameField, FakeDataHelper.getFakedata().name().fullName());
        var _phoneDial = validateHelpers.getValueByAttribute(phoneDialCodeField);
        if (!_phoneDial.contains("+964")) {
            validateHelpers.clearElement(phoneDialCodeField);
            validateHelpers.setText(phoneDialCodeField, "+964");
            validateHelpers.clickElement(employeePhoneDial);
        }
        validateHelpers.setText(invoicePhoneNumberfield, FakeDataHelper.createFakeByLocate(PropertiesHelper.getValue("LOCATE1")).phoneNumber().cellPhone()
                .replace("(", "").replace(")", "").replace("-", "").replace(".", ""));
        String warning = validateHelpers.getMessage(invoicePhoneNumberWarning);
        Assert.assertEquals(warning, phoneNUmberWarningText);
        for (int i = 0; ; i++) {
            if (warning.contains(phoneNUmberWarningText)) {
                validateHelpers.clearElement(invoicePhoneNumberfield);
                validateHelpers.setText(invoicePhoneNumberfield, "0" + FakeDataHelper.createFakeByLocate(PropertiesHelper.getValue("LOCATE1")).phoneNumber().cellPhone()
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
