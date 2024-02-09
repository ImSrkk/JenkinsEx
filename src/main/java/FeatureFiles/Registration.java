package FeatureFiles;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Registration {
    WebDriver driver =new EdgeDriver();

    @Given("User is on Webpage")

    public void user_is_on_webpage() {
        String url="https://automationexercise.com/";
        driver.get(url);
        driver.manage().window().maximize();


        driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();
    }
    @When("User Fills the details")
    public void user_fills_the_details() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Nicholas Fury");
        String email ="Nickf" + System.currentTimeMillis()+ "@marvels.com";
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys(email);
        driver.findElement(By.cssSelector("button[data-qa='signup-button']")).click();
        Thread.sleep(1000);


        driver.findElement(By.id("id_gender1")).click();
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Abc@123");


        Select dob = new Select(driver.findElement(By.xpath("//select[@id='days']")));
        dob.selectByVisibleText("10");
        Select month = new Select(driver.findElement(By.cssSelector("#months")));
        month.selectByValue("11");
        Select year = new Select(driver.findElement(By.id("years")));
        year.selectByVisibleText("1966");

        driver.findElement(By.id("first_name")).sendKeys("Nicholas");
        driver.findElement(By.id("last_name")).sendKeys("Fury");
        driver.findElement(By.name("company")).sendKeys("S.H.E.I.L.D.");
        driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("The Avengers Facility");
        driver.findElement(By.name("address2")).sendKeys("Manhattan");

        Select country = new Select(driver.findElement(By.name("country")));
        country.selectByValue("United States");

        driver.findElement(By.name("state")).sendKeys("Ney York");
        driver.findElement(By.id("city")).sendKeys("NeyYork city");
        driver.findElement(By.id("zipcode")).sendKeys("NY 10036");
        driver.findElement(By.cssSelector("#mobile_number")).sendKeys("+12233948371");

    }
    @Then("User clicks on Register button")
    public void user_clicks_on_register_button() throws InterruptedException {
        driver.findElement(By.xpath("//button[normalize-space()='Create Account']")).click();
        Thread.sleep(1500);
        WebElement title = driver.findElement(By.xpath("//b[normalize-space()='Account Created!']"));
        System.out.println(title.getText());
        driver.quit();
    }

}
