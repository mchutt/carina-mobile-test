package com.solvd.carina.automationwebpage.pages.common;

import com.solvd.carina.automationwebpage.components.product.ProductInCartComponent;
import com.solvd.carina.automationwebpage.pages.desktop.CheckoutPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public abstract class CartPageBase extends AbstractPage {

    @FindBy(xpath = "//tbody//tr")
    private List<ProductInCartComponent> cartProductList;

    @FindBy(xpath = "//a[text()='Proceed To Checkout']")
    private ExtendedWebElement proceedToCheckoutButton;

    @FindBy(css = "#empty_cart")
    private ExtendedWebElement emptyCartMessage;

    public CartPageBase(WebDriver driver) {
        super(driver);
    }

    public List<ProductInCartComponent> getAllProducts() {
        return cartProductList;
    }

    public CheckoutPageBase clickOnCheckoutButton() {
        proceedToCheckoutButton.click();
        return initPage(driver, CheckoutPageBase.class);
    }

    public boolean isEmptyCartMessageVisible(){
        return emptyCartMessage.isVisible();
    }

}
