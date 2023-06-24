package seleniumJunit.day10_TestBase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_Alert extends TestBase {


    /*
    https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.

    Bir metod olusturun: acceptAlert
    1. butona tıklayın,
    uyarıdaki OK butonuna tıklayın
    ve result mesajının "You successfully clicked an alert" oldugunu test edin.

    Bir metod olusturun: dismissAlert
    2. butona tıklayın,
    uyarıdaki Cancel butonuna tıklayın
    ve result mesajının "successfuly" icermedigini test edin.

    Bir metod olusturun: sendKeysAlert
    3. butona tıklayın,
    uyarıdaki mesajı konsolda yazdırın,
    uyarıdaki metin kutusuna isminizi yazin,
    OK butonuna tıklayın
    ve result mesajında isminizin görüntülendiğini doğrulayın.

     */

    @Test
    public void acceptAlert() throws InterruptedException {

        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        //    Bir metod olusturun: acceptAlert
        //    1. butona tıklayın,
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

        Thread.sleep(2000);



        //    uyarıdaki OK butonuna tıklayın
        driver.switchTo(). // Gecmek,Degistirmek
                alert().   // Alert'e gecis yaptı
                accept();  // cıkan uyarıda OK yada TAMAM butonuna basar


        Thread.sleep(2000);


        //    ve result mesajının "You successfully clicked an alert" oldugunu test edin.
        String actuelResult = driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expectedResult = "You successfully clicked an alert";

        Assert.assertEquals(expectedResult,actuelResult);



    }


    @Test
    public void dismissAlert() throws InterruptedException {

        //   Bir metod olusturun: dismissAlert

        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        Thread.sleep(2000);

        //    2. butona tıklayın,
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        Thread.sleep(2000);

        //    uyarıdaki Cancel butonuna tıklayın
        driver.switchTo().alert().dismiss();

        //    ve result mesajının "successfuly" icermedigini test edin.
       String actualResult = driver.findElement(By.id("result")).getText();
       String expectedResult = "successfuly";

       Assert.assertFalse(actualResult.contains(expectedResult));





    }

    @Test
    public void sendKeysAlert() {


        //Bir metod olusturun: sendKeysAlert
        //url gidin

        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");


        //3. butona tıklayın,
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();

        //uyarıdaki mesajı konsolda yazdırın,
        System.out.println("Alert uyarıdaki mesaj = " + driver.switchTo().alert().getText());

        //uyarıdaki metin kutusuna isminizi yazin,
        driver.switchTo().alert().sendKeys("Ya Sabır...");


          //OK butonuna tıklayın
        driver.switchTo().alert().accept();


        //ve result mesajında isminizin görüntülendiğini doğrulayın.
        String actual = driver.findElement(By.id("result")).getText();
        String expected = "Ya Sabır...";

        Assert.assertTrue(actual.contains("Ya Sabır..."));

    }
}
