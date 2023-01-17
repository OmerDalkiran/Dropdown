package groupWork;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Q9_Home_Arrivals extends TestBase {

    @Test
    public void  question9  (){

//        1) Open the browser
//2) Enter the URL “http://practice.automationtesting.in/”
        driver.navigate().to("http://practice.automationtesting.in/");

//3) Click on Shop Menu
        driver.findElement(By.xpath("//*[@id='menu-item-40']")).click();

//4) Now click on Home menu button
driver.findElement(By.xpath("//*[a='Home']")).click();

//5) Test whether the Home page has Three Arrivals only
        System.out.println("Number of new Arrivals : " +driver.findElements(By.xpath("//*[@class='woocommerce-LoopProduct-link']")).size());

       //6) The Home page must contain only three Arrivals
        Assert.assertEquals(8,driver.findElements(By.xpath("//*[@class='woocommerce-LoopProduct-link']")).size());

//7) Now click the image in the Arrivals


//8) Test whether it is navigating to next page where the user can add that book into his basket.
//9) Image should be clickable and should navigate to next page where user can add that book to his basket
//10) Click on the Add To Basket button which adds that book to your basket
//11) User can view that Book in the Menu item with price.
//12) Now click on Item link which navigates to proceed to check out page.
//13) User can click on the Item link in menu item after adding the book in to the basket which leads to the check out page

    }
}
