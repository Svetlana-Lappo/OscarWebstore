package com.telran.oscar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends PageBase{

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[.='Email History']")
    WebElement emailHistoryBtn;

    @FindBy(xpath = "//a[.='Order History']")
    WebElement orderHistoryBtn;

    @FindBy(xpath = "//a[.='Address Book']")
    WebElement addressBookBtn;

    public EmailHistoryPage clickOnEmailHistoryBtn(){
        click(emailHistoryBtn,2);
        return new EmailHistoryPage(driver);
    }

    public OrderHistoryPage clickOnOrderHistoryBtn(){
        click(orderHistoryBtn,2);
        return new OrderHistoryPage(driver);
    }
    public AddressBookPage clickOnAddressBookBtn(){
        click(addressBookBtn,2);
        return new AddressBookPage(driver);
    }


}
