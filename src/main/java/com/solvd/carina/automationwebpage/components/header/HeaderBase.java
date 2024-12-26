package com.solvd.carina.automationwebpage.components.header;


import com.solvd.carina.automationwebpage.constants.LinkNames;
import com.solvd.carina.automationwebpage.pages.common.AccountDeletedPageBase;
import com.solvd.carina.automationwebpage.pages.common.LoginPageBase;
import com.solvd.carina.automationwebpage.pages.common.ProductsPageBase;
import com.solvd.carina.automationwebpage.pages.desktop.AccountDeletedPage;
import com.solvd.carina.automationwebpage.pages.desktop.HomePage;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Objects;

public abstract class HeaderBase extends AbstractUIObject implements ICustomTypePageFactory {

    @FindBy(xpath = ".//li/a")
    private List<ExtendedWebElement> linkList;

    @FindBy(xpath = ".//li/a[text()=' Logged in as ']")
    private ExtendedWebElement loggedMessage;

    public HeaderBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    private void clickOnLink(LinkNames linkName) {
        linkList.stream()
                .filter(link -> Objects.equals(
                        link.getAttribute("href"),
                        linkName.getHref()))
                .findFirst().orElseThrow().click();
    }

    public abstract ProductsPageBase openProductsPage();

    public HomePage openHomePage() {
        clickOnLink(LinkNames.HOME);
        return new HomePage(driver);
    }

    public abstract LoginPageBase openLoginPage();

    public abstract AccountDeletedPageBase deleteAccount();

    public boolean isLoggedMessagePresent() {
        return loggedMessage.isElementPresent();
    }

}
