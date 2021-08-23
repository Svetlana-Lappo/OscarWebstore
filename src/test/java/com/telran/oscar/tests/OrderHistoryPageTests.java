package com.telran.oscar.tests;

import com.telran.oscar.pages.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OrderHistoryPageTests extends TestBase{

    HomePage homePage;
    LoginPage loginPage;
    BooksPage booksPage;
    BasketPage basketPage;
    ShippingAddressPage shippingAddressPage;
    PaymentPage paymentPage;
    PreviewOrderPage previewOrderPage;
    ConfirmationPage confirmationPage;
    ProfilePage profilePage;
    OrderHistoryPage orderHistoryPage;


    @BeforeMethod
    public void ensurePreconditions(){
        homePage = PageFactory.initElements(driver, HomePage.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        booksPage = PageFactory.initElements(driver, BooksPage.class);
        basketPage = PageFactory.initElements(driver, BasketPage.class);
        paymentPage = PageFactory.initElements(driver, PaymentPage.class);
        previewOrderPage = PageFactory.initElements(driver, PreviewOrderPage.class);
        confirmationPage = PageFactory.initElements(driver, ConfirmationPage.class);
        shippingAddressPage = PageFactory.initElements(driver, ShippingAddressPage.class);
        profilePage = PageFactory.initElements(driver,ProfilePage.class);
        orderHistoryPage = PageFactory.initElements(driver,OrderHistoryPage.class);
        homePage.selectLanguage("en-gb");
        homePage.goToRegistration();
        loginPage.fillLoginForm("zebra@gmail.com","Zebra_1812").clickOnLogInBtn();

    }

    @Test
    public void createOderPositiveTest(){

        homePage.clickOnBooksTabOnSidePanel();
        booksPage.clickOnAddBasketForThirdProduct();
        homePage.clickOnViewBasketBtn();
        basketPage.clickOnProceedToCheckoutBtn();
        shippingAddressPage.fillShippingAddressForm("Ms", "Sara","Corner",
                "Friedrichstr. 18", "Nuernberg", "90402", "DE", "+4917542365154").clickOnContinueBtn();
        paymentPage.clickOnContinueBtnPayment();
        previewOrderPage.clickOnPlaceOrderBtn();
        String orderNumber;
        String orderTotal;
        orderNumber= confirmationPage.getOrderNumber();
        System.out.println(orderNumber);
        orderTotal = confirmationPage.getOrderTotal();
        System.out.println(orderTotal);
        confirmationPage.clickOnContinueShoppingBtn();
        homePage.clickOnAccountBtn();
        profilePage.clickOnOrderHistoryBtn();
        Assert.assertEquals(orderHistoryPage.getOrderNumber(),orderNumber);
        Assert.assertEquals(orderHistoryPage.getOrderTotal(),orderTotal);

    }

    @Test
    public void createOderWithWrongPostcodeNegativeTest(){
        homePage.clickOnBooksTabOnSidePanel();
        booksPage.clickOnAddBasketForThirdProduct();
        homePage.clickOnViewBasketBtn();
        basketPage.clickOnProceedToCheckoutBtn();
        shippingAddressPage.fillShippingAddressForm("Ms", "Sara","Corner",
                "Friedrichstr. 18", "Nuernberg", "10000", "AL", "+4917542365154").clickOnContinueBtn();
        paymentPage.clickOnContinueBtnPayment();
        Assert.assertEquals(shippingAddressPage.getErrorMessageForWrongPostCode(),"The postcode '10000' is not valid for Albania");
    }
}
