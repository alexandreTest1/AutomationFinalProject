package ge.example.pages;

import ge.example.BasePage;
import ge.example.BaseTest;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.lessThan;


    // ეს კლასი შეიცავს RestAssured-ის დახმარებით API ტესტირებისათვის საჭირო ნაბიჯებს
public class UsersApiPage extends BaseTest {



    // მეთოდი იღებს page პარამეტრს და აბრუნებს სტატუს კოდს.
    public static int getUsersStatusCode(int page) {
        RestAssured.baseURI = "https://reqres.in/api";
        return given()
                .queryParam("page", page)
                .when()
                .get("/users")
                .then()
                .extract()
                .statusCode();
    }
}
