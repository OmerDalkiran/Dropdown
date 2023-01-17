package day14;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class C03_ExtentReports extends TestBase {

    protected static ExtentReports extentReports;
    protected static ExtentHtmlReporter extentHtmlReporter;
    protected static ExtentTest extentTest;   // yazma isleminde kullanilir


    @Test
    public void extendReportsTest(){

//
            //      REPORT  PATH
            String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
            String path = System.getProperty("user.dir")+"/test-output/reports/"+currentTime+"html_report.html";


//        creating HTML report in the path
            extentHtmlReporter = new ExtentHtmlReporter(path);


//        creating extent reports object for generating the Entire reports with configuration
            extentReports = new ExtentReports();

    // ************************************************ Customize The Report *************************************


        extentReports.setSystemInfo("Test Environment","Regression");
        extentReports.setSystemInfo("Application","TechPro Education");
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Takim","Eagles");
        extentReports.setSystemInfo("Epic","Odeme Sayfasi");
        extentReports.setSystemInfo("Sprint Numarasi","Sprint-145");
        extentReports.setSystemInfo("QA", "Omer Dalkiran");


        // **********************************Extra Rapor ismi ve documan ismi ekleyebiliriz. *************************************

        extentHtmlReporter.config().setDocumentTitle("TechProEdu Extent Reports");
        extentHtmlReporter.config().setReportName("Regression Test Result");

        //******************************* Rapor Ayarlari Bitti *******************************************

        // Raporu projeme ekliyorum

        extentReports.attachReporter(extentHtmlReporter);

        extentTest = extentReports.createTest("My First Extent Report Login Test","Smoke Test Raporu");

        extentTest.pass("Bu bir bilgilendirme mesajidir. Kullanici ana sayfaya gitsin");

        driver.get("https://www.techproeducation.com");

        // Kullanici LMS sayfasina gider.
        extentTest.pass("Kullanici LMS sayfasina gider");
        driver.findElement(By.linkText("LMS LOGIN")).click();

        //Test Bitti
        extentTest.pass("Test basariyla gecti");

        // Raporu gostermek icin .flush() yapmamiz lazim. hem olusturur hem kapatir .Raporun olusmasi icin zorunludur.
        extentReports.flush();


    }
}
