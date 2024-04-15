package erp.pages.Customer;

import erp.common.helpers.AttachmentDocumentHelper;
import erp.common.helpers.FakeDataHelper;
import erp.common.helpers.PropertiesHelper;
import erp.common.helpers.ValidateHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.text.DecimalFormat;
import java.util.Random;

public class UpdateCustomerPage {
    private WebDriver driver;
    private ValidateHelpers validateHelpers;
    private Random ran;
    private AttachmentDocumentHelper attachmentDocumentHelper;
    private CreateCustomerPage createCustomerPage;
    private String _customerdeleted;
    private String _customerUpdated;
    private String _customerNameAfterUpdated;
    private CustomerTable customerTable;

    private By customerNameList = By.xpath("//div[@data-cy='contact-name']");
    private By customerLeftMenu = By.xpath("//a[@data-cy='sidebar-customer-link']");
    private By customerNameField = By.xpath("//input[@data-cy='contact-name']");
    private By saveButton = By.xpath("//button[@data-cy='create-contact-button']");
    private By customerTitle = By.xpath("//span[@data-cy='customer-list-title']");
    private By customerAvatarField = By.xpath("//input[@apptooltip='avatar.tooltips.uploadImageTooltip']");
    private By customerConfirmDropAvatarButton = By.xpath("//button[@data-cy='save-imapge-uplaod-button']");
    private By customerCancelUploadAvatarButton = By.xpath("//button[@data-cy='cancel-image-uplaod-button']");
    private By deleteAvatarButton = By.xpath("//app-avatar//app-expanding-button");
    private By confirmDeleteAvatarButton = By.xpath("//button[@data-cy='dialog-yes-button']");
    private By cancelDeleteAvatar = By.xpath("//button[@data-cy='dialog-cancel-button']");
    private By disableEnableCustomerButton = By.xpath("//mat-slide-toggle");
    private By confirmDisabledEnable = By.xpath("//button[@data-cy='dialog-yes-button']");
    private By cancelDisableEnableCustomer = By.xpath("//button[@data-cy='dialog-cancel-button']");
    private By customerLanguageFiled = By.xpath("//input[@data-cy='language-select-input']");
    private By customerLanguageList = By.xpath("//mat-option[@data-cy='language-select-option']");
    private By customerCurrencyField = By.xpath("//input[@id='currency-input']");
    private By customerCurrencyList = By.xpath("//mat-option");
    private By customerNameExist = By.xpath("//div[@data-cy='name-exist-error-message']");
    private By customerGroup = By.xpath("//input[@data-cy='group-chip-input']");
    private By customerGroupList = By.xpath("//mat-option");
    private By customerDiscount = By.xpath("//input[@data-cy='contact-discount-setting']");
    private By customerEmailField = By.xpath("//input[@data-cy='email']");
    private By phoneDialCodeField = By.xpath("//input[@data-cy='phone-dial-code-input']");
    private By phoneNumberWarning = By.xpath("//mat-error");
    private By phonenumberField = By.xpath("//input[@data-cy='phone-number-input']");
    private By arabicDialCode = By.xpath("//mat-option[@data-cy='phone-dial-code-option']");
    private By customerNameRequiredTex = By.xpath("//div[@data-cy='name-required-error-message']");
    private By customerDeleteButton = By.xpath("//button[@data-cy='contact-delete-button']");
    private By customerConfirmDelete = By.xpath("//button[@data-cy='delete-button']");
    private By customerCancelDelete = By.xpath("//button[@data-cy='cancel-button']");


    public UpdateCustomerPage(WebDriver driver) {
        this.driver = driver;
        validateHelpers = new ValidateHelpers(driver);
        ran = new Random();
        attachmentDocumentHelper = new AttachmentDocumentHelper(driver);
        createCustomerPage = new CreateCustomerPage(driver);
        customerTable = new CustomerTable(driver);
    }


