package com.solvd.carina.automationwebpage.pages.ios;

import com.solvd.carina.automationwebpage.components.ios.IOSProductDetailsAlertComponent;
import com.solvd.carina.automationwebpage.components.common.ProductDetailsAlertComponentBase;
import com.solvd.carina.automationwebpage.pages.common.ProductDetailsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = ProductDetailsPageBase.class)
public class ProductDetails extends ProductDetailsPageBase {

    @FindBy(xpath = "//div[@class='product-information']//button[@type='button']")
    private ExtendedWebElement addToCartButton;

    @FindBy(className = "modal-content")
    private IOSProductDetailsAlertComponent alertComponent;

    public ProductDetails(WebDriver driver) {
        super(driver);
    }

    @Override
    public ProductDetailsAlertComponentBase clickOnAddToCartButton() {
        addToCartButton.scrollTo();
        addToCartButton.click();
        return alertComponent;
    }
}
