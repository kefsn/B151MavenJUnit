package seleniumJunit.automationExcercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ders02LoginUser {

    WebDriver driver;


    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01() {

        //  1. Launch browser
        //  2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        // 3. Verify that home page is visible successfully
         WebElement page = driver.findElement(By.xpath("(//li)[1]"));
         Assert.assertTrue(page.isDisplayed());

        // 4. Click on 'Signup / Login' button
        WebElement sigInButon = driver.findElement(By.xpath("(//a)[5]"));
        sigInButon.click();

        //  5. Verify 'Login to your account' is visible
        WebElement loginToYourAccount = driver.findElement(By.xpath("//*[text()='Login to your account']"));

        //  6. Enter correct email address and password
        driver.findElement(By.name("email")).sendKeys("aliosman11111.tb@gmail.com", Keys.TAB,"Password",Keys.ENTER);

        //  7. Click 'login' button
        // 8. Verify that 'Logged in as username' is visible
        //  9. Click 'Delete Account' button
        //  10. Verify that 'ACCOUNT DELETED!' is visible



    }


    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
