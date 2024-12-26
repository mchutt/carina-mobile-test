package com.solvd.carina.automationwebpage.pages.android;

import com.solvd.carina.automationwebpage.pages.common.PaymentDonePageBase;
import com.solvd.carina.automationwebpage.pages.common.PaymentPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = PaymentDonePageBase.class)
public class PaymentDonePage extends PaymentDonePageBase {

    public PaymentDonePage(WebDriver driver) {
        super(driver);
    }

}
