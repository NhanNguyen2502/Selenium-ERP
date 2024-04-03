package erp.testcases.UpdateFee.RealCompany;

import erp.base.BaseSetup;
import erp.base.ReportListener;
import erp.common.helpers.GetTypeOfCompanyHelper;
import erp.common.helpers.PropertiesHelper;
import erp.common.helpers.ValidateHelpers;
import erp.pages.CompanyListPage;
import erp.pages.FeePage.FeeTable;
import erp.pages.FeePage.UpdateFeePage;
import erp.pages.SignInPage;
import org.openqa.selenium.WebDriver;
import org.python.antlr.ast.Str;
import org.testng.annotations.*;

@Listeners(ReportListener.class)
public class UpdateFeeTest extends BaseSetup {
    private WebDriver driver;
    private ValidateHelpers validateHelpers;
    private SignInPage signInPage;
    private CompanyListPage companyListPage;
    private UpdateFeePage updateFeePage;
    private FeeTable feeTable;

    @BeforeClass
    public void setup() {
        this.driver = getDriver();
        validateHelpers = new ValidateHelpers(driver);
        signInPage = new SignInPage(driver);
        companyListPage = new CompanyListPage(driver);
        updateFeePage = new UpdateFeePage(driver);
        feeTable = new FeeTable(driver);
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void updateFeeName_then_updateSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        validateHelpers.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        updateFeePage.goToFeeTable();
        validateHelpers.waitForLoadJs();
        updateFeePage.selectFeeToUpdate();
        validateHelpers.waitForLoadJsCreatePage();
        updateFeePage.updateFeeName();
        validateHelpers.waitAfterChoseOrClickElement();
        updateFeePage.clickOnSaveButon();
        validateHelpers.waitForLoadJs();
        updateFeePage.verifyUpdateSuccess();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void updateMainPriceOfFee_then_updateSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        validateHelpers.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        updateFeePage.goToFeeTable();
        validateHelpers.waitForLoadJs();
        updateFeePage.selectFeeToUpdate();
        validateHelpers.waitForLoadJsCreatePage();
        updateFeePage.updateMainPriceOfFee();
        validateHelpers.waitAfterChoseOrClickElement();
        updateFeePage.clickOnSaveButon();
        validateHelpers.waitForLoadJs();
        updateFeePage.verifyUpdateSuccess();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void updateMainPriceAndName_then_updateSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        validateHelpers.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        updateFeePage.goToFeeTable();
        validateHelpers.waitForLoadJs();
        updateFeePage.selectFeeToUpdate();
        validateHelpers.waitForLoadJsCreatePage();
        updateFeePage.updateFeeName();
        validateHelpers.waitAfterChoseOrClickElement();
        updateFeePage.updateMainPriceOfFee();
        validateHelpers.waitAfterChoseOrClickElement();
        updateFeePage.clickOnSaveButon();
        validateHelpers.waitForLoadJs();
        updateFeePage.verifyUpdateSuccess();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void updateAddOtherPrice_then_updateSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        validateHelpers.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        updateFeePage.goToFeeTable();
        validateHelpers.waitForLoadJs();
        updateFeePage.selectFeeToUpdate();
        validateHelpers.waitForLoadJsCreatePage();
        updateFeePage.addOtherPrice();
        validateHelpers.waitAfterChoseOrClickElement();
        updateFeePage.addPriceOfOtherPrice();
        validateHelpers.waitAfterChoseOrClickElement();
        updateFeePage.clickOnSaveButon();
        validateHelpers.waitForLoadJs();
        updateFeePage.verifyUpdateSuccess();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void updateAllPrice_then_updateSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        validateHelpers.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        updateFeePage.goToFeeTable();
        validateHelpers.waitForLoadJs();
        updateFeePage.selectFeeToUpdate();
        validateHelpers.waitForLoadJsCreatePage();
        updateFeePage.updateAllPrices();
        validateHelpers.waitAfterChoseOrClickElement();
        updateFeePage.clickOnSaveButon();
        validateHelpers.waitForLoadJs();
        updateFeePage.verifyUpdateSuccess();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void updateConfirmDisableFee_then_updateSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        validateHelpers.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        updateFeePage.goToFeeTable();
        validateHelpers.waitForLoadJs();
        feeTable.filterEnable();
        validateHelpers.waitForLoadJs();
        updateFeePage.selectFeeToUpdate();
        validateHelpers.waitForLoadJsCreatePage();
        updateFeePage.disableFee();
        validateHelpers.waitAfterChoseOrClickElement();
        updateFeePage.confirmDisableFee();
        validateHelpers.waitAfterChoseOrClickElement();
        updateFeePage.clickOnSaveButon();
        validateHelpers.waitForLoadJs();
        updateFeePage.verifyUpdateSuccess();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void updateCancelDisableFee_then_updateSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        validateHelpers.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        updateFeePage.goToFeeTable();
        validateHelpers.waitForLoadJs();
        feeTable.filterEnable();
        validateHelpers.waitForLoadJs();
        updateFeePage.selectFeeToUpdate();
        validateHelpers.waitForLoadJsCreatePage();
        updateFeePage.disableFee();
        validateHelpers.waitAfterChoseOrClickElement();
        updateFeePage.cancelDisableFee();
        validateHelpers.waitAfterChoseOrClickElement();
        updateFeePage.clickOnSaveButon();
        validateHelpers.waitForLoadJs();
        updateFeePage.verifyUpdateSuccess();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

    @Test(priority = 2)
    @Parameters({"language"})
    public void updateConfirmEnableFee_then_updateSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        validateHelpers.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        updateFeePage.goToFeeTable();
        validateHelpers.waitForLoadJs();
        feeTable.filterDisabled();
        validateHelpers.waitForLoadJs();
        updateFeePage.selectFeeToUpdate();
        validateHelpers.waitForLoadJsCreatePage();
        updateFeePage.enableFee();
        validateHelpers.waitAfterChoseOrClickElement();
        updateFeePage.confirmEnableFee();
        validateHelpers.waitAfterChoseOrClickElement();
        updateFeePage.clickOnSaveButon();
        validateHelpers.waitForLoadJs();
        updateFeePage.verifyUpdateSuccess();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

    @Test(priority = 2)
    @Parameters({"language"})
    public void updateCancelEnableFee_then_updateSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        validateHelpers.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        updateFeePage.goToFeeTable();
        validateHelpers.waitForLoadJs();
        feeTable.filterDisabled();
        validateHelpers.waitForLoadJs();
        updateFeePage.selectFeeToUpdate();
        validateHelpers.waitForLoadJsCreatePage();
        updateFeePage.enableFee();
        validateHelpers.waitAfterChoseOrClickElement();
        updateFeePage.cancelEnableFee();
        validateHelpers.waitAfterChoseOrClickElement();
        updateFeePage.clickOnSaveButon();
        validateHelpers.waitForLoadJs();
        updateFeePage.verifyUpdateSuccess();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }

