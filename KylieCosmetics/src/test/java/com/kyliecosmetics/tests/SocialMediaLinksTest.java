package com.kyliecosmetics.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SocialMediaLinksTest
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

    /*@Test
    public void testSocialMediaLinks() throws InterruptedException
    {
        JavascriptExecutor jsexecutor = (JavascriptExecutor) driver;
        jsexecutor.executeScript("window.scrollBy(0,4500)", "");
        Thread.sleep(3000);

        // find the social media links
        WebElement facebookLink = driver.findElement(By.xpath("//img[@alt='Facebook']"));
        WebElement instagramLink = driver.findElement(By.xpath("//img[@alt='Instagram']"));
        WebElement twitterLink = driver.findElement(By.xpath("//img[@alt='Twitter']"));

        // click on the links
        facebookLink.click();
        driver.navigate().back();
        Thread.sleep(3000);

        JavascriptExecutor jsexecutor1 = (JavascriptExecutor) driver;
        jsexecutor1.executeScript("window.scrollBy(0,5000)", "");
        Thread.sleep(3000);

        instagramLink.click();
        driver.navigate().back();
        Thread.sleep(3000);

        JavascriptExecutor jsexecutor2 = (JavascriptExecutor) driver;
        jsexecutor2.executeScript("window.scrollBy(0,5000)", "");
        Thread.sleep(3000);

        twitterLink.click();
        Thread.sleep(3000);
        driver.navigate().back();
    }*/
    @Test
    public void facebookTest() throws InterruptedException
    {
        JavascriptExecutor jsexecutor = (JavascriptExecutor) driver;
        jsexecutor.executeScript("window.scrollBy(0,4500)", "");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//img[@alt='Facebook']")).click();
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(3000);
    }
    @Test
    public void instagramTest() throws InterruptedException
    {
        JavascriptExecutor jsexecutor = (JavascriptExecutor) driver;
        jsexecutor.executeScript("window.scrollBy(0,4500)", "");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//img[@alt='Instagram']")).click(); ///html/body/footer/div/div/div[2]/div[2]/a
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(3000);
    }
    @Test
    public void twitterTest() throws InterruptedException
    {
        JavascriptExecutor jsexecutor = (JavascriptExecutor) driver;
        jsexecutor.executeScript("window.scrollBy(0,4500)", "");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//img[@alt='Twitter']")).click();
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(3000);
    }
    @AfterTest
    public void teardown()
    {
        driver.quit();
    }
}
