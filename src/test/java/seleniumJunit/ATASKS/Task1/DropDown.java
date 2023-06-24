package seleniumJunit.ATASKS.Task1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class DropDown {

    WebDriver driver;

    @Before
    public void setUp(){
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

       // -Amazon sayfasına gidelim
        driver.get("https://amazon.com");

       // -Arama Kutusundaki Dropdown menuyu yazdıralım
        WebElement ddm = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(ddm);
        List<WebElement> dropDownMenu = select.getOptions();
        dropDownMenu.forEach(t-> System.out.println(t.getText()));

        //-Dropdown menuden sırasıyla ilk 5 başlığı (Arts&Crafts ile başlayıp Books'a kadar Books dahil) seçip
        //başlık altındakileri aratalım. Her aramada sayfa başlığını yazdıralım


        //Not: Select Class'ı kullanalım

    }
}
