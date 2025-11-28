package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import utils.ConfigReader;
import hooks.CucumberHooks;

public class LoginSteps {

    protected WebDriver driver;
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected String validUsername;
    protected String validPassword;

    public LoginSteps() {
        driver = CucumberHooks.driver;
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        validUsername = ConfigReader.getProperty("username");
        validPassword = ConfigReader.getProperty("password");
    }

    @Given("The User is on the Login page")
    public void theUserIsOnTheLoginPage() {
        System.out.println("Navigating to Login Page");
        Assert.assertTrue(loginPage.navigateToLoginPage());
    }

    @When("The User enters a valid username and password")
    public void theUserEntersAValidUsernameAndPassword() {
        System.out.println("Entering valid username and password");
        loginPage.enterUsername(validUsername);
        loginPage.enterPassword(validPassword);
    }

    @And("The User clicks the login button")
    public void theUserClicksTheLoginButton() {
        System.out.println("Clicking the login button");
        loginPage.clickLoginButton();
    }

    @Then("The User should be redirected to the Homepage")
    public void theUserShouldBeRedirectedToTheHomepage() {
        System.out.println("Verifying redirection to Homepage");
        Assert.assertTrue(homePage.isHomePageLogoDisplayed());
        Assert.assertTrue(driver.getCurrentUrl().contains("/inventory"));
    }

    @When("The User enters an invalid username {string} and password {string}")
    public void theUserEntersAnInvalidUsernameAndPassword(String arg0, String arg1) {
        System.out.println("Entering invalid username and password");
        loginPage.enterUsername(arg0);
        loginPage.enterPassword(arg1);
    }



    @Then("An error message should be displayed")
    public void anErrorMessageShouldBeDisplayed() {
        System.out.println("Verifying error message is displayed");
        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
    }

    @Given("The User is logged in with valid credentials")
    public void theUserIsLoggedInWithValidCredentials() {
        System.out.println("Logging in with valid credentials");
        loginPage.enterUsername(validUsername);
        loginPage.enterPassword(validPassword);
        loginPage.clickLoginButton();
        Assert.assertTrue(homePage.isHomePageLogoDisplayed());
    }

    @When("The User clicks the logout button")
    public void theUserClicksTheLogoutButton() {
        System.out.println("Clicking the logout button");
        homePage.clickMenuButton();
        homePage.clickLogoutLink();
    }

    @Then("The User should be redirected to the Login page")
    public void theUserShouldBeRedirectedToTheLoginPage() {
        System.out.println("Verifying redirection to Login Page");
        Assert.assertTrue(loginPage.navigateToLoginPage());
    }

    @Then("A locked out error message should be displayed")
    public void aLockedOutErrorMessageShouldBeDisplayed() {
        System.out.println("Verifying locked out error message is displayed");
        Assert.assertTrue(loginPage.isLockedOutErrorMessageDisplayed());
    }
}
