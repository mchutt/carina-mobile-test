package com.solvd.carina.automationwebpage;

import com.solvd.carina.automationwebpage.components.common.SignUpFormComponent;
import com.solvd.carina.automationwebpage.components.android.AndroidChangePasswordAlert;
import com.solvd.carina.automationwebpage.components.android.AndroidDownloadInvoicePopup;
import com.solvd.carina.automationwebpage.components.ios.IOSDownloadInvoicePopup;
import com.solvd.carina.automationwebpage.components.ios.IOSSavePasswordAlert;
import com.solvd.carina.automationwebpage.components.common.LoginFormBase;
import com.solvd.carina.automationwebpage.components.common.ProductCardComponent;
import com.solvd.carina.automationwebpage.components.common.ProductInCartComponent;
import com.solvd.carina.automationwebpage.pages.common.*;
import com.solvd.carina.demo.utils.MobileContextUtils;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.webdriver.device.Device;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static com.solvd.carina.automationwebpage.constants.UserConstants.*;


public class WebTest extends AbstractTest {

    @Test
    @MethodOwner(owner = "mchutt")
    public void searchAProductTest() {
        HomePageBase homePage = openHomePage();

        ProductsPageBase productsPage = homePage.getHeader().openProductsPage();
        Assert.assertTrue(productsPage.isAllProductsTitleDisplayed(), "The 'All Products' title is not displayed on the Products page.");

        String searchQ = "top";
        productsPage.typeTextInSearchInput(searchQ);
        productsPage.clickOnSubmitSearchButton();
        Assert.assertTrue(productsPage.isSearchedProductsTitleDisplayed(), "The 'Searched Products' title is not displayed on the Products page.");


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
        HomePageBase homePage = openHomePage();

        SignUpFormComponent form = homePage.getHeader().openLoginPage().getSignUpForm();
        Assert.assertTrue(form.isNewUserSignupMessageVisible(), "The 'New user signup' message is not Visible! ");
        form.signUp("Name", USER_EMAIL);

        Assert.assertTrue(form.isErrorMessageVisible(), "The error 'Email Address already exist!' message is not visible. ");
    }

    @Test
    @MethodOwner(owner = "mchutt")
    public void loginWithAnIncorrectEmailAndPasswordTest() {
        HomePageBase homePage = openHomePage();

        //Login
        LoginFormBase loginForm = login(homePage, "pepe@pepe.com", "sdfasfdsfdsadfsdf");
        Assert.assertTrue(loginForm.isErrorMessageVisible(), "The error message for incorrect login credentials is not displayed. ");
    }

    @Test
    @MethodOwner(owner = "mchutt")
    public void addProductToTheCartTest() {
        HomePageBase homePage = openHomePage();

        CartPageBase cartPage = addAProductToTheCart(homePage);

        //Remove products form cart
        cartPage.getAllProducts().forEach(ProductInCartComponent::clickOnDeleteProductButton);
        Assert.assertTrue(cartPage.isEmptyCartMessageVisible(), "The cart is NOT empty. ");
    }

    @Test
    @MethodOwner(owner = "mchutt")
    public void checkoutTest() {
        HomePageBase homePage = openHomePage();

        //Login
        login(homePage, USER_EMAIL, USER_PASSWORD);
        Assert.assertTrue(homePage.getHeader().isLoggedMessagePresent(), "The 'logged in user' message is not displayed after login. ");

        Device device = getDevice(getDriver());
        closeNativeModal(device);

        //Add product to cart and open cart page
        CartPageBase cartPage = addAProductToTheCart(homePage);

        CheckoutPageBase checkoutPage = cartPage.clickOnCheckoutButton();

        PaymentDonePageBase paymentDonePage = checkoutPage.clickOnPlaceOrderButton()
                .typeInNameOnCardInput(USER_CARD_NAME)
                .typeInCardNumberInput(USER_CARD_NUMBER)
                .typeInCVCInput(USER_CARD_CVC)
                .typeInExpirationMonthInput(USER_CARD_MONTH)
                .typeInExpirationYearInput(USER_CARD_YEAR)
                .clickOnConfirmOrderButton();

        Assert.assertTrue(paymentDonePage.isConfirmedOrderMessageDisplayed(), "The order confirmation message is not displayed. ");
        paymentDonePage.clickOnDownloadInvoice();

        closeNativePopup(device);
    }


