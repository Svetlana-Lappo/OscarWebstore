package com.telran.oscar.tests;

import com.telran.oscar.pages.basket.*;
import com.telran.oscar.pages.home.ContentPage;
import com.telran.oscar.pages.home.HeaderPage;
import com.telran.oscar.pages.home.SidePanelPage;
import com.telran.oscar.pages.product.*;
import com.telran.oscar.pages.user.*;
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
    RegisterFormPage registerFormPage;
    ShippingAddressPage shippingAddressPage;
    PaymentPage paymentPage;
    PreviewOrderPage previewOrderPage;
    ConfirmationPage confirmationPage;
    AccountSidePanelPage accountSidePanelPage;
    OrderHistoryPage orderHistoryPage;
    ProfilePage profilePage;
    DeleteProfilePage deleteProfilePage;
    LoginPage loginPage;


    @BeforeMethod
    public void ensurePrecondition(){
    headerPage = PageFactory.initElements(driver, HeaderPage.class);
    sidePanelPage = PageFactory.initElements(driver, SidePanelPage.class);
    booksPage = PageFactory.initElements(driver, BooksPage.class);
    basketPage = PageFactory.initElements(driver, BasketPage.class);
    whoAreYouPage = PageFactory.initElements(driver, WhoAreYouPage.class);
    registerFormPage = PageFactory.initElements(driver, RegisterFormPage.class);
    shippingAddressPage= PageFactory.initElements(driver, ShippingAddressPage.class);
    paymentPage = PageFactory.initElements(driver, PaymentPage.class);
    previewOrderPage = PageFactory.initElements(driver, PreviewOrderPage.class);
    confirmationPage = PageFactory.initElements(driver, ConfirmationPage.class);
    accountSidePanelPage = PageFactory.initElements(driver,AccountSidePanelPage.class);
    orderHistoryPage = PageFactory.initElements(driver,OrderHistoryPage.class);
    profilePage = PageFactory.initElements(driver,ProfilePage.class);
    deleteProfilePage = PageFactory.initElements(driver,DeleteProfilePage.class);
    loginPage = PageFactory.initElements(driver,LoginPage.class);
    headerPage.selectLanguage("en-gb");

    }

    @Test(enabled = false)
    public void verifyingPriceOfProductAddedToBasketTest(){
        sidePanelPage.clickOnBooksTabOnSidePanel();
        Double price = Double.parseDouble(booksPage.getPriceChosenProductOnCategoryPage(2));
        booksPage.clickOnAddToBasketOnCategoryPage(2);
        headerPage.clickOnViewBasketBtn();
        Assert.assertEquals(basketPage.getTotalPriceForProductItem(0),price);

    }

    @Test(enabled = false)
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
        basketPage.setProductQuantity("3").clickOnUpdateBtn(0);
        Assert.assertEquals(basketPage.getTotalPriceForProductItem(0),29.97,0.01);

    }
    @Test(enabled = false)
    public void changeProductQuantityNegativeTest(){
        sidePanelPage.clickOnBooksTabOnSidePanel();
        booksPage.clickOnAddToBasketOnCategoryPage(1);
        headerPage.clickOnViewBasketBtn();
        basketPage.setProductQuantity("").clickOnUpdateBtn(0);
        Assert.assertEquals(basketPage.getErrorMessage(),"This field is required.");

    }
    @Test
    public void deleteProductItemFromBasket(){
        sidePanelPage.clickOnBooksTabOnSidePanel();
        String productName = booksPage.getNameChosenProductOnCategoryPage(1);
        booksPage.clickOnAddToBasketOnCategoryPage(1);
        headerPage.clickOnViewBasketBtn();
        basketPage.setProductQuantity1("0","0").clickOnUpdateBtn(0);
        Assert.assertFalse(basketPage.isAddedProductInBasket(productName));
    }
    @Test
    public void changeBasketTotalPriceAfterDeleteProductItemTest(){
        sidePanelPage.clickOnBooksTabOnSidePanel();
        booksPage.clickOnAddToBasketOnCategoryPage(1);
        booksPage.pause(500);
        booksPage.clickOnAddToBasketOnCategoryPage(2);
        headerPage.clickOnViewBasketBtn();
        Double totalBeforeDelete = basketPage.getBasketTotal();
        Double priceSecondProduct = basketPage.getPriceForProductItem(1);
        basketPage.setProductQuantity1("1","0").clickOnUpdateBtn(1);
        Double totalAfterDelete = basketPage.getBasketTotal();
        Assert.assertEquals(totalAfterDelete,totalBeforeDelete-priceSecondProduct,0.01);
    }

    @Test(enabled = false)
    public void orderUnregisteredUserTest(){
        sidePanelPage.clickOnBooksTabOnSidePanel();
        booksPage.clickOnAddToBasketOnCategoryPage(1);
        headerPage.clickOnViewBasketBtn();
        basketPage.clickOnProceedToCheckoutBtn();
        Assert.assertTrue(whoAreYouPage.isWhoAreYouFormDisplayed());

    }

    @Test
    public void createOrderForUnregisteredUserWithRegistrationOptionTest(){
        sidePanelPage.clickOnBooksTabOnSidePanel();
        booksPage.clickOnAddToBasketOnCategoryPage(2);
        headerPage.clickOnViewBasketBtn();
        basketPage.clickOnProceedToCheckoutBtn();
        whoAreYouPage.typeEmailAddress("zebra55@gmail.com").typePassword("Zebra55_1812").selectRegistrationOption().clickOnContinueBtn();
        registerFormPage.typePassword("Zebra55_1812").typeConfirmPassword("Zebra55_1812").clickOnRegisterBtn();
        shippingAddressPage.fillShippingAddressForm("Ms", "Sara","Corner",
                "Friedrichstr. 18", "Nuernberg", "90402", "DE", "+4917542365154").clickOnContinueBtn();
        paymentPage.clickOnContinueBtnPayment();
        previewOrderPage.clickOnPlaceOrderBtn();
        String orderNumber;
        orderNumber= confirmationPage.getOrderNumber();
        confirmationPage.clickOnContinueShoppingBtn();
        headerPage.clickOnAccountBtn();
        accountSidePanelPage.clickOnOrderHistoryBtn();
        Assert.assertEquals(orderHistoryPage.getOrderNumber(),orderNumber);
        accountSidePanelPage.clickOnProfileBtn();
        profilePage.clickOnDeleteProfileBtn();
        deleteProfilePage.typeProfilePassword("Zebra55_1812").clickOnDeleteBtn();

    }

    @Test
    public void checkTotalSumInBasketTest(){
        sidePanelPage.clickOnBooksTabOnSidePanel();
        booksPage.clickOnAddToBasketOnCategoryPage(1);
        booksPage.clickOnAddToBasketOnCategoryPage(2);
        headerPage.clickOnViewBasketBtn();
        Double totalPriceForFirstItem = basketPage.getTotalPriceForProductItem(0);
        Double totalPriceForSecondItem = basketPage.getTotalPriceForProductItem(1);
        Assert.assertEquals(totalPriceForFirstItem+totalPriceForSecondItem,basketPage.getBasketTotal(),0.01);
    }

    @Test(enabled = false)
    public void createOrderWithPresentAddress(){
        headerPage.goToRegistrationAndLogin();
        loginPage.fillLoginForm("zebra@gmail.com","Zebra_1812").clickOnLogInBtn().takeScreenshot();
        sidePanelPage.clickOnBooksTabOnSidePanel();
        booksPage.clickOnAddToBasketOnCategoryPage(1);
        headerPage.clickOnViewBasketBtn();
        basketPage.clickOnProceedToCheckoutBtn();
        shippingAddressPage.clickOnShipToThisAddressBtn();
        paymentPage.clickOnContinueBtnPayment();
        previewOrderPage.clickOnPlaceOrderBtn();
        String orderNumber = confirmationPage.getOrderNumber();
        confirmationPage.clickOnContinueShoppingBtn();
        headerPage.clickOnAccountBtn();
        accountSidePanelPage.clickOnOrderHistoryBtn();
        Assert.assertEquals(orderHistoryPage.getOrderNumber(),orderNumber);
    }



}
