package com.telran.oscar.pages.basket;

import com.telran.oscar.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WhoAreYouPage extends PageBase {
    public WhoAreYouPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = ".form-stacked.well")
    WebElement whoAreYouForm;

    @FindBy(css="[name=username]")
    WebElement emailField;

    @FindBy(css="[name=password]")
    WebElement passwordField;

    @FindBy(id = "id_options_1")
    WebElement chooseRegistrationOption;

    @FindBy(css = "[type=submit]")
    WebElement continueBtn;

    public boolean isWhoAreYouFormDisplayed(){
        return whoAreYouForm.isDisplayed();
    }

    public WhoAreYouPage typeEmailAddress(String email) {
        type(emailField,1,email);
        return this;
    }

    public WhoAreYouPage selectRegistrationOption() {
        click(chooseRegistrationOption,1);
        return this;
    }

    public void clickOnContinueBtn() {
        click(continueBtn,1);
    }

    public WhoAreYouPage typePassword(String password) {
        type(passwordField,1,password);
        return this;
    }
}
