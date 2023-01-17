package day10;

import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_Actions3 extends TestBase {

    @Test
    public void scrollUpDown (){


       /* https://techproeducation.com a git
        Sayfanin altına doğru gidelim
        Sonra sayfanın üstüne doğru gidelim
         */
driver.get("https://techproeducation.com ");
        Actions actions = new Actions(driver);
        waitFor(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();  // ==> performu yazmayi unutma
        waitFor(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();  // ==> performu yazmayi unutma
        waitFor(2);

        actions.sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN).perform();


        // Arrow down page down dan daha az mesafe aldirir.
        actions.sendKeys(Keys.ARROW_DOWN).perform();

        actions.sendKeys(Keys.PAGE_UP).perform();
        waitFor(2);
        actions.sendKeys(Keys.ARROW_UP).perform();


        actions.sendKeys(Keys.ARROW_RIGHT).perform();
        actions.sendKeys(Keys.ARROW_LEFT).perform();
    }

}

