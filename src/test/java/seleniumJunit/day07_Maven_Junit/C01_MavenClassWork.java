package seleniumJunit.day07_Maven_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_MavenClassWork {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        // Signin buttonuna tiklayin
        WebElement signinButonu = driver.findElement(By.id("signin_button"));
        signinButonu.click();

        // Login alanina  "username" yazdirin,Password alanine "password" yazdirin
        WebElement login = driver.findElement(By.id("user_login"));
        login.sendKeys("username", Keys.TAB, "password");

        // Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//*[@type='submit']")).click();

        // Güvenlik problemini gecmek icin sayfada bir geri gelin
        driver.navigate().back();

        // Online Banking bölümüne tıklamalın
        driver.findElement(By.id("onlineBankingMenu")).click();

        // Pay Bills yazan kısıma tıklayın
       driver.findElement(By.id("pay_bills_link")).click();

        // Amount kismina yatirmak istediginiz herhangi bir miktari yazin
        // Date kismina "2020-09-10" yazdirin
        driver.findElement(By.id("sp_amount")).sendKeys("50", Keys.TAB, "2020-09-10" );


        // Pay buttonuna tiklayin
        driver.findElement(By.id("pay_saved_payees")).click();

        // "The payment was successfully submitted." mesajinin ciktigini test edin
        WebElement isSuccesfull = driver.findElement(By.xpath("//*[@id='alert_content']"));
        System.out.println("The payment was successfully submitted görünür mü? = " + isSuccesfull.isDisplayed());

        // Sayfayi kapatın
        driver.close();




    }
}
