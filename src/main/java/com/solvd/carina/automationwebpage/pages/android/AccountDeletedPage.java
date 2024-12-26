package com.solvd.carina.automationwebpage.pages.android;

import com.solvd.carina.automationwebpage.pages.common.AccountDeletedPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = AccountDeletedPageBase.class)
public class AccountDeletedPage extends AccountDeletedPageBase {

    @FindBy(css = "h2[data-qa='account-deleted']")
    private ExtendedWebElement accountDeletedMessage;

    public AccountDeletedPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAccountDeletedMessageVisible()  {
        accountDeletedMessage.scrollTo();
        return accountDeletedMessage.isVisible();
    }

}
