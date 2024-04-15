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
import java.util.Random;

public class UpdateProductPage {
    private WebDriver driver;
    private ValidateHelpers validateHelpers;
    private AttachmentDocumentHelper attachmentDocumentHelper;
    private CreateProductPage createProductPage;
    private String _productUpdate;
    private Random random;
    private String _productNameDelete;
    private DecimalFormat decimalFormat;
    private String _nameExist;
    private String _productName;
    private ProductTable productTable;

    public UpdateProductPage(WebDriver driver) {
        this.driver = driver;
        validateHelpers = new ValidateHelpers(driver);
        attachmentDocumentHelper = new AttachmentDocumentHelper(driver);
        random = new Random();
        decimalFormat = new DecimalFormat();
        createProductPage = new CreateProductPage(driver);
        productTable = new ProductTable(driver);
    }

    private By productLinkOnLeftMenu = By.xpath("//a[@data-cy='sidebar-product-link']");
    private By productNameList = By.xpath("//span[@data-cy='product-name-data']");
    private By productName = By.xpath("//input[@data-cy='product-name']");
    private By productNameExist = By.xpath("//div[@data-cy='product-name-exist-error']");
    private By createProductButton = By.xpath("//button[@data-cy='create-product-button']");
    private By productTableTitle = By.xpath("//div[@data-cy='product-list-page']");
    private By productPrice = By.xpath("//input[@data-cy='product-price']");
    private By productImage = By.xpath("//input[@apptooltip='avatar.tooltips.uploadImageTooltip']");
    private By productImageConfirm = By.xpath("//button[@data-cy='save-imapge-uplaod-button']");
    private By productImageCancel = By.xpath("//button[@data-cy='cancel-image-uplaod-button']");
    private By deleteAvatarButton = By.xpath("//app-avatar//app-expanding-button");
    private By confirmDeleteAvatarButton = By.xpath("//button[@data-cy='dialog-yes-button']");
    private By cancelDeleteAvatar = By.xpath("//button[@data-cy='dialog-cancel-button']");
    private By disableEnableCustomerButton = By.xpath("//mat-slide-toggle");
    private By confirmDisabledEnable = By.xpath("//button[@data-cy='dialog-yes-button']");
    private By cancelDisableEnableCustomer = By.xpath("//button[@data-cy='dialog-cancel-button']");
    private By productTypeInput = By.xpath("//app-select//input");
    private By productTypeList = By.xpath("//mat-option");
    private By taxInput = By.xpath("//app-select-object-control//input[@data-cy='select-vat']");
    private By taxList = By.xpath("//mat-option");
    private By anotherProductPrice = By.xpath("//input[@data-cy='product-currency-price']");
    private By addAnotherPriceButton = By.xpath("//app-product-other-currency-price//button[@data-cy='add-product-price-button']");
    private By deleteProductButton = By.xpath("//button[@data-cy='product-delete-button']");
    private By confirmDeleteProduct = By.xpath("//button[@data-cy='delete-button']");
    private By cancelDeleteProduct = By.xpath("//button[@data-cy='cancel-button']");


    public void verifyDeleteFailed() {
        try {
            Assert.assertTrue(validateHelpers.checkElemenNull(productTableTitle));
            System.out.println("Deleted Failed: " + _productNameDelete);
        } catch (NoSuchElementException e) {
            Assert.fail("Verify Failed");
        }
    }

    public void verifyDeleteSuccess() {
        try {
            Assert.assertTrue(driver.findElement(productTableTitle).isDisplayed());
            System.out.println("Deleted Success: " + _productNameDelete);
        } catch (NoSuchElementException e) {
            Assert.fail("Delete Failed");
        }
    }

    public void cancelDelete() {
        validateHelpers.clickElement(cancelDeleteProduct);
    }

    public void confirmDelete() {
        validateHelpers.clickElement(confirmDeleteProduct);
    }

    public void deleteProduct() {
        _productNameDelete = validateHelpers.getValueByAttribute(productName);
        validateHelpers.clickElement(deleteProductButton);
    }

