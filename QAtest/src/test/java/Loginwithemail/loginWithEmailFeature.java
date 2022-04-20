package Loginwithemail;

import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginWithEmailFeature {
	WebDriver driver = null;
	@Given("User on the welcome page to login")
	public void user_on_the_welcome_page_to_login() {
		driver = new ChromeDriver();
		driver.get("https://stockbit.com");
	}

	@When("User click on login button")
	public void user_click_on_login() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.className("login-ldn")).click();
	}
	
	@And("User fill email field in login page")
	public void user_fill__email_field_in_login_page() {
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("seleniumtest791@gmail.com");
	}
	
	@And("User fill password field in login page")
	public void user_fill_password_field_in_login_page() {
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Seleniumtest123890");
	}
	
	@And("User click login button")
	public void user_click_login_button() {
		driver.findElement(By.xpath("//input[@id='loginbutton']")).click();
	}
	
	@Then("User should see the homepage")
	public void user_should_see_homepage() {
		if (driver.getPageSource().contains("stockbit")) 
			System.out.println("Passed");
		else System.out.println("Failed");
	}
}
