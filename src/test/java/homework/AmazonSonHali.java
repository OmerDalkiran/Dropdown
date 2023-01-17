package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

public class AmazonSonHali extends TestBase {
    WebElement ddm;
    Select select;
    By secondProduct;
    TreeMap<String, String> urunler = new TreeMap<>();
    TreeMap<String, String> sepettekiler = new TreeMap<>();

    @Test
    public void test01() {          // Test01
        // 1- amazon gidin
        driver.get("https://www.amazon.com");

        // Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        ddm = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        select = new Select(ddm);
        List<WebElement> ddmOptions = select.getOptions();
        ddmOptions.stream().forEach(t -> System.out.println(t.getText()));

        //dropdown menude 40 eleman olduğunu doğrulayın
        System.out.println("ddmOptions.stream().count() = " + (long) ddmOptions.size());
        Assert.assertNotEquals(40, ddmOptions.size());
    }

    @Test
    public void test02() {          // Test02
        test01();

        // dropdown menuden elektronik bölümü seçin
        selectFromDropdown(ddm, "Electronics");

        // arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
        WebElement resultText = driver.findElement(By.xpath("//div[@class='sg-col-inner']"));
        System.out.println("resultText = " + resultText.getText());

        // sonuc sayisi bildiren yazinin iphone icerdigini test edin
        Assert.assertTrue(resultText.getText().contains("iphone"));

        // ikinci ürüne relative locater kullanarak tıklayin
        WebElement firstProduct = driver.findElement(By.xpath("//*[@cel_widget_id='MAIN-SEARCH_RESULTS-1']"));
        secondProduct = RelativeLocator.with(By.tagName("div")).toRightOf(firstProduct);
        driver.findElement(secondProduct).click();

        // ürünün title'ni ve fiyatını variable’a  assign edip ürünü sepete ekleyelim
        WebElement firstProductTitle = driver.findElement(By.xpath("//h1[@id='title']"));
        WebElement firstProductPrice = driver.findElement(By.xpath("//*[@class='a-price aok-align-center']"));
        String[] arrPrice = firstProductPrice.getText().split("\n");
        String firstPrice = arrPrice[0] + "." + arrPrice[1];
        System.out.println("firstProductTitle = " + firstProductTitle.getText());
        System.out.println("firstProductPrice = " + firstPrice);
        urunler.put(firstProductTitle.getText(),firstPrice);
        driver.findElement(By.name("submit.add-to-cart")).click();
    }

    @Test
    public void test03() {          // Test03
        test02();
        System.out.println();
        // yeni bir sekme açarak amazon anasayfaya gidin
        driver.switchTo().newWindow(WindowType.TAB);
        switchToWindow(1);
        driver.get("https://www.amazon.com");
        // dropdown’dan bebek bölümüne secin
        ddm = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        selectFromDropdown(ddm, "Baby");
        // bebek puset aratıp bulundan sonuç sayısını yazdırın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("baby stroller", Keys.ENTER);
        WebElement resultText = driver.findElement(By.xpath("//div[@class='sg-col-inner']"));
        System.out.println("resultText = " + resultText.getText());
        // sonuç yazsının puset içerdiğini test edin
        Assert.assertTrue(resultText.getText().contains("stroller"));
        // 5-birinci ürüne relative locater kullanarak tıklayin
        WebElement secondProduct = driver.findElement(By.xpath("//*[@cel_widget_id='MAIN-SEARCH_RESULTS-2']"));
        By thirdProduct = RelativeLocator.with(By.tagName("img")).above(secondProduct);
        driver.findElement(thirdProduct).click();
        // 6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
        WebElement secondProductTitle = driver.findElement(By.xpath("//h1[@id='title']"));
        WebElement secondProductPrice = driver.findElement(By.xpath("//*[@class='a-price aok-align-center']"));
        String[] arrPrice = secondProductPrice.getText().split("\n");
        String secondPrice = arrPrice[0] + "." + arrPrice[1];
        System.out.println("secondProductTitle = " + secondProductTitle.getText());
        System.out.println("secondProductPrice = " + secondPrice);
        urunler.put(secondProductTitle.getText(), secondPrice);
        driver.findElement(By.name("submit.add-to-cart")).click();
    }

    @Test
    public void test04() {          // Test 4
        test03();
        // 1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın
        driver.findElement(By.id("nav-cart")).click();

        String productTitle1 = driver.findElement(By.xpath("(//span[@class='a-truncate-cut'])[5]")).getText();
        productTitle1 = productTitle1.replaceAll("…","");
        System.out.println("productTitle1 = " + productTitle1);

        String productPrice1 = driver.findElement(By.xpath("(//p[@class='a-spacing-mini'])[1]")).getText();

        String productTitle2 = driver.findElement(By.xpath("(//span[@class='a-truncate-cut'])[6]")).getText();
        productTitle2 = productTitle2.replaceAll("…","");
        System.out.println("productTitle2 = " + productTitle2);

        String productPrice2 = driver.findElement(By.xpath("(//p[@class='a-spacing-mini'])[2]")).getText();

        sepettekiler.put(productTitle1, productPrice1);
        sepettekiler.put(productTitle2, productPrice2);

        System.out.println();
        Iterator<String> iterator1 = urunler.keySet().iterator();
        Iterator<String> iterator2 = sepettekiler.keySet().iterator();
        while (iterator1.hasNext() && iterator2.hasNext()){
            String first = iterator1.next();
            String second = iterator2.next();
            System.out.println(first + " = " + second + " " + first.contains(second));
            Assert.assertTrue(first.contains(second));
        }

        System.out.println();
        iterator1 = urunler.values().iterator();
        iterator2 = sepettekiler.values().iterator();
        while (iterator1.hasNext() && iterator2.hasNext()){
            String first = iterator1.next();
            String second = iterator2.next();
            System.out.println(first + " = " + second + " " + first.contains(second));
            Assert.assertEquals(first,second);
        }
    }

    public void selectFromDropdown(WebElement dropdown, String secenek) {
        // Gonderilen dropdown elentinin tum option'lari alinir
        // option <-- dropdown icindeki tum elemenalrin tagName'sidir.
        List<WebElement> options = dropdown.findElements(By.tagName("option"));
        for (WebElement eachOption : options) {
            if (eachOption.getText().equals(secenek)) {
                eachOption.click();
                break;
            }
        }
    }
}