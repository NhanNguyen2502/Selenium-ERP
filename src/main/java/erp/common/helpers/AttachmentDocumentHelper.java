package erp.common.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileNotFoundException;

public class AttachmentDocumentHelper {
    private WebDriver _driver;
    private String _srcImage = "D://ERP//Selenium-ERP//src//test//java//resources//image//image.png";
    private String _avatarImage = "D://ERP//Selenium-ERP//src//test//java//resources//image//avatar.png";

    public AttachmentDocumentHelper(WebDriver driver)
    {
        this._driver = driver;
    }

    public void  attachmentImage(By element)
    {
            WebElement fileInput = _driver.findElement(element);
            fileInput.sendKeys(_srcImage);

    }

    public void addAvatar (By element)
    {
        WebElement fileInput = _driver.findElement(element);
        fileInput.sendKeys(_avatarImage);
    }
}
