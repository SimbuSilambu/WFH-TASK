package com.flipkart.stepdefinition;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CricketBatValidation {
	
	static WebDriver d;
	
	@Given("User launch in filpkart application{int}")
	public void user_launch_in_filpkart_application(Integer int1) throws Exception {
		WebDriverManager.chromedriver().setup();
		d = new ChromeDriver();
		d.get("https://www.flipkart.com/");
		d.manage().window().maximize();
		Thread.sleep(5000);
	}

	@Given("User click the button{int}")
	public void user_click_the_button(Integer int1) {
		d.findElement(By.xpath("//button[text()='✕']")).click();	
	}

	@When("User Search the Cricket Bat")
	public void user_Search_the_Cricket_Bat() throws Exception {
		d.findElement(By.xpath("//input[@class='_3704LK']")).sendKeys("Cricket Bat");
		d.findElement(By.xpath("//button[@class='L0Z3Pu']")).click();
		Thread.sleep(5000);
	    
	}

	@When("User Click the Bat")
	public void user_Click_the_Bat() {
		d.findElement(By.xpath("(//*[@class='s1Q9rs'])[1]")).click();
		String parent = d.getWindowHandle();
		Set<String> child  = d.getWindowHandles();
		
		for (String c : child) {
			if(!c.equals(parent));
			
			d.switchTo().window(c);
		}    
	}

	@Then("User Click add to card to buy the Bat")
	public void user_Click_add_to_card_to_buy_the_Bat() throws Exception {
		d.findElement(By.xpath("(//*[text()='6'])[1]")).click();
        Thread.sleep(3000);
        d.findElement(By.xpath("//*[text()='ADD TO CART']")).click();
        Thread.sleep(3000);
        d.findElement(By.xpath("//*[text()='Place Order']")).click();
        Thread.sleep(3000);
        d.findElement(By.xpath("//*[text()='CONTINUE']")).click();
	    
	}


}
