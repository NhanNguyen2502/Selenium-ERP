package erp.testcases;

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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.util.concurrent.TransferQueue;

@Listeners(ReportListener.class)
//@Epic("Regression test ERP")
//@Feature("ERP")
@Epic("Sign In flow")
@Feature("Login form")
//@Story("User enters wrong password")
@Owner("Nhan Nguyen")
@Severity(SeverityLevel.CRITICAL)
public class DashboardTest extends BaseSetup {
    private DashBoardPage dashBoardPage;
    private WebDriver driver;
    private ValidateHelpers validateHelpers;
    private SignInPage signInPage;
    private CompanyListPage companyListPage;

    @BeforeClass
    @Description("Khoi tao Browser va cac class lien quan")
    public void setUp() {
        this.driver = getDriver();
        validateHelpers = new ValidateHelpers(driver);
        signInPage = new SignInPage(driver);

    }

    @Test
    public void verifyDemocompany() {
        validateHelpers.waitForLoadJs();
        signInPage.verifylanguage(PropertiesHelper.getLanguageToTest());
        companyListPage = signInPage.login(PropertiesHelper.getValue("email"),PropertiesHelper.getValue("password"));
        validateHelpers.verifylanguage(PropertiesHelper.getLanguageToTest());
        validateHelpers.waitForLoadJs();
        dashBoardPage = companyListPage.goToCompany(TranslationHelpers.setFile(PropertiesHelper.getLanguageToTest(),"$.company.listPage.text.demo"));
        validateHelpers.waitForLoadJs();
        dashBoardPage.verifyLeftMenu(
                TranslationHelpers.setFile(PropertiesHelper.getLanguageToTest(),"$.sidebar.sidebarItem.dashboard"),
                TranslationHelpers.setFile(PropertiesHelper.getLanguageToTest(),"$.sidebar.sidebarItem.sales"),
                TranslationHelpers.setFile(PropertiesHelper.getLanguageToTest(),"$.contact.listPage.text.customers"),
                TranslationHelpers.setFile(PropertiesHelper.getLanguageToTest(),"$.sidebar.sidebarItem.products"),
                TranslationHelpers.setFile(PropertiesHelper.getLanguageToTest(),"$.sidebar.sidebarItem.fees"),
                TranslationHelpers.setFile(PropertiesHelper.getLanguageToTest(),"$.sidebar.sidebarItem.employees"),
                TranslationHelpers.setFile(PropertiesHelper.getLanguageToTest(),"$.sidebar.sidebarItem.companySetting"));
        dashBoardPage.verifyChartSection();
        validateHelpers.logout();
    }
    @Test
    @Step("Login")
    public void verifyRealcompany()  {
        signInPage.waitForPageLoaded();
        signInPage.verifylanguage(PropertiesHelper.getLanguageToTest());
        companyListPage = signInPage.login(PropertiesHelper.getValue("email"),PropertiesHelper.getValue("passwordd"));
        validateHelpers.verifylanguage(PropertiesHelper.getLanguageToTest());
        validateHelpers.waitForLoadJs();
        dashBoardPage = companyListPage.goToCompany(TranslationHelpers.setFile(PropertiesHelper.getLanguageToTest(),"$.company.listPage.text.real"));
        validateHelpers.waitForLoadJs();
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
