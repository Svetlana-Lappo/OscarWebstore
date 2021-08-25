package com.telran.oscar.tests;

import com.telran.oscar.pages.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WishListsPageTests extends TestBase{
    HomePage homePage;
    LoginPage loginPage;
    BooksPage booksPage;
    ItemBookPage itemBookPage;
    AccountSidePanelPage accountSidePanelPage;
    WishListsPage wishListsPage;
    WishLists_DefaultPage wishLists_DefaultPage;

    @BeforeMethod

    public void ensurePreCondition(){
        homePage = PageFactory.initElements(driver, HomePage.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        booksPage = PageFactory.initElements(driver, BooksPage.class);
        itemBookPage = PageFactory.initElements(driver, ItemBookPage.class);
        accountSidePanelPage = PageFactory.initElements(driver, AccountSidePanelPage.class);
        wishListsPage = PageFactory.initElements(driver, WishListsPage.class);
        wishLists_DefaultPage = PageFactory.initElements(driver, WishLists_DefaultPage.class);
        homePage.selectLanguage("en-gb");
        homePage.goToRegistrationAndLogin();
        loginPage.fillLoginForm("zebra@gmail.com","Zebra_1812").clickOnLogInBtn();
    }

    @Test
    public void addBookToWishListPositiveTest(){
        homePage.clickOnBooksTabOnSidePanel();
        booksPage.clickOnThirdProduct();
        String productName = itemBookPage.getProductName();
        itemBookPage.clickOnAddWishListBtn();
        homePage.clickOnAccountBtn();
        accountSidePanelPage.clickOnWishListsBtn();
        wishListsPage.clickOnViewBtn();
        Assert.assertEquals(wishLists_DefaultPage.getProductNameWishList(), productName);
    }
}
