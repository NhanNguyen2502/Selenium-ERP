package erp.pages.EmployeePage;

import erp.common.helpers.AttachmentDocumentHelper;
import erp.common.helpers.FakeDataHelper;
import erp.common.helpers.PropertiesHelper;
import erp.common.helpers.ValidateHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Random;

public class UpdateEmployeePage {
    private WebDriver driver;
    private ValidateHelpers validateHelpers;
    private AttachmentDocumentHelper attachmentDocumentHelper;
    private Random random;
    private String _employeeUpdated;
    private String _employeeName;
    private CreateEmployeesPage createEmployeesPage;
    private EmployeeTable employeeTable;

    public UpdateEmployeePage(WebDriver driver) {
        this.driver = driver;
        validateHelpers = new ValidateHelpers(driver);
        attachmentDocumentHelper = new AttachmentDocumentHelper(driver);
        random = new Random();
        createEmployeesPage = new CreateEmployeesPage(driver);
        employeeTable = new EmployeeTable(driver);
    }

    private By employeeLeftMenu = By.xpath("//a[@data-cy='sidebar-employee-link']");
    private By employeeNameList = By.xpath("//span[@data-cy='employee-name-data']");
    private By employeeNamefield = By.xpath("//input[@data-cy='name-input']");
    private By phoneDialCodeField = By.xpath("//input[@data-cy='phone-dial-code-input']");
    private By phonenumberField = By.xpath("//input[@data-cy='phone-number-input']");
    private By phoneNumberWarning = By.xpath("//div[@data-cy='phone-invalid-error-message']");
    private By employeePhoneDial = By.xpath("//mat-option[@data-cy='phone-dial-code-option']");
    private By employeeDuplicatePhoneAndName = By.xpath("//div[@data-cy='duplicate-phone-number-and-name']");
    private By employeeDetailPageSaveButton = By.xpath("//act-button[@data-cy='create-employee-button']");
    private By employeeTabledTitle = By.xpath("//span[@data-cy='employee-list-title']");
    private By employeeAvatarField = By.xpath("//input[@apptooltip='avatar.tooltips.uploadImageTooltip']");
    private By employeeConfirmDropAvatarButton = By.xpath("//button[@data-cy='save-imapge-uplaod-button']");
    private By employeeCancelUploadAvatarButton = By.xpath("//button[@data-cy='cancel-image-uplaod-button']");
    private By deleteAvatarButton = By.xpath("//app-avatar//app-expanding-button");
    private By confirmDeleteAvatarButton = By.xpath("//button[@data-cy='dialog-yes-button']");
    private By cancelDeleteAvatar = By.xpath("//button[@data-cy='dialog-cancel-button']");
    private By disableEnableEmployeeButton = By.xpath("//mat-slide-toggle");
    private By confirmDisabledEnableEmployee = By.xpath("//button[@data-cy='dialog-yes-button']");
    private By cancelDisableEnableEmployee = By.xpath("//button[@data-cy='dialog-cancel-button']");
    private By addManyPhoneLineButton = By.xpath("//button[@data-cy='add-phone-number-button']");
    private By deleteEmployeeButton = By.xpath("//button[@data-cy='employee-delete-button']");
    private By confirmDeleteButton = By.xpath("//button[@data-cy='delete-button']");
    private By cancelDeleteButton = By.xpath("//button[@data-cy='delete-button']");
    private By employeeNameOnList = By.xpath("//span[@data-cy='employee-name-data']");


