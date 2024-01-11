package erp.testcases;

import erp.base.BaseSetup;
import erp.common.helpers.PropertiesHelper;
import erp.common.helpers.TranslationHelpers;
import erp.common.helpers.ValidateHelpers;
import erp.pages.CreateCompanyPage;
import erp.pages.CreateDemoCompanyPage;
import erp.pages.CreateRealCompanyPage;
import erp.pages.SignInPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CreateCompanyTest extends BaseSetup {
    private WebDriver driver;
    private SignInPage signInPage;
    private CreateCompanyPage createCompanyPage;
    private CreateDemoCompanyPage createDemoCompanyPage;
    private CreateRealCompanyPage createRealCompanyPage;
    private ValidateHelpers validateHelpers;

    @BeforeClass
    public void beforeClass() {
        this.driver = getDriver();
        signInPage = new SignInPage(driver);
        validateHelpers = new ValidateHelpers(driver);

    }

    @Test(priority = 1, description = "Check a create company page")
    @Parameters({"language"})
    public void verifyWithAccountNotCompany(@Optional("English") String language) throws Exception {
        validateHelpers.waitForLoadJs();
        signInPage.verifylanguage(language);
        createCompanyPage = signInPage.signinWithCreateCompany(PropertiesHelper.getValue("notCompanyEmail"), PropertiesHelper.getValue("password"));
        validateHelpers.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        createCompanyPage.goToCreateCompany();
        createCompanyPage.verifyTextOfStep(
                TranslationHelpers.setFile(language, "$.company.createPage.text.newCompany"),
                TranslationHelpers.setFile(language, "$.company.createPage.text.enterCompanyInformation"),
                TranslationHelpers.setFile(language, "$.company.createPage.text.createABusiness")
        );
        createCompanyPage.verifyTextOfCreateSection(
                TranslationHelpers.setFile(language, "$.company.createPage.text.legalCompany"),
                TranslationHelpers.setFile(language, "$.company.createPage.text.legalCompanyDescription"),
                TranslationHelpers.setFile(language, "$.company.createPage.button.registerLegalCompany"),
                TranslationHelpers.setFile(language, "$.company.createPage.text.testCompany"),
                TranslationHelpers.setFile(language, "$.company.createPage.text.testCompanyDescription"),
                TranslationHelpers.setFile(language, "$.company.createPage.button.registerTestCompany")
        );
        validateHelpers.logout();
    }

    @Test(priority = 2)
    @Parameters({"language"})
    public void verifyTextCreateRealcompany(@Optional("English") String language) throws Exception {
        validateHelpers.waitForLoadJs();
        signInPage.verifylanguage(language);
        createCompanyPage = signInPage.signinWithCreateCompany(PropertiesHelper.getValue("notCompanyEmail"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        validateHelpers.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        createCompanyPage.goToCreateCompany();
        createRealCompanyPage = createCompanyPage.goToCreatecRealCompanyPage();
        createRealCompanyPage.verifyTextofheaderPage(
                TranslationHelpers.setFile(language, "$.header.breadcrumb.companies"),
                TranslationHelpers.setFile(language, "$.company.createPage.text.legalCompanyTitle"),
                TranslationHelpers.setFile(language, "$.company.createPage.text.description")
        );
        createRealCompanyPage.verifyTextofCompanySection(
                TranslationHelpers.setFile(language, "$.company.editViewPage.tabBankAccount.title"),
                TranslationHelpers.setFile(language, "$.company.createPage.inputField.organisationNumber"),
                TranslationHelpers.setFile(language, "$.company.createPage.inputField.organNoWarning"),
                TranslationHelpers.setFile(language, "$.company.createPage.inputField.companyName"),
                TranslationHelpers.setFile(language, "$.company.createPage.inputField.mainCurrency"),
                TranslationHelpers.setFile(language, "$.company.createPage.inputField.mainCurrencyWarning"),
                TranslationHelpers.setFile(language, "$.company.createPage.inputField.establishDate"));
        createRealCompanyPage.verifyFieldIsRequiredAndErrorMessage(
                TranslationHelpers.setFile(language, "$.company.createPage.error.organisationNumberRequired"),
                TranslationHelpers.setFile(language, "$.company.createPage.error.companyNameRequired"),
                TranslationHelpers.setFile(language, "$.company.createPage.error.mainCurrencyRequired")
        );
        createRealCompanyPage.verifyTextAndFormatDateOfEstablished(TranslationHelpers.setFile(language, "$.company.createPage.error.establishDateInvalid"));
        createRealCompanyPage.verifyTextOfContactSection(
                TranslationHelpers.setFile(language, "$.company.createPage.text.contactInfo"),
                TranslationHelpers.setFile(language, "$.company.createPage.inputField.email"),
                TranslationHelpers.setFile(language, "$.company.createPage.inputField.companyPhoneNumbers"),
                TranslationHelpers.setFile(language, "$.company.createPage.inputField.website"),
                TranslationHelpers.setFile(language, "$.company.createPage.inputField.address"),
                TranslationHelpers.setFile(language, "$.company.createPage.inputField.firstStreetAddress"),
                TranslationHelpers.setFile(language, "$.company.createPage.inputField.secondStreetAddress"),
                TranslationHelpers.setFile(language, "$.company.createPage.inputField.thirdStreetAddress"),
                TranslationHelpers.setFile(language, "$.company.createPage.inputField.country"),
                TranslationHelpers.setFile(language, "$.company.createPage.inputField.zipcode"),
                TranslationHelpers.setFile(language, "$.company.createPage.inputField.city"),
                TranslationHelpers.setFile(language, "$.company.createPage.inputField.timezone")
        );
        createCompanyPage.leaveFormcreate();
        validateHelpers.logout();
    }

    @Test(priority = 3)
    @Parameters({"language"})
    public void verifyTextCreateDmoCompanyForm(@Optional("English") String language) {
        validateHelpers.waitForLoadJs();
        signInPage.verifylanguage(language);
        createCompanyPage = signInPage.signinWithCreateCompany(PropertiesHelper.getValue("notCompanyEmail"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJs();
        validateHelpers.verifylanguage(language);
        createCompanyPage.goToCreateCompany();
        validateHelpers.waitForLoadJs();
        createDemoCompanyPage = createCompanyPage.goToCreateDemoCompanyForm();
        createDemoCompanyPage.waitForPageLoaded();
        createDemoCompanyPage.verifyTextofheaderPage(
                TranslationHelpers.setFile(language, "$.header.breadcrumb.companies"),
                TranslationHelpers.setFile(language, "$.company.createPage.text.testCompanyTitle"),
                TranslationHelpers.setFile(language, "$.company.createPage.text.description") +" "+
                        TranslationHelpers.setFile(language, "$.company.createPage.text.generateText"));
        createDemoCompanyPage.verifyFieldIsRequiredAndErrorMessage(TranslationHelpers.setFile(language,
                "$.company.createPage.error.mainCurrencyRequired"));
        createDemoCompanyPage.verifyTextOfContactSection(
                TranslationHelpers.setFile(language, "$.company.createPage.text.contactInfo"),
                TranslationHelpers.setFile(language, "$.company.createPage.inputField.email"),
                TranslationHelpers.setFile(language, "$.company.createPage.inputField.companyPhoneNumbers"),
                TranslationHelpers.setFile(language, "$.company.createPage.inputField.website"),
                TranslationHelpers.setFile(language, "$.company.createPage.inputField.address"),
                TranslationHelpers.setFile(language, "$.company.createPage.inputField.firstStreetAddress"),
                TranslationHelpers.setFile(language, "$.company.createPage.inputField.secondStreetAddress"),
                TranslationHelpers.setFile(language, "$.company.createPage.inputField.thirdStreetAddress"),
                TranslationHelpers.setFile(language, "$.company.createPage.inputField.country"),
                TranslationHelpers.setFile(language, "$.company.createPage.inputField.zipcode"),
                TranslationHelpers.setFile(language, "$.company.createPage.inputField.city"),
                TranslationHelpers.setFile(language, "$.company.createPage.inputField.timezone")
        );
        createCompanyPage.leaveFormcreate();
        validateHelpers.logout();
    }

}
