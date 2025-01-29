package ge.example.pages;

import ge.example.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }



    @FindBy(xpath = "(//img[@src='/images/cart.png'])[1]")
    WebElement cartImage;



    // ეს მეთოდი აღწერს კალათის ღილაკზე კლიკს
    public void checkout(){


        clickToElementWithWait(cartImage);


    }

}
