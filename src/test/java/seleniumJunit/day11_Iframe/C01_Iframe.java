package seleniumJunit.day11_Iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_Iframe extends TestBase {
    @Test
    public void iFrame() {

        //==>   https://testcenter.techproeducation.com/index.php?page=iframe
       driver.navigate().to("https://testcenter.techproeducation.com/index.php?page=iframe");

        //==>  Ana sayfadaki 'An iframe with a thin black border:' yazısının 'black border' icerdigini test edin
        WebElement iframe = driver.findElement(By.xpath("(//p)[1]"));
        String actual = iframe.getText();
        String expected = "black border";

        Assert.assertTrue(actual.contains(expected));

        //==>  icteki web sayfasında 'Applications lists' yazisinin görünür oldugunu test edelim
         WebElement iFrame  = driver.findElement(By.xpath("//iframe[@style='border:1px solid black;']"));
        driver.switchTo().frame(iFrame);

        /*
        -Applications lists yazısını doğru locate edip,
        doğru şekilde görünür olduğunu test etmemize rağmen Failed oldu.
        Bunun üzerine HTML kodlarını izleyince 'Applications lists' yazısının aslında
        bir 'iframe' içerisinde olduğunu gördük. Bu durumda
        önce iframe'i locate edip switchTo() ile 'iframe'e geçmeliiyiz.

         */

        WebElement aplicationList = driver.findElement(By.xpath("//*[text()='Applications lists']"));
        Assert.assertTrue(aplicationList.isDisplayed());

        //==>   Ana sayfadaki'Povered By' yazisinin "Povered" icerdigini test edin
        //parentFrame() methodu ile driver'ı dıştaki web sayfaya çıkartacağız
        driver.switchTo().defaultContent();//parentFrame() dışında defaultContent() methoduda kullanılabilir.

        WebElement poverBy = driver.findElement(By.xpath("//p[text()='Povered By']"));
        Assert.assertTrue(poverBy.getText().contains("Povered"));

    }


}
