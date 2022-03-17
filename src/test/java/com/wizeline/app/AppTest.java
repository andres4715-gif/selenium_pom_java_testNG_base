package com.wizeline.app;

import com.pages.*;
import com.resources.JsonFileTest;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class AppTest {

    private static WebDriver driver = null;

    @BeforeSuite
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterSuite
    public void finish() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test(priority = 1, enabled = true, description = "This is for wizeland testint test")
    public void shouldAnswerWithTrue() {
        ArrayList<String> newTb;

        JsonFileTest jsonfile = new JsonFileTest();
        HomePage homepage = new HomePage(driver);
        LoginPage loginpage = new LoginPage(driver);
        SecureAreaPage secureareapage = new SecureAreaPage(driver);
        DropDown dropdown = new DropDown(driver);
        OpeningNewWindowsPage openingnewwindowspage = new OpeningNewWindowsPage(driver);

        driver.get(jsonfile.checkResource("url"));

        homepage.clickAuthenticationFormOption();
        loginpage.addUserName(jsonfile.checkResource("username"));
        loginpage.addPassword(jsonfile.checkResource("password"));
        loginpage.clickLoginButton();
        Assert.assertTrue(secureareapage.checkIfTheUserIsLoggedOut());
        secureareapage.clickOnLogOutButton();
        Assert.assertTrue(loginpage.checkLabelLoginPage());
        driver.navigate().to("https://the-internet.herokuapp.com/");
        Assert.assertTrue(homepage.checkMultipleWindows());
        homepage.clickDropDown();
        dropdown.chooseAnOptionDropDown();
        driver.navigate().to("https://the-internet.herokuapp.com/");
        homepage.clickMultipleWindows();
        Assert.assertTrue(openingnewwindowspage.checkOpeningNewWindowsLabe());
        openingnewwindowspage.clickHereAction();
        newTb = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(newTb.get(1));
        Assert.assertEquals(openingnewwindowspage.getNewWindowsText(), "New Window");
    }
}
