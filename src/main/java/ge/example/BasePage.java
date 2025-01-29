package ge.example;

import ge.example.utils.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }

    // მეთოდი ელოდება ვიდრე ელემენტი არ გახდება დაკლიკებადი და შემდეგ იწერება ქის მნიშვნელობა
    public void enterText(WebElement locator, String text) {
        waitForElementToBeClickable(locator);
        locator.sendKeys(text);
        Utils.log("მოვძებნე ელემენტი: [ " + locator +" ] გადავეცი ტექსტი: " + text);

    }

    // მეთოდი აღწერს ელემენტზე დაკლიკებას
    public void clickToElement(WebElement locator) {
        locator.click();
        Utils.log("დავაკლიკე [ " + locator + " ] -ზე");
    }

    // მეეთოდი აღწერს ელემენტზე კლიკს ვეითის საშუალებით
    public void clickToElementWithWait(WebElement locator) {
        waitForElementToBeClickable(locator);
        clickToElement(locator);

    }

    // მეთოდი ელოდება როდის გახდება ელემენტი დაკლიკებადი
    public void waitForElementToBeClickable(WebElement locator) {
        Utils.log("ველოდები რომ ელემენტი [ " + locator + " ] გახდეს დაკლიკებადი");
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        Utils.log("ვიპოვე ელემენტი [ " + locator + " ]");
    }

    // მეთღოდს მოაქვს ელემენტის სახელი
    public String getElementText(WebElement locator) {
        waitForElementToBeVisible(locator);

       return locator.getText();
    }


    // მეთოდი ელოდება როდის გახდება ელემენტი ხილვადი ვეითის გამოყენებით
    public void waitForElementToBeVisible(WebElement locator) {
        Utils.log("ველოდები რომ ელემენტი [ " + locator + " ] გამოჩნდეს");
        wait.until(ExpectedConditions.visibilityOf(locator));
        Utils.log("ელემენტი [ " + locator + " ] გამოჩნდა");
    }

}
