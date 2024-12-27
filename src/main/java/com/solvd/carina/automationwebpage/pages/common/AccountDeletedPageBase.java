package com.solvd.carina.automationwebpage.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class AccountDeletedPageBase extends AbstractPage {

    public AccountDeletedPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isAccountDeletedMessageVisible();

    public abstract void clickOnContinueButton();
}
