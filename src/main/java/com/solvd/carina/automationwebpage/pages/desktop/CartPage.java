package com.solvd.carina.automationwebpage.pages.desktop;

import com.solvd.carina.automationwebpage.components.product.ProductInCartComponent;
import com.solvd.carina.automationwebpage.pages.common.CartPageBase;
import com.solvd.carina.automationwebpage.pages.common.CheckoutPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = CartPageBase.class)
public class CartPage extends CartPageBase {

    @FindBy(xpath = "//tbody//tr")
    private List<ProductInCartComponent> cartProductList;

    @FindBy(xpath = "//a[text()='Proceed To Checkout']")
    private ExtendedWebElement proceedToCheckoutButton;

    @FindBy(css = "#empty_cart")
    private ExtendedWebElement emptyCartMessage;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public List<ProductInCartComponent> getAllProducts() {
        return cartProductList;
    }

    @Override
    public CheckoutPageBase clickOnCheckoutButton() {
        proceedToCheckoutButton.click();
        return initPage(driver, CheckoutPageBase.class);
    }

    @Override
    public boolean isEmptyCartMessageVisible(){
        return emptyCartMessage.isVisible();
    }

}
