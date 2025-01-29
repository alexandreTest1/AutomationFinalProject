package ge.example;

import com.google.errorprone.annotations.RestrictedApi;
import ge.example.utils.ConfigReader;
import ge.example.utils.DriverManager;
import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class BaseTest {
    protected WebDriver driver;

@BeforeMethod
    public void setUp() {
        driver = DriverManager.getDriver();
        driver.manage().window().maximize();
        driver.get("https://ee.ge/");


    }



    /*@AfterMethod
    public void tearDown() {
        DriverManager.quit();
    }*/

}

