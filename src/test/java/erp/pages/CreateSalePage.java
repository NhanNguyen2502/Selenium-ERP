package erp.pages;

import erp.common.helpers.ValidateHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CreateSalePage {
    private WebDriver driver;
    private WebDriverWait wait;
    private ValidateHelpers validateHelpers;

    private By saleTypeFiled = By.xpath("//app-select//input");
    private By dateAndTye = By.xpath("(//mat-accordion//mat-panel-title)[1]");
    private By expandableonDateAndType = By.xpath("(//button[@data-cy='expandable-buton'])[1]");
    private By saleTypeField = By.xpath("(//mat-form-field)[2]");
    private By saleTypeDropdownButton = By.xpath("//button[@data-cy='drop-down-button']");
    private By typeList = By.xpath("//mat-option");
    private By invoiceDateFiled = By.xpath("(//input[@data-cy='remaining-days'])[2]");
    private By invoiceDatebt = By.xpath("(//mat-datepicker-toggle//button)[1]");
    private By remainingDayfield = By.xpath("(//input[@data-cy='remaining-days'])[1]");
    private By dueDateField = By.xpath("//input[@data-cy='due-date']");
    private By dueDateBt = By.xpath("(//mat-datepicker-toggle//button)[2]");
    private By changeSaleDateBt = By.xpath("(//mat-expansion-panel//button)[4]");
    private By setSaleTypeDefault = By.xpath("(//mat-expansion-panel//button)[3]");
    private By accountSection = By.xpath("//app-sale-draft-account");
    private By logoCompany = By.xpath("//app-sale-draft-account//app-company-logo");
    private By accountField = By.xpath("//app-select-object-control[@id='select-account-number']");
    private By accountDropDownListButton = By.xpath("(//button[@data-cy='drop-down-button'])[2]");
    private By editBankAccountButton = By.xpath("//button[@apptooltip='regularInvoice.button.editBankAccount']");
    private By createBankAccountButton = By.xpath("//button[@apptooltip='regularInvoice.button.createBankAccount']");
    private By ourReference = By.xpath("//app-select-object-control[@id='select-our-reference']");

    public CreateSalePage(WebDriver driver) {
        this.driver = driver;
        validateHelpers = new ValidateHelpers(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public String selectSaleType(String type) {
        validateHelpers.clickElement(saleTypeDropdownButton);
        var listType = driver.findElements(typeList);
        for (var x : listType) {
            if (x.getText().equals(type)) {
                x.click();
                break;
            } else {
                System.out.println("Invoice type does not exist");
            }

        }
        return type;
    }

    public void checkAccountSection() {
        validateHelpers.checkDisplayed(logoCompany);
        validateHelpers.checkDisplayed(accountField);
        validateHelpers.checkDisplayed(accountDropDownListButton);
        validateHelpers.checkDisplayed(editBankAccountButton);
        validateHelpers.checkDisplayed(createBankAccountButton);
        validateHelpers.checkDisplayed(ourReference);
    }

    public void checkDateAndTypeSection(String saleType, String standard, String instalment) {
        String type = selectSaleType(saleType);
        if (type.equals(standard)) {
            if (!validateHelpers.checkElementDisabled(setSaleTypeDefault)) {
                Assert.assertTrue(validateHelpers.checkDisplayed(dateAndTye));
                Assert.assertTrue(validateHelpers.checkDisplayed(expandableonDateAndType));
                Assert.assertTrue(validateHelpers.checkDisplayed(saleTypeField));
                Assert.assertTrue(validateHelpers.checkDisplayed(saleTypeDropdownButton));
                Assert.assertTrue(validateHelpers.checkDisplayed(invoiceDateFiled));
                Assert.assertTrue(validateHelpers.checkDisplayed(invoiceDatebt));
                Assert.assertTrue(validateHelpers.checkElementDisabled(remainingDayfield));
                Assert.assertTrue(validateHelpers.checkDisplayed(dueDateField));
                Assert.assertTrue(validateHelpers.checkDisplayed(dueDateBt));
                Assert.assertTrue(validateHelpers.checkDisplayed(setSaleTypeDefault));
            } else {
                Assert.assertTrue(validateHelpers.checkDisplayed(dateAndTye));
                Assert.assertTrue(validateHelpers.checkDisplayed(expandableonDateAndType));
                Assert.assertTrue(validateHelpers.checkDisplayed(saleTypeField));
                Assert.assertTrue(validateHelpers.checkDisplayed(saleTypeDropdownButton));
                Assert.assertTrue(validateHelpers.checkDisplayed(invoiceDateFiled));
                Assert.assertTrue(validateHelpers.checkDisplayed(invoiceDatebt));
                Assert.assertTrue(validateHelpers.checkElementDisabled(remainingDayfield));
                Assert.assertTrue(validateHelpers.checkDisplayed(dueDateField));
                Assert.assertTrue(validateHelpers.checkDisplayed(dueDateBt));
            }

        } else if (type.equals(instalment)) {
            if (!validateHelpers.checkElementDisabled(setSaleTypeDefault)) {
                Assert.assertTrue(validateHelpers.checkDisplayed(dateAndTye));
                Assert.assertTrue(validateHelpers.checkDisplayed(expandableonDateAndType));
                Assert.assertTrue(validateHelpers.checkDisplayed(saleTypeField));
                Assert.assertTrue(validateHelpers.checkDisplayed(saleTypeDropdownButton));
                Assert.assertTrue(validateHelpers.checkDisplayed(invoiceDateFiled));
                Assert.assertTrue(validateHelpers.checkDisplayed(invoiceDatebt));
                Assert.assertTrue(validateHelpers.checkElementDisabled(remainingDayfield));
                Assert.assertTrue(validateHelpers.checkElementDisabled(dueDateField));
                Assert.assertTrue(validateHelpers.checkElementDisabled(dueDateBt));
                Assert.assertTrue(validateHelpers.checkDisplayed(setSaleTypeDefault));
                Assert.assertTrue(validateHelpers.checkElementDisabled(remainingDayfield));
                Assert.assertTrue(validateHelpers.checkElementDisabled(dueDateField));
            } else {
                Assert.assertTrue(validateHelpers.checkDisplayed(dateAndTye));
                Assert.assertTrue(validateHelpers.checkDisplayed(expandableonDateAndType));
                Assert.assertTrue(validateHelpers.checkDisplayed(saleTypeField));
                Assert.assertTrue(validateHelpers.checkDisplayed(saleTypeDropdownButton));
                Assert.assertTrue(validateHelpers.checkDisplayed(invoiceDateFiled));
                Assert.assertTrue(validateHelpers.checkDisplayed(invoiceDatebt));
                Assert.assertTrue(validateHelpers.checkElementDisabled(remainingDayfield));
                Assert.assertTrue(validateHelpers.checkElementDisabled(dueDateField));
                Assert.assertTrue(validateHelpers.checkElementDisabled(dueDateBt));
                Assert.assertTrue(validateHelpers.checkDisplayed(setSaleTypeDefault));
                Assert.assertTrue(validateHelpers.checkElementDisabled(remainingDayfield));
                Assert.assertTrue(validateHelpers.checkElementDisabled(dueDateField));
            }

        } else {
            if (!validateHelpers.checkElementDisabled(setSaleTypeDefault)) {
                Assert.assertTrue(validateHelpers.checkDisplayed(dateAndTye));
                Assert.assertTrue(validateHelpers.checkDisplayed(expandableonDateAndType));
                Assert.assertTrue(validateHelpers.checkDisplayed(saleTypeField));
                Assert.assertTrue(validateHelpers.checkDisplayed(saleTypeDropdownButton));
                Assert.assertTrue(validateHelpers.checkDisplayed(changeSaleDateBt));
                Assert.assertTrue(validateHelpers.checkDisplayed(setSaleTypeDefault));
            } else {
                Assert.assertTrue(validateHelpers.checkDisplayed(dateAndTye));
                Assert.assertTrue(validateHelpers.checkDisplayed(expandableonDateAndType));
                Assert.assertTrue(validateHelpers.checkDisplayed(saleTypeField));
                Assert.assertTrue(validateHelpers.checkDisplayed(saleTypeDropdownButton));
                Assert.assertTrue(validateHelpers.checkDisplayed(changeSaleDateBt));
                Assert.assertTrue(validateHelpers.checkElementDisabled(setSaleTypeDefault));
            }
        }
    }
}
