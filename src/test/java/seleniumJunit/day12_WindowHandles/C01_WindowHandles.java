package seleniumJunit.day12_WindowHandles;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.util.Set;

public class C01_WindowHandles extends TestBase {


    @Test
    public void windowHandles() {

        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //  ilk sayfasının Handle degerini alın yazdırın

        String sayfa1Handle = driver.getWindowHandle();
        System.out.println("İlk Sayfanın Handle Değeri = " + sayfa1Handle);

        //  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
        WebElement ilkSayfa = driver.findElement(By.xpath("//h3"));


        Assert.assertEquals("Opening a new window", ilkSayfa.getText());

        //  ilk sayfa Title'ının "The Internet" olduğunu test edin.
        String ilkSayfaTitle = driver.getTitle();
        Assert.assertEquals("The Internet", ilkSayfaTitle);
        System.out.println("İlk sayfa Title = " + ilkSayfaTitle);

        //  "Click Here" butonuna tıklayın.
        driver.findElement(By.linkText("Click Here")).click();

        //  ikinci sayfa Title'ının "New Window" olduğunu test edin.
        Set<String> windowHandlesSeti = driver.getWindowHandles();//Bütün sekmelerin handle değerini almak için 'handles' kullandık.
        System.out.println("Window Handles Seti = " + windowHandlesSeti);

        /*
        Eğer bir butona tıkladığımızda bizim kontrolümüz dışında 2. Sayfa  açılıyorsa,
        otomatik açılan 2.sayfa ya driver'i geçirmemiz gerekir.
        2.Sayfa'ya driver'ı geçirebilmemiz için 2. sayfayanın handle değerini bulmalıyız.
        getWindowHandles(): methodu sayesinde 2.sayfanın handle değerini tespit edebiliriz.
        daha sonra driver.switchTo().window(sayfa2Handle); diyerek 2. sayfaya  driver'ı geçirebiliriz.
         */

        String sayfa2HandleDegeri = "" ;
        for (String w : windowHandlesSeti){
            if (w.equals(sayfa1Handle)){
                continue;
            }else {
                sayfa2HandleDegeri = w;
                System.out.println("Sayfa 2 Handle : "+ w);
            }
        }

      /*
       LAMBDA EXPRESSİON;
       windowHandlesSeti.
                stream().
                filter(t->!t.equals(sayfa1Handle)).
                forEach(t-> System.out.println("2.Sayfa Handle değeri : "+t));
*/

        driver.switchTo().window(sayfa2HandleDegeri);

        String ikinciSayfaTitle = driver.getTitle();
        Assert.assertEquals("New Window",ikinciSayfaTitle);

        //  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
        driver.switchTo().window(sayfa1Handle);
        Assert.assertEquals("The Internet",driver.getTitle());

        //  ikinci sayfaya tekrar geçin.
        driver.switchTo().window(sayfa2HandleDegeri);


        //  ilk sayfaya tekrar dönün.
        driver.switchTo().window(sayfa1Handle);

    }
}
