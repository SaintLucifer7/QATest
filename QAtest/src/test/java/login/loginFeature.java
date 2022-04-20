package login;

import java.util.Collections;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginFeature {
	WebDriver driver = null;
	Set<String> window;
	
	@Given("User on the welcome pagee")
	public void user_on_the_welcome_pagee() {
		driver = new ChromeDriver();
		driver.get("https://stockbit.com");
	}

	@When("User click on login")
	public void user_click_on_login() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.className("login-ldn")).click();
	}
	
	@And("User click log in with google")
	public void user_click_log_in_with_google() {
		driver.findElements(By.cssSelector("input.loginlogin.login-goog.google-logo")).get(0).click();
	}
	
	@And("Pop up will show upp")
	public void pop_up_will_show_upp() {
		for(String winHandle : driver.getWindowHandles())
	    {
	        driver.switchTo().window(winHandle);
	    }
	}
	
	@And("User fill login email field")
	public void user_fill_login_email_field() {
		driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("seleniumtest791@gmail.com");
	}
	
	@And("User click login next button")
	public void user_click_login_next_button() {
		ChromeOptions options = new ChromeOptions();
	    options.addArguments("start-maximized");
	    options.setExperimentalOption("useAutomationExtension", false);
	    options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		driver.findElements(By.cssSelector("button.VfPpkd-LgbsSe.VfPpkd-LgbsSe-OWXEXe-k8QpJ.VfPpkd-LgbsSe-OWXEXe-dgl2Hf.nCP5yc.AjY5Oe.DuMIQc.qfvgSe.qIypjc.TrZEUc.lw1w4b")).get(0).click();
	}
	
	@And("User fill password login field")
	public void user_fill_password_login_field() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//input[@class='whsOnd zHQkBf']")).sendKeys("Seleniumtest123890");
	}
	
	@Then("User should see homepagee")
	public void user_should_see_homepagee() {
		if (driver.getPageSource().contains("stockbit")) 
			System.out.println("Passed");
		else System.out.println("Failed");
	}
}
