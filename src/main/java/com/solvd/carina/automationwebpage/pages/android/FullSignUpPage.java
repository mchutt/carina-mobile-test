package com.solvd.carina.automationwebpage.pages.android;

import com.solvd.carina.automationwebpage.pages.common.FullSignUpPageBase;
import com.solvd.carina.automationwebpage.pages.desktop.AccountCreatedPage;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = FullSignUpPageBase.class)
public class FullSignUpPage extends FullSignUpPageBase {

    public FullSignUpPage(WebDriver driver) {
        super(driver);
    }

}
