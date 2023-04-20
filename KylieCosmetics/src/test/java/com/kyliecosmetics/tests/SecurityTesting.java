package com.kyliecosmetics.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class SecurityTesting
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
    public void testSSLCertificate()
    {
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://kyliecosmetics.com/en-in";
        Assert.assertEquals(actualUrl, expectedUrl, "The website is not using HTTPS");

        String actualTitle = driver.getTitle();
        String expectedTitle = "Kylie Cosmetics by Kylie Jenner | Kylie Skin | Kylie Baby";
        Assert.assertEquals(actualTitle, expectedTitle, "The website title is incorrect");
    }
    @AfterTest
    public void teardown()
    {
        driver.quit();
    }
}
