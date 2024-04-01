package erp.testcases.UpdateProduct.RealCompany;

import erp.base.BaseSetup;
import erp.base.ReportListener;
import erp.common.helpers.GetTypeOfCompanyHelper;
import erp.common.helpers.PropertiesHelper;
import erp.common.helpers.ValidateHelpers;
import erp.pages.CompanyListPage;
import erp.pages.ProductPage.ProductTable;
import erp.pages.ProductPage.UpdateProductPage;
import erp.pages.SignInPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

@Listeners(ReportListener.class)
public class UpdateProductTest extends BaseSetup {
    private WebDriver driver;
    private UpdateProductPage updateProductPage;
    private ValidateHelpers validateHelpers;
    private SignInPage signInPage;
    private CompanyListPage companyListPage;
    private ProductTable productTable;

    @BeforeClass
    public void setup() {
        this.driver = getDriver();
        validateHelpers = new ValidateHelpers(driver);
        updateProductPage = new UpdateProductPage(driver);
        signInPage = new SignInPage(driver);
        companyListPage = new CompanyListPage(driver);
        productTable = new ProductTable(driver);
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void updateProductName_then_updateSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        validateHelpers.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        updateProductPage.goToProductTable();
        validateHelpers.waitForLoadJs();
        updateProductPage.selectProductToUpdate();
        validateHelpers.waitForLoadJsLoginPage();
        updateProductPage.updateProductName();
        validateHelpers.waitAfterChoseOrClickElement();
        updateProductPage.clickOnSaveButton();
        validateHelpers.waitForLoadJs();
        updateProductPage.verifyAfterUpdate_success();
        validateHelpers.waitForLoadJs();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void updateMainProductPrice_then_updateSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        validateHelpers.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        updateProductPage.goToProductTable();
        validateHelpers.waitForLoadJs();
        updateProductPage.selectProductToUpdate();
        validateHelpers.waitForLoadJsLoginPage();
        updateProductPage.updateMainProductPrice();
        validateHelpers.waitAfterChoseOrClickElement();
        updateProductPage.clickOnSaveButton();
        validateHelpers.waitForLoadJs();
        updateProductPage.verifyAfterUpdate_success();
        validateHelpers.waitForLoadJs();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void updateImageOfProduct_then_updateSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        validateHelpers.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        updateProductPage.goToProductTable();
        validateHelpers.waitForLoadJs();
        updateProductPage.selectProductToUpdate();
        validateHelpers.waitForLoadJsLoginPage();
        updateProductPage.uploadProductImage();
        validateHelpers.waitAfterChoseOrClickElement();
        updateProductPage.confirmUploadProductImage();
        validateHelpers.waitAfterChoseOrClickElement();
        updateProductPage.clickOnSaveButton();
        validateHelpers.waitForLoadJs();
        updateProductPage.verifyAfterUpdate_success();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void updateConfirmDeleteImageOfProduct_then_updateSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        validateHelpers.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        updateProductPage.goToProductTable();
        validateHelpers.waitForLoadJs();
        updateProductPage.selectProductToUpdate();
        validateHelpers.waitForLoadJsLoginPage();
        updateProductPage.deleteProductImage();
        validateHelpers.waitAfterChoseOrClickElement();
        updateProductPage.confirmDeleteProductImage();
        validateHelpers.waitAfterChoseOrClickElement();
        updateProductPage.clickOnSaveButton();
        validateHelpers.waitForLoadJs();
        updateProductPage.verifyAfterUpdate_success();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void updateDisableProduct_then_updateSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        validateHelpers.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        updateProductPage.goToProductTable();
        validateHelpers.waitForLoadJs();
        productTable.filterEnable();
        validateHelpers.waitForLoadJs();
        updateProductPage.selectProductToUpdate();
        validateHelpers.waitForLoadJsLoginPage();
        updateProductPage.disableProduct();
        validateHelpers.waitAfterChoseOrClickElement();
        updateProductPage.confirmDisableProduct();
        validateHelpers.waitAfterChoseOrClickElement();
        updateProductPage.clickOnSaveButton();
        validateHelpers.waitForLoadJs();
        updateProductPage.verifyAfterUpdate_success();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

    @Test(priority = 2)
    @Parameters({"language"})
    public void updateEnableProduct_then_updateSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        validateHelpers.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        updateProductPage.goToProductTable();
        validateHelpers.waitForLoadJs();
        productTable.filterDisabled();
        validateHelpers.waitForLoadJs();
        updateProductPage.selectProductToUpdate();
        validateHelpers.waitForLoadJsLoginPage();
        updateProductPage.enableProduct();
        validateHelpers.waitAfterChoseOrClickElement();
        updateProductPage.confirmEnableProduct();
        validateHelpers.waitAfterChoseOrClickElement();
        updateProductPage.clickOnSaveButton();
        validateHelpers.waitForLoadJs();
        updateProductPage.verifyAfterUpdate_success();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void updateProductType_then_updateSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        validateHelpers.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        updateProductPage.goToProductTable();
        validateHelpers.waitForLoadJs();
        updateProductPage.selectProductToUpdate();
        validateHelpers.waitForLoadJsLoginPage();
        updateProductPage.updateProductType();
        validateHelpers.waitAfterChoseOrClickElement();
        updateProductPage.clickOnSaveButton();
        validateHelpers.waitForLoadJs();
        updateProductPage.verifyAfterUpdate_success();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void updateTaxOfProduct_then_updateSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        validateHelpers.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        updateProductPage.goToProductTable();
        validateHelpers.waitForLoadJs();
        updateProductPage.selectProductToUpdate();
        validateHelpers.waitForLoadJsLoginPage();
        updateProductPage.updateAnotherTax();
        validateHelpers.waitAfterChoseOrClickElement();
        updateProductPage.clickOnSaveButton();
        validateHelpers.waitForLoadJs();
        updateProductPage.verifyAfterUpdate_success();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void updateAddAnotherProduct_then_updateSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        validateHelpers.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        updateProductPage.goToProductTable();
        validateHelpers.waitForLoadJs();
        updateProductPage.selectProductToUpdate();
        validateHelpers.waitForLoadJsLoginPage();
        updateProductPage.addAnotherPrice();
        validateHelpers.waitAfterChoseOrClickElement();
        updateProductPage.updatePriceOfAnotherPrice();
        validateHelpers.waitAfterChoseOrClickElement();
        updateProductPage.clickOnSaveButton();
        validateHelpers.waitForLoadJs();
        updateProductPage.verifyAfterUpdate_success();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void updateUseProductNameAlreadyExist_then_updateFailed(@Optional("English") String language) {
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        validateHelpers.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        updateProductPage.goToProductTable();
        validateHelpers.waitForLoadJs();
        updateProductPage.getProductNameExist();
        validateHelpers.waitAfterChoseOrClickElement();
        updateProductPage.selectProductToUpdate();
        validateHelpers.waitForLoadJsLoginPage();
        updateProductPage.updateProductNameExist();
        validateHelpers.waitAfterChoseOrClickElement();
        updateProductPage.clickOnSaveButton();
        validateHelpers.waitForLoadJs();
        updateProductPage.verifyAfterUpdate_Failed();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }
}
