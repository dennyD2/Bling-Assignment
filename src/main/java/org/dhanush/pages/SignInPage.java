package org.dhanush.pages;

import org.openqa.selenium.By;

public class SignInPage extends BasePage {
    private By forgotPassword = By.xpath("//button[@class='forget-password-btn']");

    private By forgotPasswordTitle = By.xpath("//p[@class='fp-title']");

    public void clickForgotPassword(){
        waitAndClick(forgotPassword);
    }

    public boolean isForgotPasswordModalDisplayed(){
        waitTillElementIsDisplayed(forgotPasswordTitle);
        return driver.findElement(forgotPasswordTitle).isDisplayed();
    }
}
