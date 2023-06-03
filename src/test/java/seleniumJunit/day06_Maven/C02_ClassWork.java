package seleniumJunit.day06_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_ClassWork {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1.http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        //2.Signin buttonuna tiklayin
        WebElement signinButonu = driver.findElement(By.id("signin_button"));
        signinButonu.click();

        //3.Login alanine "username" yazdirin
        WebElement userName = driver.findElement(By.id("user_login"));
        userName.sendKeys("username"+ Keys.TAB);

        //4.Password alanine "password" yazdirin
        WebElement password = driver.findElement(By.id("user_password"));
        password.sendKeys("password"+ Keys.TAB );

        //5.Sign in buttonuna tiklayin
        WebElement signInbutonu2 = driver.findElement(By.xpath("//*[@type='submit']"));
        signInbutonu2.click();
        driver.navigate().back();

        //6. Online Banking altında Pay Bills sayfasina gidin
        WebElement onlineBankingSekmesi = driver.findElement(By.id("onlineBankingMenu"));
        onlineBankingSekmesi.click();

        WebElement payBillsSayfasi = driver.findElement(By.id("pay_bills_link"));
        payBillsSayfasi.click();

        //7.amount kismina yatirmak istediginiz herhangi bir miktari yazin
        WebElement amounYatir = driver.findElement(By.xpath("//*[@id='sp_amount']"));
        amounYatir.sendKeys("25$" + Keys.TAB);

        //8.tarih kismina "2020-09-10" yazdirin
        WebElement date = driver.findElement(By.cssSelector("input[id='sp_date']"));
        date.sendKeys("2020-09-10");

        //9.Pay buttonuna tiklayin
        WebElement payButonu = driver.findElement(By.xpath("//*[@id='pay_saved_payees']"));
        payButonu.click();

        //10."The payment was successfully submitted." mesajinin ciktigini control edin
        WebElement isSuccesfully = driver.findElement(By.id("alert_content"));
        System.out.println("Succesfully Mesajı Görünür mü? = " + isSuccesfully.isDisplayed());


    }
}
