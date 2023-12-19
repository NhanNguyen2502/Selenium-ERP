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
    private By saleTypeDropdow = By.xpath("//button[@data-cy='drop-down-button']");
    private By invoiceDateFiled = By.xpath("(//input[@data-cy='remaining-days'])[2]");
    private By invoiceDatebt = By.xpath("(//mat-datepicker-toggle//button)[1]");
    private By remainingDayfield = By.xpath("(//input[@data-cy='remaining-days'])[1]");
    private By dueDateField = By.xpath("//input[@data-cy='due-date']");
    private By dueDateBt = By.xpath("(//mat-datepicker-toggle//button)[2]");
    private By changeSaleDateBt = By.xpath("(//mat-expansion-panel//button)[4]");
    private By setSaleTypeDefault = By.xpath("(//mat-expansion-panel//button)[3]");

    public CreateSalePage(WebDriver driver) {
        this.driver = driver;
        validateHelpers = new ValidateHelpers(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public String checkSaleType() {
        wait.until(ExpectedConditions.elementToBeClickable(saleTypeFiled));
        return validateHelpers.getMessage(saleTypeFiled);
    }

    public void checkDateandtypeSection(String standard, String instalment) {
        String saleType = checkSaleType();
        if (saleType.equals(standard)) {
            validateHelpers.checkDisplayed(dateAndTye);
            validateHelpers.checkDisplayed(expandableonDateAndType);
            validateHelpers.checkDisplayed(saleTypeField);
            validateHelpers.checkDisplayed(saleTypeDropdow);
            validateHelpers.checkDisplayed(invoiceDateFiled);
            validateHelpers.checkDisplayed(invoiceDatebt);
            validateHelpers.checkDisplayed(remainingDayfield);
            validateHelpers.checkDisplayed(dueDateField);
            validateHelpers.checkDisplayed(dueDateBt);
            validateHelpers.checkDisplayed(setSaleTypeDefault);

        } else if (saleType.equals(instalment)) {
            validateHelpers.checkDisplayed(dateAndTye);
            validateHelpers.checkDisplayed(expandableonDateAndType);
            validateHelpers.checkDisplayed(saleTypeField);
            validateHelpers.checkDisplayed(saleTypeDropdow);
            validateHelpers.checkDisplayed(invoiceDateFiled);
            validateHelpers.checkDisplayed(invoiceDatebt);
            validateHelpers.checkDisplayed(remainingDayfield);
            validateHelpers.checkDisplayed(dueDateField);
            validateHelpers.checkDisplayed(dueDateBt);
            validateHelpers.checkDisplayed(setSaleTypeDefault);
            Assert.assertTrue(validateHelpers.checkElementDisabled(remainingDayfield));
            Assert.assertTrue(validateHelpers.checkElementDisabled(dueDateField));
        } else {
            validateHelpers.checkDisplayed(dateAndTye);
            validateHelpers.checkDisplayed(expandableonDateAndType);
            validateHelpers.checkDisplayed(saleTypeField);
            validateHelpers.checkDisplayed(saleTypeDropdow);
            validateHelpers.checkDisplayed(changeSaleDateBt);
        }
    }
}
