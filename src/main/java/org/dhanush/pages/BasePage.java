package org.dhanush.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.dhanush.AppConfig;
import org.dhanush.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;
    private WebDriverWait wait;

    public void launchBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(AppConfig.appUrl);
        wait = new WaitUtils().getWait(driver);
    }

    protected void waitAndClick(By webElement){
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        driver.findElement(webElement).click();
    }

    protected void waitTillElementIsDisplayed(By webElement){
        wait.until(ExpectedConditions.visibilityOfElementLocated(webElement));
    }

    public void killBrowser(){
        driver.quit();
    }

}
