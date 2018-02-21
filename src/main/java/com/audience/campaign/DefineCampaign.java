package com.audience.campaign;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.audience.util.BaseClass;
import com.audience.util.Login;

public class DefineCampaign extends Login {
	@Test(priority = 1)
	public void definecampaign() throws InterruptedException, IOException {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath(prop.getProperty("Campaigns"))).click();
		driver.findElement(By.xpath(prop.getProperty("New_Campaign"))).click();
		Log.info("[..]Creating a new campaign");
		Log.info("[..]Entering campaign name");
		driver.findElement(By.xpath(prop.getProperty("Campaign_Name")))
				.sendKeys(prop.getProperty("name"));
		Log.info("[...]Enter campaign description");
		driver.findElement(By.xpath(prop.getProperty("Campaign_Description")))
				.sendKeys(prop.getProperty("Desc"));
		Thread.sleep(4000);
		verifyCampaigntypeAndOStype("Oneshot","Android");
		Thread.sleep(4000);
	}
	@Test(dependsOnMethods="definecampaign")
  public void campaignOptions() throws InterruptedException{
	  driver.findElement(By.xpath(prop.getProperty("Start_date"))).click();
	  Thread.sleep(3000);
	  driver.findElement(By.xpath(prop.getProperty("Current_date"))).click();
	  Log.info("[...]Current date and time selected");
	  driver.findElement(By.xpath(prop.getProperty("Select_Category"))).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath(prop.getProperty("categ"))).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath(prop.getProperty("Sub_Category"))).click();
		driver.findElement(By.xpath(prop.getProperty("sub_categ"))).click();
		Log.info("Category and Sub Category selected");
		Thread.sleep(3000);
		nextButton();

  }
	
}
