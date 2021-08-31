package com.telran.oscar.tests;

import com.telran.oscar.pages.home.HeaderPage;
import com.telran.oscar.pages.user.*;
import com.telran.oscar.utils.DataProviders;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProfilePageTests extends TestBase{
    HeaderPage headerPage;
    LoginPage loginPage;
    ProfilePage profilePage;
    DeleteProfilePage deleteProfilePage;
    Profile_ChangePasswordPage profile_changePasswordPage;
    Profile_EditDataPage profile_editDataPage;



    @BeforeMethod
    public void ensurePreconditions(){
        headerPage = PageFactory.initElements(driver, HeaderPage.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        profilePage = PageFactory.initElements(driver,ProfilePage.class);
        deleteProfilePage = PageFactory.initElements(driver,DeleteProfilePage.class);
        profile_changePasswordPage = PageFactory.initElements(driver,Profile_ChangePasswordPage.class);
        profile_editDataPage = PageFactory.initElements(driver,Profile_EditDataPage.class);
        headerPage.selectLanguage("en-gb");
        headerPage.goToRegistrationAndLogin();
        loginPage.fillLoginForm("zebra@gmail.com","Zebra_1812").clickOnLogInBtn();

    }
    @Test
    public void changeAccountPassword(){
        headerPage.clickOnAccountBtn();
        profilePage.clickOnChangePasswordBtn();
        profile_changePasswordPage.typeOldPassword("Zebra_1811").typeNewPassword("Zebra_1812")
        .typeConfirmNewPassword("Zebra_1812").clickOnSaveChangePasswordBtn();
        Assert.assertEquals(profilePage.getMessageOfSuccessfullyChangePasswordAlert(),"Password updated");

    }

    @Test
    public void editProfileData(){
        headerPage.clickOnAccountBtn();
        profilePage.clickOnEditProfileBtn();
        profile_editDataPage.typeNewFirstName("Dud").clickOnSaveBtn();
        Assert.assertTrue(profilePage.isFirstNameContainsText("Dud"));

    }
    @Test
    public void editEmailPositiveTest(){
        headerPage.clickOnAccountBtn();
        profilePage.clickOnEditProfileBtn();
        profile_editDataPage.typeNewEmailAddress("zebra@gmail.com").clickOnSaveBtn();
        Assert.assertTrue(profilePage.isEmailFieldContainsNewEmail("zebra@gmail.com"));
    }

    @Test(dataProvider = "loginInvalidEmails", dataProviderClass = DataProviders.class)
    public void editEmailNegativeTest(String email){
        headerPage.clickOnAccountBtn();
        profilePage.clickOnEditProfileBtn();
        profile_editDataPage.typeNewEmailAddress(email).clickOnSaveBtn();
        Assert.assertTrue(profile_editDataPage.isEditFormPresent());

    }

    @Test
    public void deleteProfilePositiveTest(){
        headerPage.clickOnAccountBtn();
        profilePage.clickOnDeleteProfileBtn();
        deleteProfilePage.typeProfilePassword("Zebra_1812").clickOnDeleteBtn();
        Assert.assertEquals(headerPage.getMessageOfSuccessfullyDelProfileAlert(),"Your profile has now been deleted. Thanks for using the site.");
    }
    @Test
    public void deleteProfileWithWrongPasswordNegativeTest(){
        headerPage.clickOnAccountBtn();
        profilePage.clickOnDeleteProfileBtn();
        deleteProfilePage.typeProfilePassword("Zebra_1813").clickOnDeleteBtn();
        Assert.assertEquals(deleteProfilePage.getMessageOfErrorDelProfileAlert(),"The entered password is not valid!");
    }
}
