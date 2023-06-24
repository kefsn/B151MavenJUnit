package seleniumJunit.day14_Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_KeyDownKeyUp extends TestBase {


    @Test
    public void test01() {

        //Google anasayfasına gidelim
        driver.get("https://google.com");

        //Arama kutusuna Shift tuşuna basılı olarak selenium yazdıralım ve shift
        //tuşunu serbest bırakarak Java yazdıralım.
        WebElement aramaKutusu = driver.findElement(By.xpath("//textarea[@class=‘gLFyf’]"));
        Actions actions = new Actions(driver);
        actions.keyDown(aramaKutusu, Keys.SHIFT).//Arama kutusunda shift tuşuna bastık.
                sendKeys("selenium").
                keyUp(Keys.SHIFT).// shift tuşunu serbest bıraktık.
                sendKeys("java",Keys.ENTER).perform();



    }

    @Test
    public void test02() {
        //Google anasayfasına gidelim
        driver.get("https://google.com");

        //arama kutusunda shift tusuna basılı olarak selenim yazdıralım ve shift tuşunu serbest bırakarak java yazdıralım
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        aramaKutusu.sendKeys(Keys.SHIFT,"selenim",Keys.SHIFT,"-java",Keys.ENTER);
    /*
    Mause işlemleri için actions class'ını kullanmamız gerekir. Fakat bir metin kutusundaki klavye işlemleri için
    actions class'ına kullanmadan sendKeys() methodu ile de istediğimiz bir metni büyük yazdırabilir,
    hatta bir den fazla klavye tuşlana bastırabiliriz. Yukardaki örnekte sendKeys() methodu ile Keys.SHIFT diyerek
    sonrasında yazdırmak istediğimiz metni küçük harfle yazmamıza rağmen büyük harflerle yazdırdı, tekrar Keys.SHIFT
    kullanarak shift tuşunu serbest bırakmış olduk
     */


    }

    @Test
    public void test03() {

        //google sayfasına gidelim
        driver.get("https://google.com");

        // Arama kutusuna "Selenium" yazın ve Enter tuşuna basın
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
            aramaKutusu.sendKeys("Selenium",Keys.ENTER);

        // Sayfayı bekleyin
        bekle(4);

        // Arattığımız kelimeyi arama kutusundan ctrl+x ile keselim
        driver.findElement(By.xpath("//*[@class='gLFyf']")).//sayfa yenilendiği için tekrar locate aldık.
                sendKeys(Keys.CONTROL,"a");//Metni kesebilmemiz için önce CTRL+a ile seçmemiz gerekir.
        driver.findElement(By.xpath("//*[@class='gLFyf']")).
                sendKeys(Keys.CONTROL,"x");//Seçilen metni CTRL+x kestik.

        //Tekrar google sayfasına gidip kestiğimiz kelimeyi ctrl+v ile yapıştırıp tekrar aratalım
        driver.navigate().to("https://google.com");
        driver.findElement(By.xpath("//*[@class='gLFyf']")).
                sendKeys(Keys.CONTROL,"v");//CTRL+ v ile yapıştırdık

    }
}