    public void verifyDeleteFailed() {
        try {
            Assert.assertTrue(validateHelpers.checkElemenNull(customerTitle));
            System.out.println("Deleted Failed: " + _customerdeleted);
        } catch (NoSuchElementException e) {
            Assert.fail("Verify Failed");
        }
    }
    public void verifyDeleteSuccess() {
        try {
            Assert.assertTrue(driver.findElement(customerTitle).isDisplayed());
            System.out.println("Deleted Success: " + _customerdeleted);
        } catch (NoSuchElementException e) {
            Assert.fail("Delete Failed");
        }
    }

    public void cancelDelete() {
        validateHelpers.clickElement(customerCancelDelete);
    }

    public void confirmDelete() {
        validateHelpers.clickElement(customerConfirmDelete);
    }

    public void deleteCustomer() {
        _customerdeleted = validateHelpers.getValueByAttribute(customerNameField);
        validateHelpers.clickElement(customerDeleteButton);
    }

    public void checkCustomerNameNull() {
        try {
            if (driver.findElement(customerNameRequiredTex).isDisplayed()) {
                System.out.println("Customer name  is null");
            }
        } catch (NoSuchElementException e) {
            System.out.println("Text required does not exist!!!");
        }
    }

    public void updateCustomerNameNull() {
        validateHelpers.clickElement(customerNameField);
        validateHelpers.clearElement(customerNameField);
        validateHelpers.clickOutside();
    }

