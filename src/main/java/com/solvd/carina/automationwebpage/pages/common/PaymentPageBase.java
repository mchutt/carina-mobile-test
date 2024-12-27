package com.solvd.carina.automationwebpage.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class PaymentPageBase extends AbstractPage {


    public PaymentPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract PaymentPageBase typeInNameOnCardInput(String text);

    public abstract PaymentPageBase typeInCardNumberInput(String text);

    public abstract PaymentPageBase typeInCVCInput(String text);

    public abstract PaymentPageBase typeInExpirationMonthInput(String text);

    public abstract PaymentPageBase typeInExpirationYearInput(String text);

    public abstract PaymentDonePageBase clickOnConfirmOrderButton();

}
