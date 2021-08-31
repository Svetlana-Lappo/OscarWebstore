package com.telran.oscar.pages.user;

import com.telran.oscar.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountSidePanelPage extends PageBase {
    public AccountSidePanelPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[.='Email History']")
    WebElement emailHistoryBtn;

    @FindBy(xpath = "//a[.='Order History']")
    WebElement orderHistoryBtn;

    @FindBy(xpath = "//a[.='Address Book']")
    WebElement addressBookBtn;

    @FindBy(xpath = "//a[.='Wish Lists']")
    WebElement wishListsBtn;

    @FindBy(xpath = "//a[.='Profile']")
    WebElement profileBtn;

    @FindBy(css = ".nav.nav-pills.nav-stacked")
    WebElement sidePanel;


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

    public WishListsPage clickOnWishListsBtn(){
        click(wishListsBtn,2);
        return new WishListsPage(driver);
    }

    public ProfilePage clickOnProfileBtn(){
        click(profileBtn,2);
        return new ProfilePage(driver);
    }
    public boolean isAccountSidePanelDisplayed(){
        return sidePanel.isDisplayed();
    }
}
