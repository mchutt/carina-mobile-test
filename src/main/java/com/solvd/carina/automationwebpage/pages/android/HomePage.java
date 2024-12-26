package com.solvd.carina.automationwebpage.pages.android;

import com.solvd.carina.automationwebpage.components.header.HeaderBase;
import com.solvd.carina.automationwebpage.components.header.MobileHeader;
import com.solvd.carina.automationwebpage.pages.common.HomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {
    @FindBy(id = "header")
    private MobileHeader header;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public HeaderBase getHeader() {
        return header;
    }
}
