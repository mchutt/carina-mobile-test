package com.solvd.carina.automationwebpage.pages.common;

import com.solvd.carina.automationwebpage.components.common.ProductDetailsAlertComponentBase;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ProductDetailsPageBase extends AbstractPage {

    public ProductDetailsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract ProductDetailsAlertComponentBase clickOnAddToCartButton();

}
