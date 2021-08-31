package com.telran.oscar.pages.home;

import com.telran.oscar.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContentPage extends PageBase {
    public ContentPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = ".well.well-blank")
    WebElement content;

    @FindBy(css = ".well.promotion_single")
    WebElement promotionContent;

    public boolean isMainContainDisplayed(){
        return content.isDisplayed();
    }
    public boolean isPromotionContentDisplayed(){
        return promotionContent.isDisplayed();
    }
}
