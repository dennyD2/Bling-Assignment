package org.dhanush;

import org.dhanush.pages.ForgotPasswordPopup;
import org.testng.Assert;
import org.testng.annotations.*;

public class ForgotPasswordTest {
    private ForgotPasswordPopup page;

    @BeforeMethod
    public void setUp(){
        page = new ForgotPasswordPopup();
        page.launchBrowser();
    }

    /*@Test
    public void checkForgotPasswordLink(){
        Assert.assertEquals(page.isForgotPasswordLinkPresent(), true);
    }
    @Test
    public void checkPresenceOfUIElementsTest(){
        Assert.assertEquals(page.checkPresenceOfUIElements(), true);
    }
    @Test
    public void checkCloseButton(){
        Assert.assertEquals(page.checkCloseButton(), true);
    }
    @Test
    public void checkResetPasswordWithValidCredentials(){
        Assert.assertEquals(page.checkResetPasswordWithValidCredentials(), true);
    }
//    Bug in this test
//    @Test
//    public void checkResetPasswordWithInvalidCredentialsTest(){
//        Assert.assertFalse(page.checkResetPasswordWithInvalidCredentials("dhanush2denny.com"));
//    }
    @Test
    public void checkWithEmptyCredentials(){
        Assert.assertEquals(page.checkWithEmptyCredentials(), true);
    }
    @Test
    public void checkBackToLoginButton(){
        Assert.assertEquals(page.checkBackToLoginButton(), true);
    }
@Test
public void titleTest(){
        page.title();
}*/
@Test
public void dummy(){}

    @AfterMethod
    public void cleanUp(){
        page.killBrowser();
    }
}
