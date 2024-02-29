package erp.pages;

import erp.common.helpers.PropertiesHelper;
import erp.common.helpers.TranslationHelpers;
import erp.common.helpers.ValidateHelpers;
import org.jsoup.Jsoup;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import static java.util.Map.entry;

public class CompanyListPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private ValidateHelpers validateHelpers;


    private By selecteCompanyDropdown = By.xpath("//div[@data-cy='select-company-button']");
    private By companyListTitle = By.xpath("//span[@data-cy='company-list-title']");
    //    @FindBy(xpath = "//span[@data-cy='company-list-title']")
//    WebElement companyListTitle;
    private By currentPageTitle = By.xpath("//span[@data-cy='breadcrumb-label']");
    //    @FindBy(xpath = "//span[@data-cy='breadcrumb-label']")
//    WebElement currentPageTitle;
    private By contactUsLink = By.xpath("//a[@data-cy='contact-us-link']");
    //private By languageOption = By.xpath("//app-language-option//button[@data-cy='language-option-btn']");
//    @FindBy(xpath = "//app-language-option//button[@data-cy='language-option-btn']")
//    WebElement languageOption;
    private By nameOfAccount = By.xpath("//button//span//span[@class='user-name text-truncate text-initial']");
    private By logoutButton = By.xpath("//button[@data-cy='log-out-button']");
    //private By createButton = By.xpath("//button[@data-cy='create-company-btn']");
    @FindBy(xpath = "//button[@data-cy='create-company-btn']")
    WebElement createButton;
    //private By companyStatusList = By.xpath("//div//input[@id='company-status-select']");
    @FindBy(xpath = "//div//input[@id='company-status-select']")
    WebElement companyStatusList;
    private By columnConfigButton1 = By.xpath("//div//button[@data-cy='table-column-config-button']");
    @FindBy(xpath = "//div//button[@data-cy='table-column-config-button']")
    WebElement columnConfigButton;
    private By rowPagePerText = By.xpath("//span[@class='text-truncate']");
    //    @FindBy(xpath = "//span[@class='text-truncate']")
//    WebElement rowPagePerText;
    //private By rowPagePerSelection = By.xpath("//div//input[@data-cy='page-size']");
    @FindBy(xpath = "//div//input[@data-cy='page-size']")
    WebElement rowPagePerSelection;
    //private By searchField = By.xpath("(//input[@id='search-input-field'])[1]");
    @FindBy(xpath = "(//input[@id='search-input-field'])[1]")
    WebElement searchField;
    //private By companyTable = By.xpath("//table[@id='company-list-table']");
    @FindBy(xpath = "//table[@id='company-list-table']")
    WebElement companyTable;
    private By tableTitle = By.xpath("//mat-header-row[@role='row']");
    //    @FindBy(xpath = "//mat-header-row[@role='row']")
