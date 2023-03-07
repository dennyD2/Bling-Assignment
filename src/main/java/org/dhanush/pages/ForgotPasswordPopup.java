package org.dhanush.pages;

import org.dhanush.AppConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPopup extends BasePage{

    private By forgotPasswordLink = By.xpath("//button[@class='forget-password-btn']");
    private By forgotPasswordTitle = By.xpath("//p[@class='fp-title']");
    private By closeButton = By.xpath("//img[@src='../icons/signIn_with_forgetPassword/close.svg']");
    private By noWorriesText = By.xpath("//p[text()='No worries, we’ll send you reset instructions']");
    private By emailLabel = By.xpath("//p[text()='Email']");
    private By emailTextBox = By.xpath("//input[@id='email1']");
    private By resetPasswordButton = By.xpath("//button[@class='reset-pwd signIn-btn']");
    private By backToLogin = By.xpath("//p[@class='fp-back-to-login-text']");
    private By welcomeBackText = By.xpath("//p[text()='Welcome back!']");
    private By resetSuccessMessage = By.xpath("//p[@id='resetsuccess']");
    private By emailRedErrorBox = By.xpath("//input[@class='error-msg']");

    public boolean isForgotPasswordLinkPresent(){
        return driver.findElement(forgotPasswordLink).isDisplayed();
    }
    public boolean checkPresenceOfUIElements() {
        driver.findElement(forgotPasswordLink).click();
        return driver.findElement(forgotPasswordTitle).isDisplayed() &&
                driver.findElement(closeButton).isDisplayed() &&
                driver.findElement(noWorriesText).isDisplayed() &&
                driver.findElement(emailLabel).isDisplayed() &&
                driver.findElement(emailTextBox).isDisplayed() &&
                driver.findElement(resetPasswordButton).isDisplayed() &&
                driver.findElement(backToLogin).isDisplayed();
    }
    public boolean checkCloseButton(){
        driver.findElement(forgotPasswordLink).click();
        waitTillElementIsDisplayed(closeButton);
        driver.findElement(closeButton).click();
        waitTillElementIsDisplayed(welcomeBackText);
        return driver.findElement(welcomeBackText).isDisplayed();
    }
    public boolean checkResetPasswordWithValidCredentials(){
        driver.findElement(forgotPasswordLink).click();
        waitTillElementIsDisplayed(emailTextBox);
        driver.findElement(emailTextBox).sendKeys(AppConfig.validEmail);
        driver.findElement(resetPasswordButton).click();
        waitTillElementIsDisplayed(resetSuccessMessage);
        return driver.findElement(resetSuccessMessage).isDisplayed();
    }
    public boolean checkResetPasswordWithInvalidCredentials(String invalidEmail){
        driver.findElement(forgotPasswordLink).click();
        waitTillElementIsDisplayed(emailTextBox);
        driver.findElement(emailTextBox).sendKeys(invalidEmail);
        driver.findElement(resetPasswordButton).click();
        waitTillElementIsDisplayed(resetSuccessMessage);
        return driver.findElement(resetSuccessMessage).isDisplayed();
    }
    public boolean checkWithEmptyCredentials(){
        driver.findElement(forgotPasswordLink).click();
        driver.findElement(resetPasswordButton).click();
        WebElement element = driver.findElement(emailRedErrorBox);
        String red = element.getCssValue("border-bottom-color");
        return red.equalsIgnoreCase("rgba(255, 0, 0, 1)");
    }
    public boolean checkBackToLoginButton(){
        driver.findElement(forgotPasswordLink).click();
        waitTillElementIsDisplayed(backToLogin);
        driver.findElement(backToLogin).click();
        waitTillElementIsDisplayed(welcomeBackText);
        return driver.findElement(welcomeBackText).isDisplayed();
    }
}
