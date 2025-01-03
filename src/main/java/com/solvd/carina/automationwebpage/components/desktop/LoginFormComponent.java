package com.solvd.carina.automationwebpage.components.desktop;

import com.solvd.carina.automationwebpage.components.common.LoginFormBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginFormComponent extends LoginFormBase {

    @FindBy(xpath = ".//input[@data-qa='login-email']")
    private ExtendedWebElement emailInput;

    @FindBy(xpath = ".//input[@name='password']")
    private ExtendedWebElement passwordInput;

    @FindBy(xpath = ".//button[@data-qa='login-button']")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = ".//p[text()='Your email or password is incorrect!']")
    private ExtendedWebElement emailOrPasswordIncorrectMessage;

    @FindBy(xpath = "//h2[text()='Login to your account']")
    private ExtendedWebElement loginToYourAccountMessage;

    public LoginFormComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void typeInEmailInput(String email) {
        emailInput.type(email);
    }

    public void typeInPasswordInput(String pass) {
        passwordInput.type(pass);
    }

    public void clickOnLoginButton() {
        loginButton.click();
    }

    public void login(String email, String pass) {
        typeInEmailInput(email);
        typeInPasswordInput(pass);
        clickOnLoginButton();
    }

    public boolean isErrorMessageVisible() {
        return emailOrPasswordIncorrectMessage.isVisible();
    }

    public boolean isLoginToYourAccountMessageVisible() {
        return loginToYourAccountMessage.isVisible();
    }
}
