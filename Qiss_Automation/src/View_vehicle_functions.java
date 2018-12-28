import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class View_vehicle_functions {
	
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static String precnt;
	
	public static File src;
	public static FileInputStream fis;
	public static XSSFWorkbook wb;
	public static XSSFSheet sh1;
	public static FileOutputStream fout;
	public static String file_location = "C:\\Users\\ritesh.jhaveri\\Documents\\Ritesh\\Qiss_Automation_Checklist.xlsx";
	
	View_Vehicle_Feature VF = new View_Vehicle_Feature();
	
	public void driver_login() throws InterruptedException, IOException 
	{
		
		//Specify the file path which you want to create or write
		src = new File("C:\\Users\\ritesh.jhaveri\\Documents\\Ritesh\\Qiss_Automation_Checklist.xlsx");
		
		// Load the file
		fis = new FileInputStream(src);
		
		// Load the workbook
		wb = new XSSFWorkbook(fis);
		
		// Get the sheet which you want to modify or create.
		sh1 = wb.getSheetAt(0);
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ritesh.jhaveri\\Documents\\Ritesh\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.get("https://qiss-test.quipment.nl/home");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		wait = new WebDriverWait(driver, 60);
	}
	
	public void login_ADFS() throws Exception 
	{
		
		WebElement uname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#userNameInput")));
		uname.sendKeys("ritesh.jhaveri@quipment.nl");
		
		WebElement pass = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#passwordInput")));
		pass.sendKeys("R!tesh@1989");
		
		WebElement submit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#submitButton")));
		submit.click();
		
		Thread.sleep(5000);
		WebElement vehicles = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href^='/Vehicle/ViewVehicle']")));
		vehicles.click();
		
	}
	
	public void verify_radio_data() throws Exception
	{
		
		try 
		{
			Thread.sleep(5000);
			sh1.getRow(44).createCell(3).setCellValue("PASS");
			fout = new FileOutputStream(file_location); 
			wb.write(fout);
		} 
		
		catch (Exception e) 
		{
			e.printStackTrace();
			sh1.getRow(44).createCell(3).setCellValue("FAIL");
			fout = new FileOutputStream(file_location); 
			wb.write(fout);
		}
		
		WebElement count = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span[class^='k-pager-info k-label']")));
		Thread.sleep(3000);
		precnt = count.getText();
		
		WebElement act =  wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("label[for = 'inputRadioActive']")));
		act.click();
		Thread.sleep(2000);
		
		WebElement loadcount_active = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span[class^='k-pager-info k-label']")));
		Thread.sleep(2000);
		
		//Verify that "Active" radio button is clickable or not
		
		try 
		{
			if (precnt.contentEquals(loadcount_active.getText()))
			{
				System.out.println(loadcount_active.getText());
				System.out.println("Active radio button clicked succesfully and data is loaded");
				sh1.getRow(45).createCell(3).setCellValue("PASS");
				fout = new FileOutputStream(file_location); 
				wb.write(fout);
			}
			else
			{
				System.out.println(precnt);
				System.out.println(loadcount_active.getText());
				System.out.println("Unable to click the Active radio button");
				sh1.getRow(45).createCell(3).setCellValue("FAIL");
				fout = new FileOutputStream(file_location); 
				wb.write(fout);
			}
			
			System.out.println("----------------------------------------");
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Verify that "With Product" radio button is clickable or not
		
		WebElement wp =  wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("label[for = 'inputRadioWithProducts']")));
		wp.click();
		Thread.sleep(2000);
		
		WebElement loadcount_wp = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span[class^='k-pager-info k-label']")));
		Thread.sleep(2000);
		System.out.println(loadcount_wp.getText());
		
		try 
		{
			if (loadcount_wp.getText()!=precnt)
			{
				System.out.println("With product radio button clicked succesfully and data is loaded");
				sh1.getRow(46).createCell(3).setCellValue("PASS");
				fout = new FileOutputStream(file_location); 
				wb.write(fout);
			}
			else
			{
				System.out.println("Unable to click the With product radio button");
				sh1.getRow(46).createCell(3).setCellValue("FAIL");
				fout = new FileOutputStream(file_location); 
				wb.write(fout);
			}
			
			System.out.println("----------------------------------------");
		} 
		
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Verify that "Without Product" radio button is clickable or not
		
		WebElement wop =  wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("label[for = 'inputRadioWithoutProducts']")));
		wop.click();
		Thread.sleep(2000);
		
		WebElement loadcount_wop = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span[class^='k-pager-info k-label']")));
		Thread.sleep(2000);
		System.out.println(loadcount_wop.getText());
		
		try 
		{
			if (loadcount_wop.getText()!=precnt)
			{
				System.out.println("Without products radio button clicked succesfully and data is loaded");
				sh1.getRow(47).createCell(3).setCellValue("PASS");
				fout = new FileOutputStream(file_location); 
				wb.write(fout);
			}
			else
			{
				System.out.println("Unable to click the Without products radio button");
				sh1.getRow(47).createCell(3).setCellValue("FAIL");
				fout = new FileOutputStream(file_location); 
				wb.write(fout);
			}
			
			System.out.println("----------------------------------------");
		} 
		
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		//Verify that "Deleted Vehicles" radio button is clickable or not
		
		WebElement dv =  wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("label[for = 'inputRadioDeletedVehicles']")));
		dv.click();
		Thread.sleep(2000);
		
		WebElement loadcount_dv = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span[class^='k-pager-info k-label']")));
		Thread.sleep(2000);
		System.out.println(loadcount_dv.getText());
		
		try 
		{
			
			if (loadcount_dv.getText()!=precnt)
			{
				System.out.println("Deleted Vehicles radio button clicked succesfully and data is loaded");
				sh1.getRow(48).createCell(3).setCellValue("PASS");
				fout = new FileOutputStream(file_location); 
				wb.write(fout);
			}
			else
			{
				System.out.println("Unable to click the Deleted Vehicles radio button");
				sh1.getRow(48).createCell(3).setCellValue("FAIL");
				fout = new FileOutputStream(file_location); 
				wb.write(fout);
			}
			
			System.out.println("----------------------------------------");
			
			try 
				{
					act.click();
					sh1.getRow(49).createCell(3).setCellValue("PASS");
					fout = new FileOutputStream(file_location); 
					wb.write(fout);
				
				} 
			catch (Exception e) 
				{
					sh1.getRow(49).createCell(3).setCellValue("FAIL");
					fout = new FileOutputStream(file_location); 
					wb.write(fout);
					e.printStackTrace();
				}
			
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/*-----Verify "Active" section feature working or not-----*/
	public void Active() throws Exception
	{
		
		Thread.sleep(2000);
		
		//Verify that data is succesfully filter with vehicle owner
 
		if (VF.filter_vo())
		{
			sh1.getRow(50).createCell(3).setCellValue("PASS");
			// here we need to specify where you want to save file
			fout = new FileOutputStream(file_location);
			// finally write content 
			wb.write(fout);
			
			}
		else
		{	
			sh1.getRow(50).createCell(3).setCellValue("FAIL");
			// here we need to specify where you want to save file
			fout = new FileOutputStream(file_location);
			// finally write content 
			wb.write(fout);
		}
		
		//Verify that data is succesfully filter with vehicle number

		if (VF.filter_vno())
		{
			sh1.getRow(51).createCell(3).setCellValue("PASS");
			// here we need to specify where you want to save file
			fout = new FileOutputStream(file_location);
			// finally write content 
			wb.write(fout);
			
		}
		else
		{
			sh1.getRow(51).createCell(3).setCellValue("FAIL");
			// here we need to specify where you want to save file
			fout = new FileOutputStream(file_location);
			// finally write content 
			wb.write(fout);
		}
		
		//Verify that Paging should work properly

		if (VF.page_nav())
		{
			sh1.getRow(52).createCell(3).setCellValue("PASS");
			// here we need to specify where you want to save file
			fout = new FileOutputStream(file_location);
			// finally write content 
			wb.write(fout);
		}
		else
		{
			sh1.getRow(52).createCell(3).setCellValue("FAIL");
			// here we need to specify where you want to save file
			fout = new FileOutputStream(file_location);
			// finally write content 
			wb.write(fout);
		}
		
		//Verify that items per page work properly

		if (VF.scroll())
		{
			sh1.getRow(53).createCell(3).setCellValue("PASS");
			// here we need to specify where you want to save file
			fout = new FileOutputStream(file_location);
			// finally write content 
			wb.write(fout);
		}
		else
		{
			sh1.getRow(53).createCell(3).setCellValue("FAIL");
			// here we need to specify where you want to save file
			fout = new FileOutputStream(file_location);
			// finally write content 
			wb.write(fout);
		}
		
		driver.navigate().refresh();
		Thread.sleep(5000);
		System.out.println("ACTIVE PASS");
		System.out.println("----------------------------------------");
		
	}
	
	/*-----Verify "With Products" section feature working or not-----*/
	
	public void WP() throws Exception
	{
		
		try 
		{
			WebElement wp =  wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("label[for = 'inputRadioWithProducts']")));
			wp.click();
			sh1.getRow(54).createCell(3).setCellValue("PASS");
			// here we need to specify where you want to save file
			fout = new FileOutputStream(file_location);
			// finally write content 
			wb.write(fout);
			
		} 
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			sh1.getRow(54).createCell(3).setCellValue("FAIL");
			// here we need to specify where you want to save file
			fout = new FileOutputStream(file_location);
			// finally write content 
			wb.write(fout);
			e.printStackTrace();
		}
		
		Thread.sleep(2000);
		
		//Verify that data is succesfully filter with vehicle owner

		if (VF.filter_vo())
		{
			sh1.getRow(55).createCell(3).setCellValue("PASS");
			// here we need to specify where you want to save file
			fout = new FileOutputStream(file_location);
			// finally write content 
			wb.write(fout);
		}
		
		else
		{
			sh1.getRow(55).createCell(3).setCellValue("FAIL");
			// here we need to specify where you want to save file
			fout = new FileOutputStream(file_location);
			// finally write content 
			wb.write(fout);
		}
	
		//Verify that data is succesfully filter with vehicle number

		if (VF.filter_vno())
		{
			sh1.getRow(56).createCell(3).setCellValue("PASS");
			// here we need to specify where you want to save file
			fout = new FileOutputStream(file_location);
			// finally write content 
			wb.write(fout);
		}
		
		else
		{
			sh1.getRow(56).createCell(3).setCellValue("FAIL");
			// here we need to specify where you want to save file
			fout = new FileOutputStream(file_location);
			// finally write content 
			wb.write(fout);
		}
	
		//Verify that Paging should work properly

		if (VF.page_nav())
		{
			sh1.getRow(57).createCell(3).setCellValue("PASS");
			// here we need to specify where you want to save file
			fout = new FileOutputStream(file_location);
			// finally write content 
			wb.write(fout);
		}
		
		else
		{
			sh1.getRow(57).createCell(3).setCellValue("FAIL");
			// here we need to specify where you want to save file
			fout = new FileOutputStream(file_location);
			// finally write content 
			wb.write(fout);
		}
	
		//Verify that items per page work properly

		if (VF.scroll())
		{
			sh1.getRow(58).createCell(3).setCellValue("PASS");
			// here we need to specify where you want to save file
			fout = new FileOutputStream(file_location);
			// finally write content 
			wb.write(fout);
		}
		
		else
		{
			sh1.getRow(58).createCell(3).setCellValue("FAIL");
			// here we need to specify where you want to save file
			fout = new FileOutputStream(file_location);
			// finally write content 
			wb.write(fout);
		}
		
			System.out.println("WP SCROLL PASS");
			driver.navigate().refresh();
			Thread.sleep(5000);
			System.out.println("WP PASS");
			System.out.println("----------------------------------------");
	}
	
	/*-----Verify "Without Products" section feature working or not-----*/
	
	public void WOP() throws Exception
	{
		
		Thread.sleep(5000);
		
		try 
		{
			WebElement wop =  wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("label[for = 'inputRadioWithoutProducts']")));
			wop.click();
			sh1.getRow(59).createCell(3).setCellValue("PASS");
			// here we need to specify where you want to save file
			fout = new FileOutputStream(file_location);
			// finally write content 
			wb.write(fout);
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			sh1.getRow(59).createCell(3).setCellValue("FAIL");
			// here we need to specify where you want to save file
			fout = new FileOutputStream(file_location);
			// finally write content 
			wb.write(fout);
		}
		Thread.sleep(2000);
		
		//Verify that data is successfully filter with vehicle owner
		
		if (VF.filter_vo())
		{
			sh1.getRow(60).createCell(3).setCellValue("PASS");
			// here we need to specify where you want to save file
			fout = new FileOutputStream(file_location);
			// finally write content 
			wb.write(fout);
		}
		
		else
		{
		
			sh1.getRow(60).createCell(3).setCellValue("FAIL");
			// here we need to specify where you want to save file
			fout = new FileOutputStream(file_location);
			// finally write content 
			wb.write(fout);
		}
		
		//Verify that data is successfully filter with vehicle number
		
		if (VF.filter_vno())
		{
			sh1.getRow(61).createCell(3).setCellValue("PASS");
			// here we need to specify where you want to save file
			fout = new FileOutputStream(file_location);
			// finally write content 
			wb.write(fout);
		}
		
		else
		{
			sh1.getRow(61).createCell(3).setCellValue("FAIL");
			// here we need to specify where you want to save file
			fout = new FileOutputStream(file_location);
			// finally write content 
			wb.write(fout);
		}
		
		//page_nav();
		
		//Verify that items per page should work properly
		
		if (VF.scroll())
		{
			sh1.getRow(62).createCell(3).setCellValue("PASS");
			// here we need to specify where you want to save file
			fout = new FileOutputStream(file_location);
			// finally write content 
			wb.write(fout);
		}
		
		else
		{
			sh1.getRow(62).createCell(3).setCellValue("FAIL");
			// here we need to specify where you want to save file
			fout = new FileOutputStream(file_location);
			// finally write content 
			wb.write(fout);
		}
		
			System.out.println("WOP SCROLL PASS");
			driver.navigate().refresh();
			Thread.sleep(5000);
			System.out.println("WOP PASS");
			System.out.println("----------------------------------------");
	}
	
	/*-----Verify "Delete Products" section feature working or not-----*/
	
	public void DV() throws Exception
	{
		
		try 
		{
			WebElement dv =  wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("label[for = 'inputRadioDeletedVehicles']")));
			dv.click();
			sh1.getRow(63).createCell(3).setCellValue("PASS");
			fout = new FileOutputStream(file_location);
			wb.write(fout);
		} 
		catch (Exception e)
		{
			sh1.getRow(63).createCell(3).setCellValue("FAIL");
			fout = new FileOutputStream(file_location);
			wb.write(fout);
			e.printStackTrace();
		}
		Thread.sleep(2000);
		
		//Verify that data is successfully filter with vehicle owner
		
		if (VF.filter_vo())
		{
			sh1.getRow(64).createCell(3).setCellValue("PASS");
			// here we need to specify where you want to save file
			fout = new FileOutputStream(file_location);
			// finally write content 
			wb.write(fout);
		}
		
		else
		{
		
			sh1.getRow(64).createCell(3).setCellValue("FAIL");
			// here we need to specify where you want to save file
			fout = new FileOutputStream(file_location);
			// finally write content 
			wb.write(fout);
		}
	
		//Verify that data is successfully filter with vehicle number
		
		if (VF.filter_vno())
		{
			sh1.getRow(65).createCell(3).setCellValue("PASS");
			// here we need to specify where you want to save file
			fout = new FileOutputStream(file_location);
			// finally write content 
			wb.write(fout);
		
		}
		
		else
		{
			sh1.getRow(65).createCell(3).setCellValue("FAIL");
			// here we need to specify where you want to save file
			 fout = new FileOutputStream(file_location);
			// finally write content 
			wb.write(fout);
		}
	
		//Verify that Paging should work properly
		
		if (VF.page_nav())
		{
			sh1.getRow(66).createCell(3).setCellValue("PASS");
			// here we need to specify where you want to save file
			 fout = new FileOutputStream(file_location);
			// finally write content 
			wb.write(fout);
		}
		
		else
		{
			sh1.getRow(66).createCell(3).setCellValue("FAIL");
			// here we need to specify where you want to save file
			 fout = new FileOutputStream(file_location);
			// finally write content 
			wb.write(fout);
		}
	
		//Verify that items per page work properly
		
		if (VF.scroll())
		{
			sh1.getRow(67).createCell(3).setCellValue("PASS");
			// here we need to specify where you want to save file
			 fout = new FileOutputStream(file_location);
			// finally write content 
			wb.write(fout);
		}
		
		else
		{
			sh1.getRow(67).createCell(3).setCellValue("FAIL");
			// here we need to specify where you want to save file
			 fout = new FileOutputStream(file_location);
			// finally write content 
			wb.write(fout);
		}
		
		driver.navigate().refresh();
		Thread.sleep(5000);
		System.out.println("----------------------------------------");
	}

}

	