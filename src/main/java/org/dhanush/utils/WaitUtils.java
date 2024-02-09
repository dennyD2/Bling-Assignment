package org.dhanush.utils;

import org.dhanush.AppConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Time;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WaitUtils {
    private WebDriverWait wait;
    private static Long webElementWaitTimeInSeconds = TimeUnit.SECONDS.toSeconds(10);

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
