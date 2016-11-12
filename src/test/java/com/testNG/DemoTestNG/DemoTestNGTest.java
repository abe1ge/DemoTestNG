package com.testNG.DemoTestNG;

import static java.lang.System.*;
import static org.testng.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 11/11/2016.
 */


public class DemoTestNGTest {

    private WebDriver driver;

    @BeforeTest
    public void setupSelenium()
    {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\work\\Documents\\git hub\\selenium\\DemoTestNG\\geckodriver.exe");
        //WebDriver driver = new FirefoxDriver();
        driver = new FirefoxDriver();

        //instantiating the wait command and setting the maximum time to wait in seconds (4)

    }

    @Test
    public void gmailLogin()
    {
        // objects and variables instantiation


        WebDriverWait wait = new WebDriverWait(driver, 4);

        String appUrl = "https://accounts.google.com";
        // launch the firefox browser and open the application url
        driver.get(appUrl);

        //maximize the browser window
        driver.manage().window().maximize();

        //declare and initialize the variabl to store the expected title of the webpage
        String expectedTitle = "Sign in - Google Accounts";

        //fetch the title of the webpage and save it into a string
        String actualTitle = driver.getTitle();

        //compare expected titial with actual title
        Assert.assertEquals(expectedTitle, actualTitle);

        // enter a valid username in the email textbox
        WebElement username = driver.findElement(By.id("Email"));
        username.clear();
        username.sendKeys("mrtrump2024@gmail.com");

        //click next to move onto password
        WebElement NextButton = driver.findElement(By.id("next"));
        NextButton.click();

        //wait until the Passwd elempent is present
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("Passwd")));

        // enter a valid password in the password textbox
        WebElement password = driver.findElement(By.id("Passwd"));
        password.clear();
        password.sendKeys("trollanddump2024");

        // click on the Sign in button
        WebElement SignInButton = driver.findElement(By.id("signIn"));
        SignInButton.click();

    }

    @AfterTest
    public void closBrowser()
    {
        // close the web browser
        driver.quit();
    }
}