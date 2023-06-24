package seleniumJunit.day09_DropDown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class C02_DropDown {

    /*
    - getFirstSelectedOption() ==> DropDown da ki en son seçtiğimiz
    opsiyonu bize döndürür.

    -getOptions() ==> dropDown'daki tüm optionları bize döndürür.

     */

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() throws Exception {
        //driver.close();
    }

    @Test
    public void name() {

        // https://testcenter.techproeducation.com/index.php?page=dropdown sayfasına gidiniz
            driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");

        // Select a State Dropdown'undan "Arizona" seciniz
        WebElement ddmSelectAState = driver.findElement(By.id("state"));
        Select select = new Select(ddmSelectAState);
        select.selectByVisibleText("Arizona");
        select.selectByVisibleText("Alaska");
        select.selectByVisibleText("Alabama");

        System.out.println("Get First Select Option = " + select.getFirstSelectedOption().getText());


        // Select a State Dropdown'undan son secilen option'un "Arizona" oldugunu test ediniz
       /* WebElement sonSecilenOpsiyon = select.getFirstSelectedOption();//Son seçilen opsiyonu getText() methodu ile String hale getirdik
        String sonSecileOpsiyonStr = sonSecilenOpsiyon.getText();
                Assert.assertEquals("Arizona", sonSecileOpsiyonStr);
*/

                  // Select a State Dropdown'undaki tum optionları konsolda yazdırınız
        //1.Yol
        List<WebElement> tumOpsiyonlar = select.getOptions();
        for (WebElement w : tumOpsiyonlar){
            System.out.println(w.getText());
        }




        //2. Way çalışmadı tekrar BAK ITERATORLARA

      /*  List<WebElement> tumOpsiyonlar2 = driver.findElements(By.xpath("//select[@id='state']"));

          ListIterator opsiyonlar = tumOpsiyonlar2.listIterator();

          while (opsiyonlar.hasNext()){

              Object hepsi  = opsiyonlar.next() ;

              opsiyonlar.add(hepsi);

              System.out.println(hepsi);
          }
        System.out.println(tumOpsiyonlar2);*/



    }
}
