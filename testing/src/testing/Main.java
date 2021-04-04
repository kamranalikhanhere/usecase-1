package com.company;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;


// Above for Json

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
public class Main {
    static WebDriver driver;

    public Main(WebDriver driver) {
        this.driver=driver;

    }

    public static void main(String[] args) throws InterruptedException {
        // write your code here

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\kakhan\\Downloads\\chromedriver_win32//chromedriver.exe");
        driver = new ChromeDriver();


        Home obj=new Home(driver);
        obj.ByPage();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        obj.homepage().click();
        System.out.println("Home page clicked successfully");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Fomclasslocators formpage=new Fomclasslocators(driver);
        System.out.println("waiting");
        formpage.Formpage1().click();
        System.out.println("Form page clicked");
        formpage.Formtextpage().click();
        formpage.name().sendKeys("Alpha");
        formpage.Lname().sendKeys("Testing");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        formpage.gender();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("before phone number");
        formpage.Cellphone();
        formpage.Submit();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);


        String winHandleBefore = driver.getWindowHandle();

// Perform the click operation that opens new window

// Switch to new window opened
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }

        System.out.println("switched to pop up");
        String Success = formpage.VerifyFileSuccess();
        Assert.assertTrue(Success.contains("Thanks for submitting the form"));
        System.out.println("verified text: Form Submitted successully");
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
      //  driver.switchTo().window(winHandleBefore);
         formpage.Closepopup().click();
        driver.switchTo().window(winHandleBefore);
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.quit();
    }







    }


