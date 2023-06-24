package seleniumJunit.day15_FileExist;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_FileExist extends TestBase {

    /*
        Selenium herhangi bir dosyanin inip inmedigini kontrol edemeyiz.
        Selenium sadece web sayfasini kontrol eder windows uygulamalarini test edemez, bu sebeple java kullaniriz.
        dosya mevcutlugunu java kontrol edebilir.
        Selenium web sayfasina gidebilir, linke tiklayabilir, dosyayi indirebilir.
        Dosya indigi anda Java dosyaya müdahale edebilir. Selenium edemez.
    */

    @Test
    public void fileExist() {

        System.out.println("İçinde Bulunduğumuz Dosya Yolu = " + System.getProperty("user.dir"));//C:\Users\Samsung\Desktop\GitProjects\B151MavenJUnit
        //System.getProperty("user.dir"));  Bana içindde bulunduğum projenin dosya yolunu verir.


        System.out.println("Herkesin Bilgisayarında Farklı Olan kısım = " + System.getProperty("user.home"));//C:\Users\Samsung
        //System.getProperty("user.home")); Herkesin bilgisayarında farklı olan kısmı verir.

        // Desktop(masaustu)'da bir text dosyası olusturun
            /*
            dosanin,bilgisayarimda desktop'da olup olmadigini
            Java ile test edecegim
            Cunku selenium, web sayfalarini test eder.
            Selenium,benim bilgisayarimdaki desktop'a mudahele edemez
             */


        // Desktop(masaustu)'da text dosyasının olup olmadıgını test edin
        //  "C:\Users\Samsung\Desktop\text.txt"
        Assert.assertTrue(Files.exists(Paths.get("C:\\Users\\Samsung\\Desktop\\text.txt")));



        //Daha dinamik hale getirelim
        //  "C:\Users\Samsung   \Desktop\text.txt"

      String farkliKisim = System.getProperty("user.home");
      String ortakKisim = "\\Desktop\\text.txt";

      String dosyaYolu = farkliKisim+ortakKisim;
      Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }
}

