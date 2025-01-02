package com.solvd.carina.automationwebpage.pages.android;

import com.solvd.carina.automationwebpage.components.common.ProductDetailsAlertComponentBase;
import com.solvd.carina.automationwebpage.pages.common.ProductDetailsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductDetailsPageBase.class)
public class ProductDetails extends ProductDetailsPageBase {

    @FindBy(xpath = "//button[@type='button']")
    private ExtendedWebElement addToCartButton;

    @FindBy(className = "modal-content")
    private ProductDetailsAlertComponentBase alertComponent;

    public ProductDetails(WebDriver driver) {
        super(driver);
    }

    @Override
    public ProductDetailsAlertComponentBase clickOnAddToCartButton() {
        addToCartButton.isVisible();
        addToCartButton.click();
        return alertComponent;
    }
}
