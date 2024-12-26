package com.solvd.carina.automationwebpage.components.header;

import com.solvd.carina.automationwebpage.pages.common.AccountDeletedPageBase;
import com.solvd.carina.automationwebpage.pages.common.HomePageBase;
import com.solvd.carina.automationwebpage.pages.common.LoginPageBase;
import com.solvd.carina.automationwebpage.pages.common.ProductsPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class MobileHeader extends HeaderBase {
    @FindBy(xpath = "//*[@href='/delete_account']")
    private ExtendedWebElement deleteAccountLink;

    @FindBy(xpath = "//*[@href='/products']")
    private ExtendedWebElement productsLink;

    @FindBy(xpath = "//*[@href='/login']")
    private ExtendedWebElement loginLink;

    @FindBy(xpath = "//*[@href='/']")
    private ExtendedWebElement homeLink;


    public MobileHeader(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public ProductsPageBase openProductsPage() {
        productsLink.isElementPresent();
        productsLink.click();
        return initPage(driver, ProductsPageBase.class);
    }

    @Override
    public HomePageBase openHomePage() {
        homeLink.click();
        return initPage(driver, HomePageBase.class);
    }

    @Override
    public LoginPageBase openLoginPage() {
        loginLink.isElementPresent();
        loginLink.click();
        return initPage(driver, LoginPageBase.class);
    }

    @Override
    public AccountDeletedPageBase deleteAccount() {
        deleteAccountLink.isElementPresent();
        deleteAccountLink.click();
        return initPage(driver, AccountDeletedPageBase.class);
    }
}