    public void updateProductNameExist() {
        if (!_nameExist.isEmpty()) {
            validateHelpers.clearElement(productName);
            validateHelpers.setText(productName, _nameExist);
            validateHelpers.clickOutside();
            Assert.assertTrue(validateHelpers.checkDisplayed(productNameExist));
            System.out.println("Can not create a product has name already exist.");
        } else {
            System.out.println("This company has not product.");
        }
    }

    public String getProductNameExist() {
        var _nameExistList = validateHelpers.getList(productNameList);
        if (!_nameExistList.isEmpty()) {
            var _nameRandom = random.nextInt(_nameExistList.size());
            _nameExist = _nameExistList.get(_nameRandom).getText();
        }
        return _nameExist;
    }

    public void updatePriceOfAnotherPrice() {
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
        var _anotherList = validateHelpers.getList(anotherProductPrice);
        var _numberRandom = random.nextInt(1, 10);
        if (!_anotherList.isEmpty()) {
            System.out.println("This product has another prices: " + _anotherList.size());
            _numberRandom = random.nextInt(_anotherList.size());
            System.out.println("Add more: " + _numberRandom);
            for (int i = 0; i < _numberRandom; i++) {
                validateHelpers.clickElement(addAnotherPriceButton);
                validateHelpers.waitAfterChoseOrClickElement();
            }
        } else {
            System.out.println("Add " + _numberRandom + " another prices.");
            for (int i = 0; i < _numberRandom; i++) {
                validateHelpers.clickElement(addAnotherPriceButton);
                validateHelpers.waitAfterChoseOrClickElement();
            }
        }

    }

