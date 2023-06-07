package seleniumJunit.day08_Junit_Assertion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class NT05_RadioButtonClassWork {

    /*
    -https://www.facebook.com adresine gidin
    -Cookies’i kabul edin
    -“Create an Account” button’una basin
    -“radio buttons” elementlerini locate edin
    -Secili degilse cinsiyet butonundan size uygun olani secin
     */

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/checkboxes");

    }

    @Test
    public void radioButton() {
        // https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");

        // Cookies’i kabul edin
        // Create an Account” button’una basin
        driver.findElement(By.linkText("Yeni hesap oluştur")).click();

        // "radio buttons” elementlerini locate edin
        WebElement female = driver.findElement(By.xpath("(//*[@name='sex'])[1]"));
        WebElement male = driver.findElement(By.xpath("(//*[@name='sex'])[2]"));
        WebElement ozel = driver.findElement(By.xpath("(//*[@name='sex'])[3]"));

        // Secili degilse cinsiyet butonundan size uygun olani secin
        if (!male.isSelected()){
            male.click();
        }

    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
