package seleniumJunit.day17_Exception;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_TimeOutException extends TestBase {

    @Test
    public void TimeOutException() {

        /*
        TimeOutException:
        Sayfada aradığımız elementi wait ile belirttiğimiz maximum sürede
        bulamadığı durumda TimeOutException hatası alırız.
         */
        //techproeducation sayafasına gidelim
        driver.get("https://techproeducation.com");
        bekle(3);

        //reklamı kapatınız
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();


        //serachBox görünür oluncaya kadar bekleyin
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='elementor-search-form-9f26725']"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(searchBox));

        /*
        TimeOUtException alabilemek için visibilityOfElementLocated methodunu kullanarak
        yanlış bir locate aldık,WebElement'i beklerken o webelementin locate'İni bulamadığı için
        maximum belirttiğimiz süre kadar bekledi ve TimeOutException hatasını verdi.
         */

        /*
            TimeOutException:
            Explicit wait kullanildiginda, ve element bulunamadiginda
            alinir.
            Explicit wait & yanlis locator-> timeout
            Explicit wait & doğru locator & sure yeterli degil -> timeout
            Explicit wait & dogru locator & sure yeterli & iframe var ->
            time out


                        Solution:
            -Sureyi arttirmak
            -Farkli explicit kullanmak: wait visibilityOfElementLocated
            YERINE presenceOfElementLocated. Yada javascript executor
            da ki waiter sayfa geçişlerini beklemek icin kullanabilirim
            -Locatori tekrar kontrol etmek
            -Frameworkunde hazir reusable method lar var Bu durumda
            timeoutexception aldigimda hızlıca o metotlar yardımıyla
            problemi cozebiliyoruz

 */


    }


    @Test
    public void TimeOutExceptionTest2() {


        //https://the-internet.herokuapp.com/dynamic_loading/1 sayfasına gidiniz.
         driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        // Start butonuna tıklayınız
        driver.findElement(By.xpath("//button[text()='Start']")).click();

        //Hello World! yazısının görünürlüğünü test ediniz.

        WebElement helloWorldYAzi = driver.findElement(By.xpath("//h4[text()='Hello World!']"));

        WebDriverWait wait2 = new WebDriverWait(driver,Duration.ofSeconds(1));
        wait2.until(ExpectedConditions.visibilityOf(helloWorldYAzi));

        Assert.assertTrue(helloWorldYAzi.isDisplayed());

        /** Start butonuna bastiktan sonra neredeyse 6sn sonra yazi görünür. Biz burda o süreden daha az süre belirleiz
         ve bilerek hata aliriz. !!! TIMEOUTEXCEPTION

         Gercekte Hello World! yazisi ortalama 6sn sonra gözüküyor TimeOutException alabilmek icin Explicit Wait'e
         max. bekleme süresini 1 sn verdik. Bu sebeple; TimeOutException hatasi almis olduk.
         */

    }
}