    public void updateAnotherTax() {
        try {
            if (driver.findElement(taxInput).isDisplayed()) {
                validateHelpers.clickElement(taxInput);
                var _taxList = validateHelpers.getList(taxList);
                if (!_taxList.isEmpty()) {
                    var _taxRandom = random.nextInt(_taxList.size());
                    System.out.println("Tax has been selected: " + _taxList.get(_taxRandom).getText());
                    _taxList.get(_taxRandom).click();
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println("Tax does not display.");
        }
    }

    public void updateProductType() {
        var _oldType = validateHelpers.getValueByAttribute(productTypeInput);
        validateHelpers.clickElement(productTypeInput);
        var _typeList = validateHelpers.getList(productTypeList);
        if (!_typeList.isEmpty()) {
            for (WebElement a : _typeList) {
                if (!a.getText().contains(_oldType)) {
                    System.out.println("Change product type from " + _oldType + " to " + a.getText());
                    a.click();
                    break;
                }
            }
        } else {
            System.out.println("Type List is null");
        }
    }

    public void cancelEnableProduct() {
        validateHelpers.clickElement(cancelDisableEnableCustomer);
        System.out.println("Cancel Enabled");
    }

    public void confirmEnableProduct() {
        validateHelpers.clickElement(confirmDisabledEnable);
        System.out.println("Confirm Enabled");
    }

    public void enableProduct() {
        validateHelpers.clickElement(disableEnableCustomerButton);
    }

    public void cancelDisableProduct() {
        validateHelpers.clickElement(cancelDisableEnableCustomer);
        System.out.println("Cancel Disabled");
    }

    public void confirmDisableProduct() {
        validateHelpers.clickElement(confirmDisabledEnable);
        System.out.println("Confirm Disable");
    }

    public void disableProduct() {
        validateHelpers.clickElement(disableEnableCustomerButton);
    }

    public void updateMainProductPrice() {
        var _amountRandom = random.nextDouble(1, 1000);
        decimalFormat.setMaximumFractionDigits(3);
        validateHelpers.clearElement(productPrice);
        validateHelpers.clickElement(productPrice);
        validateHelpers.setText(productPrice, String.valueOf(decimalFormat.format(_amountRandom)));
    }

    public void cancelDeleteProductImage() {
        validateHelpers.clickElement(cancelDeleteAvatar);
        validateHelpers.waitForLoadJs();
        var a = validateHelpers.getList(deleteAvatarButton);
        if (!a.isEmpty()) {
            System.out.println(" Cancel delete product image success!");
        } else {
            System.out.println(" Cancel product image failed!");
        }
    }

    public void confirmDeleteProductImage() {
        validateHelpers.clickElement(confirmDeleteAvatarButton);
        validateHelpers.waitForLoadJs();
        Assert.assertTrue(validateHelpers.checkElemenNull(deleteAvatarButton));
        System.out.println(" Confirm delete product image success!");

    }

    public void deleteProductImage() {
        try {
            var a = validateHelpers.getList(deleteAvatarButton);
            if (a.isEmpty()) {
                uploadProductImage();
                validateHelpers.waitAfterChoseOrClickElement();
                confirmUploadProductImage();
                validateHelpers.waitAfterChoseOrClickElement();
                validateHelpers.clickElement(deleteAvatarButton);
            } else {
                validateHelpers.clickElement(deleteAvatarButton);
            }
        } catch (NoSuchElementException e) {
            System.out.println("");
        }
    }

    public void cancelUploadProductImage() {
        validateHelpers.clickElement(productImageConfirm);
        var _avatar = validateHelpers.getValueByAttribute(productImage);
        if (_avatar.isEmpty()) {
            System.out.println(" Cancel upload Avatar success!");
        } else {
            System.out.println("Cancel upload Avatar failed!");
        }
    }


    public void confirmUploadProductImage() {
        validateHelpers.clickElement(productImageConfirm);
        var _avatar = validateHelpers.getValueByAttribute(productImage);
        if (!_avatar.isEmpty()) {
            System.out.println("Upload Avatar success!");
        } else {
            Assert.fail("Upload Avatar failed!");

        }
    }

    public void uploadProductImage() {
        attachmentDocumentHelper.uploadProductImage(productImage);
    }

    public void verifyAfterUpdate_Failed() {

        Assert.assertTrue(validateHelpers.checkElemenNull(productTableTitle));
        System.out.println("Updated Product Failed.");
    }

    public void verifyAfterUpdate_success() {
        try {
            if (driver.findElement(productTableTitle).isDisplayed()) {
                System.out.println("The product has been updated success with name: " + _productName);
            }
        } catch (NoSuchElementException e) {
            Assert.fail("Update failed");
        }
    }

    public void clickOnSaveButton() {
        _productName = validateHelpers.getValueByAttribute(productName);
        validateHelpers.clickElement(createProductButton);
    }

    public void updateProductName() {
        _productName = FakeDataHelper.getFakedata().tea().variety();
        validateHelpers.clearElement(productName);
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
            System.out.println("Can update the product with this name.");
        }
    }

    public void selectProductToUpdate() {
        var _productList = validateHelpers.getList(productNameList);
        var _ran = random.nextInt(0,_productList.size());
        if (_productList.isEmpty()) {
            createProductPage.goToCreateProductPage();
            validateHelpers.waitForLoadJsCreatePage();
            createProductPage.enterProductName();
            validateHelpers.waitAfterChoseOrClickElement();
            createProductPage.enterProductPrice();
            validateHelpers.waitAfterChoseOrClickElement();
            createProductPage.clickOnCreateButton();
            validateHelpers.waitForLoadJs();
            createProductPage.verifyAfterCreate_success();
            _productList = validateHelpers.getList(productNameList);
            _ran = random.nextInt(0,_productList.size());
        }
        _productUpdate = _productList.get(_ran).getText();
        _productList.get(_ran).click();
        System.out.println("Product has been selected: " + _productUpdate);

    }

    public void selectProductNameToUpdate(String productName) {
        productTable.searchProductName(productName);
        validateHelpers.waitForLoadJs();
        productTable.filterEnable();
        validateHelpers.waitForLoadJs();
        var _productList = validateHelpers.getList(productNameList);
        for(WebElement a: _productList)
        {
            if(a.getText().equals(productName))
            {
                _productUpdate = a.getText();
                a.click();
                break;
            }
        }
        System.out.println("Product has been selected: " + _productUpdate);

    }

    public void goToProductTable() {
        validateHelpers.clickElement(productLinkOnLeftMenu);
    }
}
