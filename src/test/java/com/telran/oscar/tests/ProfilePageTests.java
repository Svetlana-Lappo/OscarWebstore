package com.telran.oscar.tests;

import com.telran.oscar.pages.HomePage;
import com.telran.oscar.pages.LoginPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;

public class ProfilePageTests extends TestBase{
    HomePage homePage;
    LoginPage loginPage;
    @BeforeMethod
    public void ensurePreconditions(){
        homePage = PageFactory.initElements(driver, HomePage.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        homePage.selectLanguage("en-gb");
        homePage.goToRegistration();
        loginPage.fillLoginForm("zebra@gmail.com","Zebra_1812").clickOnLogInBtn();

    }
}
