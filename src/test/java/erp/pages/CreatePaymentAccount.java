package erp.pages;

import erp.common.helpers.FakeDataHelper;
import erp.common.helpers.ValidateHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class CreatePaymentAccount {
    private WebDriver driver;
    private ValidateHelpers validateHelpers;
    private Random random;
    private DecimalFormat decimalFormat;
    private String _paymentName;
    private DateTimeFormatter date;
    private DateTimeFormatter month;
    private DateTimeFormatter year;

    public CreatePaymentAccount(WebDriver driver) {
        this.driver = driver;
        validateHelpers = new ValidateHelpers(driver);
        random = new Random();
        decimalFormat = new DecimalFormat();
        date = DateTimeFormatter.ofPattern("dd");
        month = DateTimeFormatter.ofPattern("MM");
        year = DateTimeFormatter.ofPattern("YYYY");

    }

    private By leftMenuLink = By.xpath("//a[@data-cy='sidebar-payment-accounts-link']");
    private By createPaymentButton = By.xpath("//button[@apptooltip='regularInvoice.button.createBankAccount']");
    private By paymentNameField = By.xpath("//input[@data-cy='bank-name-input']");
    private By paymentNameExist = By.xpath("//div[@data-cy='account-name-exists-error']");
    private By paymentTableTitle = By.xpath("//span[@data-cy='purchase-list-title']");
    private By createButton = By.xpath("//button[@data-cy='account-save-create-button']");
    private By accountNumber = By.xpath("//input[@data-cy='account-number-input']");
    private By accountNameRequired = By.xpath("//div[@data-cy='account-name-required']");
    private By accountNumberRequired = By.xpath("//div[@data-cy='account-number-required']");
    private By accountHolderRequired = By.xpath("//mat-error//div[@data-cy='account-account-holder-required']");
    private By accountHolderField = By.xpath("//input[@data-cy='bank-account-holder-input']");
    private By openingBalanceField = By.xpath("//input[@data-cy='opening-balance']");
    private By balanceDateRequired = By.xpath("//div[@data-cy='balance-date-required']");
    private By balanceDateField = By.xpath("//input[@data-cy='balance-date']");
    private By internationalField = By.xpath("(//mat-checkbox//label//span)[1]");
    private By ibanField = By.xpath("//input[@data-cy='bank-ibanNumber-input']");
    private By bicOrSwift = By.xpath("//input[@data-cy='swiftNumber-input']");
    private By bankTypeFiled = By.xpath("//input[@data-cy='language-select-input']");
    private By bankTypeList = By.xpath("//mat-option[@data-cy='language-select-option']");
    private By paymentServiceOption = By.xpath("//input[@data-placeholder='Select']");
    private By paymentServiceOptionList = By.xpath("//mat-option[@data-cy='language-select-option']");
    private By ibanWarning = By.xpath("//div[@data-cy='ibanNumber-pattern']");


    public void selectRandomPaymentServiceOption() {
        validateHelpers.clickElement(paymentServiceOption);
        var _options = validateHelpers.getList(paymentServiceOptionList);
        if (!_options.isEmpty()) {
            var _optionRandom = random.nextInt(_options.size());
            _options.get(_optionRandom).click();
        } else {
            Assert.fail("Can not get option list.");
        }
    }

    public void selectTypeOfPaymentAccount(String paymentAccountType) {
        validateHelpers.clickElement(bankTypeFiled);
        var _list = validateHelpers.getList(bankTypeList);
        if (!_list.isEmpty()) {
            for (WebElement a : _list)
                if (a.getText().contains(paymentAccountType)) {
                    a.click();
                    break;
                }
        } else {
            Assert.fail("Can not get the bank type list.");
        }
    }

    public void enterBicOrSwift() {
        validateHelpers.setText(bicOrSwift, FakeDataHelper.getFakedata().finance().bic());
    }

    public void enterIban() {
        validateHelpers.setText(ibanField, String.valueOf(FakeDataHelper.getFakedata().finance().iban()));
        validateHelpers.clickOutside();
        try {
            for (int i = 0; ; i++) {
                if (driver.findElement(ibanWarning).isDisplayed()) {
                    validateHelpers.clearElement(ibanField);
                    validateHelpers.setText(ibanField, String.valueOf(FakeDataHelper.getFakedata().finance().iban()));
                } else {
                    break;
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println("Can create with Iban");
        }
    }

    public void clickOnInternational() {
        validateHelpers.clickElement(internationalField);
    }

    public void enterBalanceDate() {
        LocalDateTime now = LocalDateTime.now();
        var _date = Integer.valueOf(date.format(now)) - random.nextInt(0, Integer.valueOf(date.format(now)) - 1);
        validateHelpers.setText(balanceDateField, year.format(now) + "." + month.format(now) + "." + String.valueOf(_date));
    }

    public void checkBalanceDateRequired() {
        Assert.assertTrue(validateHelpers.checkDisplayed(balanceDateRequired));
    }

    public void enterOpeningBalance() {
        decimalFormat.setMaximumFractionDigits(3);
        validateHelpers.setText(openingBalanceField, String.valueOf(decimalFormat.format(random.nextDouble(1, 100))));
    }

    public void checkAccountNumberRequired() {
        Assert.assertTrue(validateHelpers.checkDisplayed(accountNumberRequired), "Account number not required.");
    }

    public void checkAccountNameRequired() {
        Assert.assertTrue(validateHelpers.checkDisplayed(accountNameRequired), "Account name not required");
    }

    public void enterAccountNumber() {
        validateHelpers.setText(accountNumber, String.valueOf(FakeDataHelper.getFakedata().number().randomNumber()));
    }

    public void clickOnCreateButton() {
        validateHelpers.clickElement(createButton);
    }

    public void verifyFailed() {
        Assert.assertTrue(validateHelpers.checkElemenNull(paymentTableTitle));
        System.out.println("Create Fail.");
    }

    public void verifyCreateSuccess() {
        Assert.assertTrue(validateHelpers.checkDisplayed(paymentTableTitle), "Create Failed.");
        System.out.println("Payment account has been create success with name: " + _paymentName);
    }

    public String enterPaymentName() {
        _paymentName = FakeDataHelper.getFakedata().finance().stockMarket();
        validateHelpers.setText(paymentNameField, _paymentName);
        validateHelpers.clickOutside();
        try {
            for (int i = 0; ; i++) {
                if (driver.findElement(paymentNameExist).isDisplayed()) {
                    _paymentName = FakeDataHelper.getFakedata().finance().stockMarket();
                    validateHelpers.setText(paymentNameField, _paymentName);
                } else {
                    break;
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println("Can create payment account with this name.");
        }
        return _paymentName;
    }

    public void goToCreatePaymentAccountPage() {
        validateHelpers.clickElement(createPaymentButton);
    }

    public void goToPaymentTable() {
        validateHelpers.clickElement(leftMenuLink);
    }
}
