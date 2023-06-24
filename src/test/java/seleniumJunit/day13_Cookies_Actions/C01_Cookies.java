package seleniumJunit.day13_Cookies_Actions;

import com.google.common.base.Supplier;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class C01_Cookies extends TestBase {


    @Test
    public void test01() {

        //1-Amazon anasayfaya gidin
        driver.navigate().to("https://amazon.com");

        //2-tum cookie’leri listeleyin
        /*
        Cooki'leri listelemek istersek,
        driver.manage().getCookies() methoduyla bir set ya da
        arrayList'e atarak listeleyebiliriz.
         */

        //Lambda Cookies yazımı
        // Arrays.stream(driver.manage().getCookies().toArray()).forEach(System.out::println);
        Set<Cookie> cookieSet = driver.manage().getCookies();
        int sayac = 1;
        for (Cookie w : cookieSet) {
            System.out.println(sayac + ".ci cookie :" + w);
            System.out.println(sayac + ".ci cookieName :" + w.getName());// -->Sadece cookie lerin ismini alırız
            System.out.println(sayac + ".ci cookieValue :" + w.getValue());// -->Sadece cookie lerin value larını alırız

            sayac++;
        }

        //3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        System.out.println("Cookies Sayısı = " + cookieSet.size());
        Assert.assertTrue(cookieSet.size() > 5);


        //4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        String actualCookieValue = driver.manage().getCookieNamed("i18n-prefs").getValue();
        String expectedCookiealue = "USD";
        Assert.assertEquals(expectedCookiealue, actualCookieValue);
        //getCookieNamed() methodu ile bize verilen cookie isminin getValue()
        // methoduyla gercek degerini actualCookieValue degiskenine assign ettik

        // 5-ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie  olusturun ve sayfaya ekleyin
        Cookie enSevdigimCookie = new Cookie("en sevdigim cookie", "cikolatali");
        driver.manage().addCookie(enSevdigimCookie);


        //6-eklediginiz cookie’nin sayfaya eklendigini test edin
        cookieSet = driver.manage().getCookies();

        for (Cookie w : cookieSet){
            System.out.println(w);
        }
        Assert.assertEquals("cikolatali", driver.manage().getCookieNamed("en sevdigim cookie").getValue());
        System.out.println("Cookie'lerin sayisi = "+cookieSet.size());
        //2.Way Lambda ile sayısını bulmak.
        System.out.println("Cookie'lerin sayisi = "+Arrays.stream(driver.manage().getCookies().toArray()).count());


        //7-ismi skin olan cookie’yi silin ve silindigini test edin
       int silinmedenOnce = cookieSet.size();
        System.out.println("Silinmeden Once Cookies Sayısı = " + silinmedenOnce);

        driver.manage().deleteCookieNamed("skin");//ismi skin olan cookie silindi
        cookieSet = driver.manage().getCookies();//Silindikten sonra cookieSet'e yine atama yapiyoruz aksi taktirde fail aliriz

        int silindiktenSonra = cookieSet.size();
        System.out.println("Silindikten Sonra Cookies Sayısı = " + silindiktenSonra);

        Assert.assertEquals(1,(silinmedenOnce-silindiktenSonra));


        //8-tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();//Tüm cookileri sildik
        cookieSet = driver.manage().getCookies();//Tekrar cooki seti güncelledik
        Assert.assertTrue(cookieSet.isEmpty());//Ve cookiSetin içinin boş olduğunu isEmpty ile test ettik

    }
}
