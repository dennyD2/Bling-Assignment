package org.dhanush.utils;

import org.dhanush.AppConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {
    private WebDriverWait wait;
    private static Duration webElementWaitTimeInSeconds = Duration.ofSeconds(10);

    private void setWait(WebDriver driver){
        if(wait == null){
            wait  = new WebDriverWait(driver, webElementWaitTimeInSeconds);
        }
    }

    public WebDriverWait getWait(WebDriver driver){
        setWait(driver);
        return wait;
    }
}
