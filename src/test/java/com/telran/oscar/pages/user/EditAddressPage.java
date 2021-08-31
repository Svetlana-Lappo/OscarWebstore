package com.telran.oscar.pages.user;

import com.telran.oscar.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditAddressPage extends PageBase {
    public EditAddressPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "[name='line1']")
    WebElement addressEditForm;
    @FindBy(css = "[name='country']")
    WebElement countryEditForm;
    @FindBy(xpath = "//button[@class='btn btn-lg btn-primary']")
    WebElement saveBtn;
    @FindBy(css = "[name='postcode']")
    WebElement postcodeEditForm;
    @FindBy(css = ".error-block")
    WebElement errorForWrongPostcodeEditForm;

    public EditAddressPage editShippingAddress(String newAddress){
        type(addressEditForm,2, newAddress);
        return this;
    }

    public AddressBookPage clickOnSaveBtn() {
        click(saveBtn,2);
        return new AddressBookPage(driver);
    }

    public EditAddressPage editPostcode(String newPostcode){
        type(postcodeEditForm,2,newPostcode);
        return this;
    }
    public String getErrorMessageForWrongPostCodeEditForm(){
        return errorForWrongPostcodeEditForm.getText();
    }

    public EditAddressPage editCountry(String country) {
        selectDropDownByValue(countryEditForm,country);
        return this;
    }
}
