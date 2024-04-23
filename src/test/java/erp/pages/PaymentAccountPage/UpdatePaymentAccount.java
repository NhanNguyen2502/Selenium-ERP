package erp.pages.PaymentAccountPage;

import erp.common.helpers.*;
import erp.pages.CompanyListPage;
import erp.pages.ProductPage.CreateProductPage;
import erp.pages.SignInPage;
import org.openqa.selenium.*;
import org.python.antlr.ast.Str;
import org.testng.Assert;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.WeakHashMap;

public class UpdatePaymentAccount {
    private WebDriver driver;
    private ValidateHelpers validateHelpers;
    private CreatePaymentAccount createPaymentAccount;
    private Random random;
    private DecimalFormat decimalFormat;
    private SignInPage signInPage;
    private CompanyListPage companyListPage;
    private PaymentTable paymentTable;
    private String _paymentUpdate;
    private String _newPaymentName;
    private String _type;
    private String _oldOpeningBalance = "";
    private boolean _defaultAccount = false;


    public UpdatePaymentAccount(WebDriver driver) {
        this.driver = driver;
        validateHelpers = new ValidateHelpers(driver);
        createPaymentAccount = new CreatePaymentAccount(driver);
        random = new Random();
        decimalFormat = new DecimalFormat();
        signInPage = new SignInPage(driver);
        companyListPage = new CompanyListPage(driver);
        paymentTable = new PaymentTable(driver);
    }

    private By paymentAccountNameList = By.xpath("//span[@data-cy='account-name-data']");
    private By paymentAccountTypeField = By.xpath("//input[@data-cy='language-select-input']");
    private By paymentNameField = By.xpath("//input[@data-cy='bank-name-input']");
    private By paymentNameExist = By.xpath("//div[@data-cy='account-name-exists-error']");
    private By saveButton = By.xpath("//act-button[@data-cy='account-save-create-button']");
    private By paymentAccountTableTitle = By.xpath("//span[@data-cy='breadcrumb-label']");
    private By paymentAccountNumber = By.xpath("//input[@data-cy='account-number-input']");
    private By paymentOpeningBalance = By.xpath("//input[@data-cy='opening-balance']");
    private By paymentAccountType = By.xpath("//span[@data-cy='account-type-data']");
    private By balanceDateField = By.xpath("//input[@data-cy='balance-date']");
    private By confirmChangeOpeningBalanceButton = By.xpath("//act-button[@data-cy='confirm-button']");
    private By paymentDisableOrEnableToggle = By.xpath("(//mat-slide-toggle[@data-cy='account-status-toggle'])[2]");
    private By confirmDisableOrEnable = By.xpath("//button[@data-cy='dialog-yes-button']");
    private By cancelDisableOrEnable = By.xpath("//button[@data-cy='dialog-cancel-button']");
    private By paymentAccountStatus = By.xpath("//div[@id='account-status']");
    private By deletePaymentAccountButton = By.xpath("//act-button[@data-cy='delete-bank-account-button']");
    private By confirmDeleteButton = By.xpath("//act-button[@data-cy='delete-button']");
    private By paymentCancelButton = By.xpath("//act-button[@data-cy='account-cancel-button']");
    private By cancelDeleteButton = By.xpath("//act-button[@data-cy='cancel-button']");
    private By paymentInternationalCheckbox = By.xpath("//mat-checkbox//input");
    private By paymentInternationalField = By.xpath("(//mat-checkbox//label//span)[1]");
    private By paymentIbanField = By.xpath("//input[@data-cy='bank-ibanNumber-input']");
    private By swiftBicFieled = By.xpath("//input[@data-cy='swiftNumber-input']");
    private By confirmChangeBalanceDialog = By.xpath("//app-confirm-change-opening-balance-dialog");

    public void updatePaymentAccountNumber(String language, String paymentType) {
        selectPaymentAccountToUpdateByType(language, paymentType);
        validateHelpers.waitForLoadJsCreatePage();
        updateAccountNumber(language);
        validateHelpers.waitAfterChoseOrClickElement();
    }

