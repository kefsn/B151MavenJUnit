package seleniumJunit.day06_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.LinkedList;
import java.util.List;

public class C01_MavenIlkTest {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        /*
        https://www.amazon.com/ sayfasina gidelim
        arama kutusunu locate edelim
        “Samsung headphones” ile arama yapalim
        Bulunan sonuc sayisini yazdiralim
        Ilk urunu tiklayalim
        Sayfadaki tum basliklari yazdiralim
         */

        // https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com/");

        //arama kutusunu locate edelim
        WebElement aramaKutusu = driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']"));

        // “Samsung headphones” ile arama yapalim
        aramaKutusu.sendKeys("Samsung headphones", Keys.ENTER);

        //Bulunan sonuc sayisini yazdiralim
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String sonucSayisi[] = sonucYazisi.getText().split(" ");

        System.out.println("Sonuc Sayisi  = " + sonucSayisi[2]);

        // Ilk urunu tiklayalim
        WebElement ilkUrun = driver.findElement(By.xpath("(//*[@class='a-size-medium a-color-base a-text-normal'])[1]"));
        ilkUrun.click();

        // Sayfadaki tum basliklari yazdiralim
List<WebElement> safyaBasliklari = driver.findElements(By.xpath("/h1|//h2|//h5|//h3|//h4|//h6"));
safyaBasliklari.forEach(t-> System.out.println(t.getText()));


    }


}
