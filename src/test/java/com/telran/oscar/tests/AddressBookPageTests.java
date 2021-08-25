package com.telran.oscar.tests;

import com.telran.oscar.pages.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddressBookPageTests extends TestBase{

    HomePage homePage;
    LoginPage loginPage;
    AccountSidePanelPage accountSidePanelPage;
    AddressBookPage addressBookPage;
    EditAddressPage editAddressPage;
    AddNewAddressPage addNewAddressPage;


    @BeforeMethod
    public void ensurePreconditions(){
        homePage = PageFactory.initElements(driver, HomePage.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        accountSidePanelPage = PageFactory.initElements(driver, AccountSidePanelPage.class);
        addressBookPage = PageFactory.initElements(driver, AddressBookPage.class);
        editAddressPage = PageFactory.initElements(driver, EditAddressPage.class);
        addNewAddressPage = PageFactory.initElements(driver, AddNewAddressPage.class);
        homePage.selectLanguage("en-gb");
        homePage.goToRegistrationAndLogin();
        loginPage.fillLoginForm("zebra@gmail.com","Zebra_1812").clickOnLogInBtn();
        homePage.clickOnAccountBtn();
    }

    @Test
    public void editAddressPositiveTest(){
        accountSidePanelPage.clickOnAddressBookBtn();
        addressBookPage.clickOnEditBtn();
        editAddressPage.editShippingAddress("Dachnerstr. 25");
        editAddressPage.clickOnSaveBtn();
       // Assert.assertEquals(addressBookPage.getNewShippingAddress(),"Dachnerstr. 25");
        Assert.assertTrue(addressBookPage.isEditAddressContainsText("Dachnerstr. 25"));
    }

    @Test
    public void editPostcodeNegativeTest(){
        accountSidePanelPage.clickOnAddressBookBtn();
        addressBookPage.clickOnEditBtn();
        editAddressPage.editPostcode("MK7 6AJ");
        editAddressPage.clickOnSaveBtn();
        Assert.assertEquals(editAddressPage.getErrorMessageForWrongPostCodeEditForm(),"The postcode 'MK7 6AJ' is not valid for Germany");

    }
    @Test
    public void editCountryNegativeTest(){
        accountSidePanelPage.clickOnAddressBookBtn();
        addressBookPage.clickOnEditBtn();
        editAddressPage.editCountry("AF");
        editAddressPage.clickOnSaveBtn();
        Assert.assertEquals(editAddressPage.getErrorMessageForWrongPostCodeEditForm(),"The postcode '95050' is not valid for Afghanistan");

    }

    @Test
    public void addNewShippingAddressPositiveTest(){
        accountSidePanelPage.clickOnAddressBookBtn();
        addressBookPage.clickOnAddNewAddressBtn();
        addNewAddressPage.fillNewAddressForm("Ms", "Barbara","Corner",
                    "MarktPlatz.8", "Bamberg", "96050", "DE", "+4917542365155").clickOnSaveBtn();
        Assert.assertEquals(addressBookPage.getSuccessfullyAlertText(),"Address 'Ms Barbara Corner, MarktPlatz.8, Bamberg, 95050, Germany' created");

    }
    @Test
    public void addAlreadyExistedShippingAddressNegativeTest(){
        accountSidePanelPage.clickOnAddressBookBtn();
        addressBookPage.clickOnAddNewAddressBtn();
        addNewAddressPage.fillNewAddressForm("Ms", "Barbara","Corner",
                    "MarktPlatz.8", "Bamberg", "96050", "DE", "+4917542365155").clickOnSaveBtn();
        Assert.assertEquals(addNewAddressPage.getErrorSameAddress(),"This address is already in your address book");


    }
}
