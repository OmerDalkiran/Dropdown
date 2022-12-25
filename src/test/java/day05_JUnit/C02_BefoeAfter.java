package day05_JUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C02_BefoeAfter {

    @Before
    public void setup(){
        System.out.println("Her Test metodundan once calisir");

    }
    @After
    public void teardown(){
        System.out.println("Her Test metodundan sonra calisir.");


    }
    @Test
    public void test01(){
        System.out.println("ilk test");
    }

    @Test
    public void test02 (){

        System.out.println("ikinci test");
    }
}