    public void updatePhoneNumberArabic() {
        var _phoneDial = validateHelpers.getValueByAttribute(phoneDialCodeField);
        if (!_phoneDial.contains("+964")) {
            validateHelpers.clearElement(phoneDialCodeField);
            validateHelpers.setText(phoneDialCodeField, "+964");
            validateHelpers.clickElement(arabicDialCode);
        }
        try {
            validateHelpers.clearElement(phonenumberField);
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

    public void updateEmail() {
        validateHelpers.clearElement(customerEmailField);
        validateHelpers.setText(customerEmailField, FakeDataHelper.getFakedata().text().text(3) + "@mailinator.com");
    }

    public void updateDiscount() {
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        var _discountRandom = ran.nextDouble(1, 100);
        validateHelpers.clearElement(customerDiscount);
        validateHelpers.setText(customerDiscount, String.valueOf(df.format(_discountRandom)));
    }

    public void enterGroupForCustomer() {
        validateHelpers.setText(customerGroup, FakeDataHelper.getFakedata().name().title());
    }

    public void updatetGroupAlreadyExist() {
        validateHelpers.clickElement(customerGroup);
        var _groupList = validateHelpers.getList(customerGroupList);
        var _groupRandom = ran.nextInt(_groupList.size());
        if (!_groupList.isEmpty()) {
            _groupList.get(_groupRandom).click();
        } else {
            enterGroupForCustomer();
        }
    }

    public void updateAnotherCurrency() {
        var _oldCurrency = validateHelpers.getValueByAttribute(customerCurrencyField);
        validateHelpers.clickElement(customerCurrencyField);
        var _currencyList = validateHelpers.getList(customerCurrencyList);
        var _currencyRandom = ran.nextInt(_currencyList.size());
        for (int i = 0; ; i++) {
            if (_currencyList.get(_currencyRandom).getText().contains(_oldCurrency)) {
                _currencyRandom = ran.nextInt(_currencyList.size());
            } else {
                _currencyList.get(_currencyRandom).click();
                break;
            }
        }
    }

    public void updateAnotherLanguage() {
        var _oldLanguage = validateHelpers.getValueByAttribute(customerLanguageFiled);
        validateHelpers.clickElement(customerLanguageFiled);
        var _languageList = validateHelpers.getList(customerLanguageList);
        var _languageRandom = ran.nextInt(_languageList.size());
        for (int i = 0; ; i++) {
            if (_languageList.get(_languageRandom).getText().contains(_oldLanguage)) {
                _languageRandom = ran.nextInt(_languageList.size());
            } else {
                _languageList.get(_languageRandom).click();
                break;
            }
        }
    }

    public void cancelEnableCustomer() {
        validateHelpers.clickElement(cancelDisableEnableCustomer);
        System.out.println("Cancel Enabled");
    }

    public void confirmEnableCustomer() {
        validateHelpers.clickElement(confirmDisabledEnable);
        System.out.println("Confirm Enabled");
    }

    public void enableCustomer() {
        validateHelpers.clickElement(disableEnableCustomerButton);
    }

    public void cancelDisableCustomer() {
        validateHelpers.clickElement(cancelDisableEnableCustomer);
        System.out.println("Cancel Disabled");
    }

    public void confirmDisableCustomer() {
        validateHelpers.clickElement(confirmDisabledEnable);
        System.out.println("Confirm Disable");
    }

    public void disableCustomer() {
        validateHelpers.clickElement(disableEnableCustomerButton);
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
        validateHelpers.clickElement(customerCancelUploadAvatarButton);
        var _avatar = validateHelpers.getValueByAttribute(customerAvatarField);
        if (_avatar.isEmpty()) {
            System.out.println(" Cancel upload Avatar success!");
        } else {
            System.out.println("Cancel upload Avatar failed!");
        }
    }

    public void confirmDropAvatar() {
        validateHelpers.clickElement(customerConfirmDropAvatarButton);
        var _avatar = validateHelpers.getValueByAttribute(customerAvatarField);
        if (!_avatar.isEmpty()) {
            System.out.println("Upload Avatar success!");
        } else {
            System.out.println("Upload Avatar failed!");
        }
    }

    public void uploadAvatar() {
        attachmentDocumentHelper.addAvatar(customerAvatarField);
    }

    public void verifyUpdateFailed() {
        Assert.assertTrue(validateHelpers.checkElemenNull(customerTitle));
        System.out.println("Create Customer Failed.");
    }

    public void verifyUpdateSuccess() {
        try {
            Assert.assertTrue(driver.findElement(customerTitle).isDisplayed());
            System.out.println("Customer has been update success: " + _customerNameAfterUpdated);
        } catch (NoSuchElementException e) {
            Assert.fail("Update customer failed!!");
        }
    }

    public String clickOnSaveButton() {
        _customerNameAfterUpdated = validateHelpers.getValueByAttribute(customerNameField);
        validateHelpers.clickElement(saveButton);
        return _customerNameAfterUpdated;
    }

    public void editCustomerName() {
        validateHelpers.clearElement(customerNameField);
        validateHelpers.setText(customerNameField, FakeDataHelper.getFakedata().name().name());
        validateHelpers.clickOutside();
        try {
            if (driver.findElement(customerNameExist).isDisplayed()) {
                for (int i = 0; ; i++) {
                    if (driver.findElement(customerNameExist).isDisplayed()) {
                        validateHelpers.clearElement(customerNameField);
                        validateHelpers.setText(customerNameField, FakeDataHelper.getFakedata().name().name());
                        validateHelpers.clickOutside();
                    } else {
                        break;
                    }
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println("Element does not exist! ");
        }
    }

    public void selectCustomerToUpdate() {
        var _customerList = validateHelpers.getList(customerNameList);
        if (_customerList.isEmpty()) {
            createCustomerPage.goToCreateCustomerPage();
            validateHelpers.waitForLoadJsCreatePage();
            createCustomerPage.enterCustomerName();
            validateHelpers.waitAfterChoseOrClickElement();
            createCustomerPage.clickOnCreateButton();
            validateHelpers.waitForLoadJs();
            createCustomerPage.verifyCreate();
            _customerList = validateHelpers.getList(customerNameList);
        }
        var _random = ran.nextInt(_customerList.size());
        _customerUpdated = _customerList.get(_random).getText();
        _customerList.get(_random).click();
        System.out.println("The customer has been selected: " + _customerUpdated);
    }

    public void selectCustomerToUpdateViaCustomerName(String customerName) {
        customerTable.searchCustomerName(customerName);
        validateHelpers.waitForLoadJs();
        var _customerList = validateHelpers.getList(customerNameList);
        for(WebElement a: _customerList)
        {
            if(a.getText().equals(customerName))
            {
                _customerUpdated = a.getText();
                a.click();
                break;
            }
        }
        System.out.println("The customer has been selected: " + _customerUpdated);
    }

    public void goToTheCustomerTable() {
        validateHelpers.clickElement(customerLeftMenu);
    }
}