    @Test(priority = 0)
    @Parameters({"language"})
    public void updateConfirmDeleteFee_then_deleteSuccess(@Optional("English") String language) {
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        validateHelpers.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        updateFeePage.goToFeeTable();
        validateHelpers.waitForLoadJs();
        updateFeePage.selectFeeToUpdate();
        validateHelpers.waitForLoadJsCreatePage();
        updateFeePage.deleteFee();
        validateHelpers.waitAfterChoseOrClickElement();
        updateFeePage.confirmDelete();
        validateHelpers.waitForLoadJs();
        updateFeePage.verifyDeleteSuccess();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }
    @Test(priority = 0)
    @Parameters({"language"})
    public void updateCancelDeleteFee_then_deleteFail(@Optional("English") String language) {
        validateHelpers.waitForLoadJsLoginPage();
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        validateHelpers.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        updateFeePage.goToFeeTable();
        validateHelpers.waitForLoadJs();
        updateFeePage.selectFeeToUpdate();
        validateHelpers.waitForLoadJsCreatePage();
        updateFeePage.deleteFee();
        validateHelpers.waitAfterChoseOrClickElement();
        updateFeePage.cancelDelete();
        validateHelpers.waitForLoadJs();
        updateFeePage.verifyDeleteFailed();
        validateHelpers.waitAfterChoseOrClickElement();
        validateHelpers.logout();
    }
}
