package ge.example.pages;

import ge.example.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class ProductListPage extends BasePage {

    public ProductListPage(WebDriver driver) {
        super(driver);
    }
  ;

    @FindBy(xpath = "(//input[@id='search_list'])[1]")
    WebElement searchField;

    @FindBy(xpath = "(//i[@class='fa fa-search'])[1]")
    WebElement searchButton;

    @FindBy(xpath = "(//button[contains(@class,'btn-darkred mb-2 add_to_cart')])[1]")
    WebElement addToCartButton;

        // მეთოდი აღწერს როგორ მოვძებნო პროდუქტი სერჩის ფუნქციის საშუალებით
        public void search(String text){

            enterText(searchField, text);
            clickToElementWithWait(searchButton);
            clickToElementWithWait(addToCartButton);
        }
}