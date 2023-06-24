package seleniumJunit.day11_Iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C03_WindowHandle extends TestBase {


    @Test
    public void windowHandle() {

         //  https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");

        /*
        techproducation sayfasının handle değerini getWindowHandle();
        methodu ile elde edebiliriz.
         */
        String techProWindowHandle = driver.getWindowHandle();
        System.out.println("TechPro Window Handle = " + techProWindowHandle);
        //TechPro Window Handle = 5FFBEFB7C91B7A0ABCB5ADB06C37B57B

        //  Title'ın "Techpro Education | Online It Courses & Bootcamps" olduğunu test edin
        String actualTitle = driver.getTitle();
        String expectedTitle = "Techpro Education | Online It Courses & Bootcamps";
        Assert.assertEquals(expectedTitle,actualTitle);

        //  Yeni bir pencere acıp,  https://www.youtube.com sayfasına gidiniz
            driver.switchTo().newWindow(WindowType.WINDOW);//Yeni bir pencereye driver'ı taşır.

            driver.get("https://www.youtube.com");
          String youtubeWindowHandle = driver.getWindowHandle();
        System.out.println("Youtube Window Handle = " + youtubeWindowHandle);
            //Youtube Window Handle = 8A5450A3985192707AE9890C796EE9A0

        //  Yeni bir pencere acıp, https://www.linkedin.com sayfasına gidiniz
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com");
       String linkedinWindowHandle =  driver.getWindowHandle();
        System.out.println("Linkedin Window Handle = " + linkedinWindowHandle);
        //Linkedin Window Handle = DE6D76CEE5A378B624B014A9313800BB

        //  techproeducation sayfasına geçiniz
        driver.switchTo().window(techProWindowHandle);

        //  youtube sayfasına geçiniz
        driver.switchTo().window(youtubeWindowHandle);

        //  linkedIn sayfasına geçiniz:
        driver.switchTo().window(linkedinWindowHandle);

    }
}
