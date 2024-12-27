package com.solvd.carina.automationwebpage.pages.android;

import com.solvd.carina.automationwebpage.components.product.ProductCardComponent;
import com.solvd.carina.automationwebpage.pages.common.ProductsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductsPageBase.class)
public class ProductsPage extends ProductsPageBase {

    @FindBy(css = ".features_items .col-sm-4")
    private List<ProductCardComponent> productList;

    @FindBy(css = "#search_product")
    private ExtendedWebElement searchInput;

    @FindBy(css = "#submit_search")
    private ExtendedWebElement submitSearchButton;

    @FindBy(xpath = "//h2[text()='All Products']")
    private ExtendedWebElement allProductsTitle;

    @FindBy(xpath = "//h2[text()='Searched Products']")
    private ExtendedWebElement searchedProductsTitle;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void typeTextInSearchInput(String text) {
        searchInput.scrollTo();
        searchInput.type(text);
    }

    @Override
    public void clickOnSubmitSearchButton() {
        searchInput.scrollTo();
        submitSearchButton.click();
    }

    @Override
    public boolean isAllProductsTitleDisplayed() {
        searchInput.scrollTo();
        return allProductsTitle.isElementPresent();
    }

    @Override
    public boolean isSearchedProductsTitleDisplayed() {
        searchInput.scrollTo();
        return searchedProductsTitle.isElementPresent();
    }

    @Override
    public List<ProductCardComponent> getProducts() {
        searchInput.scrollTo();
        return productList;
    }

}
