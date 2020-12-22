package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginPage extends BasePage {
    private static String ENDPOINT ="/auth/login";

    protected By emailSelector = By.id("name");
    protected By passwordSelector = By.id("password");
    protected By loginSelector = By.id("button_primary");
    protected By ERROR_MESSAGE = By.className("error-text");




    public LoginPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(BASE_URL+ENDPOINT);

    }

    @Override
    public boolean isPageOpened() {
         return waiters.isElementDisplayed(By.id("button_primary"));
    }


    public WebElement getEmailField() {
        return waiters.presenceOfElementLocated(emailSelector);
    }

    public WebElement getPasswordField() {
        return waiters.getElementBy(passwordSelector);
    }

    public WebElement getLoginButton() {
        return waiters.getElementBy(loginSelector);
    }

    public String getErrorMessage() {
        return waiters.getElementBy(ERROR_MESSAGE).getText();
    }
}
