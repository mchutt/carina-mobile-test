package com.solvd.carina.automationwebpage.pages.desktop;

import com.solvd.carina.automationwebpage.pages.common.AccountDeletedPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = AccountDeletedPageBase.class)
public class AccountDeletedPage extends AccountDeletedPageBase {

    @FindBy(css = "h2[data-qa='account-deleted']")
    private ExtendedWebElement accountDeletedMessage;

    @FindBy(css = "a[data-qa='continue-button']")
    private ExtendedWebElement continueButton;

    public AccountDeletedPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAccountDeletedMessageVisible() {
        return accountDeletedMessage.isVisible();
    }

    public void clickOnContinueButton() {
        continueButton.click();
    }
}