    public void enablePaymentAccountWithConfirm(String language, String paymentType) {
        paymentTable.filterDisabled();
        validateHelpers.waitForLoadJs();
        selectPaymentAccountToUpdateByType(language, paymentType);
        validateHelpers.waitForLoadJsCreatePage();
        clickOnToggleToEnableOrDisable();
        validateHelpers.waitAfterChoseOrClickElement();
        confirmEnablePaymentAccount(language);
        validateHelpers.waitForLoadJs();
    }

    public void confirmEnablePaymentAccount(String language) {

        validateHelpers.clickElement(confirmDisableOrEnable);
        validateHelpers.waitAfterChoseOrClickElement();
        try {
            Assert.assertTrue(driver.findElement(paymentAccountStatus).getText().equals(TranslationHelpers.setFile(language, "$.company.editViewPage.tabBankAccount.text.enabled")));
            System.out.println("Enabled payment account success.");
            validateHelpers.waitAfterChoseOrClickElement();
            clickOnSaveButton();
        } catch (NoSuchElementException e) {
            Assert.fail("Disable Failed.");
        }
    }

    public void updateSwiftIbanOfPaymentAccount(String language, String paymentType) {
        selectPaymentAccountToUpdateByType(language, paymentType);
        validateHelpers.waitForLoadJsCreatePage();
        updateIBanAndSwift();
        validateHelpers.waitAfterChoseOrClickElement();
    }

    public void updateIBanAndSwift() {
        if (checkPaymentAccountHasInternational()) {
            if (!validateHelpers.getMessage(paymentIbanField).isEmpty())
                validateHelpers.clearElement(paymentIbanField);
            if (!validateHelpers.getMessage(swiftBicFieled).isEmpty())
                validateHelpers.clearElement(swiftBicFieled);
        } else {
            validateHelpers.clickElement(paymentInternationalField);
        }
        createPaymentAccount.enterIban();
        validateHelpers.waitAfterChoseOrClickElement();
        createPaymentAccount.enterBicOrSwift();
    }

    public void updateSwiftBicOfPaymentAccount(String language, String paymentType) {
        selectPaymentAccountToUpdateByType(language, paymentType);
        validateHelpers.waitForLoadJsCreatePage();
        updateSwiftBic();
        validateHelpers.waitAfterChoseOrClickElement();
    }

    public void updateSwiftBic() {
        if (checkPaymentAccountHasInternational() && !validateHelpers.getMessage(swiftBicFieled).isEmpty()) {
            validateHelpers.clearElement(swiftBicFieled);
        } else {
            validateHelpers.clickElement(paymentInternationalField);
        }
        createPaymentAccount.enterBicOrSwift();
    }

    public void updateIbanOfPaymentAccount(String language, String paymentType) {
        selectPaymentAccountToUpdateByType(language, paymentType);
        validateHelpers.waitForLoadJsCreatePage();
        updateIban();
        validateHelpers.waitAfterChoseOrClickElement();
    }

    public void updateIban() {
        if (checkPaymentAccountHasInternational() && !validateHelpers.getMessage(paymentIbanField).isEmpty()) {
            validateHelpers.clearElement(paymentIbanField);
        } else {
            validateHelpers.clickElement(paymentInternationalField);
        }
        createPaymentAccount.enterIban();
    }

    public boolean checkPaymentAccountHasInternational() {
        var a = driver.findElement(paymentInternationalCheckbox).getAttribute("aria-checked");
        return a.equals("true");
    }

    public void deletePaymentAccountWithConfirm(String language, String paymentType) {
        selectPaymentAccountToUpdateByType(language, paymentType);
        validateHelpers.waitForLoadJsCreatePage();
        clickOnDeleteButton();
        validateHelpers.waitAfterChoseOrClickElement();
        confirmDeletePaymentAccount(language);
        validateHelpers.waitAfterChoseOrClickElement();
    }

