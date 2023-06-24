package seleniumJunit.day17_Exception;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C04_StaleElementReferanceException extends TestBase {


    /*
    StaleElementReferanceException:
    Bir web sayfasında ki bir web elementin geçerliliğinin kaybolduğu durumlarda oluşur.
    Yani bir webelementi locate ettikten sonra , sayfada refresh() ya da back(), forward(), kullanıyorsak
    yeniden o elemana ulaşmak istediğimizde StaleElementsReferanceException hatasını alırız.
    Bunu handle edebilmek için, webelemente yeniden aynı locate'i atamalıyız.(web elemente locati hatırlatma denilebilir)


     */


    @Test
    public void staleElementReferanceException1() {

        //techproeducation sayfasına gidelim.
        driver.get("https://techproeducation.com");

        // reklamı kapatalım
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        //sayfayı yenileyelim
        driver.navigate().refresh();
        driver.navigate().refresh();
        //navigate'den sonraki
        // locate'ler bayatlar ve tekrar kullanamayiz.

        //LMS login butonuna tıklayalım
        driver.findElement(By.xpath("(//a[@class='elementor-item'])[5]")).click();


    }
}
