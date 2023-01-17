package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import javax.annotation.Tainted;

public class Question3 extends TestBase {

    @Test
    public void test01(){

        //       1. Launch browser
//        2. Navigate to url 'http://automationexercise.com'
     driver.get("http://automationexercise.com");


//        3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(homePage.isDisplayed()); // Boolean veriyor. True /False
       // Homepage gorunurmu?


//        4. Click on 'Signup / Login' button
           driver.findElement(By.xpath("//*[@href='/login']")).click();


//        5. Verify 'Login to your account' is visible
          WebElement login = driver.findElement(By.xpath("//h2[1]"));
          Assert.assertTrue(login.isDisplayed());

//        6. Enter incorrect email address and password   &                                                                                7. Click 'login' button
          driver.findElement(By.xpath("//*[@data-qa='login-email']")).sendKeys("dortbunder@jfjfjjf.com", Keys.TAB,"12344",Keys.ENTER);

//        8. Verify error 'Your email or password is incorrect!' is visible
         WebElement errorScript =   driver.findElement(By.xpath("//p[.='Your email or password is incorrect!']"));

         Assert.assertTrue(errorScript.isDisplayed());



    }

}
