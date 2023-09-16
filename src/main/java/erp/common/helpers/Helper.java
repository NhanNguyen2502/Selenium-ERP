package erp.common.helpers;

import org.openqa.selenium.WebDriver;


import java.time.Duration;

public class Helper {


    public static String getcurrentDir() {
        String current = System.getProperty("user.dir") + "/";
        return current;
    }
}
