package com.solvd.carina.automationwebpage.pages.android;

import com.solvd.carina.automationwebpage.pages.common.AccountCreatedPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = AccountCreatedPageBase.class)
public class AccountCreatedPage extends AccountCreatedPageBase {

    public AccountCreatedPage(WebDriver driver) {
        super(driver);
    }

}
