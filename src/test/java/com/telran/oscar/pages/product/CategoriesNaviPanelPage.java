package com.telran.oscar.pages.product;

import com.telran.oscar.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CategoriesNaviPanelPage extends PageBase {
    public CategoriesNaviPanelPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//ul[@class='nav nav-list']//li//a[contains(.,'Clothing')]")
    WebElement clothingTab;
    @FindBy(xpath = "//ul[@class='nav nav-list']//li//a[contains(.,'Books')]")
    WebElement booksTab;
    @FindBy(xpath ="//ul[@class='nav nav-list']//li[1]//a[contains(.,'Fiction')]")
    WebElement fictionTab;
    @FindBy(xpath ="//ul[@class='nav nav-list']//li[1]//a[contains(.,'Computers')]")
    WebElement compInLiteratureTab;
    @FindBy(xpath ="//ul[@class='nav nav-list']//li[2]//a[contains(.,'Non-Fiction')]")
    WebElement nonFictionTab;
    @FindBy(xpath ="//ul[@class='nav nav-list']//li[2]//a[contains(.,'Essential')]")
    WebElement essentialProgrammingTab;
    @FindBy(xpath ="//ul[@class='nav nav-list']//li[2]//a[contains(.,'Hacking')]")
    WebElement hackingTab;

    public ClothingPage clickOnClothingTab(){
        click(clothingTab,2);
        return new ClothingPage(driver);
    }
    public BooksPage clickOnBooksTab(){
        click(booksTab,2);
        return new BooksPage(driver);
    }
    public FictionPage clickOnFictionTab(){
        click(fictionTab,2);
        return new FictionPage(driver);
    }
    public CompInLiteraturePage clickOnCompInLiteratureTab(){
        click(compInLiteratureTab,2);
        return new CompInLiteraturePage(driver);
    }
    public NonFictionPage clickOnNonFictionTab(){
        click(nonFictionTab,2);
        return new NonFictionPage(driver);
    }

    public EssentialProgrammingPage clickOnEssentialProgrammingTab() {
        click(essentialProgrammingTab,2);
        return new EssentialProgrammingPage(driver);
    }

    public HackingPage clickOnHackingTab() {
        click(hackingTab,2);
        return new HackingPage(driver);

    }
}
