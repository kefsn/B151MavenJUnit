package seleniumJunit.day07_Maven_Junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NT2_BeforeAfter {

             /*
                Notasyonlara sahip methodlar olusturabilmek icin mouse+sag tik +generate(kisayol alt + insert) yaparak
                after methodu icin teardown'u seceriz.
                before methodu icin setup'i seceriz.
                test methodu icin de test'i seceriz

                JUnit frameworkunde testlerimizi siralama yapabilmek icin ekstra bir notasyon yoktur.
                Eger belli bir siralamada calistirmak istersek method isimlerini alfabetik ve sayisal olarak belirtmemiz gerekir
            */
    @After
    public void tearDown() {
        System.out.println("Her test methodundan sonra bir kez çalışır");

    }

    @Before
    public void setUp() {

        System.out.println("Her test methodundan önce bir kez çalışır");


    }

    @Test
    public void test1() {
        System.out.println("Test 1 methodu çalıştı");
    }

    @Test
    public void test2() {
        System.out.println("Test 2 methodu çalıştı");
    }

    @Test
    public void test3() {
        System.out.println("Test 3 methodu çalıştı");
    }
}
