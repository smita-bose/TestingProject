package com.kyliecosmetics.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MobileResponsivenessTest
{
    WebDriver driver;

    @BeforeTest
    public void setUp() throws Exception
    {
        //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        // navigate to website
        driver.get("https://kyliecosmetics.com/en-in");
        // resize window to mobile device screen size
        driver.manage().window().setSize(new Dimension(360, 740));
        Thread.sleep(1000);
        //DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        //driver = new ChromeDriver(capabilities);
    }
    @Test
    public void CookieConsent()
    {
        driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]")).click();
    }
    @Test
    public void testMobileResponsive() throws InterruptedException
    {
        // check that website elements are displayed correctly
        WebElement menuIcon = driver.findElement(By.xpath("/html/body/header/div[2]/div/div[3]/a"));
        Assert.assertTrue(menuIcon.isDisplayed());
        Thread.sleep(2000);

        menuIcon.click();
        //WebElement accountIcon = driver.findElement(By.xpath("//*[@id=\"main-menu-flyout\"]/header/div[2]/div[2]/a"));
        //WebElement accountIcon = driver.findElement(By.xpath("//a[@href='/en-in/account/login']"));
        //Assert.assertTrue(accountIcon.isDisplayed());
        //Thread.sleep(3000);
        try
        {
            WebElement accountIcon = driver.findElement(By.xpath("//a[@href='/en-in/account/login']"));
            if (((WebElement) accountIcon).isDisplayed())
            {
                Assert.assertTrue(accountIcon.isDisplayed());
                Thread.sleep(3000);
            }
        }
        catch (NoSuchElementException e)
        {
            // Handle exception if the element is not found
        }

        // test login functionality
        //accountIcon.click();
        driver.findElement(By.xpath("//a[@href='/en-in/account/login']")).click();
        driver.findElement(By.xpath("//*[@id=\"CustomerLogin-CustomerEmail\"]")).sendKeys("jivadixit1@gmail.com");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"CustomerLogin-CustomerPassword\"]")).sendKeys("Smita@0987");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"CustomerLogin-Submit\"]")).click();
        Thread.sleep(3000);

        // test search functionality
        driver.findElement(By.xpath("/html/body/header/div[2]/div/div[4]/a[3]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"SearchForm-Header-Query\"]")).sendKeys("eyeliner");
        Thread.sleep(4000);
        String expectedURL = "https://kyliecosmetics.com/en-in/account";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL, "actual and expected urls are not same");

    }

    @AfterTest
    public void tearDown() throws Exception
    {
        driver.quit();
    }

}
