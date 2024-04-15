package erp.pages.Customer;

import erp.common.helpers.AttachmentDocumentHelper;
import erp.common.helpers.FakeDataHelper;
import erp.common.helpers.PropertiesHelper;
import erp.common.helpers.ValidateHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.text.DecimalFormat;
import java.util.Random;

public class CreateCustomerPage {
    private WebDriver driver;
    private ValidateHelpers validateHelpers;
    private Random ran;
    private AttachmentDocumentHelper attachmentDocumentHelper;
    private String _customerNameExist;

    //Create Customer on the create Invoice Page
    private By invoiceAddCustomerButton = By.xpath("(//button[@apptooltip='regularInvoice.button.createContactTooltip'])[2]");
    private By invoiceCustomerNamefield = By.xpath("//input[@apptooltip='invoicesCommon.dialog.createEditContact.inputField.contactNameTooltip']");
    private By invoiceCreateCustomerButton = By.xpath("//app-create-edit-contact-dialog//button[@data-cy='dialog-confirm-button']");
    private By invoiceCustomerNameError = By.xpath("//mat-error//div");
    private By customerLeftMenu = By.xpath("//a[@data-cy='sidebar-customer-link']");
    private By cusTometTableCreateCustomerButton = By.xpath("//button[@data-cy='create-contact-button']");
    private By customerNameField = By.xpath("//input[@data-cy='contact-name']");
    private By customerNameExist = By.xpath("//div[@data-cy='name-exist-error-message']");
    private By customerEmailField = By.xpath("//input[@data-cy='email']");
    private By phoneDialCodeField = By.xpath("//input[@data-cy='phone-dial-code-input']");
    private By phoneNumberWarning = By.xpath("//mat-error");
    private By phonenumberField = By.xpath("//input[@data-cy='phone-number-input']");
    private By createButton = By.xpath("//button[@data-cy='create-contact-button']");
    private By customerTitle = By.xpath("//span[@data-cy='customer-list-title']");
    private By customerGroup = By.xpath("//input[@data-cy='group-chip-input']");
    private By customerDiscount = By.xpath("//input[@data-cy='contact-discount-setting']");
    private By customerCurrencyField = By.xpath("//input[@id='currency-input']");
    private By customerCurrencyList = By.xpath("//mat-option");
    private By customerGroupList = By.xpath("//mat-option");
    private By customerLanguageFiled = By.xpath("//input[@data-cy='language-select-input']");
    private By customerLanguageList = By.xpath("//mat-option[@data-cy='language-select-option']");
    private By customerNameRequiredTex = By.xpath("//div[@data-cy='name-required-error-message']");
    private By customerAvatarField = By.xpath("//input[@apptooltip='avatar.tooltips.uploadImageTooltip']");
    private By customerConfirmDropAvatarButton = By.xpath("//button[@data-cy='save-imapge-uplaod-button']");
    private By customerCancelUploadAvatarButton = By.xpath("//button[@data-cy='cancel-image-uplaod-button']");
    private By customerNameList = By.xpath("//div[@data-cy='contact-name']");
    private By customerExistWarning = By.xpath("//div[@data-cy='name-exist-error-message']");
    private By supplierLeftMenu = By.xpath("//a[@data-cy='sidebar-supplier-link']");
    private By arabicDialCode = By.xpath("//mat-option[@data-cy='phone-dial-code-option']");

    public CreateCustomerPage(WebDriver driver) {
        this.driver = driver;
        validateHelpers = new ValidateHelpers(driver);
        ran = new Random();
        attachmentDocumentHelper = new AttachmentDocumentHelper(driver);
    }

    public void gotoSupplierTable()
    {
        validateHelpers.clickElement(supplierLeftMenu);
    }

    public void verifyCustomerNameExist()
    {
        try {
            if(driver.findElement(customerNameExist).isDisplayed())
            {
                System.out.println("Contact with the same name already exists.");
            }
        }catch (NoSuchElementException e)
        {
            System.out.println("You can create Contact with this name.");
        }
    }

    public void enterNameAlreadyExist(){
        if(!_customerNameExist.isEmpty())
        {
            validateHelpers.setText(customerNameField,_customerNameExist);
        }
        else {
            enterCustomerName();
        }
    }
    public void getNameAlreadyExist() {
        var _nameList = validateHelpers.getList(customerNameList);
        if(!_nameList.isEmpty())
        {
            var _selectRandom = ran.nextInt(_nameList.size());
            _customerNameExist = _nameList.get(_selectRandom).getText();
        }
        else
        {
            System.out.println("The list name is empty");
            _customerNameExist = null;
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

    public void selectGroupAlreadyExist() {
        validateHelpers.clickElement(customerGroup);
        var _groupList = validateHelpers.getList(customerGroupList);
        var _groupRandom = ran.nextInt(_groupList.size());
        if (!_groupList.isEmpty()) {
            _groupList.get(_groupRandom).click();
        } else {
            enterGroupForCustomer();
        }
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

    public void enterAnotherLanguage() {
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

    public void enterAnotherCurrency() {
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

    public void enterDiscount() {
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        var _discountRandom = ran.nextDouble(1, 100);
        validateHelpers.clearElement(customerDiscount);
        validateHelpers.setText(customerDiscount, String.valueOf(df.format(_discountRandom)));
    }

    public void enterGroupForCustomer() {
        validateHelpers.setText(customerGroup, FakeDataHelper.getFakedata().name().title());
    }

    public void verifyCreate() {
        try {
            if (driver.findElement(customerTitle).isDisplayed()) {
                System.out.println("Create Customer successfully!!!");
            }
        } catch (NoSuchElementException e) {
            System.out.println("Create Failed.");
        }
    }

    public void clickOnCreateButton() {
        validateHelpers.clickElement(createButton);
    }

    public void enterPhoneNumberArabic() {
        var _phoneDial = validateHelpers.getValueByAttribute(phoneDialCodeField);
        if (!_phoneDial.contains("+964")) {
            validateHelpers.clearElement(phoneDialCodeField);
            validateHelpers.setText(phoneDialCodeField, "+964");
            validateHelpers.clickElement(arabicDialCode);
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

    public void enterEmail() {
        validateHelpers.setText(customerEmailField, FakeDataHelper.getFakedata().text().text(3) + "@mailinator.com");
    }

    public void enterCustomerName() {
        validateHelpers.setText(customerNameField, FakeDataHelper.getFakedata().name().name());
        validateHelpers.clickOutside();
        try {
            if (driver.findElement(customerNameExist).isDisplayed()) {
                for (int i = 0; ; i++) {
                    if (driver.findElement(customerNameExist).isDisplayed()) {
                        validateHelpers.clearElement(customerNameField);
                        validateHelpers.setText(customerNameField, FakeDataHelper.getFakedata().name().name().replace("."," "));
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

    public void goToCreateCustomerPage() {
        validateHelpers.clickElement(cusTometTableCreateCustomerButton);
    }

    public void goToTheCustomerTable() {
        validateHelpers.clickElement(customerLeftMenu);
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
