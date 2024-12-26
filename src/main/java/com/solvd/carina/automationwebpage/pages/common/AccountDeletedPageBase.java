package com.solvd.carina.automationwebpage.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class AccountDeletedPageBase extends AbstractPage {

    @FindBy(css = "a[data-qa='continue-button']")
    private ExtendedWebElement continueButton;

    public AccountDeletedPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isAccountDeletedMessageVisible();

    public void clickOnContinueButton() {
        continueButton.click();
    }
}
