package com.telran.oscar.pages.basket;

import com.telran.oscar.pages.PageBase;
import org.openqa.selenium.By;
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

    @FindBy(xpath = "//div[@class='col-sm-4']//a")
    List<WebElement> listProductsInBasket;

    @FindBy(xpath = "//div[@class='col-sm-2']/p[@class='price_color align-right']")
    List <WebElement> totalPriceList;

    @FindBy(xpath = "//div[@class='col-sm-1']/p[@class='price_color align-right']")
    List <WebElement> priceList;

    @FindBy(id = "id_form-0-quantity")
    WebElement productQuantity;

    @FindBy(xpath = "//span[@class='input-group-btn']/button[@type='submit']")
    List<WebElement> updateBtnList;

    @FindBy (xpath = "//span[@class='error-block']")
    WebElement errMessageForEmptyQuantity;

    @FindBy(css = "tr:nth-child(2) th:nth-child(2)")
    WebElement basketTotal;





    public ShippingAddressPage clickOnProceedToCheckoutBtn(){
        click(proceedToCheckoutBtn,2);
        return new ShippingAddressPage(driver);
    }


    public boolean isBasketPageDisplayed(){
        return isPageHeaderDisplayed();
    }

    public boolean isAddedProductInBasket(String title){
        if(listProductsInBasket!=null){
        for (WebElement product:listProductsInBasket) {

         if(product.getText().contains(title)) {
             return true; }
        }
        }
            return false;

    }

    public Double getTotalPriceForProductItem(int itemNumber){
        return Double.parseDouble(removeFirstChar(totalPriceList.get(itemNumber).getText()));


    }

    public Double getPriceForProductItem(int itemNumber){
        return Double.parseDouble(removeFirstChar(priceList.get(itemNumber).getText()));


    }
    public BasketPage setProductQuantity(String quantity){
        type(productQuantity,1,quantity);
        return this;
    }

    public BasketPage setProductQuantity1(String productNumber, String quantity){
        WebElement element = driver.findElement(By.id("id_form-"+productNumber+"-quantity"));
        type(element,2,quantity);
        return this;
    }


    public BasketPage clickOnUpdateBtn(int productNumber) {
        click(updateBtnList.get(productNumber), 1);
        return this;

    }

    public String getErrorMessage() {
        return errMessageForEmptyQuantity.getText();
    }

    public Double getBasketTotal(){
        Double basketTotalPrice = Double.parseDouble(removeFirstChar(basketTotal.getText()));
        return basketTotalPrice;
    }


}
