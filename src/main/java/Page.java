package com.selenium.webdriver;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Page extends com.selenium.webdriver.SetUp {

    public WebElement findByName(String name){
        WebElement Element=driver.findElement(By.name(name));
        return Element;
    }

    public WebElement findByName(String name){
        WebElement Element=driver.findElement(By.name(name));
        return Element;
    }

    public WebElement findByClassName(String name){
        WebElement Element=driver.findElement(By.className(name));
        return Element;
    }
    public WebElement findByXpath(String name){
        WebElement Element=driver.findElement(By.xpath(name));
        return Element;
    }
    public WebElement findById(String name){
        WebElement Element=driver.findElement(By.id(name));
        return Element;
    }


    public List<WebElement> findListByXpath(String name){
        List<WebElement> Element=driver.findElements(By.xpath(name));
        return Element;
    }
    public ExpectedCondition<WebElement> elementClickableByClassName(String name){
        ExpectedCondition<WebElement> clickable=ExpectedConditions.elementToBeClickable((By.className(name)));
        return clickable;
    }
    public ExpectedCondition<WebElement> elementClickableById(String name){
        ExpectedCondition<WebElement> clickable=ExpectedConditions.elementToBeClickable((By.id(name)));
        return clickable;
    }
    public ExpectedCondition<WebElement> elementClickableByXpath(String name){
        ExpectedCondition<WebElement> clickable=ExpectedConditions.elementToBeClickable((By.xpath(name)));
        return clickable;
    }
    public String getElementTextByXpath(String name){
        return driver.findElement(By.xpath(name)).getText();
    }
    public void waitForPageLoad() {

        Wait<WebDriver> wait = new WebDriverWait(driver, 10);
        wait.until(new Function<WebDriver, Boolean>() {
            public Boolean apply(WebDriver driver) {
                System.out.println("Current Window State       : "
                        + String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")));
                return String
                        .valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
                        .equals("complete");
            }
        });
    }
}