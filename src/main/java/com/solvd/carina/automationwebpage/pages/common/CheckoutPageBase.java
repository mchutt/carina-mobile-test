package com.solvd.carina.automationwebpage.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CheckoutPageBase extends AbstractPage {


    public CheckoutPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract PaymentPageBase clickOnPlaceOrderButton();
}
