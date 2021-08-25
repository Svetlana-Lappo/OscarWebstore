package com.telran.oscar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends PageBase{

    public ProfilePage(WebDriver driver) {
        super(driver);
    }
    
    @FindBy(id = "delete_profile")
    WebElement deleteProfileBtn;

    @FindBy(xpath = "//a[contains(text(),'Change password')]")
    WebElement changePswdBtn;

    @FindBy(xpath = "//a[contains(text(),'Edit profile')]")
    WebElement editProfileBtn;

    @FindBy(xpath = "//div[@class='alertinner wicon']")
    WebElement successfullyChangePswdAlert;

    @FindBy(css = "tr:nth-child(1) > td")
    WebElement firstNameCell;


    public DeleteProfilePage clickOnDeleteProfileBtn() {
        click(deleteProfileBtn,2);
        return new DeleteProfilePage(driver);
    }

    public Profile_ChangePasswordPage clickOnChangePasswordBtn() {
        click(changePswdBtn,2);
        return new Profile_ChangePasswordPage(driver);
    }
    public String getMessageOfSuccessfullyChangePasswordAlert(){
        return successfullyChangePswdAlert.getText();
    }

    public Profile_EditDataPage clickOnEditProfileBtn(){
        click(editProfileBtn,2);
        return new Profile_EditDataPage(driver);
    }

    public boolean isFirstNameContainsText(String text) {
        return firstNameCell.getText().contains(text);
    }
}
