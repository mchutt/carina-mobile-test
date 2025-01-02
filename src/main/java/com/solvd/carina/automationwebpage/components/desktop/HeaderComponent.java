package com.solvd.carina.automationwebpage.components.desktop;


import com.solvd.carina.automationwebpage.components.common.HeaderBase;
import com.solvd.carina.automationwebpage.constants.LinkNames;
import com.solvd.carina.automationwebpage.pages.common.AccountDeletedPageBase;
import com.solvd.carina.automationwebpage.pages.common.HomePageBase;
import com.solvd.carina.automationwebpage.pages.common.LoginPageBase;
import com.solvd.carina.automationwebpage.pages.common.ProductsPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Objects;

public class HeaderComponent extends HeaderBase {

    @FindBy(xpath = ".//li/a")
    private List<ExtendedWebElement> linkList;

    @FindBy(xpath = ".//li/a[text()=' Logged in as ']")
    private ExtendedWebElement loggedMessage;

    public HeaderComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    private void clickOnLink(LinkNames linkName) {
        linkList.stream()
                .filter(link -> Objects.equals(
                        link.getAttribute("href"),
                        linkName.getHref()))
                .findFirst().orElseThrow().click();
    }

    @Override
    public ProductsPageBase openProductsPage() {
        clickOnLink(LinkNames.PRODUCTS);
        return initPage(driver, ProductsPageBase.class);
    }

    @Override
    public HomePageBase openHomePage() {
        clickOnLink(LinkNames.HOME);
        return initPage(driver, HomePageBase.class);
    }

    @Override
    public LoginPageBase openLoginPage() {
        clickOnLink(LinkNames.LOGIN);
        return initPage(driver, LoginPageBase.class);
    }

    @Override
    public AccountDeletedPageBase deleteAccount() {
        clickOnLink(LinkNames.DELETE_ACCOUNT);
        return initPage(driver, AccountDeletedPageBase.class);
    }

    @Override
    public boolean isLoggedMessagePresent() {
        return loggedMessage.isElementPresent();
    }

}
