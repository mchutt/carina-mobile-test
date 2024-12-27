package com.solvd.carina.automationwebpage.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class AccountCreatedPageBase extends AbstractPage {

    public AccountCreatedPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isAccountCreatedMessageVisible();

    public abstract void clickOnContinueButton();

}
