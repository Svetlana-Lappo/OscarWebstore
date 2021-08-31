package com.telran.oscar.pages.basket;

import com.telran.oscar.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShippingAddressPage extends PageBase {
    public ShippingAddressPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "id_title")
    WebElement title;
    @FindBy(css = "[name='first_name']")
    WebElement firstName;
    @FindBy(css = "[name='last_name']")
    WebElement lastName;
    @FindBy(css = "[name='line1']")
    WebElement address1;
    @FindBy(css = "[name='line4']")
    WebElement shippingCity;
    @FindBy(css = "[name='postcode']")
    WebElement postcode;
    @FindBy(id = "id_country")
    WebElement country;
    @FindBy(id = "id_phone_number")
    WebElement phoneNumber;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement continueBtnShipping;
    @FindBy(css = ".error-block")
    WebElement errorForWrongPostcode;



    public ShippingAddressPage fillShippingAddressForm(String titleValue, String fName, String lName, String adr1,
                                                String city, String zipCode, String countryValue, String phone){
        fillAddressForm(title,titleValue, firstName, fName,lastName,
                lName,address1,adr1,shippingCity,city,postcode,zipCode,
                country,countryValue,phoneNumber,phone);
        return this;
    }
    public String getCountry(){
        return country.getText();
    }

    public PaymentPage clickOnContinueBtn() {
        click(continueBtnShipping,2);
        return new PaymentPage(driver);
    }

    public String getErrorMessageForWrongPostCode(){
        return errorForWrongPostcode.getText();
    }
}
