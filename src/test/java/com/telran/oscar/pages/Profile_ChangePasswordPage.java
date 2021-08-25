package com.telran.oscar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Profile_ChangePasswordPage extends PageBase{
    public Profile_ChangePasswordPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[name=old_password]")
    WebElement oldPswdField;

    @FindBy(css = "[name=new_password1]")
    WebElement newPswdField;

    @FindBy(css = "[name=new_password2]")
    WebElement confirmNewPswdField;

    @FindBy(xpath = "//button[@class='btn btn-lg btn-primary']")
    WebElement saveChangePswdBtn;

    public Profile_ChangePasswordPage typeOldPassword(String oldPassword){
        type(oldPswdField,2,oldPassword);
        return this;
    }
    public Profile_ChangePasswordPage typeNewPassword(String newPassword){
        type(newPswdField,2,newPassword);
        return this;
    }
    public Profile_ChangePasswordPage typeConfirmNewPassword(String confirmNewPassword){
        type(confirmNewPswdField,2,confirmNewPassword);
        return this;
    }
    public void clickOnSaveChangePasswordBtn(){
        click(saveChangePswdBtn,2);
    }

}
