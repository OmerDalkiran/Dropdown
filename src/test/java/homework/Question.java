package homework;

import utilities.TestBase;
import org.junit.Test;

public class Question extends TestBase {

    @Test
    public void test01 (){

        /*
1) Open the browser
2) Enter the URL “http://practice.automationtesting.in/”
3) Click on Shop Menu
4) Now click on Home menu button
5) Test whether the Home page has Three Arrivals only
6) The Home page must contains only three Arrivals
7) Now click the image in the Arrivals
8) Test whether it is navigating to next page where the user can add that book into his basket.
9) Image should be clickable and shoul navigate to next page where user can add that book to his basket
10) Click on the Add To Basket button which adds that book to your basket
11) User can view that Book in the Menu item with price.
12) Now click on Item link which navigates to proceed to check out page.
13) User can click on the Item link in menu item after adding the book in to the basket which leads to the check out page
14) Enter the Coupon code as ‘krishnasakinala’ to get 50rps off on the total.
15) User can able to apply coupon by entering ‘krishnasakinala’ in the coupon textbox which give 50rps off on the total price
 */

        driver.get("http://practice.automationtesting.in/");

    }




}
