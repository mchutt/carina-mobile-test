package com.solvd.carina.automationwebpage.pages.desktop;

import com.solvd.carina.automationwebpage.components.alert.ProductDetailsAlertComponent;
import com.solvd.carina.automationwebpage.pages.common.ProductDetailsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = ProductDetailsPageBase.class)
public class ProductDetailsPage extends ProductDetailsPageBase {

    @FindBy(xpath = "//button[@type='button']")
    private ExtendedWebElement addToCartButton;

    @FindBy(className = "modal-content")
    private ProductDetailsAlertComponent modal;

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ProductDetailsAlertComponent clickOnAddToCartButton() {
        addToCartButton.click();
        return modal;
    }

}
