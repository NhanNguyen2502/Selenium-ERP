package erp.testcases.CreateProductPage.RealCompany;

import erp.base.BaseSetup;
import erp.base.ReportListener;
import erp.common.helpers.GetTypeOfCompanyHelper;
import erp.common.helpers.PropertiesHelper;
import erp.common.helpers.ValidateHelpers;
import erp.pages.CompanyListPage;
import erp.pages.CreateProductPage;
import erp.pages.SignInPage;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

@Listeners(ReportListener.class)
public class CreateProductTest extends BaseSetup {
    private WebDriver driver;
    private CreateProductPage createProductPage;
    private ValidateHelpers validateHelpers;
    private SignInPage signInPage;
    private CompanyListPage companyListPage;

    @BeforeClass
    public void setUp() {
        this.driver = getDriver();
        createProductPage = new CreateProductPage(driver);
        validateHelpers = new ValidateHelpers(driver);
        signInPage = new SignInPage(driver);
        companyListPage = new CompanyListPage(driver);
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void createProductWithConfirmUploadImage_then_CreateSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        createProductPage.goToProductTable();
        validateHelpers.waitForLoadJs();
        createProductPage.goToCreateProductPage();
        validateHelpers.waitForLoadJs();
        createProductPage.uploadProductImage();
        validateHelpers.waitAfterChoseOrClickElement();
        createProductPage.confirmUploadProductImage();
        validateHelpers.waitAfterChoseOrClickElement();
        createProductPage.enterProductName();
        validateHelpers.waitAfterChoseOrClickElement();
        createProductPage.clickOnCreateButton();
        validateHelpers.waitForLoadJs();
        createProductPage.verifyAfterCreate_success();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void createProductWithCancelUploadImage_then_CreateSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        createProductPage.goToProductTable();
        validateHelpers.waitForLoadJs();
        createProductPage.goToCreateProductPage();
        validateHelpers.waitForLoadJs();
        createProductPage.uploadProductImage();
        validateHelpers.waitAfterChoseOrClickElement();
        createProductPage.cancelUploadProductImage();
        validateHelpers.waitAfterChoseOrClickElement();
        createProductPage.enterProductName();
        validateHelpers.waitAfterChoseOrClickElement();
        createProductPage.clickOnCreateButton();
        validateHelpers.waitForLoadJs();
        createProductPage.verifyAfterCreate_success();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void createProductWithTypeService_then_CreateSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        createProductPage.goToProductTable();
        validateHelpers.waitForLoadJs();
        createProductPage.goToCreateProductPage();
        validateHelpers.waitForLoadJs();
        createProductPage.enterProductName();
        validateHelpers.waitAfterChoseOrClickElement();
        createProductPage.selectProductService();
        validateHelpers.waitAfterChoseOrClickElement();
        createProductPage.clickOnCreateButton();
        validateHelpers.waitForLoadJs();
        createProductPage.verifyAfterCreate_success();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void createProductWithAmount_then_CreateSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        createProductPage.goToProductTable();
        validateHelpers.waitForLoadJs();
        createProductPage.goToCreateProductPage();
        validateHelpers.waitForLoadJs();
        createProductPage.enterProductName();
        validateHelpers.waitAfterChoseOrClickElement();
        createProductPage.selectProductService();
        validateHelpers.waitAfterChoseOrClickElement();
        createProductPage.enterProductPrice();
        validateHelpers.waitAfterChoseOrClickElement();
        createProductPage.clickOnCreateButton();
        validateHelpers.waitForLoadJs();
        createProductPage.verifyAfterCreate_success();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void createProductWithTypeServiceAndTax_then_CreateSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        createProductPage.goToProductTable();
        validateHelpers.waitForLoadJs();
        createProductPage.goToCreateProductPage();
        validateHelpers.waitForLoadJs();
        createProductPage.enterProductName();
        validateHelpers.waitAfterChoseOrClickElement();
        createProductPage.selectProductService();
        validateHelpers.waitAfterChoseOrClickElement();
        createProductPage.enterProductPrice();
        validateHelpers.waitAfterChoseOrClickElement();
        createProductPage.selectTax();
        validateHelpers.waitAfterChoseOrClickElement();
        createProductPage.clickOnCreateButton();
        validateHelpers.waitForLoadJs();
        createProductPage.verifyAfterCreate_success();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void createProductWithTypeItemAndTax_then_CreateSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        createProductPage.goToProductTable();
        validateHelpers.waitForLoadJs();
        createProductPage.goToCreateProductPage();
        validateHelpers.waitForLoadJs();
        createProductPage.enterProductName();
        validateHelpers.waitAfterChoseOrClickElement();
        createProductPage.enterProductPrice();
        validateHelpers.waitAfterChoseOrClickElement();
        createProductPage.selectTax();
        validateHelpers.waitAfterChoseOrClickElement();
        createProductPage.clickOnCreateButton();
        validateHelpers.waitForLoadJs();
        createProductPage.verifyAfterCreate_success();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void createProductWithTypeItemAndAnotherPrice_then_CreateSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        createProductPage.goToProductTable();
        validateHelpers.waitForLoadJs();
        createProductPage.goToCreateProductPage();
        validateHelpers.waitForLoadJs();
        createProductPage.enterProductName();
        validateHelpers.waitAfterChoseOrClickElement();
        createProductPage.addAnotherPrice();
        validateHelpers.waitAfterChoseOrClickElement();
        createProductPage.enterProductPrice();
        validateHelpers.waitAfterChoseOrClickElement();
        createProductPage.enterProductPriceToAnotherPrice();
        validateHelpers.waitAfterChoseOrClickElement();
        createProductPage.clickOnCreateButton();
        validateHelpers.waitForLoadJs();
        createProductPage.verifyAfterCreate_success();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }
    @Test(priority = 0)
    @Parameters({"language"})
    public void createProductWithProductNameNull_then_CreateFail(@Optional("English") String language) {
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        createProductPage.goToProductTable();
        validateHelpers.waitForLoadJs();
        createProductPage.goToCreateProductPage();
        validateHelpers.waitForLoadJsCreatePage();
        createProductPage.clickOnCreateButton();
        validateHelpers.waitAfterChoseOrClickElement();
        createProductPage.checkProductNameRequired();
        validateHelpers.waitAfterChoseOrClickElement();
        createProductPage.verifyAfterCreate_Failed();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void createProductWithProductNameExist_then_CreateFail(@Optional("English") String language) {
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        createProductPage.goToProductTable();
        validateHelpers.waitForLoadJsCreatePage();
        createProductPage.getProductNameExist();
        validateHelpers.waitAfterChoseOrClickElement();
        createProductPage.goToCreateProductPage();
        validateHelpers.waitForLoadJsCreatePage();
        createProductPage.enterProductNameExist();
        validateHelpers.waitAfterChoseOrClickElement();
        createProductPage.clickOnCreateButton();
        validateHelpers.waitAfterChoseOrClickElement();
        createProductPage.verifyAfterCreate_Failed();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

}
