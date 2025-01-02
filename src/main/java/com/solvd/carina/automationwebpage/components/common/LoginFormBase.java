package com.solvd.carina.automationwebpage.components.common;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class LoginFormBase extends AbstractUIObject {
    public LoginFormBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
    public abstract boolean isLoginToYourAccountMessageVisible();
    public abstract void login(String email, String pass);
    public abstract boolean isErrorMessageVisible();
}
