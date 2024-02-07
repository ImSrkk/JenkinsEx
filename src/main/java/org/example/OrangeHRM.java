package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRM {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver =new ChromeDriver();
driver.get("https://opensource-demo.orangehrmlive.com/");
        System.out.println("The Title: "+driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(2000);
       WebElement usrnm=driver.findElement(By.xpath("//input[@placeholder='Username']"));

       usrnm.sendKeys("Admin");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
    }
}
