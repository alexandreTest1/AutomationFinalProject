package ge.example.pages;

import ge.example.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {


    public LoginPage(WebDriver driver){
        super(driver);
    }



    @FindBy(xpath = "(//button[contains(text(),'შესვლა')])[1]")
    WebElement loginButton;

    @FindBy(xpath = "(//input[@placeholder='ელ. ფოსტის მისამართი'])[1]")
    WebElement userMailField;

    @FindBy(xpath = "(//input[@placeholder='პაროლი'])[1]")
    WebElement passwordField;

    @FindBy(xpath = "(//button[contains(text(),'ავტორიზაცია')])[1]")
    WebElement authorizationButton;

    // მეთოდი აღწერს როგორ დავლოგინდე სისტემაში მაილით და პაროლით
    public void login(String username, String password) {


        clickToElementWithWait(loginButton);
        enterText(userMailField,username);
        enterText(passwordField,password);
        clickToElementWithWait(authorizationButton);

    }


}
