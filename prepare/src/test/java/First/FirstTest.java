package First;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class FirstTest extends Man {


    public FirstTest(String browser) {
        super(browser);
    }

    @Test
    public void testLogin_p() {

        Man.app.click(By.name("user"));
        Man.app.type(By.name("user"), "admin");
        Man.app.click(By.id("LoginForm"));
        Man.app.click(By.name("pass"));
        Man.app.type(By.name("pass"), "secret");
        Man.app.click(By.xpath("//form[@id='LoginForm']/input[3]"));

    }
    

}
