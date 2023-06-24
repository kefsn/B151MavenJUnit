package seleniumJunit.day09_DropDown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.net.http.WebSocket;
import java.time.Duration;

public class C01_DropDown {

    /*
    DropDown : Alt başlıkların olduğu açılır menu lisesidir.
    DropDown  3 adımdan oluşur.

    1- DropDown locate edilmelidir
    2- Selecet objesi oluşturmalıdır
    Selecet select = new Select(ddm)
    3-Opsiyonlardan bir tanesi seçilir
       -selectByVisibleText() : Görünen opsiyon parantez içie yazılır
       -selectByIndex() : Opsiyona index ile ulaşmak için kullanılır
       -selectByvalue() : Opsiyona value ile ulaşmak için kullanılır

     */

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
        // driver.close();
    }

    @Test
    public void test01() {

        // https://testcenter.techproeducation.com/index.php?page=dropdown sayfasına gidiniz
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");


        // Yıl Dropdown'undan "2020" seciniz
        //1.ADIM LOCATE AL
        //2: ADIM SELECT OBJESİ OLUŞTUR
        WebElement ddmyil = driver.findElement(By.id("year"));
        Select select = new Select(ddmyil);

        // select.selectByVisibleText("2020"); visibleText kullanıldı 2020 almak için
        //select.selectByIndex(3); İndeksle alındı.İndeksi 3
        select.selectByValue("2020"); //value değeri ile alındı

        // Ay Dropdown'undan "August" seciniz
        WebElement ddmAy = driver.findElement(By.id("month"));
        Select select1 = new Select(ddmAy);
        select1.selectByVisibleText("August");


        // Gün Dropdown'undan "5" seciniz
        WebElement ddmGun = driver.findElement(By.id("day"));
        Select select2 = new Select(ddmGun);
        select2.selectByVisibleText("5");

    }
}
