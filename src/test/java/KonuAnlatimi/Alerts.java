package KonuAnlatimi;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Alerts extends TestBase {

    @Test
    public void test01() {

        driver.get("https://demoqa.com/alerts");
       // driver.findElement()
        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).getText();
        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();

    }

}
