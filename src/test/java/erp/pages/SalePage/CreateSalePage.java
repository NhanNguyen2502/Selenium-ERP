package erp.pages.SalePage;

import erp.common.helpers.*;
import erp.pages.CompanyListPage;
import erp.pages.Customer.CreateCustomerPage;
import erp.pages.Customer.UpdateCustomerPage;
import erp.pages.EmployeePage.CreateEmployeesPage;
import erp.pages.EmployeePage.UpdateEmployeePage;
import erp.pages.FeePage.CreateFeePage;
import erp.pages.FeePage.UpdateFeePage;
import erp.pages.ProductPage.CreateProductPage;
import erp.pages.ProductPage.UpdateProductPage;
import erp.pages.SignInPage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
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
    private DecimalFormat decimalFormat;
    private String _actualAmount;
    private SignInPage signInPage;
    private CompanyListPage companyListPage;
    private SaleTable saleTable;
    private UpdateEmployeePage updateEmployeePage;
    private UpdateCustomerPage updateCustomerPage;
    private UpdateProductPage updateProductPage;
    private UpdateFeePage updateFeePage;
    private BrowserManagerHelper browserManagerHelper;

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
        decimalFormat = new DecimalFormat();
        decimalFormat.setMaximumFractionDigits(3);
        updateEmployeePage = new UpdateEmployeePage(driver);
        updateCustomerPage = new UpdateCustomerPage(driver);
        signInPage = new SignInPage(driver);
        companyListPage = new CompanyListPage(driver);
        saleTable = new SaleTable(driver);
        updateProductPage = new UpdateProductPage(driver);
        updateFeePage = new UpdateFeePage(driver);
        browserManagerHelper = new BrowserManagerHelper(driver);

    }

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
    private By addProductOnProductLinebutton = By.xpath("//button[@data-cy='add-product-button' and @apptooltip='invoicesCommon.button.addProductTooltip']");
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
    private By invoiceReceiptLanguageInput = By.xpath("//app-language-select//input");
    private By invoiceIDNumber = By.xpath("//span[@data-cy='invoice-detail-number']");
    private By invoiceQuantityInput = By.xpath("//input[@data-cy='quantity']");
    private By invoiceDiscountInput = By.xpath("//input[@data-cy='discount']");
    private By invoiceConfirmCreateInvoiceamout0Dialog = By.xpath("//app-confirm-dialog");
    private By invoiceCancleCreateInvoiceAmount0Button = By.xpath("//button[@data-cy='dialog-cancel-button']");
    private By invoiceConfirmCreateInvoiceAmount0Button = By.xpath("//button[@data-cy='dialog-yes-button']");
    private By invoiceProductsOnPopularProductSection = By.xpath("//app-draft-invoice-most-popular-products//span[@class='product-name text-truncate']");
    private By invoiceCommentArea = By.xpath("//textarea");
    private By invoiceAttachmentInput = By.xpath("//app-upload-file//input");
    private By invoiceFeeAmount = By.xpath("//input[@data-cy='invoice-currency-amount']");
    private By warningFirstInvoiceNumber = By.xpath("//app-add-invoice-number-series-dialog");
    private By fristInvoiceNumberField = By.xpath("//input[@data-cy='invoice-number-input']");
    private By fristInvoiceNumberConfirmButton = By.xpath("//button[@data-cy='dialog-confirm-button']");
    private By fristInvoiceNumberCancelButton = By.xpath("//button[@data-cy='dialog-cancel-button']");
    private By warningText = By.xpath("//div[@data-cy='payment-amount-max-amount']");
    private By priceField1 = By.xpath("//mat-form-field//input[@data-cy='price' and @id='price-input']");
    private By priceFirst = By.xpath("//div[@data-cy='payment-amount-max-amount']");
    private By instalmentPlanInput = By.xpath("//input[@data-cy='installment-amount-input']");
    private By createPlanButton = By.xpath("//button[@data-cy='create-plan-button']");
    private By addPrePaymentButton = By.xpath("//button[@data-cy='add-prepayment-button']");
    private By prePaymentAmountField = By.xpath("//input[@data-cy='amount']");
    private By prePaymentAmountRequired = By.xpath("//div[@data-cy='payment-amount-required']");
    private By confirmAddPrePaymentButton = By.xpath("//button[@data-cy='dialog-confirm-button']");
    private By instalmentPeriodField = By.xpath("(//app-select//mat-form-field//input)[2]");
    private By periodOptions = By.xpath("//mat-option");
    private By informChangeAmountOfInstalmentPlan = By.xpath("//app-confirm-dialog");
    private By cancelUpdateInstalMentPlan = By.xpath("//button[@data-cy='dialog-cancel-button']");
    private By confirmUpdateInstalmentPlan = By.xpath("//button[@data-cy='dialog-yes-button']");
    private By removeInstalmentLines = By.xpath("//button[@apptooltip='general.button.remove']");
    private By addInstalmentLine = By.xpath("//button[@apptooltip='installmentInvoice.button.addInstallment']");
    private By removeProductButton = By.xpath("(//button[@data-cy='product-remove-button'])[1]");
    private By confirmRemoveProductButton = By.xpath("//button[@data-cy='dialog-yes-button']");
    private By confirmUpdateInstalmentPlanAfterChangeInstalmentAmount = By.xpath("//button[@data-cy='create-plan-confirm-button']");
    private By cancelUpdateInstalmentPlanAfterChangeInstalmentAmount = By.xpath("//button[@data-cy='create-plan-cancel-button']");
    private By customerNameField = By.xpath("(//app-select-object-control)[3]//input");
    private By productName = By.xpath("//input[@data-cy='select-product']");
    private By employeeName = By.xpath("//input[@data-cy='select-our-reference']");

