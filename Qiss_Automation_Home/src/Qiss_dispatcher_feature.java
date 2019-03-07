import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.text.StrTokenizer;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

public class Qiss_dispatcher_feature extends Start_Qiss {
	
	public static WebDriver driver = null;
	/*public static WebDriverWait wait;*/
	
	/*public static File src;
	public static FileInputStream fis;
	public static XSSFWorkbook wb;
	public static XSSFSheet sh1;
	public static FileOutputStream fout;
	public static String file_location = "C:\\Users\\ritesh.jhaveri\\Documents\\Ritesh\\Qiss_Automation_Checklist.xlsx";*/
	public static String Count,record_count,dv_count;
	public Actions action;
	
	public static void login() throws Exception
		
	{
		
		src = new File (file_location);
			
		fis = new FileInputStream(src);
			
		wb = new XSSFWorkbook(fis);
			
		sh1 = wb.getSheetAt(0);
			
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ritesh.jhaveri\\Documents\\Ritesh\\chromedriver.exe");
			
		driver = new ChromeDriver();
			
		driver.get("https://qiss-test.quipment.nl/home");
			
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
		driver.manage().window().maximize();
			
		wait = new WebDriverWait(driver, 60);
			
	}
	
	/*Waiting for page load*/
	
	public static void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    @Override
					public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(Start_Qiss.driver, 30);
            wait.until(expectation);
        } catch (Throwable error) {
            System.out.println("Timeout waiting for Page Load Request complete.");
        }
    }
	
	public static void disp_login_adfs() throws Exception
	
	{
		
		Qiss_dispatcher_locators.uname(driver).sendKeys("ritesh.jhaveri@quipment.nl");
		Qiss_dispatcher_locators.pass(driver).sendKeys("R!tesh@1989");
		Qiss_dispatcher_locators.submit(driver).click();
		waitForPageLoaded();
		
		
	}
	
	public static void view_dis() throws Exception
	
	{
		Thread.sleep(2000);
		
		Count = Qiss_dispatcher_locators.count(Start_Qiss.driver).getText();
		
		if (Count != "0 - 00 of 000 items")
		{
			System.out.println("Dispatchers data counts is : " + Count);
			sh1.getRow(70).createCell(3).setCellValue("PASS");
			fout = new FileOutputStream(file_location); 
			wb.write(fout);
		}
		
		else
		{
			System.out.println("Dispatchers data might be not available.");
			sh1.getRow(70).createCell(3).setCellValue("FAIL");
			fout = new FileOutputStream(file_location); 
			wb.write(fout);
		}

	}

	public static void filter () throws Exception
	
	{
		Qiss_dispatcher_locators.filter_icon(Start_Qiss.driver).click();
		Qiss_dispatcher_locators.filter_data(Start_Qiss.driver).sendKeys("Insigno Quipment");
		Qiss_dispatcher_locators.filter_btn(Start_Qiss.driver).click();
		record_count = Qiss_dispatcher_locators.count(Start_Qiss.driver).getText();
		
		if (Count != record_count)
		{
			System.out.println("Data succesfully filter with Vehicle Number and count is : " + record_count);
			sh1.getRow(71).createCell(3).setCellValue("PASS");
			fout = new FileOutputStream(file_location); 
			wb.write(fout);
		}
		
		else
		{
			System.out.println("Not able to filter data");
			sh1.getRow(71).createCell(3).setCellValue("FAIL");
			fout = new FileOutputStream(file_location); 
			wb.write(fout);
		}
		
		Qiss_dispatcher_locators.filter_icon(Start_Qiss.driver).click();
		waitForPageLoaded();
		Qiss_dispatcher_locators.clear(Start_Qiss.driver).click();
		
	}
	
	public static void paging () throws Exception
	
	{
		waitForPageLoaded();
		Qiss_dispatcher_locators.page_3(Start_Qiss.driver).click();
		record_count = Qiss_dispatcher_locators.count(Start_Qiss.driver).getText();
		
		if (Count != record_count)
		{
			System.out.println("Page navigation worked succesfully : " + record_count);
			sh1.getRow(72).createCell(3).setCellValue("PASS");
			fout = new FileOutputStream(file_location); 
			wb.write(fout);
		}
		
		else
		{
			System.out.println("Failed in navigating the Page no 3");
			sh1.getRow(72).createCell(3).setCellValue("FAIL");
			fout = new FileOutputStream(file_location); 
			wb.write(fout);
		}
		
		Qiss_dispatcher_locators.scrol_btn(Start_Qiss.driver).click();
		waitForPageLoaded();
		Qiss_dispatcher_locators.click_30(Start_Qiss.driver).click();
		record_count = Qiss_dispatcher_locators.count(Start_Qiss.driver).getText();
		
		if (Count !=record_count)
		{
			System.out.println("Item per page loaded succesfully : " + record_count);
			sh1.getRow(73).createCell(3).setCellValue("PASS");
			fout = new FileOutputStream(file_location); 
			wb.write(fout);
		}
		
		else
		{
			System.out.println("Not able to load data as per item per page selected");
			sh1.getRow(73).createCell(3).setCellValue("FAIL");
			fout = new FileOutputStream(file_location); 
			wb.write(fout);
		}
		
		Qiss_dispatcher_locators.filter_icon(Start_Qiss.driver).click();
		Qiss_dispatcher_locators.filter_data(Start_Qiss.driver).sendKeys("Insigno Quipment");
		Qiss_dispatcher_locators.filter_btn(Start_Qiss.driver).click();
		waitForPageLoaded();
		
		
			
			Qiss_dispatcher_locators.navigate(Start_Qiss.driver).click();
			
			if (Start_Qiss.driver.findElement(By.className("page_heading")).getText().contentEquals("Maintain dispatcher"))
			{
			sh1.getRow(74).createCell(3).setCellValue("PASS");
			fout = new FileOutputStream(file_location); 
			wb.write(fout);
			}
			
			else
			{
			sh1.getRow(74).createCell(3).setCellValue("FAIL");
			fout = new FileOutputStream(file_location); 
			wb.write(fout);
			}
		
	}
	
	public static void maintain_dispathcher_validation () throws Exception
	
	{
			//Start_Qiss.driver.navigate().to("https://qiss-test.quipment.nl/Dispatcher/MaintainDispatcher/172");
			waitForPageLoaded();
			Qiss_dispatcher_locators.disp_name(Start_Qiss.driver).clear();
			Qiss_dispatcher_locators.qgate_id(Start_Qiss.driver).clear();
			Qiss_dispatcher_locators.disp_email(Start_Qiss.driver).clear();
			Qiss_dispatcher_locators.disp_email(Start_Qiss.driver).sendKeys("test@com");
			
			Actions action = new Actions(Start_Qiss.driver);
			WebElement we = Start_Qiss.driver.findElement(By.xpath("//*[@id='ACKOnly']"));
			action.moveToElement(we).moveToElement(Start_Qiss.driver.findElement(By.xpath("//*[@id='ACKOnly']"))).click().build().perform();
			
			Qiss_dispatcher_locators.confirm_btn(Start_Qiss.driver).click();
			waitForPageLoaded();
		
		if (Qiss_dispatcher_locators.dname_error(Start_Qiss.driver).getText().contentEquals("Dispatcher name is required.") &&
			Qiss_dispatcher_locators.qgate_id_error(Start_Qiss.driver).getText().contentEquals("QGate dispatcher ID is required.") &&
			Qiss_dispatcher_locators.disp_email_error(Start_Qiss.driver).getText().contentEquals("Please enter a valid e-mail address.") &&
			Qiss_dispatcher_locators.disp_rsa_exp_error(Start_Qiss.driver).getText().contentEquals("RSA key exponent parameter is required.") &&
			Qiss_dispatcher_locators.disp_rsa_mod_error(Start_Qiss.driver).getText().contentEquals("RSA key modulus parameter is required."))
		
			{
				System.out.println("Validation messages are shown");
				sh1.getRow(75).createCell(3).setCellValue("PASS");
				fout = new FileOutputStream(file_location); 
				wb.write(fout);
				action.moveToElement(we).moveToElement(Start_Qiss.driver.findElement(By.xpath("//*[@id='ACKOnly']"))).click().build().perform();
			}
		
		else
			{
				System.out.println("Validation messages are not shown");
				sh1.getRow(75).createCell(3).setCellValue("FAIL");
				fout = new FileOutputStream(file_location); 
				wb.write(fout);
			}
	}
	
	public static void maintain_dispathcher_data () throws Exception
	
	{
			Qiss_dispatcher_locators.disp_name(Start_Qiss.driver).sendKeys("INDIA");
			Qiss_dispatcher_locators.qgate_id(Start_Qiss.driver).sendKeys("T_test");
			Qiss_dispatcher_locators.disp_email(Start_Qiss.driver).clear();
			Qiss_dispatcher_locators.disp_email(Start_Qiss.driver).sendKeys("test@test.com");
			Qiss_dispatcher_locators.confirm_btn(Start_Qiss.driver).click();
			Thread.sleep(5000);
			
			Qiss_dispatcher_locators.navigate(Start_Qiss.driver).click();
			waitForPageLoaded();
		
		if (Qiss_dispatcher_locators.disp_name(Start_Qiss.driver).getAttribute("value").contentEquals("INDIA") &&
			Qiss_dispatcher_locators.qgate_id(Start_Qiss.driver).getAttribute("value").contentEquals("T_test") &&
			Qiss_dispatcher_locators.disp_email(Start_Qiss.driver).getAttribute("value").contentEquals("test@test.com")) 
			
			{
				System.out.println("Entered data saved succesfuly");
				sh1.getRow(76).createCell(3).setCellValue("PASS");
				fout = new FileOutputStream(file_location); 
				wb.write(fout);
			}
		
		else
			{
				System.out.println("Error in saving entered data");
				sh1.getRow(76).createCell(3).setCellValue("FAIL");
				fout = new FileOutputStream(file_location); 
				wb.write(fout);
			}
		
	}	
		
	public static void maintain_conn () throws Exception
	
	{
			/*Verify maintain connection popup open succesfully*/
			
			Qiss_dispatcher_locators.maintain_conn(Start_Qiss.driver).click();
		
		if (Start_Qiss.driver.findElement(By.id("ui-id-5")).getText().contentEquals("Maintain connections"))
		
		{
			System.out.println("Maintain connection popup opened succesfuly");
			sh1.getRow(77).createCell(3).setCellValue("PASS");
			fout = new FileOutputStream(file_location); 
			wb.write(fout);
		}
		else
		
		{
			System.out.println("Error in opening maintain connection popup");
			sh1.getRow(77).createCell(3).setCellValue("FAIL");
			fout = new FileOutputStream(file_location); 
			wb.write(fout);
		}
		
		/*Add dispatcher to vehicle*/
		
		Qiss_dispatcher_locators.ava_veh(Start_Qiss.driver).click();
		String available_vehicle = Qiss_dispatcher_locators.ava_veh(Start_Qiss.driver).getText();
		System.out.println(available_vehicle);
		String result = available_vehicle.replaceAll("[-]","");
		System.out.println(result);
		Qiss_dispatcher_locators.add_btn(Start_Qiss.driver).click();		
		
		try 
		{
			Qiss_dispatcher_locators.confirm(Start_Qiss.driver).click();
			sh1.getRow(78).createCell(3).setCellValue("PASS");
			fout = new FileOutputStream(file_location);
			wb.write(fout);
		} 
		catch (Exception e) 
		{
			sh1.getRow(78).createCell(3).setCellValue("FAIL");
			fout = new FileOutputStream(file_location);
			wb.write(fout);
			e.printStackTrace();
		}
		
		waitForPageLoaded();
		
		/*Edit the qgate unit id to "RJ-9777" */
		
		List<WebElement> elem = Start_Qiss.driver.findElements(By.xpath("//td[@role='gridcell']/input [@type='text']"));
		System.out.println(elem.size());
		
		for (WebElement loop1 : elem)
		{
			if (loop1.getAttribute("value").contentEquals(result))
			{
				loop1.clear();
				loop1.sendKeys("RJ-9777");
				System.out.println("Qgate unit id edited succesfully!");
				
				Actions action = new Actions(Start_Qiss.driver);
				WebElement we = Start_Qiss.driver.findElement(By.xpath("//*[@id='ConnectedVehiclesListGrid']/div[2]/div[1]/table/tbody/tr[1]/td[4]"));
				action.moveToElement(we).moveToElement(Start_Qiss.driver.findElement(By.xpath("//td[@class='gridTextCenter'][2]/label"))).click().build().perform();
				
				sh1.getRow(79).createCell(3).setCellValue("PASS");
				fout = new FileOutputStream(file_location);
				wb.write(fout);
				Qiss_dispatcher_locators.confirm_btn(Start_Qiss.driver).click();
				Thread.sleep(5000);
				Qiss_dispatcher_locators.navigate(Start_Qiss.driver).click();
				waitForPageLoaded();
				break;
			}
			
			else
			{
				sh1.getRow(79).createCell(3).setCellValue("FAIL");
				fout = new FileOutputStream(file_location);
				wb.write(fout);
			}
		}
		
		/*Verify dispatcher added to vehicle or not*/
		
		WebElement elem1 = Start_Qiss.driver.findElement(By.xpath("//td[@role='gridcell']/input [@type='text']"));
		
			
			if (elem1.getAttribute("value").contentEquals("rj9777"))
			{
				System.out.println("Dispatcher added successfully");
				sh1.getRow(80).createCell(3).setCellValue("PASS");
				fout = new FileOutputStream(file_location); 
				wb.write(fout);
				
			}	
			
			else
			{
				System.out.println("Error in adding Dispatcher..!");
				sh1.getRow(80).createCell(3).setCellValue("FAIL");
				fout = new FileOutputStream(file_location); 
				wb.write(fout);
			}
			
		
	
		/*Removing previous added dispatcher from vehicle*/
		
		Qiss_dispatcher_locators.maintain_conn(Start_Qiss.driver).click();
		
		List<WebElement> remove_elem = Start_Qiss.driver.findElements(By.cssSelector("#ConnectedVehicleList option"));
		
		for(WebElement loop : remove_elem) 
		{
			if (loop.getAttribute("innerHTML").contentEquals(available_vehicle))
			{
				System.out.println(loop.getAttribute("innerHTML"));
				loop.click();
				Qiss_dispatcher_locators.remove_btn(Start_Qiss.driver).click();
				Qiss_dispatcher_locators.confirm(Start_Qiss.driver).click();
				waitForPageLoaded();
				Qiss_dispatcher_locators.confirm_btn(Start_Qiss.driver).click();
				Thread.sleep(5000);
				Start_Qiss.driver.findElement(By.xpath("/html/body/div[6]/div[1]/button/span[1]")).click();
				Thread.sleep(5000);
				Qiss_dispatcher_locators.navigate(Start_Qiss.driver).click();	
				break;
			}
		}
		
		/*Verify dispatcher removed from vehicle or not*/
		
		WebElement elem2 = Start_Qiss.driver.findElement(By.xpath("//*[@id='ConnectedVehiclesListGrid']/div[2]/div[1]/table/tbody/tr/td"));
		
		System.out.println(elem2.getAttribute("innerHTML"));
	
			if (elem2.getAttribute("innerHTML").contentEquals("No records to display"))
			{
				System.out.println("Checking and found dispatcher is removed succesfully.");
				sh1.getRow(81).createCell(3).setCellValue("PASS");
				fout = new FileOutputStream(file_location);
				wb.write(fout);
				
			}	
			else
			{
				System.out.println("Error in removing dispatcher from vehicle");
				sh1.getRow(81).createCell(3).setCellValue("FAIL");
				fout = new FileOutputStream(file_location);
				wb.write(fout);
			}
	}
		
		
	public static void disp_view_his() throws Exception 
	{
		
		/*Verify Dispatcher vehicle connection history popup is open or not*/
		
		Qiss_dispatcher_locators.disp_his(Start_Qiss.driver).click();
		
		Thread.sleep(3000);
		
		String dh = "Dispatcher vehicle connection history";
		if ((wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.xpath("//span[@class= 'ui-dialog-title'][following::span][contains(text(),'Dispatcher vehicle connection history')]"))).getText().
				contentEquals(dh)))
			{
		
			System.out.println("Dispatcher vehicle connection history popup is shown");
			sh1.getRow(82).createCell(3).setCellValue("PASS");
			fout = new FileOutputStream(file_location);
			wb.write(fout);

			}
		else
			{
			System.out.println("Dispatcher vehicle connection history popup is not shown");
			sh1.getRow(82).createCell(3).setCellValue("FAIL");
			fout = new FileOutputStream(file_location);
			wb.write(fout);
			}
		
		Thread.sleep(2000);
		
		/*Verify that filter is working or not */
		
		if (Qiss_dispatcher_function.filter())
			{
				System.out.println("Data filter with Old value succesfully");
				sh1.getRow(83).createCell(3).setCellValue("PASS");
				fout = new FileOutputStream(file_location);
				wb.write(fout);
			}
		else
			{
				System.out.println("Error in filtering data with Old value");
				sh1.getRow(83).createCell(3).setCellValue("FAIL");
				fout = new FileOutputStream(file_location);
				wb.write(fout);
			}
		
		/*Verify that able to clear data from filter*/
		
		if (Qiss_dispatcher_function.clear())
			{
				System.out.println("Data cleared successfuly");
				sh1.getRow(84).createCell(3).setCellValue("PASS");
				fout = new FileOutputStream(file_location);
				wb.write(fout);
			}
		else
			{
				System.out.println("Error is clearing data");
				sh1.getRow(84).createCell(3).setCellValue("FAIL");
				fout = new FileOutputStream(file_location);
				wb.write(fout);
			}
		

		/*Verify that Item per page is working or not*/
		
		if (Qiss_dispatcher_function.item_page())
			{
				System.out.println("Navigating item per page succesfully");
				sh1.getRow(86).createCell(3).setCellValue("PASS");
				fout = new FileOutputStream(file_location);
				wb.write(fout);
			}
		else
			{
				System.out.println("Error is navigating item per page");
				sh1.getRow(86).createCell(3).setCellValue("FAIL");
				fout = new FileOutputStream(file_location);
				wb.write(fout);
			}
		
		/*Verify that paging is working or not*/
		
		if (Qiss_dispatcher_function.paging())
			{
				System.out.println("Paging worked succesfully");
				sh1.getRow(85).createCell(3).setCellValue("PASS");
				fout = new FileOutputStream(file_location);
				wb.write(fout);
			}
		else
			{
				System.out.println("Error is paging data");
				sh1.getRow(85).createCell(3).setCellValue("FAIL");
				fout = new FileOutputStream(file_location);
				wb.write(fout);
			}
		
		/*Click close button*/
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div[1]/button/span[1]"))).click();
		
		/*Verify View history popup*/ 
		
		Thread.sleep(3000);
		WebElement view_his = wait.until(ExpectedConditions.elementToBeClickable(By.id("viewHistory")));
		view_his.click();
		String vh = "View history";
		
		if ((wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class= 'ui-dialog-title'][following::span][contains(text(),'View history')]")))
				.getText().contentEquals(vh)))
			{
		
				System.out.println("View history popup is shown");
				sh1.getRow(87).createCell(3).setCellValue("PASS");
				fout = new FileOutputStream(file_location);
				wb.write(fout);
			}
		else
			{
		
				System.out.println("View history popup is not shown");
				sh1.getRow(87).createCell(3).setCellValue("FAIL");
				fout = new FileOutputStream(file_location);
				wb.write(fout);
			}
		
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[1]/button/span[1]"))).click();
		
		}
	
	
}
	
	
	
