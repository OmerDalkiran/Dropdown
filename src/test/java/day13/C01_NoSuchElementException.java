package day13;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;
import java.security.Key;
public class C01_NoSuchElementException extends TestBase {
    @Test
    public void noSuchElementTest(){
        /*
         */
        driver.get("https://www.techproeducation.com");
        driver.
                findElement(By.xpath("//input[@type='searchh']")).//org.openqa.selenium.NoSuchElementException:
                sendKeys("QA"+ Keys.ENTER);
        //org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {"method":"xpath","selector":"//input[@type='searchh']"}
//NoSuchElementException:

    /*    Yanlis locator
        Popup, yeni pencere, iframe,…
        Sayfa dolmada problemler ve yavaslamalar
        Sakli olan elementler
        Solution:
        Locatorin dogrulugunu tekrar kontrol et
        Manual test ile iframe, yeni pencere, alert,… gibi elementlerin varligini kontrol et.
                Bekleme problemi olabilir. Implicit wait bekleme suresini cozmuyor. Bu durumda explicit wait yada fluent wait kullaniriz

        Falsche Location
        popup, neu Fenster, iframe
        bei seite ladung probleme und verlangsamung (bei Einladung der Seiten)
        geheime seiten
        kontrolliere die richtigkeit der locations
        mit Manuel Test iframe, neu Fenster, alert..ähnliches.. überprüfe die anwesenheit die elemente
        Warte probleme kann entstehen
        implicit wait ist keine lösung für wartezeit
        in diesem fall kann explicit wait oder fluent waid angewendet werden
*/
    }
}
