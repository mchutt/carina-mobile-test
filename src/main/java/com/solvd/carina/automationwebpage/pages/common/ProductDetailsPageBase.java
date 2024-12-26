package com.solvd.carina.automationwebpage.pages.common;

import com.solvd.carina.automationwebpage.components.alert.ProductDetailsAlertComponent;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class ProductDetailsPageBase extends AbstractPage {


    @FindBy(xpath = "//button[@type='button']")
    private ExtendedWebElement addToCartButton;

    @FindBy(className = "modal-content")
    private ProductDetailsAlertComponent modal;

    public ProductDetailsPageBase(WebDriver driver) {
        super(driver);
    }

    public ProductDetailsAlertComponent clickOnAddToCartButton() {
        addToCartButton.click();
        return modal;
    }

}
