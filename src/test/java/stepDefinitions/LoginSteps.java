package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static driver.DriverFactory.getDriver;

public class LoginSteps {
    private WebDriver driver = getDriver();

    @Given("I access the E-commerce Website login page")
    public void i_access_the_e_commerce_website_login_page() {
        driver.get("http://localhost:3000/login");
    }

    @When("I enter an email {string}")
    public void i_enter_an_email(String email) {
        driver.findElement(By.id("email")).sendKeys(email);
    }

    @And("I enter a password {}")
    public void i_enter_a_password(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @And("I click on the Login button")
    public void i_click_on_the_login_button() {
        driver.findElement(By.xpath("//button[text()='Login']")).click();
    }

    @Then("I should be presented with the Account button in the navbar")
    public void i_should_be_presented_with_the_account_button_in_the_navbar() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Account']")));
        Boolean isAccountButtonDisplayed = driver.findElement(By.xpath(
                "//button[text()='Account']")).isDisplayed();
        Assert.assertTrue(isAccountButtonDisplayed);
    }

    @Then("I should be presented with the invalid login credentials error message")
    public void i_should_be_presented_with_the_invalid_login_credentials_error_message() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
                "//p[contains(@class, 'text-danger text-center') and text() = 'Invalid email or password']")));
        WebElement errorMessage = driver.findElement(By.xpath(
                "//p[contains(@class, 'text-danger text-center') and text() = 'Invalid email or password']"));
        Assert.assertEquals(errorMessage.getText(), "Invalid email or password");
    }
}
