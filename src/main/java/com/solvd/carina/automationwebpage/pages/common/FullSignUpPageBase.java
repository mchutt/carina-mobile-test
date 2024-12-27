package com.solvd.carina.automationwebpage.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class FullSignUpPageBase extends AbstractPage {


    public FullSignUpPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract FullSignUpPageBase typePassword(String pass);

    public abstract FullSignUpPageBase typeFirstName(String firstName);

    public abstract FullSignUpPageBase typeLastName(String lastName);

    public abstract FullSignUpPageBase typeAddress(String address);

    public abstract FullSignUpPageBase selectCountry(String country);

    public abstract FullSignUpPageBase typeState(String state);

    public abstract FullSignUpPageBase typeCity(String city);

    public abstract FullSignUpPageBase typeZipCode(String zipCode);

    public abstract FullSignUpPageBase typeMobilePhone(String mobileNumber);

    public abstract AccountCreatedPageBase clickOnSubmitButton();
}
