package com.telran.oscar.tests;

import com.telran.oscar.pages.home.HeaderPage;
import com.telran.oscar.pages.home.SidePanelPage;
import com.telran.oscar.pages.product.BooksPage;
import com.telran.oscar.pages.product.ItemBookPage;
import com.telran.oscar.pages.user.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WishListsPageTests extends TestBase{
    SidePanelPage sidePanelPage;
    HeaderPage headerPage;
    BooksPage booksPage;
    ItemBookPage itemBookPage;
    AccountSidePanelPage accountSidePanelPage;
    WishListsPage wishListsPage;
    WishLists_DefaultPage wishLists_DefaultPage;
    RegisterPage registerPage;
    ProfilePage profilePage;
    DeleteProfilePage deleteProfilePage;


    @BeforeMethod

    public void ensurePreCondition(){
        sidePanelPage = PageFactory.initElements(driver, SidePanelPage.class);
        headerPage = PageFactory.initElements(driver, HeaderPage.class);
        registerPage = PageFactory.initElements(driver, RegisterPage.class);
        booksPage = PageFactory.initElements(driver, BooksPage.class);
        itemBookPage = PageFactory.initElements(driver, ItemBookPage.class);
        accountSidePanelPage = PageFactory.initElements(driver, AccountSidePanelPage.class);
        wishListsPage = PageFactory.initElements(driver, WishListsPage.class);
        wishLists_DefaultPage = PageFactory.initElements(driver, WishLists_DefaultPage.class);
        profilePage = PageFactory.initElements(driver, ProfilePage.class);
        deleteProfilePage = PageFactory.initElements(driver, DeleteProfilePage.class);
        headerPage.selectLanguage("en-gb");
        headerPage.goToRegistrationAndLogin();
        registerPage.fillRegisterForm("zebra17@gmail.com","Zebra_1817","Zebra_1817").clickOnRegisterBtn();

    }

    @Test
    public void addBookToWishListPositiveTest(){
        sidePanelPage.clickOnBooksTabOnSidePanel();
        booksPage.clickOnChosenProduct(3);
        String productName = itemBookPage.getProductName();
        itemBookPage.clickOnAddWishListBtn();
        headerPage.clickOnAccountBtn();
        accountSidePanelPage.clickOnWishListsBtn();
        wishListsPage.clickOnViewBtn();
        Assert.assertEquals(wishLists_DefaultPage.getProductNameWishList(), productName);
    }
    @AfterMethod
    public void cleanUp(){
        accountSidePanelPage.clickOnProfileBtn();
        profilePage.clickOnDeleteProfileBtn();
        deleteProfilePage.typeProfilePassword("Zebra_1817").clickOnDeleteBtn();
    }
}
