package day09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C02_WindowHandle3 extends TestBase {

    @Test
    public void newWindowHandleTest01(){        // Bu method  Selenium 4 te var sadece.

        // 1. Tchpro education in title ini "Techpro Education" metnini icerdigini test edin.
        driver.get("https://techproeducation.com");
        String techProHandle = driver.getWindowHandle();
        Assert.assertTrue(driver.getTitle().contains("Techpro Education"));



      //  String actualTitle = ..... yerine

        // 2. Yeni bir pencerede Amazon sayfasini acip titlein " Amazon metnini icerdigini test edelim.
        waitFor(3);
       // driver.get("https://amazon.com"); yazarsak ayni sayfada acar Amazonu
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://amazon.com");
        Assert.assertTrue(driver.getTitle().contains("Amazon"));



        // 3. Yeni bir pencerede Linkedin sayfasini acip titlein " LinkedIn metnini icerdigini test edelim.
        waitFor(3);
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://linkedin.com");
        Assert.assertTrue(driver.getTitle().contains("LinkedIn"));


        // tekrar Techproya gitmek icin
        driver.switchTo().window(techProHandle);
        // Driver nerde?

        Assert.assertTrue(driver.getTitle().contains("Techpro Education"));
        waitFor(3);




    }
}
