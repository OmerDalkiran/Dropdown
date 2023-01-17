package day11;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist {

    @Test
    public void isExistTest (){

        String userDIR = System.getProperty("user.dir");
        System.out.println(userDIR);                         // C:\Users\ich\Desktop\Batch103\src\test\java\com.B103Maven_Junit


        String userHome = System.getProperty("user.home");
        System.out.println(userHome);                          //  C:\Users\ich


        String filePath = userHome+"/Desktop/logo.jpeg";
        System.out.println(filePath);

        boolean isExist = Files.exists(Paths.get(filePath));
        Assert.assertTrue(isExist);

    }

}
