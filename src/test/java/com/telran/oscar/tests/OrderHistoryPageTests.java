package com.telran.oscar.tests;

import com.telran.oscar.pages.basket.*;
import com.telran.oscar.pages.home.HeaderPage;
import com.telran.oscar.pages.home.SidePanelPage;
import com.telran.oscar.pages.product.BooksPage;
import com.telran.oscar.pages.user.AccountSidePanelPage;
import com.telran.oscar.pages.user.LoginPage;
import com.telran.oscar.pages.user.OrderHistoryPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OrderHistoryPageTests extends TestBase{

    HeaderPage headerPage;
    SidePanelPage sidePanelPage;
    LoginPage loginPage;
    BooksPage booksPage;
    BasketPage basketPage;
    ShippingAddressPage shippingAddressPage;
    PaymentPage paymentPage;
    PreviewOrderPage previewOrderPage;
    ConfirmationPage confirmationPage;
    AccountSidePanelPage accountSidePanelPage;
    OrderHistoryPage orderHistoryPage;


    @BeforeMethod
    public void ensurePreconditions(){
        sidePanelPage = PageFactory.initElements(driver, SidePanelPage.class);
        headerPage = PageFactory.initElements(driver, HeaderPage.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        booksPage = PageFactory.initElements(driver, BooksPage.class);
        basketPage = PageFactory.initElements(driver, BasketPage.class);
        paymentPage = PageFactory.initElements(driver, PaymentPage.class);
        previewOrderPage = PageFactory.initElements(driver, PreviewOrderPage.class);
        confirmationPage = PageFactory.initElements(driver, ConfirmationPage.class);
        shippingAddressPage = PageFactory.initElements(driver, ShippingAddressPage.class);
        accountSidePanelPage = PageFactory.initElements(driver,AccountSidePanelPage.class);
        orderHistoryPage = PageFactory.initElements(driver,OrderHistoryPage.class);
        headerPage.selectLanguage("en-gb");
        headerPage.goToRegistrationAndLogin();
        loginPage.fillLoginForm("zebra@gmail.com","Zebra_1812").clickOnLogInBtn();

    }

    @Test
    public void orderHistoryPositiveTest(){

        sidePanelPage.clickOnBooksTabOnSidePanel();
        booksPage.clickOnAddToBasketOnCategoryPage(3);
        headerPage.clickOnViewBasketBtn();
        basketPage.clickOnProceedToCheckoutBtn();
        shippingAddressPage.fillShippingAddressForm("Ms", "Sara","Corner",
                "Friedrichstr. 18", "Nuernberg", "90402", "DE", "+4917542365154").clickOnContinueBtn();
        paymentPage.clickOnContinueBtnPayment();
        previewOrderPage.clickOnPlaceOrderBtn();
        String orderNumber;
        String orderTotal;
        orderNumber= confirmationPage.getOrderNumber();
        orderTotal = confirmationPage.getOrderTotal();
        confirmationPage.clickOnContinueShoppingBtn();
        headerPage.clickOnAccountBtn();
        accountSidePanelPage.clickOnOrderHistoryBtn();
        Assert.assertEquals(orderHistoryPage.getOrderNumber(),orderNumber);
        Assert.assertEquals(orderHistoryPage.getOrderTotal(),orderTotal);

    }

    @Test(enabled = false)
    public void createOderWithWrongPostcodeNegativeTest(){
        sidePanelPage.clickOnBooksTabOnSidePanel();
        booksPage.clickOnAddToBasketOnCategoryPage(3);
        headerPage.clickOnViewBasketBtn();
        basketPage.clickOnProceedToCheckoutBtn();
        shippingAddressPage.fillShippingAddressForm("Ms", "Sara","Corner",
                "Friedrichstr. 18", "Nuernberg", "90402", "AF", "+4917542365154").clickOnContinueBtn();
        paymentPage.clickOnContinueBtnPayment();
        Assert.assertEquals(shippingAddressPage.getErrorMessageForWrongPostCode(),"The postcode '90402' is not valid for Afganistan");
    }
}
