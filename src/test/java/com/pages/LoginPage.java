package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    protected WebDriver driver;

    By userName = By.id("username");
    By password = By.id("password");
    By btnLogin = By.cssSelector("[class='radius']");
    By loginPageLabel = By.xpath("//*[text() = 'Login Page']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addUserName(String strUserName) {
        driver.findElement(userName).sendKeys(strUserName);
    }

    public void addPassword(String strUserPassword) {
        driver.findElement(password).sendKeys(strUserPassword);
    }

    public void clickLoginButton() {
        driver.findElement(btnLogin).click();
    }

    public boolean checkLabelLoginPage() {
        boolean checkingMessageLoginPage = driver.findElement(loginPageLabel).isDisplayed();
        return checkingMessageLoginPage;
    }
}
