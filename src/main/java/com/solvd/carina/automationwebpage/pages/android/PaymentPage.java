package com.solvd.carina.automationwebpage.pages.android;

import com.solvd.carina.automationwebpage.pages.common.PaymentPageBase;
import com.solvd.carina.automationwebpage.pages.desktop.PaymentDonePage;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = PaymentPageBase.class)
public class PaymentPage extends PaymentPageBase {

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

}