    public void selectEmployeeToUpdateDisableViaEmployeeName(String employeeName) {
        employeeTable.searchEmployeeName(employeeName);
        employeeTable.filterEnable();
        validateHelpers.waitForLoadJs();
        var _employeeList = validateHelpers.getList(employeeNameOnList);
        validateHelpers.waitForLoadJs();
        for (int i = 0;; i++) {
            if(!_employeeList.isEmpty())
            {
                if (_employeeList.size() > 1) {
                    _employeeUpdated = _employeeList.get(i).getText();
                    System.out.println("The employee has been selected: " + _employeeUpdated);
                    _employeeList.get(i).click();
                    validateHelpers.waitForLoadJs();
                    disableEmployee();
                    validateHelpers.waitAfterChoseOrClickElement();
                    confirmDisableEmployee();
                    validateHelpers.waitAfterChoseOrClickElement();
                    clickOnSaveEmployeeButton();
                    validateHelpers.waitForLoadJs();
                    employeeTable.searchEmployeeName(employeeName);
                    validateHelpers.waitForLoadJs();
                    employeeTable.filterEnable();
                    validateHelpers.waitForLoadJs();
                    _employeeList = validateHelpers.getList(employeeNameOnList);
                } else {
                    for ( WebElement a: _employeeList)
                    {
                        _employeeUpdated = a.getText();
                        System.out.println("The employee has been selected: " + _employeeUpdated);
                        a.click();
                        validateHelpers.waitForLoadJs();
                        disableEmployee();
                        validateHelpers.waitAfterChoseOrClickElement();
                        confirmDisableEmployee();
                        validateHelpers.waitAfterChoseOrClickElement();
                        clickOnSaveEmployeeButton();
                        validateHelpers.waitForLoadJs();
                        _employeeList = validateHelpers.getList(employeeNameOnList);
                        break;
                    }

                }
            }
            else {
                break;
            }

        }
    }

    public void cancelDeleteButton() {
        validateHelpers.clickElement(cancelDeleteButton);
    }

    public void confirmDeleteButton() {

        validateHelpers.clickElement(confirmDeleteButton);
    }

    public void deleteEmployee() {
        _employeeName = validateHelpers.getValueByAttribute(employeeNamefield);
        validateHelpers.clickElement(deleteEmployeeButton);
    }