    public void deletePaymentAccountWithCancel(String language, String paymentType) {
        selectPaymentAccountToUpdateByType(language, paymentType);
        validateHelpers.waitForLoadJsCreatePage();
        clickOnDeleteButton();
        validateHelpers.waitAfterChoseOrClickElement();
        cancelDeletePaymentAccount();
        validateHelpers.waitAfterChoseOrClickElement();
    }

    public void cancelDeletePaymentAccount() {
        try {
            driver.findElement(cancelDeleteButton).click();
            Assert.assertTrue(driver.findElement(paymentNameField).isDisplayed());
            System.out.println("Cancel delete success.");
        } catch (NoSuchElementException e) {
            Assert.fail("Can not find Cancel Delete button");
        }

    }

    public void confirmDeletePaymentAccount(String language) {
        try {
            validateHelpers.clickElement(confirmDeleteButton);
            validateHelpers.waitAfterChoseOrClickElement();
            if (!_type.equals(GetTypeOfPaymentAccountHelper.getCashType(language)) && !validateHelpers.checkElemenNull(paymentNameField)) {
                if (checkPaymentAccountHasBeenUsedOnTheInvoiceOrNot()) {
                    System.out.println("This account has been used on the invoice");
                } else {
                    Assert.fail("Delete failed.");
                }
            } else {
                if (validateHelpers.checkElemenNull(paymentNameField)) {
                    Assert.assertTrue(validateHelpers.checkElemenNull(paymentNameField));
                    System.out.println("Payment account has been deleted.");
                } else {
                    System.out.println("Maybe Cash has been used on the invoice.");
                }
            }

        } catch (NoSuchElementException e) {
            Assert.fail("Can not find Confirm delete.");
        }

    }

    public void clickOnDeleteButton() {
        validateHelpers.clickElement(deletePaymentAccountButton);
    }

    public void disablePaymentAccountWithCancel(String language, String paymentType) {
        paymentTable.filterEnable();
        validateHelpers.waitForLoadJs();
        selectPaymentAccountToUpdateByType(language, paymentType);
        validateHelpers.waitForLoadJs();
        clickOnToggleToEnableOrDisable();
        validateHelpers.waitForLoadJs();
        cancelDisablePaymentAccount(language);
        validateHelpers.waitForLoadJs();
    }

    public void disablePaymentAccountWithConfirm(String language, String paymentType) {
        paymentTable.filterEnable();
        validateHelpers.waitForLoadJs();
        selectPaymentAccountToUpdateByType(language, paymentType);
        validateHelpers.waitForLoadJsCreatePage();
        clickOnToggleToEnableOrDisable();
        validateHelpers.waitAfterChoseOrClickElement();
        confirmDisablePaymentAccount(language);
        validateHelpers.waitForLoadJs();
    }

    public void cancelDisablePaymentAccount(String language) {
        if (_defaultAccount) {
            validateHelpers.clickElement(cancelDisableOrEnable);
            validateHelpers.waitAfterChoseOrClickElement();
            try {
                Assert.assertTrue(driver.findElement(paymentAccountStatus).getText().equals(TranslationHelpers.setFile(language, "$.company.editViewPage.tabBankAccount.text.enabled")));
                System.out.println("Canceled disabled payment account success.");
                clickOnSaveButton();
            } catch (NoSuchElementException e) {
                Assert.fail("Canceled disable Failed.");
            }
        }

    }

    public void confirmDisablePaymentAccount(String language) {
        if (_defaultAccount) {
            validateHelpers.clickElement(confirmDisableOrEnable);
            validateHelpers.waitAfterChoseOrClickElement();
            try {
                Assert.assertTrue(driver.findElement(paymentAccountStatus).getText().equals(TranslationHelpers.setFile(language, "$.company.editViewPage.tabBankAccount.text.disabled")));
                System.out.println("Disabled payment account success.");
                validateHelpers.waitAfterChoseOrClickElement();
                clickOnSaveButton();
            } catch (NoSuchElementException e) {
                Assert.fail("Disable Failed.");
            }
        }
    }

