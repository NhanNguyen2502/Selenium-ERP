package erp.pages;

import erp.common.helpers.AttachmentDocumentHelper;
import erp.common.helpers.FakeDataHelper;
import erp.common.helpers.TranslationHelpers;
import erp.common.helpers.ValidateHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.python.antlr.ast.Str;
import org.testng.Assert;

import java.text.DecimalFormat;
import java.time.Duration;
import java.util.Random;

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
    private String _invoiceLanguage;
    private String _mainCurrencyOfCompany;
    private Random ran;
    private AttachmentDocumentHelper _attachmentDocumentHelper;

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
    private By addProductOnProductLinebutton = By.xpath("//button[@apptooltip='invoicesCommon.button.addProductTooltip']");
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
    private By invoiceProductError = By.xpath("//form//app-select-object-control//mat-error");
    private By invoiceLanguageOfCustomerInputField = By.xpath("//input[@data-cy='language-select-input']");
    private By invoiceCustomerLanguageList = By.xpath("//mat-option[@data-cy='language-select-option']");
    private String invoiceLanguageOfCustomerID = "language-select-input";
    private String invoiceMainCurrency = "currency-input";
    private By invoiceCurrencyInputField = By.xpath("//input[@data-placeholder='Currency']");
    private By invoiceCurrencyList = By.xpath("//mat-option");
    private By invoiceConfirmChangeCurrencyDialog = By.xpath("//app-confirm-change-currency-dialog");
    private By invoiceConfirmChangeCurrencyButton = By.xpath("//button[@data-cy='dialog-change-button']");
    private By invoiceCancelChangeCurrencyButton = By.xpath("//button[@data-cy='dialog-cancel-button']");
    private By invoiceProductPriceInput = By.xpath("//input[@id='price-input']");
    private By invoiceHistorySection = By.xpath("//app-invoice-detail-histories");
    private By invoiceRateInput = By.xpath("//input[@data-cy='exchange-rate-input']");
    private By invoiceReceiptLanguageInput = By.xpath("//input[@data-cy='language-select-input']");
    private By invoiceIDNumber = By.xpath("//span[@data-cy='invoice-detail-number']");
    private By invoiceQuantityInput = By.xpath("//input[@data-cy='quantity']");
    private By invoiceDiscountInput = By.xpath("//input[@data-cy='discount']");
    private By invoiceConfirmCreateInvoiceamout0Dialog = By.xpath("//app-confirm-dialog");
    private By invoiceCancleCreateInvoiceAmount0Button = By.xpath("//button[@data-cy='dialog-cancel-button']");
    private By invoiceConfirmCreateInvoiceAmount0Button = By.xpath("//button[@data-cy='dialog-yes-button']");
    private By invoiceProductsOnPopularProductSection = By.xpath("//app-draft-invoice-most-popular-products//span[@class='product-name text-truncate']");
    private By invoiceCommentArea = By.xpath("//textarea");
    private By invoiceAttachmentInput = By.xpath("//app-upload-file//input");


    public CreateSalePage(WebDriver driver) {
        this.driver = driver;
        validateHelpers = new ValidateHelpers(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        createEmployeesPage = new CreateEmployeesPage(driver);
        createCustomerPage = new CreateCustomerPage(driver);
        createProductPage = new CreateProductPage(driver);
        createFeePage = new CreateFeePage(driver);
        ran = new Random();
        _attachmentDocumentHelper = new AttachmentDocumentHelper(driver);
    }
    public void attachmentImage()
    {
        _attachmentDocumentHelper.attachmentImage(invoiceAttachmentInput);
    }

    public  void addCommentOnInvoice()
    {
        validateHelpers.clickElement(invoiceCommentArea);
        validateHelpers.setText(invoiceCommentArea,FakeDataHelper.getFakedata().text().text(1,255));
    }
    public void selectProductOnPopularProductSection()
    {
        var _productList =  validateHelpers.getList(invoiceProductsOnPopularProductSection);
        if(!_productList.isEmpty())
        {
            var _selectRandom = ran.nextInt(_productList.size());
            _productList.get(_selectRandom).click();
        }
        else {
            System.out.println("Customer has not the popular product!. We will select a random product.");
            selectProduct();
        }
    }
    public void updateDiscountOfAllProducts()
    {
        var _discountInputList = validateHelpers.getList(invoiceDiscountInput);
        if(_discountInputList.isEmpty())
        {
            for(WebElement a : _discountInputList)
            {
                var _discountRandomNumber = ran.nextInt(0,10);
                a.clear();
                a.sendKeys(String.valueOf(_discountRandomNumber));
            }
        }
    }

    public void confirmCreateInvoiceAmout0()
    {
        try {
            driver.findElement(invoiceConfirmCreateInvoiceAmount0Button).click();
            System.out.println("Confirm create invoice with amount 0 success.");
        } catch (NoSuchElementException e) {
            System.out.println("Confirm button does not show");
        }
    }

    public void cancelCreateInvoiceAmout0() {
        try {
            driver.findElement(invoiceCancleCreateInvoiceAmount0Button).click();
            System.out.println("Cancel create invoice with amount 0 success.");
        } catch (NoSuchElementException e) {
            System.out.println("Cancel button does not show");
        }
    }

    public void checkConfirmCreateInvoiceWith0Mount() {
        try {
            var _a = driver.findElement(invoiceConfirmCreateInvoiceamout0Dialog);
            if (_a.isDisplayed()) {
                System.out.println("Confirm Create invoice with amount is 0 show");
            }
        } catch (NoSuchElementException e) {
            System.out.println("Confirm Create invoice with amount is 0 does not show");
        }
    }

    public void updateDiscountOfProductOnProductLine() {
        var _discountList = validateHelpers.getList(invoiceDiscountInput);
        var _discountNumber = ran.nextInt(1, 10);
        if (!_discountList.isEmpty()) {
            var _randomNumber = ran.nextInt(0, _discountList.size());
            _discountList.get(_randomNumber).clear();
            _discountList.get(_randomNumber).sendKeys(String.valueOf(_discountNumber));
        }
    }

    public void updateQuantityOfAnyProduct() {
        var _quantityList = validateHelpers.getList(invoiceQuantityInput);
        var _quantityNumber = ran.nextInt(1, 10);
        if (!_quantityList.isEmpty()) {
            var _randomNumber = ran.nextInt(0, _quantityList.size());
            _quantityList.get(_randomNumber).clear();
            _quantityList.get(_randomNumber).sendKeys(String.valueOf(_quantityNumber));
        }
    }

    public void updateQuantityAllProduct() {
        var _quantityList = validateHelpers.getList(invoiceQuantityInput);

        if (!_quantityList.isEmpty()) {
            for (WebElement a : _quantityList) {
                var _quantityNumber = ran.nextInt(1, 10);
                a.clear();
                validateHelpers.waitAfterChoseOrClickElement();
                a.sendKeys(String.valueOf(_quantityNumber));
            }
        }
    }

    public void updateQuantityOfProduct() {
        var _quantity = ran.nextInt(1, 10);
        //System.out.println(_quantity);
        driver.findElement(invoiceQuantityInput).clear();
        driver.findElement(invoiceQuantityInput).sendKeys(String.valueOf(_quantity));
    }

    public void addAProductLineIntoProductSection() {
        validateHelpers.clickElement(addProductOnProductLinebutton);
    }

    public void changePriceOfAnyProductInProductLines() {
        var priceList = validateHelpers.getList(invoiceProductPriceInput);
        if (!priceList.isEmpty()) {
            Random ran = new Random();
            DecimalFormat df = new DecimalFormat();
            df.setMaximumFractionDigits(3);
            var randomPrice = ran.nextInt(0, priceList.size());
            var oldPrice = Double.valueOf(priceList.get(randomPrice).getAttribute("value"));
            priceList.get(randomPrice).clear();
            priceList.get(randomPrice).sendKeys(String.valueOf(df.format(ran.nextDouble(1, 1000))));
        }

    }

    public void fillProductIntoProductlines() {
        var productLines = validateHelpers.getList(invoiceProductDropdownButton);
        if (!productLines.isEmpty()) {
            for (WebElement p : productLines) {
                p.click();
                var list = driver.findElements(invoiceProductList);
                if (!list.isEmpty()) {
                    Random ran = new Random();
                    var randomNumber = ran.nextInt(list.size());
                    list.get(randomNumber).click();
                } else {
                    createProductPage.createProductOnInvoice();
                }

            }
        }

    }

    public void addManyProductInProductLine() {
        Random ran = new Random();
        var ranNumberClick = ran.nextInt(1, 5);
        for (int i = 0; i < ranNumberClick; i++) {
            validateHelpers.clickElement(addProductOnProductLinebutton);
        }

    }

    public void checkInvoiceAfterClickCreateButton() {
        try {
            if (driver.findElement(invoiceHistorySection).isDisplayed()) {
                var IDNumber = validateHelpers.getMessage(invoiceIDNumber);
                System.out.println("Invoice has been created with invoice number: " + IDNumber);
            }
        } catch (NoSuchElementException e) {
            System.out.println("Create invoice Failed!");
        }
    }

    public void fillRate() {
        validateHelpers.clearElement(invoiceRateInput);
        Random ran = new Random();
        var random = ran.nextInt(1, 10);
        System.out.println("Rate: " + random);
        validateHelpers.setText(invoiceRateInput, String.valueOf(random));
    }

    public void changeProductPriceRandomPrice() {
        var oldPrice = Double.valueOf(validateHelpers.getValueByAttribute(invoiceProductPriceInput));
        Random ran = new Random();
        var random = ran.nextDouble(1, 1000);
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(3);
        validateHelpers.clearElement(invoiceProductPriceInput);
        validateHelpers.setText(invoiceProductPriceInput, String.valueOf(df.format(random)));
    }

    public void changeProductPriceOtherThan0() {
        var a = Double.valueOf(validateHelpers.getValueByAttribute(invoiceProductPriceInput));
        if (a == 0.00) {
            Random ran = new Random();
            var random = ran.nextDouble(1000.00);
            DecimalFormat df = new DecimalFormat();
            df.setMaximumFractionDigits(3);
            System.out.println("Price of the product after change: " + df.format(random));
            validateHelpers.clearElement(invoiceProductPriceInput);
            validateHelpers.setText(invoiceProductPriceInput, String.valueOf(df.format(random)));
        }
    }

    public void confirmChangeCurrency() {
        try {
            driver.findElement(invoiceConfirmChangeCurrencyButton).click();
            System.out.println("Currency has been change");
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }

    public void cancelChangeCurrency() {
        try {
            driver.findElement(invoiceCancelChangeCurrencyButton).click();
            System.out.println("Cancel change currency");
        } catch (NoSuchElementException e) {
            System.out.println("Cancel button does not exist!");
        }

    }

    public void checkConfirmChangeCurrencyDialog() {
        try {
            var a = driver.findElement(invoiceConfirmChangeCurrencyDialog);
            if (a.isDisplayed()) {
                System.out.println("The confirm change currency dialog display.");
            }
        } catch (NoSuchElementException e) {
            System.out.println("The confirm change currency dialog dose not display.");
        }
    }

    public void changeCurrencyOnInvoice() {
        _mainCurrencyOfCompany = validateHelpers.getValueByJSByID(invoiceMainCurrency);
        System.out.println("The main currency on the create invoice page: " + _mainCurrencyOfCompany);
        validateHelpers.clickElement(invoiceCurrencyInputField);
        var currencyList = validateHelpers.getList(invoiceCurrencyList);
        if (!currencyList.isEmpty()) {
            Random ran = new Random();
            while (true) {
                var randomNumber = ran.nextInt(currencyList.size());
                if (!currencyList.get(randomNumber).getText().equals(_mainCurrencyOfCompany)) {
                    System.out.println("The currency will change from: " + _mainCurrencyOfCompany + " to currency " + currencyList.get(randomNumber).getText());
                    currencyList.get(randomNumber).click();
                    break;
                } else {
                    System.out.println("Currency " + currencyList.get(randomNumber).getText() + " the same as the main currency " + _mainCurrencyOfCompany);
                }
            }

        }
    }

    public void changeLanguageOfCustomerOnInvoiceCreatePage() {
        _invoiceLanguage = validateHelpers.getValueByAttribute(invoiceReceiptLanguageInput);
        System.out.println("Language of invoice: " + _invoiceLanguage);
        validateHelpers.clickElement(invoiceReceiptLanguageInput);
        var languageList = validateHelpers.getList(invoiceCustomerLanguageList);
        if (!languageList.isEmpty()) {
            Random ran = new Random();
            while (true) {
                var random = ran.nextInt(languageList.size());
                if (!languageList.get(random).getText().equals(_invoiceLanguage)) {
                    System.out.println("Change language from " + _invoiceLanguage + " to " + languageList.get(random).getText());
                    languageList.get(random).click();
                    break;
                } else {
                    System.out.println("Language " + languageList.get(random).getText() + " the same as language of customer " + _invoiceLanguage);
                }
            }

        }
    }

    public void getProductError() {
        System.out.println(validateHelpers.getMessage(invoiceProductError));
    }

    public void getCustomerError() {
        System.out.println(validateHelpers.getMessage(invoiceCustomerError));
    }

    public void clickCreateButton() {
        if (_typeOfSale.equals(_instalment)) {
            _invoiceInstalmentAmount = validateHelpers.getMessage(invoiceInstalmentPlanAmount);
            if (Integer.valueOf(_invoiceInstalmentAmount) > 0) {
                validateHelpers.clearElement(invoiceInstalamoutField);
                validateHelpers.setText(invoiceInstalamoutField, String.valueOf(FakeDataHelper.getFakedata().number().numberBetween(1, Integer.valueOf(_invoiceInstalmentAmount))));
                validateHelpers.clickElement(invoiceCreatePlanButton);
                if (validateHelpers.getMessage(invoiceInstalmentPlanAmount).equals(String.valueOf(0))) {
                    validateHelpers.clickElement(invoiceCreateInvoiceButton);
                }
            }

        } else {
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
                // System.out.println(x.getText() + " match with " + type);
                x.click();
                break;
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
