package erp.testcases.Dashboard;

import erp.base.BaseSetup;
import erp.base.ReportListener;
import erp.common.helpers.PropertiesHelper;
import erp.common.helpers.TranslationHelpers;
import erp.common.helpers.ValidateHelpers;
import erp.pages.CompanyListPage;
import erp.pages.DashBoardPage;
import erp.pages.SignInPage;
import io.qameta.allure.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.ByteArrayInputStream;
import java.util.concurrent.TransferQueue;

@Listeners(ReportListener.class)

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
    @Parameters({"language"})
    public void verifyDemocompany(@Optional("English") String language) {
        driver.navigate().refresh();
        validateHelpers.waitForLoadJs();
        signInPage.verifylanguage(language);
        companyListPage = signInPage.login(PropertiesHelper.getValue("email"),PropertiesHelper.getValue("password"));
        validateHelpers.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        dashBoardPage = companyListPage.goToCompany(TranslationHelpers.setFile(language,"$.company.listPage.text.demo"));
        validateHelpers.waitForLoadJs();
        dashBoardPage.verifyLeftMenu(
                TranslationHelpers.setFile(language,"$.sidebar.sidebarItem.dashboard"),
                TranslationHelpers.setFile(language,"$.sidebar.sidebarItem.sales"),
                TranslationHelpers.setFile(language,"$.contact.listPage.text.customers"),
                TranslationHelpers.setFile(language,"$.sidebar.sidebarItem.products"),
                TranslationHelpers.setFile(language,"$.sidebar.sidebarItem.fees"),
                TranslationHelpers.setFile(language,"$.sidebar.sidebarItem.employees"),
                TranslationHelpers.setFile(language,"$.sidebar.sidebarItem.companySetting"));
        dashBoardPage.verifyChartSection();
        validateHelpers.logout();
    }
    @Test
    @Parameters({"language"})
    public void verifyRealcompany(@Optional("English") String language)  {
        signInPage.waitForPageLoaded();
        signInPage.verifylanguage(language);
        signInPage.waitForPageLoaded();
        companyListPage = signInPage.login(PropertiesHelper.getValue("email"),PropertiesHelper.getValue("password"));
        signInPage.waitForPageLoaded();
        validateHelpers.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        dashBoardPage = companyListPage.goToCompany(TranslationHelpers.setFile(language,"$.company.listPage.text.real"));
        validateHelpers.waitForLoadJs();
        dashBoardPage.verifyLeftMenu(
                TranslationHelpers.setFile(language,"$.sidebar.sidebarItem.dashboard"),
                TranslationHelpers.setFile(language,"$.sidebar.sidebarItem.sales"),
                TranslationHelpers.setFile(language,"$.sidebar.sidebarItem.customers"),
                TranslationHelpers.setFile(language,"$.sidebar.sidebarItem.products"),
                TranslationHelpers.setFile(language,"$.sidebar.sidebarItem.fees"),
                TranslationHelpers.setFile(language,"$.sidebar.sidebarItem.employees"),
                TranslationHelpers.setFile(language,"$.sidebar.sidebarItem.companySetting"));
        dashBoardPage.verifyChartSection();
        validateHelpers.logout();
    }
}
