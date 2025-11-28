import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepdefs {
    @Given("The User is on the Login page")
    public void theUserIsOnTheLoginPage() {
    }

    @When("The User enters a valid username and password")
    public void theUserEntersAValidUsernameAndPassword() {
    }

    @And("The User clicks the login button")
    public void theUserClicksTheLoginButton() {
    }

    @Then("The User should be redirected to the Homepage")
    public void theUserShouldBeRedirectedToTheHomepage() {
    }

    @When("The User enters an invalid username {string} and password {string}")
    public void theUserEntersAnInvalidUsernameAndPassword(String arg0, String arg1) {
    }

    @Then("An error message should be displayed {string}")
    public void anErrorMessageShouldBeDisplayed(String arg0) {
    }
}
