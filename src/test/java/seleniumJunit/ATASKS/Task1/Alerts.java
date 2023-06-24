package seleniumJunit.ATASKS.Task1;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Alerts extends TestBase {

    @Test
    public void alert() {

//        -http://demo.automationtesting.in/Alerts.html sayfasına gidiniz
        driver.get("http://demo.automationtesting.in/Alerts.html");

//        -Alert with OK karşısındaki click the button to display an alert box: butonuna tıklayınız
        WebElement buttonToDisplay = driver.findElement(By.xpath("//button[@class='btn btn-danger']"));
        buttonToDisplay.click();


//        -Çıkan alert üzerindeki yazıyı konsola yazdırınız ve tamam butonuna basınız
        System.out.println("Alert yazısı - 1 = " + driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

//                -Alert with OK & Cancel butonuna basınız ve sonrasında click the button to display a confirm box butonuna basınız
                WebElement alertWİthOK = driver.findElement(By.className("analystic"));
                alertWİthOK.click();

                driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();

//                -Çıkan alert'te iptal butonuna basınız
        driver.switchTo().alert().dismiss();

//                -Alert with Textbox butonuna basınız ve sonrasında click the button to demonstrate the prompt box butonuna basınız
            driver.findElement(By.xpath("(//a[@class='analystic'])[3]")).click();
            driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();

//        -Çıkan prompt box'a 'isminizi' yazdırınız ve Tamam'a basınız
       driver.switchTo().alert().sendKeys("Efe");
       driver.switchTo().alert().accept();

//        -Çıkan mesajı konsola yazdırınız
       WebElement yazi =  driver.findElement(By.id("demo1"));
        System.out.println("Sonuç Yazısı = " + yazi.getText());

//                -Çıkan mesajın 'Hello <isminiz> How are you today' yazdığını doğrulayınız
//
    }
}
