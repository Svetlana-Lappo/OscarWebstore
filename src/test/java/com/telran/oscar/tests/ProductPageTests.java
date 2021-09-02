package com.telran.oscar.tests;

import com.telran.oscar.pages.basket.BasketPage;
import com.telran.oscar.pages.home.ContentPage;
import com.telran.oscar.pages.home.HeaderPage;
import com.telran.oscar.pages.home.SidePanelPage;
import com.telran.oscar.pages.product.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductPageTests extends TestBase {
    ProductPage productPage;
    HeaderPage headerPage;
    SidePanelPage sidePanelPage;
    CategoriesNaviPanelPage categoriesNaviPanelPage;
    ClothingPage clothingPage;
    BooksPage booksPage;
    FictionPage fictionPage;
    CompInLiteraturePage compInLiteraturePage;
    NonFictionPage nonFictionPage;
    EssentialProgrammingPage essentialProgrammingPage;
    HackingPage hackingPage;
    ItemBookPage itemBookPage;
    ContentPage contentPage;
    BasketPage basketPage;

    @BeforeMethod
    public void ensurePrecondition(){
        headerPage = PageFactory.initElements(driver, HeaderPage.class);
        sidePanelPage = PageFactory.initElements(driver, SidePanelPage.class);
        categoriesNaviPanelPage = PageFactory.initElements(driver, CategoriesNaviPanelPage.class);
        clothingPage = PageFactory.initElements(driver, ClothingPage.class);
        booksPage = PageFactory.initElements(driver, BooksPage.class);
        fictionPage = PageFactory.initElements(driver, FictionPage.class);
        compInLiteraturePage = PageFactory.initElements(driver, CompInLiteraturePage.class);
        nonFictionPage = PageFactory.initElements(driver, NonFictionPage.class);
        essentialProgrammingPage = PageFactory.initElements(driver, EssentialProgrammingPage.class);
        hackingPage = PageFactory.initElements(driver, HackingPage.class);
        productPage = PageFactory.initElements(driver, ProductPage.class);
        itemBookPage = PageFactory.initElements(driver, ItemBookPage.class);
        contentPage = PageFactory.initElements(driver, ContentPage.class);
        basketPage = PageFactory.initElements(driver, BasketPage.class);
        headerPage.selectLanguage("en-gb");

    }
    @Test
    public void clothingTabOnNaviRedirectToClothingPageTest(){
        sidePanelPage.clickOnAllProductsTabOnSidePanel();
        categoriesNaviPanelPage.clickOnClothingTab();
        Assert.assertTrue(clothingPage.isClothingPageDisplayed());
    }
    @Test
    public void booksTabOnNaviRedirectToBooksPageTest(){
        sidePanelPage.clickOnAllProductsTabOnSidePanel();
        categoriesNaviPanelPage.clickOnBooksTab();
        Assert.assertTrue(booksPage.isBooksPageDisplayed());
    }
    @Test
    public void fictionTabOnNaviRedirectToFictionPageTest(){
        sidePanelPage.clickOnAllProductsTabOnSidePanel();
        categoriesNaviPanelPage.clickOnFictionTab();
        Assert.assertTrue(fictionPage.isFictionPageDisplayed());
    }
    @Test
    public void compInLiteratureTabOnNaviRedirectToCompLiteraturePageTest(){
        sidePanelPage.clickOnAllProductsTabOnSidePanel();
        categoriesNaviPanelPage.clickOnCompInLiteratureTab();
        Assert.assertTrue(compInLiteraturePage.isCompInLiteraturePageDisplayed());
    }
    @Test
    public void nonFictionTabOnNaviRedirectToNonFictionPageTest(){
        sidePanelPage.clickOnAllProductsTabOnSidePanel();
        categoriesNaviPanelPage.clickOnNonFictionTab();
        Assert.assertTrue(nonFictionPage.isNonFictionPageDisplayed());
    }
    @Test
    public void essentialProgrammingTabOnNaviRedirectToEssentialProgrammingPageTest(){
        sidePanelPage.clickOnAllProductsTabOnSidePanel();
        categoriesNaviPanelPage.clickOnEssentialProgrammingTab();
        Assert.assertTrue(essentialProgrammingPage.isEssentialProgrammingPageDisplayed());
    }
    @Test
    public void hackingTabOnNaviRedirectToHackingPageTest(){
        sidePanelPage.clickOnAllProductsTabOnSidePanel();
        categoriesNaviPanelPage.clickOnHackingTab();
        Assert.assertTrue(hackingPage.isHackingPageDisplayed());
    }
    @Test
    public void verifyCorrectNameOfBookTest(){
      sidePanelPage.clickOnBooksTabOnSidePanel();
      String productName =booksPage.getNameChosenProductOnCategoryPage(3);
      booksPage.clickOnChosenProduct(3);
      Assert.assertEquals(itemBookPage.getProductName(),productName);
    }
    @Test
    public void homeTabOnItemBookPageRedirectToHomePageTest(){
        sidePanelPage.clickOnBooksTabOnSidePanel();
        booksPage.clickOnChosenProduct(1);
        itemBookPage.clickOnHomeTab();
        Assert.assertTrue(contentPage.isMainContainDisplayed());
    }
    @Test
    public void logoLinkRedirectFromItemBookPageToHomePageTest(){
        sidePanelPage.clickOnBooksTabOnSidePanel();
        booksPage.clickOnChosenProduct(5);
        headerPage.clickOnLogoLink();
        Assert.assertTrue(contentPage.isMainContainDisplayed());
    }

    @Test
    public void nextPageBtnFunctionalTest(){
        sidePanelPage.clickOnAllProductsTabOnSidePanel();
        productPage.clickOnNextBtn();
        Assert.assertEquals(productPage.getCurrentPage(),"2");

    }

    @Test
    public void previousPageBtnFunctionalTest(){
        sidePanelPage.clickOnAllProductsTabOnSidePanel();
        productPage.clickOnNextBtn();
        productPage.clickOnPreviousBtn();
        Assert.assertEquals(productPage.getCurrentPage(),"1");

    }
    @Test
    public void AddToBasketBtnOnProductPageFunctionalTest(){
        sidePanelPage.clickOnAllProductsTabOnSidePanel();
        productPage.clickOnAddToBasketOnCategoryPage(2);
        String productName = productPage.getNameChosenProductOnCategoryPage(2);
        headerPage.clickOnViewBasketBtn();
        Assert.assertTrue(basketPage.isAddedProductInBasket("Hacking Exposed Wireless"));
    }

    @Test
    public void AddToBasketBtnOnItemBookPageFunctionalTest(){
        sidePanelPage.clickOnBooksTabOnSidePanel();
        String productName = booksPage.getNameChosenProductOnCategoryPage(3);
        booksPage.clickOnChosenProduct(3);
        itemBookPage.clickOnAddToBasketBtn();
        headerPage.clickOnViewBasketBtn();
        Assert.assertTrue(basketPage.isAddedProductInBasket("Coders at Work"));

    }


}
