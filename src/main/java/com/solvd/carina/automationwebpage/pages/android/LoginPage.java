package com.solvd.carina.automationwebpage.pages.android;

import com.solvd.carina.automationwebpage.components.login.LoginFormBase;
import com.solvd.carina.automationwebpage.components.login.MobileLoginFormComponent;
import com.solvd.carina.automationwebpage.pages.common.LoginPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {

    @FindBy(css = ".login-form")
    private MobileLoginFormComponent loginForm;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public LoginFormBase getLoginForm() {
        return loginForm;
    }
}
