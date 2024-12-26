package com.solvd.carina.automationwebpage.pages.desktop;

import com.solvd.carina.automationwebpage.pages.common.PaymentPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = PaymentPageBase.class)
public class PaymentPage extends PaymentPageBase {

    @FindBy(xpath = "//input[@name='name_on_card']")
    private ExtendedWebElement nameOnCardInput;

    @FindBy(xpath = "//input[@name='card_number']")
    private ExtendedWebElement cardNumberInput;

    @FindBy(xpath = "//input[@name='cvc']")
    private ExtendedWebElement cvcInput;

    @FindBy(xpath = "//input[@name='expiry_month']")
    private ExtendedWebElement expirationMonthInput;

    @FindBy(xpath = "//input[@name='expiry_year']")
    private ExtendedWebElement expirationYearInput;

    @FindBy(css = "#submit")
    private ExtendedWebElement confirmOrderbutton;

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public PaymentPage typeInNameOnCardInput(String text) {
        nameOnCardInput.type(text);
        return this;
    }

    public PaymentPage typeInCardNumberInput(String text) {
        cardNumberInput.type(text);
        return this;
    }

    public PaymentPage typeInCVCInput(String text) {
        cvcInput.type(text);
        return this;
    }

    public PaymentPage typeInExpirationMonthInput(String text) {
        expirationMonthInput.type(text);
        return this;
    }

    public PaymentPage typeInExpirationYearInput(String text) {
        expirationYearInput.type(text);
        return this;
    }

    public PaymentDonePage clickOnConfirmOrderButton() {
        confirmOrderbutton.scrollTo();
        confirmOrderbutton.click();
        return new PaymentDonePage(driver);
    }

}
