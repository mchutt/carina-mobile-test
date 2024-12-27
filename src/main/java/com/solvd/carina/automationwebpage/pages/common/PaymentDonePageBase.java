package com.solvd.carina.automationwebpage.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class PaymentDonePageBase extends AbstractPage {

    public PaymentDonePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isConfirmedOrderMessageDisplayed();
    public abstract void clickOnDownloadInvoice();
}
