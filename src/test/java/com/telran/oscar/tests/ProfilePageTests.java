package com.telran.oscar.tests;

import com.telran.oscar.pages.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProfilePageTests extends TestBase{
    HomePage homePage;
    LoginPage loginPage;
    ProfilePage profilePage;
    DeleteProfilePage deleteProfilePage;
    Profile_ChangePasswordPage profile_changePasswordPage;
    Profile_EditDataPage profile_editDataPage;



    @BeforeMethod
    public void ensurePreconditions(){
        homePage = PageFactory.initElements(driver, HomePage.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        profilePage = PageFactory.initElements(driver,ProfilePage.class);
        deleteProfilePage = PageFactory.initElements(driver,DeleteProfilePage.class);
        profile_changePasswordPage = PageFactory.initElements(driver,Profile_ChangePasswordPage.class);
        profile_editDataPage = PageFactory.initElements(driver,Profile_EditDataPage.class);
        homePage.selectLanguage("en-gb");
        homePage.goToRegistrationAndLogin();
        loginPage.fillLoginForm("zebra@gmail.com","Zebra_1812").clickOnLogInBtn();

    }
    @Test
    public void changeAccountPassword(){
        homePage.clickOnAccountBtn();
        profilePage.clickOnChangePasswordBtn();
        profile_changePasswordPage.typeOldPassword("Zebra_1811").typeNewPassword("Zebra_1812")
        .typeConfirmNewPassword("Zebra_1812").clickOnSaveChangePasswordBtn();
        Assert.assertEquals(profilePage.getMessageOfSuccessfullyChangePasswordAlert(),"Password updated");

    }

    @Test
    public void editProfileData(){
        homePage.clickOnAccountBtn();
        profilePage.clickOnEditProfileBtn();
        profile_editDataPage.typeNewFirstName("Dud").clickOnSaveBtn();
        Assert.assertTrue(profilePage.isFirstNameContainsText("Dud"));

    }
    @Test
    public void deleteProfilePositiveTest(){
        homePage.clickOnAccountBtn();
        profilePage.clickOnDeleteProfileBtn();
        deleteProfilePage.typeProfilePassword("Zebra_1812").clickOnDeleteBtn();
        Assert.assertEquals(homePage.getMessageOfSuccessfullyDelProfileAlert(),"Your profile has now been deleted. Thanks for using the site.");
    }
    @Test
    public void deleteProfileWithWrongPasswordNegativeTest(){
        homePage.clickOnAccountBtn();
        profilePage.clickOnDeleteProfileBtn();
        deleteProfilePage.typeProfilePassword("Zebra_1813").clickOnDeleteBtn();
        Assert.assertEquals(deleteProfilePage.getMessageOfErrorDelProfileAlert(),"The entered password is not valid!");
    }
}
