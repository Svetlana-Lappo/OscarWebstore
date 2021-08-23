package com.telran.oscar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase{


    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".dropdown-submenu")
    WebElement submenuBook;

    @FindBy(id = "login_link")
    WebElement loginAndRegistrationTab;

    @FindBy(id = "logout_link")
    WebElement logoutBtn;

    @FindBy(css = "[name='language']")
    WebElement selectLanguage;

    @FindBy(xpath = "//button[@class='btn btn-default']")
    WebElement goBtn;

    @FindBy(css = ".icon-user")
    WebElement accountTab;

    @FindBy(xpath = "//a[@class='btn btn-default']")
    WebElement viewBasketBtn;

    @FindBy(xpath= "//a[.='Books']")
    WebElement booksTabOnSidePanel;

    public HomePage selectCategory() {
        submenuBook.click();
        return this;
    }

    public RegisterPage goToRegistration() {
        click(loginAndRegistrationTab,2);
        return new RegisterPage(driver);
    }

    public boolean isLogoutBtnDisplayed() {
        return logoutBtn.isDisplayed();
    }

    public void selectLanguage(String language) {
        selectDropDownByValue(selectLanguage,language);
        click(goBtn,2);
    }

    public ProfilePage clickOnAccountBtn() {
        click(accountTab,2);
        return new ProfilePage(driver);
    }

    public BasketPage clickOnViewBasketBtn(){
        click(viewBasketBtn,2);
        return new BasketPage(driver);
    }

    public BooksPage clickOnBooksTabOnSidePanel(){
        click(booksTabOnSidePanel,2);
        return new BooksPage(driver);
    }
}
