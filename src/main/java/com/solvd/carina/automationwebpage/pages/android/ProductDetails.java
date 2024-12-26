package com.solvd.carina.automationwebpage.pages.android;

import com.solvd.carina.automationwebpage.pages.common.ProductDetailsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = ProductDetailsPageBase.class)
public class ProductDetails extends ProductDetailsPageBase {
    public ProductDetails(WebDriver driver) {
        super(driver);
    }
}
