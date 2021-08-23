package com.telran.oscar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BooksPage extends PageBase{
    public BooksPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//ol[@class='row']/li[3]//button[@type='submit']")
    WebElement addToBasketBtnForThirdProduct;

    public void clickOnAddBasketForThirdProduct(){
        click(addToBasketBtnForThirdProduct,2);
    }


}
