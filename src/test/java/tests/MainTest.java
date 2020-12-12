package tests;

import baseEntities.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import steps.CreateProjectSteps;
import steps.DeleteSteps;
import steps.EditPageSteps;
import steps.LoginSteps;
import utils.Retry;

public class MainTest extends BaseTest {


    @Test(priority =3)
    public void testDelete(){
        DeleteSteps deleteSteps = new DeleteSteps(driver);
        deleteSteps.delete(readProperties.getUserName(), readProperties.getPassword());

        Assert.assertTrue(true);
    }


    @Test(priority = 1)
    public void testCreateProject() {
        CreateProjectSteps createProjectSteps = new CreateProjectSteps(driver);
        createProjectSteps.createProject(readProperties.getUserName(), readProperties.getPassword(),
                readProperties.getName());

        Assert.assertTrue(true);
    }

    @Test(priority = 2)
    public void testEditProject() {
        EditPageSteps editPageSteps = new EditPageSteps(driver);
        editPageSteps.stepsEditProject(readProperties.getUserName(), readProperties.getPassword(),
                readProperties.getNewName());

        Assert.assertTrue(true);
    }


    @Test(enabled = false,priority = 1, description="Description for Allure")
    @Description("Немного деталей по тесту")
    @Link("https://aqa07.atlassian.net/browse/AQA07-25")
    @TmsLink("1")
    @Severity(SeverityLevel.BLOCKER)
    public void loginPositiveTest() {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.login(readProperties.getUserName(), readProperties.getPassword());

        Assert.assertTrue(true);
    }

    @Test(enabled = false,priority = 2)
    @Issue("AQA07-25")
    @Severity(SeverityLevel.NORMAL)
    public void loginNegativeTest1() {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.login("fail", readProperties.getPassword());

        Assert.assertEquals(new LoginPage(driver, false).getErrorMessage(),
                "Email/Login or Password is incorrect. Please try again.", "Incorrect error message");
    }

    @Test(enabled = false,priority = 3)
    public void loginNegativeTest2() {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.login(readProperties.getUserName(), "fail");

        Assert.assertEquals(new LoginPage(driver, false).getErrorMessage(),
                "Email/Login or Password is incorrect. Please try again.", "Incorrect error message");
    }

    @Test(enabled = false,priority = 4)
    public void loginNegativeTest3() {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.login("fail", "fail");

        Assert.assertEquals(new LoginPage(driver, false).getErrorMessage(),
                "Email/Login or Password is incorrect. Please try again.", "Incorrect error message");
    }


//    @DataProvider(name = "набор кредов")
//    public Object[][] credentialsFoeTest() {
//        return new Object[][]{
//                {"atrostyanko+072@gmail.com", "w3n1bU7F4rxOfnfvrBJL"},
//                {"incorrectUsername", "w3n1bU7F4rxOfnfvrBJL"},
//                {"atrostyanko+072@gmail.com", "incorrectPsw"},
//        };
//    }
//
//    @Test(enabled = false, dataProvider = "набор кредов")
//    public void testLoginWithMultiple(String username, String psw) {
//        loginSteps = new LoginSteps(driver);
//        loginSteps.login(username, psw);
//    }

//    @Parameters({"username", "psw"})
//    @Test(enabled = false)
//     public void testLoginWithParameters(@Optional("1") String username,@Optional("2") String psw){
//        loginSteps=new LoginSteps(driver);
//        loginSteps.login(username, psw);
//    }\
//
//    @Test(retryAnalyzer = Retry.class)
//    public void RetryTest(){
//        throw new NullPointerException();
//
//    }


}
