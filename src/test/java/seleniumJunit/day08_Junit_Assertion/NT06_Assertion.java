package seleniumJunit.day08_Junit_Assertion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class NT06_Assertion {

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/checkboxes");

    }


    /*
    Assertion'larda esitlik icin expected , actual olarak kullanilir
     */
    @Test
    public void test01() {
        Assert.assertEquals(2,2);
        System.out.println("Test basarili bir sekilde calisti");

    }
    @Test
    public void test02() {
        Assert.assertEquals(3,2);
        System.out.println("Test basarili bir sekilde calisti");
    }
    @Test
    public void test03() {
        Assert.assertNotEquals(5,4);
        System.out.println("Test basarili bir sekilde calisti");
    }
    @Test
    public void test04() {
        String actualName = "burcu";
        String expectedName = "Burcu";
        Assert.assertEquals(expectedName,actualName);
        System.out.println("Test basarili bir sekilde calisti");
    }





}
