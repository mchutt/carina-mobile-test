package com.solvd.carina.automationwebpage.pages.desktop;

import com.solvd.carina.automationwebpage.components.header.HeaderBase;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    @FindBy(css = "#header")
    private HeaderBase header;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HeaderBase getHeader() {
        return header;
    }
}
