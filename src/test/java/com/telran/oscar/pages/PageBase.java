package com.telran.oscar.pages;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class PageBase {
    protected WebDriver driver;

    public PageBase(WebDriver driver){
        this.driver = driver;
      //  PageFactory.initElements(driver,this);
    }

    public void type(WebElement element, int timeout, String text) {

        try {
            new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
            element.clear();
            element.sendKeys(text);
        } catch (WebDriverException wde) {
            System.out.println(wde);
        }
    }

    public void scrollUpOrDown(int x, int y){
        JavascriptExecutor js =(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy("+ x + ","+ y + ")");
    }

    public void click(WebElement element, int timeout){
        try{
            new WebDriverWait(driver,timeout).until(ExpectedConditions.elementToBeClickable(element)).click();

        }catch (WebDriverException wde){
            System.out.println(wde);
        }
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        }catch(InterruptedException e){
            System.out.println(e);
        }
    }

    public void selectDropDownByValue(WebElement element, String value){
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public String takeScreenshot() {
        File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File screenshot = new File("screenshot/screen" + System.currentTimeMillis() + ".png");
        try {
            Files.copy(tmp, screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return screenshot.getAbsolutePath();
    }

    public Screenshot takeScreenshotWithScrollDown(){
        Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(ShootingStrategies.scaling(1f),1000))
                .takeScreenshot(driver);
        try{
            ImageIO.write(screenshot.getImage(),"PNG", new File("screenshot/screen" + System.currentTimeMillis() + ".png"));
        }catch (IOException e){
            e.printStackTrace();
        }
        return screenshot;
    }

    public void fillAddressForm(WebElement title, String titleValue, WebElement firstName, String fName,
                                WebElement lastName, String lName, WebElement address1, String adr1, WebElement shippingCity,
                                String city, WebElement postCode, String zipCode, WebElement country, String countryValue,
                                WebElement phoneNumber, String phone){
        selectDropDownByValue(title,titleValue);
        type(firstName,2,fName);
        type(lastName,2,lName);
        type(address1,2,adr1);
        type(shippingCity,2, city);
        type(postCode,2,zipCode);
        selectDropDownByValue(country,countryValue);
        type(phoneNumber,2,phone);

    }

    public boolean isElementClickable(WebElement element, int timeout){

        WebElement elementTemp = null;
        try{
         elementTemp = new WebDriverWait(driver,timeout).until(ExpectedConditions.elementToBeClickable(element));

         if(elementTemp!=null){
             return true;
         }
        }catch (WebDriverException wde){
            System.out.println(wde);
        }

        return false;
    }

    public boolean isPageHeaderDisplayed(){
        return driver.findElement(By.cssSelector(".page-header.action")).isDisplayed();
    }
}
