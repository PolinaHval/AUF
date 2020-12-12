package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class WaitsTest extends BaseTest {


    @Test
    public void waits (){
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        WebDriverWait webDriverWait = new WebDriverWait(driver,10);

        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.linkText("удалять")));
        webDriverWait.until(ExpectedConditions.attributeContains(By.cssSelector("[onclick=\"addElement()\"]"),
                "onclick","addElement()"));
        webDriverWait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(By.id("content"),
                By.cssSelector("[onclick=\"addElement()\"]")));
        webDriverWait.until(ExpectedConditions.numberOfElementsToBe(By.id("content"),1));
        webDriverWait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.id("content"),3));
        webDriverWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.id("content"),0));


        driver.quit();
    }


    @Test
    public void waitsTest (){
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        WebDriverWait webDriverWait = new WebDriverWait(driver,10);
        webDriverWait.until(ExpectedConditions.elementSelectionStateToBe(By.cssSelector("[type=\"checkbox\"]"),false));

        driver.quit();
    }
}
