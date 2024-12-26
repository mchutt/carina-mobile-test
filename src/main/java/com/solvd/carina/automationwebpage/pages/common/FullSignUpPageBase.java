package com.solvd.carina.automationwebpage.pages.common;

import com.solvd.carina.automationwebpage.pages.desktop.AccountCreatedPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public abstract class FullSignUpPageBase extends AbstractPage {


    @FindBy(css = "#password")
    private ExtendedWebElement passwordInput;

    @FindBy(css = "#first_name")
    private ExtendedWebElement firstNameInput;

    @FindBy(css = "#last_name")
    private ExtendedWebElement lastNameInput;

    @FindBy(css = "#address1")
    private ExtendedWebElement addressOneInput;

    @FindBy(css = "#country")
    private ExtendedWebElement countrySelect;

    @FindBy(css = "#state")
    private ExtendedWebElement stateInput;

    @FindBy(css = "#city")
    private ExtendedWebElement cityInput;

    @FindBy(css = "#zipcode")
    private ExtendedWebElement zipcodeInput;

    @FindBy(css = "#mobile_number")
    private ExtendedWebElement mobileNumberInput;

    @FindBy(xpath = "//button[@data-qa='create-account']")
    private ExtendedWebElement submitButton;

    public FullSignUpPageBase(WebDriver driver) {
        super(driver);
    }

    public FullSignUpPageBase typePassword(String pass) {
        passwordInput.type(pass);
        return this;
    }

    public FullSignUpPageBase typeFirstName(String firstName) {
        firstNameInput.isElementPresent();
        firstNameInput.type(firstName);
        return this;
    }

    public FullSignUpPageBase typeLastName(String lastName) {
        lastNameInput.type(lastName);
        return this;
    }

    public FullSignUpPageBase typeAddress(String address) {
        addressOneInput.type(address);
        return this;
    }

    public FullSignUpPageBase selectCountry(String country) {
        countrySelect.scrollTo();
        countrySelect.select(country);
        return this;
    }

    public FullSignUpPageBase typeState(String state) {
        stateInput.type(state);
        return this;
    }

    public FullSignUpPageBase typeCity(String city) {
        cityInput.type(city);
        return this;
    }

    public FullSignUpPageBase typeZipCode(String zipCode) {
        zipcodeInput.type(zipCode);
        return this;
    }

    public FullSignUpPageBase typeMobilePhone(String mobileNumber) {
        mobileNumberInput.type(mobileNumber);
        return this;
    }

    public AccountCreatedPageBase clickOnSubmitButton() {
        submitButton.scrollTo();
        submitButton.click();
        return initPage(driver, AccountCreatedPageBase.class);
    }
}
