package org.dhanush;
import org.dhanush.pages.SignInPage;
import org.junit.jupiter.api.BeforeEach;
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
    public void checkInvalidEmailAndInvalidPasswordTest(){
        Assert.assertEquals(page.enterInvalidEmailAndInvalidPassword("dhanushdenny@gmail.com","bling@12345"), true);
    }
    @Test
    public void checkSignUpLinkForInvalidEmailInvalidPasswordTest(){
        Assert.assertEquals(page.checkSignUpLinkForInvalidEmailInvalidPassword("dhanushdenny@gmail.com","bling@12345"), true);
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
    public void checkWithEmptyEmailAndPasswordTest(){
        Assert.assertEquals(page.checkWithEmptyEmailAndPassword(), true);
    }
    @Test
    public void checkValidEmailAndEmptyPasswordTest(){
        Assert.assertEquals(page.enterValidEmailAndEmptyPassword(), true);
    }
    @Test
    public void checkInvalidEmailAndEmptyPasswordTest(){
        Assert.assertEquals(page.enterInvalidEmailAndEmptyPassword("dhanush2denny@gmail.con"), true);
    }

    @AfterMethod
    public void cleanUp(){
        page.killBrowser();
    }

}