/////////////////////////Functionalities////////////////////////////

    public void selectEmployeeCustomerAndCancelChangeCurrencyOfCustomer(String language) {
        validateHelpers.waitAfterChoseOrClickElement();
        selectAccountNumber();
        validateHelpers.waitAfterChoseOrClickElement();
        selectEmployee(TranslationHelpers.setFile(language, "$.phoneNumber.error.phoneInvalid"));
        validateHelpers.waitAfterChoseOrClickElement();
        selectCustomer(TranslationHelpers.setFile(language, "$.invoicesCommon.dialog.createEditContact.text.language"));
        validateHelpers.waitForLoadJs();
        checkConfirmChangeCurrencyDialog();
        validateHelpers.waitAfterChoseOrClickElement();
        cancelChangeCurrency();
        validateHelpers.waitAfterChoseOrClickElement();
    }

    public void selectEmployeeProductAndCancelChangeCurrencyOfCustomer(String language) {
        validateHelpers.waitAfterChoseOrClickElement();
        selectAccountNumber();
        validateHelpers.waitAfterChoseOrClickElement();
        selectEmployee(TranslationHelpers.setFile(language, "$.phoneNumber.error.phoneInvalid"));
        validateHelpers.waitAfterChoseOrClickElement();
        selectProduct();
        validateHelpers.waitAfterChoseOrClickElement();
    }

    public void selectInstalmentPeriodYearly(String language) {
        changeInstalmentPeriod(GetPeriodForInstalmentInvoice.getYearly(language));
        validateHelpers.waitAfterChoseOrClickElement();
        addInstallmentPlan();
        validateHelpers.waitAfterChoseOrClickElement();
    }

    public void selectInstalmentPeriodQuarterly(String language) {
        changeInstalmentPeriod(GetPeriodForInstalmentInvoice.getQuarterly(language));
        validateHelpers.waitAfterChoseOrClickElement();
        addInstallmentPlan();
        validateHelpers.waitAfterChoseOrClickElement();
    }

    public void selectInstalmentPeriodWekkly(String language) {
        changeInstalmentPeriod(GetPeriodForInstalmentInvoice.getWekkly(language));
        validateHelpers.waitAfterChoseOrClickElement();
        addInstallmentPlan();
        validateHelpers.waitAfterChoseOrClickElement();
    }

    public void cancelUpdateInstalmentPlanAfterEnterAnotherAmountToInstalmentAmount() {
        changeAmountOfInstalmentAmount();
        validateHelpers.waitAfterChoseOrClickElement();
        clickCreateButton();
        validateHelpers.waitAfterChoseOrClickElement();
        verifyConfirmCreateInvoiceWithoutChangePlan();
        validateHelpers.waitAfterChoseOrClickElement();
        cancelUpdateInstalmentPlan();
        validateHelpers.waitAfterChoseOrClickElement();
    }

    public void confirmUpdateInstalmentPlanAfterEnterAnotherAmountToInstalmentAmount() {
        changeAmountOfInstalmentAmount();
        validateHelpers.waitAfterChoseOrClickElement();
        clickCreateButton();
        validateHelpers.waitAfterChoseOrClickElement();
        verifyConfirmCreateInvoiceWithoutChangePlan();
        validateHelpers.waitAfterChoseOrClickElement();
        confirmUpdateInstalmentPlan();
        validateHelpers.waitAfterChoseOrClickElement();
    }

    public void reAddInstalmentLineViaPlusIcon() {
        reAddInstalmentLines();
        validateHelpers.waitAfterChoseOrClickElement();
    }

    public void addInstalmentPlanViaPlusIconOnInstalmentPlanSection() {
        enterAmountToInstalmentAmount();
        validateHelpers.waitAfterChoseOrClickElement();
        addInstalmentLinesViaPlusIcon();
        validateHelpers.waitAfterChoseOrClickElement();
    }

    public void selectPaymentAccountCustomerManyProductManyFee(String language) {
        validateHelpers.waitAfterChoseOrClickElement();
        selectAccountNumber();
        validateHelpers.waitAfterChoseOrClickElement();
        selectEmployee(TranslationHelpers.setFile(language, "$.phoneNumber.error.phoneInvalid"));
        validateHelpers.waitAfterChoseOrClickElement();
        selectCustomer(TranslationHelpers.setFile(language, "$.invoicesCommon.dialog.createEditContact.text.language"));
        validateHelpers.waitAfterChoseOrClickElement();
        checkConfirmChangeCurrencyDialog();
        validateHelpers.waitAfterChoseOrClickElement();
        cancelChangeCurrency();
        validateHelpers.waitAfterChoseOrClickElement();
        addManyProductInProductLine();
        validateHelpers.waitAfterChoseOrClickElement();
        fillProductIntoProductlines();
        validateHelpers.waitAfterChoseOrClickElement();
        addManyFeeLineOnFeeSection();
        validateHelpers.waitAfterChoseOrClickElement();
        fillAllFeesOnFeeSection();
        validateHelpers.waitAfterChoseOrClickElement();
    }

    public void changeCurrencyOfCustomer() {
        changeCurrencyOnInvoice();
        validateHelpers.waitAfterChoseOrClickElement();
        confirmChangeCurrency();
        validateHelpers.waitAfterChoseOrClickElement();
        fillRate();
        validateHelpers.waitAfterChoseOrClickElement();
    }

    public void instalmentVerifyAfterCreate() {
        validateHelpers.waitAfterChoseOrClickElement();
        clickCreateButton();
        validateHelpers.waitAfterChoseOrClickElement();
        confirmUpdateInstalmentPlan();
        validateHelpers.waitAfterChoseOrClickElement();
        skipSetFirstInvoiceNumber();
        validateHelpers.waitForLoadJs();
        checkInvoiceAfterClickCreateButton();
        validateHelpers.waitAfterChoseOrClickElement();
    }

    public void selectPaymentAccountEmployeeCustomerProductFeeAndCancelChangeCurrencyOfCustomer(String language) {
        validateHelpers.waitAfterChoseOrClickElement();
        selectAccountNumber();
        validateHelpers.waitAfterChoseOrClickElement();
        selectEmployee(TranslationHelpers.setFile(language, "$.phoneNumber.error.phoneInvalid"));
        validateHelpers.waitAfterChoseOrClickElement();
        selectCustomer(TranslationHelpers.setFile(language, "$.invoicesCommon.dialog.createEditContact.text.language"));
        validateHelpers.waitForLoadJs();
        checkConfirmChangeCurrencyDialog();
        validateHelpers.waitAfterChoseOrClickElement();
        cancelChangeCurrency();
        validateHelpers.waitAfterChoseOrClickElement();
        selectProduct();
        validateHelpers.waitAfterChoseOrClickElement();
        selectFee();
        validateHelpers.waitAfterChoseOrClickElement();
    }

    public void selectEmployeeAnonymousCustomerProductAndCancelChangeCurrencyOfCustomer(String language) {
        validateHelpers.waitAfterChoseOrClickElement();
        selectAccountNumber();
        validateHelpers.waitAfterChoseOrClickElement();
        selectEmployee(TranslationHelpers.setFile(language, "$.phoneNumber.error.phoneInvalid"));
        validateHelpers.waitAfterChoseOrClickElement();
        selectProduct();
        validateHelpers.waitAfterChoseOrClickElement();
    }

    public void selectEmployeeAnonymousCustomerManyProductAndCancelChangeCurrencyOfCustomer(String language) {
        validateHelpers.waitAfterChoseOrClickElement();
        selectAccountNumber();
        validateHelpers.waitAfterChoseOrClickElement();
        selectEmployee(TranslationHelpers.setFile(language, "$.phoneNumber.error.phoneInvalid"));
        validateHelpers.waitAfterChoseOrClickElement();
        addManyProductInProductLine();
        validateHelpers.waitAfterChoseOrClickElement();
        fillProductIntoProductlines();
        validateHelpers.waitAfterChoseOrClickElement();
    }

    public void selectEmployeeCustomerManyProductAndCancelChangeCurrencyOfCustomer(String language) {
        validateHelpers.waitAfterChoseOrClickElement();
        selectAccountNumber();
        validateHelpers.waitAfterChoseOrClickElement();
        selectEmployee(TranslationHelpers.setFile(language, "$.phoneNumber.error.phoneInvalid"));
        validateHelpers.waitAfterChoseOrClickElement();
        selectCustomer(TranslationHelpers.setFile(language, "$.invoicesCommon.dialog.createEditContact.text.language"));
        validateHelpers.waitAfterChoseOrClickElement();
        checkConfirmChangeCurrencyDialog();
        validateHelpers.waitAfterChoseOrClickElement();
        cancelChangeCurrency();
        validateHelpers.waitAfterChoseOrClickElement();
        addManyProductInProductLine();
        validateHelpers.waitAfterChoseOrClickElement();
        fillProductIntoProductlines();
        validateHelpers.waitAfterChoseOrClickElement();
    }

    public void selectPaymentAccountEmployeeCustomerProductManyFeeAndCancelChangeCurrencyOfCustomer(String language) {
        validateHelpers.waitAfterChoseOrClickElement();
        selectAccountNumber();
        validateHelpers.waitAfterChoseOrClickElement();
        selectEmployee(TranslationHelpers.setFile(language, "$.phoneNumber.error.phoneInvalid"));
        validateHelpers.waitAfterChoseOrClickElement();
        selectCustomer(TranslationHelpers.setFile(language, "$.invoicesCommon.dialog.createEditContact.text.language"));
        validateHelpers.waitForLoadJs();
        checkConfirmChangeCurrencyDialog();
        validateHelpers.waitAfterChoseOrClickElement();
        cancelChangeCurrency();
        validateHelpers.waitAfterChoseOrClickElement();
        selectProduct();
        validateHelpers.waitAfterChoseOrClickElement();
        addManyFeeLineOnFeeSection();
        validateHelpers.waitAfterChoseOrClickElement();
        fillAllFeesOnFeeSection();
        validateHelpers.waitAfterChoseOrClickElement();
    }

    public void selectEmployeeCustomerProductAndCancelChangeCurrencyOfCustomer(String language) {
        validateHelpers.waitAfterChoseOrClickElement();
        selectAccountNumber();
        validateHelpers.waitAfterChoseOrClickElement();
        selectEmployee(TranslationHelpers.setFile(language, "$.phoneNumber.error.phoneInvalid"));
        validateHelpers.waitAfterChoseOrClickElement();
        selectCustomer(TranslationHelpers.setFile(language, "$.invoicesCommon.dialog.createEditContact.text.language"));
        validateHelpers.waitForLoadJs();
        checkConfirmChangeCurrencyDialog();
        validateHelpers.waitForLoadJs();
        cancelChangeCurrency();
        validateHelpers.waitAfterChoseOrClickElement();
        selectProduct();
        validateHelpers.waitAfterChoseOrClickElement();
    }

    public void createInvoiceAndVerifyAfterCreate() {
        clickCreateButton();
        validateHelpers.waitAfterChoseOrClickElement();
        checkConfirmCreateInvoiceWith0Mount();
        validateHelpers.waitAfterChoseOrClickElement();
        confirmCreateInvoiceAmout0();
        validateHelpers.waitAfterChoseOrClickElement();
        skipSetFirstInvoiceNumber();
        validateHelpers.waitAfterChoseOrClickElement();
        checkInvoiceAfterClickCreateButton();
        validateHelpers.waitAfterChoseOrClickElement();
         browserManagerHelper.closingTab1();
    }

    public void disableProduct(String productName) {
        createProductPage.goToProductTable();
        validateHelpers.waitAfterChoseOrClickElement();
        updateProductPage.selectProductNameToUpdate(productName);
        validateHelpers.waitForLoadJs();
        updateProductPage.disableProduct();
        validateHelpers.waitAfterChoseOrClickElement();
        updateProductPage.confirmDisableProduct();
        validateHelpers.waitAfterChoseOrClickElement();
    }

    public void disableCustomer(String customerName) {
        createCustomerPage.goToTheCustomerTable();
        validateHelpers.waitAfterChoseOrClickElement();
        updateCustomerPage.selectCustomerToUpdateViaCustomerName(customerName);
        validateHelpers.waitAfterChoseOrClickElement();
        updateCustomerPage.disableCustomer();
        validateHelpers.waitAfterChoseOrClickElement();
        updateCustomerPage.confirmDisableCustomer();
        validateHelpers.waitAfterChoseOrClickElement();
        updateCustomerPage.clickOnSaveButton();
        validateHelpers.waitAfterChoseOrClickElement();
    }

    public void disableEmployee(String employeeName) {
        createEmployeesPage.gotoEmployeeTable();
        validateHelpers.waitForLoadJs();
        updateEmployeePage.selectEmployeeToUpdateDisableViaEmployeeName(employeeName);
        validateHelpers.waitAfterChoseOrClickElement();
    }

    public void disableFee(String feeName) {
        createFeePage.goToCreateFeeTable();
        validateHelpers.waitAfterChoseOrClickElement();
        updateFeePage.selectFeeToDisableViaSearchFeeName(feeName);
        validateHelpers.waitAfterChoseOrClickElement();
    }

    public void loginAndGoToTheCreateSalePage(String language) {
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        validateHelpers.verifylanguage(language);
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        saleTable.gtoSaleViaShortCut();
        validateHelpers.waitForLoadJsCreatePage();
    }

    public void cancelUpdadateInstalmentPlanAfterChangeInstalAmount() {
        validateHelpers.clickElement(cancelUpdateInstalmentPlanAfterChangeInstalmentAmount);
        validateHelpers.waitAfterChoseOrClickElement();
    }

    public void confirmUpdadateInstalmentPlanAfterChangeInstalmentAmount() {
        validateHelpers.clickElement(confirmUpdateInstalmentPlanAfterChangeInstalmentAmount);
        validateHelpers.waitAfterChoseOrClickElement();
    }

    public void removeAllProducts() {
        var _productList = validateHelpers.getList(removeProductButton);
        if (!_productList.isEmpty()) {
            for (int i = 0; i < _productList.size(); i++) {
                _productList.get(i).click();
                confirmRemoveProduct();
            }
        }
        validateHelpers.waitAfterChoseOrClickElement();
    }

    public void confirmRemoveProduct() {
        validateHelpers.clickElement(confirmRemoveProductButton);
    }

    public void addInstalmentLinesViaPlusIcon() {
        try {
            for (int i = 0; ; i++) {
                if (driver.findElement(addInstalmentLine).isEnabled()) {
                    validateHelpers.clickElement(addInstalmentLine);
                    validateHelpers.waitAfterChoseOrClickElement();
                } else {
                    break;
                }

            }
        } catch (NoSuchElementException e) {
            Assert.fail("Click on Instalment plan button fail.");
        }
    }

    public void enterAmountToInstalmentAmount() {
        try {
            validateHelpers.setText(instalmentPlanInput, "9999999999999999999999999999999999999999999");
            validateHelpers.clickElement(createPlanButton);
            validateHelpers.waitAfterChoseOrClickElement();
            var _str = driver.findElement(priceFirst).getText();
            String[] _amount = _str.split(":", 2);
            _actualAmount = _amount[1].replace(" ", "");
            if (_actualAmount.equals("0")) {
                System.out.println("Total amount: 0, We can not create instalment invoice!");
                System.out.println("We will update amount of the product");
                var _list = validateHelpers.getList(priceField1);
                if (!_list.isEmpty()) {
                    for (int i = 0; i < _list.size(); i++) {
                        var _randomAmount = ran.nextInt(1, 1000);
                        _list.get(i).clear();
                        _list.get(i).sendKeys(String.valueOf(_randomAmount));
                    }
                }
                validateHelpers.setText(instalmentPlanInput, "9999999999999999999999999999999999999999999");
                validateHelpers.clickElement(createPlanButton);
                validateHelpers.waitAfterChoseOrClickElement();
                _str = driver.findElement(priceFirst).getText();
                _amount = _str.split(":", 2);
                System.out.println(_amount[1].replace(" ", ""));
                _actualAmount = _amount[1].replace(" ", "");
            }
            double a = Float.parseFloat(_actualAmount) / 2;
            int num = (int) a;
            validateHelpers.clearElement(instalmentPlanInput);
            validateHelpers.setText(instalmentPlanInput, String.valueOf(num));

        } catch (NoSuchElementException e) {
            Assert.fail("Add Instalment Plan failed!");
        }

    }

    public void reAddInstalmentLines() {
        int a = removeLines();
        for (int i = 0; i < a; i++) {
            validateHelpers.clickElement(addInstalmentLine);
        }
    }

    public int removeLines() {
        var _numberRan = 0;
        var _instalmentLine = validateHelpers.getList(removeInstalmentLines);
        if (!_instalmentLine.isEmpty()) {
            _numberRan = ran.nextInt(1, _instalmentLine.size());
            for (int i = 0; i < _numberRan; i++) {
                _instalmentLine.get(i).click();
            }
        }
        return _numberRan;
    }

    public void confirmUpdateInstalmentPlan() {
        try {
            driver.findElement(confirmUpdateInstalmentPlan).click();
        } catch (NoSuchElementException e) {
            System.out.println("Confirm change plan does not display.");
        }
    }


    public void cancelUpdateInstalmentPlan() {
        validateHelpers.clickElement(cancelUpdateInstalMentPlan);
    }

    public void verifyConfirmCreateInvoiceWithoutChangePlan() {
        try {
            Assert.assertTrue(driver.findElement(informChangeAmountOfInstalmentPlan).isDisplayed());
        } catch (NoSuchElementException e) {
            Assert.fail("Confirm create invoice change plan does not show!!!");
        }
    }

    public void changeAmountOfInstalmentAmount() {
        var _currentAmout = validateHelpers.getValueByAttribute(instalmentPlanInput).replace(",", "").replace(" ", "");
        validateHelpers.clearElement(instalmentPlanInput);
        double a = Float.parseFloat(_currentAmout);
        int num = (int) a;
        validateHelpers.setText(instalmentPlanInput, String.valueOf(ran.nextInt(1, num)));
    }

    public void changeInstalmentPeriod(String option) {
        validateHelpers.clickElement(instalmentPeriodField);
        var _options = validateHelpers.getList(periodOptions);
        for (WebElement a : _options) {
            if (a.getText().equals(option)) {
                a.click();
                break;
            }
        }
    }

    public void addPrePayment() {
        try {
            validateHelpers.setText(instalmentPlanInput, "9999999999999999999999999999999999999999999");
            validateHelpers.clickElement(createPlanButton);
            validateHelpers.waitAfterChoseOrClickElement();
            var _str = driver.findElement(priceFirst).getText();
            String[] _amount = _str.split(":", 2);
            _actualAmount = _amount[1].replace(" ", "");
            if (_actualAmount.equals("0")) {
                System.out.println("Total amount: 0, We can not add pre-payment!");
                System.out.println("We will update amount of the product");
                var _list = validateHelpers.getList(priceField1);
                if (!_list.isEmpty()) {
                    for (int i = 0; i < _list.size(); i++) {
                        var _randomAmount = ran.nextInt(1, 1000);
                        _list.get(i).clear();
                        _list.get(i).sendKeys(decimalFormat.format(_randomAmount));
                    }
                }
                validateHelpers.setText(instalmentPlanInput, "9999999999999999999999999999999999999999999");
                validateHelpers.clickElement(createPlanButton);
                validateHelpers.waitAfterChoseOrClickElement();
                _str = driver.findElement(priceFirst).getText();
                _amount = _str.split(":", 2);
                System.out.println(_amount[1].replace(" ", ""));
                _actualAmount = _amount[1].replace(" ", "");
            }
            validateHelpers.clickElement(addPrePaymentButton);
            validateHelpers.clickElement(confirmAddPrePaymentButton);
            Assert.assertTrue(driver.findElement(prePaymentAmountRequired).isDisplayed());
            double a = Float.parseFloat(_actualAmount) / 2;
            int num = (int) a;
            validateHelpers.setText(prePaymentAmountField, String.valueOf(num));
            validateHelpers.clickElement(confirmAddPrePaymentButton);
            validateHelpers.waitAfterChoseOrClickElement();
        } catch (NoSuchElementException e) {
            Assert.fail("Add pre-payment failed!!");
        }
    }

    public void addInstallmentPlan() {
        try {
            validateHelpers.setText(instalmentPlanInput, "9999999999999999999999999999999999999999999");
            validateHelpers.clickElement(createPlanButton);
            validateHelpers.waitAfterChoseOrClickElement();
            var _str = driver.findElement(priceFirst).getText();
            String[] _amount = _str.split(":", 2);
            _actualAmount = _amount[1].replace(" ", "");
            if (_actualAmount.equals("0")) {
                System.out.println("Total amount: 0, We can not create instalment invoice!");
                System.out.println("We will update amount of the product");
                var _list = validateHelpers.getList(priceField1);
                if (!_list.isEmpty()) {
                    for (int i = 0; i < _list.size(); i++) {
                        var _randomAmount = ran.nextInt(1, 1000);
                        _list.get(i).clear();
                        _list.get(i).sendKeys(String.valueOf(_randomAmount));
                    }
                }
                validateHelpers.setText(instalmentPlanInput, "9999999999999999999999999999999999999999999");
                validateHelpers.clickElement(createPlanButton);
                validateHelpers.waitAfterChoseOrClickElement();
                _str = driver.findElement(priceFirst).getText();
                _amount = _str.split(":", 2);
                System.out.println(_amount[1].replace(" ", ""));
                _actualAmount = _amount[1].replace(" ", "");
            }
            double a = Float.parseFloat(_actualAmount) / 2;
            int num = (int) a;
            validateHelpers.clearElement(instalmentPlanInput);
            validateHelpers.setText(instalmentPlanInput, String.valueOf(num));
            validateHelpers.clickElement(createPlanButton);
            validateHelpers.waitAfterChoseOrClickElement();

        } catch (NoSuchElementException e) {
            Assert.fail("Add Instalment Plan failed!");
        }
    }

    public void confirmSetFirstInvoiceNumber() {
        try {
            if (driver.findElement(warningFirstInvoiceNumber).isDisplayed()) {
                var _numberRandom = ran.nextInt(1000, 9999);
                validateHelpers.setText(fristInvoiceNumberField, String.valueOf(_numberRandom));
                validateHelpers.clickElement(fristInvoiceNumberConfirmButton);
            }
        } catch (NoSuchElementException e) {
            System.out.println("The warning First Invoice does not display!!!");
        }
    }

    public void skipSetFirstInvoiceNumber() {
        try {
            if (driver.findElement(warningFirstInvoiceNumber).isDisplayed()) {
                validateHelpers.clickElement(fristInvoiceNumberCancelButton);
            }
        } catch (NoSuchElementException e) {
            System.out.println("The warning First Invoice does not display!!!");
        }
    }

    public void updateAmountOfFee() {
        var _randomAmount = ran.nextInt(1, 1000);
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(3);
        validateHelpers.clearElement(invoiceFeeAmount);
        validateHelpers.setText(invoiceFeeAmount, String.valueOf(df.format(_randomAmount)));
        validateHelpers.waitAfterChoseOrClickElement();
    }

    public void fillAllFeesOnFeeSection() {
        var _feeFields = validateHelpers.getList(invoiceFeeField);
        if (!_feeFields.isEmpty()) {
            for (WebElement _feeElement : _feeFields) {
                _feeElement.click();
                validateHelpers.waitAfterChoseOrClickElement();
                var _feeList = validateHelpers.getList(invoiceFeeList);
                if (!_feeList.isEmpty()) {
                    var _ranDomFee = ran.nextInt(_feeList.size());
                    _feeList.get(_ranDomFee).click();
                } else {
                    createFeePage.createFeeOnInvoice();
                }
            }
        }
    }

    public void addManyFeeLineOnFeeSection() {
        var _numberOfFee = ran.nextInt(1, 10);
        for (int i = 0; i < _numberOfFee; i++) {
            validateHelpers.clickElement(invoiceAddNewFeeOnFeeLineButton);
        }

    }

    public void attachmentImage() {
        _attachmentDocumentHelper.attachmentImage(invoiceAttachmentInput);
        validateHelpers.waitAfterChoseOrClickElement();
    }

    public void addCommentOnInvoice() {
        validateHelpers.clickElement(invoiceCommentArea);
        validateHelpers.setText(invoiceCommentArea, FakeDataHelper.getFakedata().text().text(1, 255));
        validateHelpers.waitAfterChoseOrClickElement();
    }

    public void selectProductOnPopularProductSection() {
        var _productList = validateHelpers.getList(invoiceProductsOnPopularProductSection);
        if (!_productList.isEmpty()) {
            var _selectRandom = ran.nextInt(_productList.size());
            _productList.get(_selectRandom).click();
        } else {
            System.out.println("Customer has not the popular product!. We will select a random product.");
            selectProduct();
        }
    }

    public void updateDiscountOfAllProducts() {
        var _discountInputList = validateHelpers.getList(invoiceDiscountInput);
        if (_discountInputList.isEmpty()) {
            for (WebElement a : _discountInputList) {
                var _discountRandomNumber = ran.nextInt(0, 10);
                a.clear();
                a.sendKeys(String.valueOf(_discountRandomNumber));
            }
        }
        validateHelpers.waitAfterChoseOrClickElement();
    }

    public void confirmCreateInvoiceAmout0() {
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
        validateHelpers.waitAfterChoseOrClickElement();
    }

    public void updateQuantityOfProduct() {
        try {
            var _quantity = ran.nextInt(1, 10);
            //System.out.println(_quantity);
            driver.findElement(invoiceQuantityInput).clear();
            driver.findElement(invoiceQuantityInput).sendKeys(String.valueOf(_quantity));
            validateHelpers.waitAfterChoseOrClickElement();
        } catch (NoSuchElementException e) {
            Assert.fail("Can not update quantity of the product.");
        }


    }

    public void addAProductLineIntoProductSection() {
        validateHelpers.clickElement(addProductOnProductLinebutton);
        validateHelpers.waitAfterChoseOrClickElement();
    }

    public void changePriceOfAnyProductInProductLines() {
        var priceList = validateHelpers.getList(invoiceProductPriceInput);
        if (!priceList.isEmpty()) {
            Random ran = new Random();
            DecimalFormat df = new DecimalFormat();
            df.setMaximumFractionDigits(3);
            var randomPrice = ran.nextInt(0, priceList.size());
            priceList.get(randomPrice).clear();
            priceList.get(randomPrice).sendKeys(String.valueOf(df.format(ran.nextInt(1, 1000))));
        }
        validateHelpers.waitAfterChoseOrClickElement();
    }

    public void fillProductIntoProductlines() {
        var productLines = validateHelpers.getList(invoiceProductDropdownButton);
        if (!productLines.isEmpty()) {
            for (int i = 0; i < productLines.size(); i++) {
                productLines.get(i).click();
                var list = driver.findElements(invoiceProductList);
                if (!list.isEmpty()) {
                    Random ran = new Random();
                    var randomNumber = ran.nextInt(list.size());
                    list.get(randomNumber).click();
                } else {
                    createProductPage.createProductOnInvoice();
                    validateHelpers.waitForLoadJs();
                    productLines = validateHelpers.getList(invoiceProductDropdownButton);
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

    public void checkInvoiceAfterClickCreateButton_Failed() {
        try {
            Assert.assertTrue(validateHelpers.checkElemenNull(invoiceIDNumber));
            System.out.println("Invoice has been created failed!");

        } catch (NoSuchElementException e) {
            Assert.fail("Create invoice Failed!");
        }
    }

    public void checkInvoiceAfterClickCreateButton() {
        try {
            Assert.assertTrue(driver.findElement(invoiceHistorySection).isDisplayed());
            var IDNumber = validateHelpers.getMessage(invoiceIDNumber);
            System.out.println("Invoice has been created with invoice number: " + IDNumber);

        } catch (NoSuchElementException e) {
            Assert.assertTrue(validateHelpers.checkElemenNull(invoiceHistorySection));
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
        var random = ran.nextInt(1, 1000);
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(3);
        validateHelpers.clearElement(invoiceProductPriceInput);
        validateHelpers.setText(invoiceProductPriceInput, String.valueOf(df.format(random)));
        validateHelpers.waitAfterChoseOrClickElement();
    }

    public void changeProductPriceOtherThan0() {
        var a = validateHelpers.getValueByAttribute(invoiceProductPriceInput);
        if (a.contains("0.00") || a.contains("0")) {
            Random ran = new Random();
            var random = ran.nextInt(1, 1000);
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
            validateHelpers.waitAfterChoseOrClickElement();
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
        validateHelpers.waitAfterChoseOrClickElement();
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
        validateHelpers.waitAfterChoseOrClickElement();
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

    public String getFeeName() {
        var _name = validateHelpers.getValueByAttribute(invoiceFeeField);
        for (int i = 0; ; i++) {
            if (_name.contains(".")) {
                selectFee();
                _name = validateHelpers.getValueByAttribute(invoiceFeeField);
            } else {
                break;
            }
        }
        return _name;
    }

    public void selectProduct() {
        if (!validateHelpers.selectRandom(invoiceProductDropdownButton, invoiceProductList)) {
            createProductPage.createProductOnInvoice();
        }
    }

    public String getProductName() {
        var _name = validateHelpers.getValueByAttribute(productName);
        for (int i = 0; ; i++) {
            if (_name.contains(".")) {
                selectProduct();
                _name = validateHelpers.getValueByAttribute(productName);
            } else {
                break;
            }
        }
        return _name;
    }

    public void selectCustomer(String warning) {
        if (!validateHelpers.selectRandom(customerDropdownListButton, customerList)) {
            createCustomerPage.createCustomerOnCreateInvoicePage(warning);
        }
    }

    public String getCustomerName() {
        var _name = validateHelpers.getValueByAttribute(customerNameField);
        for (int i = 0; ; i++) {
            if (_name.equals("Anonymous") || _name.contains(".")) {
                validateHelpers.selectRandom(customerDropdownListButton, customerList);
                validateHelpers.waitForLoadJs();
                checkConfirmChangeCurrencyDialog();
                validateHelpers.waitForLoadJs();
                cancelChangeCurrency();
                validateHelpers.waitAfterChoseOrClickElement();
                _name = validateHelpers.getValueByAttribute(customerNameField);
            } else {
                break;
            }
        }
        return _name;
    }

    public void selectEmployee(String warning) {
        if (!validateHelpers.selectRandom(employeeDropdownButton, employeeOptionList)) {
            createEmployeesPage.createEmployeeOnCreateInvoicePage(warning);
        }
    }

    public String getEmployeeName() {
        var _name = validateHelpers.getValueByAttribute(employeeName);
        for (int i = 0; ; i++) {
            if (_name.contains(".")) {
                validateHelpers.selectRandom(employeeDropdownButton, employeeOptionList);
                _name = validateHelpers.getValueByAttribute(employeeName);
            } else {
                break;
            }
        }
        return _name;
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
        validateHelpers.waitAfterChoseOrClickElement();
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
