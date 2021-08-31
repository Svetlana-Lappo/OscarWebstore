package com.telran.oscar.pages.user;

import com.telran.oscar.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListsPage extends PageBase {
    public WishListsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='btn-group']/a[@class='btn btn-default']")
    WebElement viewBtn;


    public void clickOnViewBtn() {
        click(viewBtn,2);
    }
}
