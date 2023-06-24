package seleniumJunit.day14_Actions_Faker;

import com.github.javafaker.Faker;
import org.junit.Test;
import utilities.TestBase;

public class C04_Faker  {


    @Test
    public void faker() {

    /*
    Faker class'ından sahte verileri kullanbilmek için obje oluşturmamız gerekir.

     */
        Faker faker = new Faker();

        //faker objesini kullanarak bir isim yazdırınız
        System.out.println("Faker First Name = " + faker.name().firstName());

        //faker objesini kullanarak bir Lastname yazdırınız
        System.out.println("Faker Last Name = " + faker.name().lastName());

         //faker objesini kullanarak bir fullname yazdırınız
        System.out.println("Faker Full Name = " + faker.name().fullName());

        //faker objesini kullanarak bir adres yazdırınız
        System.out.println("Faker Adres = " + faker.address().fullAddress());


        //faker objesini kullanarak bir tel_no yazdırınız
        System.out.println("Faker Cep No = " + faker.phoneNumber().cellPhone());
        System.out.println("Faker Tel No = " + faker.phoneNumber().phoneNumber());

        //Rastgele 15 haneli bir numara yazdıralım
        System.out.println("Faker 15 Haneli bir sayı = " + faker.number().digits(15));

        System.out.println("Faker artist adı = " + faker.artist().name().toUpperCase());

    }
}
