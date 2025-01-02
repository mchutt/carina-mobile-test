package com.solvd.carina.automationwebpage.pages.common;

import com.solvd.carina.automationwebpage.components.common.ProductInCartComponent;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class CartPageBase extends AbstractPage {

    public CartPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract List<ProductInCartComponent> getAllProducts();

    public abstract CheckoutPageBase clickOnCheckoutButton();

    public abstract boolean isEmptyCartMessageVisible();

}
