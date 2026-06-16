package com.educacionit.guru99.pages;

import com.educacionit.guru99.config.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private static final By USERNAME_INPUT = By.name("userName");
    private static final By PASSWORD_INPUT = By.name("password");
    private static final By SUBMIT_BUTTON = By.name("submit");
    private static final By SUCCESS_MESSAGE = By.xpath(
            "//*[contains(text(),'Login Successfully') or contains(text(),'Thank you for Loggin')]");
    private static final By ERROR_MESSAGE = By.xpath(
            "//*[contains(text(),'Enter your userName and password')]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage open() {
        driver.get(Config.getBaseUrl().replaceAll("/$", "") + "/login.php");
        acceptCookiesIfPresent();
        return this;
    }

    public LoginPage enterUsername(String username) {
        type(USERNAME_INPUT, username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        type(PASSWORD_INPUT, password);
        return this;
    }

    public LoginPage clickSubmit() {
        click(SUBMIT_BUTTON);
        return this;
    }

    public LoginPage login(String username, String password) {
        return enterUsername(username)
                .enterPassword(password)
                .clickSubmit();
    }

    public boolean isLoginSuccessful() {
        return driver.getCurrentUrl().contains("login_sucess.php") || isDisplayed(SUCCESS_MESSAGE);
    }

    public String getSuccessMessage() {
        return getText(SUCCESS_MESSAGE);
    }

    public boolean isLoginErrorDisplayed() {
        return isDisplayed(ERROR_MESSAGE);
    }
}
