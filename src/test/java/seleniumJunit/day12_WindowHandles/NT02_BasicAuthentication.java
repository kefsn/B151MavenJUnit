package seleniumJunit.day12_WindowHandles;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class NT02_BasicAuthentication extends TestBase {


    @Test
    public void test01() {


        //Aşağıdaki bilgileri kullanarak authentication yapınız:
        // Url: https://the-internet.herokuapp.com/basic_auth
        //Username: admin
        //Password: admin
        //Başarılı girişi doğrulayın.

        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        bekle(3);

        //Başarılı bir girişten sonra Congratulations! yazısının çıktığını doğrulayın.
        WebElement text = driver.findElement(By.xpath("//p"));
        Assert.assertTrue(text.getText().contains("Congratulations!"));

        //Elemental Selenium yazısına tıklayalım
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());//Açılan yeni pencereye geçtik


        //Başlığın Elemental Selenium olmadığını doğrulayın
        System.out.println("Sayfa Başlığı = " + driver.getTitle());
        Assert.assertNotEquals("Elemental Selenium", driver.getTitle());

        //DropDowndan Java'yı seçelim 'Join the mailing liste' kısmına tıklayın
        WebElement ddm = driver.findElement(By.xpath("//*[@name='fields[programming_language]']"));
        Select select = new Select(ddm);
        select.selectByVisibleText("Java");


    }
}
