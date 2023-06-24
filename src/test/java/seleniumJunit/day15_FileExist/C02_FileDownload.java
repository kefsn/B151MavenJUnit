package seleniumJunit.day15_FileExist;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileDownload extends TestBase {
    @Test
    public void fileDownload() {

        //"https://testcenter.techproeducation.com/index.php?page=file-download"   adresine gidin
         driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");

        //"b10 all test cases" dosyasını indirin
        WebElement testCases = driver.findElement(By.xpath("//a[text()='b10 all test cases, code.docx']"));
        testCases.click();


        File silinecekDosya = new File("C:\\Users\\Samsung\\Downloads\\b10 all test cases, code.docx");
        silinecekDosya.delete();


        /*
         File silinecekDosya=new File("/Users/betulsongul/Downloads/b10 all test cases, code.docx") ;
        silinecekDosya.delete();

        Eğer  localinizden otomasyon ile dosya silmek için File class ından obje oluşturup dosya yolunu içine yerleştiririz.
         Ve oluşturduğumuz obje ile delete() methodunu kullanarak silebiliriz.
         Bunu yapma sebebimiz test classımızı çalıştırmada yeni bir dosya indireceği için oradaki dosya kalabalığını önlemiş oluruz
         Aynı zamananda doğrulama yaparken işimizi garantiye almış oluyoruz
         Aynı isimde birden fazla dosya indirmiş olsakta her indirilenin yanına index vereceği için ve bizim ilk indirdiğimiz
         o klasörün içinde bulamayacağı için her zaman ilk dosyanın varlığını böylelikle test etmiş oluruz

            */


        /*
        Dosyanın downloads'a başarıyla indirilip indirilmeidğini Java ile test edeceğiz.
        Çünkü Selenium web sayfasını test eder. Selenium bilgisayarda ki download'a müdahale edemez.

         */

        // Dosyanın başarıyla indirilip indirilmediğini test edin.
        //  C:\Users\Samsung\Downloads\b10 all test cases, code.docx

        //Assert.assertTrue(Files.exists(Paths.get("C:\\Users\\Samsung\\Downloads\\b10 all test cases, code.docx")));

        //Daha dinamik hale getirelim
        String herkesteFarkli = System.getProperty("user.home");
        String herkesyeAyni = "\\Downloads\\b10 all test cases, code.docx";

        String dosyaYolu = herkesteFarkli+herkesyeAyni;
        bekle(2);//dosyayi indirme, silme bulma vs. cok hizli oldugundan assert isleminden önce bi bekle gerekiyor.
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));



    }


}
