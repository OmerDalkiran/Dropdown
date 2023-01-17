package day12;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_FileUpload extends TestBase {

//    Tests packagenin altina bir class oluşturun : C05_UploadFile
//https://the-internet.herokuapp.com/upload adresine gidelim
//chooseFile butonuna basalim
//Yuklemek istediginiz dosyayi secelim.
//Upload butonuna basalim.
//“File Uploaded!” textinin goruntulendigini test edelim.


    @Test
    public void fileUploadTest(){

        driver.get("https://the-internet.herokuapp.com/upload");

        WebElement chooseFileButton =driver.findElement(By.id("file-upload"));

        String filePath = System.getProperty("user.home")+"/Desktop/logo.jpeg";
    // Dunden kalan path bu
     //  String filePath = userHome+"/Desktop/logo.jpeg";
       // String filePath = userHome+"/Desktop/logo.jpeg";
//        System.out.println(filePath);


        chooseFileButton.sendKeys(filePath);



    }
}
