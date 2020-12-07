package steps;

import org.openqa.selenium.WebDriver;

import pages.DeletePage;
import pages.EditPage;

public class DeleteSteps {
    private WebDriver driver;

    public DeleteSteps(WebDriver driver) {
        this.driver = driver;
    }

    public void delete(String username, String psw) {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.login(username, psw);
        DeletePage deletePage = new DeletePage(driver,true);
        deletePage.getDeleteButton().click();
        deletePage.getCheckbox().click();
        deletePage.getOk().click();
    }
}
