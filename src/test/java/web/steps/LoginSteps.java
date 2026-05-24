package web.steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import web.pages.LoginPage;
import utils.DriverManager;

public class LoginSteps {

    WebDriver driver = DriverManager.getDriver();
    LoginPage loginPage = new LoginPage(driver);

    @Given("User is on CRM login page")
    public void openLoginPage() {
        loginPage.open();
    }

    @When("User input valid username and password")
    public void loginValid() {
        loginPage.login("standard_user", "secret_sauce");
    }

    @When("User input invalid username and password")
    public void loginInvalid() {
        loginPage.login("wrong", "wrong");
    }

    @Then("User should be redirected to dashboard")
    public void verifySuccess() {
        Assert.assertTrue(loginPage.isLoginSuccess());
        driver.quit();
    }

    @Then("Error message should be displayed")
    public void verifyError() {
        Assert.assertTrue(loginPage.isErrorDisplayed());
        driver.quit();
    }
}