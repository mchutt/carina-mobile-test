package com.solvd.carina.automationwebpage.pages.common;

import com.solvd.carina.automationwebpage.components.common.HeaderBase;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class HomePageBase extends AbstractPage {

    public HomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract HeaderBase getHeader();
}
