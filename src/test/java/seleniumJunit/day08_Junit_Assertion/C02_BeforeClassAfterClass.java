package seleniumJunit.day08_Junit_Assertion;

import org.junit.*;

public class C02_BeforeClassAfterClass {

    /*
    @BeforeClass class'da en önce çalışan methoddur.Sadece bir kez çalışır
    @AfterClass  class'da en son çalışan methoddur.Sadece bir kez çalışır

    @BeforeClass ve @AfterClass methodları sadece static methodlar ile çalışır.

     */

    @BeforeClass
    public static void beforeClass() throws Exception {

        System.out.println("@BeforeClass Classta ilk  önce çalışan methoddur");
    }

    @AfterClass
    public static void afterClass() throws Exception {

        System.out.println(" @AfterClass Classta ilk  son çalışan methoddur");

    }

    @Before
    public void setUp() throws Exception {
        System.out.println(" @Before Her Test methodundan önce çalışır.");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("@After Her Test methodundan önce çalışır.");
    }

    @Test
    public void test01() {
        System.out.println("ilk test");

    }

    @Test
    public void test02() {
        System.out.println("İkinci Test");
    }
}
