package erp.pages.ProductPage;

import erp.common.helpers.AttachmentDocumentHelper;
import erp.common.helpers.FakeDataHelper;
import erp.common.helpers.ValidateHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Random;

public class CreateProductPage {
    private WebDriver driver;
    private ValidateHelpers validateHelpers;
    private AttachmentDocumentHelper attachmentDocumentHelper;
    private String _productName;
    private Random random;
    private DecimalFormat decimalFormat;
    private String _nameExist;

    //Create product on the invoice page
    private By invoiceAddProductButton = By.xpath("(//button[@data-cy='add-product-button'])[2]");
    private By invoiceProductDropdownButton = By.xpath("//input[@data-cy='select-product']");
    private By invoiceProductList = By.xpath("//mat-option");
    private By invoiceProductName = By.xpath("//input[@apptooltip='invoicesCommon.dialog.createEditProduct.inputField.productNameTooltip']");
    private By invoiceProuctPrice = By.xpath("//input[@apptooltip='invoicesCommon.dialog.createEditProduct.inputField.standardPriceTooltip']");
    private By invoiceCreateProductButton = By.xpath("//button[@data-cy='dialog-confirm-button']");
    private By productLinkOnLeftMenu = By.xpath("//a[@data-cy='sidebar-product-link']");
    private By productCreateButton = By.xpath("//button[@data-cy='create-product-button']");
    private By productImage = By.xpath("//input[@apptooltip='avatar.tooltips.uploadImageTooltip']");
    private By productName = By.xpath("//input[@data-cy='product-name']");
    private By productImageConfirm = By.xpath("//button[@data-cy='save-imapge-uplaod-button']");
    private By productImageCancel = By.xpath("//button[@data-cy='cancel-image-uplaod-button']");
    private By createProductButton = By.xpath("//button[@data-cy='create-product-button']");
    private By productTableTitle = By.xpath("//div[@data-cy='product-list-page']");
    private By productTypeInput = By.xpath("//app-select//input");
    private By productTypeList = By.xpath("//mat-option");
    private By productPrice = By.xpath("//input[@data-cy='product-price']");
    private By taxInput = By.xpath("//app-select-object-control//input[@data-cy='select-vat']");
    private By taxList = By.xpath("//mat-option");
    private By productPriceOfLine = By.xpath("//app-amount-display//div//span[@data-cy='number-before']");
    private By addAnotherPriceButton = By.xpath("//app-product-other-currency-price//button[@data-cy='add-product-price-button']");
    private By anotherProductPrice = By.xpath("//input[@data-cy='product-currency-price']");
    private By productNameExist = By.xpath("//div[@data-cy='product-name-exist-error']");
    private By productNameRequired = By.xpath("//div[@data-cy='product-name-required-error']");
    private By productNameExistList = By.xpath("//span[@data-cy='product-name-data']");


    public CreateProductPage(WebDriver driver) {
        this.driver = driver;
        validateHelpers = new ValidateHelpers(driver);
        attachmentDocumentHelper = new AttachmentDocumentHelper(driver);
        random = new Random();
        decimalFormat = new DecimalFormat();
    }

    public String getProductNameExist() {
        var _nameExistList = validateHelpers.getList(productNameExistList);
        if(!_nameExistList.isEmpty())
        {
            var _nameRandom = random.nextInt(_nameExistList.size());
            _nameExist = _nameExistList.get(_nameRandom).getText();
        }
        return  _nameExist;
    }

    public void enterProductNameExist() {
        if (!_nameExist.isEmpty()) {
            validateHelpers.setText(productName, _nameExist);
            validateHelpers.clickOutside();
            Assert.assertTrue(validateHelpers.checkDisplayed(productNameExist));
            System.out.println("Can not create a product has name already exist.");
        } else {
            System.out.println("This company has not product.");
        }
    }

    public void checkProductNameRequired() {
        Assert.assertTrue(validateHelpers.checkDisplayed(productNameRequired));
    }

    public void enterProductPriceToAnotherPrice() {
        var _priceInputList = validateHelpers.getList(anotherProductPrice);
        if (!_priceInputList.isEmpty()) {
            for (WebElement a : _priceInputList) {
                decimalFormat.setMaximumFractionDigits(3);
                var _priceRandom = random.nextDouble(1, 1000);
                a.sendKeys(String.valueOf(decimalFormat.format(_priceRandom)));
            }
        }
    }