    @Test
    @MethodOwner(owner = "mchutt")
    public void createAccountAndRemoveAccountTest() {
        HomePageBase homePage = openHomePage();

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

        Assert.assertTrue(accountCreatedPage.isAccountCreatedMessageVisible(), "The message 'Account Created!' is not visible!");

        Device device = getDevice(getDriver());
        closeNativeModal(device);

        accountCreatedPage.clickOnContinueButton();

        AccountDeletedPageBase accountDeletedPage = homePage.getHeader().deleteAccount();
        Assert.assertTrue(accountDeletedPage.isAccountDeletedMessageVisible(), "The message 'Account Deleted!' is not visible");
        accountDeletedPage.clickOnContinueButton();

        Assert.assertFalse(homePage.getHeader().isLoggedMessagePresent(), "The logged message should not be present");

    }


    private HomePageBase openHomePage() {
        HomePageBase homePage = initPage(getDriver(), HomePageBase.class);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");
        return homePage;
    }

    private LoginFormBase login(HomePageBase homePage, String email, String pass) {
        LoginFormBase loginForm = homePage.getHeader().openLoginPage().getLoginForm();
        Assert.assertTrue(loginForm.isLoginToYourAccountMessageVisible(),
                "Login to your account message is not visible");
        loginForm.login(email, pass);
        return loginForm;
    }


    private static CartPageBase addAProductToTheCart(HomePageBase homePage) {
        ProductsPageBase productsPage = homePage.getHeader().openProductsPage();
        ProductDetailsPageBase productDetailsPage = productsPage.getProducts().get(0).openProductDetails();
        CartPageBase cartPage = productDetailsPage.clickOnAddToCartButton().openCartPage();
        Assert.assertFalse(cartPage.getAllProducts().isEmpty(), "The cart is empty. ");
        return cartPage;
    }

    private void closeNativeModal(Device device) {
        String deviceType = device.getType();
        if (StringUtils.isNoneEmpty(deviceType) && deviceType.equals("phone")) {
            if (StringUtils.equalsIgnoreCase(device.getCapabilities().getPlatformName().toString(), "android")) {
                closeAndroidNativeModal();
            }
            if (StringUtils.equalsIgnoreCase(device.getCapabilities().getPlatformName().toString(), "ios")) {
                closeIOSNativeModal();
            }
        }
    }

    private void closeNativePopup(Device device) {
        String deviceType = device.getType();
        if (StringUtils.isNoneEmpty(deviceType) && deviceType.equals("phone")) {
            if (StringUtils.equalsIgnoreCase(device.getCapabilities().getPlatformName().toString(), "android")) {
                androidDownloadInvoice();
            }
            if (StringUtils.equalsIgnoreCase(device.getCapabilities().getPlatformName().toString(), "ios")) {
                iOSDownloadInvoice();
            }
        }
    }

    private void closeAndroidNativeModal() {
        MobileContextUtils mobileContextUtils = new MobileContextUtils();
        mobileContextUtils.switchMobileContext(MobileContextUtils.View.NATIVE);

        AndroidChangePasswordAlert alert = new AndroidChangePasswordAlert(getDriver());
        alert.clickOnOkButton();

        mobileContextUtils.switchMobileContext(MobileContextUtils.View.BROWSER);
    }

    private void closeIOSNativeModal() {
        MobileContextUtils mobileContextUtils = new MobileContextUtils();
        mobileContextUtils.switchMobileContext(MobileContextUtils.View.NATIVE);

        IOSSavePasswordAlert alert = new IOSSavePasswordAlert(getDriver());
        alert.clickOnNotNowButton();

        mobileContextUtils.switchMobileContext(MobileContextUtils.View.WEB_BROWSER);
    }

    private void androidDownloadInvoice() {
        MobileContextUtils mobileContextUtils = new MobileContextUtils();
        mobileContextUtils.switchMobileContext(MobileContextUtils.View.NATIVE);

        AndroidDownloadInvoicePopup popup = new AndroidDownloadInvoicePopup(getDriver());
        popup.clickOnShowAgainCheckBox();
        popup.clickOnDownload();

        mobileContextUtils.switchMobileContext(MobileContextUtils.View.BROWSER);
    }

    private void iOSDownloadInvoice() {
        MobileContextUtils mobileContextUtils = new MobileContextUtils();
        mobileContextUtils.switchMobileContext(MobileContextUtils.View.NATIVE);

        IOSDownloadInvoicePopup popup = new IOSDownloadInvoicePopup(getDriver());
        popup.clickOnDownLoadButton();

        mobileContextUtils.switchMobileContext(MobileContextUtils.View.WEB_BROWSER);
    }
}
