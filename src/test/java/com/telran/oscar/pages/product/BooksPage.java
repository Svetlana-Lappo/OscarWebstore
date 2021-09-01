package com.telran.oscar.pages.product;

import com.telran.oscar.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BooksPage extends PageBase {
    public BooksPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//ol[@class='row']/li[3]//button[@type='submit']")
    WebElement addToBasketBtnForThirdProduct;

    @FindBy(xpath = "//ol[@class='row']/li[3]//div[@class='image_container']")
    WebElement imgForThirdProduct;
    @FindBy(xpath = "//ol[@class='row']/li[3]//h3")
    WebElement titleOfThirdProduct;



    public boolean isBooksPageDisplayed() {
        return isPageHeaderDisplayed();
    }

    public void clickOnAddBasketForThirdProduct(){
        click(addToBasketBtnForThirdProduct,2);
    }

    public ItemBookPage clickOnThirdProduct(){
        click(imgForThirdProduct,2);
        return new ItemBookPage(driver);
    }

    public String getNameOfThirdProduct(){
        return titleOfThirdProduct.getText();
    }


}
