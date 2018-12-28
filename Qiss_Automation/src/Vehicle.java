import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Vehicle  {
	
	public ChromeOptions options;
	public static  WebDriver driver;
	public JavascriptExecutor js;
	public Actions action;
	public static WebDriverWait wait;
	public static File src;
	public static FileInputStream fis;
	public static XSSFWorkbook wb;
	public static XSSFSheet sh1;
	public static FileOutputStream fout;
	public static String file_location = "C:\\Users\\ritesh.jhaveri\\Documents\\Ritesh\\Qiss_Automation_Checklist.xlsx";
	
	
	public void call_driver() throws InterruptedException, IOException 
	{
		
		//Specify the file path which you want to create or write
		src = new File("C:\\Users\\ritesh.jhaveri\\Documents\\Ritesh\\Qiss_Automation_Checklist.xlsx");
		
		// Load the file
		fis = new FileInputStream(src);
		
		// Load the workbook
		wb = new XSSFWorkbook(fis);
		
		// Get the sheet which you want to modify or create.
		sh1 = wb.getSheetAt(0);
		
		/*Set drivers path*/
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ritesh.jhaveri\\Documents\\Ritesh\\chromedriver.exe");		
		
		options = new ChromeOptions();
		options.addArguments("disable-infobars");
		
		driver = new ChromeDriver(options);
		
		wait = new WebDriverWait(driver, 60);
		
		/*Set Firefox Headless mode as TRUE*/
		
		/*Running the script without opening browser by setting setheadless to true.*/
		
		/*ChromeOptions options = new ChromeOptions();
		options.setHeadless(true);*/
	}
	
	public void URL() throws InterruptedException, IOException 
	{
		driver.get("https://qiss-test.quipment.nl/home");
		
		/*Specify implicit wait of 30 seconds*/                                   
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		/*To Maximize Browser Window*/
		driver.manage().window().maximize();
		
		/*Getting current URL and title */
		System.out.println(driver.getCurrentUrl());
		if (driver.getTitle().contentEquals("Sign In"))
		{
			System.out.println("ADFS Login page is loaded succesfully.");
			sh1.getRow(12).createCell(3).setCellValue("PASS");
			// here we need to specify where you want to save file
			 fout = new FileOutputStream(file_location);
			// finally write content 
			wb.write(fout);
			
		}
		else
		{
			System.out.println("ADFS Login page is not loaded succesfully.");
			sh1.getRow(12).createCell(3).setCellValue("FAIL");
			// here we need to specify where you want to save file
			 fout = new FileOutputStream(file_location);
			// finally write content 
			wb.write(fout);
			
		}
	}
	
	public void login() throws InterruptedException, IOException 
	{
		try {
			WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userNameInput")));
			WebElement passwordname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("passwordInput")));
			WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("submitButton")));
			
			
				/*Logging with valid credentials */
				username.sendKeys("ritesh.jhaveri@quipment.nl");
				passwordname.sendKeys("R!tesh@1989");
			
			
			submitButton.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		/*Getting current URL and title */
		try {
			System.out.println(driver.getCurrentUrl());
			System.out.println(driver.getTitle());
			if (driver.getTitle().contentEquals("QISS"))
			{
				System.out.println("Login succesfully.");
				sh1.getRow(13).createCell(3).setCellValue("PASS");
				// here we need to specify where you want to save file
				 fout = new FileOutputStream(file_location);
				// finally write content 
				wb.write(fout);
				
			}
			else
			{
				System.out.println("Login was not succesfully due to Invalid credentials.");
				sh1.getRow(13).createCell(3).setCellValue("FAIL");
				// here we need to specify where you want to save file
				 fout = new FileOutputStream(file_location);
				// finally write content 
				wb.write(fout);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/*public void login_excel_data() throws InterruptedException, IOException 
	{
		
		Getting header and logging with invalid credentials 
		try {
			WebElement label=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("header")));
			System.out.println(label.getText());	
			WebElement loginmessage=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginMessage")));
			System.out.println(loginmessage.getText());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Locator not Found/Visible.!");
			e.printStackTrace();
		}
		
		username.sendKeys("abc");
		passwordname.sendKeys("abc");
		submitButton.click();
		captureScreenShot(driver);
		
		Verify the error message 
		WebElement error=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("errorText")));
		System.out.println("Error - " + error.getText());
		
		Logging with valid credentials 
		username.clear();
		passwordname.clear();
		
		// Specify the path of file
		// Load sheet- Here we are loading first sheetonly
		
		try {
			File src = new File("C:\\test data\\test_data.xlsx");

			// load file
			FileInputStream fis = new FileInputStream(src);

			// Load workbook
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			sh1 = wb.getSheetAt(1);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to access file.!");
			e.printStackTrace();
		}
		
		DataFormatter formatter = new DataFormatter();
		String rj = "QISS";
		int cnt = 0;
		for (int i = 0; i <= sh1.getLastRowNum(); i++)

		{
			String username1 = (formatter.formatCellValue(sh1.getRow(i).getCell(0)));
			String password1 = (formatter.formatCellValue(sh1.getRow(i).getCell(1)));

			WebElement username=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userNameInput")));
			WebElement passwordname=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("passwordInput")));
			WebElement submitButton=wait.until(ExpectedConditions.elementToBeClickable(By.id("submitButton")));
		
			username.sendKeys(username1);
			passwordname.sendKeys(password1);
			submitButton.click();
			Thread.sleep(5000);
			//captureScreenShot(driver);
			
			
			if (driver.getTitle().contentEquals(rj))
			{	
				
			Getting current URL and title 
			//System.out.println(driver.getCurrentUrl());
			//System.out.println(driver.getTitle());
			System.out.println("Login succesfully.!!!");
			
			break;
			}
			else
			{
				cnt++;
				System.out.println("Login attempt tried count is - " + cnt);
				username.clear();
				passwordname.clear();
			}	
		}
	
			
			String blank = "Enter your user ID in the format \"domain\\user\" or \"user@domain\".";
			String invalid_pwd = "Enter your password.";
			String invalid_data = "Incorrect user ID or password. Type the correct user ID and password, and try again.";
			
		WebElement validate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("errorText")));
		String verify = validate.getText();
		System.out.println(verify);
		
		if (verify.contentEquals(blank))
		{
			System.out.println("1");
		}
		else if (verify.contentEquals(invalid_pwd))
		{
			System.out.println("2");
		}
		
		else if (verify.contentEquals(invalid_data))
		{
			System.out.println("3");
		}
	}	
		
		if (driver.getTitle().contentEquals(rj))
		{	
			
		Getting current URL and title 
		//System.out.println(driver.getCurrentUrl());
		//System.out.println(driver.getTitle());
		System.out.println("Login succesfully.!!!");
		break;
		}
		else
		{
			cnt++;
			System.out.println("Login attempt tried count is - " + cnt);
			username.clear();
			passwordname.clear();
		}	
	}
}

*/
	public void search() throws InterruptedException, IOException 
	{
		wait = new WebDriverWait(driver, 75);
		
		/*Enter and search for vehicle number 9898 */ 
		
		//Thread.sleep(30000);
		
		try {
			WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("SearchTextName")));
			search.sendKeys("9898");
			sh1.getRow(14).createCell(3).setCellValue("PASS");
			// here we need to specify where you want to save file
			 fout = new FileOutputStream(file_location);
			// finally write content 
			wb.write(fout);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			sh1.getRow(14).createCell(3).setCellValue("FAIL");
			// here we need to specify where you want to save file
			 fout = new FileOutputStream(file_location);
			// finally write content 
			wb.write(fout);
			e.printStackTrace();
		}
		
		WebElement vehicle = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/Vehicle/ViewVehicle']")));
		vehicle.click();
		System.out.println(driver.getCurrentUrl());
		
		/*Click arrow to visit vehicle maintain page */	
		//Thread.sleep(8000);
		 
		
		//WebElement arrow = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ViewVehicleGrid']/div[4]/div[1]/table/tbody/tr/td[2]/a")));
		//arrow.click();
		
		try
		{
		
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ViewVehicleGrid']/div[4]/div[1]/table/tbody/tr/td[2]/a")));
			 
			WebElement arrow = driver.findElement(By.xpath("//*[@class='k-hierarchy-cell']//following::td[1]/a"));
			Thread.sleep(3000);
			arrow.click();  
		/*WebElement arrow = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ViewVehicleGrid']/div[4]/div[1]/table/tbody/tr/td[2]/a")));
			arrow.click();*/
			sh1.getRow(15).createCell(3).setCellValue("PASS");
			// here we need to specify where you want to save file
			 fout = new FileOutputStream(file_location);
			// finally write content 
			wb.write(fout);
		 
		}
		catch (TimeoutException toe)
			{
			 
			System.out.println("Element is not visible.!");
			sh1.getRow(15).createCell(3).setCellValue("FAIL");
			// here we need to specify where you want to save file
			 fout = new FileOutputStream(file_location);
			// finally write content 
			wb.write(fout);
			
			
			} 
		 
		//Thread.sleep(6000);
		System.out.println(driver.getCurrentUrl()); 
		System.out.println("Maintain Vehicle Page open succesfully.");
	}
	

	
	public void data() throws InterruptedException, IOException 
	{


		//captureScreenShot(driver);
		/*Display maintain vehicle page data from different elements */
		
		/* Displaying vehicle owner */
		try {
			WebElement vehicleowner = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("companyHyperLink")));
			System.out.println("Vehicle Owner - " + vehicleowner.getText());
			
			/* Displaying vehicle number */
			WebElement vehiclenumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("voertuignummer")));
			System.out.println("Vehicle Number - " + vehiclenumber.getAttribute("value"));
			
			/* Displaying Chassis number */
			WebElement chasssino = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("chassisnummer")));
			System.out.println("Chassis Number - " + chasssino.getAttribute("value"));
			
			/* Displaying License plate */
			WebElement Licenseplate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("kenteken")));
			System.out.println("License Plate - " + Licenseplate.getAttribute("value"));
			
			/* Displaying Software adopter type value from dropdown list */
			WebElement soft_xp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@aria-owns='ddlSoftwareAdopterType_listbox']")));
			System.out.println("Already selected Soft Adopter Type - " + soft_xp.getText());
			
			/* Click Software adopter type dropdown list */
			WebElement soft_xpc = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@aria-owns='ddlSoftwareAdopterType_listbox']")));
			soft_xpc.click();
			
			/* Getting data from Software adopter type dropdown list  */
			WebElement soft_beta = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='ddlSoftwareAdopterType-list']/div/ul/li[1]")));
			System.out.println("Soft adopter Type - " + soft_beta.getText());
			
			WebElement soft_final = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='ddlSoftwareAdopterType-list']/div/ul/li[2]")));
			System.out.println("Soft adopter Type - " + soft_final.getText());
			
			WebElement soft_pilot = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='ddlSoftwareAdopterType-list']/div/ul/li[3]")));
			Thread.sleep(2000);
			soft_xpc.sendKeys("Pilot");
			//driver.findElement((By.xpath("//span[@aria-owns='ddlSoftwareAdopterType_listbox']"))).sendKeys("Pilot");
			System.out.println("Soft adopter Type - " + soft_pilot.getText());
			
			sh1.getRow(16).createCell(3).setCellValue("PASS");
			// here we need to specify where you want to save file
			 fout = new FileOutputStream(file_location);
			// finally write content 
			wb.write(fout);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Locator not Found/Visible.!");
			e.printStackTrace();
			sh1.getRow(16).createCell(3).setCellValue("FAIL");
			// here we need to specify where you want to save file
			 fout = new FileOutputStream(file_location);
			// finally write content 
			wb.write(fout);
		}
		
		/* Click other side */
		wait.until(ExpectedConditions.elementToBeClickable(By.id("tabContents"))).click();
		
		Thread.sleep(5000);
		
		/* Click Logging dropdown list */
		WebElement log_click=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@aria-owns='ddlExtendedLogging_listbox']")));
		log_click.click();
		
		Thread.sleep(2000);
		
		/* Getting data from Logging dropdown list  */
		try {
			WebElement log_emg=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id ='ddlExtendedLogging-list']/div/ul/li[1]")));
			System.out.println("Logging Type - " + log_emg.getText());
			
			WebElement log_alert=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id ='ddlExtendedLogging-list']/div/ul/li[2]")));
			System.out.println("Logging Type - " + log_alert.getText());
			
			WebElement log_crc=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id ='ddlExtendedLogging-list']/div/ul/li[3]")));
			System.out.println("Logging Type - " + log_crc.getText());
			
			WebElement log_err=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id ='ddlExtendedLogging-list']/div/ul/li[4]")));
			System.out.println("Logging Type - " + log_err.getText());
			
			WebElement log_war=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id ='ddlExtendedLogging-list']/div/ul/li[5]")));
			System.out.println("Logging Type - " + log_war.getText());
			
			WebElement log_not=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id ='ddlExtendedLogging-list']/div/ul/li[6]")));
			System.out.println("Logging Type - " + log_not.getText());
			
			WebElement log_info=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id ='ddlExtendedLogging-list']/div/ul/li[7]")));
			System.out.println("Logging Type - " + log_info.getText());
			
			WebElement log_deb=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id ='ddlExtendedLogging-list']/div/ul/li[8]")));
			System.out.println("Logging Type - " + log_deb.getText());
			
			sh1.getRow(17).createCell(3).setCellValue("PASS");
			// here we need to specify where you want to save file
			 fout = new FileOutputStream(file_location);
			// finally write content 
			wb.write(fout);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Locator not Found/Visible.!");
			sh1.getRow(17).createCell(3).setCellValue("FAIL");
			// here we need to specify where you want to save file
			fout = new FileOutputStream(file_location);
			// finally write content 
			wb.write(fout);
			e.printStackTrace();
		}
		
		//Thread.sleep(5000);
		
		/* Click other side */
		wait.until(ExpectedConditions.elementToBeClickable(By.id("tabContents"))).click();
		
		//Thread.sleep(2000);
		
		/* Displaying K value */
		try {
			WebElement kvalue=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Constant")));
			System.out.println("K value - " + kvalue.getAttribute("value"));
			
			/* Displaying Tarrif set value from dropdown list */
			WebElement tariff=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@aria-owns='TariffSetID_listbox']")));
			System.out.println("Current Tariff Type is - " + tariff.getText());
			
			/* Click Tarrif set dropdown list */
			WebElement tariff_click=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@aria-owns='TariffSetID_listbox']")));
			tariff_click.click();
			
			//Thread.sleep(2000);
			
			/* Getting data from Tarrif set dropdown list  */
			WebElement tariff_def=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id ='TariffSetID-list']/div/ul/li[1]")));
			System.out.println("Tariffset - " + tariff_def.getText());
			
			WebElement tariff_pt=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id ='TariffSetID-list']/div/ul/li[2]")));
			System.out.println("Tariffset - " + tariff_pt.getText());
			
			WebElement tariff_ft=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id ='TariffSetID-list']/div/ul/li[3]")));
			System.out.println("Tariffset - " + tariff_ft.getText());
			
			WebElement tariff_aj=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id ='TariffSetID-list']/div/ul/li[4]")));
			System.out.println("Tariffset - " + tariff_aj.getText());
			
			sh1.getRow(18).createCell(3).setCellValue("PASS");
			// here we need to specify where you want to save file
			fout = new FileOutputStream(file_location);
			// finally write content 
			wb.write(fout);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Locator not Found/Visible.!");
			sh1.getRow(18).createCell(3).setCellValue("FAIL");
			// here we need to specify where you want to save file
			fout = new FileOutputStream(file_location);
			// finally write content 
			wb.write(fout);
			e.printStackTrace();
		}
		
		//Thread.sleep(2000);
		
		/* Click other side */
		wait.until(ExpectedConditions.elementToBeClickable(By.id("tabContents"))).click();
		
		try {
			/* Displaying payment type value from dropdown list */
			WebElement payment=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@aria-owns='PaymentTypeId_listbox']")));
			System.out.println("Current Payment Type - " + payment.getText());
			
			/* Click payment type dropdown list */
			WebElement pay_click=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@aria-owns='PaymentTypeId_listbox']")));
			pay_click.click();
			
			//Thread.sleep(2000);
			
			/* Getting data from Payment type list  */
			WebElement pay_dis=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id ='PaymentTypeId-list']/div/ul/li[1]")));
			System.out.println("Payment Type - " + pay_dis.getText());
			
			WebElement pay_ady=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id ='PaymentTypeId-list']/div/ul/li[2]")));
			System.out.println("Payment Type - " + pay_ady.getText());
			
			WebElement pay_sumup=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id ='PaymentTypeId-list']/div/ul/li[3]")));
			System.out.println("Payment Type - " + pay_sumup.getText());
			
			WebElement pay_sumupair=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id ='PaymentTypeId-list']/div/ul/li[4]")));
			System.out.println("Payment Type - " + pay_sumupair.getText());
			
			sh1.getRow(19).createCell(3).setCellValue("PASS");
			// here we need to specify where you want to save file
			fout = new FileOutputStream(file_location);
			// finally write content 
			wb.write(fout);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Locator not Found/Visible.!");
			sh1.getRow(19).createCell(3).setCellValue("FAIL");
			// here we need to specify where you want to save file
			fout = new FileOutputStream(file_location);
			// finally write content 
			wb.write(fout);
			e.printStackTrace();
		}
		
		//Thread.sleep(2000);
		
		/* Click other side */
		wait.until(ExpectedConditions.elementToBeClickable(By.id("tabContents"))).click();
		
		//Thread.sleep(2000);
		
		try {
			/* Displaying dashboard odometer value from dropdown list */
			WebElement odo=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@aria-owns='DashboardOdometer_listbox']")));
			System.out.println("Current dashboard odometer - " + odo.getText());
			
			/* Click dashboard odometer dropdown list */
			WebElement odo_click=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@aria-owns='DashboardOdometer_listbox']")));
			odo_click.click();
			
			//Thread.sleep(2000);
			
			/* Getting data from dashboard odometer list  */
			WebElement disable=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id ='DashboardOdometer-list']/div/ul/li[1]")));
			System.out.println("Dashboard odometer - " + disable.getText());
			
			WebElement el=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id ='DashboardOdometer-list']/div/ul/li[2]")));
			System.out.println("Dashboard odometer - " + el.getText());
			
			WebElement ell=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id ='DashboardOdometer-list']/div/ul/li[3]")));
			System.out.println("Dashboard odometer - " + ell.getText());
			
			WebElement elo=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id ='DashboardOdometer-list']/div/ul/li[4]")));
			System.out.println("Dashboard odometer - " + elo.getText());
			
			sh1.getRow(20).createCell(3).setCellValue("PASS");
			// here we need to specify where you want to save file
			fout = new FileOutputStream(file_location);
			// finally write content 
			wb.write(fout);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Locator not Found/Visible.!");
			sh1.getRow(20).createCell(3).setCellValue("FAIL");
			// here we need to specify where you want to save file
			fout = new FileOutputStream(file_location);
			// finally write content 
			wb.write(fout);
			e.printStackTrace();
		}
		
		//Thread.sleep(2000);
		
		/* Click other side */
		wait.until(ExpectedConditions.elementToBeClickable(By.id("tabContents"))).click();
		
		//Thread.sleep(2000);
		
		try {
			/* Displaying PingTimeout */
			WebElement pg_time=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("PingTimeout")));
			System.out.println("Ping Timeout - " + pg_time.getAttribute("value"));
			
			/* Displaying Ping Retries */
			WebElement pg_rt=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("PingRetries")));
			System.out.println("Ping Retries - " + pg_rt.getAttribute("value"));
			
			/* Displaying Radius */
			WebElement rad=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("DesignatedAreaRadius")));
			System.out.println("Radius - " + rad.getAttribute("value"));
			
			/* Displaying Stationarytime */
			WebElement Stationarytime=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("DesignatedAreaStationaryTime")));
			System.out.println("Stationary time - " + Stationarytime.getAttribute("value"));
			
			/* Displaying Printer check value */
			WebElement printercheck=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='k-switch-container km-switch-container']")));
			System.out.println("Printer Check - " + printercheck.getText());
			
			sh1.getRow(21).createCell(3).setCellValue("PASS");
			// here we need to specify where you want to save file
			fout = new FileOutputStream(file_location);
			// finally write content 
			wb.write(fout);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Locator not Found/Visible.!");
			sh1.getRow(21).createCell(3).setCellValue("FAIL");
			// here we need to specify where you want to save file
			fout = new FileOutputStream(file_location);
			// finally write content 
			wb.write(fout);
			e.printStackTrace();
		}
		
		/* Enabled Printer check to "Yes" */
		String r = "YES";
		Thread.sleep(2000);
		if(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='IsDisplayPrinterChecked']//following::span[contains(text(),'YES')][1]"))).getText().contentEquals(r))
		{	
			System.out.println("Already Printer check option is enabled.");
			//captureScreenShot(driver);
			sh1.getRow(22).createCell(3).setCellValue("PASS");
			// here we need to specify where you want to save file
			fout = new FileOutputStream(file_location);
			// finally write content 
			wb.write(fout);
		}
		else
			{
			WebElement print_change = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='IsDisplayPrinterChecked']//following::span[contains(text(),'NO')][1]")));
			print_change.click();
			sh1.getRow(22).createCell(3).setCellValue("PASS");
			// here we need to specify where you want to save file
			fout = new FileOutputStream(file_location);
			// finally write content 
			wb.write(fout);
			}	
		
		//Thread.sleep(2000);
		
		/* Click other side */
		wait.until(ExpectedConditions.elementToBeClickable(By.id("tabContents"))).click();
		
		/*WebElement printerchange=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.table:nth-child(1) > div:nth-child(1) > div:nth-child(15) > div:nth-child(2) > span:nth-child(1) > span:nth-child(3) > span:nth-child(1) > span:nth-child(1)"));
		System.out.println("Printer Check - " + printerchange.getText());*/
		
		try {
			/* Enabled/Disabled TM check*/
			WebElement tm_click=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class = 'k-switch-label-off km-switch-label-off']//following::span[32]")));
			tm_click.click();
			
			/* Click other side */
			wait.until(ExpectedConditions.elementToBeClickable(By.id("tabContents"))).click();
			
			/* Enabled/Disabled Navigation */
			WebElement nav=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class = 'k-switch-label-off km-switch-label-off']//following::span[7]")));
			nav.click();
			
			/* Click other side */
			wait.until(ExpectedConditions.elementToBeClickable(By.id("tabContents"))).click();
			
			/* Enabled/Disabled Remove NAT */
			WebElement nat_click=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class = 'k-switch-label-off km-switch-label-off']//following::span[15]")));
			nat_click.click();
			
			sh1.getRow(23).createCell(3).setCellValue("PASS");
			// here we need to specify where you want to save file
			fout = new FileOutputStream(file_location);
			// finally write content 
			wb.write(fout);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Locator not Found/Visible.!");
			sh1.getRow(23).createCell(3).setCellValue("FAIL");
			// here we need to specify where you want to save file
			fout = new FileOutputStream(file_location);
			// finally write content 
			wb.write(fout);
			e.printStackTrace();
		}
		
		/* Click other side */
		try {
			wait.until(ExpectedConditions.elementToBeClickable(By.id("tabContents"))).click();
			
			js = (JavascriptExecutor) driver;
			// This  will scroll down the page by  1000 pixel vertical
			js.executeScript("window.scrollBy(0,2000)");
			
			/* Click auto brightness drop down list */
			WebElement bright_click=wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#MaintainVehicleForm > div.grid_results2 > div.li2.li2_margin > div.maintain_user_content_main_box > div:nth-child(1) > div:nth-child(2) > div:nth-child(15) > div.secondcolumn > span > span > span.k-select")));
			bright_click.click();
			
			/* Click other side */
			wait.until(ExpectedConditions.elementToBeClickable(By.id("tabContents"))).click();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Locator not Found/Visible.!");
			e.printStackTrace();
		}
		
		
	}
	
	public void dis_info() throws InterruptedException, IOException 
	{

	/*Get Connected dispatcher info */
	
	try {
		/* Displaying Dispatcher name */
		System.out.println("Displaying Dispatcher Info");
		WebElement dispname=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ConnectedDispatcherListGrid']/div[2]/div[1]/table/tbody/tr[1]/td[1]/label")));
		System.out.println("Dispatcher Name - " + dispname.getText());
		
		/* Displaying Qgate ID */
		WebElement qgateid=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("QGateMobileId65")));
		System.out.println("Qgate ID - " + qgateid.getAttribute("value"));
		
		/* Display device information Product name | Serial Number | Activated Status - Yes */
		
		System.out.println("Displaying Product name, Serial Number, Activated Status.!!");
		WebElement bct_info=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ViewInstallProductsList']/table/tbody/tr/td[2]")));
		System.out.println("Product name - " + bct_info.getText());
		
		WebElement serial_no=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ViewInstallProductsList']/table/tbody/tr/td[4]")));
		System.out.println("Serial Number - " + serial_no.getText());
		
		WebElement activated=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ViewInstallProductsList']/table/tbody/tr/td[8]")));
		System.out.println("Activated Status - " + activated.getText());
		
		sh1.getRow(24).createCell(3).setCellValue("PASS");
		// here we need to specify where you want to save file
		fout = new FileOutputStream(file_location);
		// finally write content 
		wb.write(fout);
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println("Locator not Found/Visible.!");
		e.printStackTrace();
		sh1.getRow(24).createCell(3).setCellValue("FAIL");
		// here we need to specify where you want to save file
		fout = new FileOutputStream(file_location);
		// finally write content 
		wb.write(fout);
	}
	//captureScreenShot(driver);
	
	}	
	
	public void uninstall() throws InterruptedException 
	{
	/* Uninstall the device */
	
	System.out.println("Uninstalling Display unit.!!");
	try {
		WebElement locate=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ViewInstallProductsList']/table/tbody/tr/td[8]")));
		
		/* Right click on Yes button on activated tab*/
		
		action = new Actions(driver).contextClick(locate);
		action.build().perform();
		
		/* Click on uninstall button */
		try {
			WebElement click_uninstall=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#divContextMenuUninstall")));
			//Thread.sleep(2000);
			click_uninstall.click();
			sh1.getRow(25).createCell(3).setCellValue("PASS");
			// here we need to specify where you want to save file
			fout = new FileOutputStream(file_location);
			// finally write content 
			wb.write(fout);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("---------->>> DU is not installed! <<<----------");
			sh1.getRow(25).createCell(3).setCellValue("FAIL");
			// here we need to specify where you want to save file
			fout = new FileOutputStream(file_location);
			// finally write content 
			wb.write(fout);
			e.printStackTrace();
		}
		//Thread.sleep(5000);
		
		/* Click on Yes button on confirmation popup */
		try {
			WebElement click_yes=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-dialog-buttonset']//button[contains(text(),'Yes')]")));
			Thread.sleep(5000);
			click_yes.click();
			//captureScreenShot(driver);
			
			Thread.sleep(5000);
			
			System.out.println("Uninstalling PB.!!");
			WebElement locate1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ViewInstallProductsList']/table/tbody/tr/td[7]")));
			
			/* Right click on Yes button on activated tab*/
			
			action = new Actions(driver).contextClick(locate1);
			action.build().perform();
			
			sh1.getRow(26).createCell(3).setCellValue("PASS");
			// here we need to specify where you want to save file
			fout = new FileOutputStream(file_location);
			// finally write content 
			wb.write(fout);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("---------->>> PB is not installed! <<<----------");
			sh1.getRow(26).createCell(3).setCellValue("FAIL");
			// here we need to specify where you want to save file
			fout = new FileOutputStream(file_location);
			// finally write content 
			wb.write(fout);
			e.printStackTrace();
		}
		
		/* Click on uninstall button */
		WebElement click_uninstall_pb=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#divContextMenuUninstall")));
		//Thread.sleep(2000);
		click_uninstall_pb.click();
		//Thread.sleep(5000);
		
		/* Click on Yes button on confirmation popup */
		WebElement click_yes_pb=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-dialog-buttonset']//button[contains(text(),'Yes')]")));
		Thread.sleep(5000);
		click_yes_pb.click();
		
		Thread.sleep(2000);
		
		/* Verifying that device is uninstalled */
		WebElement verify_no_records=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='ViewInstallProductsList']/table/tbody/tr/td")));
		String records = verify_no_records.getText();
		System.out.println(records);
		System.out.println("DU and PB Uninstalled Succesfully..!!");
		
		//Thread.sleep(2000);
		
		/* Click on confirmed button */
		try {
			WebElement confirm_button = wait.until(ExpectedConditions.elementToBeClickable(By.name("confirmVehicle")));
			confirm_button.click();
			Thread.sleep(5000);
			
			sh1.getRow(27).createCell(3).setCellValue("PASS");
			// here we need to specify where you want to save file
			fout = new FileOutputStream(file_location);
			// finally write content 
			wb.write(fout);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			sh1.getRow(27).createCell(3).setCellValue("FAIL");
			// here we need to specify where you want to save file
			fout = new FileOutputStream(file_location);
			// finally write content 
			wb.write(fout);
			
			e.printStackTrace();
		}
		
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
	
	public void navigate() throws InterruptedException, IOException 
	{

	/*Automatically Navigate to view vehicle page */
	
	/*Getting current URL and title */
	System.out.println(driver.getCurrentUrl());
	System.out.println(driver.getTitle());
	Thread.sleep(5000);
	
	/*Click arrow to visit vehicle maintain page */
	try {
		WebElement arrow_click = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ViewVehicleGrid']/div[4]/div[1]/table/tbody/tr/td[2]/a")));
		arrow_click.click();
		Thread.sleep(5000);
		
		sh1.getRow(28).createCell(3).setCellValue("PASS");
		// here we need to specify where you want to save file
		fout = new FileOutputStream(file_location);
		// finally write content 
		wb.write(fout);
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		sh1.getRow(28).createCell(3).setCellValue("FAIL");
		// here we need to specify where you want to save file
		fout = new FileOutputStream(file_location);
		// finally write content 
		wb.write(fout);
		e.printStackTrace();
	}
	
	/*This  will scroll down the page by  1000 pixel vertical*/		
    js.executeScript("window.scrollBy(0,2000)");
    Thread.sleep(3000);
	
	}	
	
	public void install() throws InterruptedException, IOException 
	{
	//captureScreenShot(driver);
		Thread.sleep(5000);
	/*Click on install product button*/
    try {
		System.out.println("Installing and Activating device BCT - 01-000016A8D3CF.");
		WebElement install_product=wait.until(ExpectedConditions.elementToBeClickable(By.className("add_vehicle_btn")));
		install_product.click();
		//captureScreenShot(driver);
		Thread.sleep(2000);
		
		//Click on filter icon
		WebElement filtericon_click=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ViewSelectProductList']/div[1]/div/table/thead/tr/th[3]/a[1]/span")));
		filtericon_click.click();
		//Thread.sleep(2000);
		
		//Filter for USN - '01-000016A8D3CF'
		WebElement type_usn=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@title = 'Value']")));
		type_usn.sendKeys("01-000016A8D3CF");
		//captureScreenShot(driver);
		//Thread.sleep(3000);
		
		//Click on filter button
		WebElement filterbutton_click=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='k-button k-primary']")));
		filterbutton_click.click();
		Thread.sleep(3000);
		
		WebElement double_click = driver.findElement(By.xpath("//*[@id='ViewSelectProductList']/div[2]/div/table/tbody/tr/td[3]"));
		Thread.sleep(5000);
		
		//Double click USN 
		action.doubleClick(double_click).perform();
		Thread.sleep(5000);
		//captureScreenShot(driver);
		//Tick the checkboxs for activation
		
		//Explictly wait
		//WebDriverWait wait = new WebDriverWait(driver, 60);
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[id='ViewInstallProductsList'] table tbody tr td[class='gridTextCenter']")));
		
		//Mouse hover then click element
		action.moveToElement(driver.findElement(By.cssSelector("div[id='ViewInstallProductsList'] table tbody tr td[class='gridTextCenter']"))).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[id='ViewInstallProductsList'] table tbody tr td[class='gridTextCenter']"))).click();
		//captureScreenShot(driver);
		Thread.sleep(9000);
		
		sh1.getRow(29).createCell(3).setCellValue("PASS");
		// here we need to specify where you want to save file
		fout = new FileOutputStream(file_location);
		// finally write content 
		wb.write(fout);
		
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		sh1.getRow(29).createCell(3).setCellValue("FAIL");
		// here we need to specify where you want to save file
		fout = new FileOutputStream(file_location);
		// finally write content 
		wb.write(fout);
		
		e.printStackTrace();
	}
	
	/*Installing PB2 */
	
	
		try {
			/*Click on install product button*/
			System.out.println("Installing PB2 - 7c669d536c4b");
			WebElement install_product_pb=wait.until(ExpectedConditions.elementToBeClickable(By.className("add_vehicle_btn")));
			install_product_pb.click();
			//captureScreenShot(driver);
			Thread.sleep(2000);
			
			/*Click on filter icon*/
			WebElement filtericon_pb_click=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ViewSelectProductList']/div[1]/div/table/thead/tr/th[3]/a[1]/span")));
			filtericon_pb_click.click();
			//Thread.sleep(3000);
			
			/*Filter for PB 2 - '7c669d536c4b'*/
			WebElement pb_usn=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@title = 'Value']//following::input[2]")));
			
			pb_usn.sendKeys("7c669d536c4b");
			//captureScreenShot(driver);
			//Thread.sleep(5000);
			
			/*Click on filter button*/
			WebElement filterbutton_pb_click=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[16]/form/div[1]/div[2]/button[1]")));
			filterbutton_pb_click.click();
			Thread.sleep(5000);
			
			/*Double click USN */
			WebElement double_click_pb = driver.findElement(By.xpath("//*[@id='ViewSelectProductList']/div[2]/div/table/tbody/tr/td[3]"));
			Thread.sleep(5000);
			action.doubleClick(double_click_pb).perform();
			//captureScreenShot(driver);
			Thread.sleep(5000);
			
			sh1.getRow(30).createCell(3).setCellValue("PASS");
			// here we need to specify where you want to save file
			fout = new FileOutputStream(file_location);
			// finally write content 
			wb.write(fout);
			
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			sh1.getRow(30).createCell(3).setCellValue("FAIL");
			// here we need to specify where you want to save file
			fout = new FileOutputStream(file_location);
			// finally write content 
			wb.write(fout);
			e1.printStackTrace();
		}
		
		try {
			/*Click confirm button*/
			WebElement confirm_button_1 = driver.findElement(By.name("confirmVehicle"));
			confirm_button_1.click();
			Thread.sleep(9000);
			System.out.println("Installed and Activated succesfully.!!");
			
			sh1.getRow(31).createCell(3).setCellValue("PASS");
			// here we need to specify where you want to save file
			fout = new FileOutputStream(file_location);
			// finally write content 
			wb.write(fout);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			sh1.getRow(31).createCell(3).setCellValue("FAIL");
			// here we need to specify where you want to save file
			fout = new FileOutputStream(file_location);
			// finally write content 
			wb.write(fout);
			
			e.printStackTrace();
		}
		
	}	
	
	public void verify() throws InterruptedException, IOException 
	{
		
	try {
		/*Verify the device is installed or not */
		WebElement list = driver.findElement(By.xpath("//*[@class = 'k-hierarchy-cell']"));
		list.click();
		
		Thread.sleep(5000);
		//captureScreenShot(driver);
		WebElement product_type = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = '12691']//td[2]")));
		System.out.println("Product Type - "+ product_type.getText());
		
		WebElement product_name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = '12691']//td[3]")));
		System.out.println("Product Name - "+ product_name.getText());
		
		WebElement Serial_no = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = '12691']//td[4]")));
		System.out.println("Serial Number - "+ Serial_no.getText());
		
		WebElement USN = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = '12691']//td[5]")));
		System.out.println("USN - "+ USN.getText());
		
		WebElement Install_date = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = '12691']//td[6]")));
		System.out.println("Installation date - "+ Install_date.getText());
		
		WebElement product_type_pb = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = '12691']//table/tbody/tr[2]/td[2]")));
		System.out.println("Product Type - "+ product_type_pb.getText());
		
		WebElement product_name_pb = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = '12691']//table/tbody/tr[2]/td[3]")));
		System.out.println("Product Name - "+ product_name_pb.getText());
		
		WebElement Serial_no_pb = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = '12691']//table/tbody/tr[2]/td[4]")));
		System.out.println("Serial Number - "+ Serial_no_pb.getText());
		
		WebElement USN_pb = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = '12691']//table/tbody/tr[2]/td[5]")));
		System.out.println("USN - "+ USN_pb.getText());
		
		WebElement Install_date_pb = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id = '12691']//table/tbody/tr[2]/td[6]")));
		System.out.println("Installation date - "+ Install_date_pb.getText());
		
		sh1.getRow(32).createCell(3).setCellValue("PASS");
		// here we need to specify where you want to save file
		fout = new FileOutputStream(file_location);
		// finally write content 
		wb.write(fout);
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		sh1.getRow(32).createCell(3).setCellValue("FAIL");
		// here we need to specify where you want to save file
		fout = new FileOutputStream(file_location);
		// finally write content 
		wb.write(fout);
		e.printStackTrace();
	}
	
	//driver.close();
	
	}
	
	public void Validation() throws InterruptedException, IOException 
	{
		//captureScreenShot(driver);
		try {
			WebElement pg_time=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("PingTimeout")));
			pg_time.clear();
			
			WebElement pg_rt=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("PingRetries")));
			pg_rt.clear();
			
			WebElement rad=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("DesignatedAreaRadius")));
			rad.clear();
			
			WebElement Stationarytime=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("DesignatedAreaStationaryTime")));
			Stationarytime.clear();
			
			WebElement retry_time=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("FirewallRetry")));
			retry_time.clear();
			
			WebElement confirm_button = driver.findElement(By.name("confirmVehicle"));
			confirm_button.click();
			
			sh1.getRow(33).createCell(3).setCellValue("PASS");
			// here we need to specify where you want to save file
			fout = new FileOutputStream(file_location);
			// finally write content 
			wb.write(fout);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Locator not Found/Visible.!");
			sh1.getRow(33).createCell(3).setCellValue("PASS");
			// here we need to specify where you want to save file
			fout = new FileOutputStream(file_location);
			// finally write content 
			wb.write(fout);
			e.printStackTrace();
		}
		//captureScreenShot(driver);
		
		try {
			String Ping = "Ping Timeout (seconds) is required.";
			String Ping_retries = "Ping Retries is required.";
			String Radius = "Radius (meters) is required.";
			String stat_time = "Stationary time (seconds) is required.";
			String retry = "The Retry field is required.";
			Thread.sleep(5000);
			if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class = 'qiss_validation_error validation-summary-errors']/ul/li[1]"))).getText().contentEquals(Ping))
				{
					System.out.println("Validation message is shown- Ping");
				}
				else
					{
						System.out.println("Validation message is missing");
					}
			
			if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class = 'qiss_validation_error validation-summary-errors']/ul/li[2]"))).getText().contentEquals(Ping_retries))
				{
					System.out.println("Validation message is shown - Ping Retries");
				}
				else
					{
						System.out.println("Validation message is missing");
					}
			
			if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class = 'qiss_validation_error validation-summary-errors']/ul/li[3]"))).getText().contentEquals(Radius))
				{
					System.out.println("Validation message is shown - Radius");
				}
				else
					{
					System.out.println("Validation message is missing");
					}
			
			if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class = 'qiss_validation_error validation-summary-errors']/ul/li[4]"))).getText().contentEquals(stat_time))
				{
					System.out.println("Validation message is shown - Stationary time");
				}
				else
					{
						System.out.println("Validation message is missing");
					}
			if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class = 'qiss_validation_error validation-summary-errors']/ul/li[5]"))).getText().contentEquals(retry))
			{
				System.out.println("Validation message is shown - Retry time");
			}
			else
				{
					System.out.println("Validation message is missing");
				}
			
			sh1.getRow(34).createCell(3).setCellValue("PASS");
			// here we need to specify where you want to save file
			fout = new FileOutputStream(file_location);
			// finally write content 
			wb.write(fout);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			sh1.getRow(34).createCell(3).setCellValue("FAIL");
			// here we need to specify where you want to save file
			fout = new FileOutputStream(file_location);
			// finally write content 
			wb.write(fout);
			
			e.printStackTrace();
		}
		//captureScreenShot(driver);
		try {
			driver.navigate().refresh();
			
			System.out.println("Page is refreshed successfully.!");
			
			Thread.sleep(5000);
			//captureScreenShot(driver);
			WebElement confirm_button_1 = driver.findElement(By.name("confirmVehicle"));
			confirm_button_1.click();
			sh1.getRow(35).createCell(3).setCellValue("PASS");
			// here we need to specify where you want to save file
			fout = new FileOutputStream(file_location);
			// finally write content 
			wb.write(fout);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			sh1.getRow(35).createCell(3).setCellValue("FAIL");
			// here we need to specify where you want to save file
			fout = new FileOutputStream(file_location);
			// finally write content 
			wb.write(fout);
			e.printStackTrace();
		}
		
	}
		
	//Verify qalibrate data
	public void Qalibrate() throws InterruptedException, IOException 
		{
			Thread.sleep(5000);
			WebElement qalibrate = wait.until(ExpectedConditions.elementToBeClickable(By.id("QalibrateLink")));
			qalibrate.click();
			String qal_data = "No Qalibrate records found for this vehicle.";
		if ((wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id= 'main']//following::div[18][contains(text(),'No Qalibrate records found for this vehicle.')]"))).getText().contentEquals(qal_data)))
			{
				System.out.println("No Qalibrate records found for this vehicle.");
				sh1.getRow(40).createCell(3).setCellValue("PASS");
				// here we need to specify where you want to save file
				fout = new FileOutputStream(file_location);
				// finally write content 
				wb.write(fout);
	
			}
		else
			{
			
			System.out.println("Qalibrate data is shown for this available.");
			sh1.getRow(40).createCell(3).setCellValue("PASS");
			// here we need to specify where you want to save file
			fout = new FileOutputStream(file_location);
			// finally write content 
			wb.write(fout);
			}
		}
	
	
	//Verify NMI data
	public void NMI() throws InterruptedException, IOException 
		{
			Thread.sleep(5000);
			WebElement nmi = wait.until(ExpectedConditions.elementToBeClickable(By.id("NMILink")));
			nmi.click();
			String nmi_data = "No NMI data";
			if ((wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='textVerification']"))).getAttribute("value").contentEquals(nmi_data)))
				{
					System.out.println("No NMI data available for this vehicle.");
					sh1.getRow(41).createCell(3).setCellValue("PASS");
					// here we need to specify where you want to save file
					fout = new FileOutputStream(file_location);
					// finally write content 
					wb.write(fout);
		
				}
			else
				{
				
				System.out.println("NMI data available for this vehicle.");
				sh1.getRow(41).createCell(3).setCellValue("PASS");
				// here we need to specify where you want to save file
				fout = new FileOutputStream(file_location);
				// finally write content 
				wb.write(fout);
				}
			//Navigate back to vehicle page
			Thread.sleep(5000);
			WebElement back = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a#VehicleLink")));
			back.click();
			
			System.out.println("Closing the browser..");
			
			Thread.sleep(3000);
			driver.close();
			System.out.println("Browser closed successfully.!");
			
			}
	
	//Verify Generate config, dispatcher vehicle connection history and view history buttons
		public void buttons() throws InterruptedException, IOException 
			{
				Thread.sleep(5000);
				
				try {
					/*Click arrow to visit vehicle maintain page */
					WebElement arrow_click = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ViewVehicleGrid']/div[4]/div[1]/table/tbody/tr/td[2]/a")));
					arrow_click.click();
					Thread.sleep(5000);
					sh1.getRow(36).createCell(3).setCellValue("PASS");
					// here we need to specify where you want to save file
					fout = new FileOutputStream(file_location);
					// finally write content 
					wb.write(fout);
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					sh1.getRow(36).createCell(3).setCellValue("FAIL");
					// here we need to specify where you want to save file
					fout = new FileOutputStream(file_location);
					// finally write content 
					wb.write(fout);
					e1.printStackTrace();
				}
				
				try {
					//Verify Dispatcher Generate config 
					WebElement gen_btn = wait.until(ExpectedConditions.elementToBeClickable(By.id("generateVehicleConfiguration")));
					gen_btn.click();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("------>>>Generate config button is not visible  <<<------.");
					e.printStackTrace();
				}
				Thread.sleep(5000);
				String gc = "Generate configuration";
				if ((wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class= 'ui-dialog-title'][contains(text(),'Generate configuration')]"))).getText().contentEquals(gc)))
					{
					
					WebElement yes = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class = 'ui-dialog-buttonset']/button[1]")));
					yes.click();
					
					Thread.sleep(5000);
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class= 'ui-dialog-buttonset']/button"))).click();
					System.out.println("Request has been sent successfully for generating configuration.");
					sh1.getRow(37).createCell(3).setCellValue("PASS");
					// here we need to specify where you want to save file
					fout = new FileOutputStream(file_location);
					// finally write content 
					wb.write(fout);
			
					}
				else
					{
					
					System.out.println("Generate configuration popup is not visible");
					sh1.getRow(37).createCell(3).setCellValue("FAIL");
					// here we need to specify where you want to save file
					fout = new FileOutputStream(file_location);
					// finally write content 
					wb.write(fout);
					
					}
				
				//Verify Dispatcher vehicle connection history popup 
				Thread.sleep(3000);
				WebElement disp_his = wait.until(ExpectedConditions.elementToBeClickable(By.id("viewDispatcherConnectionHistory")));
				disp_his.click();
				String dh = "Dispatcher vehicle connection history";
				if ((wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class= 'ui-dialog-title'][following::span][contains(text(),'Dispatcher vehicle connection history')]"))).getText().contentEquals(dh)))
					{
				
					System.out.println("Dispatcher vehicle connection history popup is shown");
					sh1.getRow(38).createCell(3).setCellValue("PASS");
					// here we need to specify where you want to save file
					fout = new FileOutputStream(file_location);
					// finally write content 
					wb.write(fout);
		
					}
				else
					{
				
					System.out.println("Dispatcher vehicle connection history popup is not shown");
					sh1.getRow(38).createCell(3).setCellValue("FAIL");
					// here we need to specify where you want to save file
					fout = new FileOutputStream(file_location);
					// finally write content 
					wb.write(fout);
					}
				Thread.sleep(5000);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div[1]/button/span[1]"))).click();
				
				//Verify View history popup 
				Thread.sleep(3000);
				WebElement view_his = wait.until(ExpectedConditions.elementToBeClickable(By.id("viewHistory")));
				view_his.click();
				String vh = "View history";
				
				if ((wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class= 'ui-dialog-title'][following::span][contains(text(),'View history')]"))).getText().contentEquals(vh)))
					{
				
					System.out.println("View history popup is shown");
					sh1.getRow(39).createCell(3).setCellValue("PASS");
					// here we need to specify where you want to save file
					fout = new FileOutputStream(file_location);
					// finally write content 
					wb.write(fout);
		
					}
				else
					{
				
					System.out.println("View history popup is not shown");
					sh1.getRow(39).createCell(3).setCellValue("FAIL");
					// here we need to specify where you want to save file
					fout = new FileOutputStream(file_location);
					// finally write content 
					wb.write(fout);
					}
				
				Thread.sleep(5000);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[1]/button/span[1]"))).click();
				
				}
	
	public void captureScreenShot(WebDriver ldriver)
	{
		// Take screenshot and store as a file format            
		File src=((TakesScreenshot)ldriver).getScreenshotAs(OutputType.FILE);
			try 
			{
		// now copy the  screenshot to desired location using copyFile method

				FileUtils.copyFile(src, new File("C:/selenium/"+System.currentTimeMillis()+".jpg")); 
			} 
				catch (IOException e)

					{
						System.out.println(e.getMessage());
					}
	}
	
	public void closed() throws InterruptedException 
	{
	  
		  driver.close();
	  }
}
	

		
	



