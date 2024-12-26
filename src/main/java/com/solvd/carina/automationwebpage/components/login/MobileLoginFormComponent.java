package com.solvd.carina.automationwebpage.components.login;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class MobileLoginFormComponent extends LoginFormBase implements IMobileUtils {

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

    public MobileLoginFormComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public void login(String email, String pass) {
        emailInput.type(email);
        hideKeyboard();
        passwordInput.type(pass);
        hideKeyboard();
        loginButton.click();
    }

    @Override
    public boolean isErrorMessageVisible() {
        emailOrPasswordIncorrectMessage.scrollTo();
        return emailOrPasswordIncorrectMessage.isVisible();
    }

    @Override
    public boolean isLoginToYourAccountMessageVisible() {
        return loginToYourAccountMessage.isVisible();
    }
}
