package day10;

import com.beust.ah.A;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_Actions4 extends TestBase {

    @Test
    public void dragAndDropTest (){



     //   Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");

     //   And user moves the target element(Drag me to my target) in to  destination(Drop here)


        driver.switchTo().frame(0); // bunu en son yazdik. 0 demek 1 tane iframe var demek.

        WebElement source = driver.findElement(By.xpath("//*[@id='draggable']"));

        WebElement target = driver.findElement(By.xpath(" //*[@id='droppable'] "));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(source,target).perform();
waitFor(2);

     // ==> NOTE: Eger drag and drop islemi iframe in icinde ise, ilk once onun icine switch yapmak lazim.


    }
    @Test
    public void clickAndHoldTest () {


        //   Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");

        //   And user moves the target element(Drag me to my target) in to  destination(Drop here)
       //    Kaynak ve hedef elementleri iframin icerisinde
        driver.switchTo().frame(0); // bunu en son yazdik. 0 demek 1 tane iframe var demek.

        WebElement source = driver.findElement(By.xpath("//*[@id='draggable']"));

        WebElement target = driver.findElement(By.xpath(" //*[@id='droppable'] "));

        Actions actions = new Actions(driver);
        actions
                .clickAndHold(source)   // kaynagi tut
                .moveToElement(target)        // hedefe koy
                .release()                    // sal, birak
                .build()                      // ozellikle 1den fazla fonksiyonda bunlari bagla,kur,guclendir,insa et
                .perform();                   // islemi gerceklestir  ==> yap , calistir, uygula



    }
    @Test
    public void moveByOffSetTest (){
        //   Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");

        //   And user moves the target element(Drag me to my target) in to  destination(Drop here)
        //    Kaynak ve hedef elementleri iframin icerisinde
        driver.switchTo().frame(0); // bunu en son yazdik. 0 demek 1 tane iframe var demek.

        WebElement source = driver.findElement(By.xpath("//*[@id='draggable']"));

        WebElement target = driver.findElement(By.xpath(" //*[@id='droppable'] "));

        Actions actions = new Actions(driver);

        actions
                .clickAndHold(source)
                .moveByOffset(550,30)
                .build()
                .perform();

    }
}
