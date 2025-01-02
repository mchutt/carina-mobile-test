package com.solvd.carina.automationwebpage.components.android;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AndroidDownloadInvoicePopup extends AbstractUIObject {

    @FindBy(id = "com.android.chrome:id/show_again_checkbox")
    private ExtendedWebElement showAgainCheckBox;

    @FindBy(id = "com.android.chrome:id/positive_button")
    private ExtendedWebElement downloadButton;

    public AndroidDownloadInvoicePopup(WebDriver driver) {
        super(driver);
    }

    public void clickOnShowAgainCheckBox(){
        showAgainCheckBox.click();
    }

    public void clickOnDownload(){
        downloadButton.click();
    }
}
