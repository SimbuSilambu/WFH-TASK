package com.flipkart.stepdefinition;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class mobilevalidation {
	
	static WebDriver  d;
	static String NA;
	
	@Given("User launch in filpkart application")
	public void user_launch_in_filpkart_application() throws Exception {
		WebDriverManager.chromedriver().setup();
		d = new ChromeDriver();
		d.get("https://www.flipkart.com/");
		d.manage().window().maximize();
		Thread.sleep(5000);
	    
	}

	@Given("User click the button")
	public void user_click_the_button() {
		d.findElement(By.xpath("//button[text()='✕']")).click();	    
	}

	@When("User Search the Vivo y{int} mobile")
	public void user_Search_the_Vivo_y_mobile(Integer int1) throws Exception {
		d.findElement(By.xpath("//input[@class='_3704LK']")).sendKeys("vivo y17");
		d.findElement(By.xpath("//button[@class='L0Z3Pu']")).click();
		Thread.sleep(5000);
	    
	}

	@When("User Click the moblie")
	public void user_Click_the_moblie() {
d.findElement(By.xpath("(//*[contains(text(),'vivo Y17')])[1]")).click();
		
		String parent = d.getWindowHandle();
		Set<String> child  = d.getWindowHandles();
		
		for (String c : child) {
			if(!c.equals(parent));
			
			d.switchTo().window(c);
		}
		
	    
	}

	@Then("User Click add to card to buy the mobile")
	public void user_Click_add_to_card_to_buy_the_mobile() throws Exception {
		
		Thread.sleep(3000);
		d.findElement(By.xpath("//button[text()='ADD TO CART']")).click();
		//d.quit();
	    
	}
}
