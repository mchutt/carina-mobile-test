package com.solvd.carina.automationwebpage.pages.ios;

import com.solvd.carina.automationwebpage.pages.common.AccountCreatedPageBase;
import com.solvd.carina.automationwebpage.pages.common.FullSignUpPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = FullSignUpPageBase.class)
public class FullSignUpPage extends FullSignUpPageBase {

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

    public FullSignUpPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public FullSignUpPageBase typePassword(String pass) {
        passwordInput.type(pass);
        return this;
    }

    @Override
    public FullSignUpPageBase typeFirstName(String firstName) {
        firstNameInput.isElementPresent();
        firstNameInput.type(firstName);
        return this;
    }

    @Override
    public FullSignUpPageBase typeLastName(String lastName) {
        lastNameInput.type(lastName);
        return this;
    }

    @Override
    public FullSignUpPageBase typeAddress(String address) {
        addressOneInput.type(address);
        return this;
    }

    @Override
    public FullSignUpPageBase selectCountry(String country) {
        countrySelect.scrollTo();
        countrySelect.select(country);
        return this;
    }

    @Override
    public FullSignUpPageBase typeState(String state) {
        stateInput.type(state);
        return this;
    }

    @Override
    public FullSignUpPageBase typeCity(String city) {
        cityInput.type(city);
        return this;
    }

    @Override
    public FullSignUpPageBase typeZipCode(String zipCode) {
        zipcodeInput.type(zipCode);
        return this;
    }

    @Override
    public FullSignUpPageBase typeMobilePhone(String mobileNumber) {
        mobileNumberInput.type(mobileNumber);
        return this;
    }

    @Override
    public AccountCreatedPageBase clickOnSubmitButton() {
        submitButton.scrollTo();
        submitButton.click();
        return initPage(driver, AccountCreatedPageBase.class);
    }

}
