package Pages;

import Core.Constants;
import Core.Element;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class LogIn {

    private By userNameField = By.name("email");
    private By passwordField = By.name("password");
    private By logInButton = By.id("buttonFormLogin");

    @Step("set email and password: {0} step ...")
    public void logIn() {
        Element.sendKeys(userNameField, Constants.email);
        Element.sendKeys(passwordField, Constants.password);
        Element.click(logInButton);
    }
}