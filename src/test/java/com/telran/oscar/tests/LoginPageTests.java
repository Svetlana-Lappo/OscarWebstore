package com.telran.oscar.tests;

import com.telran.oscar.pages.HomePage;
import com.telran.oscar.pages.LoginPage;
import com.telran.oscar.utils.DataProviders;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTests extends TestBase{

    HomePage homePage;
    LoginPage loginPage;

    @BeforeMethod
    public void ensurePrecondition(){
        homePage = PageFactory.initElements(driver, HomePage.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        homePage.selectLanguage("en-gb");
        homePage.goToRegistrationAndLogin();
    }

    @Test
    public void loginUserPositiveTest(){
        loginPage.fillLoginForm("@gmail.com","Zebra_1812").clickOnLogInBtn().takeScreenshot();
        Assert.assertTrue(homePage.isLogoutBtnDisplayed());
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "loginInvalidEmails")
    public void loginUserWithInvalidEmail(String email){
        loginPage.fillLoginForm(email,"Zebra_1812").clickOnLogInBtn();
        Assert.assertTrue(loginPage.isLoginFormDisplayed());
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "loginInvalidPasswords")
    public void loginUserWithInvalidPassword(String password){
        loginPage.fillLoginForm("zebra@gmail.com",password).clickOnLogInBtn();
        Assert.assertTrue(loginPage.isLoginFormDisplayed());
    }

}
