package day13;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;
import java.time.Duration;
public class C02_TimeOutException extends TestBase {
    /*
    TimeOutException explicit wait kullandimda ve locator bulunamadiginda alirim
     */
    @Test
    public void timeOutExceptionTest(){
        driver.get("https://www.techproeducation.com");
//        Explit wait icin olusturdugumuz methodlardan birini kullanalim
//        Parametre 1: beklemek istedigim element, Parametre 2: Max sure
//        waitForVisibility(By.xpath("//input[@type='searchh']"),25)//org.openqa.selenium.TimeoutException:
//                .sendKeys("QA"+ Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("YANLIS ID")));//org.openqa.selenium.TimeoutException:
        /*
TimeOutException explicit wait kullanıldığı zaman ve element bulunamadığında alınan bir hatadır.
Şimdiye kadar karşılaşmamızın nedeni sadece implicit wait kullanmış olmamızdır.
Explicit wait ve yanlış locatar kullandığımız zaman TimeOutException alırız.
Explicit wait var, doğru locatar kullandık ama süre yeterli olmadığı durumlarda TimeOutException alırız.
Explicit wait var, doğru locatar kullandık, süre yeterli ama iframe var TimeOutException alırız.
*/

      /*  Çözüm
        Süreyi artırabiliriz.
        Farkli explicit wait yöntemleri kullanırız. Örn: VisibilityOfElementLocated çözmedi yerine presenceOfElementLocator kullanılabilir.
                Ya da javascript executor da ki waitleri sayfa geçişlerini beklemek için kullanabiliriz.
                Locatorı kontrol ederiz.
        Frameworkümde hazır reusable methodlar var. Bu durumda TimeOutException aldığımda o methodlar yardımıyla problemi çözebiliriz. */
        //TimeOutException:
     /*   If you use explicit wait and wait time is not enough/locator still incorrect then TimeOutException
        Simply put, wait time is over but the commend is not completed
        Solution:
        -Increase the wait time
                -Try using different wait. For example try using javascript executor wait for the page to load. This is also a dynamic wait
        -I have different explicit waits in my Reusable util class. I have javascript executor wait as well. ReusableMethods.waitForPageToLoad(1);
        -Case by case, I prefer different explicit waits to maximize the performance of the automation script.*/

    }
}