package com.flipkart.stepdefinition;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazonshoesvalidation {
	
	static WebDriver d;
	
	
	@Given("User Launch Amazon")
	public void user_Launch_Amazon() {
		WebDriverManager.chromedriver().setup();
		d = new ChromeDriver();
		d.get("https://www.amazon.in/");
		d.manage().window().maximize();
	    
	}

	@When("User Search adidas Shoe")
	public void user_Search_adidas_Shoe() {
		d.findElement(By.xpath("//*[@type='text']")).sendKeys("adidas shoes");
	    
	}

	@When("User Click to search")
	public void user_Click_to_search() {
		d.findElement(By.xpath("//*[@class='nav-search-submit nav-sprite']")).click();
d.findElement(By.xpath("(//*[contains(@class,'a-size-base-plus a-color-base a-text-normal')])[1]")).click();
		
		String Pw = d.getWindowHandle();
		Set<String> Cw = d.getWindowHandles();
		
		for (String C : Cw) {
			if(!C.equals(Pw)) {
			d.switchTo().window(C);
			
		}}
	    
	}

	@Then("User Buy the Adidas Shoe")
	public void user_Buy_the_Adidas_Shoe() throws Exception {
		Thread.sleep(5000);
		d.findElement(By.id("buy-now-button")).click();
		d.quit();
		
	    
	}

}
