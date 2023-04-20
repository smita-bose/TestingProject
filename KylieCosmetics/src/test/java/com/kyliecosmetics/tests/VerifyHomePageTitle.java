package com.kyliecosmetics.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class VerifyHomePageTitle
{
    WebDriver driver;

    @BeforeTest
    public void setup()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://kyliecosmetics.com/en-in");
        driver.manage().window().maximize(); //Full screen.
    }

    @Test
    public void verifyTitle()
    {
        String expectedTitle = "Kylie Cosmetics by Kylie Jenner | Kylie Skin | Kylie Baby";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @AfterTest
    public void teardown()
    {
        driver.quit();
    }
}
