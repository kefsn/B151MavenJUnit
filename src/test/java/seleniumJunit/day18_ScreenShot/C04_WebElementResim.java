package seleniumJunit.day18_ScreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C04_WebElementResim extends TestBase {
    /*
    Bir webelementin resmini almak için önce WebElementi locate edip bir webelemente assign ederiz.
    Ve bu webelementi direk get ScreenShotAs() methhodunu kullanarak resmini belirttiğimiz dosyaya kaydederiz.

     */

    @Test
    public void name() throws IOException {

        //amazon sayfasına gidelim
        driver.get("https://amazon.com");

        bekle(2);

        //İphone aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

        //Çıkan sonuc yazısını resmini alalım
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "src/test/java/seleniumJunit/WebElemenResmi/screenShot" + tarih + ".jpeg";
        FileUtils.copyFile(sonucYazisi.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));

    }
}
