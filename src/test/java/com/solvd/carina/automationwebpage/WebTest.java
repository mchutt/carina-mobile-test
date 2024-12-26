package com.solvd.carina.automationwebpage;

import com.solvd.carina.automationwebpage.components.SignUpFormComponent;
import com.solvd.carina.automationwebpage.components.alert.AndroidChangePasswordAlert;
import com.solvd.carina.automationwebpage.components.login.LoginFormBase;
import com.solvd.carina.automationwebpage.components.product.ProductCardComponent;
import com.solvd.carina.automationwebpage.components.product.ProductInCartComponent;
import com.solvd.carina.automationwebpage.pages.common.*;
import com.solvd.carina.demo.utils.MobileContextUtils;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static com.solvd.carina.automationwebpage.constants.UserConstants.*;


public class WebTest extends AbstractTest {


    @Test
    @MethodOwner(owner = "mchutt")
    public void searchAProductTest() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");


        ProductsPageBase productsPage = homePage.getHeader().openProductsPage();
        boolean isTitleDisplayed = productsPage.isAllProductsTitleDisplayed();
        Assert.assertTrue(isTitleDisplayed, "The 'All Products' title is not displayed on the Products page.");


        String searchQ = "top";
        productsPage.typeTextInSearchInput(searchQ);
        productsPage.clickOnSubmitSearchButton();
        boolean searchedProductsTitleDisplayed = productsPage.isSearchedProductsTitleDisplayed();
        Assert.assertTrue(searchedProductsTitleDisplayed, "The 'Searched Products' title is not displayed on the Products page.");


