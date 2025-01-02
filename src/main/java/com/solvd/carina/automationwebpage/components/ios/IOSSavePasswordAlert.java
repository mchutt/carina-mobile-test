package com.solvd.carina.automationwebpage.components.ios;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.annotations.Predicate;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class IOSSavePasswordAlert extends AbstractUIObject implements IMobileUtils {

    @FindBy(xpath = "name == 'Not Now'")
    @Predicate
    private ExtendedWebElement notNowButton;

    public IOSSavePasswordAlert(WebDriver driver) {
        super(driver);
    }

    public void clickOnNotNowButton(){
        tap(notNowButton);
    }
}
