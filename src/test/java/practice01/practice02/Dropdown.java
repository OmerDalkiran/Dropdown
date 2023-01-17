package practice01.practice02;

import utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Dropdown extends TestBase {

    @Test
    public void test01 (){

        // Amazon sayfasina gidin

        driver.get("https://amazon.com");


        //Dropdown menuyu yazdıralım
        List<WebElement> dropdown = driver.findElements(By.xpath("//*[@id='searchDropdownBox']"));


        //Select select = new Select(dropdown); select in icine web element istiyor. dropdowni koyamazsin.
        dropdown.forEach(t-> System.out.println(t.getText()));

        //ya da
//        WebElement dropdown2 = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
//        Select select = new Select(dropdown2);
//        for (WebElement w : select.getOptions()) {
//            System.out.println(w.getText());
//        }

        //Dropdown menuden baby secelim
        driver.findElement(By.xpath("//*[@id='searchDropdownBox']")).sendKeys("Baby"
                , Keys.TAB,"Milk",Keys.ENTER);
        //arama bölümünden milk aratalım
    }
}