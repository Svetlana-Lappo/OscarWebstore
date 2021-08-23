package com.telran.oscar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PreviewOrderPage extends PageBase{
    public PreviewOrderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "place-order")
    WebElement placeOrderBtn;

    public void clickOnPlaceOrderBtn() {
        click(placeOrderBtn,2);
    }
}
