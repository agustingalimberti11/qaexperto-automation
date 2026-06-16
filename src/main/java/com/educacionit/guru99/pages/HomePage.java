package com.educacionit.guru99.pages;

import com.educacionit.guru99.config.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private static final By USERNAME_INPUT = By.name("userName");
    private static final By PASSWORD_INPUT = By.name("password");
    private static final By LOGIN_BUTTON = By.name("submit");
    private static final By REGISTER_LINK = By.linkText("Register here");
    private static final By LOGIN_SUCCESS_MESSAGE = By.xpath(
            "//*[contains(text(),'Thank you for logging in')]");
    private static final By LOGIN_ERROR_MESSAGE = By.xpath(
            "//*[contains(text(),'Enter your userName and password')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage open() {
        driver.get(Config.getBaseUrl());
        acceptCookiesIfPresent();
        return this;
    }

    public HomePage enterUsername(String username) {
        type(USERNAME_INPUT, username);
        return this;
    }

    public HomePage enterPassword(String password) {
        type(PASSWORD_INPUT, password);
        return this;
    }

    public HomePage clickLogin() {
        click(LOGIN_BUTTON);
        return this;
    }

    public HomePage login(String username, String password) {
        return enterUsername(username)
                .enterPassword(password)
                .clickLogin();
    }

    public RegisterPage goToRegister() {
        click(REGISTER_LINK);
        return new RegisterPage(driver);
    }

    public boolean isLoginSuccessful() {
        return isDisplayed(LOGIN_SUCCESS_MESSAGE);
    }

    public String getLoginSuccessMessage() {
        return getText(LOGIN_SUCCESS_MESSAGE);
    }

    public boolean isLoginErrorDisplayed() {
        return isDisplayed(LOGIN_ERROR_MESSAGE);
    }

    public String getLoginErrorMessage() {
        return getText(LOGIN_ERROR_MESSAGE);
    }
}
