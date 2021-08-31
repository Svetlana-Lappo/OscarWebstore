package com.telran.oscar.pages.user;

import com.telran.oscar.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteProfilePage extends PageBase {
    public DeleteProfilePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "[name=password]")
    WebElement pswdField;
    @FindBy(xpath = "//button[@class='btn btn-lg btn-danger']")
    WebElement deleteBtn;
    @FindBy(xpath = "//span[@class='error-block']")
    WebElement errorDeleteProfileAlert;

    public DeleteProfilePage typeProfilePassword(String password) {
        type(pswdField,2,password);
        return this;
    }

    public void clickOnDeleteBtn() {
        click(deleteBtn,2);

    }

    public String getMessageOfErrorDelProfileAlert(){
        return errorDeleteProfileAlert.getText();
    }
}
