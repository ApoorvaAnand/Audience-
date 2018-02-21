package com.audience.util;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class Login extends BaseClass {

	@BeforeTest
	public void openBrowser() throws InterruptedException, IOException {
		prop.load(getClass().getClassLoader().getResourceAsStream("application.properties"));

	System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
	driver = new ChromeDriver();
		// creating an object of Chrome driver with the reference of webdriver
		// interface

		// getting the baseurl
	String baseurl = "https://uat-ui.support-pcg.eu";
		driver.get(baseurl);
		System.out.println("launched Audience+  website Successfully");
		Thread.sleep(1000);
		driver.manage().window().maximize();

		try {
		driver.findElement(By.xpath(prop.getProperty("Username_xpath"))).sendKeys(prop.getProperty("Username"));
	Log.info("[...] Valid username");
		driver.findElement(By.xpath(prop.getProperty("pwd_xpath"))).sendKeys(prop.getProperty("pwd"));
			Log.info("[...]valid password");
			
		} catch (Exception e) { 
			Log.error("Invalid username and password");
		}

		driver.findElement(By.xpath(prop.getProperty("Login")))
				
				.click();

	

	} 
}
