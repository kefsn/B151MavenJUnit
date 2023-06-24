package seleniumJunit.day16_Wait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_ExplicitWait extends TestBase {

    @Test
    public void explicitWait() {



        //==> https://the-internet.herokuapp.com/dynamic_loading/1 sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //==> Start buttonuna tıklayın
        WebElement start = driver.findElement(By.xpath("//button[text()='Start']"));
        start.click();


        //1. Way;

        WebElement helloWorld = driver.findElement(By.xpath("(//h4)[2]"));

        visibleWait(helloWorld,10);//TestBase'de bulunan visibleWait() reuseable methodu çağırdık.

        Assert.assertTrue(helloWorld.isDisplayed());



    }
}
