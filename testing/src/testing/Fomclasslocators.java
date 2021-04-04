package com.company;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Fomclasslocators  {


    WebDriver driver;

    By SelectForm = By.xpath("/html/body/div/div/div/div[2]/div/div[2]/div/div[3]");
    //By Formtext = By.linkText("Please select an item from left to start practice.");
    By praticeform = By.xpath("/html/body/div/div/div/div[2]/div[1]/div/div/div[2]/div/ul/li/span");
    By Name = By.id("firstName");
    By LName = By.id("lastName");
    By gender = By.xpath("/html/body/div/div/div/div[2]/div[2]/div[1]/form/div[3]/div[2]/div[1]/label");
    By Cellphone = By.id("userNumber");
    By Submit = By.id("submit");
    By SuccessMessage=By.id("example-modal-sizes-title-lg");
    By closepopup=By.id("closeLargeModal");

    public Fomclasslocators(WebDriver driver) {
        this.driver=driver;

    }

    public  WebElement Formpage1() {
        WebElement myelement = driver.findElement(SelectForm);
        JavascriptExecutor jse2 = (JavascriptExecutor)driver;
        jse2.executeScript("arguments[0].scrollIntoView()", myelement);
        return driver.findElement(SelectForm);
    }

    public WebElement Formtextpage() {

        return driver.findElement(praticeform);
    }
//    public WebElement praticeform() {
//
//        return driver.findElement(praticeform);
//    }

    public WebElement name() {

        return driver.findElement(Name);
    }
    public WebElement Lname() {

        return driver.findElement(LName);
    }
    public WebElement gender() {
        WebElement radio = driver.findElement(gender);
        radio.click();
        return radio;
    }

    public WebElement Cellphone() {
            WebElement cell=driver.findElement(Cellphone);
            cell.sendKeys("1234567990");
        return cell;
    }

    public WebElement Submit() {
        WebElement ele = driver.findElement(Submit);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", ele);
        return ele;
    }
    public String VerifyFileSuccess(){

       
        WebDriverWait wait = new WebDriverWait (driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(SuccessMessage));
        return driver.findElement(SuccessMessage).getText();
    }
    public WebElement Closepopup() {

        return driver.findElement(closepopup);
    }
}
