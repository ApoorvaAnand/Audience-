package com.audience.util;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseClass {
	public WebDriver driver;
	public static Logger Log = Logger.getLogger(BaseClass.class);
	public Properties prop=new Properties();
	
	public void nextButton(){
		driver.findElement(By.xpath(prop.getProperty("next_button"))).click();
	}

	public void saveChanges(){
		driver.findElement(By.xpath(prop.getProperty("save_changes"))).click();
		
	}
	
	public void pageNumber(String pagenum) throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(
				By.xpath(".//*[@id='content']/ui-view/ui-view/div/div[2]/div/ng-transclude/ui-view/div/div[1]/form/div/fieldset[3]/div[2]/div[2]/select"))
				.click();
		if (pagenum.equals("Default")) {
			driver.findElement(By.xpath("//option[contains(text(),'Default')]"))
					.click();
		} else if (pagenum.equals("DeepLink Service")) {
			driver.findElement(
					By.xpath("//option[contains(text(),'DeepLink Service')]"))
					.click();
			driver.findElement(
					By.xpath(".//*[@id='content']/ui-view/ui-view/div/div[2]/div/ng-transclude/ui-view/div/div[1]/form/div/fieldset[3]/div[2]/div[2]/div/textarea"))
					.sendKeys("0");
		} else if (pagenum.equals("Detail Activity")) {
			driver.findElement(
					By.xpath("//option[contains(text(),'Detail Activity')]"))
					.click();
			driver.findElement(
					By.xpath(".//*[@id='content']/ui-view/ui-view/div/div[2]/div/ng-transclude/ui-view/div/div[1]/form/div/fieldset[3]/div[2]/div[2]/div/textarea"))
					.sendKeys("1");
		} else if (pagenum.equals("Main Activity")) {
			driver.findElement(
					By.xpath("//option[contains(text(),'Main Activity')]"))
					.click();
			driver.findElement(
					By.xpath(".//*[@id='content']/ui-view/ui-view/div/div[2]/div/ng-transclude/ui-view/div/div[1]/form/div/fieldset[3]/div[2]/div[2]/div/textarea"))
					.sendKeys("2");
		}

	}

	public void buttonoptions(String arg) throws InterruptedException {
		Thread.sleep(4000);

		driver.findElement(By.xpath("//button[contains(text(),'Add')]"))
				.click();
		driver.findElement(
				By.xpath(".//*[@id='content']/ui-view/ui-view/div/div[2]/div/ng-transclude/ui-view/div/div[1]/form/div/fieldset[6]/div/div/div[1]/div/input"))
				.sendKeys("button one");
		// driver.findElement(By.xpath(".//*[@id='content']/ui-view/ui-view/div/div[2]/div/ng-transclude/ui-view/div/div[1]/form/div/fieldset[6]/div/div/div[2]/select")).click();
		if (arg.equals("Do nothing")) {
			driver.findElement(
					By.xpath("//option[contains(text(),'Do nothing')]"))
					.click();

		} else if (arg.equals("Open application")) {
			driver.findElement(
					By.xpath("//option[contains(text(),'Open application')]"))
					.click();
			driver.findElement(
					By.xpath("//*[@id='content']/ui-view/ui-view/div/div[2]/div/ng-transclude/ui-view/div/div[1]/form/div/fieldset[3]/div[2]/div[2]/select"))
					.click();
			pageNumber("DeepLink Service");

		} else if (arg.equals("Open URL")) {
			driver.findElement(
					By.xpath("//option[contains(text(),'Open URL')]")).click();
			driver.findElement(
					By.xpath(".//*[@id='content']/ui-view/ui-view/div/div[2]/div/ng-transclude/ui-view/div/div[1]/form/div/fieldset[3]/div[2]/div[2]/input"))
					.sendKeys("www.gmail.com");

		} else if (arg.equals("Close push Notification")) {
			driver.findElement(
					By.xpath("//option[contains(text(),'Close push Notification')]"))
					.click();
 
		driver.findElement(By.xpath("//button[contains(text(),'Next')]")).click();
		}
	}
	    
	public void scrollUp(int scrollUp) throws InterruptedException {
		  JavascriptExecutor jse = (JavascriptExecutor) driver;
		  jse.executeScript("window.scrollBy(0," + scrollUp + ")", "");
		  Thread.sleep(1000);
	}
	
	public void title(){
		driver.findElement(By.xpath(".//*[@id='pushandroidTitle']")).sendKeys(
				"Hello");
		
		
	}
	public void pushmessage(){
		driver.findElement(By.xpath(".//*[@id='pushandroidMessage']"))
		.sendKeys("World");
	}
	public void sound(){
		driver.findElement(By.xpath(".//*[@id='content']/ui-view/ui-view/div/div[2]/div/ng-transclude/ui-view/div/div[1]/form/div/fieldset[3]/div[1]/div/div[1]/div[2]/label/span[2]]")).click();
	}
	
	public void vibrate(){
		driver.findElement(By.xpath(".//*[@id='content']/ui-view/ui-view/div/div[2]/div/ng-transclude/ui-view/div/div[1]/form/div/fieldset[3]/div[1]/div/div[2]/div[2]/label/span[2]")).click();
	}
	public void light(){
		driver.findElement(By.xpath(".//*[@id='content']/ui-view/ui-view/div/div[2]/div/ng-transclude/ui-view/div/div[1]/form/div/fieldset[3]/div[1]/div/div[3]/div[2]/label/span[2]")).click();
	}
	
	public void messageSurvey(){
		driver.findElement(By.xpath(".//*[@id='adp-campaign-wizard-multipush-edit']/div[1]/form/div/fieldset[3]/div[2]/div[2]/div[2]/label/span[2]")).click();
	}
	
	public void messageStandard(){
		driver.findElement(By.xpath(".//*[@id='adp-campaign-wizard-multipush-edit']/div[1]/form/div/fieldset[3]/div[3]/div[2]/div[2]/label/span[2]")).click();
	}
	
	public void condition() throws InterruptedException{
		driver.findElement(By.xpath("//input[@name='scenario-input']")).sendKeys("Condition1");
		Thread.sleep(4000);
		driver.findElement(By.xpath(".//*[@id='content']/ui-view/ui-view/div/div[2]/div/ng-transclude/ui-view/div/form/div/div/div/div/div[1]/div/div[2]/div[2]/div[1]/button")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath(".//*[@id='content']/ui-view/ui-view/div/div[2]/div/ng-transclude/ui-view/div/form/div/div/div/div/div[1]/div/div[2]/div[2]/div[1]/div/div/select")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//option[1]")).click();
	}
	
	
	
	
	public void addpush(){
		driver.findElement(By.xpath("//button[text()='Add push']")).click();
	}
	
	
	public void verifyCampaigntypeAndOStype(String campaigntype, String OStype)
			throws InterruptedException {
		if (campaigntype.equalsIgnoreCase("Oneshot")) {
			Thread.sleep(3000);
			driver.findElement(By.xpath(prop.getProperty("oneshot"))).click();
			Thread.sleep(3000);
		} else if (campaigntype.equalsIgnoreCase("Cyclic")) {
			driver.findElement(By.xpath(prop.getProperty("cyclic"))).click();
			Thread.sleep(3000);
		} else if (campaigntype.equalsIgnoreCase("Program")) {
			driver.findElement(By.xpath(prop.getProperty("program"))).click();

		}
		Thread.sleep(3000);
		if (OStype.equalsIgnoreCase("Android")) {
			driver.findElement(By.xpath(prop.getProperty("Android"))).click();
			Thread.sleep(3000);
		} else if (OStype.equalsIgnoreCase("IOS")) {
			driver.findElement(By.xpath(prop.getProperty("IOS"))).click();
			Thread.sleep(3000);
		} else if (OStype.equalsIgnoreCase("Web")) {
			driver.findElement(By.xpath(prop.getProperty("Web"))).click();
		}

	}
	
}
