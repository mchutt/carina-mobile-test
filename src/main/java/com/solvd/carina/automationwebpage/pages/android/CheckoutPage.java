package com.solvd.carina.automationwebpage.pages.android;

import com.solvd.carina.automationwebpage.pages.common.CheckoutPageBase;
import com.solvd.carina.automationwebpage.pages.common.PaymentPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CheckoutPageBase.class)
public class CheckoutPage extends CheckoutPageBase {

    @FindBy(xpath = "//a[text()='Place Order']")
    private ExtendedWebElement placeOrderButton;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public PaymentPageBase clickOnPlaceOrderButton() {
        placeOrderButton.scrollTo();
        placeOrderButton.click();
        return initPage(driver, PaymentPageBase.class);
    }
}
