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

public class NT04_CheckBox {


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
    public void checkBox() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        // Checkbox1 ve checkbox2 elementlerini locate edin.
        WebElement checkBox1 = driver.findElement(By.xpath("(//input)[1]"));
        WebElement checkBox2 = driver.findElement(By.xpath("(//input)[2]"));
        Thread.sleep(2000);
        // Checkbox1 seçili değilse onay kutusunu tıklayın
        if (!checkBox1.isSelected()){ // seçili değilse
            checkBox1.click(); //checkbox'i click yap
        }
        Thread.sleep(2000);
        // Checkbox2 seçili değilse onay kutusunu tıklayın
        if (!checkBox2.isSelected()){ // seçili değilse
            checkBox2.click(); //checkbox'i click yap
        }


    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
