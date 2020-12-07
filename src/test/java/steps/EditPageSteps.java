package steps;

import browserService.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CreateProjectPage;
import pages.Dashboard;
import pages.EditPage;

public class EditPageSteps{
    private WebDriver driver;


    public EditPageSteps(WebDriver driver) {
        this.driver = driver;
    }

    public void stepsEditProject(String username, String psw, String newName){
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.login(username,psw);
        EditPage editPage = new EditPage(driver,true);
        editPage.getEditButton().click();
        editPage.getName().clear();
        editPage.getName().sendKeys(newName);
        editPage.getButton().click();
    }
}
