package com.telran.oscar.pages.home;

import com.telran.oscar.pages.*;
import com.telran.oscar.pages.product.BooksPage;
import com.telran.oscar.pages.product.ClothingPage;
import com.telran.oscar.pages.product.OffersPage;
import com.telran.oscar.pages.product.ProductPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SidePanelPage extends PageBase {
    public SidePanelPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath= "//a[.='Books']")
    WebElement booksTabOnSidePanel;

    @FindBy(xpath= "//a[.='All products']")
    WebElement allProductsTabOnSidePanel;

    @FindBy(xpath= "//a[.='Clothing']")
    WebElement clothingTabOnSidePanel;

    @FindBy(xpath= "//a[.='Offers']")
    WebElement offersTabOnSidePanel;

    @FindBy(xpath = "//ul[@data-navigation='dropdown-menu']")
    WebElement navigationPanel;

    @FindBy(xpath = "//input[@type='search']")
    WebElement searchField;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement searchBtn;

    public BooksPage clickOnBooksTabOnSidePanel(){
        click(booksTabOnSidePanel,2);
        return new BooksPage(driver);
    }
    public ProductPage clickOnAllProductsTabOnSidePanel(){
        click(allProductsTabOnSidePanel,2);
        return new ProductPage(driver);
    }
    public ClothingPage clickOnClothingTabOnSidePanel(){
        click(clothingTabOnSidePanel,2);
        return new ClothingPage(driver);
    }

    public boolean isNavigationPanelDisplayed(){
        return navigationPanel.isDisplayed();
    }
    public boolean isSearchFieldDisplayed(){
        return searchField.isDisplayed();
    }
    public boolean isSearchBtnDisplayed(){
        return searchBtn.isDisplayed();
    }
    public boolean isSearchBtnClickable(){
        return isElementClickable(searchBtn,1);
    }

    public OffersPage clickOnOffersTabOnSidePanel() {
        click(offersTabOnSidePanel,2);
        return new OffersPage(driver);
    }
}
