package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_Assertions {
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amazon.com");

    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
//1)Bir class oluşturun:YoutubeAssertions
//2)https://www.amazon.com adresine gidin
//3)Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleriyapin
//○ title Test  => Sayfa başlığının “Amazon” oldugunu testedin
//○ image Test => Amazon resminin görüntülendiğini (isDisplayed()) testedin
//○ Search Box 'in erisilebilir oldugunu test edin(isEnabled())
//○ wrongTitleTest => Sayfa basliginin “Amazon” olmadigini dogrulayin

    @Test
    public void test01() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "Amazon";
        //if(actualtitle=expectedTiyle)) ==>     eskiden if else kullaniyorduk. simdi ise
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }

    @Test
    public void test02() {

        WebElement sayfaResmi = driver.findElement(By.xpath("//*[@ id='nav-logo-sprites']"));
        Assert.assertTrue(sayfaResmi.isDisplayed());
    }

    @Test
    public void test03() {

        WebElement searcBox = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        Assert.assertTrue(searcBox.isEnabled());

    }

    @Test
    public void test04() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "amazon";
        //if(actualtitle=expectedTiyle)) ==>     eskiden if else kullaniyorduk. simdi ise
        Assert.assertFalse(actualTitle.contains(expectedTitle)); // ==> Sayfaya baktigimizda amazon'un
        // kucuk harfle yazilmadigini goruyoruz.(logonun degil.)

    }
}


