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
       // homePage.handleJavaScriptAlertIfPresent();
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

    @When("The User enters a locked out username and password")
    public void theUserEntersALockedOutUsernameAndPassword() {
        System.out.println("Entering locked out username and password");
        String lockedOutUsername = ConfigReader.getProperty("lockedOutUsername");
        String lockedOutPassword = ConfigReader.getProperty("lockedOutPassword");
        loginPage.enterUsername(lockedOutUsername);
        loginPage.enterPassword(lockedOutPassword);
    }

    @When("The User enters a problem user username and password")
    public void theUserEntersAProblemUserUsernameAndPassword() {
        System.out.println("Entering problem user username and password");
        String problemUsername = ConfigReader.getProperty("problemUsername");
        String problemPassword = ConfigReader.getProperty("problemPassword");
        loginPage.enterUsername(problemUsername);
        loginPage.enterPassword(problemPassword);
    }

    @Then("The User should be redirected to the Homepage with issues")
    public void theUserShouldBeRedirectedToTheHomepageWithIssues() {
        System.out.println("Verifying redirection to Homepage with issues");
        homePage.handleJavaScriptAlertIfPresent();
        Assert.assertTrue(homePage.isHomePageLogoDisplayed());
        Assert.assertTrue(driver.getCurrentUrl().contains("/inventory"));
    }

    @When("The User enters a performance glitch user username and password")
    public void theUserEntersAPerformanceGlitchUserUsernameAndPassword() {
        System.out.println("Entering performance glitch user username and password");
        String performanceUsername = ConfigReader.getProperty("performanceGlitchUsername");
        String performancePassword = ConfigReader.getProperty("performanceGlitchPassword");
        loginPage.enterUsername(performanceUsername);
        loginPage.enterPassword(performancePassword);
    }

    @Then("The User should be redirected to the Homepage after a delay")
    public void theUserShouldBeRedirectedToTheHomepageAfterADelay() {
        System.out.println("Verifying redirection to Homepage after a delay");
        // Check for delay
        long startTime = System.currentTimeMillis();
        homePage.handleJavaScriptAlertIfPresent();
        Assert.assertTrue(homePage.isHomePageLogoDisplayed());
        Assert.assertTrue(driver.getCurrentUrl().contains("/inventory"));
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("Login redirection delay: " + elapsedTime + " ms");
    }
}
