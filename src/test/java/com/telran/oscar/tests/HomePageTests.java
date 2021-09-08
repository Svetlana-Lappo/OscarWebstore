package com.telran.oscar.tests;

import com.telran.oscar.pages.basket.BasketPage;
import com.telran.oscar.pages.home.ContentPage;
import com.telran.oscar.pages.home.HeaderPage;
import com.telran.oscar.pages.home.SidePanelPage;
import com.telran.oscar.pages.product.BooksPage;
import com.telran.oscar.pages.product.ClothingPage;
import com.telran.oscar.pages.product.OffersPage;
import com.telran.oscar.pages.product.ProductPage;
import com.telran.oscar.pages.user.AccountSidePanelPage;
import com.telran.oscar.pages.user.LoginPage;
import com.telran.oscar.pages.user.RegisterPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase{
    HeaderPage headerPage;
    ProductPage productPage;
    SidePanelPage sidePanelPage;
    ContentPage contentPage;
    LoginPage loginPage;
    RegisterPage registerPage;
    BasketPage basketPage;
    AccountSidePanelPage accountSidePanelPage;
    BooksPage booksPage;
    ClothingPage clothingPage;
    OffersPage offersPage;



    @BeforeMethod
    public void pageInit(){
        headerPage = PageFactory.initElements(driver, HeaderPage.class);
        productPage = PageFactory.initElements(driver,ProductPage.class);
        sidePanelPage = PageFactory.initElements(driver,SidePanelPage.class);
        contentPage = PageFactory.initElements(driver,ContentPage.class);
        loginPage = PageFactory.initElements(driver,LoginPage.class);
        registerPage = PageFactory.initElements(driver,RegisterPage.class);
        basketPage = PageFactory.initElements(driver,BasketPage.class);
        accountSidePanelPage = PageFactory.initElements(driver,AccountSidePanelPage.class);
        booksPage = PageFactory.initElements(driver,BooksPage.class);
        clothingPage = PageFactory.initElements(driver,ClothingPage.class);
        offersPage = PageFactory.initElements(driver,OffersPage.class);
    }

    @Test(enabled = false)
    public void selectMenuPositiveTest(){
        headerPage.selectCategory();
        Assert.assertTrue(productPage.isItProductPage());
    }

    @Test
    public void elementsDisplayedTest(){
        Assert.assertTrue(headerPage.isSelectLanguageBtnDisplayed());
        Assert.assertTrue(headerPage.isGoBtnDisplayed());
        Assert.assertTrue(headerPage.isLoginOrRegisterBtnDisplayed());
        Assert.assertTrue(headerPage.isBasketTotalDisplayed());
        Assert.assertTrue(headerPage.isViewBasketBtnDisplayed());
        Assert.assertTrue(headerPage.isLogoLinkDisplayed());
        Assert.assertTrue(sidePanelPage.isNavigationPanelDisplayed());
        Assert.assertTrue(sidePanelPage.isSearchBtnDisplayed());
        Assert.assertTrue(sidePanelPage.isSearchFieldDisplayed());

    }
    @Test(enabled = false)
    public void elementsDisplayedForRegisteredUserTest(){
        headerPage.selectLanguage("en-gb");
        headerPage.goToRegistrationAndLogin();
        loginPage.fillLoginForm("zebra@gmail.com","Zebra_1812").clickOnLogInBtn();
        Assert.assertTrue(headerPage.isLogoutBtnDisplayed());
        Assert.assertTrue(headerPage.isAccountBtnDisplayed());
    }

    @Test
    public void elementsClickableTest(){
        Assert.assertTrue(headerPage.isLoginOrRegisterBtnClickable());
        Assert.assertTrue(headerPage.isGoBtnClickable());
        Assert.assertTrue(headerPage.isSelectLanguageBtnClickable());
        Assert.assertTrue(headerPage.isLogoLinkClickable());
        Assert.assertTrue(headerPage.isViewBasketBtnClickable());
        Assert.assertTrue(sidePanelPage.isSearchBtnClickable());

    }

    @Test(enabled = false)
    public void elementsClickableForRegisteredUserTest(){
        headerPage.selectLanguage("en-gb");
        headerPage.goToRegistrationAndLogin();
        loginPage.fillLoginForm("zebra@gmail.com","Zebra_1812").clickOnLogInBtn();
        Assert.assertTrue(headerPage.isLogoutBtnClickable());
        Assert.assertTrue(headerPage.isAccountBtnClickable());
    }
    @Test(enabled = false)
    public void loginOrRegisterBtnRedirectToLoginOrRegisterPagesTest(){
        headerPage.goToRegistrationAndLogin();
        Assert.assertTrue(registerPage.isRegisterFormDisplayed());
    }
    @Test(enabled = false)
    public void viewBasketBtnRedirectToBasketTest(){
        headerPage.clickOnViewBasketBtn();
        Assert.assertTrue(basketPage.isBasketPageDisplayed());
    }
    @Test(enabled = false)
    public void siteTitleRedirectToHomePage(){
        headerPage.clickOnLogoLink();
        Assert.assertTrue(sidePanelPage.isNavigationPanelDisplayed());
    }
    @Test(enabled = false)
    public void accountBtnRedirectToAccountPage(){
        headerPage.selectLanguage("en-gb");
        headerPage.goToRegistrationAndLogin();
        loginPage.fillLoginForm("zebra@gmail.com","Zebra_1812").clickOnLogInBtn();
        headerPage.clickOnAccountBtn();
        Assert.assertTrue(accountSidePanelPage.isAccountSidePanelDisplayed());
    }
    @Test(enabled = false)
    public void logoutBtnRedirectToHomePage(){
        headerPage.selectLanguage("en-gb");
        headerPage.goToRegistrationAndLogin();
        loginPage.fillLoginForm("zebra@gmail.com","Zebra_1812").clickOnLogInBtn();
        headerPage.clickOnLogOutBtn();
        Assert.assertTrue(contentPage.isMainContainDisplayed());

    }
    @Test(enabled = false)
    public void allProductsTabRedirectToAllProductsPage(){
        headerPage.selectLanguage("en-gb");
        sidePanelPage.clickOnAllProductsTabOnSidePanel();
        Assert.assertTrue(productPage.isItProductPage());

    }
    @Test(enabled = false)
    public void BooksTabRedirectToBooksPage(){
        headerPage.selectLanguage("en-gb");
        sidePanelPage.clickOnBooksTabOnSidePanel();
        Assert.assertTrue(booksPage.isBooksPageDisplayed());

    }
    @Test(enabled = false)
    public void ClothingTabRedirectToClothingPage(){
        headerPage.selectLanguage("en-gb");
        sidePanelPage.clickOnClothingTabOnSidePanel();
        Assert.assertTrue(clothingPage.isClothingPageDisplayed());

    }
    @Test(enabled = false)
    public void OffersTabRedirectToOffersPage(){
        headerPage.selectLanguage("en-gb");
        sidePanelPage.clickOnOffersTabOnSidePanel();
        Assert.assertTrue(offersPage.isOffersPageDisplayed());

    }

}
