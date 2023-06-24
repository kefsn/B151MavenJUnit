package seleniumJunit.day16_Wait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_ExplicitWait extends TestBase {


    @Test
    public void test01() {

        //==>  https://the-internet.herokuapp.com/dynamic_controls sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //==>  Remove tuşuna basın
        WebElement removeButton = driver.findElement(By.xpath("//button[text()='Remove']"));
        removeButton.click();


        //==>  "It's gone!" yazısının görünür oldugunu test edin.
        WebElement itsGone = driver.findElement(By.id("message"));
        Assert.assertTrue(itsGone.isDisplayed());

    }
}
