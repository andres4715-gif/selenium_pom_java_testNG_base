package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OpeningNewWindowsPage {

    WebDriver driver;

    By openingNewWindowsPage = By.xpath("//*[text() = 'Opening a new window']");
    By clickHere = By.xpath("//*[text() = 'Click Here']");
    By newWindowsText = By.xpath("//h3[text() = 'New Window']");

    public OpeningNewWindowsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean checkOpeningNewWindowsLabe() {
        boolean checkingOpeningMesssage = driver.findElement(openingNewWindowsPage).isDisplayed();
        return checkingOpeningMesssage;
    }

    public void clickHereAction() {
        driver.findElement(clickHere).click();
    }

    public String getNewWindowsText() {
        String gettingTextLabelNewPage = driver.findElement(newWindowsText).getText();
        return gettingTextLabelNewPage;

    }
}
