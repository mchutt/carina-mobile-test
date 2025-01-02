package com.solvd.carina.automationwebpage.components.android;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
// android native modal
public class AndroidChangePasswordAlert extends AbstractUIObject implements IMobileUtils {

    @FindBy(id = "com.android.chrome:id/positive_button")
    private ExtendedWebElement okButton;

    public AndroidChangePasswordAlert(WebDriver driver) {
        super(driver);
    }

    public void clickOnOkButton(){
        tap(okButton);
    }

}
