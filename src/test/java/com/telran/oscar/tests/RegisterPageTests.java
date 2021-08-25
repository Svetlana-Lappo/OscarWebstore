package com.telran.oscar.tests;

import com.telran.oscar.pages.HomePage;
import com.telran.oscar.pages.ProfilePage;
import com.telran.oscar.pages.RegisterPage;
import com.telran.oscar.utils.DataProviders;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class RegisterPageTests extends TestBase{

    HomePage homePage;
    RegisterPage registerPage;


    @BeforeMethod
    public void ensurePreconditions(){
        homePage = PageFactory.initElements(driver, HomePage.class);
        registerPage = PageFactory.initElements(driver, RegisterPage.class);
        homePage.selectLanguage("en-gb");
        homePage.goToRegistrationAndLogin();
    }

    @Test
    public void registerNewUserPositiveTest_(){

        registerPage.fillRegisterForm("zebra@gmail.com", "Zebra_1812", "Zebra_1812").clickOnRegisterBtn();
        Assert.assertTrue(homePage.isLogoutBtnDisplayed());

    }

    @Test(priority = 1, groups = {"functional"})
    public void registerNewUserPositiveTest(){

        registerPage.fillRegisterForm("zebra" + (System.currentTimeMillis()/1000%3600) + "@gmail.com", "Zebra_1812", "Zebra_1812").clickOnRegisterBtn();
        Assert.assertTrue(homePage.isLogoutBtnDisplayed());

    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "registerNegativeEmails", priority = 2)
    public void registerWithInvalidEmail(String email){
        registerPage.fillRegisterForm(email, "Zebra_1812", "Zebra_1812").clickOnRegisterBtn();
        Assert.assertTrue(registerPage.isRegisterFormDisplayed());
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "registerNegativePasswords")
    public void registerWithInvalidPassword(String password){
        registerPage.fillRegisterForm("zebra1@gmail.com", password, password).clickOnRegisterBtn();
        Assert.assertTrue(registerPage.isRegisterFormDisplayed());

    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "registerDifferentPasswords")
    public void registerWithDifferentPassword(String password, String confirmPassword){
        registerPage.fillRegisterForm("zebra1@gmail.com", password, confirmPassword).clickOnRegisterBtn();
        Assert.assertEquals(registerPage.errorDifferentPswd(),"The two password fields didn't match.");
    }




}
