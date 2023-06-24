package seleniumJunit.automationExcercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class ders01ResgisterUser {

    WebDriver driver;
    @Before
    public void setUp() throws Exception {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }

    @After
    public void tearDown() throws Exception {
       // driver.close();
    }


    @Test
    public void test01() {

//       1. Launch browser




//        2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");

//        3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//*[@style='color: orange;']"));
        Assert.assertTrue(homePage.isDisplayed());


//        4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();

//        5. Verify 'New User Signup!' is visible
        WebElement newSignUp = driver.findElement(By.xpath("(//h2)[3]"));
        Assert.assertTrue(newSignUp.isDisplayed());


//        6. Enter name and email address
        //        7. Click 'Signup' button
        driver.findElement(By.name("name")).sendKeys("Ali Osman", Keys.TAB,"aliosman11111.tb@gmail.com",Keys.TAB,Keys.ENTER);


//        8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement account = driver.findElement(By.xpath("//b"));
        Assert.assertTrue(account.isDisplayed());


//        9. Fill details: Title, Name, Email, Password, Date of birth
        WebElement radioButon = driver.findElement(By.id("id_gender1"));
        radioButon.click();
        radioButon.sendKeys(Keys.TAB,"Mustafa",Keys.TAB,"Password", Keys.TAB);

       WebElement ddm = driver.findElement(By.id("days"));
        Select select = new Select(ddm);
        select.selectByIndex(4);

        ddm.sendKeys(Keys.TAB,"May",Keys.TAB,"2021");

//        10. Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.cssSelector("input[id='newsletter']")).click();

//        11. Select checkbox 'Receive special offers from our partners!'
      WebElement checkBox =  driver.findElement(By.cssSelector("input#optin"));
      checkBox.click();


//        12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        //        13. Click 'Create Account button'
        checkBox.sendKeys(Keys.TAB,"Efe",Keys.TAB,"Can",Keys.TAB,"TAB Company",Keys.TAB,"Adıyaman/Trabzon",Keys.TAB,"Manisa California",Keys.TAB,"Canada",
        Keys.TAB,"Miami",Keys.TAB,"Ohai",Keys.TAB, "61300",Keys.TAB,"55555555555",Keys.TAB,Keys.ENTER);





//        14. Verify that 'ACCOUNT CREATED!' is visible
        WebElement createdAccount = driver.findElement(By.xpath("//b"));
        Assert.assertTrue(createdAccount.isDisplayed());

//        15. Click 'Continue' button
       // driver.findElement(By.className("btn btn-primary")).click();
        driver.findElement(By.linkText("Continue")).click();

       // driver.findElement(By.xpath("//*[text()='Close']")).click();

//        16. Verify that 'Logged in as username' is visible
        WebElement userName = driver.findElement(By.xpath("(//li)[10]"));



//        17. Click 'Delete Account' button
        driver.findElement(By.xpath("//*[text()=' Delete Account']")).click();

//        18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        WebElement deletedAccount = driver.findElement(By.xpath("//b"));
        Assert.assertTrue(deletedAccount.isDisplayed());


    }
}
