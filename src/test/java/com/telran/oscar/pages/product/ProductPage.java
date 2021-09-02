package com.telran.oscar.pages.product;

import com.telran.oscar.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends PageBase {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//li[@class='next']/a")
    WebElement nextBtn;
    @FindBy(xpath = "//li[@class='previous']/a")
    WebElement previousBtn;




    public boolean isItProductPage() {
        return isPageHeaderDisplayed();
    }

    public ProductPage clickOnNextBtn(){
        click(nextBtn,2);
        return this;
    }


    public ProductPage clickOnPreviousBtn() {
        click(previousBtn,2);
        return this;
    }



}
