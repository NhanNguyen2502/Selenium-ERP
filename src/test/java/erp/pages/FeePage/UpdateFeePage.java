package erp.pages.FeePage;

import erp.common.helpers.AttachmentDocumentHelper;
import erp.common.helpers.FakeDataHelper;
import erp.common.helpers.ValidateHelpers;
import erp.pages.ProductPage.CreateProductPage;
import erp.pages.ProductPage.UpdateProductPage;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.text.DecimalFormat;
import java.util.Random;

public class UpdateFeePage {
    private WebDriver driver;
    private ValidateHelpers validateHelpers;
    private AttachmentDocumentHelper attachmentDocumentHelper;
    private CreateFeePage createFeePage;
    private String _feeUpdate;
    private Random random;
    private DecimalFormat decimalFormat;
    private String _nameExist;
    private String _feeName;
    private String _feeDeleted;
    private FeeTable feeTable;

    public UpdateFeePage(WebDriver driver) {
        this.driver = driver;
        validateHelpers = new ValidateHelpers(driver);
        createFeePage = new CreateFeePage(driver);
        random = new Random();
        decimalFormat = new DecimalFormat();
        feeTable = new FeeTable(driver);
    }

    private By productLinkOnLeftMenu = By.xpath("//a[@data-cy='sidebar-fee-link']");
    private By feeNameList = By.xpath("//span[@data-cy='fee-name-data']");
    private By feeNamefield = By.xpath("//input[@data-cy='fee-name-input']");
    private By feeNameExist = By.xpath("//mat-error//div[@data-cy='fee-name-required-error']");
    private By createFeeButton = By.xpath("//act-button[@data-cy='create-fee-button']");
    private By feeMainPrice = By.xpath("(//input[@data-cy='fee-currency-amount'])[1]");
    private By feeTableTitle = By.xpath("//span[@data-cy='product-list-page']");
    private By otherPriceList = By.xpath("//input[@data-cy='fee-currency-amount']");
    private By addOtherPriceButton = By.xpath("//act-button[@data-cy='add-fee-amount-button']");
    private By disableEnableCustomerButton = By.xpath("(//mat-slide-toggle)[1]");
    private By confirmDisabledEnable = By.xpath("//button[@data-cy='dialog-yes-button']");
    private By cancelDisableEnableCustomer = By.xpath("//act-button[@data-cy='dialog-cancel-button']");
    private By deleteFeeButton = By.xpath("//act-button[@data-cy='fee-delete-button']");
    private By confirmDeleteFee = By.xpath("//act-button[@data-cy='delete-button']");
    private By cancelDeleteFee = By.xpath("//act-button[@data-cy='cancel-button']");


    public void selectFeeToDisableViaSearchFeeName(String feeName) {
        feeTable.searchFeeName(feeName);
        validateHelpers.waitForLoadJs();
        feeTable.filterEnable();
        validateHelpers.waitForLoadJs();
        int j =0;
        var _feeList = validateHelpers.getList(feeNameList);
        for (int i = 0;; i++) {
            if(!_feeList.isEmpty())
            {
                if (_feeList.size() > 1) {
                    _feeList.get(j).click();
                    validateHelpers.waitForLoadJs();
                    disableFee();
                    validateHelpers.waitAfterChoseOrClickElement();
                    confirmDisableFee();
                    validateHelpers.waitAfterChoseOrClickElement();
                    clickOnSaveButon();
                    validateHelpers.waitForLoadJs();
                    feeTable.searchFeeName(feeName);
                    validateHelpers.waitForLoadJs();
                    feeTable.filterEnable();
                    validateHelpers.waitForLoadJs();
                    _feeList = validateHelpers.getList(feeNameList);

                } else {
                    for ( WebElement a: _feeList)
                    {
                        a.click();
                        validateHelpers.waitForLoadJs();
                        disableFee();
                        validateHelpers.waitAfterChoseOrClickElement();
                        confirmDisableFee();
                        validateHelpers.waitAfterChoseOrClickElement();
                        clickOnSaveButon();
                        validateHelpers.waitForLoadJs();
                        _feeList = validateHelpers.getList(feeNameList);
                        break;
                    }

                }
            }
            else {
                break;
            }

        }

    }

    public void verifyDeleteFailed() {
        try {
            Assert.assertTrue(validateHelpers.checkElemenNull(feeTableTitle));
            System.out.println("Deleted Failed: " + _feeDeleted);
        } catch (NoSuchElementException e) {
            Assert.fail("Verify Failed");
        }
    }

    public void verifyDeleteSuccess() {
        try {
            Assert.assertTrue(driver.findElement(feeTableTitle).isDisplayed());
            System.out.println("Deleted Success: " + _feeDeleted);
        } catch (NoSuchElementException e) {
            Assert.fail("Delete Failed");
        }
    }

