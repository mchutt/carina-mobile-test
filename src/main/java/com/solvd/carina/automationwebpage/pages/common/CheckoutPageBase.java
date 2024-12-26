package com.solvd.carina.automationwebpage.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class CheckoutPageBase extends AbstractPage {

    @FindBy(xpath = "//a[text()='Place Order']")
    private ExtendedWebElement placeOrderButton;

    public CheckoutPageBase(WebDriver driver) {
        super(driver);
    }

    public PaymentPageBase clickOnPlaceOrderButton() {
        placeOrderButton.scrollTo();
        placeOrderButton.click();
        return initPage(driver, PaymentPageBase.class);
    }
}
