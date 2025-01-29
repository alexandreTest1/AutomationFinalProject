package ge.example.pages;

import ge.example.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Cart extends BasePage {

    public Cart(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "(//span[@class='cursor_pointer'][normalize-space()='Samsung EP-T2510NBEGRU'])[1]")
    WebElement cartHeaderText;

    // მეთოდი ამოწმებს დამატებული პროდუქტის დასახელებას

    public String getCartHeaderText(){

        return getElementText(cartHeaderText);

    }
}