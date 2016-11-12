package com.testNG.DemoTestNG;

import org.apache.xpath.operations.String;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Administrator on 11/11/2016.
 */

public class DemoTestNG {

    public void main(String[] args) {
        // objects and variables instantiation

        //need to change this to where the geckodriver.exe is located
        System.setProperty("webdriver.gecko.driver", "..\\DemoTestNG\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        java.lang.String appUrl = "https://accounts.google.com";

        //instantiating the wait command and setting the maximum time to wait in seconds (4)
        WebDriverWait wait = new WebDriverWait(driver, 4);

        // launch the firefox browser and open the application url
        driver.get(appUrl);

        //maximize the browser window
        driver.manage().window().maximize();

        //declare and initialize the variabl to store the expected title of the webpage
        java.lang.String expectedTitle = "Sign in - Google Accounts";

        //fetch the title of the webpage and save it into a string
        java.lang.String actualTitle = driver.getTitle();

        // compare the expected title of the page with the actual title of the page and print the result
        if (expectedTitle.equals(actualTitle)) {
            System.out.println("Verification Successful - The correct title is displayed on the web page.");
        } else {
            System.out.println("Verification Failed - An incorrect title is displayed on the web page");
            System.out.println(actualTitle);
        }

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

        // close the web browser
        driver.close();
        //driver.quit();   //to force close the browser
        System.out.println("Test script executed successfully.");

        // terminate the program
        System.exit(0);
    }
}
