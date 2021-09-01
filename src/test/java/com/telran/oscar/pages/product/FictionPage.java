package com.telran.oscar.pages.product;

import com.telran.oscar.pages.PageBase;
import org.openqa.selenium.WebDriver;

public class FictionPage extends PageBase {
    public FictionPage(WebDriver driver) {
        super(driver);
    }


    public boolean isFictionPageDisplayed() {
        return isPageHeaderDisplayed();
    }
}
