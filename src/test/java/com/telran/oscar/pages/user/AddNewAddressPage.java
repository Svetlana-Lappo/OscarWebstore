package com.telran.oscar.pages.user;

import com.telran.oscar.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddNewAddressPage extends PageBase {
    public AddNewAddressPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "id_title")
    WebElement titleNewAddressForm;
    @FindBy(css = "[name='first_name']")
    WebElement firstNameNewAddressForm;
    @FindBy(css = "[name='last_name']")
    WebElement lastNameNewAddressForm;
    @FindBy(css = "[name='line1']")
    WebElement address1NewAddressForm;
    @FindBy(css = "[name='line4']")
    WebElement shippingCityNewAddressForm;
    @FindBy(css = "[name='postcode']")
    WebElement postcodeNewAddressForm;
    @FindBy(css = "[name='country']")
    WebElement countryNewAddressForm;
    @FindBy(id = "id_phone_number")
    WebElement phoneNumberNewAddressForm;
    @FindBy(xpath = "//button[@class='btn btn-lg btn-primary']")
    WebElement saveBtnNewAddressForm;
    @FindBy(css = ".error-block")
    WebElement errorForWrongPostcodeNewAddressForm;
    @FindBy(xpath = "//form[@class='form-horizontal ']//div[2]")
    WebElement errorSameAddress;


    public AddNewAddressPage fillNewAddressForm(String titleValue, String fName, String lName, String adr1,
                                                String city, String zipCode, String countryValue, String phone){
        fillAddressForm(titleNewAddressForm,titleValue, firstNameNewAddressForm, fName,lastNameNewAddressForm,
                lName,address1NewAddressForm,adr1,shippingCityNewAddressForm,city,postcodeNewAddressForm,zipCode,
                countryNewAddressForm,countryValue,phoneNumberNewAddressForm,phone);
        return this;
    }

    public AddressBookPage clickOnSaveBtn(){
        click(saveBtnNewAddressForm,2);
        return new AddressBookPage(driver);
    }
    public String getErrorSameAddress(){
        return errorSameAddress.getText();
    }
}
