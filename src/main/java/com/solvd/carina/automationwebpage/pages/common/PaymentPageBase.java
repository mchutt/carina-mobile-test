package com.solvd.carina.automationwebpage.pages.common;

import com.solvd.carina.automationwebpage.pages.desktop.PaymentDonePage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class PaymentPageBase extends AbstractPage {

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

    public PaymentPageBase(WebDriver driver) {
        super(driver);
    }

    public PaymentPageBase typeInNameOnCardInput(String text) {
        nameOnCardInput.type(text);
        return this;
    }

    public PaymentPageBase typeInCardNumberInput(String text) {
        cardNumberInput.type(text);
        return this;
    }

    public PaymentPageBase typeInCVCInput(String text) {
        cvcInput.type(text);
        return this;
    }

    public PaymentPageBase typeInExpirationMonthInput(String text) {
        expirationMonthInput.type(text);
        return this;
    }

    public PaymentPageBase typeInExpirationYearInput(String text) {
        expirationYearInput.type(text);
        return this;
    }

    public PaymentDonePageBase clickOnConfirmOrderButton() {
        confirmOrderbutton.scrollTo();
        confirmOrderbutton.click();
        return initPage(driver, PaymentDonePageBase.class);
    }

}
