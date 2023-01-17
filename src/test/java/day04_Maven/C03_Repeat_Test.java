package day04_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Repeat_Test {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        ////C01_TekrarTesti isimli bir class olusturun


        ////2 https://www.google.com/ adresine gidin

        driver.get("https://www.google.com/");
        Thread.sleep(3000);

        ////3 cookies uyarisini kabul ederek kapatin
       driver.findElement(By.xpath("(//*[@ class='QS5gu sy4vM'])[2] ")).click();


        ////4 Sayfa basliginin "Google" ifadesi icerdigini test edin
        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";
        //if(actualtitle=expectedTiyle)) ==>     eskiden if else kullaniyorduk. simdi ise
        Assert.assertTrue(actualTitle.contains(expectedTitle));


      ////5 Arama cubuguna "Nutella" yazip aratin
      driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys("Nutella", Keys.ENTER);

       ////6 Bulunan sonuc sayisini yazdirin
        String [] sonucSayisi =  driver.findElement(By.xpath("//*[@ id='result-stats']")).getText().split(" ");
        String sonuc = sonucSayisi[1];
        System.out.println("sonuc sayisi = "+sonuc );



       ////7 sonuc sayisinin 10 milyon'dan fazla oldugunu test edin
    sonuc = sonuc.replaceAll("\\D", "" );   // ReplaceAll metodu ile \\D 'i kullanarak butun noktalama isaretlerinden kurtulunur.
        int istenenSayi = 100000000;
        Assert.assertTrue(Integer.parseInt(sonuc)>istenenSayi);



        ////8 Sayfayi kapatin
     //driver.close();


//1. "https://www.saucedemo.com" Adresine gidin
//2. Username kutusuna "standard_user" yazdirin
//3. Password kutusuna "secret_sauce" yazdirin
//4. Login tusuna basin
//5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
//6. Add to Cart butonuna basin
//7. Alisveris sepetine tiklayin
//8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
//9. Sayfayi kapatin


    }
}
