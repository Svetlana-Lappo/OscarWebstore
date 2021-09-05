package com.telran.oscar.tests;

import com.telran.oscar.pages.basket.BasketPage;
import com.telran.oscar.pages.basket.WhoAreYouPage;
import com.telran.oscar.pages.home.ContentPage;
import com.telran.oscar.pages.home.HeaderPage;
import com.telran.oscar.pages.home.SidePanelPage;
import com.telran.oscar.pages.product.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BasketPageTests extends TestBase{

    HeaderPage headerPage;
    SidePanelPage sidePanelPage;
    BooksPage booksPage;
    BasketPage basketPage;
    WhoAreYouPage whoAreYouPage;


    @BeforeMethod
    public void ensurePrecondition(){
    headerPage = PageFactory.initElements(driver, HeaderPage.class);
    sidePanelPage = PageFactory.initElements(driver, SidePanelPage.class);
    booksPage = PageFactory.initElements(driver, BooksPage.class);
    basketPage = PageFactory.initElements(driver, BasketPage.class);
    whoAreYouPage = PageFactory.initElements(driver, WhoAreYouPage.class);
    headerPage.selectLanguage("en-gb");
    }

    @Test
    public void verifyingPriceOfProductAddedToBasketTest(){
        sidePanelPage.clickOnBooksTabOnSidePanel();
        Double price = Double.parseDouble(booksPage.getPriceChosenProductOnCategoryPage(2));
        booksPage.clickOnAddToBasketOnCategoryPage(2);
        headerPage.clickOnViewBasketBtn();
        Assert.assertEquals(basketPage.getTotalPriceForProductItem(),price);

    }

    @Test
    public void verifyingNameOfProductAddedToBasketTest(){
        sidePanelPage.clickOnBooksTabOnSidePanel();
        String productName = booksPage.getNameChosenProductOnCategoryPage(1);
        booksPage.clickOnAddToBasketOnCategoryPage(1);
        headerPage.clickOnViewBasketBtn();
        Assert.assertTrue(basketPage.isAddedProductInBasket(productName));
    }

    @Test
    public void changePriceAfterUpdateProductQuantityTest(){
        sidePanelPage.clickOnBooksTabOnSidePanel();
        booksPage.clickOnAddToBasketOnCategoryPage(1);
        headerPage.clickOnViewBasketBtn();
        basketPage.setProductQuantity("3").clickOnUpdateBtn();
        Assert.assertEquals(basketPage.getTotalPriceForProductItem(),29.97,0.01);

    }
    @Test
    public void changeProductQuantityNegativeTest(){
        sidePanelPage.clickOnBooksTabOnSidePanel();
        booksPage.clickOnAddToBasketOnCategoryPage(1);
        headerPage.clickOnViewBasketBtn();
        basketPage.setProductQuantity("").clickOnUpdateBtn();
        Assert.assertEquals(basketPage.getErrorMessage(),"This field is required.");

    }
    @Test
    public void deleteProductItemFromBasket(){
        sidePanelPage.clickOnBooksTabOnSidePanel();
        String productName = booksPage.getNameChosenProductOnCategoryPage(1);
        booksPage.clickOnAddToBasketOnCategoryPage(1);
        headerPage.clickOnViewBasketBtn();
        basketPage.setProductQuantity("0").clickOnUpdateBtn();
        Assert.assertFalse(basketPage.isAddedProductInBasket(productName));
    }
    @Test
    public void changeTotalPriceAfterDeleteProductItemTest(){
        sidePanelPage.clickOnBooksTabOnSidePanel();
        Double priceFirstProduct = Double.parseDouble(booksPage.getPriceChosenProductOnCategoryPage(1));
        booksPage.clickOnAddToBasketOnCategoryPage(1);
        booksPage.clickOnAddToBasketOnCategoryPage(2);
        headerPage.clickOnViewBasketBtn();
        Double totalBeforeDelete = basketPage.getBasketTotal();
        basketPage.setProductQuantity("0").clickOnUpdateBtn();
       // basketPage.setProductQuantity1("1","0");
        Double totalAfterDelete = basketPage.getBasketTotal();
        Assert.assertEquals(totalAfterDelete,totalBeforeDelete-priceFirstProduct,0.01);
       // Assert.assertEquals(totalAfterDelete,9.99,0.01);
    }

    @Test
    public void orderUnregisteredUserTest(){
        sidePanelPage.clickOnBooksTabOnSidePanel();
        booksPage.clickOnAddToBasketOnCategoryPage(1);
        headerPage.clickOnViewBasketBtn();
        basketPage.clickOnProceedToCheckoutBtn();
        Assert.assertTrue(whoAreYouPage.isWhoAreYouFormDisplayed());

    }


}
