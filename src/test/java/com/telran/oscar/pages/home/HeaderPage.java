package com.telran.oscar.pages.home;

import com.telran.oscar.pages.*;
import com.telran.oscar.pages.basket.BasketPage;
import com.telran.oscar.pages.user.ProfilePage;
import com.telran.oscar.pages.user.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderPage extends PageBase {

    public HeaderPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = ".dropdown-submenu")
    WebElement submenuBook;

    @FindBy(id = "login_link")
    WebElement loginAndRegistrationTab;

    @FindBy(css = ".icon-signout")
    WebElement logoutBtn;

    @FindBy(css = "[name='language']")
    WebElement selectLanguage;

    @FindBy(xpath = "//button[@class='btn btn-default']")
    WebElement goBtn;

    @FindBy(css = ".icon-user")
    WebElement accountTab;

    @FindBy(xpath = "//a[@class='btn btn-default']")
    WebElement viewBasketBtn;


    @FindBy(xpath = "//div[@class='alertinner wicon']")
    WebElement successfullyDeleteProfileAlert;

    @FindBy(xpath = "//div[@class='col-sm-7 h1']/a")
    WebElement siteTitle;

    @FindBy(xpath = "//strong[contains(text(),'Summe')]")
    WebElement basketTotal;



    public HeaderPage selectCategory() {
        submenuBook.click();
        return this;
    }

    public HeaderPage clickOnLogOutBtn(){
        click(logoutBtn,2);
        return this;
    }

    public RegisterPage goToRegistrationAndLogin() {
        click(loginAndRegistrationTab,2);
        return new RegisterPage(driver);
    }
    public boolean isLoginOrRegisterBtnClickable(){
        return isElementClickable(loginAndRegistrationTab,1);
    }
    public boolean isLogoutBtnDisplayed() {
        return logoutBtn.isDisplayed();
    }


    public boolean isLogoutBtnClickable(){
      return isElementClickable(logoutBtn,2);
    }

    public void selectLanguage(String language) {
        selectDropDownByValue(selectLanguage,language);
        click(goBtn,2);
    }
    public boolean isSelectLanguageBtnClickable(){
       return isElementClickable(selectLanguage,1);
    }

    public ProfilePage clickOnAccountBtn() {
        click(accountTab,2);
        return new ProfilePage(driver);
    }
    public boolean isAccountBtnClickable(){
        return isElementClickable(accountTab,1);
    }
    public boolean isAccountBtnDisplayed(){
        return accountTab.isDisplayed();
    }
    public BasketPage clickOnViewBasketBtn(){
        click(viewBasketBtn,2);
        return new BasketPage(driver);
    }

    public boolean isLogoLinkDisplayed(){
        return siteTitle.isDisplayed();
    }
    public boolean isLogoLinkClickable(){
        return isElementClickable(siteTitle,1);
    }

    public boolean isSelectLanguageBtnDisplayed(){
        return selectLanguage.isDisplayed();
    }
    public boolean isGoBtnDisplayed(){
        return goBtn.isDisplayed();
    }
    public boolean isGoBtnClickable(){
        return isElementClickable(goBtn,1);
    }
    public boolean isLoginOrRegisterBtnDisplayed(){
        return goBtn.isDisplayed();
    }
    public boolean isViewBasketBtnDisplayed(){
        return viewBasketBtn.isDisplayed();
    }
    public boolean isViewBasketBtnClickable(){
        return isElementClickable(viewBasketBtn,1);
    }

    public boolean isBasketTotalDisplayed(){
        return basketTotal.isDisplayed();
    }

    public String getMessageOfSuccessfullyDelProfileAlert(){
        return successfullyDeleteProfileAlert.getText();
    }

    public void clickOnLogoLink(){
        click(siteTitle,2);
    }

}
