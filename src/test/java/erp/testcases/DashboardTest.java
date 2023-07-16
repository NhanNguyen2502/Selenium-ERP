package erp.testcases;

import erp.base.BaseSetup;
import erp.common.helpers.PropertiesHelper;
import erp.common.helpers.TranslationHelpers;
import erp.common.helpers.ValidateHelpers;
import erp.pages.CompanyListPage;
import erp.pages.DashBoardPage;
import erp.pages.SignInPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TransferQueue;

public class DashboardTest extends BaseSetup {
    private DashBoardPage dashBoardPage;
    private WebDriver driver;
    private ValidateHelpers validateHelpers;
    private SignInPage signInPage;
    private CompanyListPage companyListPage;

    @BeforeClass
    public void setUp() {
        this.driver = getDriver();
        validateHelpers = new ValidateHelpers(driver);
        signInPage = new SignInPage(driver);
    }

    @Test
    public void verifyDemocompany() {
        signInPage.waitForPageLoaded();
        signInPage.verifylanguage(PropertiesHelper.getLanguageToTest());
        companyListPage = signInPage.login(PropertiesHelper.getValue("email"),PropertiesHelper.getValue("password"));
        dashBoardPage = companyListPage.goToCompany(TranslationHelpers.setFile(PropertiesHelper.getLanguageToTest(),"$.company.listPage.text.demo"));
        dashBoardPage.verifyLeftMenu(
                TranslationHelpers.setFile(PropertiesHelper.getLanguageToTest(),"$.sidebar.sidebarItem.dashboard"),
                TranslationHelpers.setFile(PropertiesHelper.getLanguageToTest(),"$.sidebar.sidebarItem.sales"),
                TranslationHelpers.setFile(PropertiesHelper.getLanguageToTest(),"$.sidebar.sidebarItem.contacts"),
                TranslationHelpers.setFile(PropertiesHelper.getLanguageToTest(),"$.sidebar.sidebarItem.products"),
                TranslationHelpers.setFile(PropertiesHelper.getLanguageToTest(),"$.sidebar.sidebarItem.fees"),
                TranslationHelpers.setFile(PropertiesHelper.getLanguageToTest(),"$.sidebar.sidebarItem.employees"),
                TranslationHelpers.setFile(PropertiesHelper.getLanguageToTest(),"$.sidebar.sidebarItem.companySetting"));
        dashBoardPage.verifyChartSection();
        validateHelpers.logout();
    }
    @Test
    public void verifyRealcompany() throws InterruptedException {
        signInPage.waitForPageLoaded();
        signInPage.verifylanguage(PropertiesHelper.getLanguageToTest());
        companyListPage = signInPage.login(PropertiesHelper.getValue("email"),PropertiesHelper.getValue("password"));
        companyListPage.verifylanguage(PropertiesHelper.getLanguageToTest());
        Thread.sleep(1000);
        dashBoardPage = companyListPage.goToCompany(TranslationHelpers.setFile(PropertiesHelper.getLanguageToTest(),"$.company.listPage.text.real"));
        dashBoardPage.waiForLoadingPage();
        dashBoardPage.verifyLeftMenu(
                TranslationHelpers.setFile(PropertiesHelper.getLanguageToTest(),"$.sidebar.sidebarItem.dashboard"),
                TranslationHelpers.setFile(PropertiesHelper.getLanguageToTest(),"$.sidebar.sidebarItem.sales"),
                TranslationHelpers.setFile(PropertiesHelper.getLanguageToTest(),"$.sidebar.sidebarItem.customers"),
                TranslationHelpers.setFile(PropertiesHelper.getLanguageToTest(),"$.sidebar.sidebarItem.products"),
                TranslationHelpers.setFile(PropertiesHelper.getLanguageToTest(),"$.sidebar.sidebarItem.fees"),
                TranslationHelpers.setFile(PropertiesHelper.getLanguageToTest(),"$.sidebar.sidebarItem.employees"),
                TranslationHelpers.setFile(PropertiesHelper.getLanguageToTest(),"$.sidebar.sidebarItem.companySetting"));
        dashBoardPage.verifyChartSection();
        validateHelpers.logout();
    }
}