//    WebElement tableTitle;
    private By languageButton = By.xpath("//app-language-option");
    private By languageOptions = By.xpath("//div[@data-cy='language-option-item']");
    //Check company table
    private By companies = By.xpath("//mat-row//mat-cell[2]");
    private By companyType = By.xpath("//mat-row//mat-cell//div[@data-cy='company-type']");
    //Go to company list
    private By selecteCompanyButton = By.xpath("//div[@data-cy='select-company-button']");
    private By companyListButton = By.xpath("//a[@data-cy='breadcrumb-company-list']");
    //more options
    private By moreOptionButton = By.xpath("//app-company-table-option[@data-cy='company-more-option']");
    private By editOption = By.xpath("//div[@data-cy='company-option-edit']");
    private By deleteOption = By.xpath("//div[@data-cy='company-option-delete']");
    //delete
    private By deletepopup = By.xpath("//app-confirm-delete-company-dialog");
    private By deleteTitle = By.xpath("//h4[@data-cy='confirm-delete-company-title']");
    private By closeDialog = By.xpath("//button[@data-cy='dialog-close-button']");
    private By cancleButton = By.xpath("//button[@data-cy='dialog-cancel-delete-comapny-button']");
    private By confirmButton = By.xpath("//button[@data-cy='dialog-delete-button']");
    private By companyName = By.xpath("//mat-row//mat-cell//span[@data-cy='company-primary-name']");
    private By contectDelete = By.xpath("//p[@data-cy='confirm-dialog-message']");

    public CompanyListPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        validateHelpers = new ValidateHelpers(driver);
        PageFactory.initElements(driver, this);
    }

    public DashBoardPage goToCompany(String type) {
        var companyTypes = driver.findElements(companyType);
        var com = driver.findElements(companies);
        for (int i = 0; i < companyTypes.size(); i++) {
            if (companyTypes.get(i).getText().contains(type)) {
                System.out.println("The company "+(i+1)+ ": " +companyTypes.get(i).getText() + " match with type " +type);
                com.get(i).click();
                break;
            }
            else {
                System.out.println("The company "+(i+1)+ ": " +companyTypes.get(i).getText() + " Not match with type " +type);
            }
        }
        return new DashBoardPage(driver);
    }

    public void deleteCompany(String Ctype, String deTitle, String content) {
        Assert.assertTrue(validateHelpers.checkDisplayed(moreOptionButton));
        var companyTypes = driver.findElements(companyType);
        var options = driver.findElements(moreOptionButton);
        var names = driver.findElements(companyName);
        for (int i = 0; i < companyTypes.size(); i++) {
            if (companyTypes.get(i).getText().equals(Ctype)) {
                options.get(i).click();
                String name = names.get(i).getText();
                validateHelpers.clickElement(deleteOption);
                Assert.assertTrue(validateHelpers.checkDisplayed(deletepopup));
                Assert.assertTrue(validateHelpers.checkDisplayed(deleteTitle));
                Assert.assertTrue(validateHelpers.checkDisplayed(closeDialog));
                Assert.assertTrue(validateHelpers.checkDisplayed(cancleButton));
                Assert.assertTrue(validateHelpers.checkDisplayed(confirmButton));
                Assert.assertEquals(validateHelpers.getMessage(deleteTitle), deTitle);
//                Map<String, String> data = Map.ofEntries(
//                        entry("name", name)
//                );
                Map<String, String> data = new HashMap<>();
                data.put("name", name);
                Assert.assertEquals(
                        validateHelpers.removeHtmlTags(validateHelpers.getMessage(contectDelete)),
                        validateHelpers.removeHtmlTags(TranslationHelpers.getContent(content, data)), "Wrong here");
                validateHelpers.clickElement(cancleButton);
            } else System.out.println("The company type does not exist");
        }
    }

    public void goToEditPage(String Ctype) {
        Assert.assertTrue(validateHelpers.checkDisplayed(moreOptionButton));
        var companyTypes = driver.findElements(companyType);
        var options = driver.findElements(moreOptionButton);
        for (int i = 0; i < companyTypes.size(); i++) {
            if (companyTypes.get(i).getText().equals(Ctype)) {
                options.get(i).click();
                validateHelpers.clickElement(editOption);
                break;
            }
            else{
                System.out.println("Company "+ i+1 + " is not " +Ctype);
            }

        }

    }

    public void checkMoreOptions(String editText, String deleteText) {
        Assert.assertTrue(validateHelpers.checkDisplayed(moreOptionButton));
        List<WebElement> optionButton = driver.findElements(moreOptionButton);
        if (optionButton.size() >= 1) {
            for (WebElement o : optionButton) {
                o.click();
                validateHelpers.waitForLoadJs();
                Assert.assertEquals(validateHelpers.getMessage(editOption), editText, "checkMoreOptions wrong 1");
                Assert.assertEquals(validateHelpers.getMessage(deleteOption), deleteText, "checkMoreOptions wrong 2");
                validateHelpers.clickOutside();
            }
        }

    }

    public void checkTypeOfCompany(String realtype) {
        List<WebElement> companyTypes = driver.findElements(companyType);
        int i = 0;
        int ii = 0;
        for (WebElement c : companyTypes) {
            if (c.getText().equals(realtype))
                i++;
            else ii++;
        }
        System.out.println("Real Company is: " + i + "\n" + "Demo company is: " + ii);
    }

    public void checkCompaniesList() {
        List<WebElement> companiesList = driver.findElements(companies);
        if (companiesList.isEmpty()) {
            System.out.println("The result is empty");
        }
        System.out.println("number of company on list is " + companiesList.size());
    }

    public void gotoCompnyList() {
        Assert.assertTrue(validateHelpers.checkDisplayed(selecteCompanyButton));
        validateHelpers.clickElement(selecteCompanyButton);
        Assert.assertTrue(validateHelpers.checkDisplayed(companyListButton));
        validateHelpers.clickElement(companyListButton);
    }


    public void verifyColumnConfiguration() {
        Assert.assertTrue(validateHelpers.checkDisplayed(columnConfigButton1), "ColumnConfiguration is not display");
        validateHelpers.clickElement(columnConfigButton1);
    }

    public void verifyHeader() {
        WebElement contactUs = driver.findElement(contactUsLink);
        WebElement accountName = driver.findElement(nameOfAccount);
        WebElement logoutElement = driver.findElement(logoutButton);
        Assert.assertTrue(contactUs.isDisplayed(), "verifyHeader 1");
        Assert.assertTrue(accountName.isDisplayed(), "verifyHeader 2");
        Assert.assertTrue(logoutElement.isDisplayed(), "verifyHeader 3");
    }

    public void verifyBodyOfPage(String Companies, String companyList, String rowtext) {
        Assert.assertTrue(createButton.isDisplayed());
        Assert.assertTrue(companyStatusList.isDisplayed());
        Assert.assertTrue(columnConfigButton.isDisplayed());
        Assert.assertTrue(rowPagePerSelection.isDisplayed());
        Assert.assertTrue(searchField.isDisplayed());
        Assert.assertEquals(validateHelpers.getMessage(currentPageTitle), Companies);
        Assert.assertEquals(validateHelpers.getMessage(companyListTitle), companyList);
        Assert.assertEquals(validateHelpers.getMessage(rowPagePerText), rowtext);
    }

    public void verifylanguage(String language) {
        validateHelpers.clickElement(languageButton);
        wait.until(ExpectedConditions.elementToBeClickable(languageOptions));
        List<WebElement> options = driver.findElements(languageOptions);
        String key = "$.languageSelect.option.english";
        switch (language) {
            case "English" -> key = "$.languageSelect.option.english";
            case "Arabic" -> key = "$.languageSelect.option.arabic";
            case "Kurdish - Badini" -> key = "$.languageSelect.option.badini";
            case "Kurdish - Sorani" -> key = "$.languageSelect.option.sorani";
            default -> System.out.println("default");
        }
        for (WebElement o : options) {
            if (o.getText().contains(language) || o.getText().contains(TranslationHelpers.setFile(PropertiesHelper.getLanguageToTest(), key))) {
                System.out.println(o.getText());
                o.click();
            }
        }
    }

    public void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
                        .equals("complete");
            }
        };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }


}
