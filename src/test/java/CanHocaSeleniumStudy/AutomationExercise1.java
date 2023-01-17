package CanHocaSeleniumStudy;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class AutomationExercise1 {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

//3. Verify that home page is visible successfully


        WebElement homePageVisibility = driver.findElement(By.xpath("//*[@alt='Website for automation practice']"));
        if(homePageVisibility.isDisplayed()){

            System.out.println ("Test Passed");
        }else System.out.println("Test Failed");


//4. Click on 'Signup / Login' button:
        driver.findElement(By.xpath(" //*[text()=' Signup / Login']")).click();

        //5. Verify 'New User Signup!' is visible
        WebElement newUSVisible = driver.findElement(By.xpath("//*[h2='New User Signup!']"));
        if (newUSVisible.isDisplayed()){
            System.out.println("Text PASSED");
        }else System.out.println("Text FAILED");

   // Boolean newUserSignUp = driver.findElement(By.xpath("//*[h2='New User Signup!']")).isDisplayed();



//6. Enter name and email address
        driver.findElement(By.xpath("//*[@data-qa='signup-name']")).sendKeys("Omer");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@ data-qa='signup-email']")).sendKeys("dd@rhenusacademy.com");
        Thread.sleep(1000);

//7. Click 'Signup' button
        driver.findElement(By.xpath("//*[@data-qa='signup-button']")).submit();
        Thread.sleep(1000);

//8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
     Boolean enterAccountInfo =  driver.findElement(By.xpath("//*[b='Enter Account Information']")).isDisplayed();
        System.out.println("ENTER ACCOUNT INFORMATION  is " + enterAccountInfo);

//9. Fill details: Title, Name, Email, Password, Date of birth
        driver.findElement(By.xpath("//*[@id='id_gender1']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@type='password']")).sendKeys("Qwerty");

        WebElement day= driver.findElement(By.xpath("//*[@id='days']"));
        day.findElement(By.xpath("//*[@value= '15']")).click();
        Thread.sleep(3000);

        WebElement month = driver.findElement(By.xpath("//*[@id='months']"));
        month.findElement(By.xpath("//*[text()='May']")).click();
        Thread.sleep(3000);

        WebElement year = driver.findElement(By.xpath("//*[@id='years']"));
        year.findElement(By.xpath("//*[text()='1972']")).click();
        Thread.sleep(1500);


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
        driver.findElement(By.xpath("//*[@class='ns-75dc7-e-16']")).click();
        driver.findElement(By.xpath("//*[@class='ns-9hfdv-e-16']")).click();


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
