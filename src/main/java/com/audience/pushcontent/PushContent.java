package com.audience.pushcontent;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.audience.campaign.DefineCampaign;

public class PushContent extends DefineCampaign {
 @Test(priority=1) 

	public void push(String PushType) throws InterruptedException, IOException {
	 if (PushType.equals("Standard")) {
			driver.findElement(
					By.xpath(".//*[@id='content']/ui-view/ui-view/div/div[2]/div/ng-transclude/ui-view/div/div[1]/form/div/fieldset[2]/select"))
					.click();

			driver.findElement(
					By.xpath("//option[contains(text(),'Standard')]")).click();

			driver.findElement(
					By.xpath(".//*[@id='content']/ui-view/ui-view/div/div[2]/div/ng-transclude/ui-view/div/div[1]/form/div/fieldset[3]/div[1]/div/div[1]/div[2]/label/span[2]"))
					.click();

			Thread.sleep(3000);

		}
			
		}
		@Test(dependsOnMethods="push")
	public void pushOptions() throws InterruptedException{
		Thread.sleep(4000);
		
		 List<WebElement> choice = driver.findElements(By.xpath(prop.getProperty("Toggle")));
	        for(WebElement e : choice){
	            System.out.println(e.getText());
	            e.click();
	           
			}
			
		
		
	}
	}
	

