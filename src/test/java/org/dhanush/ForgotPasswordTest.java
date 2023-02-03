package org.dhanush;

import org.dhanush.pages.SignInPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ForgotPasswordTest {
    private SignInPage page;

    @BeforeClass
    public void setUp(){
        page = new SignInPage();
        page.launchBrowser();
    }

    @Test
    public void forgotPasswordTest() throws InterruptedException {
        page.clickForgotPassword();
        Assert.assertEquals(page.isForgotPasswordModalDisplayed(), true);
    }

    @AfterClass
    public void cleanUp(){
        page.killBrowser();
    }
}
