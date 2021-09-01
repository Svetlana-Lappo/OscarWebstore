package com.telran.oscar.pages.product;

import com.telran.oscar.pages.PageBase;
import org.openqa.selenium.WebDriver;

public class HackingPage extends PageBase {
    public HackingPage(WebDriver driver) {
        super(driver);
    }

    public boolean isHackingPageDisplayed() {
        return isPageHeaderDisplayed();
    }
}
