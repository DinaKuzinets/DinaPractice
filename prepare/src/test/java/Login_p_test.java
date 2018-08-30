import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Login_p_test extends AppManager{


    public Login_p_test(String browser) {
        super(browser);
    }

    @Test
    public void testLogin_p() {

        app.click(By.name("user"));
        app.type(By.name("user"), "admin");
        app.click(By.id("LoginForm"));
        app.click(By.name("pass"));
        app.type(By.name("pass"), "secret");
        app.click(By.xpath("//form[@id='LoginForm']/input[3]"));

    }
    

}
