package com.solvd.carina.automationwebpage.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class AccountCreatedPageBase extends AbstractPage {

    @FindBy(css = "h2[data-qa='account-created']")
    private ExtendedWebElement accountCreatedMessage;

    @FindBy(css = "a[data-qa='continue-button']")
    private ExtendedWebElement continueButton;

    public AccountCreatedPageBase(WebDriver driver) {
        super(driver);
    }

    public boolean isAccountCreatedMessageVisible(){
        return accountCreatedMessage.isVisible();
    }

    public void clickOnContinueButton(){
        continueButton.click();
    }

}
