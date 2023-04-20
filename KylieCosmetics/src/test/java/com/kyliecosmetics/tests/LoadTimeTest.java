package com.kyliecosmetics.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoadTimeTest
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
    public void websiteLoadTime()
    {
        long startTime = System.currentTimeMillis();

        // Navigate to the website
        driver.get("https://kyliecosmetics.com/");

        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;

        System.out.println("Load time: " + totalTime + " milliseconds");
    }
    @AfterTest
    public void teardown()
    {
        driver.quit();
    }
}
