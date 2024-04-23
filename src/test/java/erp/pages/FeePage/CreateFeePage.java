package erp.pages.FeePage;

import erp.common.helpers.FakeDataHelper;
import erp.common.helpers.ValidateHelpers;
import org.apache.poi.hssf.record.PageBreakRecord;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.text.DecimalFormat;
import java.util.Random;

public class CreateFeePage {
    private WebDriver driver;
    private ValidateHelpers validateHelpers;
    private String _feeName;
    private Random random;
    private DecimalFormat decimalFormat;
    private String _nameAlreadyExist = null;

    public CreateFeePage(WebDriver driver) {
        this.driver = driver;
        validateHelpers = new ValidateHelpers(driver);
        random = new Random();
        decimalFormat = new DecimalFormat();
    }

    //Create fee on the create invoice page
    private By invoiceAddNewFeeOnFeeLineButton = By.xpath("//act-button[@data-cy='new-fee-row-button']");
    private By invoiceFeeField = By.xpath("//input[@data-cy='select-fee']");
    private By invoiceAddNewFeeButton = By.xpath("(//act-button[@apptooltip='regularInvoice.button.createFeeTooltip'])[2]");
    private By invoiceFeeList = By.xpath("//mat-option");
    private By invoiceFeeError = By.xpath("//div[@data-cy='fee-name-required-error']");
    private By invoiceFeeNameField = By.xpath("//input[@data-cy='fee-name-input']");
    private By invoiceMainPricefield = By.xpath("//input[@data-cy='fee-amount-company-main-currecny']");
    private By invoiceCreateButton = By.xpath("//mat-dialog-actions//button[@data-cy='dialog-confirm-button']");
    private By leftMenuFee = By.xpath("//a[@data-cy='sidebar-fee-link']");
    private By createButtonOnTable = By.xpath("//act-button[@data-cy='create-fee-button']");
    private By feeNamefield = By.xpath("//input[@data-cy='fee-name-input']");
    private By feeNameExist = By.xpath("//mat-error//div[@data-cy='fee-name-required-error']");
    private By createFeeButton = By.xpath("//button[@data-cy='fee-submit-button']");
    private By feeTableTitle = By.xpath("//span[@data-cy='product-list-page']");
    private By feePrice = By.xpath("//input[@data-cy='fee-currency-amount']");
    private By feeNameRequired = By.xpath("//div[@data-cy='fee-name-required-error']");
    private By feeNameOnTable = By.xpath("//mat-row//mat-cell[3]//span");
    private By feeTaxField = By.xpath("//input[@data-cy='select-vat']");
    private By feeTaxList = By.xpath("//mat-option");
    private By addPriceLineButton = By.xpath("//button[@data-cy='add-fee-amount-button']");


    public void addPriceToPriceLine() {
        var _priceList = validateHelpers.getList(feePrice);
        decimalFormat.setMaximumFractionDigits(3);
        if(!_priceList.isEmpty())
        {
            for(WebElement a : _priceList)
            {
                a.clear();
                a.sendKeys(String.valueOf(decimalFormat.format(random.nextDouble(1,100))));
            }
        }
    }

    public void addManyPriceLineWithOtherCurrencies() {
        for (int i = 0; i <= random.nextInt(10); i++) {
            validateHelpers.clickElement(addPriceLineButton);
            validateHelpers.waitAfterChoseOrClickElement();
        }
    }

    public void selectTax() {
        try {
            if (driver.findElement(feeTaxField).isDisplayed()) {
                Assert.assertTrue(validateHelpers.checkDisplayed(feeTaxField));
                validateHelpers.clickElement(feeTaxField);
                var _taxlist = validateHelpers.getList(feeTaxList);
                if (!_taxlist.isEmpty()) {
                    _taxlist.get(random.nextInt(_taxlist.size())).click();
                } else {
                    System.out.println("Create Fee without entries tax.");
                }
            }
        } catch (NoSuchElementException e) {
            Assert.fail("Tax not exist.");
        }
    }

    public void enterNameAlreadyExist() {
        if (!_nameAlreadyExist.isEmpty()) {
            validateHelpers.setText(feeNamefield, _nameAlreadyExist);
            validateHelpers.clickOutside();
            Assert.assertTrue(validateHelpers.checkDisplayed(feeNameExist));
            System.out.println("This name already exist, Please enter another name.");
        } else {
            enterFeeName();
        }
    }

    public String getNameAlreadyExist() {
        var _listName = validateHelpers.getList(feeNameOnTable);
        if (!_listName.isEmpty()) {
            _nameAlreadyExist = _listName.get(random.nextInt(_listName.size())).getText();
        }
        return _nameAlreadyExist;
    }

    public void checkNameRequied() {
        Assert.assertTrue(validateHelpers.checkDisplayed(feeNameRequired));
    }

    public void verifyCreateFailed() {
        Assert.assertTrue(validateHelpers.checkElemenNull(feeTableTitle));
        System.out.println("Create Fee Failed.");
    }

    public void enterFeePrice() {
        decimalFormat.setMaximumFractionDigits(3);
        validateHelpers.clearElement(feePrice);
        validateHelpers.setText(feePrice, String.valueOf(decimalFormat.format(random.nextDouble(1, 100))));
    }

    public void verifyCreateSuccess() {
        try {
            if (driver.findElement(feeTableTitle).isDisplayed()) {
                Assert.assertTrue(validateHelpers.checkDisplayed(feeTableTitle));
                System.out.println("The fee has been create success with name " + _feeName);
            }
        } catch (NoSuchElementException e) {
            Assert.fail("Create Failed");
        }
    }

    public void clickOnCreateButon() {
        validateHelpers.clickElement(createFeeButton);
    }

    public void enterFeeName() {
        _feeName = FakeDataHelper.getFakedata().job().title();
        validateHelpers.setText(feeNamefield, _feeName);
        try {
            for (int i = 0; ; i++) {
                if (driver.findElement(feeNameExist).isDisplayed()) {
                    _feeName = FakeDataHelper.getFakedata().job().title();
                    validateHelpers.clearElement(feeNamefield);
                    validateHelpers.setText(feeNamefield, _feeName);
                } else {
                    break;
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println("Can create the fee with this name.");
        }
    }

    public void goToCreateFeePage() {
        validateHelpers.clickElement(createButtonOnTable);
    }

    public void goToCreateFeeTable() {
        validateHelpers.clickElement(leftMenuFee);
    }

    public void createFeeOnInvoice() {

        Assert.assertTrue(validateHelpers.checkDisplayed(invoiceAddNewFeeOnFeeLineButton));
        Assert.assertTrue(validateHelpers.checkDisplayed(invoiceAddNewFeeButton));
        Assert.assertTrue(validateHelpers.checkDisplayed(invoiceFeeField));
        validateHelpers.clickElement(invoiceAddNewFeeButton);
        validateHelpers.setText(invoiceFeeNameField, FakeDataHelper.getFakedata().job().title());
        validateHelpers.clearElement(invoiceMainPricefield);
        validateHelpers.setText(invoiceMainPricefield, String.valueOf(FakeDataHelper.getFakedata().number().numberBetween(0, 100)));
        validateHelpers.clickElement(invoiceCreateButton);
    }
}
