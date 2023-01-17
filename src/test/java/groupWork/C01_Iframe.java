package groupWork;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C01_Iframe extends TestBase {


    @Test
    public void test01(){

        driver.get("http://demoga.com/frames");
        int iframeNumberOnPage = driver.findElements(By.tagName("iframe")).size();

        System.out.println(iframeNumberOnPage);



        driver.switchTo().frame("frame1");
        System.out.println(driver.findElement(By.id("iframe")).getText());

        driver.switchTo().parentFrame().switchTo();
        driver.switchTo().defaultContent();

    }



}
