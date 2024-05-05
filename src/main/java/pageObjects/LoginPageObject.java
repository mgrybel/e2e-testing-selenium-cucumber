package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.GlobalVars;

public class LoginPageObject extends BasePageObject {
    public LoginPageObject() {
        super();
    }

    private @FindBy(id = "email")
    WebElement emailTextField;

    private @FindBy(id = "password")
    WebElement passwordTextField;

    private @FindBy(xpath = "//button[text()='Login']")
    WebElement loginButton;

    public void navigateToLoginPage() {
        navigateToURL(GlobalVars.ECOMMERCE_WEBSITE_URL + "/login");
    }

    public void setEmail(String email) {
        sendKeys(emailTextField, email);
    }

    public void setPassword(String password) {
        sendKeys(passwordTextField, password);
    }

    public void clickOnLoginButton() {
        waitForWebElementAndClick(loginButton);
    }

    public boolean isAccountButtonDisplayed() {
        return isWebElementDisplayed(By.xpath("//button[text()='Account']"));
    }

    public WebElement getErrorMessage() {
        WebElement errorMessage = getWebElement(By.xpath(
                "//p[contains(@class, 'text-danger text-center') and text() = 'Invalid email or password']"));
        return errorMessage;
    }
}
