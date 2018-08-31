//package Second;
//
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import static org.testng.Assert.assertEquals;
//import static org.testng.Assert.assertTrue;
//
//public class LoginTest extends HelperBase{
//
//    private final static String url = "http://localhost:8080/LoginFormTest/admin";
//    @BeforeClass
//    public static void createFFDriver() {
//// Launch the Firefox browser using Firefox driver.
//        setUpFFDriver();
//    }
//    @Test
//    public void loginFormTest() {
//// Open URL and wait for it to load
//        openUrl(url);
//      waitUntilHeadingIsVisible("Login Form");
//// Verify that opened base url has correct title.
//        assertEquals("Login Page", getPageTitle());
//        assertTrue(isUsernameFieldVisible());
//        assertTrue(isPasswordFieldVisible());
////Fill in the login form with wrong data and click submit
//        typeValueInUsernameField("piret");
//        typeValueInPasswordField("password");
//        clickOnSubmitButton();
////Verify that you are on the same page
//// and error message is displayed
//        assertEquals("Login Page", getPageTitle());
//        assertEquals("Invalid username and password!", getErrorMessage());
////Fill in the login form with correct data
//// and click submit button
//        typeValueInUsernameField("test");
//        typeValueInPasswordField("123456");
//        clickOnSubmitButton();
//        waitUntilLinkIsVisible("Logout");
//// Verify that the opened page is the one expected.
//        assertEquals("Login form based authentication!", getPageTitle());
//        assertEquals("Message : This is protected page!", getHeadingText("h3"));
//    }
//    @AfterClass
//    public static void cleanup() {
//// Close the firefox browser.
//        quitBrowser();
//    }
//}
