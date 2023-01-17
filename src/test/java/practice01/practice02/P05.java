package practice01.practice02;

import utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class P05 extends TestBase {

    @Test
    public void test01() throws InterruptedException {

        //// https://the-internet.herokuapp.com/iframe adresine gidiniz.
        driver.get("https://the-internet.herokuapp.com/iframe");


//        // An iFrame conteining... başlığının altındaki Text Box’a “Techproeducation” yazin.
        WebElement iframe = driver.findElement(By.xpath("//*[@ id='mce_0_ifr']"));
        driver.switchTo().frame(iframe);
        WebElement textbox = driver.findElement(By.xpath("//p"));
        textbox.clear();
        textbox.sendKeys("Techproeducation");



//        // TextBox’in altinda bulunan “Elemental Selenium” linkinin gorunur oldugunu test edin
          driver.switchTo().defaultContent();
           WebElement elementSeleniumLinki = driver.findElement(By.xpath("//*[.='Elemental Selenium']"));
          Assert.assertTrue(elementSeleniumLinki.isDisplayed());
        //Assert.assertTrue(driver.findElement(By.xpath("//*[.='Elemental Selenium']")).isDisplayed());



//        // Elemental Selenium linkine tıklayın
        elementSeleniumLinki.click();
        List<String> windowHAndles = new ArrayList<String>(driver.getWindowHandles());
        System.out.println(windowHAndles);
        driver.switchTo().window(windowHAndles.get(1));
          // get(0) [CDwindow-21E13E49E01E6DBA3F28F2674E354F36,      get(1) ==> CDwindow-F1A337EE7E4F54EBB205E0CF9C31094D]

        //    MULTIPLE WINDOW
        //      Gecis yapmak istedigim sayfanin title'i
        // ornek :
        //driver.get("https://the-internet.herokuapp.com/windows");
        // switchToWindow("New Window");
        // switchToWindow("The Internet");

//    public static void switchToWindow (String targetTitle) {
//        String origin = driver.getWindowHandle();
//        for (String handle : driver.getWindowHandles()) {
//            driver.switchTo().window(handle);
//            if (driver.getTitle().equals(targetTitle)) {
//                return;
//            }
//        }
//        driver.switchTo().window(origin);





//        // Açılan sayfada sayfa başlığını yazdırınız
        System.out.println(" Elemental Selenium Sayfa Basligi= "+ driver.getTitle());

//        // Elemental Selenium başlığı altındaki "Source Labs" linkinin gorunur olduğunu test edin
        WebElement sourceLabLinki = driver.findElement(By.xpath("//*[.='Sauce Labs']"));
        Assert.assertTrue(sourceLabLinki.isDisplayed());

//        // Source labs linkine tıklayın  ( burada acilan pencere 3 e cikti. 3'e cikinca tekrar liste attim.
        System.out.println("-----------------------------------");
        sourceLabLinki.click();
        List<String > windowHandles2 = new ArrayList<>(driver.getWindowHandles());
        System.out.println(windowHandles2);
  // [CDwindow-CBECCF7D6875C91528453A6FF07000C8, CDwindow-525392AB840ADDB59C169037CEDC2F65, CDwindow-6445004B824C533DC8306C8C3968F6F0]
        driver.switchTo().window(windowHandles2.get(2));


//        // Açılan sayfada sayfa başlığını yazdırınız

        System.out.println("Source Labs Sayfa Basligi =" + driver.getTitle());


//        // ilk sekmeye geri dönelim ve url'ini yazdıralım
        driver.switchTo().window(windowHandles2.get(2));
        System.out.println("Sayfa URL si = " + driver.getCurrentUrl());
        Thread.sleep(2000);

      // ilk sekmeyi kapatalım
      //  driver.close();
       // driver.switchTo().window(windowHandles2.get(2));
       // System.out.println(driver.getCurrentUrl());




    }

}
