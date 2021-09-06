package com.telran.oscar.pages.basket;

import com.telran.oscar.pages.PageBase;
import com.telran.oscar.pages.user.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterFormPage extends PageBase {
    public RegisterFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[name=password1]")
    WebElement pswd;

    @FindBy(css = "[name=password2]")
    WebElement confirmPswd;

    @FindBy(css = "[name=registration_submit]")
    WebElement registerBtn;


    public RegisterFormPage typePassword(String password) {
        type(pswd,1,password);
        return this;
    }

    public RegisterFormPage typeConfirmPassword(String confirmPassword) {
        type(confirmPswd,1,confirmPassword);
        return this;
    }

    public void clickOnRegisterBtn() {
        click(registerBtn,1);
    }
}
