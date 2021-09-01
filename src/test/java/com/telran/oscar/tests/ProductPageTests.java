package com.telran.oscar.tests;

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
      String productName =booksPage.getNameOfThirdProduct();
      booksPage.clickOnThirdProduct();
      Assert.assertEquals(itemBookPage.getProductName(),productName);
    }
    @Test
    public void homeTabOnItemBookPageRedirectToHomePageTest(){
        sidePanelPage.clickOnBooksTabOnSidePanel();
        booksPage.clickOnThirdProduct();
        itemBookPage.clickOnHomeTab();
        Assert.assertTrue(contentPage.isMainContainDisplayed());
    }
    @Test
    public void LogoLinkRedirectFromItemBookPageToHomePageTest(){
        sidePanelPage.clickOnBooksTabOnSidePanel();
        booksPage.clickOnThirdProduct();
        headerPage.clickOnLogoLink();
        Assert.assertTrue(contentPage.isMainContainDisplayed());
    }

}
