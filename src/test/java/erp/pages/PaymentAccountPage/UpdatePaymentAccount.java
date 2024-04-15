package erp.pages.PaymentAccountPage;

import erp.common.helpers.AttachmentDocumentHelper;
import erp.common.helpers.GetTypeOfCompanyHelper;
import erp.common.helpers.PropertiesHelper;
import erp.common.helpers.ValidateHelpers;
import erp.pages.CompanyListPage;
import erp.pages.ProductPage.CreateProductPage;
import erp.pages.SignInPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.text.DecimalFormat;
import java.util.Random;

public class UpdatePaymentAccount {
    private WebDriver driver;
    private ValidateHelpers validateHelpers;
    private CreatePaymentAccount createPaymentAccount;
    private Random random;
    private DecimalFormat decimalFormat;
    private SignInPage signInPage;
    private CompanyListPage companyListPage;
    private PaymentTable paymentTable;
    private String _paymentUpdate;

    public UpdatePaymentAccount(WebDriver driver) {
        this.driver = driver;
        validateHelpers = new ValidateHelpers(driver);
        createPaymentAccount = new CreatePaymentAccount(driver);
        random = new Random();
        decimalFormat = new DecimalFormat();
        signInPage = new SignInPage(driver);
        companyListPage = new CompanyListPage(driver);
        paymentTable = new PaymentTable(driver);
    }

    private By paymentAccountNameList = By.xpath("//span[@data-cy='account-name-data']");

    public void loginAndGoToPaymentAccountTable(String language) {
        signInPage.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        signInPage.login(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
        validateHelpers.waitForLoadJsLoginPage();
        validateHelpers.verifylanguage(language);
        validateHelpers.waitForLoadJs();
        companyListPage.goToCompany(GetTypeOfCompanyHelper.getTypeOfRealCompany(language));
        validateHelpers.waitForLoadJs();
        createPaymentAccount.goToPaymentTable();
        validateHelpers.waitForLoadJs();
    }

    public void selectRandomPaymentAccountToUpdate()
    {
        var _paymentAccountList = validateHelpers.getList(paymentAccountNameList);
        var _ran = random.nextInt(0,_paymentAccountList.size());
        if(_paymentAccountList.isEmpty())
        {
            createPaymentAccount.goToCreatePaymentAccountPage();
            validateHelpers.waitForLoadJsCreatePage();
            createPaymentAccount.enterPaymentName();
            validateHelpers.waitAfterChoseOrClickElement();
            createPaymentAccount.enterAccountNumber();
            validateHelpers.waitAfterChoseOrClickElement();
            createPaymentAccount.clickOnCreateButton();
            validateHelpers.waitForLoadJs();
            _paymentAccountList = validateHelpers.getList(paymentAccountNameList);
            _ran = random.nextInt(0,_paymentAccountList.size());
        }
        _paymentUpdate = _paymentAccountList.get(_ran).getText();
        _paymentAccountList.get(_ran).click();
        System.out.println("Product has been selected: " + _paymentUpdate);

    }

}
