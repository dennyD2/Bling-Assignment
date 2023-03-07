package org.dhanush.pages;

import org.dhanush.AppConfig;
import org.openqa.selenium.By;

public class SignInPage extends BasePage {
    private By forgotPasswordLink = By.xpath("//button[@class='forget-password-btn']");
    private By forgotPasswordTitle = By.xpath("//p[@class='fp-title']");

    private By blingLogo = By.xpath("//img[@class='bling-logo']");
    private By welcomeBackText = By.xpath("//p[text()='Welcome back!']");
    private By emailAddress = By.xpath("//input[@id='email']");
    private By password = By.xpath("//input[@id='password'and@type='password']");
    private By visibilityEyeIcon = By.xpath("//i[@class='bi bi-eye-slash-fill bi-eye-slash-fill-password']");
    private By signInButton = By.xpath("//button[@class='signIn-btn main-signIn-btn']");
    private By dontHaveAnAccount = By.xpath("//div[@class='not-have-account']");
    private By signUp = By.xpath("//a[text()='Sign up']");
    private By homePageText = By.xpath("//h1[@id='page-title']");
    private By accountDoesNotExist = By.xpath("//p[@class='email-error-text main-email-error-text']");
    private By pleaseSignUp = By.xpath("(//a[@href='signup.html'])[1]");
    private By pleaseEnterValidEmail = By.xpath("//p[@class='email-error-text main-email-error-text']");
    private By createAccountText = By.xpath("//p[text()='Create Account']");
    private By youAreNotAuthorised = By.xpath("//p[@class='email-error-text main-email-error-text']");
    private By pleaseProvideAnEmail = By.xpath("//p[@class='email-error-text main-email-error-text']");
    private By pleaseEnterYourPassword = By.xpath("//p[@class='password-error-text']");
    private By passwordMustContainAtleast5Characters = By.xpath("//p[@class='password-error-text']");


    public boolean checkPresenceOfUIElements() {
        return driver.findElement(blingLogo).isDisplayed() &&
                driver.findElement(welcomeBackText).isDisplayed() &&
                driver.findElement(emailAddress).isDisplayed() &&
                driver.findElement(password).isDisplayed() &&
                driver.findElement(visibilityEyeIcon).isDisplayed() &&
                driver.findElement(signInButton).isDisplayed() &&
                driver.findElement(dontHaveAnAccount).isDisplayed() &&
                driver.findElement(signUp).isDisplayed() &&
                driver.findElement(forgotPasswordLink).isDisplayed();

    }

    public boolean enterValidEmailAndValidPassword() {
        driver.findElement(emailAddress).sendKeys(AppConfig.validEmail);
        driver.findElement(password).sendKeys(AppConfig.validPassword);
        driver.findElement(signInButton).click();
        waitTillElementIsDisplayed(homePageText);
        return driver.findElement(homePageText).isDisplayed();
    }

    public boolean enterInvalidCredentials(String invalidEmail, String invalidPassword) {
        driver.findElement(emailAddress).sendKeys(invalidEmail);
        driver.findElement(password).sendKeys(invalidPassword);
        driver.findElement(signInButton).click();
        waitTillElementIsDisplayed(accountDoesNotExist);
        return driver.findElement(accountDoesNotExist).isDisplayed();
    }

    public boolean checkSignUpLinkForInvalidCredentials(String invalidEmail, String invalidPassword) {
        driver.findElement(emailAddress).sendKeys(invalidEmail);
        driver.findElement(password).sendKeys(invalidPassword);
        driver.findElement(signInButton).click();
        waitTillElementIsDisplayed(pleaseSignUp);
        driver.findElement(pleaseSignUp).click();
        waitTillElementIsDisplayed(createAccountText);
        return driver.findElement(createAccountText).isDisplayed();
    }

