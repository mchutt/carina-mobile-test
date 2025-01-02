package com.solvd.carina.automationwebpage.pages.ios;

import com.solvd.carina.automationwebpage.components.common.SignUpFormComponent;
import com.solvd.carina.automationwebpage.components.common.LoginFormBase;
import com.solvd.carina.automationwebpage.components.common.MobileLoginFormComponent;
import com.solvd.carina.automationwebpage.pages.common.LoginPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {

    @FindBy(css = ".signup-form")
    private SignUpFormComponent signUpForm;

    @FindBy(css = ".login-form")
    private MobileLoginFormComponent loginForm;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public SignUpFormComponent getSignUpForm() {
        return signUpForm;
    }

    @Override
    public LoginFormBase getLoginForm() {
        return loginForm;
    }
}
