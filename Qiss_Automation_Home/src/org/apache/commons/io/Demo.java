package org.apache.commons.io;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Demo {

	public static void main(String[] args) throws Exception {
		/*Set drivers path*/
		
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ritesh.jhaveri\\Documents\\Ritesh\\chromedriver.exe");		
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		
		ChromeDriver driver = new ChromeDriver(options);
		
		WebDriverWait wait = new WebDriverWait(driver,90);
		driver.get("https://qiss-test.quipment.nl/Vehicle/MaintainVehicle/12691");
		
		/*To Maximize Browser Window*/
		driver.manage().window().maximize();
		
		WebElement username=driver.findElement(By.id("userNameInput"));
		WebElement passwordname=driver.findElement(By.id("passwordInput"));
	
		Thread.sleep(3000);
		
		username.sendKeys("ritesh.jhaveri@quipment.nl");
		passwordname.sendKeys("R!tesh@1989");
		
		WebElement submitButton=driver.findElement(By.id("submitButton"));
		submitButton.click();
		
		Thread.sleep(3000);
		driver.get("https://qiss-test.quipment.nl/Vehicle/MaintainVehicle/12691");
		
		Thread.sleep(10000);
		
		/* Displaying Software adopter type value from dropdown list */
		WebElement soft_xp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@aria-owns='ddlSoftwareAdopterType_listbox']")));
		System.out.println("Already selected Soft Adopter Type - " + soft_xp.getText());
		
		soft_xp.click();
		
		List<WebElement> list  = driver.findElementsByXPath("//div[@id='ddlSoftwareAdopterType-list']/div/ul/li");
		
		for (int i = 0; i<3; i++)
		{
			
		
		for (WebElement loop : list)
		{
			//System.out.println("Values " + loop.getAttribute("innerHTML"));
			
			if (loop.getAttribute("innerHTML").contains("Final"))
			{
				Thread.sleep(2000);
				loop.click();
				System.out.println("i am in Final");
				wait.until(ExpectedConditions.elementToBeClickable(By.id("tabContents"))).click();
				wait.until(ExpectedConditions.elementToBeClickable(By.id("tabContents"))).click();
				Thread.sleep(2000);
				
				soft_xp.click();
			}
			else if (loop.getAttribute("innerHTML").contains("Beta"))
			{
				Thread.sleep(2000);
				loop.click();
				System.out.println("i am in Beta");
				wait.until(ExpectedConditions.elementToBeClickable(By.id("tabContents"))).click();
				Thread.sleep(2000);
				soft_xp.click();
			}
			else if (loop.getAttribute("innerHTML").contains("Pilot"))
			{
				Thread.sleep(2000);
				loop.click();
				System.out.println("i am in Pilot");
				wait.until(ExpectedConditions.elementToBeClickable(By.id("tabContents"))).click();
				Thread.sleep(2000);
				soft_xp.click();
			}
			
		}
	}		
		
		/*//Verify View history popup 
		Thread.sleep(3000);
		WebElement view_his = wait.until(ExpectedConditions.elementToBeClickable(By.id("viewHistory")));
		view_his.click();
		
		WebElement from_date = wait.until(ExpectedConditions.elementToBeClickable(By.id("viewHistoryFromDate")));
		from_date.clear();
		
		Thread.sleep(2000);
		
		WebElement sideclick  = driver.findElement(By.id("Container"));
		sideclick.click();
		
		
		WebElement ok = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class = 'ui-button ui-corner-all ui-widget']")));
		ok.click();
		
		Thread.sleep(2000);
		
		from_date.sendKeys("19-05-2018");
		
		
		System.out.println("Wowwww");
		
		WebElement to_date = wait.until(ExpectedConditions.elementToBeClickable(By.id("viewHistoryToDate")));
		to_date.clear();
		
		WebElement sideclick1  = driver.findElement(By.id("Container"));
		sideclick1.click();
		
		Thread.sleep(2000);
		WebElement okk = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class = 'ui-button ui-corner-all ui-widget']")));
		okk.click();
		
		Thread.sleep(2000);
		from_date.sendKeys("21-05-2018");
		
		System.out.println("Done..");
		
		WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.id("Search")));
		search.click();
		Thread.sleep(2000);
		 
		WebElement status = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for = 'inputStatusUpdate']")));
		System.out.println(status.isDisplayed());
		Thread.sleep(3000);
		System.out.println(status.isSelected());
		Thread.sleep(3000);
		System.out.println(status.isEnabled());
		
		WebElement att = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for = 'inputAttributeStatus']")));
		System.out.println(att.isDisplayed());
		Thread.sleep(3000);
		System.out.println(att.isSelected());
		Thread.sleep(3000);
		System.out.println(att.isEnabled());
		
		Thread.sleep(2000);
		WebElement v = driver.findElement(By.xpath("//label[@for = 'inputAttributeStatus']"));
		v.click();
		Thread.sleep(3000);
		//boolean a = v.isSelected();
		System.out.println("Test " + v.getAttribute("innerHTML"));
		if (v.getAttribute("innerHTML").contentEquals("::after"))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		*/
		
		
		
	}

	

}
