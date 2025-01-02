package com.solvd.carina.automationwebpage.components.common;

import com.solvd.carina.automationwebpage.pages.common.CartPageBase;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsAlertComponentBase extends AbstractUIObject implements ICustomTypePageFactory {

    @FindBy(xpath = ".//u[text()='View Cart']")
    private ExtendedWebElement viewCartButton;

    public ProductDetailsAlertComponentBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public CartPageBase openCartPage() {
        viewCartButton.isElementPresent();
        viewCartButton.hover();
        viewCartButton.scrollTo();
        viewCartButton.click();
        return initPage(driver, CartPageBase.class);
    }
}
