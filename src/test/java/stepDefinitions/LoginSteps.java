package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObjects.BasePageObject;
import pageObjects.LoginPageObject;

public class LoginSteps extends BasePageObject {
    private WebDriver driver = getDriver();

    private LoginPageObject loginPageObject;

    public LoginSteps(LoginPageObject loginPageObject) {
        this.loginPageObject = loginPageObject;
    }

    @Given("I access the E-commerce Website login page")
    public void i_access_the_e_commerce_website_login_page() {
        loginPageObject.navigateToLoginPage();
    }

    @When("I enter an email {string}")
    public void i_enter_an_email(String email) {
        loginPageObject.setEmail(email);
    }

    @And("I enter a password {}")
    public void i_enter_a_password(String password) {
        loginPageObject.setPassword(password);
    }

    @And("I click on the Login button")
    public void i_click_on_the_login_button() {
        loginPageObject.clickOnLoginButton();
    }

    @Then("I should be presented with the Account button in the navbar")
    public void i_should_be_presented_with_the_account_button_in_the_navbar() {
        boolean isAccountButtonDisplayed = loginPageObject.isAccountButtonDisplayed();
        Assert.assertTrue(isAccountButtonDisplayed);
    }

    @Then("I should be presented with the invalid login credentials error message")
    public void i_should_be_presented_with_the_invalid_login_credentials_error_message() {
        WebElement errorMessage = loginPageObject.getErrorMessage();
        Assert.assertEquals(errorMessage.getText(), "Invalid email or password");
    }
}
