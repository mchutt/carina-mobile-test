package com.solvd.carina.automationwebpage.pages.desktop;

import com.solvd.carina.automationwebpage.pages.common.AccountCreatedPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = AccountCreatedPageBase.class)
public class AccountCreatedPage extends AccountCreatedPageBase {

    @FindBy(css = "h2[data-qa='account-created']")
    private ExtendedWebElement accountCreatedMessage;

    @FindBy(css = "a[data-qa='continue-button']")
    private ExtendedWebElement continueButton;

    public AccountCreatedPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAccountCreatedMessageVisible(){
        return accountCreatedMessage.isVisible();
    }

    public void clickOnContinueButton(){
        continueButton.click();
    }

}
