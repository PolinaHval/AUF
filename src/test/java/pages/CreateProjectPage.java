package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateProjectPage extends BasePage {
    private static String ENDPOINT = "/admin/projects/add/1";

    protected By nameSelector = By.id("name");
    protected By buttonSelector = By.id("accept");


    public CreateProjectPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(BASE_URL+ENDPOINT);

    }

    @Override
    public boolean isPageOpened() {
        try {
            return driver.findElement(By.id("accept")).isDisplayed();
        }catch (Exception ex){
        return false;
        }
    }

    public WebElement getName (){
        return driver.findElement(nameSelector);
    }


    public WebElement getButton (){
        return driver.findElement(buttonSelector);
    }












}
