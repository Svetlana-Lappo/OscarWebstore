package com.telran.oscar.pages.product;

import com.telran.oscar.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OffersPage extends PageBase {
    public OffersPage(WebDriver driver) {
        super(driver);
    }


    public boolean isOffersPageDisplayed() {
        return  isPageHeaderDisplayed();
    }
}
