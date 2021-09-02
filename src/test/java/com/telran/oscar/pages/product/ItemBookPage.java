package com.telran.oscar.pages.product;

import com.telran.oscar.pages.PageBase;
import com.telran.oscar.pages.home.ContentPage;
import com.telran.oscar.pages.home.HeaderPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItemBookPage extends PageBase {
    public ItemBookPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@class='btn btn-lg']")
    WebElement addToWishListBtn;

    @FindBy(xpath = "//div[@class='col-sm-6 product_main']/h1")
    WebElement productName;
    @FindBy(xpath = "//ul[@class='breadcrumb']/li[1]")
    WebElement homeTab;
    @FindBy(xpath = "//button[@value='Add to basket']")
    WebElement addToBasketBtn;


    public ItemBookPage clickOnAddWishListBtn(){
        click(addToWishListBtn,2);
        return this;
    }

    public String getProductName(){
        return productName.getText();
    }

    public ContentPage clickOnHomeTab() {
        click(homeTab,2);
        return new ContentPage(driver);

    }

    public ItemBookPage clickOnAddToBasketBtn() {
        click(addToBasketBtn,2);
        return this;
    }
}