    public void cancelDelete() {
        validateHelpers.clickElement(cancelDeleteFee);
    }

    public void confirmDelete() {
        validateHelpers.clickElement(confirmDeleteFee);
    }

    public void deleteFee() {
        _feeDeleted = validateHelpers.getValueByAttribute(feeNamefield);
        validateHelpers.clickElement(deleteFeeButton);
    }

    public void cancelEnableFee() {
        validateHelpers.clickElement(cancelDisableEnableCustomer);
        System.out.println("Cancel Enabled");
    }

    public void confirmEnableFee() {
        validateHelpers.clickElement(confirmDisabledEnable);
        System.out.println("Confirm Enabled");
    }

    public void enableFee() {
        validateHelpers.clickElement(disableEnableCustomerButton);
    }

    public void cancelDisableFee() {
        validateHelpers.clickElement(cancelDisableEnableCustomer);
        System.out.println("Cancel Disabled");
    }

    public void confirmDisableFee() {
        validateHelpers.clickElement(confirmDisabledEnable);
        System.out.println("Confirm Disable");
    }

    public void disableFee() {
        validateHelpers.clickElement(disableEnableCustomerButton);
    }

    public void updateAllPrices() {
        var _otherPriceList = validateHelpers.getList(otherPriceList);
        for (int i = 0; i < _otherPriceList.size(); i++) {
            var _randomPrice = decimalFormat.format(random.nextInt(1, 100));
            var _oldPrice = _otherPriceList.get(i).getAttribute("value");
            System.out.println("Update price from " + _oldPrice + " to " + _randomPrice);
            _otherPriceList.get(i).clear();
            _otherPriceList.get(i).sendKeys(String.valueOf(_randomPrice));
        }
    }

    public void addPriceOfOtherPrice() {
        var _otherPriceList = validateHelpers.getList(otherPriceList);
        for (int i = 1; i < _otherPriceList.size(); i++) {
            var _randomPrice = decimalFormat.format(random.nextInt(1, 100));
            _otherPriceList.get(i).clear();
            _otherPriceList.get(i).sendKeys(String.valueOf(_randomPrice));
        }
    }

    public void addOtherPrice() {
        var _numberRandom = random.nextInt(1, 5);
        for (int i = 0; i < _numberRandom; i++) {
            validateHelpers.waitAfterChoseOrClickElement();
            validateHelpers.clickElement(addOtherPriceButton);
            validateHelpers.waitAfterChoseOrClickElement();
        }
    }

    public void verifyUpdateSuccess() {
        try {
            if (driver.findElement(feeTableTitle).isDisplayed()) {
                Assert.assertTrue(validateHelpers.checkDisplayed(feeTableTitle));
                System.out.println("The fee has been update success with name: " + _feeName);
            }
        } catch (NoSuchElementException e) {
            Assert.fail("Create Failed");
        }
    }

    public void updateMainPriceOfFee() {
        decimalFormat.setMaximumFractionDigits(3);
        var _oldPrice = validateHelpers.getValueByAttribute(feeMainPrice);
        var _newPrice = decimalFormat.format(random.nextDouble(1, 100));
        System.out.println("The main price change from: " + _oldPrice + " to " + _newPrice);
        validateHelpers.clearElement(feeMainPrice);
        validateHelpers.setText(feeMainPrice, String.valueOf(_newPrice));
    }

    public void clickOnSaveButon() {
        _feeName = validateHelpers.getValueByAttribute(feeNamefield);
        validateHelpers.clickElement(createFeeButton);
    }

    public void updateFeeName() {
        _feeName = FakeDataHelper.getFakedata().job().title();
        validateHelpers.clearElement(feeNamefield);
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
            System.out.println("Can update the fee with this name.");
        }
    }

    public void selectFeeToUpdate() {
        var _feeList = validateHelpers.getList(feeNameList);
        if (_feeList.isEmpty()) {
            createFeePage.goToCreateFeeTable();
            validateHelpers.waitForLoadJs();
            createFeePage.goToCreateFeePage();
            validateHelpers.waitForLoadJsCreatePage();
            createFeePage.enterFeeName();
            validateHelpers.waitAfterChoseOrClickElement();
            createFeePage.enterFeePrice();
            validateHelpers.waitForLoadJs();
            createFeePage.clickOnCreateButon();
            validateHelpers.waitForLoadJs();
            createFeePage.verifyCreateSuccess();
            _feeList = validateHelpers.getList(feeNameList);
        }
        var _random = random.nextInt(_feeList.size());
        _feeUpdate = _feeList.get(_random).getText();
        _feeList.get(_random).click();
        System.out.println("The customer has been selected: " + _feeUpdate);
    }

    public void goToFeeTable() {
        validateHelpers.clickElement(productLinkOnLeftMenu);
    }
}
