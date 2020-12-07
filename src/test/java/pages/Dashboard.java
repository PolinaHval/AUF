package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Dashboard extends BasePage {
    private static String ENDPOINT ="/dashboard";

    protected By buttonAddProjectSelector = By.id("sidebar-projects-add");


    public Dashboard(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(BASE_URL+ENDPOINT);

    }

    @Override
    public boolean isPageOpened() {
        try{
            return driver.findElement(By.id("sidebar-projects-add")).isDisplayed();
        }catch(Exception ex){
            return false;
        }
    }

    public WebElement getButtonCreateProject (){
        return driver.findElement(buttonAddProjectSelector);
    }
}
