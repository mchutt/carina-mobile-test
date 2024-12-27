package com.solvd.carina.automationwebpage.pages.android;

import com.solvd.carina.automationwebpage.pages.common.PaymentDonePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = PaymentDonePageBase.class)
public class PaymentDonePage extends PaymentDonePageBase {

    @FindBy(xpath = "//p[text()='Congratulations! Your order has been confirmed!']")
    private ExtendedWebElement confirmedOrderMessage;

    @FindBy(xpath = "//a[text()='Download Invoice']")
    private ExtendedWebElement downloadInvoceButton;

    public PaymentDonePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isConfirmedOrderMessageDisplayed()  {
        return confirmedOrderMessage.isElementPresent();
    }

    @Override
    public void clickOnDownloadInvoice() {
        downloadInvoceButton.click();
    }

}
