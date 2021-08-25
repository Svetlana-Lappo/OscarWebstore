package com.telran.oscar.pages;

import com.telran.oscar.tests.TestBase;
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

    public Profile_EditDataPage typeNewFirstName(String newFirstName){
        type(firstNameField,2,newFirstName);
        return this;

    }
    public void clickOnSaveBtn(){
        click(SaveBtn,2);
    }
}
