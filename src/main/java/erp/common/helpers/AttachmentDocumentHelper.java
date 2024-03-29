package erp.common.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileNotFoundException;

public class AttachmentDocumentHelper {
    private WebDriver _driver;
    private String _srcImage = "D://ERP//Selenium-ERP//src//test//java//resources//image//Invoices//image.png";
    private String _avatarImage = "D://ERP//Selenium-ERP//src//test//java//resources//image//EmployeeAndCustomer//avatar.png";
    private String _productImage = "D://ERP//Selenium-ERP//src//test//java//resources//image//Products//product.png";

    public AttachmentDocumentHelper(WebDriver driver) {
        this._driver = driver;
    }

    public void uploadProductImage(By element) {
        WebElement fileInput = _driver.findElement(element);
        fileInput.sendKeys(_productImage);
    }

    public void attachmentImage(By element) {
        WebElement fileInput = _driver.findElement(element);
        fileInput.sendKeys(_srcImage);

    }

    public void addAvatar(By element) {
        WebElement fileInput = _driver.findElement(element);
        fileInput.sendKeys(_avatarImage);
    }
}
