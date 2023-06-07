package seleniumJunit.day08_Junit_Assertion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_Assertion {

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
         driver.close();
    }

    // 4 tane test methodu olusturun

    @Test
    public void test01() {
        // test01
        // https://amazon.com sayfasına gidin
        driver.get("https://amazon.com");

        // sayfa baslıgının "Amazon" kelimesini icerdigini test edin
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains("Amazon"));//true


    }

    @Test
    public void test02() {

        // test02
        // https://amazon.com sayfasına gidin
        driver.get("https://amazon.com");

        // Amazon resminin görüntülendiğini (isDisplayed()) test edin
        WebElement amazonResmi = driver.findElement(By.xpath("//*[@id='nav-logo-sprites']"));
        Assert.assertTrue(amazonResmi.isDisplayed());

    }

    @Test
    public void test03() {

        // test03
        // https://amazon.com sayfasına gidin
        driver.get("https://amazon.com");

        // arama kutusunun erisilebilir oldugunu test edin
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        Assert.assertTrue(aramaKutusu.isEnabled());


    }

    @Test
    public void test04() {

        // test04
        // https://amazon.com sayfasına gidin
        driver.get("https://amazon.com");

        // sayfa baslıgının "kitap" icermedigini test edin
        String actualTitle = driver.getTitle();
        Assert.assertFalse(actualTitle.contains("kitap"));

    }


}
