package com.solvd.carina.automationwebpage.components.ios;

import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.annotations.Predicate;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class IOSDownloadInvoicePopup extends AbstractUIObject implements IMobileUtils {

    @FindBy(xpath = "name == 'Download' AND label == 'Download' AND value == 'Download'")
    @Predicate
    private ExtendedWebElement downloadButton;

    public IOSDownloadInvoicePopup(WebDriver driver) {
        super(driver);
    }

    public void clickOnDownLoadButton(){
        tap(downloadButton);
    }

}
