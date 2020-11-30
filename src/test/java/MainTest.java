import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import steps.LoginSteps;
import utils.Retry;

public class MainTest extends BaseTest {
    private LoginSteps loginSteps;

//
//    @Test(enabled = false)
//    public void testCreateProject() {
//        LoginSteps loginSteps = new LoginSteps(driver);
//        loginSteps.login(readProperties.getUserName(), readProperties.getPassword());
//        loginSteps.stepsCreateProject(readProperties.getName());
//
//        Assert.assertTrue(true);
//    }


//    @Test(enabled = false)
//    public void testEditProject() {
//        LoginSteps loginSteps = new LoginSteps(driver);
//        loginSteps.login(readProperties.getUserName(), readProperties.getPassword());
//        loginSteps.stepsCreateProject(readProperties.getName());
//        loginSteps.stepsEditProject(readProperties.getNewName());
//
//        Assert.assertTrue(true);
//    }


    @Test
    public void loginPositiveTest() {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.login(readProperties.getUserName(), readProperties.getPassword());

        Assert.assertTrue(true);
    }

    @Test
    public void loginNegativeTest1() {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.login("fail", readProperties.getPassword());

        Assert.assertEquals(new LoginPage(driver, false).getErrorMessage(),
                "Email/Login or Password is incorrect. Please try again.", "Incorrect error message");
    }

    @Test(enabled = false)
    public void loginNegativeTest2() {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.login(readProperties.getUserName(), "fail");

        Assert.assertEquals(new LoginPage(driver, false).getErrorMessage(),
                "Email/Login or Password is incorrect. Please try again.", "Incorrect error message");
    }

    @Test(enabled = false)
    public void loginNegativeTest3() {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.login("fail", "fail");

        Assert.assertEquals(new LoginPage(driver, false).getErrorMessage(),
                "Email/Login or Password is incorrect. Please try again.", "Incorrect error message");
    }


    @DataProvider(name = "набор кредов")
    public Object[][] credentialsFoeTest() {
        return new Object[][]{
                {"atrostyanko+072@gmail.com", "w3n1bU7F4rxOfnfvrBJL"},
                {"incorrectUsername", "w3n1bU7F4rxOfnfvrBJL"},
                {"atrostyanko+072@gmail.com", "incorrectPsw"},
        };
    }

    @Test(enabled = false, dataProvider = "набор кредов")
    public void testLoginWithMultiple(String username, String psw) {
        loginSteps = new LoginSteps(driver);
        loginSteps.login(username, psw);
    }

//    @Parameters({"username", "psw"})
//    @Test(enabled = false)
//     public void testLoginWithParameters(@Optional("1") String username,@Optional("2") String psw){
//        loginSteps=new LoginSteps(driver);
//        loginSteps.login(username, psw);
//    }\

    @Test(retryAnalyzer = Retry.class)
    public void RetryTest(){
        throw new NullPointerException();

    }


}
