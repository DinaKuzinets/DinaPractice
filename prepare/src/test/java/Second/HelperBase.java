package Second;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class HelperBase {

    private static WebDriver driver;

    protected static void setUpFFDriver() {
        driver = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
        driver.manage().timeouts().implicitlyWait(new Long("10"), TimeUnit.SECONDS);
    }


    protected void openUrl(String url) {
        driver.get(url);
    }


    private WebElement waitUntilElementIsLodedCustomTime(By by, int time, String error_message) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.withMessage(error_message + "\n");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));


    }



//    protected void waitUntilHeadingIsVisible(String heading) {
//        (new WebDriverWait(driver, 30)).until(ExpectedConditions
//                .textToBePresentInElementLocated(By.id(heading), heading));
//    }


//    protected String getPageTitle() {
//        return driver.getTitle();
//    }

    public void click(By locator) {driver.findElement(locator).click();
    }

    public void type(By locator, String text) {
        click(locator);
        if (text != null) {
            String existText = driver.findElement(locator).getAttribute("value");
            if (!text.equals(existText)) {
                driver.findElement(locator).clear();
                driver.findElement(locator).sendKeys(text);
            }
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected boolean isLoginPageIsVisible() {
        return isElementPresent(By.xpath("//input[@value='LOGIN']"));
    }


    protected boolean isUsernameFieldVisible() {
        return isElementPresent(By.name("user"));
    }

    protected boolean isPasswordFieldVisible() {
        return isElementPresent(By.name("pass"));
    }


    protected boolean isLogoutButtonIsVisible(){
        return isElementPresent(By.xpath("//a[contains(text(),'LOGOUT')]"));
    }

    protected void typeValueInUsernameField(String username) {
        type(By.name("user"),username);
//        WebElement field = driver.findElement(By.name("user"));
//        field.clear();
//        field.sendKeys(username);
    }

    protected void typeValueInPasswordField(String password) {
        type(By.name("pass"),password);
//        WebElement field = driver.findElement(By.name("pass"));
//        field.clear();
//        field.sendKeys(password);
    }

    protected void clickOnSubmitButton() {
        click(By.xpath("//input[@value='LOGIN']"));
    }

//
//    protected String getErrorMessage() {
//        return driver.findElement(By.className("error")).getText();
//    }

//    protected void waitUntilLinkIsVisible(final String linkText) {
//        (new WebDriverWait(driver, 30)).until(ExpectedConditions
//                .visibilityOfElementLocated(By.linkText(linkText)));
//    }


    protected void logOut()
    {click(By.cssSelector("a[onclick='document.logout.submit();']"));
    }


    protected static void quitBrowser() {
        driver.quit();
    }

//    protected String getHeadingText(String heading) {
//        return driver.findElement(By
//                .cssSelector(heading)).getText();
//    }



}