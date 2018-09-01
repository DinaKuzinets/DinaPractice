package Second;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTestM extends HelperBase {

    private final static String url = "http://localhost/addressbook/";

    //  private final static String url = "https://www.google.co.il/";
    @BeforeClass
    public static void createFFDriver() {
// Launch the Firefox browser using Firefox driver.
        setUpFFDriver();
    }

//    @Test
//    public void loginFormTest() {
//        openUrl(url);
//        assertTrue(isLoginPageIsVisible());
//        assertTrue(isUsernameFieldVisible());
//        assertTrue(isPasswordFieldVisible());
////Fill in the login form with correct data and click submit button
//        typeValueInUsernameField("admin");
//        typeValueInPasswordField("secret");
//        clickOnSubmitButton();
//        // Verify that the opened page is the one expected.
//        assertTrue(isLogoutButtonIsVisible());
//        logOut();
//
//    }


    @Test
    public void loginFormTest2() {
        openUrl(url);
        WebElement loginLink = waitUntilElementIsLodedCustomTime(
                By.xpath("//input[@value='LOGIN']"),
                40,
                "Login page was not loaded");
        //    loginLink.click();
        WebElement user = waitUntilElementIsLodedCustomTime(
                By.xpath("//input[@name='user']"),
                40,
                "Username field was not loaded");
        WebElement password = waitUntilElementIsLodedCustomTime(
                By.xpath("//input[@name='pass']"),
                40,
                "Password field was not loaded");
        WebElement loginButton = waitUntilElementIsLodedCustomTime(
                By.xpath("//input[@value='LOGIN']"),
                40,
                "Login button was not loaded");
        typeValueInUsernameField("admin");
        typeValueInPasswordField("secret");
        loginButton.click();
        WebElement logOutButton = waitUntilElementIsLodedCustomTime(
                By.xpath("//a[contains(text(),'LOGOUT')]"),
                40,
                "Username or password is incorrect");
        logOut();

    }


    @AfterClass
    public static void cleanup() {
// Close the firefox browser.
        quitBrowser();
    }
}
