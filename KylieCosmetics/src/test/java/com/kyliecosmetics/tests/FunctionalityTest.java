package com.kyliecosmetics.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FunctionalityTest
{
    WebDriver driver;
    @BeforeTest
    public void setup()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //WebDriverManager.safaridriver().setup();
        //driver = new SafariDriver();
        driver.get("https://kyliecosmetics.com/en-in");
        driver.manage().window().maximize(); //Full screen.
    }

    @Test
    public void CookieConsent()
    {
        driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]")).click();
    }
    @Test (priority = 1)
    public void loginToSite() throws InterruptedException
    {
        driver.findElement(By.xpath("//a[@title='Account']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"CustomerLogin-CustomerEmail\"]")).sendKeys("jivadixit1@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"CustomerLogin-CustomerPassword\"]")).sendKeys("Smita@0987");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"CustomerLogin-Submit\"]")).click();
        Thread.sleep(2000);
    }

    @Test (priority = 2)
    public void searchProduct() throws InterruptedException
    {
        driver.findElement(By.xpath("//a[@title='Search']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='SearchForm-Header-Query']")).sendKeys("lipstick");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@id='SearchForm-Header-Submit']")).click();
        Thread.sleep(3000);
    }
    @Test (priority = 3) //(dependsOnMethods = {"searchProduct"})
    public void getProductDetails() throws InterruptedException
    {
        //driver.findElement(By.linkText("dolce k")).click();
        driver.findElement(By.xpath("//*[@id=\"uid-41-ProductTile-Title\"]")).click();
        Thread.sleep(4000);
    }

    @Test (priority = 4)
    public void addToWishlist() throws InterruptedException
    {
        //driver.findElement(By.xpath("//span[@class='wishlist-button__icon icon icon--heart-outline']")).click();
        //driver.findElement(By.xpath("//*[@id=\"shopify-section-template--16612516069618__main\"]/div/article/div[2]/div/div[2]/div/div[1]/div/button")).click();
        Thread.sleep(3000);
        try
        {
            //WebElement addToCartButton = driver.findElement(By.xpath("//button[@type='button' and @title='add to wishlist']"));
            WebElement addToCartButton = driver.findElement(By.xpath("//div[@class='badges-container']//span[@class='wishlist-button__icon icon icon--heart-outline']"));
            if (((WebElement) addToCartButton).isDisplayed())
            {
                addToCartButton.click();
                Thread.sleep(3000);
            }
        }
        catch (NoSuchElementException e)
        {
            // Handle exception if the element is not found
        }
    }

    @Test (priority = 5)
    public void checkWishlist() throws InterruptedException
    {
        driver.findElement(By.xpath("//a[@class='site-header__action site-header__action--wishlist']")).click();
        Thread.sleep(3000);
    }
    @Test (priority = 6)
    public void productAddToCart() throws InterruptedException
    {
        //driver.findElement(By.xpath("//*[@id=\"uid-31-ProductTileQuickAdd\"]/div[3]/div/button[1]")).click();
        //driver.findElement(By.xpath("//*[@id=\"MainContent\"]/div/div[1]/div[2]/article/div/div/div[2]/button")).click();
        //Thread.sleep(3000);
        try
        {
            WebElement addToCartButton = driver.findElement(By.xpath("//*[@id=\"MainContent\"]/div/div[1]/div[2]/article/div/div/div[2]/button"));
            if (((WebElement) addToCartButton).isDisplayed())
            {
                addToCartButton.click();
                Thread.sleep(3000);
            }
        }
        catch (NoSuchElementException e)
        {
            // Handle exception if the element is not found
        }
    }
    @Test (priority = 7)
    public void checkoutProduct() throws InterruptedException
    {
        //driver.findElement(By.xpath("//*[@id=\"MiniCart-Checkout\"]")).click();
        //Thread.sleep(3000);
        try
        {
            WebElement checkoutButton = driver.findElement(By.xpath("//*[@id=\"MiniCart-Checkout\"]"));
            if (((WebElement) checkoutButton).isDisplayed())
            {
                checkoutButton.click();
                Thread.sleep(3000);
            }
        }
        catch (NoSuchElementException e)
        {
            // Handle exception if the element is not found
        }
    }
    @AfterTest
    public void teardown()
    {
        driver.quit();
    }
}
