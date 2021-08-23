package com.telran.oscar.tests;

import com.telran.oscar.pages.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EmailHistoryPageTests extends TestBase{

    HomePage homePage;
    LoginPage loginPage;
    RegisterPage registerPage;
    EmailHistoryPage emailHistoryPage;
    ProfilePage profilePage;


    @BeforeMethod
    public void ensurePreconditions(){
        homePage = PageFactory.initElements(driver, HomePage.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        registerPage = PageFactory.initElements(driver, RegisterPage.class);
        emailHistoryPage = PageFactory.initElements(driver, EmailHistoryPage.class);
        profilePage = PageFactory.initElements(driver, ProfilePage.class);
        homePage.selectLanguage("en-gb");
        homePage.goToRegistration();
        registerPage.fillRegisterForm("zebra" + (System.currentTimeMillis()/1000%3600) + "@gmail.com", "Zebra_1812", "Zebra_1812").clickOnRegisterBtn();
        homePage.clickOnAccountBtn();

    }

    @Test
    public void verificationOfEmailCreateDataPositiveTest(){
        profilePage.clickOnEmailHistoryBtn();
        Assert.assertEquals(emailHistoryPage.getCreateDateOfEmail(),"22 Aug 2021");
    }
}
