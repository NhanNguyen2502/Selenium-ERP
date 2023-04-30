package erp.testcases;

import erp.base.BaseSetup;
import erp.common.helpers.Helper;
import erp.common.helpers.PropertiesHelper;
import erp.common.helpers.TranslationHelpers;
import erp.common.helpers.ValidateHelpers;
import erp.pages.CreateCompanyPage;
import erp.pages.SignInPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateCompanyTest extends BaseSetup {
    private WebDriver driver;
    private SignInPage signInPage;
    private Helper helper;
    private CreateCompanyPage createCompanyPage;

    @BeforeClass
    public void beforeClass() {
        this.driver = getDriver();
        signInPage = new SignInPage(driver);
        helper = new Helper(driver);
        signInPage.verifylanguage(PropertiesHelper.getLanguageToTest());
    }

    @Test(priority = 1 , description = "Check a create company page ")
    public void verifyWithAccountNotCompany() throws Exception {
        createCompanyPage = signInPage.signinWithCreateCompany(PropertiesHelper.getValue("notCompanyEmail"), PropertiesHelper.getValue("password"));
        createCompanyPage.waitForPageLoaded();
        createCompanyPage.verifylanguage(PropertiesHelper.getLanguageToTest());
        createCompanyPage.verifyTextOfStep(
                TranslationHelpers.setFile(PropertiesHelper.getLanguageToTest(), "$.company.createPage.text.newCompany"),
                TranslationHelpers.setFile(PropertiesHelper.getLanguageToTest(), "$.company.createPage.text.enterCompanyInformation"),
                TranslationHelpers.setFile(PropertiesHelper.getLanguageToTest(), "$.company.createPage.text.createABusiness")
        );
        createCompanyPage.verifyTextOfCreateSection(
                TranslationHelpers.setFile(PropertiesHelper.getLanguageToTest(),"$.company.createPage.text.legalCompany"),
                TranslationHelpers.setFile(PropertiesHelper.getLanguageToTest(),"$.company.createPage.text.legalCompanyDescription"),
                TranslationHelpers.setFile(PropertiesHelper.getLanguageToTest(),"$.company.createPage.button.registerLegalCompany"),
                TranslationHelpers.setFile(PropertiesHelper.getLanguageToTest(),"$.company.createPage.text.testCompany"),
                TranslationHelpers.setFile(PropertiesHelper.getLanguageToTest(),"$.company.createPage.text.testCompanyDescription"),
                TranslationHelpers.setFile(PropertiesHelper.getLanguageToTest(),"$.company.createPage.button.registerTestCompany")
        );
    }
}
