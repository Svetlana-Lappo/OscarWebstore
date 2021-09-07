package com.telran.oscar.tests;

import com.telran.oscar.pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class TestBase {

    WebDriver driver;
   // String browser;
    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeMethod(alwaysRun = true)
    public void startTest(Method method, Object[] p){
        logger.info("Start test: " + method.getName());
        if(p.length!=0){
            logger.info("--> With data: " + Arrays.asList(p));
        }
    }

    @BeforeMethod
    @Parameters("browser")
    public void setUp(String browser){
        //headless
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        options.addArguments("window-size=1200x800");
//        driver = new ChromeDriver(options);
        if(browser.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver(options);
        }else if (browser.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver(options);
        }
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
        driver.get("https://selenium1py.pythonanywhere.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result){

        if(result.isSuccess()){
            logger.info("Test result: PASSED");
        }
        else{
            logger.error("Test result: FAILD" +"\n" + new PageBase(driver).takeScreenshotWithScrollDown());
        }
        logger.info("Stop test: " +result.getTestName());
        logger.info("*************************************");
        driver.quit();

    }
}
