package homework;

import com.github.javafaker.Team;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.security.Key;

public class AutomationEx01 extends TestBase {


    @Test
    public void test01() throws InterruptedException {

//   Test Case 1: Register User
//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'

driver.get("http://automationexercise.com");

//3. Verify that home page is visible successfully
     WebElement homePageVisibility = driver.findElement(By.xpath("//*[@alt='Website for automation practice']")) ;
     if(homePageVisibility.isDisplayed()){
         System.out.println("Test Passed");
     }else System.out.println("Test failed");


//4. Click on 'Signup / Login' button
      driver.findElement(By.xpath(" //*[text()=' Signup / Login'] ")).click();


//5. Verify 'New User Signup!' is visible
        WebElement newUserVisible = driver.findElement(By.xpath("//h2")) ;
        Assert.assertTrue(newUserVisible.isDisplayed());

//6. Enter name and email address
     driver.findElement(By.xpath("//*[@data-qa='signup-name']")).sendKeys("Omer", Keys.TAB,"eee@hotmail.com");


//7. Click 'Signup' button
         driver.findElement(By.xpath("//*[@data-qa='signup-button']")).click(); ;  //*[@data-qa='signup-button']
waitFor(2);


         //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
      //  WebElement enterAccInfo= driver.findElement(By.xpath(" //*[b='Enter Account Information']"));
     // Assert.assertTrue(enterAccInfo.isDisplayed());

        String actualResult  = driver.findElement(By.xpath(" //*[b='Enter Account Information']")).getText();
      //  System.out.println(actualResult);
        String expectedResult= "ENTER ACCOUNT INFORMATION";
        Assert.assertEquals(expectedResult,actualResult);

//9. Fill details: Title, Name, Email, Password, Date of birth
        driver.findElement(By.xpath("//*[@id='id_gender1']")).click(); ;

        driver.findElement(By.xpath("//*[@type='password']")).sendKeys("asdfgh");

        driver.findElement(By.xpath("//input[@id='id_gender1']")).click();
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("qwermjkthj");



//        WebElement dateOfBirth = driver.findElement(By.xpath("//select[@id='days']"));
//        Select date = new Select(dateOfBirth);
//        date.selectByVisibleText("15");

        WebElement day= driver.findElement(By.xpath("//*[@id='days']"));
       // day.findElement(By.xpath("//*[@value= '15']")).click();
        WebElement month=driver.findElement(By.xpath("//select[@id='months']"));

        WebElement year=driver.findElement(By.xpath("//select[@id='years']"));

       day.click();
       day.sendKeys("12");
       month.sendKeys("May");
       year.sendKeys("1970");

//   selectFromDropdown(day,"15");
//   selectFromDropdown(month,"May");
//   selectFromDropdown(year,"1972");


  //      WebElement month=driver.findElement(By.xpath("//select[@id='months']"));
//        Select select=new Select(month);
//        select.selectByIndex(5);
//
//WebElement year=driver.findElement(By.xpath("//select[@id='years']"));
//        Select dogumTarihi=new Select(years);
//        dogumTarihi.selectByVisibleText("1984");

//10. Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.xpath("//*[@name='newsletter']")).click();
        Thread.sleep(1500);
//11. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.xpath("//*[@id='optin']")).click();
        Thread.sleep(1500);
//12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number

        //Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        driver.findElement(By.xpath("//*[@id='first_name']")).sendKeys("Omer");
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id='last_name']")).sendKeys("Dalkiran");
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id='company']")).sendKeys("Interco");
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id='address1']")).sendKeys("Dortmund Germany");
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id='address2']")).sendKeys("Bruderstr.34 ");
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id='country']"));
        driver.findElement(By.xpath("//*[text()='India']")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id='state']")).sendKeys("NRW");
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id='city']")).sendKeys("Dortmund");
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id='zipcode']")).sendKeys("45634");
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id='mobile_number']")).sendKeys("+4915901610467");
        Thread.sleep(1500);



//13. Click 'Create Account button'
        driver.findElement(By.xpath("//*[text()='Create Account']")).click();
        Thread.sleep(1500);

//14. Verify that 'ACCOUNT CREATED!' is visible

        WebElement accountCr = driver.findElement(By.xpath("//*[text()='Account Created!']"));
        if (accountCr.isDisplayed()) {
            System.out.println("TEST PASSED");
        } else System.out.println("TEST FAILED");
        Thread.sleep(1500);

//15. Click 'Continue' button
        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
        Thread.sleep(1500);

        //==> Advertisement ns-9hfdv-e-16
       // driver.findElement(By.xpath("//*[@class='ns-75dc7-e-16']")).click();
   //     driver.findElement(By.xpath("//*[@class='ns-9hfdv-e-16']")).click();


//16. Verify that 'Logged in as username' is visible
        WebElement usernameKontrol = driver.findElement(By.xpath("//*[@class='fa fa-user']"));
        if (usernameKontrol.isDisplayed()) {
            System.out.println("TEST PASSED");
        } else System.out.println("TEST FAILED");
        Thread.sleep(1500);

//17. Click 'Delete Account' button
        driver.findElement(By.xpath("//*[@href='/delete_account']")).click();
        Thread.sleep(1500);

//18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        WebElement accountDelete = driver.findElement(By.xpath("//*[text()='Account Deleted!']"));
        if (accountDelete.isDisplayed()) {
            System.out.println("TEST PASSED");
        } else System.out.println("TEST FAILED");

        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();

        Thread.sleep(1500);

        driver.close();
    }
}

