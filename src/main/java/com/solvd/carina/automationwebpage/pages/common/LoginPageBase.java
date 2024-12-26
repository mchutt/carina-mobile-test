package com.solvd.carina.automationwebpage.pages.common;

import com.solvd.carina.automationwebpage.components.SignUpFormComponent;
import com.solvd.carina.automationwebpage.components.login.LoginFormBase;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class LoginPageBase extends AbstractPage {

    @FindBy(css = ".signup-form")
    private SignUpFormComponent signUpForm;


    public LoginPageBase(WebDriver driver) {
        super(driver);
    }

    public SignUpFormComponent getSignUpForm() {
        return signUpForm;
    }

    public abstract LoginFormBase getLoginForm();

}
