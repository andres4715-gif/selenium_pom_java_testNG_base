package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDown {

    WebDriver driver;

    By pleaseSelectAnOptionDropDown = By.id("dropdown");

    public DropDown(WebDriver driver) {
        this.driver = driver;
    }

    public void chooseAnOptionDropDown() {
        Select option = new Select(driver.findElement(pleaseSelectAnOptionDropDown));
        option.selectByVisibleText("Option 1");
    }
}
