package com.telran.oscar.pages.product;

import com.telran.oscar.pages.PageBase;
import org.openqa.selenium.WebDriver;

public class CompInLiteraturePage extends PageBase {
    public CompInLiteraturePage(WebDriver driver) {
        super(driver);
    }

    public boolean isCompInLiteraturePageDisplayed() {
        return isPageHeaderDisplayed();
    }
}
