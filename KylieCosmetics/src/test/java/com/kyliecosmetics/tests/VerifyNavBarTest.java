package com.kyliecosmetics.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class VerifyNavBarTest
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
    public void CookieConsent()
    {
        driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]")).click();
    }
    @Test
    public void verifyNavBar()
    {
        boolean navBarPresent = driver.findElement(By.xpath("/html/body/header/div[2]/div/div[2]")).isDisplayed();
        Assert.assertTrue(navBarPresent);
    }

    @AfterTest
    public void teardown()
    {
        driver.quit();
    }
}
