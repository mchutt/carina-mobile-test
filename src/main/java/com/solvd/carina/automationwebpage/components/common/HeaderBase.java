package com.solvd.carina.automationwebpage.components.common;


import com.solvd.carina.automationwebpage.pages.common.AccountDeletedPageBase;
import com.solvd.carina.automationwebpage.pages.common.HomePageBase;
import com.solvd.carina.automationwebpage.pages.common.LoginPageBase;
import com.solvd.carina.automationwebpage.pages.common.ProductsPageBase;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class HeaderBase extends AbstractUIObject implements ICustomTypePageFactory {

    public HeaderBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract ProductsPageBase openProductsPage();

    public abstract HomePageBase openHomePage();

    public abstract LoginPageBase openLoginPage();

    public abstract AccountDeletedPageBase deleteAccount();

    public abstract boolean isLoggedMessagePresent();

}
