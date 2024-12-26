package com.solvd.carina.automationwebpage.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class PaymentDonePageBase extends AbstractPage {

    @FindBy(xpath = "//p[text()='Congratulations! Your order has been confirmed!']")
    private ExtendedWebElement confirmedOrderMessage;

    public PaymentDonePageBase(WebDriver driver) {
        super(driver);
    }

    public boolean isConfirmedOrderMessageDisplayed() {
        return confirmedOrderMessage.isElementPresent();
    }
}
