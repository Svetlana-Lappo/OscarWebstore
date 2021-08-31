package com.telran.oscar.pages.user;

import com.telran.oscar.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishLists_DefaultPage extends PageBase {
    public WishLists_DefaultPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "tr:nth-child(2) td:nth-child(2)")
    WebElement productName;

    public String getProductNameWishList(){
        return productName.getText();
    }
}
