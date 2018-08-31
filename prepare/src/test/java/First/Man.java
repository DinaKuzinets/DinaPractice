package First;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class Man {
    WebDriver wd;
    private String browser;


    public Man(String browser) {
        this.browser = browser;
    }


    public void start() throws IOException {
        if (browser.equals(BrowserType.FIREFOX)) {
            wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
        } else if (browser.equals(BrowserType.CHROME)) {
            wd = new ChromeDriver();
        } else if (browser.equals(BrowserType.IE)) {
            wd = new InternetExplorerDriver();
        }

        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        openSite("http://localhost/addressbook/");
    }


    public void getBrowserLog(){
        System.out.println(wd.manage().logs().getAvailableLogTypes());
        wd.manage().logs().get("browser").forEach(l -> System.out.println(l));
    }


    public void openSite(String url) {
        wd.get(url);

    }

    public void stop() {
       logOut();
        wd.quit();
    }

    public void logOut() {
        click(By.cssSelector("a[onclick='document.logout.submit();']"));
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void type(By locator, String text) {
        click(locator);
        if (text != null) {
            String existText = wd.findElement(locator).getAttribute("value");
            if (!text.equals(existText)) {
                wd.findElement(locator).clear();
                wd.findElement(locator).sendKeys(text);
            }
        }
    }



    Logger logger = LoggerFactory.getLogger(Man.class);


    protected static final Man app =
            new Man(System.getProperty("browser",BrowserType.FIREFOX));

    @BeforeSuite
    public void setUp() throws Exception {
        app.start();
    }

    @AfterSuite
    public void tearDown() {
        app.stop();
    }


    @BeforeMethod
    public void startLog(Method m){
        logger.info("Start test " + m);
    }

    @AfterMethod
    public void stoptLog(Method m){
        app.getBrowserLog();
        logger.info("Stop test " + m);
    }




}
