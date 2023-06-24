package seleniumJunit.day15_FileExist;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C03_File_UpLoad extends TestBase {
    @Test
    public void fileUpload() {


        // masaustunde bir deneme dosyası olusturun
        //masaüstüne 'deneme' adında dosya oluşturuldu

        // 'https://the-internet.herokuapp.com/upload' adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/upload");

        // 'Dosya Seç' kısmına deneme dosyasını yükleyiniz
        WebElement dosyaSec = driver.findElement(By.xpath("//input[@id='file-upload']"));

        //"C:\Users\Samsung\Desktop\deneme.txt"
        String hersteFarkli = System.getProperty("user.home");
        String hersteAyni = "\\Desktop\\deneme.txt";

        String dosyaYolu = hersteFarkli + hersteAyni;


        dosyaSec.sendKeys(dosyaYolu);

        // 'Upload' butonuna basın
        WebElement upload = driver.findElement(By.id("file-submit"));
        upload.click();

        // 'File Uploaded!' yazısının goruntulendigini test edin
        WebElement fileUploaded = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(fileUploaded.isDisplayed());

    }

}
