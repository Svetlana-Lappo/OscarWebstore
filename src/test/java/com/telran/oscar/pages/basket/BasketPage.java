package com.telran.oscar.pages.basket;

import com.telran.oscar.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BasketPage extends PageBase {
    public BasketPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@class='btn btn-lg btn-primary btn-block']")
    WebElement proceedToCheckoutBtn;
    @FindBy(xpath = "//div[@class='col-sm-4']")
    List<WebElement> listProductsInBasket;
    @FindBy(xpath = "//div[@class='col-sm-4']//a[contains(text(),'Coders at Work')]")
    WebElement titleOfThirdProduct;



    public void createOder(){

    }


    public ShippingAddressPage clickOnProceedToCheckoutBtn(){
        click(proceedToCheckoutBtn,2);
        return new ShippingAddressPage(driver);
    }


    public boolean isBasketPageDisplayed(){
        return isPageHeaderDisplayed();
    }

    public boolean isAddedProductInBasket(String title){
        for (WebElement product:listProductsInBasket) {

         if(product.getText().contains(title)) {
             return true;
        }
        }
        return false;
    }


}
