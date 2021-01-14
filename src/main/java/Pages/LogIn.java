package Pages;

import Core.Constants;
import Core.MyActions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class LogIn {

    private By userNameField = By.name("email");
    private By passwordField = By.name("password");
    private By logInButton = By.id("buttonFormLogin");

    @Step("set email and password: {0} step ...")
    public void logIn() {
        MyActions.sendKeys(userNameField, Constants.email);
        MyActions.sendKeys(passwordField, Constants.password);
        MyActions.click(logInButton);
    }
}
