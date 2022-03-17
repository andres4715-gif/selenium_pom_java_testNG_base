package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage {

    WebDriver driver;

    By secureAreaLabel = By.xpath("//*[text() = ' Secure Area']");
    By btnLogOut = By.xpath("//*[contains(text(),'Logout')]");

    public SecureAreaPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean checkIfTheUserIsLoggedOut() {
        boolean checkMessage = driver.findElement(secureAreaLabel).isDisplayed();
        return checkMessage;
    }

    public void clickOnLogOutButton() {
        driver.findElement(btnLogOut).click();
    }
}
