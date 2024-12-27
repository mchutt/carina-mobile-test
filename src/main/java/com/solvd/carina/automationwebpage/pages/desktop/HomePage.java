package com.solvd.carina.automationwebpage.pages.desktop;

import com.solvd.carina.automationwebpage.components.header.HeaderBase;
import com.solvd.carina.automationwebpage.components.header.HeaderComponent;
import com.solvd.carina.automationwebpage.pages.common.HomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    @FindBy(css = "#header")
    private HeaderComponent header;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public HeaderBase getHeader() {
        return header;
    }
}
