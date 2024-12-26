package com.solvd.carina.automationwebpage.pages.desktop;

import com.solvd.carina.automationwebpage.pages.common.PaymentDonePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = PaymentDonePageBase.class)
public class PaymentDonePage extends PaymentDonePageBase {

    @FindBy(xpath = "//p[text()='Congratulations! Your order has been confirmed!']")
    private ExtendedWebElement confirmedOrderMessage;

    public PaymentDonePage(WebDriver driver) {
        super(driver);
    }

    public boolean isConfirmedOrderMessageDisplayed() {
        return confirmedOrderMessage.isElementPresent();
    }
}
