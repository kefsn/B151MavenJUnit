package seleniumJunit.day11_Iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_iFrame extends TestBase {

    @Test
    public void iFrame() {


            //==>  https://the-internet.herokuapp.com/iframe sayfasına gidiniz
            driver.get("https://the-internet.herokuapp.com/iframe");

          //==>  Kalın yazının "Editor" kelimesini içerdiğini test ediniz
           WebElement kalinYazi = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(kalinYazi.getText().contains("Editor"));

        //==>  textBox içindeki yazıyı siliniz.
        WebElement frameLocate = driver.findElement(By.xpath("//iframe"));
        driver.switchTo().frame(frameLocate);//iframe kullanılarak locate alındı
        /*
        -Iframe'e geçmenin yolu index ile;
        driver.switchTo().frame(0);//index kullanılarak içte ki web sayfaya geçildi
        -Eğer iki tane iframe olsaydı ve eğer 2. Iframe'e geçmek isteseydik
        index'i 1 almam gerekecektir.

        -İframe geçmenin 3. yolu //frame(name or id); secilir ve
        id attribute kopyalanir paranteze yapistirilir
         Örnek : driver.switchTo().frame("mce_0_ifr");
         */

            bekle(3);
        WebElement textBoxYazi = driver.findElement(By.xpath("//p[text()='Your content goes here.']"));
        textBoxYazi.clear();


            //==>  Sildiğiniz yazı yerine "Bu textbox iFrame içinde yer almaktadır" yazınız.
       textBoxYazi.sendKeys("Bu textbox iFrame içinde yer almaktadır");


            //==>  Sayfadaki "Elemental Selenium" yazısının görünür olduğunu doğrulayınız.
        driver.switchTo().defaultContent();

        WebElement elementelSelenium = driver.findElement(By.xpath("//a[text() = 'Elemental Selenium']"));
        Assert.assertTrue(elementelSelenium.getText().contains("Elemental Selenium"));
    }
}
