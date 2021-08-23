package com.telran.oscar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderHistoryPage extends PageBase{
    public OrderHistoryPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "td:nth-child(1)")
    WebElement orderNumberHistory;

    @FindBy(css = "td:nth-child(3)")
    WebElement orderTotalHistory;



    public String getOrderNumber(){
        return orderNumberHistory.getText();
    }
    public String getOrderTotal(){
        return orderTotalHistory.getText();
    }


}
