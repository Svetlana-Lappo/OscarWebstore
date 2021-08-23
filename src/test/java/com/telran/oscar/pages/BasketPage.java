package com.telran.oscar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasketPage extends PageBase{
    public BasketPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@class='btn btn-lg btn-primary btn-block']")
    WebElement proceedToCheckoutBtn;


    public ShippingAddressPage clickOnProceedToCheckoutBtn(){
        click(proceedToCheckoutBtn,2);
        return new ShippingAddressPage(driver);
    }
}
