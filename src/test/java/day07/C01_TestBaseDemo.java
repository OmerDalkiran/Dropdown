package day07;

import utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;

public class C01_TestBaseDemo extends TestBase {


    @Test
    public void test1(){

        // techproeducation ana sayfasina git ve title 'in Bootcamps kelimesini icerdigini test edelim.

        driver.get("https://www.techproeducation.com");

        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle.contains("Bootcamps"));


    }


}
