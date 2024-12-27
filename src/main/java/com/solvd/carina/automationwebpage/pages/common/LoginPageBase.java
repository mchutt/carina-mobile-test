package com.solvd.carina.automationwebpage.pages.common;

import com.solvd.carina.automationwebpage.components.SignUpFormComponent;
import com.solvd.carina.automationwebpage.components.login.LoginFormBase;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class LoginPageBase extends AbstractPage {


    public LoginPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract SignUpFormComponent getSignUpForm();

    public abstract LoginFormBase getLoginForm();

}
