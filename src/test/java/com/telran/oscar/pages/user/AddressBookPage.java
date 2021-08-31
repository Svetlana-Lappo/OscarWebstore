package com.telran.oscar.pages.user;

import com.telran.oscar.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddressBookPage extends PageBase {
    public AddressBookPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".table.table-striped.table-bordered")
    WebElement bookOfAddresses;
    @FindBy(xpath = "//div[@class='btn-group']//a[@class='btn btn-default']")
    WebElement editBtn;
    @FindBy(css = "td:nth-child(1)")
    WebElement fullShippingAddress;
    @FindBy(xpath = "//a[@class='btn btn-primary']")
    WebElement addNewAddressBtn;
    @FindBy(xpath = "//div[@class='alertinner wicon']")
    WebElement alertNewAddressAdded;

    public boolean isAddressBookDisplayed(){
        return bookOfAddresses.isDisplayed();
    }

    public EditAddressPage clickOnEditBtn(){
        click(editBtn,2);
        return new EditAddressPage(driver);
    }

    public String getNewShippingAddress(){
        String [] dataInfo = fullShippingAddress.getText().split("\n");
        return dataInfo[1];
    }
    public boolean isEditAddressContainsText(String Text){
        return fullShippingAddress.getText().contains(Text);

    }

    public AddNewAddressPage clickOnAddNewAddressBtn(){
        click(addNewAddressBtn,2);
        return new AddNewAddressPage(driver);
    }

    public String getSuccessfullyAlertText(){
        return alertNewAddressAdded.getText();
    }

}
