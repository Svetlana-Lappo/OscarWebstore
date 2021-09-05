package com.telran.oscar.pages.basket;

import com.telran.oscar.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WhoAreYouPage extends PageBase {
    public WhoAreYouPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = ".form-stacked.well")
    WebElement whoAreYouForm;

    public boolean isWhoAreYouFormDisplayed(){
        return whoAreYouForm.isDisplayed();
    }
}
