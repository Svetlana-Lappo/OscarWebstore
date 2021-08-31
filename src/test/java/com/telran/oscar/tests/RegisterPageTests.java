package com.telran.oscar.tests;

import com.telran.oscar.pages.home.HeaderPage;
import com.telran.oscar.pages.user.AccountSidePanelPage;
import com.telran.oscar.pages.user.DeleteProfilePage;
import com.telran.oscar.pages.user.ProfilePage;
import com.telran.oscar.pages.user.RegisterPage;
import com.telran.oscar.utils.DataProviders;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;

public class RegisterPageTests extends TestBase{

    HeaderPage headerPage;
    RegisterPage registerPage;
    AccountSidePanelPage accountSidePanelPage;
    ProfilePage profilePage;
    DeleteProfilePage deleteProfilePage;


    @BeforeMethod
    public void ensurePreconditions(){
        headerPage = PageFactory.initElements(driver, HeaderPage.class);
        registerPage = PageFactory.initElements(driver, RegisterPage.class);
        accountSidePanelPage = PageFactory.initElements(driver, AccountSidePanelPage.class);
        profilePage = PageFactory.initElements(driver, ProfilePage.class);
        deleteProfilePage = PageFactory.initElements(driver, DeleteProfilePage.class);
        headerPage.selectLanguage("en-gb");
        headerPage.goToRegistrationAndLogin();
    }

    @Test
    public void registerMainUserPositiveTest(){

        registerPage.fillRegisterForm("zebra@gmail.com", "Zebra_1812", "Zebra_1812").clickOnRegisterBtn();
        Assert.assertTrue(headerPage.isLogoutBtnDisplayed());

    }

    @Test(priority = 1, groups = {"functional"})
    public void registerNewUserPositiveTest(){

        registerPage.fillRegisterForm("zebra" + (System.currentTimeMillis()/1000%3600) + "@gmail.com", "Zebra_1812", "Zebra_1812").clickOnRegisterBtn();
        Assert.assertTrue(headerPage.isLogoutBtnDisplayed());

    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "registerNegativeEmails", priority = 2)
    public void registerWithInvalidEmail(String email){
        registerPage.fillRegisterForm(email, "Zebra_1812", "Zebra_1812").clickOnRegisterBtn();
        Assert.assertTrue(registerPage.isRegisterFormDisplayed());
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "registerNegativePasswords",priority = 3)
    public void registerWithInvalidPassword(String password){
        registerPage.fillRegisterForm("zebra1@gmail.com", password, password).clickOnRegisterBtn();
        Assert.assertTrue(registerPage.isRegisterFormDisplayed());

    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "registerDifferentPasswords",priority = 4)
    public void registerWithDifferentPassword(String password, String confirmPassword){
        registerPage.fillRegisterForm("zebra1@gmail.com", password, confirmPassword).clickOnRegisterBtn();
        Assert.assertEquals(registerPage.errorDifferentPswd(),"The two password fields didn't match.");
    }

@AfterGroups(groups = {"functional"})
    public void cleanUp(){
    headerPage.clickOnAccountBtn();
    profilePage.clickOnDeleteProfileBtn();
    deleteProfilePage.typeProfilePassword("Zebra_1812").clickOnDeleteBtn();
}


}
