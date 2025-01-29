package ge.example.tests;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import ge.example.BaseTest;


import ge.example.pages.*;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends BaseTest {

    @Test (priority = 1)
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(driver);

        // ავტორიზაცია მეილით და პაროლით
        loginPage.login("alexfortest9@gmail.com", "shemishvi");

        // Url შემოწმება wait-ის მეშვეობით
        String expectedUrl = "https://ee.ge/";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));

        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl, "URL არ ემთხვევა");

    }



    @Test (priority = 2)
    // ეს მეთოდი აბრუნებს სამსუნგის პროდუქტების სიას

    public void searchProduct() {
    ProductListPage productListPage = new ProductListPage(driver);

    // Samsung-ის პროდუქტების სიაზე გადასვლა
    productListPage.search("samsung");

    // Url შემოწმება wait-ის მეშვეობით
    String expectedUrl = "https://ee.ge/search-product-list?s=samsung&page=1";

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.urlToBe(expectedUrl));

    String actualUrl = driver.getCurrentUrl();
    Assert.assertEquals(actualUrl,expectedUrl, "URL არ იძებნება");



}


@Test (priority = 3)

// ეს მეთოდი ამოწმებს დაემატა თუარა არჩეული პროდუქტი სიაში
    public void testCheckoutPage(){
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        // კალათაში დამატებული პროდუქტის გვერდზე გადასვლა
        checkoutPage.checkout();

    // Url შემოწმება wait-ის მეშვეობით
    String expectedUrl = "https://ee.ge/checkout";

    // Url შემოწმება wait-ის მეშვეობით
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.urlToBe(expectedUrl));

    String actualUrl = driver.getCurrentUrl();
    Assert.assertEquals(actualUrl,expectedUrl, "Url არ მოიძებნა");


    Cart cart = new Cart(driver);

    String expectedCartHeaderText = "Samsung EP-T2510NBEGRU";
    String actualCartHeaderText = cart.getCartHeaderText();

    Assert.assertEquals(actualCartHeaderText, expectedCartHeaderText,"ტექსტი არ ემთხვევა");



}

    @Test

    // მეთოდი ამოწმებს სტატუს კოდს
    public void testStatusCode() {
        int statusCode = UsersApiPage.getUsersStatusCode(2);
        Assert.assertEquals(statusCode, 200, "სტატუს კოდი არ ემთხვევა");

    }

}
