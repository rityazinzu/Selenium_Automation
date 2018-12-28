package org.apache.commons.io;

import java.io.File;
import java.io.FileFilter;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class download {
	
	private WebDriver driver;
	
	private static String downloadPath = "C:\\selenium";
	private String URL="https://qiss-test.quipment.nl/Dispatcher/ViewDispatcher"; 
	
	@BeforeClass
	public void testSetup() throws Exception{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ritesh.jhaveri\\Documents\\Ritesh\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement username=driver.findElement(By.id("userNameInput"));
		WebElement passwordname=driver.findElement(By.id("passwordInput"));
	
		Thread.sleep(3000);
		
		username.sendKeys("ritesh.jhaveri@quipment.nl");
		passwordname.sendKeys("R!tesh@1989");
		
		WebElement submitButton=driver.findElement(By.id("submitButton"));
		submitButton.click();
		Thread.sleep(5000);
		
	}
	
	@Test
	public void example_VerifyDownloadWithFileName() throws InterruptedException  {
		driver.get(URL);
		Thread.sleep(5000);
		driver.findElement(By.id("exportPdf")).click();
	    Assert.assertTrue(isFileDownloaded(downloadPath, "ViewDispatcher"), "Failed to download Expected document");
	}
	
        @Test
	public void example_VerifyDownloadWithFileExtension() throws InterruptedException  {
		driver.get(URL);
		Thread.sleep(5000);
		driver.findElement(By.id("exportPdf")).click();
	    Assert.assertTrue(isFileDownloaded_Ext(downloadPath, ".pdf"), "Failed to download document which has extension .xls");
	}

	@Test
	public void example_VerifyExpectedFileName() throws InterruptedException {
		driver.get(URL);
		Thread.sleep(5000);
		driver.findElement(By.id("exportPdf")).click();
	    File getLatestFile = getLatestFilefromDir(downloadPath);
	    String fileName = getLatestFile.getName();
	    Assert.assertTrue(fileName.equals("ViewDispatcher"), "Downloaded file name is not matching with expected file name");
	}
	

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public boolean isFileDownloaded(String downloadPath, String fileName) {
		boolean flag = false;
	    File dir = new File(downloadPath);
	    File[] dir_contents = dir.listFiles();
	  	    
	    for (int i = 0; i < dir_contents.length; i++) {
	        if (dir_contents[i].getName().equals(fileName))
	            return flag=true;
	            }

	    return flag;
	}
	
	private boolean isFileDownloaded_Ext(String dirPath, String ext){
		boolean flag=false;
	    File dir = new File(dirPath);
	    File[] files = dir.listFiles();
	    if (files == null || files.length == 0) {
	        flag = false;
	    }
	    
	    for (int i = 1; i < files.length; i++) {
	    	if(files[i].getName().contains(ext)) {
	    		flag=true;
	    	}
	    }
	    return flag;
	}
	
	/* Get the latest file from a specific directory*/
	private File getLatestFilefromDir(String dirPath){
	    File dir = new File(dirPath);
	    File[] files = dir.listFiles();
	    if (files == null || files.length == 0) {
	        return null;
	    }
	
	    File lastModifiedFile = files[0];
	    for (int i = 1; i < files.length; i++) {
	       if (lastModifiedFile.lastModified() < files[i].lastModified()) {
	           lastModifiedFile = files[i];
	       }
	    }
	    return lastModifiedFile;
	}
}
	
	