package seleniumJunit.day17_Exception;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_NullPointerException  {

    /*
    NullPointerException:

    degisken yada obje olusturup bu degiskene atama yapmadigimizda yada esitlemedigimizde
    NullPointerException hatasi aliriz.
     */

    WebDriver driver;
    Faker faker ;
    Actions actions;
    Integer sayi;
    String isim;

    @Test
    public void nullPointerException() {
// driver = new ChromeDriver(); atamasını
// yapmadıgımız icin NullPointerException hatasını aldık.
     driver.get("https://amazon.com");



    }

    @Test
    public void nullPointerException2() {
// faker = new Faker(); atamasını
// yapmadıgımız icin NullPointerException hatasını aldık.

        System.out.println(faker.name().firstName());

    }

    @Test
    public void nullPointerException3() {
// actions = new Actions(); atamasını
// yapmadıgımız icin NullPointerException hatasını aldık.

        actions.doubleClick().perform();

    }

    @Test
    public void nullPointerException4() {
//Integer sayi=6; sayi deegiskenine aatama yapmadigmiz
// icin NullPointerException hatasi aldik
        System.out.println(sayi+5);

    }

    @Test
    public void nullPointerException5() {
    //isim="Efe"; isim degiskenine atama yapilmadigi icin NullPointerException hatasini aldik
        System.out.println(isim.charAt(0));

    }
}
