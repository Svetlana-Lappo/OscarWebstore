package com.telran.oscar.pages.user;

import com.telran.oscar.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Profile_EditDataPage extends PageBase {
    public Profile_EditDataPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "id_first_name")
    WebElement firstNameField;

    @FindBy(xpath = "//button[@class='btn btn-lg btn-primary']")
    WebElement SaveBtn;

    @FindBy(css = "[name='email']")
    WebElement emailField;

    @FindBy(xpath = "//div[@class='col-sm-8 col-md-9']")
    WebElement editForm;

    public Profile_EditDataPage typeNewFirstName(String newFirstName){
        type(firstNameField,2,newFirstName);
        return this;

    }
    public Profile_EditDataPage typeNewEmailAddress(String newEmail){
        type(emailField,2,newEmail);
        return this;

    }

    public void clickOnSaveBtn(){
        click(SaveBtn,2);
    }

    public boolean isEditFormPresent(){
        return editForm.isDisplayed();
    }
}
