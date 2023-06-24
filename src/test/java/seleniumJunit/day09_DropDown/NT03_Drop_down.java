package seleniumJunit.day09_DropDown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class NT03_Drop_down {
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }

    /*
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://amazon.com/");
    }

    WebElement ddm;
    Select select;

    @Test
    public void test01() throws InterruptedException {
//        -Arama Kutusundaki Dropdown menuyu yazdıralım
        ddm = driver.findElement(By.cssSelector("[id='searchDropdownBox']"));
        select = new Select(ddm);
        List<WebElement> dropdownMenu = select.getOptions();
        dropdownMenu.forEach(t -> System.out.println(t.getText()));
//        for (WebElement w : dropdownMenu) {
//            System.out.println(w.getText());
//        }

//   -Dropdown menuden sırasıyla ilk 5 başlığı (Arts&Crafts ile başlayıp Books'a kadar Books dahil) seçip
//         başlık altındakileri aratalım. Her aramada sayfa başlığını yazdıralım

        for (int i = 1; i < 6; i++) {
            ddm = driver.findElement(By.cssSelector("[id='searchDropdownBox']"));
            select = new Select(ddm);
            select.selectByIndex(i);
            driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);
            System.out.println(driver.getTitle());
            Thread.sleep(2000);
            driver.navigate().back();

        }
     */

}
