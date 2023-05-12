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
    private CreateCompanyPage createCompanyPage;

    @BeforeClass
    public void beforeClass() {
        this.driver = getDriver();
        signInPage = new SignInPage(driver);
        signInPage.verifylanguage(PropertiesHelper.getLanguageToTest());
        createCompanyPage = signInPage.signinWithCreateCompany(PropertiesHelper.getValue("notCompanyEmail"), PropertiesHelper.getValue("password"));
    }

    @Test(priority = 1, description = "Check a create company page")
    public void verifyWithAccountNotCompany() throws Exception {
        createCompanyPage.verifylanguage(PropertiesHelper.getLanguageToTest());
        createCompanyPage.waitForPageLoaded();
        createCompanyPage.verifyTextOfStep(
                TranslationHelpers.setFile(PropertiesHelper.getLanguageToTest(), "$.company.createPage.text.newCompany"),
                TranslationHelpers.setFile(PropertiesHelper.getLanguageToTest(), "$.company.createPage.text.enterCompanyInformation"),
                TranslationHelpers.setFile(PropertiesHelper.getLanguageToTest(), "$.company.createPage.text.createABusiness")
        );
        createCompanyPage.verifyTextOfCreateSection(
                TranslationHelpers.setFile(PropertiesHelper.getLanguageToTest(), "$.company.createPage.text.legalCompany"),
                TranslationHelpers.setFile(PropertiesHelper.getLanguageToTest(), "$.company.createPage.text.legalCompanyDescription"),
                TranslationHelpers.setFile(PropertiesHelper.getLanguageToTest(), "$.company.createPage.button.registerLegalCompany"),
                TranslationHelpers.setFile(PropertiesHelper.getLanguageToTest(), "$.company.createPage.text.testCompany"),
                TranslationHelpers.setFile(PropertiesHelper.getLanguageToTest(), "$.company.createPage.text.testCompanyDescription"),
                TranslationHelpers.setFile(PropertiesHelper.getLanguageToTest(), "$.company.createPage.button.registerTestCompany")
        );
    }

    @Test(priority = 2)
    public void verifyCreateRealcompany() {
        createCompanyPage.verifylanguage(PropertiesHelper.getLanguageToTest());
        createCompanyPage.waitForPageLoaded();
        createCompanyPage.goToCreatecRealCompanyPage();
        createCompanyPage.verifyTextofheaderPage(
                TranslationHelpers.setFile(PropertiesHelper.getLanguageToTest(), "$.header.breadcrumb.companies"),
                TranslationHelpers.setFile(PropertiesHelper.getLanguageToTest(), "$.company.createPage.text.legalCompanyTitle"),
                TranslationHelpers.setFile(PropertiesHelper.getLanguageToTest(), "$.company.createPage.text.description")
        );
        createCompanyPage.verifyTextofCompanySection(
                TranslationHelpers.setFile(PropertiesHelper.getLanguageToTest(),"$.company.editViewPage.tabBankAccount.title"),
                TranslationHelpers.setFile(PropertiesHelper.getLanguageToTest(),"$.company.createPage.inputField.organisationNumber"),
                TranslationHelpers.setFile(PropertiesHelper.getLanguageToTest(),"$.company.createPage.inputField.organNoWarning"),
                TranslationHelpers.setFile(PropertiesHelper.getLanguageToTest(),"$.company.createPage.inputField.companyName"),
                TranslationHelpers.setFile(PropertiesHelper.getLanguageToTest(),"$.company.createPage.inputField.mainCurrency"),
                TranslationHelpers.setFile(PropertiesHelper.getLanguageToTest(),"$.company.createPage.inputField.mainCurrencyWarning"),
                TranslationHelpers.setFile(PropertiesHelper.getLanguageToTest(),"$.company.createPage.inputField.establishDate"));
        createCompanyPage.verifyFieldIsRequiredAndErrorMessage(
                TranslationHelpers.setFile(PropertiesHelper.getLanguageToTest(),"$.company.createPage.error.organisationNumberRequired"),
                TranslationHelpers.setFile(PropertiesHelper.getLanguageToTest(),"$.company.createPage.error.companyNameRequired"),
                TranslationHelpers.setFile(PropertiesHelper.getLanguageToTest(),"$.company.createPage.error.mainCurrencyRequired")
        );
        createCompanyPage.verifyTextAndFormatDateOfEstablished(TranslationHelpers.setFile(PropertiesHelper.getLanguageToTest(),"$.company.createPage.error.establishDateInvalid"));
        createCompanyPage.verifyTextOfContactSection();
    }
}
