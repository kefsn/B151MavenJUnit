package seleniumJunit.day10_TestBase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C03_Alerts extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        //https://demoqa.com/alerts adresine gidelim
        driver.get("https://demoqa.com/alerts");

        //Click Button to see alert karşısındaki butona tıklayalım
        driver.findElement(By.xpath("(//button)[2]")).click();
        bekle(2);

        //Çıkan Alert'te You clicked a button yazısının çıktığını doğrulayalım
        System.out.println("Alert Uzerindeki Yazi : "+getTextAlert());//-->TestBase class'ında oluşturmuş olduğumuz method
        Assert.assertEquals("You clicked a button",getTextAlert());
        bekle(2);

        //Ve alert'ü kapatalım
        acceptAlert();//-->TestBase class'ında oluşturmuş olduğumuz method
    }

    @Test
    public void test02() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        //On button click, confirm box will appear karşsindaki buttona basalım
        driver.findElement(By.xpath("(//button)[4]")).click();
        bekle(2);
        //Çıkan alertte iptal'e basalım
        dismissAlert();

        //sonuc yazısında You selected Cancel yazdığını doğrulayalım
        String sonucYazisi = driver.findElement(By.id("confirmResult")).getText();
        Assert.assertEquals("You selected Cancel",sonucYazisi);

    }

}
