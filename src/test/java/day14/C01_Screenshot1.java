package day14;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_Screenshot1 extends TestBase {

//    Class : screenShot1
//    Techpro education a git ve Sayfanin goruntusunu al
//-“QA” aramasi yap
//    Acilen sayfanin metnini test et ve ekran goruntusu al: “Search Results for: QA”

    @Test
    public void fullPageScreenshotTest() throws IOException {

       // Selenium da tum ekran goruntusu nasil alinir?
        // Seleniumdan gelen getScreenshotAs metodu ile alinir. o da Selenium daki TakeScreenshot API indan gelir.


        driver.get("https://techproeducation.com");
       // driver.getScreenshotAs metodu ile alip file olarak olusturalim

       //1 - Ekran goruntusunu getScreenshotAs metotu ile alip file olarak olusturalim.
        File goruntu = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        //2. Adim = Almis oldugum ekran goruntusunu belirledigim bir yola kaydet.
        String currentDate = new SimpleDateFormat("yyyyMMddhhmmss").format((new Date()));
        String path = System.getProperty("user.dir")+"/test-output/Screenshots/"+currentDate+"image.png";
        File hedef = new File(path);

        // dosya olarak alinir ve genelde png tipi olarak kaydedilir.
           FileUtils.copyFile(goruntu,hedef);

        //3. Goruntum ile dosyami birlestirip kaydet :
        FileUtils.copyFile(goruntu,hedef);
        //Asagidaki gibi tek satirda da yazilabilir. !!!
//        FileUtils.copyFile(((TakesScreenshot)driver)
//        .getScreenshotAs(OutputType.FILE),new File(System.getProperty("user.dir")+"/test-output/Ekrangoruntuleri/image.png"));
//

    // QA aramasi yap

        driver.findElement(By.xpath("//input[@type='search']")).sendKeys("QA"+ Keys.ENTER);
        waitFor(3);
//        Acilen sayfanin metnini test et ve ekran goruntusu al: “Search Results for: qa”
        String expected = "Search Results for: QA";
        String text = driver.findElement(By.xpath("//*[contains(text(),'Search Results for')]")).getText();
        Assert.assertTrue(expected.contains(text));


        // Reusable method ile ekran goruntusunu al

    takeScreenShotOfPage();

    }

}
