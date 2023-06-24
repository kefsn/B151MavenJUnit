package seleniumJunit.day17_Exception;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Nt02_TimeOutException extends TestBase {

    @Test
    public void timeOutExceptin() {
/*
Yukardaki örnekte max. süreyi doğru vermemize rağmen yanlis locate aldığımız için yine
org.openqa.selenium.TimeoutException hatası alırız. Dolayısıyla bu exception'ı handle edebilmek için
locate'i doğru almalıyız
 */

        //https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver adresine gidelim
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");

        //CheckBox yazan buttona tıklayalım
        driver.findElement(By.xpath("//*[@id='checkbox']")).click();

        //checkBox'ın seçili olduğunu doğrulayalım(CheckBox'ı locate etmeliyiz)
        WebElement checkBox = driver.findElement(By.xpath("//*[@id='ch']"));
        Assert.assertTrue(checkBox.isSelected());




    }
}
