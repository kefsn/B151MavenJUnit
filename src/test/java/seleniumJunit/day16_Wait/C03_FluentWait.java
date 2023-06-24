package seleniumJunit.day16_Wait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C03_FluentWait extends TestBase {

    //Fluent Wait: Belirli bir koşul gerçekleşene kadar maxsimumm süre boyunca
    //belirttiğimiz aralıklarla WebElement'i kontrol ederek bekler.


    @Test
    public void fluentWait() {

        //==> https://the-internet.herokuapp.com/dynamic_loading/1 sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //==> Start buttonuna tıklayın
        WebElement start = driver.findElement(By.xpath("//button[text()='Start']"));
        start.click();



        //==> Hello World! yazısının görünürlügünü test edin

        WebElement helloWorld = driver.findElement(By.xpath("(//h4)[2]"));
        Wait<WebDriver> wait = new FluentWait<>(driver).
                withTimeout(Duration.ofSeconds(30)).//FluentWait için maksimum bekleme süresi
                pollingEvery(Duration.ofSeconds(3)).//(3 saniyede kontrol edecek)Kaç saniyede bir webelementi kontrol edeceğimiz sağlar.
                withMessage("Ignore Exception");//Hata durumunda mesaj vermek için kulllanılır.

        wait.until(ExpectedConditions.visibilityOf(helloWorld));

        Assert.assertTrue(helloWorld.isDisplayed());

        /*
            Thread.Sleep(): Javadan gelir. Belirttigimiz sure kadar kodlari bekletir.

            Implicitly Wait: Selenium'dan gelir. Sayfadaki tum webelementlerin yuklenebilmesi icin max bekleme suresidir.

            Explicitly Wait 2'ye ayrilir:

            1.) WebDriver Wait: Belirli bir kosul gerceklesene kadar max sure boyunca,
            default olarak 500ms araliklarla webelementi kontrol ederek bekler.

            2.) Fluent Wait: Belirli bir kosul gerceklesene kadar max sure boyunca,
            belirttigimiz araliklarla webelementi kontrol ederek bekler.
        */

    }
}
