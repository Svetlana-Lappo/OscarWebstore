package com.telran.oscar.pages.basket;

import com.telran.oscar.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfirmationPage extends PageBase {
    public ConfirmationPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//div[@class='col-sm-4 col-sm-offset-4']//a[@class='btn btn-primary btn-block btn-lg']")
    WebElement continueShoppingBtn;

    @FindBy(xpath = "//p[@class='lead']/strong")
    WebElement orderNumber;

    @FindBy(xpath = "//h3[@class='price_color']")
    WebElement orderTotal;

    public void clickOnContinueShoppingBtn() {
        click(continueShoppingBtn,2);

    }

    public String getOrderNumber(){
        return orderNumber.getText();
    }
    public String getOrderTotal(){
        return orderTotal.getText();
    }
}
