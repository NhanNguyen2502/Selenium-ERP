package erp.testcases.CreateFees.RealCompany;

import erp.base.BaseSetup;
import erp.base.ReportListener;
import erp.common.helpers.GetTypeOfCompanyHelper;
import erp.common.helpers.PropertiesHelper;
import erp.common.helpers.ValidateHelpers;
import erp.pages.CompanyListPage;
import erp.pages.CreateFeePage;
import erp.pages.SignInPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

@Listeners(ReportListener.class)
public class CreateFeeTest extends BaseSetup {
    private WebDriver driver;
    private SignInPage signInPage;
    private ValidateHelpers validateHelpers;
    private CompanyListPage companyListPage;
    private CreateFeePage createFeePage;

    @BeforeClass
    public void setup() {
        this.driver = getDriver();
        signInPage = new SignInPage(driver);
        validateHelpers = new ValidateHelpers(driver);
        companyListPage = new CompanyListPage(driver);
        createFeePage = new CreateFeePage(driver);
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void createFeeWithOnlyName_then_createSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        createFeePage.goToCreateFeeTable();
        validateHelpers.waitForLoadJs();
        createFeePage.goToCreateFeePage();
        validateHelpers.waitForLoadJs();
        createFeePage.enterFeeName();
        validateHelpers.waitAfterChoseOrClickElement();
        createFeePage.clickOnCreateButon();
        validateHelpers.waitForLoadJs();
        createFeePage.verifyCreateSuccess();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void createFeeWithFeeNameNull_then_createFail(@Optional("English") String language) {
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        createFeePage.goToCreateFeeTable();
        validateHelpers.waitForLoadJs();
        createFeePage.goToCreateFeePage();
        validateHelpers.waitForLoadJs();
        createFeePage.clickOnCreateButon();
        validateHelpers.waitAfterChoseOrClickElement();
        createFeePage.checkNameRequied();
        validateHelpers.waitForLoadJs();
        createFeePage.verifyCreateFailed();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void createFeeWithFeePrice_then_createSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        createFeePage.goToCreateFeeTable();
        validateHelpers.waitForLoadJs();
        createFeePage.goToCreateFeePage();
        validateHelpers.waitForLoadJs();
        createFeePage.enterFeeName();
        validateHelpers.waitAfterChoseOrClickElement();
        createFeePage.enterFeePrice();
        validateHelpers.waitAfterChoseOrClickElement();
        createFeePage.clickOnCreateButon();
        validateHelpers.waitForLoadJs();
        createFeePage.verifyCreateSuccess();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void createFeeWithFeeNameExist_then_createFail(@Optional("English") String language) {
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        createFeePage.goToCreateFeeTable();
        validateHelpers.waitForLoadJs();
        createFeePage.getNameAlreadyExist();
        validateHelpers.waitAfterChoseOrClickElement();
        createFeePage.goToCreateFeePage();
        validateHelpers.waitForLoadJs();
        createFeePage.enterNameAlreadyExist();
        validateHelpers.waitAfterChoseOrClickElement();
        createFeePage.clickOnCreateButon();
        validateHelpers.waitAfterChoseOrClickElement();
        createFeePage.verifyCreateFailed();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void createFeeWithTax_then_createSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        createFeePage.goToCreateFeeTable();
        validateHelpers.waitForLoadJs();
        createFeePage.goToCreateFeePage();
        validateHelpers.waitForLoadJs();
        createFeePage.enterFeeName();
        validateHelpers.waitAfterChoseOrClickElement();
        createFeePage.enterFeePrice();
        validateHelpers.waitAfterChoseOrClickElement();
        createFeePage.selectTax();
        validateHelpers.waitAfterChoseOrClickElement();
        createFeePage.clickOnCreateButon();
        validateHelpers.waitAfterChoseOrClickElement();
        createFeePage.verifyCreateSuccess();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }
    @Test(priority = 0)
    @Ignore
    @Parameters({"language"})
    public void createFeeWithManyPrice_then_createSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        createFeePage.goToCreateFeeTable();
        validateHelpers.waitForLoadJs();
        createFeePage.goToCreateFeePage();
        validateHelpers.waitForLoadJs();
        createFeePage.enterFeeName();
        validateHelpers.waitAfterChoseOrClickElement();
        createFeePage.addManyPriceLineWithOtherCurrencies();
        validateHelpers.waitAfterChoseOrClickElement();
        createFeePage.addPriceToPriceLine();
        validateHelpers.waitAfterChoseOrClickElement();
        createFeePage.selectTax();
        validateHelpers.waitAfterChoseOrClickElement();
        createFeePage.clickOnCreateButon();
        validateHelpers.waitAfterChoseOrClickElement();
        createFeePage.verifyCreateSuccess();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }
}