        List<ProductCardComponent> products = productsPage.getProducts();
        int productNameContainsSearchedTextCount = 0;
        for (ProductCardComponent product : products) {
            if (StringUtils.containsIgnoreCase(product.getProductName(), searchQ)) {
                productNameContainsSearchedTextCount++;
            } else productNameContainsSearchedTextCount--;
        }
        Assert.assertTrue(productNameContainsSearchedTextCount > 0, "The product list do not contain any products which name matches with the searched text: " + searchQ);
    }

    @Test
    @MethodOwner(owner = "mchutt")
    public void registerUserWithAnExistingEmailTest() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");


        SignUpFormComponent form = homePage.getHeader().openLoginPage().getSignUpForm();
        boolean newUserSignupMessageVisible = form.isNewUserSignupMessageVisible();
        Assert.assertTrue(newUserSignupMessageVisible, "The 'New user signup' message is not Visible! ");
        form.signUp("Pepe", "pepe@pepe.com");

        boolean isErrorMessageVisible = form.isErrorMessageVisible();
        Assert.assertTrue(isErrorMessageVisible, "The error 'Email Address already exist!' message is not visible. ");
    }

    @Test
    @MethodOwner(owner = "mchutt")
    public void loginWithAnIncorrectEmailAndPasswordTest() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
            homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");


        LoginFormBase loginForm = homePage.getHeader().openLoginPage().getLoginForm();
        boolean loginToYourAccountMessageVisible = loginForm.isLoginToYourAccountMessageVisible();
        Assert.assertTrue(loginToYourAccountMessageVisible, "The 'Login to your account' message is not visible! ");
        loginForm.login("pepe@pepe.com", "Incorrect Pass");

        boolean isErrorMessageVisible = loginForm.isErrorMessageVisible();
        Assert.assertTrue(isErrorMessageVisible, "The error message for incorrect login credentials is not displayed. ");
    }

    @Test
    @MethodOwner(owner = "mchutt")
    public void addProductToTheCartTest() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");


        ProductsPageBase productsPage = homePage.getHeader().openProductsPage();
        ProductCardComponent productCardComponent = productsPage.getProducts().get(0);
        ProductDetailsPageBase productDetailsPage = productCardComponent.openProductDetails();

        CartPageBase cartPage = productDetailsPage.clickOnAddToCartButton().openCartPage();


        Assert.assertFalse(cartPage.getAllProducts().isEmpty(), "The cart is empty. ");

        cartPage.getAllProducts()
                .forEach(ProductInCartComponent::clickOnDeleteProductButton);
        Assert.assertTrue(cartPage.isEmptyCartMessageVisible(), "The cart is NOT empty. ");
    }

    @Test
    @MethodOwner(owner = "mchutt")
    public void checkoutTest() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");


        //Login
        LoginFormBase loginForm = homePage.getHeader().openLoginPage().getLoginForm();
        loginForm.login(USER_EMAIL, USER_PASSWORD);

        // TODO: Close chrome-native modal
        MobileContextUtils mobileContextUtils = new MobileContextUtils();
        mobileContextUtils.switchMobileContext(MobileContextUtils.View.NATIVE);
        AndroidChangePasswordAlert alert = new AndroidChangePasswordAlert(getDriver());
        alert.clickOnOkButton();
        mobileContextUtils.switchMobileContext(MobileContextUtils.View.BROWSER);

        boolean isloggedMessageDisplayed = homePage.getHeader().isLoggedMessagePresent();
        Assert.assertTrue(isloggedMessageDisplayed, "The 'logged in user' message is not displayed after login. ");

        //Add product to cart
        ProductsPageBase productsPage = homePage.getHeader().openProductsPage();
        ProductCardComponent productCardComponent = productsPage.getProducts().get(0);
        ProductDetailsPageBase productDetailsPage = productCardComponent.openProductDetails();
        CartPageBase cartPage = productDetailsPage.clickOnAddToCartButton().openCartPage();

        Assert.assertFalse(cartPage.getAllProducts().isEmpty(), "The cart is empty after adding a product. ");

        CheckoutPageBase checkoutPage = cartPage.clickOnCheckoutButton();

        PaymentDonePageBase paymentDonePage = checkoutPage.clickOnPlaceOrderButton()
                .typeInNameOnCardInput(USER_CARD_NAME)
                .typeInCardNumberInput(USER_CARD_NUMBER)
                .typeInCVCInput(USER_CARD_CVC)
                .typeInExpirationMonthInput(USER_CARD_MONTH)
                .typeInExpirationYearInput(USER_CARD_YEAR)
                .clickOnConfirmOrderButton();



        boolean confirmedOrder = paymentDonePage.isConfirmedOrderMessageDisplayed();
        Assert.assertTrue(confirmedOrder, "The order confirmation message is not displayed. ");

    }

    @Test
    @MethodOwner(owner = "mchutt")
    public void createAccountAndRemoveAccountTest() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        SignUpFormComponent form = homePage.getHeader().openLoginPage().getSignUpForm();
        form.signUp(NEW_USER_NAME, NEW_USER_EMAIL);

        AccountCreatedPageBase accountCreatedPage = form.openFullSignUpPage()
                .typeFirstName(NEW_USER_NAME)
                .typeLastName(NEW_USER_LAST_NAME)
                .typePassword(NEW_USER_PASS)
                .typeAddress(NEW_USER_ADDRESS)
                .selectCountry(NEW_USER_COUNTRY)
                .typeState(NEW_USER_STATE)
                .typeCity(NEW_USER_CITY)
                .typeZipCode(NEW_USER_ZIP_CODE)
                .typeMobilePhone(NEW_USER_MOBILE_NUMBER)
                .clickOnSubmitButton();

        // TODO: Close chrome-native modal
        MobileContextUtils mobileContextUtils = new MobileContextUtils();
        mobileContextUtils.switchMobileContext(MobileContextUtils.View.NATIVE);
        AndroidChangePasswordAlert alert = new AndroidChangePasswordAlert(getDriver());
        alert.clickOnOkButton();
        mobileContextUtils.switchMobileContext(MobileContextUtils.View.BROWSER);

        Assert.assertTrue(accountCreatedPage.isAccountCreatedMessageVisible(), "The message 'Account Created!' is not visible!");
        accountCreatedPage.clickOnContinueButton();

        AccountDeletedPageBase accountDeletedPage = homePage.getHeader().deleteAccount();
        Assert.assertTrue(accountDeletedPage.isAccountDeletedMessageVisible(), "The message 'Account Deleted!' is not visible");
        accountDeletedPage.clickOnContinueButton();

        boolean isLoggedMessagePresent = homePage.getHeader().isLoggedMessagePresent();
        Assert.assertFalse(isLoggedMessagePresent, "The logged message should not be present");

    }
}
