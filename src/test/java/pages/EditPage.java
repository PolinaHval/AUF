package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditPage extends BasePage {

    private static String ENDPOINT ="/admin/projects/overview";

    protected By editSelector= By.linkText("Auf");
    protected By nameSelector = By.id("name");
    protected By buttonSelector = By.id("accept");


    public EditPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(BASE_URL+ENDPOINT);
    }

    @Override
    public boolean isPageOpened() {
        try{
            return driver.findElement(By.id("navigation-sub-users")).isDisplayed();
        } catch (Exception ex){
            return false;
        }
    }

    public WebElement getEditButton(){
        return driver.findElement(editSelector);

    }

    public WebElement getName(){
        return driver.findElement(nameSelector);
    }


    public WebElement getButton(){
        return driver.findElement(buttonSelector);
    }

}
