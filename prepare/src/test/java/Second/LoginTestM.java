package Second;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTestM extends HelperBase{

    private final static String url = "http://localhost/addressbook/";
  //  private final static String url = "https://www.google.co.il/";
    @BeforeClass
    public static void createFFDriver() {
// Launch the Firefox browser using Firefox driver.
        setUpFFDriver();
    }
    @Test
    public void loginFormTest() {
        openUrl(url);
       assertTrue(isLoginPageIsVisible());
        assertTrue(isUsernameFieldVisible());
        assertTrue(isPasswordFieldVisible());
//Fill in the login form with correct data and click submit button
        typeValueInUsernameField("admin");
        typeValueInPasswordField("secret");
        clickOnSubmitButton();
       // Verify that the opened page is the one expected.
        assertTrue(isLogoutButtonIsVisible());
        logOut();
    }


    @AfterClass
    public static void cleanup() {
// Close the firefox browser.
        quitBrowser();
    }
}