    public void clickOnToggleToEnableOrDisable() {
        var a = validateHelpers.getCSSValue(paymentDisableOrEnableToggle, "pointer-events");
        if (!a.equals("none")) {
            validateHelpers.clickElement(paymentDisableOrEnableToggle);
            _defaultAccount = true;
        } else {
            validateHelpers.clickElement(paymentCancelButton);
            System.out.println("This payment has been set default, so we can not disable.");
        }
    }

    public void updateOpeningBalance() {
        try {
            _oldOpeningBalance = validateHelpers.getValueByAttribute(paymentOpeningBalance);
            if (!_oldOpeningBalance.isEmpty()) {
                validateHelpers.clearElement(paymentOpeningBalance);
                createPaymentAccount.enterOpeningBalance();
                validateHelpers.waitAfterChoseOrClickElement();
                validateHelpers.setText(balanceDateField, "");
                createPaymentAccount.enterBalanceDate();
            } else {
                createPaymentAccount.enterOpeningBalance();
                validateHelpers.waitAfterChoseOrClickElement();
                createPaymentAccount.enterBalanceDate();
            }
        } catch (NoSuchElementException e) {
            Assert.fail("Update payment opening balance!!!");
        }
        validateHelpers.waitAfterChoseOrClickElement();
    }

    public void updateAccountNumber(String language) {
        try {
            if (!_type.equals(GetTypeOfPaymentAccountHelper.getCashType(language))) {
                if (!checkPaymentAccountHasBeenUsedOnTheInvoiceOrNot()) {
                    validateHelpers.clearElement(paymentAccountNumber);
                    createPaymentAccount.enterAccountNumber();
                } else {
                    System.out.println("The payment account has been used on the invoice, you can not update payment account number.");
                }
            } else {
                System.out.println("Can not update payment account, because payment account type Cash");
            }
        } catch (NoSuchElementException e) {
            Assert.fail("Can not find payment account number");
        }
        validateHelpers.waitAfterChoseOrClickElement();
    }

    public boolean checkPaymentAccountHasBeenUsedOnTheInvoiceOrNot() {
        try {
            var _check = driver.findElement(paymentAccountNumber).getAttribute("readonly");
            return _check != null && _check.equals("true");
        } catch (NoSuchElementException e) {
            Assert.fail("Can not find payment account number field.");
            return false;
        }
    }

    public void saveSuccessAfterClickOnSaveButton() {
        clickOnSaveButton();
        validateHelpers.waitForLoadJs();
        verifyUpdateSuccess();
        validateHelpers.waitAfterChoseOrClickElement();
    }

    public void saveFailedAfterClickOnSaveButton() {
        clickOnSaveButton();
        validateHelpers.waitForLoadJs();
        verifyUpdateFailed();
        validateHelpers.waitAfterChoseOrClickElement();
    }

    public void verifyUpdateFailed() {
        try {
            Assert.assertTrue(validateHelpers.checkElemenNull(paymentAccountTableTitle));
            System.out.println("Updated payment account Failed!!");
        } catch (NoSuchElementException e) {
            Assert.fail("");
        }
    }

    public void verifyUpdateSuccess() {
        try {
            Assert.assertTrue(validateHelpers.checkElemenNull(paymentNameField));
            if (_newPaymentName == null) {
                System.out.println("Updated payment account successfully!!");
            } else {
                System.out.println("Updated payment account success with name: " + _newPaymentName);
            }
        } catch (NoSuchElementException e) {
            Assert.fail("Update payment account failed!!!");
        }
    }

