package erp.pages;

import erp.common.helpers.FakeDataHelper;
import erp.common.helpers.TranslationHelpers;
import erp.common.helpers.ValidateHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CreateSalePage {
    private WebDriver driver;
    private WebDriverWait wait;
    private ValidateHelpers validateHelpers;
    private CreateEmployeesPage createEmployeesPage;
    private CreateCustomerPage createCustomerPage;
    private CreateProductPage createProductPage;
    private CreateFeePage createFeePage;
    private String _typeOfSale;
    private String _invoiceInstalmentAmount;
    private static String _standard;
    private static String _instalment;

    private By saleTypeFiled = By.xpath("//app-select//input");
    private By dateAndTye = By.xpath("(//mat-accordion//mat-panel-title)[1]");
    private By expandableonDateAndType = By.xpath("(//button[@data-cy='expandable-buton'])[1]");
    private By saleTypeField = By.xpath("(//mat-form-field)[2]");
    private By saleTypeDropdownButton = By.xpath("//button[@data-cy='drop-down-button']");
    private By typeList = By.xpath("//mat-option");
    private By invoiceDateFiled = By.xpath("(//input[@data-cy='remaining-days'])[2]");
    private By invoiceDatebt = By.xpath("(//mat-datepicker-toggle//button)[1]");
    private By remainingDayfield = By.xpath("(//input[@data-cy='remaining-days'])[1]");
    private By dueDateField = By.xpath("//input[@data-cy='due-date']");
    private By dueDateBt = By.xpath("(//mat-datepicker-toggle//button)[2]");
    private By changeSaleDateBt = By.xpath("(//mat-expansion-panel//button)[4]");
    private By setSaleTypeDefault = By.xpath("(//mat-expansion-panel//button)[3]");
    private By accountSection = By.xpath("//app-sale-draft-account");
    private By logoCompany = By.xpath("//app-sale-draft-account//app-company-logo");
    private By accountField = By.xpath("//app-select-object-control[@id='select-account-number']");
    private By accountDropDownListButton = By.xpath("(//button[@data-cy='drop-down-button'])[2]");
    private By accountList = By.xpath("//mat-option");
    private By editBankAccountButton = By.xpath("//button[@apptooltip='regularInvoice.button.editBankAccount']");
    private By createBankAccountButton = By.xpath("//button[@apptooltip='regularInvoice.button.createBankAccount']");
    private By ourReference = By.xpath("//app-select-object-control[@id='select-our-reference']");
    private By employeeDropdownButton = By.xpath("(//button[@data-cy='drop-down-button'])[3]");
    private By employeeOptionList = By.xpath("//mat-option");
    private By customerField = By.xpath("(//app-select-object-control)[3]");
    private By customerDropdownListButton = By.xpath("(//button[@data-cy='drop-down-button'])[4]");
    private By customerList = By.xpath("//mat-option");
    private By addCustomerButton = By.xpath("(//button[@apptooltip='regularInvoice.button.createContactTooltip'])[2]");
    private By currencyField = By.xpath("//mat-form-field[@data-cy='select-currency-form-field']");
    private By currencyDropdownListbutton = By.xpath("(//button[@data-cy='drop-down-button'])[5]");
    private By receiptLanguageField = By.xpath("//app-language-select");
    private By receiptLanguageButton = By.xpath("(//button[@data-cy='drop-down-button'])[6]");
    private By productField = By.xpath("(//mat-form-field)[12]");
    private By productDropDownListButton = By.xpath("(//button[@data-cy='drop-down-button'])[7]");
    private By addNewProductButton = By.xpath("(//button[@data-cy='add-product-button'])[2]");
    private By priceField = By.xpath("//input[@data-cy='price']");
    private By quantityField = By.xpath("//input[@data-cy='quantity']");
    private By discountField = By.xpath("//input[@data-cy='discount']");
    private By removeProductFromProductLine = By.xpath("(//button[@data-cy='product-remove-button'])[1]");
    private By addCommentForEachProductOnProductLine = By.xpath("//app-expanding-button//button");
    private By addProductOnProductLinebutton = By.xpath("(//button[@data-cy='add-product-button'])[3]");
    private By addFeeOnFeeLinebutton = By.xpath("//button[@data-cy='new-fee-row-button']");
    private By invoiceProductDropdownButton = By.xpath("//input[@data-cy='select-product']");
    private By invoiceProductList = By.xpath("//mat-option");
    private By invoiceAddNewFeeOnFeeLineButton = By.xpath("//button[@data-cy='new-fee-row-button']");
    private By invoiceFeeField = By.xpath("//input[@data-cy='select-fee']");
    private By invoiceFeeList = By.xpath("//mat-option");
    private By invoiceCreateInvoiceButton = By.xpath("//button[@data-cy='create-invoice-button']");
    private By invoiceInstalmentPlanAmount = By.xpath("//app-sale-draft-installment-payments//app-amount-display//span[@data-cy='number-before']");
    private By invoiceInstalamoutField = By.xpath("//input[@data-cy='installment-amount-input']");
    private By invoiceCreatePlanButton = By.xpath("//button[@data-cy='create-plan-button']");
    private By invoiceCustomerError = By.xpath("//app-select-object-control//mat-error");

    public CreateSalePage(WebDriver driver) {
        this.driver = driver;
        validateHelpers = new ValidateHelpers(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        createEmployeesPage = new CreateEmployeesPage(driver);
        createCustomerPage = new CreateCustomerPage(driver);
        createProductPage = new CreateProductPage(driver);
        createFeePage = new CreateFeePage(driver);
    }

    public void getCustomerError()
    {
        System.out.println(validateHelpers.getMessage(invoiceCustomerError));
    }

    public void clickCreateButton() {
        if(_typeOfSale.equals(_instalment))
        {
            _invoiceInstalmentAmount =  validateHelpers.getMessage(invoiceInstalmentPlanAmount);
            validateHelpers.clearElement(invoiceInstalamoutField);
            validateHelpers.setText(invoiceInstalamoutField,String.valueOf(FakeDataHelper.getFakedata().number().numberBetween(1, Integer.valueOf(_invoiceInstalmentAmount))));
            validateHelpers.clickElement(invoiceCreatePlanButton);
            if(validateHelpers.getMessage(invoiceInstalmentPlanAmount).equals(String.valueOf(0)))
            {
                validateHelpers.clickElement(invoiceCreateInvoiceButton);
            }

        }else {
            validateHelpers.clickElement(invoiceCreateInvoiceButton);
        }

    }

    public void selectFee() {
        validateHelpers.clickElement(invoiceAddNewFeeOnFeeLineButton);
        if (!validateHelpers.selectRandom(invoiceFeeField, invoiceFeeList)) {
            createFeePage.createFeeOnInvoice();
        }
    }

    public void selectProduct() {
        if (!validateHelpers.selectRandom(invoiceProductDropdownButton, invoiceProductList)) {
            createProductPage.createProductOnInvoice();
        }
    }

    public void selectCustomer(String warning) {
        if (!validateHelpers.selectRandom(customerDropdownListButton, customerList)) {
            createCustomerPage.createCustomerOnCreateInvoicePage(warning);
        }
    }

    public void selectEmployee(String warning) {
        if (!validateHelpers.selectRandom(employeeDropdownButton, employeeOptionList)) {
            createEmployeesPage.createEmployeeOnCreateInvoicePage(warning);
        }
    }

    public void selectAccountNumber() {
        validateHelpers.selectRandom(accountDropDownListButton, accountList);
    }

    public void checkFeeSection() {
        Assert.assertTrue(validateHelpers.checkDisplayed(addFeeOnFeeLinebutton));
    }

    public void checkProductionSection(String language) {
        if (!_typeOfSale.equals(TranslationHelpers.setFile(language, "$.regularInvoice.select.option.cashSale"))) {
            Assert.assertTrue(validateHelpers.checkDisplayed(productField));
            Assert.assertTrue(validateHelpers.checkDisplayed(productDropDownListButton));
            Assert.assertTrue(validateHelpers.checkDisplayed(addNewProductButton));
            Assert.assertTrue(validateHelpers.checkDisplayed(priceField));
            Assert.assertTrue(validateHelpers.checkDisplayed(quantityField));
            Assert.assertTrue(validateHelpers.checkDisplayed(discountField));
            Assert.assertTrue(validateHelpers.checkDisplayed(removeProductFromProductLine));
            Assert.assertTrue(validateHelpers.checkDisplayed(addCommentForEachProductOnProductLine));
            Assert.assertTrue(validateHelpers.checkDisplayed(addProductOnProductLinebutton));
        } else {
            Assert.assertTrue(validateHelpers.checkDisplayed(productField));
            Assert.assertTrue(validateHelpers.checkDisplayed(productDropDownListButton));
            Assert.assertTrue(validateHelpers.checkDisplayed(addNewProductButton));
            Assert.assertTrue(validateHelpers.checkDisplayed(priceField));
            Assert.assertTrue(validateHelpers.checkDisplayed(quantityField));
            Assert.assertTrue(validateHelpers.checkDisplayed(discountField));
            Assert.assertTrue(validateHelpers.checkDisplayed(removeProductFromProductLine));
            Assert.assertTrue(validateHelpers.checkDisplayed(addProductOnProductLinebutton));
        }

    }

    public void selectSaleType(String type) {
        validateHelpers.clickElement(saleTypeDropdownButton);
        var listType = driver.findElements(typeList);
        for (var x : listType) {
            if (x.getText().equals(type)) {
                x.click();
                break;
            } else {
                System.out.println("Invoice type does not exist");
            }

        }
        _typeOfSale = type;
    }

    public void checkCustomerSection() {
        Assert.assertTrue(validateHelpers.checkDisplayed(customerField));
        Assert.assertTrue(validateHelpers.checkDisplayed(customerDropdownListButton));
        Assert.assertTrue(validateHelpers.checkDisplayed(addCustomerButton));
        Assert.assertTrue(validateHelpers.checkDisplayed(customerField));
        Assert.assertTrue(validateHelpers.checkDisplayed(currencyField));
        Assert.assertTrue(validateHelpers.checkDisplayed(currencyDropdownListbutton));
        Assert.assertTrue(validateHelpers.checkDisplayed(receiptLanguageField));
        Assert.assertTrue(validateHelpers.checkDisplayed(receiptLanguageButton));
    }

    public void checkAccountSection() {
        validateHelpers.checkDisplayed(logoCompany);
        validateHelpers.checkDisplayed(accountField);
        validateHelpers.checkDisplayed(accountDropDownListButton);
        validateHelpers.checkDisplayed(editBankAccountButton);
        validateHelpers.checkDisplayed(createBankAccountButton);
        validateHelpers.checkDisplayed(ourReference);
    }

    public void checkDateAndTypeSection(String saleType, String standard, String instalment) {
        selectSaleType(saleType);
        if (_typeOfSale.equals(standard)) {
            _standard = standard;
            if (!validateHelpers.checkElementDisabled(setSaleTypeDefault)) {
                Assert.assertTrue(validateHelpers.checkDisplayed(dateAndTye));
                Assert.assertTrue(validateHelpers.checkDisplayed(expandableonDateAndType));
                Assert.assertTrue(validateHelpers.checkDisplayed(saleTypeField));
                Assert.assertTrue(validateHelpers.checkDisplayed(saleTypeDropdownButton));
                Assert.assertTrue(validateHelpers.checkDisplayed(invoiceDateFiled));
                Assert.assertTrue(validateHelpers.checkDisplayed(invoiceDatebt));
                Assert.assertTrue(validateHelpers.checkElementDisabled(remainingDayfield));
                Assert.assertTrue(validateHelpers.checkDisplayed(dueDateField));
                Assert.assertTrue(validateHelpers.checkDisplayed(dueDateBt));
                Assert.assertTrue(validateHelpers.checkDisplayed(setSaleTypeDefault));
            } else {
                Assert.assertTrue(validateHelpers.checkDisplayed(dateAndTye));
                Assert.assertTrue(validateHelpers.checkDisplayed(expandableonDateAndType));
                Assert.assertTrue(validateHelpers.checkDisplayed(saleTypeField));
                Assert.assertTrue(validateHelpers.checkDisplayed(saleTypeDropdownButton));
                Assert.assertTrue(validateHelpers.checkDisplayed(invoiceDateFiled));
                Assert.assertTrue(validateHelpers.checkDisplayed(invoiceDatebt));
                Assert.assertTrue(validateHelpers.checkElementDisabled(remainingDayfield));
                Assert.assertTrue(validateHelpers.checkDisplayed(dueDateField));
                Assert.assertTrue(validateHelpers.checkDisplayed(dueDateBt));
            }

        } else if (_typeOfSale.equals(instalment)) {
            _instalment = instalment;
            if (!validateHelpers.checkElementDisabled(setSaleTypeDefault)) {
                Assert.assertTrue(validateHelpers.checkDisplayed(dateAndTye));
                Assert.assertTrue(validateHelpers.checkDisplayed(expandableonDateAndType));
                Assert.assertTrue(validateHelpers.checkDisplayed(saleTypeField));
                Assert.assertTrue(validateHelpers.checkDisplayed(saleTypeDropdownButton));
                Assert.assertTrue(validateHelpers.checkDisplayed(invoiceDateFiled));
                Assert.assertTrue(validateHelpers.checkDisplayed(invoiceDatebt));
                Assert.assertTrue(validateHelpers.checkElementDisabled(remainingDayfield));
                Assert.assertTrue(validateHelpers.checkElementDisabled(dueDateField));
                Assert.assertTrue(validateHelpers.checkElementDisabled(dueDateBt));
                Assert.assertTrue(validateHelpers.checkDisplayed(setSaleTypeDefault));
                Assert.assertTrue(validateHelpers.checkElementDisabled(remainingDayfield));
                Assert.assertTrue(validateHelpers.checkElementDisabled(dueDateField));
            } else {
                Assert.assertTrue(validateHelpers.checkDisplayed(dateAndTye));
                Assert.assertTrue(validateHelpers.checkDisplayed(expandableonDateAndType));
                Assert.assertTrue(validateHelpers.checkDisplayed(saleTypeField));
                Assert.assertTrue(validateHelpers.checkDisplayed(saleTypeDropdownButton));
                Assert.assertTrue(validateHelpers.checkDisplayed(invoiceDateFiled));
                Assert.assertTrue(validateHelpers.checkDisplayed(invoiceDatebt));
                Assert.assertTrue(validateHelpers.checkElementDisabled(remainingDayfield));
                Assert.assertTrue(validateHelpers.checkElementDisabled(dueDateField));
                Assert.assertTrue(validateHelpers.checkElementDisabled(dueDateBt));
                Assert.assertTrue(validateHelpers.checkDisplayed(setSaleTypeDefault));
                Assert.assertTrue(validateHelpers.checkElementDisabled(remainingDayfield));
                Assert.assertTrue(validateHelpers.checkElementDisabled(dueDateField));
            }

        } else {
            if (!validateHelpers.checkElementDisabled(setSaleTypeDefault)) {
                Assert.assertTrue(validateHelpers.checkDisplayed(dateAndTye));
                Assert.assertTrue(validateHelpers.checkDisplayed(expandableonDateAndType));
                Assert.assertTrue(validateHelpers.checkDisplayed(saleTypeField));
                Assert.assertTrue(validateHelpers.checkDisplayed(saleTypeDropdownButton));
                Assert.assertTrue(validateHelpers.checkDisplayed(changeSaleDateBt));
                Assert.assertTrue(validateHelpers.checkDisplayed(setSaleTypeDefault));
            } else {
                Assert.assertTrue(validateHelpers.checkDisplayed(dateAndTye));
                Assert.assertTrue(validateHelpers.checkDisplayed(expandableonDateAndType));
                Assert.assertTrue(validateHelpers.checkDisplayed(saleTypeField));
                Assert.assertTrue(validateHelpers.checkDisplayed(saleTypeDropdownButton));
                Assert.assertTrue(validateHelpers.checkDisplayed(changeSaleDateBt));
                Assert.assertTrue(validateHelpers.checkElementDisabled(setSaleTypeDefault));
            }
        }
    }


}
