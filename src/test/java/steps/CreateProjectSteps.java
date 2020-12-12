package steps;

import org.openqa.selenium.WebDriver;
import pages.CreateProjectPage;

public class CreateProjectSteps {
    private WebDriver driver;

    public CreateProjectSteps(WebDriver driver) {
        this.driver = driver;
    }


    public void createProject(String username,String psw,String name){
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.login(username,psw);
        CreateProjectPage createProjectPage= new CreateProjectPage(driver,true);
        createProjectPage.getName().sendKeys(name);
        createProjectPage.getButton().click();
    }
}
