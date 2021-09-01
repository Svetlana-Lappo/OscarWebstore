package com.telran.oscar.pages.product;

import com.telran.oscar.pages.PageBase;
import org.openqa.selenium.WebDriver;

public class NonFictionPage extends PageBase {
    public NonFictionPage(WebDriver driver) {
        super(driver);
    }

    public boolean isNonFictionPageDisplayed() {
        return isPageHeaderDisplayed();
    }
}
