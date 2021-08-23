package com.telran.oscar.tests;

import com.telran.oscar.pages.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddressBookPageTests extends TestBase{

    HomePage homePage;
    LoginPage loginPage;
    ProfilePage profilePage;
    AddressBookPage addressBookPage;
    EditAddressPage editAddressPage;
    AddNewAddressPage addNewAddressPage;

    @BeforeMethod
    public void ensurePreconditions(){
        homePage = PageFactory.initElements(driver, HomePage.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        profilePage = PageFactory.initElements(driver, ProfilePage.class);
        addressBookPage = PageFactory.initElements(driver, AddressBookPage.class);
        editAddressPage = PageFactory.initElements(driver, EditAddressPage.class);
        addNewAddressPage = PageFactory.initElements(driver, AddNewAddressPage.class);
        homePage.selectLanguage("en-gb");
        homePage.goToRegistration();
        loginPage.fillLoginForm("zebra@gmail.com","Zebra_1812").clickOnLogInBtn();
        homePage.clickOnAccountBtn();

    }
    @Test
    public void editShippingAddressPositiveTest(){
        profilePage.clickOnAddressBookBtn();
        if(addressBookPage.isAddressBookDisplayed()){
            addressBookPage.clickOnEditBtn();
            editAddressPage.editShippingAddress("Dachnerstr. 22");
            editAddressPage.clickOnSaveBtn();
            Assert.assertEquals(addressBookPage.getNewShippingAddress(),"Dachnerstr. 22");
        } else {
            System.out.println("Address Book is empty");
        }

    }

    @Test
    public void editAddressPostcodeNegativeTest(){
        profilePage.clickOnAddressBookBtn();
        if(addressBookPage.isAddressBookDisplayed()){
            addressBookPage.clickOnEditBtn();
            editAddressPage.editPostcode("MK7 6AJ");
            editAddressPage.clickOnSaveBtn();
            Assert.assertEquals(editAddressPage.getErrorMessageForWrongPostCodeEditForm(),"The postcode 'MK7 6AJ' is not valid for Germany");
        } else {
            System.out.println("Address Book is empty");
        }
    }
    @Test
    public void editShippingCountryNegativeTest(){
        profilePage.clickOnAddressBookBtn();
        if(addressBookPage.isAddressBookDisplayed()){
            addressBookPage.clickOnEditBtn();
            editAddressPage.editCountry("AF");
            editAddressPage.clickOnSaveBtn();
            Assert.assertEquals(editAddressPage.getErrorMessageForWrongPostCodeEditForm(),"The postcode '90402' is not valid for Afghanistan");
        } else {
            System.out.println("Address Book is empty");
        }
    }

    @Test
    public void addNewShippingAddressPositiveTest(){
        profilePage.clickOnAddressBookBtn();
        if(addressBookPage.isAddressBookDisplayed()){
            addressBookPage.clickOnAddNewAddressBtn();
            addNewAddressPage.fillNewAddressForm("Ms", "Barbara","Corner",
                    "MarktPlatz.8", "Bamberg", "96050", "DE", "+4917542365155").clickOnSaveBtn();
            Assert.assertEquals(addressBookPage.getSuccessfullyAlertText(),"Address 'Ms Barbara Corner, MarktPlatz.8, Bamberg, 96050, Germany' created");

        }else{
            System.out.println("Address book is empty");
        }

    }
    @Test
    public void addAlreadyExistedAddressNegativeTest(){
        profilePage.clickOnAddressBookBtn();
        if(addressBookPage.isAddressBookDisplayed()){
            addressBookPage.clickOnAddNewAddressBtn();
            addNewAddressPage.fillNewAddressForm("Ms", "Barbara","Corner",
                    "MarktPlatz.8", "Bamberg", "96050", "DE", "+4917542365155").clickOnSaveBtn();
            Assert.assertEquals(addNewAddressPage.getErrorSameAddress(),"This address is already in your address book");

        }else{
            System.out.println("Address book is empty");
        }
    }
}
