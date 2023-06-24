package seleniumJunit.day18_ScreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_TumSayfaResmi extends TestBase {

    /*
    SCREENSHOT
        Selenium'da tüm ekran görüntüsünü alabilmek için TakeScreenShot
        arayüzünden bir obje oluşturup driver'a eşitleriz. Arayüzler farklı olduğu için
        casting yaparız ve bu oluşturduğumuz obje ile getScreenShosAs methodu ile sayfanın
        resmini alırız. Almış olduğumuz resmi projemizde nereye kaydedeceksek oranın yolunu
        belirtiriz.
     */
    @Test
    public void test01() throws IOException {

        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");
        bekle(2);
        //Çıkan reklamı kapatalım
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();


        //Ve ekran görüntüsünü alalım

        /*
        İlk olarak SS aldığımızda nereye kaydetmek istiyorsak oranın yolunu belirtelim.
        İkinci olarak  TakeSceenShot arayüzünden obje oluştur.
         Üçüncü olarak FileUtils class'ından copyFile() methodu ile ts objemizi kullanarak
         getScreenShotAs() methodu ile dosya yolunu belirteceğiz.
         */

        String dosyaYolu = "src/test/java/seleniumJunit/TumSayfaResmi/screenShot.jpeg";
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));


    }

    @Test
    public void test02() throws IOException {


        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");
        bekle(2);
        //Çıkan reklamı kapatalım
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();


        //Ve ekran görüntüsünü alalım

        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File("ScreenShot/screenShot.png"));


    }


    @Test
    public void test03() throws IOException {

        /*
        Kaydettiğimiz ekran resmi her seferinde aynı dosya üzerine yazmaması için
        dosya isminden sonra tarih String bir değişkene tarih formatı atayabiliriz.
         */

        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");
        bekle(2);

        //Çıkan reklamı kapatalım
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();


        //Ve ekran görüntüsünü alalım
        /*
        SimpleDateFormat'ı kullanarak yeni bir tarih formatı oluşturup
        bir String'e assign ederiz.Ve bunu dosya isminden önce blirtiriz.
         */
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "src/test/java/seleniumJunit/TumSayfaResmi/screenShot"+tarih+".jpeg";
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));


    }
    @Test
    public void test04() throws IOException {
        //Techproeducation sayfasına gidelim
        driver.get("https://amazon.com");

        bekle(2);

        //Ve ekran görüntüsünü alalım

        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "src/test/java/techproed/TumSayfaResmi/screenShot" + tarih + ".jpeg";
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));


    }

}
