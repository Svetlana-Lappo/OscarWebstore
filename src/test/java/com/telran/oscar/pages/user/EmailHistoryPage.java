package com.telran.oscar.pages.user;

import com.telran.oscar.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailHistoryPage extends PageBase {
    public EmailHistoryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "td:nth-child(2)")
    WebElement emailCreateDate;

    public String getCreateDateOfEmail() {

        String[] dataInfo = emailCreateDate.getText().split(",");
        return dataInfo[0];

    }
}
