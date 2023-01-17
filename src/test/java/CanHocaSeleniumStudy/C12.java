package CanHocaSeleniumStudy;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;
import java.util.List;
public class C12 extends TestBase {
    @Test
    public void test(){
        //go to url : http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
        //Fill in capitals by country

        // REUSABLE METHOD'LA
        eslestir(2,2);
        eslestir(4,4);
        /* TEK TEK ESLESTIRME
        //Actions actions = new Actions(driver);
        WebElement oslo = driver.findElement(By.xpath("//div[@id='box1']"));
        WebElement norway = driver.findElement(By.xpath("//div[@id='box101']"));
        actions.dragAndDrop(oslo,norway).perform();

        WebElement stockholm = driver.findElement(By.xpath("//div[@id='box2']"));
        WebElement sweden = driver.findElement(By.xpath("//div[.='Sweden']"));
        actions.dragAndDrop(stockholm,sweden).perform();

        WebElement washington = driver.findElement(By.xpath("//div[@id='box3']"));
        WebElement  unitedStates = driver.findElement(By.xpath("//div[@id='box103']"));
        actions.dragAndDrop(washington,unitedStates).perform();

        WebElement copenhagen = driver.findElement(By.xpath("//div[@id='box4']"));
        WebElement denmark = driver.findElement(By.xpath("//div[@id='box104']"));
        actions.dragAndDrop(copenhagen,denmark).perform();

        WebElement seoul = driver.findElement(By.xpath("//div[@id='box5']"));
        WebElement southKorea = driver.findElement(By.xpath("//div[@id='box105']"));
        actions.dragAndDrop(seoul,southKorea).perform();

        WebElement rome = driver.findElement(By.xpath("//div[@id='box6']"));
        WebElement italy = driver.findElement(By.xpath("//div[@id='box106']"));
        actions.dragAndDrop(rome,italy).perform();
        waitFor(3);

        WebElement madrid = driver.findElement(By.xpath("//div[@id='box7']"));
        WebElement spain = driver.findElement(By.xpath("//div[@id='box107']"));
        actions.dragAndDrop(madrid, spain).perform();
*/

    }
    public void eslestir(int x,int y) {
        Actions actions = new Actions(driver);
        WebElement capitals = driver.findElement(By.xpath("//div[@id='box" + x + "']"));
        WebElement countries = driver.findElement(By.xpath("//div[@id='box10" + y + "']"));
        actions.dragAndDrop(capitals, countries).perform();
    }
}