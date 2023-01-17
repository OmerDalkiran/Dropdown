package day09;

import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C04_Cookies extends TestBase {

    @Test

    public void handleCookiesTest (){

//        Class: Cookies
//Method: handleCookies


//Amazona git
//1.toplam cookie sayisini bul
//2. Bir Cookie yi smiyle bul
//3. Yeni bir cookie ekle
//4. Bir Cookie yi ismiyle sil
//5. Tum cookie leri sil


        //        Amazona git
        driver.get("https://www.amazon.com");
        waitFor(3);
//        1.toplam cookie sayisini bul
        Set<Cookie> allCookies = driver.manage().getCookies();
        int cookieSayisi = allCookies.size();
        System.out.println("Sayfada "+cookieSayisi+ " adet cookie var");

//2. Bir Cookie yi ismiyle bul

        driver.manage().getCookieNamed("i18n-prefs=USD");

        System.out.println("Cookie'yi ismiyle cagiriyorum : "+driver.manage().getCookieNamed("i18n-prefs=USD"));




        allCookies.stream().forEach(t->System.out.println(t.getName()));

        for (Cookie eachCookie : allCookies){
            System.out.println("Cookie : "+ eachCookie);  // Cookie nin tamamini yazdik
            System.out.println("Cookie isimleri : "+ eachCookie.getName());

            //3. Yeni bir cookie ekle
            Cookie favoriteCookie= new Cookie("Cikolatam","antep-Fistikli-Cikolota");
          driver.manage().addCookie(favoriteCookie);

            System.out.println("Yeni cookies sayisi : "+driver.manage().getCookies().size());

            //4. Bir Cookie yi ismiyle sil
            driver.manage().deleteCookieNamed("session-id");


            //5. Tum cookie leri sil
          driver.manage().deleteAllCookies();
          waitFor(3);
            System.out.println("Yeni cookie sayisi :" + driver.manage().getCookies().size());
        }
    }
}
