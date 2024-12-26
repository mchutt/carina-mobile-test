package com.solvd.carina.automationwebpage.pages.desktop;

import com.solvd.carina.automationwebpage.components.SignUpFormComponent;
import com.solvd.carina.automationwebpage.components.login.LoginFormComponent;
import com.solvd.carina.automationwebpage.pages.common.LoginPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {

    @FindBy(css = ".signup-form")
    private SignUpFormComponent signUpForm;

    @FindBy(css = ".login-form")
    private LoginFormComponent loginForm;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public SignUpFormComponent getSignUpForm() {
        return signUpForm;
    }

    public LoginFormComponent getLoginForm() {
        return loginForm;
    }
}
