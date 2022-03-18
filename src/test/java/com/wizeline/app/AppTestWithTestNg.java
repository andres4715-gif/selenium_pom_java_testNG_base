package com.wizeline.app;

import com.pages.*;
import com.resources.JsonFileTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;

public class AppTestWithTestNg {

    private static WebDriver driver = null;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterTest
    public void finish() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test(priority = 1, enabled = true, description = "This is for wizeland testing test")
    public void shouldAnswerWithTrue() {
        JsonFileTest jsonfile = new JsonFileTest();
        HomePage homepage = new HomePage(driver);
        LoginPage loginpage = new LoginPage(driver);
        SecureAreaPage secureareapage = new SecureAreaPage(driver);

        driver.get(jsonfile.checkResource("url"));
        homepage.clickAuthenticationFormOption();
        loginpage.addUserName(jsonfile.checkResource("username"));
        loginpage.addPassword(jsonfile.checkResource("password"));
        loginpage.clickLoginButton();
        Assert.assertTrue(secureareapage.checkIfTheUserIsLoggedOut());
        secureareapage.clickOnLogOutButton();
        Assert.assertTrue(loginpage.checkLabelLoginPage());
    }

    @Parameters({"url"})
    @Test(priority = 2, enabled = true, description = "checking the second activity")
    public void newExecutionActivity(String myUrl) {
        DropDown dropdown = new DropDown(driver);
        HomePage homepage = new HomePage(driver);
        driver.navigate().to(myUrl);
        Assert.assertTrue(homepage.checkMultipleWindows());
        homepage.clickDropDown();
        dropdown.chooseAnOptionDropDown();
    }

    @Test(priority = 3, enabled = true, description = "Chcking new activitie")
    public void executingNewPage() {
        ArrayList<String> newTb;
        HomePage homepage = new HomePage(driver);
        OpeningNewWindowsPage openingnewwindowspage = new OpeningNewWindowsPage(driver);
        driver.navigate().to("https://the-internet.herokuapp.com/");
        homepage.clickMultipleWindows();
        Assert.assertTrue(openingnewwindowspage.checkOpeningNewWindowsLabe());
        openingnewwindowspage.clickHereAction();
        newTb = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(newTb.get(1));
        Assert.assertEquals(openingnewwindowspage.getNewWindowsText(), "New Window");
    }
}
