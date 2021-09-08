package com.telran.oscar.tests;

import com.telran.oscar.pages.user.LoginPage;
import com.telran.oscar.pages.home.HeaderPage;
import com.telran.oscar.utils.DataProviders;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTests extends TestBase{

    HeaderPage headerPage;
    LoginPage loginPage;

    @BeforeMethod
    public void ensurePrecondition(){
        headerPage = PageFactory.initElements(driver, HeaderPage.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        headerPage.selectLanguage("en-gb");
        headerPage.goToRegistrationAndLogin();
    }

    @Test(enabled = false)
    public void loginUserPositiveTest(){
     // loginPage.fillLoginForm("zebra@gmail.com","Zebra_1812").clickOnLogInBtn().takeScreenshot();
        loginPage.fillLoginForm("zebra@gmail.com","Zebra_1812").clickOnLogInBtn();
        loginPage.pause(1000);
        Assert.assertTrue(headerPage.isLogoutBtnDisplayed());
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "loginInvalidEmails")
    public void loginUserWithInvalidEmail(String email){
        loginPage.fillLoginForm(email,"Zebra_1812").clickOnLogInBtn();
        Assert.assertTrue(loginPage.isLoginFormDisplayed());
    }

    @Test(enabled = false, dataProviderClass = DataProviders.class, dataProvider = "loginInvalidPasswords")
    public void loginUserWithInvalidPassword(String password){
        loginPage.fillLoginForm("zebra@gmail.com",password).clickOnLogInBtn();
        Assert.assertTrue(loginPage.isLoginFormDisplayed());
    }



}