    public boolean enterEmailIdWithoutAtAndValidPassword(String emailIdWithoutAt) {
        driver.findElement(emailAddress).sendKeys(emailIdWithoutAt);
        driver.findElement(password).sendKeys(AppConfig.validPassword);
        driver.findElement(signInButton).click();
        waitTillElementIsDisplayed(pleaseEnterValidEmail);
        return driver.findElement(pleaseEnterValidEmail).isDisplayed();
    }

    public boolean enterValidEmailAndInvalidPassword(String invalidPassword) {
        driver.findElement(emailAddress).sendKeys(AppConfig.validEmail);
        driver.findElement(password).sendKeys(AppConfig.invalidPassword);
        driver.findElement(signInButton).click();
        waitTillElementIsDisplayed(youAreNotAuthorised);
        return driver.findElement(youAreNotAuthorised).isDisplayed();
    }

    public boolean enterInvalidEmailAndValidPassword(String invalidEmail) {
        driver.findElement(emailAddress).sendKeys(invalidEmail);
        driver.findElement(password).sendKeys(AppConfig.validPassword);
        driver.findElement(signInButton).click();
        waitTillElementIsDisplayed(accountDoesNotExist);
        return driver.findElement(accountDoesNotExist).isDisplayed();
    }

    public boolean checkSignUpLinkForInvalidEmailAndValidPassword(String invalidEmail) {
        driver.findElement(emailAddress).sendKeys(invalidEmail);
        driver.findElement(password).sendKeys(AppConfig.validPassword);
        driver.findElement(signInButton).click();
        waitTillElementIsDisplayed(pleaseSignUp);
        driver.findElement(pleaseSignUp).click();
        waitTillElementIsDisplayed(createAccountText);
        return driver.findElement(createAccountText).isDisplayed();
    }

    public boolean checkWithEmptyCredentials() {
        waitTillElementIsDisplayed(signInButton);
        driver.findElement(signInButton).click();
        waitTillElementIsDisplayed(pleaseProvideAnEmail);
        return driver.findElement(pleaseProvideAnEmail).isDisplayed();
    }

    public boolean enterValidEmailAndEmptyPassword() {
        driver.findElement(emailAddress).sendKeys(AppConfig.validEmail);
        driver.findElement(signInButton).click();
        waitTillElementIsDisplayed(pleaseEnterYourPassword);
        return driver.findElement(pleaseEnterYourPassword).isDisplayed();
    }

    public boolean enterInvalidEmailAndEmptyPassword(String invalidEmail) {
        driver.findElement(emailAddress).sendKeys(invalidEmail);
        driver.findElement(signInButton).click();
        waitTillElementIsDisplayed(pleaseEnterYourPassword);
        return driver.findElement(pleaseEnterYourPassword).isDisplayed();
    }

    public boolean enterEmptyEmailValidPasswordAnd() {
        driver.findElement(password).sendKeys(AppConfig.validPassword);
        driver.findElement(signInButton).click();
        waitTillElementIsDisplayed(pleaseProvideAnEmail);
        return driver.findElement(pleaseProvideAnEmail).isDisplayed();
    }

    public boolean enterEmptyEmailInvalidPassword(String invalidEmail) {
        driver.findElement(emailAddress).sendKeys(invalidEmail);
        driver.findElement(signInButton).click();
        waitTillElementIsDisplayed(pleaseProvideAnEmail);
        return driver.findElement(pleaseProvideAnEmail).isDisplayed();
    }

    public boolean checkForgotPasswordFunctionality() {
        waitAndClick(forgotPasswordLink);
        waitTillElementIsDisplayed(forgotPasswordTitle);
        return driver.findElement(forgotPasswordTitle).isDisplayed();
    }
    public boolean isPasswordAbove5Characters(String Below5Characters){
        driver.findElement(emailAddress).sendKeys(AppConfig.validEmail);
        driver.findElement(emailAddress).sendKeys(Below5Characters);
        driver.findElement(signInButton).click();
        waitTillElementIsDisplayed(passwordMustContainAtleast5Characters);
        return driver.findElement(passwordMustContainAtleast5Characters).isDisplayed();
    }

}
