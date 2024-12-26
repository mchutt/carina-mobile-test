package com.solvd.carina.automationwebpage.components.header;


import com.solvd.carina.automationwebpage.pages.common.AccountDeletedPageBase;
import com.solvd.carina.automationwebpage.pages.common.HomePageBase;
import com.solvd.carina.automationwebpage.pages.common.LoginPageBase;
import com.solvd.carina.automationwebpage.pages.common.ProductsPageBase;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class HeaderBase extends AbstractUIObject implements ICustomTypePageFactory {

    @FindBy(xpath = ".//li/a[text()=' Logged in as ']")
    private ExtendedWebElement loggedMessage;

    public HeaderBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract ProductsPageBase openProductsPage();

    public abstract HomePageBase openHomePage();

    public abstract LoginPageBase openLoginPage();

    public abstract AccountDeletedPageBase deleteAccount();

    public boolean isLoggedMessagePresent() {
        return loggedMessage.isElementPresent();
    }

}
