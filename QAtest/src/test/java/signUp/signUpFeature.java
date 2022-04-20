package signUp;

import java.util.Collections;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class signUpFeature {
	WebDriver driver = null;
	Set<String> window;
	String winHandleBefore;
	
	@Given("User on the welcome page")
	public void user_on_the_welcome_page() {
		driver = new ChromeDriver();
		driver.get("https://stockbit.com");
	}

	@When("User click on Sign up")
	public void user_click_on_sign_up() {
		driver.findElements(By.className("register-lnd")).get(0).click();
	}
	
	@And("User click Register with google")
	public void user_click_register_with_google() {
		driver.findElements(By.cssSelector("input.loginlogin.register-goog.google-logo")).get(0).click();
	}
	
	@And("Pop up will show up")
	public void and_pop_up_will_show_up() {
		winHandleBefore = driver.getWindowHandle();
		for(String winHandle : driver.getWindowHandles())
	    {
	        driver.switchTo().window(winHandle);
	    }
	}
	
	@And("User fill email field")
	public void user_fill_email_field() {
		driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("seleniumtest791@gmail.com");
	}
	
	@And("User click next button")
	public void user_click_next_button() {
		ChromeOptions options = new ChromeOptions();
	    options.addArguments("start-maximized");
	    options.setExperimentalOption("useAutomationExtension", false);
	    options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		driver.findElements(By.cssSelector("button.VfPpkd-LgbsSe.VfPpkd-LgbsSe-OWXEXe-k8QpJ.VfPpkd-LgbsSe-OWXEXe-dgl2Hf.nCP5yc.AjY5Oe.DuMIQc.qfvgSe.qIypjc.TrZEUc.lw1w4b")).get(0).click();
	}
	
	@And("User fill password field")
	public void user_fill_password_field() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//input[@class='whsOnd zHQkBf']")).sendKeys("Seleniumtest123890");
	}
	
	@And("User will see register form")
	public void user_will_see_register_form() {
		driver.getPageSource().contains("Your Name");
	}
	
	@And("User click register button")
	public void user_click_register_button() {
		driver.findElement(By.xpath("//button[@class='loginlogin']")).click();
	}

	@Then("User should see homepage")
	public void user_should_see_homepage() {
		if (driver.getPageSource().contains("check")) 
			System.out.println("Passed");
		else System.out.println("Failed");
	}
}
