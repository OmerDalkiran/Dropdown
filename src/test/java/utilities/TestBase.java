package utilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

public abstract class TestBase {
    //    TestBase i abstract yapmamizin sebebi bu sinifin objesini olusturmak istemiyorum
//    TestBase testBase = new TestBase(); -> YAPILAMAZ
//    Amacim bu sinifi extend etmek ve icindeki hazir metodlari kullanmak
//    driver objesini olustur. Driver ya public yada protected olmali.
//    Sebepi child classlarda gorulebilir olmasi


    protected static WebDriver driver;

    //    setUp
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
//        driver=WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    // 'http://automationexercise.com' URL 'sine gidin

    public void firstThreeMethod() {

        driver.get("http://automationexercise.com");
        String actionalUrl = "https://automationexercise.com/";
        String exceptedUrl = driver.getCurrentUrl();
        Assert.assertEquals(actionalUrl, exceptedUrl);
        driver.findElement(By.xpath("//*[@href='/login']")).click();

    }

    //    tearDown
    @After
    public void tearDown() {
        waitFor(5);
        // driver.quit();
    }

    //    MULTIPLE WINDOW:
//    1 parametre alir : Gecis Yapmak Istedigim sayfanin Title
//    ORNEK:
//    driver.get("https://the-internet.herokuapp.com/windows");
//    switchToWindow("New Window");
//    switchToWindow("The Internet")
    public static void switchToWindow(String targetTitle) {
        String origin = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getTitle().equals(targetTitle)) {
                return;//CIK. break;
            }
        }
        driver.switchTo().window(origin);
    }

    //    windowNumber sıfır (0)'dan başlıyor.
//    index numarasini parametre olarak alir
//    ve o indexli pencerece gecis yapar
    public static void switchToWindow(int windowNumber) {
        List<String> list = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(list.get(windowNumber));
    }

    /*   HARD WAIT:
     @param : second
    */
    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //    ACTIONS_RIGHT CLICK
    public static void rightClickOnElementActions(WebElement element) {
        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
    }

    //ACTIONS_DOUBLE CLICK
    public static void doubleClick(WebElement element) {
        new Actions(driver).doubleClick(element).build().perform();
    }

    //    ACTIONS_HOVER_OVER
    public static void hoverOverOnElementActions(WebElement element) {
//        Actions actions = new Actions(driver);
        new Actions(driver).moveToElement(element).perform();
    }

    //    ACTIONS_SCROLL_DOWN
    public static void scrollDownActions() {
//        Actions actions = new Actions(driver);
        new Actions(driver).sendKeys(Keys.PAGE_DOWN).perform();
    }

    //    ACTIONS_SCROLL_UP
    public static void scrollUpActions() {
//        Actions actions = new Actions(driver);
        new Actions(driver).sendKeys(Keys.PAGE_UP).perform();
    }

    //    ACTIONS_SCROLL_RIGHT
    public static void scrollRightActions() {
        new Actions(driver).sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_RIGHT).perform();
    }

    //    ACTIONS_SCROLL_LEFT
    public static void scrollLeftActions() {
        new Actions(driver).sendKeys(Keys.ARROW_LEFT).sendKeys(Keys.ARROW_LEFT).perform();
    }

    //    ACTIONS_DRAG_AND_DROP
    public static void dragAndDropActions(WebElement source, WebElement target) {
//        Actions actions = new Actions(driver);
        new Actions(driver).dragAndDrop(source, target).perform();
    }

    //    ACTIONS_DRAG_AND_DROP_BY
    public static void dragAndDropActions(WebElement source, int x, int y) {
//        Actions actions = new Actions(driver);
        new Actions(driver).dragAndDropBy(source, x, y).perform();

    }

    //    DYNAMIC SELENIUM WAITS:
//===============Explicit Wait==============//
    public static WebElement waitForVisibility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOf(element));

        //alttaki metodla overloading bunlar
    }

    public static WebElement waitForVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Web elementin tiklanilabilirligini su kadar surede dene, o kadar bekle
    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitForClickablility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    // hard wait kullanilarak yapildi, cok kullanilmaz
    public static void clickWithTimeOut(WebElement element, int timeout) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.click();
                return;
            } catch (WebDriverException e) {
                waitFor(1);
            }
        }
    }

    // JAva script executor ==> html tamamen dolana kadar bekle demek. sayfanin tamamen dolup dolmadigini gormek icin
    // yeni sayfaya gecislerde kullanilabilir.
    //    This can be used when a new page opens
    public static void waitForPageToLoad(long timeout) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            System.out.println("Waiting for page to load...");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            wait.until(expectation);
        } catch (Throwable error) {
            System.out.println(
                    "Timeout waiting for Page Load Request to complete after " + timeout + " seconds");
        }
    }

    //======Fluent Wait====
    // params : xpath of teh element , max timeout in seconds, polling in second
    public static WebElement fluentWait(String xpath, int withTimeout, int pollingEvery) {
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(withTimeout))//Wait 3 second each time
                .pollingEvery(Duration.ofSeconds(pollingEvery))//Check for the element every 1 second
                .withMessage("Ignoring No Such Element Exception")
                .ignoring(NoSuchElementException.class);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return element;
    }

    public void selectFromDropdown(WebElement dropdown, String secenek) {
//        selectFromDropdown(driver.findElement(By.xpath("//select[@id='year']")), "2005"); -> year dan 2005
//        selectFromDropdown(driver.findElement(By.xpath("//select[@id='month']")), "January"); -> month January
//        selectFromDropdown(driver.findElement(By.id("day")), "12"); -> Day 12
//        Gonderilen dropdown elemention tum optionslari alinir
        List<WebElement> options = dropdown.findElements(By.tagName("option"));//Tum option tagli elementleri aliyorum
        for (WebElement eachOption : options) {
            if (eachOption.getText().equals(secenek)) {
                eachOption.click();
                break;
            }
        }
    }

    //   SCREENSHOTS
    public void takeScreenShotOfPage() {
//        1. Take screenshot
        File image = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//       2. Save screenshot
//        getting the current time as string to use in teh screenshot name, previous screenshots will be kept
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
//        Path of screenshot save folder               folder / folder    /file name
        String path = System.getProperty("user.dir") + "/test-output/Screenshots/" + currentTime + "image.png";
        try {
            FileUtils.copyFile(image, new File(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //    SCREENSHOT
//    @params: WebElement
//    takes screenshot
    public void takeScreenshotOfElement(WebElement element) throws IOException {
//        1. take screenshot
        File image = element.getScreenshotAs(OutputType.FILE);
//        2. save screenshot
//        path
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir")+"/test-output/Screenshots/"+currentTime+"image.png";
        FileUtils.copyFile(image,new File(path));


    }
    //    Task 5 : Iki parametreli bir Java metot oluşturalım: printData
//    Parameter 1 = row numarasi
//    Parameter 2 = column numarasi
//    printData(2,3);  => 2nd satir, 3rd sutun daki datayı print etsin


//    public void printData(int satir, int sutun){
//        driver.get("https://the-internet.herokuapp.com/tables");
//        String myXpath = "//table[@id='table1']//tbody//tr["+satir+"]//td["+sutun+"]";
//        System.out.println(driver.findElement(By.xpath(myXpath)).getText());
//    }
}