    public void enterArabicPhoneAllLines() {
        var _phoneList = validateHelpers.getList(phonenumberField);
        for (int i = 1; i < _phoneList.size(); i++) {
            _phoneList.get(i).sendKeys("0" + FakeDataHelper.createFakeByLocate(PropertiesHelper.getValue("LOCATE1")).phoneNumber().cellPhone()
                    .replace("(", "").replace(")", "").replace("-", "").replace(".", ""));
            try {
                for (int j = 0; ; j++) {
                    if (driver.findElement(phoneNumberWarning).isDisplayed() || driver.findElement(employeeDuplicatePhoneAndName).isDisplayed()) {
                        _phoneList.get(i).clear();
                        _phoneList.get(i).sendKeys("0" + FakeDataHelper.createFakeByLocate(PropertiesHelper.getValue("LOCATE1")).phoneNumber().cellPhone()
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

    public void changeAllDialCodeToArabicDialCode() {
        var _dialList = validateHelpers.getList(phoneDialCodeField);
        for (int i = 1; i < _dialList.size(); i++) {
            if (!_dialList.get(i).getText().contains("+964")) {
                _dialList.get(i).clear();
                _dialList.get(i).sendKeys("+964");
                validateHelpers.clickElement(employeePhoneDial);
            }
        }
    }

    public void addManyPhone() {
        var _number = random.nextInt(1, 4);
        for (int i = 0; i <= _number; i++) {
            validateHelpers.clickElement(addManyPhoneLineButton);
            validateHelpers.waitAfterChoseOrClickElement();
        }
    }

    public void cancelEnableEmployee() {
        validateHelpers.clickElement(cancelDisableEnableEmployee);
        System.out.println("Cancel Disabled");
    }

    public void confirmEnableEmployee() {
        validateHelpers.clickElement(confirmDisabledEnableEmployee);
        System.out.println("Confirm Disable");
    }

    public void enableEmployee() {
        validateHelpers.clickElement(disableEnableEmployeeButton);
    }

    public void cancelDisableEmployee() {
        validateHelpers.clickElement(cancelDisableEnableEmployee);
        System.out.println("Cancel Disabled");
    }

    public void confirmDisableEmployee() {
        validateHelpers.clickElement(confirmDisabledEnableEmployee);
        System.out.println("Confirm Disable");
    }

    public void disableEmployee() {
        validateHelpers.clickElement(disableEnableEmployeeButton);
    }

    public void cancelDeleteAvatar() {
        validateHelpers.clickElement(cancelDeleteAvatar);
    }

    public void confirmDeleteAvatar() {
        validateHelpers.clickElement(confirmDeleteAvatarButton);
    }

    public void deleteAvatar() {
        try {
            var a = validateHelpers.getList(deleteAvatarButton);
            if (a.isEmpty()) {
                uploadAvatar();
                validateHelpers.waitAfterChoseOrClickElement();
                confirmDropAvatar();
                validateHelpers.waitAfterChoseOrClickElement();
                validateHelpers.clickElement(deleteAvatarButton);
            } else {
                validateHelpers.clickElement(deleteAvatarButton);
            }
        } catch (NoSuchElementException e) {
            System.out.println("");
        }
    }

    public void cancelUploadAvatar() {
        validateHelpers.clickElement(employeeCancelUploadAvatarButton);
        var _avatar = validateHelpers.getValueByAttribute(employeeAvatarField);
        if (_avatar.isEmpty()) {
            System.out.println(" Cancel upload Avatar success!");
        } else {
            System.out.println("Cancel upload Avatar failed!");
        }
    }

    public void confirmDropAvatar() {
        validateHelpers.clickElement(employeeConfirmDropAvatarButton);
        var _avatar = validateHelpers.getValueByAttribute(employeeAvatarField);
        if (!_avatar.isEmpty()) {
            System.out.println("Upload Avatar success!");
        } else {
            System.out.println("Upload Avatar failed!");
        }
    }

    public void uploadAvatar() {
        attachmentDocumentHelper.addAvatar(employeeAvatarField);
    }

    public void verifyUpdateFailed() {
        try {
            Assert.assertTrue(validateHelpers.checkElemenNull(employeeTabledTitle));
        } catch (NoSuchElementException e) {
            Assert.fail("Failed!!!");
        }
    }

    public void verifyUpdateSuccess() {
        try {
            Assert.assertTrue(driver.findElement(employeeTabledTitle).isDisplayed());
            System.out.println("Update success with employee: " + _employeeName);
        } catch (NoSuchElementException e) {
            Assert.fail("Update Failed!!!");
        }
    }

    public String clickOnSaveEmployeeButton() {
        var a = validateHelpers.getValueByAttribute(employeeNamefield);
        validateHelpers.clickElement(employeeDetailPageSaveButton);
        return _employeeName = a;
    }

    public void updatePhoneNumberArabic() {
        var _phoneDial = validateHelpers.getValueByAttribute(phoneDialCodeField);
        if (!_phoneDial.contains("+964")) {
            validateHelpers.clearElement(phoneDialCodeField);
            validateHelpers.setText(phoneDialCodeField, "+964");
            validateHelpers.clickElement(employeePhoneDial);
        }
        try {
            validateHelpers.clearElement(phonenumberField);
            validateHelpers.setText(phonenumberField, "0" + FakeDataHelper.createFakeByLocate(PropertiesHelper.getValue("LOCATE1")).phoneNumber().cellPhone()
                    .replace("(", "").replace(")", "").replace("-", "").replace(".", ""));
            for (int i = 0; ; i++) {
                if (driver.findElement(phoneNumberWarning).isDisplayed() || driver.findElement(employeeDuplicatePhoneAndName).isDisplayed()) {
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

    public void updateEmployeeName() {
        validateHelpers.clearElement(employeeNamefield);
        validateHelpers.setText(employeeNamefield, FakeDataHelper.getFakedata().name().name());
    }

    public void selectEmployeeToUpdate() {
        var _customerList = validateHelpers.getList(employeeNameList);
        if (_customerList.isEmpty()) {
            createEmployeesPage.gotoCreateEmployeePage();
            validateHelpers.waitForLoadJsCreatePage();
            createEmployeesPage.enterEmployeeName();
            validateHelpers.waitAfterChoseOrClickElement();
            createEmployeesPage.enterPhoneNumberArabic();
            validateHelpers.waitForLoadJs();
            createEmployeesPage.clickOnCreateEmployeeButton();
            validateHelpers.waitForLoadJs();
            createEmployeesPage.verifyAfterCreate();
            _customerList = validateHelpers.getList(employeeNameList);
        }
        var _random = random.nextInt(_customerList.size());
        _employeeUpdated = _customerList.get(_random).getText();
        _customerList.get(_random).click();
        System.out.println("The customer has been selected: " + _employeeUpdated);
    }

    public void gotoEmployeeTable() {
        validateHelpers.clickElement(employeeLeftMenu);
    }
}
