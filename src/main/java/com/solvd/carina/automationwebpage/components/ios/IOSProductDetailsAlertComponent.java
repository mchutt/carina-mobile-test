package com.solvd.carina.automationwebpage.components.ios;

import com.solvd.carina.automationwebpage.components.common.ProductDetailsAlertComponentBase;
import com.solvd.carina.automationwebpage.pages.common.CartPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class IOSProductDetailsAlertComponent extends ProductDetailsAlertComponentBase {

    @FindBy(xpath = ".//u[text()='View Cart']")
    private ExtendedWebElement viewCartButton;

    public IOSProductDetailsAlertComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public CartPageBase openCartPage() {
        viewCartButton.isClickable();
        viewCartButton.scrollTo();
        viewCartButton.click();
        return initPage(driver, CartPageBase.class);
    }
}
