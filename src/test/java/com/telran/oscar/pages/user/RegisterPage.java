package com.telran.oscar.pages.user;

import com.telran.oscar.pages.PageBase;
import com.telran.oscar.pages.home.HeaderPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends PageBase {

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[name='registration-email']")
    WebElement emailField;

    @FindBy(css = "[name='registration-password1']")
    WebElement pswdField;

    @FindBy(css = "[name='registration-password2']")
    WebElement pswdConfirmField;

    @FindBy(css = "[name='registration_submit']")
    WebElement registerBtn;

    @FindBy(id="register_form")
    WebElement registerForm;

    @FindBy(css = ".error-block")
    WebElement errorDifferentPswd;


    public RegisterPage fillRegisterForm(String email, String password, String confirmPassword) {
        type(emailField,2,email);
        type(pswdField,2,password);
        type(pswdConfirmField,2,confirmPassword);

        return this;
    }

    public HeaderPage clickOnRegisterBtn() {
        click(registerBtn, 2);
        return new HeaderPage(driver);
    }

    public boolean isRegisterFormDisplayed() {
        return registerForm.isDisplayed();
    }

    public String errorDifferentPswd() {
        return errorDifferentPswd.getText();
    }
}
