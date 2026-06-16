package com.educacionit.guru99.pages;

import com.educacionit.guru99.config.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {

    private static final By FIRST_NAME_INPUT = By.name("firstName");
    private static final By LAST_NAME_INPUT = By.name("lastName");
    private static final By PHONE_INPUT = By.name("phone");
    private static final By EMAIL_INPUT = By.name("email");
    private static final By ADDRESS_INPUT = By.name("address1");
    private static final By CITY_INPUT = By.name("city");
    private static final By STATE_INPUT = By.name("state");
    private static final By POSTAL_CODE_INPUT = By.name("postalCode");
    private static final By COUNTRY_SELECT = By.name("country");
    private static final By USERNAME_INPUT = By.name("userName");
    private static final By PASSWORD_INPUT = By.name("password");
    private static final By CONFIRM_PASSWORD_INPUT = By.name("confirmPassword");
    private static final By SUBMIT_BUTTON = By.cssSelector("input[name='submit']");
    private static final By SIGN_IN_LINK = By.partialLinkText("sign-in");
    private static final By SUCCESS_MESSAGE = By.xpath(
            "//*[contains(text(),'Thank you for registering')]");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public RegisterPage open() {
        driver.get(Config.getRegisterUrl());
        acceptCookiesIfPresent();
        return this;
    }

    public RegisterPage fillContactInformation(String firstName, String lastName,
                                               String phone, String email) {
        type(FIRST_NAME_INPUT, firstName);
        type(LAST_NAME_INPUT, lastName);
        type(PHONE_INPUT, phone);
        type(EMAIL_INPUT, email);
        return this;
    }

    public RegisterPage fillMailingInformation(String address, String city,
                                               String state, String postalCode,
                                               String country) {
        type(ADDRESS_INPUT, address);
        type(CITY_INPUT, city);
        type(STATE_INPUT, state);
        type(POSTAL_CODE_INPUT, postalCode);
        selectByVisibleText(COUNTRY_SELECT, country);
        return this;
    }

    public RegisterPage fillUserInformation(String username, String password,
                                            String confirmPassword) {
        type(USERNAME_INPUT, username);
        type(PASSWORD_INPUT, password);
        type(CONFIRM_PASSWORD_INPUT, confirmPassword);
        return this;
    }

    public RegisterPage submitRegistration() {
        click(SUBMIT_BUTTON);
        return this;
    }

    public LoginPage goToSignIn() {
        click(SIGN_IN_LINK);
        return new LoginPage(driver);
    }

    public boolean isRegistrationSuccessful() {
        return isDisplayed(SUCCESS_MESSAGE);
    }

    public String getSuccessMessage() {
        return getText(SUCCESS_MESSAGE);
    }
}
