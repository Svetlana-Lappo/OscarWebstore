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

    @FindBy(xpath = "//ol[@class='row']/li[3]//div[@class='image_container']")
    WebElement imgForThirdProduct;

    public void clickOnAddBasketForThirdProduct(){
        click(addToBasketBtnForThirdProduct,2);
    }

    public ItemBookPage clickOnThirdProduct(){
        click(imgForThirdProduct,2);
        return new ItemBookPage(driver);
    }


}
