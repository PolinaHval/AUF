package utils;

import browserService.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiters {
    private WebDriver driver;
    private WebDriverWait webDriverWait;

    public Waiters(WebDriver driver,int timeout) {
        this.driver = driver;
        webDriverWait=new WebDriverWait(driver,timeout );
    }

    public Waiters (WebDriver driver ){
        this.driver=driver;
        ReadProperties readProperties= new ReadProperties();
        webDriverWait = new WebDriverWait(driver, readProperties.getTimeOut());
    }

    public boolean  isElementDisplayed(By by){
        try {
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;
        }catch(TimeoutException ex){
            return false;
        }
    }

    public WebElement getElementBy (By by){
        try {
            return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
        }catch(TimeoutException ex){
            return null;
        }
    }

    public WebElement isElementClickable (By by){
        try {
            return webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
        }catch(TimeoutException ex){
            return null;
        }
    }

    public WebElement presenceOfElementLocated (By by){
        try {
            return webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
        }catch(TimeoutException ex){
            return null;
        }
    }

    public boolean textToBe (By by){
        try {
            webDriverWait.until(ExpectedConditions.textToBe(by,"Email/Login or Password is incorrect. Please try again."));
            return true;
        }catch(TimeoutException ex){
            return false;
        }
    }


}
