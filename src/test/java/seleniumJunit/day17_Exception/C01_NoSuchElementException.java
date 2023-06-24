package seleniumJunit.day17_Exception;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_NoSuchElementException extends TestBase {

    @Test
    public void noSuchElementException() {

    /*
    NoSuchElementException :
    Sayfada bulunmayan bir elemente erişim sağlanmaya çalışıldığında
    NoSuchElementException hatası alırız.
     */
        /*
        org.openqa.selenium.InvalidSelectorException: xpath ile aldigimiz bir webelementin locate'ini
        cssSelector locator ile kullanirsak bu exception'i aliriz
         */

     //techproeducation sayafasına gidelim
        driver.get("https://techproeducation.com");
        bekle(3);

        //reklamı kapatınız
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        bekle(2);

        //searchBox'a java yazıp aratalım
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='elementor-search-form-9f26725']"));
        searchBox.sendKeys("java", Keys.ENTER);


    }
}
