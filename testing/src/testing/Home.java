package com.company;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Home {

    WebDriver driver;

    By homepage = By.xpath("/html/body/div/header/a/img");

    // By Frame = By.name("title");
    // By Loginperson = By.xpath("//*[@id='form1']/div[1]/header/nav/div/ul/li[2]/a/span");
    // By Loginperson = By.xpath("//span[@class='hidden-xs']");

    public Home(WebDriver driver){

        this.driver = driver;

    }



    public WebElement homepage(){

        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(homepage));

        return driver.findElement(homepage);
    }

    public void ByPage() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Launch the application

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //This will scroll the web page till end.
        js.executeScript("window.scrollBy(0,2000)"); //Scroll vertically down by 10000 pixels

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        js.executeScript("window.scrollBy(0,-1000)");
    }

}