    public void addAnotherPrice() {
        var _numberRandom = random.nextInt(10);
        for (int i = 0; i <= _numberRandom; i++) {
            validateHelpers.clickElement(addAnotherPriceButton);
        }
    }

    public void selectTax() {
        try {
            if (driver.findElement(taxInput).isDisplayed()) {
                validateHelpers.clickElement(taxInput);
                var _taxList = validateHelpers.getList(taxList);
                if (!_taxList.isEmpty()) {
                    var _taxRandom = random.nextInt(_taxList.size());
                    _taxList.get(_taxRandom).click();
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println("Tax does not display.");
        }
    }

    public void enterProductPrice() {
        var _amountRandom = random.nextDouble(1, 1000);
        decimalFormat.setMaximumFractionDigits(3);
        validateHelpers.clickElement(productPrice);
        validateHelpers.setText(productPrice, String.valueOf(decimalFormat.format(_amountRandom)));
    }

    public void selectProductService() {
        var _oldType = validateHelpers.getValueByAttribute(productTypeInput);
        validateHelpers.clickElement(productTypeInput);
        var _typeList = validateHelpers.getList(productTypeList);
        if (!_typeList.isEmpty()) {
            for (WebElement a : _typeList) {
                if (!a.getText().contains(_oldType)) {
                    a.click();
                    break;
                }
            }
        } else {
            System.out.println("Type List is null");
        }
    }

    public void verifyAfterCreate_Failed() {

        Assert.assertTrue(validateHelpers.checkElemenNull(productTableTitle));
        System.out.println("Create Product Failed.");
//        try {
//            var _list = validateHelpers.getList(productTableTitle);
//            Assert.assertTrue(_list.isEmpty());
//            System.out.println("Create Product Failed.");
//        } catch (NoSuchElementException e) {
//            Assert.fail("This case Failed.");
//        }
    }

    public void verifyAfterCreate_success() {
        try {
            if (driver.findElement(productTableTitle).isDisplayed()) {
                System.out.println("The product has been create success with name " + _productName);
            }
        } catch (NoSuchElementException e) {
            Assert.fail("Create failed");
        }
    }

    public void clickOnCreateButton() {
        validateHelpers.clickElement(createProductButton);
    }

    public void cancelUploadProductImage() {
        try {
            if (driver.findElement(productImageCancel).isDisplayed()) {
                validateHelpers.clickElement(productImageCancel);
                System.out.println("Confirm upload product image success.");
            }
        } catch (NoSuchElementException e) {
            Assert.fail("Canceled Upload failed.");
        }
    }

    public void confirmUploadProductImage() {
        try {
            if (driver.findElement(productImageConfirm).isDisplayed()) {
                validateHelpers.clickElement(productImageConfirm);
                System.out.println("Confirm upload product image success.");
            }
        } catch (NoSuchElementException e) {
            Assert.fail("Confirm failed.");
        }
    }

    public void uploadProductImage() {
        attachmentDocumentHelper.uploadProductImage(productImage);
    }

    public void enterProductName() {
        _productName = FakeDataHelper.getFakedata().tea().variety();
        validateHelpers.setText(productName, _productName);
        try {
            for (int i = 0; ; i++) {
                if (driver.findElement(productNameExist).isDisplayed()) {
                    _productName = FakeDataHelper.getFakedata().tea().variety();
                    validateHelpers.clearElement(productName);
                    validateHelpers.setText(productName, _productName);
                } else {
                    break;
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println("Can create the product with this name.");
        }
    }


    public void goToCreateProductPage() {
        validateHelpers.clickElement(productCreateButton);
    }

    public void goToProductTable() {
        validateHelpers.clickElement(productLinkOnLeftMenu);
    }

    public void createProductOnInvoice() {
        Assert.assertTrue(validateHelpers.checkDisplayed(invoiceAddProductButton));
        Assert.assertTrue(validateHelpers.checkDisplayed(invoiceProductDropdownButton));
        validateHelpers.clickElement(invoiceAddProductButton);
        validateHelpers.setText(invoiceProductName, FakeDataHelper.getFakedata().tea().variety());
        validateHelpers.clearElement(invoiceProuctPrice);
        validateHelpers.setText(invoiceProuctPrice, String.valueOf(FakeDataHelper.getFakedata().number().numberBetween(0, 100)));
        validateHelpers.clickElement(invoiceCreateProductButton);

    }
}