    public void clickOnSaveButton() {
        validateHelpers.clickElement(saveButton);
        try {
            if (driver.findElement(confirmChangeBalanceDialog).isDisplayed()) {
                validateHelpers.clickElement(confirmChangeOpeningBalanceButton);
            }
        } catch (NoSuchElementException e) {
            System.out.println("");
        }

    }

    public String updatePaymentAccountName() {
        var a = validateHelpers.getValueByAttribute(paymentNameField);
        _newPaymentName = FakeDataHelper.getFakedata().finance().stockMarket();
        validateHelpers.clearElement(paymentNameField);
        validateHelpers.setText(paymentNameField, _newPaymentName);
        validateHelpers.clickOutside();
        try {
            for (int i = 0; ; i++) {
                if (driver.findElement(paymentNameExist).isDisplayed() || _newPaymentName.equals(a)) {
                    _newPaymentName = FakeDataHelper.getFakedata().finance().stockMarket();
                    validateHelpers.clearElement(paymentNameField);
                    validateHelpers.setText(paymentNameField, _newPaymentName);
                    a = validateHelpers.getValueByAttribute(paymentNameField);
                } else {
                    break;
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println("Can update payment account with this name.");
        }
        validateHelpers.waitAfterChoseOrClickElement();
        return _newPaymentName;

    }

    public void loginAndGoToPaymentAccountTable(String language) {
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJsLoginPage();
        validateHelpers.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        createPaymentAccount.goToPaymentTable();
        validateHelpers.waitForLoadJs();
    }

    public String selectPaymentAccountToUpdateByType(String language, String type) {
        if (type.equals("Cash")) {
            _type = GetTypeOfPaymentAccountHelper.getCashType(language);
        } else if (type.equals("Bank")) {
            _type = GetTypeOfPaymentAccountHelper.getBankType(language);

        } else {
            _type = GetTypeOfPaymentAccountHelper.getPaymentServiceType(language);
        }
        validateHelpers.waitAfterChoseOrClickElement();
        paymentTable.searchPaymentAccountName(_type);
        validateHelpers.waitForLoadJs();
        var _paymentAccountList = validateHelpers.getList(paymentAccountNameList);
        var _paymentAccountTypes = validateHelpers.getList(paymentAccountType);
        var _paymentRandom = random.nextInt(0, _paymentAccountTypes.size());
        for (int i = 0; i < _paymentAccountTypes.size(); i++) {
            if (_paymentAccountTypes.get(_paymentRandom).getText().equals(_type)) {
                _paymentUpdate = _paymentAccountList.get(_paymentRandom).getText();
                System.out.println("Payment Account has been selected: " + _paymentUpdate);
                _paymentAccountTypes.get(_paymentRandom).click();
                break;
            } else {
                _paymentRandom = random.nextInt(0, _paymentAccountTypes.size());
                System.out.println("This account not math with type");
            }
        }

        validateHelpers.waitForLoadJs();
        return _type;
    }

    public void selectRandomPaymentAccountToUpdate() {
        var _paymentAccountList = validateHelpers.getList(paymentAccountNameList);
        var _ran = random.nextInt(0, _paymentAccountList.size());
        if (_paymentAccountList.isEmpty()) {
            createPaymentAccount.goToCreatePaymentAccountPage();
            validateHelpers.waitForLoadJsCreatePage();
            createPaymentAccount.enterPaymentName();
            validateHelpers.waitAfterChoseOrClickElement();
            createPaymentAccount.enterAccountNumber();
            validateHelpers.waitAfterChoseOrClickElement();
            createPaymentAccount.clickOnCreateButton();
            validateHelpers.waitForLoadJs();
            _paymentAccountList = validateHelpers.getList(paymentAccountNameList);
            _ran = random.nextInt(0, _paymentAccountList.size());
        }
        _paymentUpdate = _paymentAccountList.get(_ran).getText();
        _paymentAccountList.get(_ran).click();
        System.out.println("Payment Account has been selected: " + _paymentUpdate);
        validateHelpers.waitForLoadJs();
    }

}
