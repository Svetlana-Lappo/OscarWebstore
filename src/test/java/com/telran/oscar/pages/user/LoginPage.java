package com.telran.oscar.pages.user;

import com.telran.oscar.pages.PageBase;
import com.telran.oscar.pages.home.HeaderPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[name='login-username']")
    WebElement loginUsername;

    @FindBy(css ="[name='login-password']")
    WebElement loginPassword;

    @FindBy(css ="[name='login_submit']")
    WebElement loginBtn;

    @FindBy(id ="login_form")
    WebElement loginForm;

    public LoginPage fillLoginForm(String username, String password) {
       type(loginUsername,2,username);
       type(loginPassword,2,password);
       return this;
    }

    public HeaderPage clickOnLogInBtn() {

        click(loginBtn,2);
        return new HeaderPage(driver);
    }

    public boolean isLoginFormDisplayed() {
     return loginForm.isDisplayed();
    }
}
