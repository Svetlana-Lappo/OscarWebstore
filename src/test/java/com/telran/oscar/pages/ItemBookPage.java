package com.telran.oscar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItemBookPage extends PageBase{
    public ItemBookPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@class='btn btn-lg']")
    WebElement addToWishListBtn;

    @FindBy(xpath = "//div[@class='col-sm-6 product_main']/h1")
    WebElement productName;

    public ItemBookPage clickOnAddWishListBtn(){
        click(addToWishListBtn,2);
        return this;
    }

    public String getProductName(){
        return productName.getText();
    }
}
