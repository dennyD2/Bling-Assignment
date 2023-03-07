package org.dhanush;
import org.dhanush.pages.SignInPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class SignInPageTest {

    private SignInPage page;

    @BeforeMethod
    public void setUp(){
        page = new SignInPage();
        page.launchBrowser();
    }

    @Test
    public void checkPresenceOfUIElementsTest(){
        Assert.assertEquals(page.checkPresenceOfUIElements(), true);
    }
    @Test
    public void checkValidEmailAndValidPasswordTest(){
        Assert.assertEquals(page.enterValidEmailAndValidPassword(), true);
    }
    @Test
    public void checkInvalidCredentialsTest(){
        Assert.assertEquals(page.enterInvalidCredentials("dhanushdenny@gmail.com","bling@12345"), true);
    }
    @Test
    public void checkSignUpLinkForInvalidEmailInvalidPasswordTest(){
        Assert.assertEquals(page.checkSignUpLinkForInvalidCredentials("dhanushdenny@gmail.com","bling@12345"), true);
    }
    @Test
    public void checkEmailIdWithoutAtAndValidPasswordTest(){
        Assert.assertEquals(page.enterEmailIdWithoutAtAndValidPassword("dhanush2dennygmail.com"), true);
    }
    @Test
    public void checkValidEmailAndInvalidPasswordTest(){
        Assert.assertEquals(page.enterValidEmailAndInvalidPassword("bling@123"), true);
    }
    @Test
    public void checkInvalidEmailAndValidPasswordTest(){
        Assert.assertEquals(page.enterInvalidEmailAndValidPassword("dhanushdenny@gmailcom"), true);
    }
    @Test
    public void checkSignUpLinkForInvalidEmailAndValidPasswordTest(){
        Assert.assertEquals(page.checkSignUpLinkForInvalidEmailAndValidPassword("dhanushdenny@gmailcom"), true);
    }
    @Test
    public void checkWithEmptyCredentialsTest(){
        Assert.assertEquals(page.checkWithEmptyCredentials(), true);
    }
    @Test
    public void checkValidEmailAndEmptyPasswordTest(){
        Assert.assertEquals(page.enterValidEmailAndEmptyPassword(), true);
    }
    @Test
    public void checkInvalidEmailAndEmptyPasswordTest(){
        Assert.assertEquals(page.enterInvalidEmailAndEmptyPassword("dhanush2denny@gmail.con"), true);
    }
    @Test
    public void checkEmptyEmailValidPasswordTest(){
        Assert.assertEquals(page.enterEmptyEmailValidPasswordAnd(), true);
    }
    @Test
    public void checkEmptyEmailInvalidPasswordTest(){
        Assert.assertEquals(page.enterEmptyEmailInvalidPassword("bling12345"), true);
    }
    @Test
    public void checkPasswordIsAtleast5CharactersTest(){
        Assert.assertEquals(page.isPasswordAbove5Characters("blin"), true);
    }

    @AfterMethod
    public void cleanUp(){
        page.killBrowser();
    }

}
