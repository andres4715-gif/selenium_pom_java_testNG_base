package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    protected WebDriver driver;

    By authenticationForm = By.xpath("//*[text()= 'Form Authentication']");
    By multipleWindows = By.xpath("//*[text()= 'Multiple Windows']");
    By dropDown = By.xpath("//*[text() = 'Dropdown']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAuthenticationFormOption() {
        driver.findElement(authenticationForm).click();
    }

    public boolean checkMultipleWindows() {
        boolean checkingMultipleWindows = driver.findElement(multipleWindows).isDisplayed();
        return checkingMultipleWindows;
    }

    public void clickMultipleWindows() {
        driver.findElement(multipleWindows).click();
    }

    public void clickDropDown() {
        driver.findElement(dropDown).click();
    }

}
