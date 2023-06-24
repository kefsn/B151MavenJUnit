package seleniumJunit.day19_ExtentReports_WebTables;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_ExtentReport extends TestBase {
    /*

    EXTENTREPORT;
    1-Extentreport(aventStack) kullanabilmek için, öncelikle mvn adresinden 4.0.9 versiyon
    numaralı dependency'i pom.xml'e dosyamızı ekleriz.
    2-Extentreport class'ından obje atamasını class seviyesinde obje oluşturulur.
    3-ExtentHtmlReporter class'ından obje atamasını class seviyesinde obje oluşturulur.
    4-ExtentTest class'ından obje atamasını class seviyesinde obje oluşturulur.
     */

    ExtentReports extentReports;//Raporlamayı başlatmak için kullanılan class.
    ExtentHtmlReporter extentHtmlReporter;//Raporu HTML formatında düzenler.
    ExtentTest extentTest;//Test adımlarına eklemek istediğimiz bilgileri bu class'la oluşturulur.

    @Test
    public void test01() {

        extentReports = new ExtentReports();
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "testOutput/extentReports/extentReport" + tarih + ".html";
        extentHtmlReporter = new ExtentHtmlReporter(dosyaYolu);
        extentReports.attachReporter(extentHtmlReporter);//HTML formatında raporlamayı başlatacak

        //raporda gözükmesini istediğimiz bilgiler için
        extentReports.setSystemInfo("Browser", "Chrome");
        extentReports.setSystemInfo("Tester", "Mrt");
        extentHtmlReporter.config().setDocumentTitle("Extent Report");
        extentHtmlReporter.config().setReportName("Smoke Test Raporu");

        extentTest = extentReports.createTest("ExtenTest", "Test Raporu");

         /*
    Testlerimiz bittiginde bizden bir rapor istenebilir. Karsimizdaki teknik terimleri bilmeyebilir ama Extent Class' larini kullanrak
    raporla ilgili bilgileri rapora ekleyebiliriz
     */

        //amazon sayfasına gidelim
        driver.get("https://amazon.com");
        extentTest.info("Amazon sayfasına gidildi");

        //Başlığın Amazon içerdiğini test edelim
        Assert.assertTrue(driver.getTitle().contains("Amazon"));
        extentTest.info("Başlığın Amazon içerdiğini test edin");

        //arama kutusunda iphone aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
        extentTest.info("Arama kutusunda iphone aratıldı");


        //Sonuç yazısını konsola yazdıralım
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        System.out.println("sonucYazisi.getText() = " + sonucYazisi.getText());
        extentTest.info("Sonuç Yazısı konsola yazdırıldı");
        extentTest.pass("Sayfa kapatıldı");
        /*
        extentTest objesi ile info() methodunu kullanarak her stepde
        ne yaptığımız ile alakalı bilgi yazabiliriz. Testimizin en sonunda
        testin bittiğini ifade eden pass() methodu ile testimiz ile alakalı son bilgiyi ekleyebiliriz.
           Ve son olarak actions daki perform() methodu gibi extentReport objesi ile flush() methodu
            kullanarak raporo sonlandırırız.
         */

        extentReports.flush();//Bu method kullanılmazsa raporumuz oluşmaz.

    }
}
