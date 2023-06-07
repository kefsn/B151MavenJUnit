package seleniumJunit.day08_Junit_Assertion;

import org.junit.*;

public class NT01_BeforeClassAfterClass {


    @BeforeClass
    public static void beforeClass() throws Exception {


        System.out.println("Her class'dan önce @BeforeClass bir kere çalışır");

    }

    @AfterClass
    public static void afterClass() throws Exception {


        System.out.println("Her class'dan sonra @AfterClass bir kere çalışır");

    }

    @Before
    public void setUp() throws Exception {
        System.out.println("Her methoddan önce Before methodu bir kere çalışır");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Her methoddan sonra After methodu bir kere çalışır");
    }

    @Test
    public void test01() {

    }

    @Test
    public void test02() {

    }

    @Test
    public void test03() {
    }









}

