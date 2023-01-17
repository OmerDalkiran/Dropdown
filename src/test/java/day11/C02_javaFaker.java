package day11;

import com.github.javafaker.Faker;
import org.junit.Test;

public class C02_javaFaker {



    @Test
    public void javaFakerTest() {

        // 1. Faker objesi olustur
        Faker faker = new Faker();

        // 2. Faker objesi ile fake data olustur

        String fName = faker.name().firstName();
        System.out.println(fName);

        String lastName = faker.name().lastName();
        System.out.println(lastName);

        // username
        String username = faker.name().username();

         // job title
        System.out.println( faker.name().title());

        // city
        System.out.println(faker.address().city());

        //ceyalet
        System.out.println(faker.address().state());

        // full address
        System.out.println(faker.address().fullAddress());

        // email
        System.out.println(faker.internet().emailAddress());

        // post code
        System.out.println(faker.address().zipCode());

        // rastgele 15 haneli numara

        System.out.println(faker.number().digits(15));


        /*
        Test data : kullanici adi , sifre, tel no, email, sehir ...
        Test datalari kimden alinir?
        -
         */


    }

}
