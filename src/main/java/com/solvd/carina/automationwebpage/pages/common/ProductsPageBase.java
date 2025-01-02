package com.solvd.carina.automationwebpage.pages.common;

import com.solvd.carina.automationwebpage.components.common.ProductCardComponent;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class ProductsPageBase extends AbstractPage {
    public ProductsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void typeTextInSearchInput(String text);

    public abstract void clickOnSubmitSearchButton();

    public abstract boolean isAllProductsTitleDisplayed();

    public abstract boolean isSearchedProductsTitleDisplayed();

    public abstract List<ProductCardComponent> getProducts();

}
