import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Qiss_Company_details_feature extends Start_Qiss {

	public static WebDriver driver = null;
	public static WebDriverWait wait;

	/*public static File src;
	public static FileInputStream fis;
	public static XSSFWorkbook wb;
	public static XSSFSheet sh1;
	public static FileOutputStream fout;
	public static String file_location = "C:\\Users\\ritesh.jhaveri\\Documents\\Ritesh\\Qiss_Automation_Checklist.xlsx";*/
	public static String Count, record_count, comp_count;
	public Actions action;

	public static void login() throws Exception

	{

		src = new File(file_location);

		fis = new FileInputStream(src);

		
		wb = new XSSFWorkbook(fis);

		sh1 = wb.getSheetAt(0);

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ritesh.jhaveri\\Documents\\Ritesh\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.get("https://qiss-test.quipment.nl/home");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		wait = new WebDriverWait(Start_Qiss.driver, 60);

	}

	/* Waiting for page load */

	public static void waitForPageLoaded() {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
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

	/* Login Qiss portal with ADFS */

	/*public void login_adfs()

	{

		Qiss_Company_details_locators.uname(driver).sendKeys("ritesh.jhaveri@quipment.nl");
		Qiss_Company_details_locators.pass(driver).sendKeys("R!tesh@1989");
		Qiss_Company_details_locators.submit(driver).click();
		waitForPageLoaded();
		Qiss_Company_details_locators.company(driver).click();

	}*/

	/* Verify the Filter, Paging and Item per page for "Active" Companies */

	public static void Active() throws Exception

	{
		if (Qiss_Company_details_locators.active(Start_Qiss.driver).getText().contentEquals("Active")) {
			System.out.println("Active records loaded successfully");
			 sh1.getRow(89).createCell(3).setCellValue("PASS");
			 fout = new FileOutputStream(file_location); wb.write(fout);
		}

		else {
			System.out.println("Error in loading Active records");
			 sh1.getRow(89).createCell(3).setCellValue("FAIL");
			 fout = new FileOutputStream(file_location); wb.write(fout);
		}

		/* Verify that filter is working or not */

		if (Qiss_Company_details_function.filter()) {
			System.out.println("Data filtered with Company name succesfully");
			
			 sh1.getRow(90).createCell(3).setCellValue("PASS");
			 fout = new FileOutputStream(file_location); wb.write(fout);
			 
		} else {
			System.out.println("Error in filtering data with Old value");
			
			 sh1.getRow(90).createCell(3).setCellValue("FAIL"); 
			 fout = new FileOutputStream(file_location); wb.write(fout);
			 
		}

		/* Verify that able to clear data from filter */

		if (Qiss_Company_details_function.clear()) {
			System.out.println("Data cleared successfuly");
			
		} else {
			System.out.println("Error is clearing data");
			
		}

		/* Verify that paging is working or not */

		if (Qiss_Company_details_function.paging()) {
			System.out.println("Paging worked succesfully");
			
				sh1.getRow(91).createCell(3).setCellValue("PASS"); fout = new
				FileOutputStream(file_location); wb.write(fout);
			 
		} else {
			System.out.println("Error is paging data");
			 
				sh1.getRow(91).createCell(3).setCellValue("FAIL"); fout = new
				FileOutputStream(file_location); wb.write(fout);
			 
		}

		/* Verify that Item per page is working or not */

		if (Qiss_Company_details_function.item_page()) {
			System.out.println("Navigating item per page succesfully");
			
			sh1.getRow(92).createCell(3).setCellValue("PASS"); fout = new
			FileOutputStream(file_location); wb.write(fout);
			
		} else {
			System.out.println("Error is navigating item per page");
			
			sh1.getRow(92).createCell(3).setCellValue("FAIL"); fout = new
			FileOutputStream(file_location); wb.write(fout);
		}

		Start_Qiss.driver.navigate().refresh();
	}

	/* Verify the Filter, Paging and Item per page for "InActive" Companies */

	public static void Inactive() throws Exception

	{

		waitForPageLoaded();
		Thread.sleep(2000);
		Qiss_Company_details_locators.inactive(Start_Qiss.driver).click();
		waitForPageLoaded();

		if (Qiss_Company_details_locators.inactive(Start_Qiss.driver).getText().contentEquals("Inactive")) {
			System.out.println("Inactive records loaded successfully");
			sh1.getRow(93).createCell(3).setCellValue("PASS"); 
			fout = new FileOutputStream(file_location); wb.write(fout);
		}

		else {
			System.out.println("Error in loading Inactive records");
			sh1.getRow(93).createCell(3).setCellValue("FAIL"); 
			fout = new FileOutputStream(file_location); wb.write(fout);
		}

		/* Verify that filter is working or not */

		if (Qiss_Company_details_function.filter()) {
			System.out.println("Data filtered with Company name succesfully");
			sh1.getRow(94).createCell(3).setCellValue("PASS"); 
			fout = new FileOutputStream(file_location); wb.write(fout);
			
		} else {
			System.out.println("Error in filtering data with Old value");
			sh1.getRow(94).createCell(3).setCellValue("FAIL"); 
			fout = new FileOutputStream(file_location); wb.write(fout);
		}

		/* Verify that able to clear data from filter */

		if (Qiss_Company_details_function.clear()) {
			System.out.println("Data cleared successfuly");
			
		} else {
			System.out.println("Error is clearing data");
			
		}

		/* Verify that paging is working or not */

		if (Qiss_Company_details_function.paging()) {
			System.out.println("Paging worked succesfully");
			sh1.getRow(95).createCell(3).setCellValue("PASS"); 
			fout = new FileOutputStream(file_location); wb.write(fout);
			
		} else {
			System.out.println("Error is paging data");
			sh1.getRow(95).createCell(3).setCellValue("FAIL"); 
			fout = new FileOutputStream(file_location); wb.write(fout);
		}

		/* Verify that Item per page is working or not */

		if (Qiss_Company_details_function.item_page()) {
			System.out.println("Navigating item per page succesfully");
			sh1.getRow(96).createCell(3).setCellValue("PASS"); 
			fout = new FileOutputStream(file_location); wb.write(fout);
			
		} else {
			System.out.println("Error is navigating item per page");
			sh1.getRow(96).createCell(3).setCellValue("FAIL"); 
			fout = new FileOutputStream(file_location); wb.write(fout);
		}

		Start_Qiss.driver.navigate().refresh();
	}

	/* Verify the Filter, Paging and Item per page for "ALL" Companies */

	public static void All() throws Exception

	{

		waitForPageLoaded();
		Thread.sleep(2000);
		Qiss_Company_details_locators.all(Start_Qiss.driver).click();
		waitForPageLoaded();

		if (Qiss_Company_details_locators.all(Start_Qiss.driver).getText().contentEquals("All")) {
			System.out.println("All records loaded successfully");
			sh1.getRow(97).createCell(3).setCellValue("PASS"); 
			fout = new FileOutputStream(file_location); wb.write(fout);
		}

		else {
			System.out.println("Error in loading All records");
			sh1.getRow(97).createCell(3).setCellValue("FAIL"); 
			fout = new FileOutputStream(file_location); wb.write(fout);
		}

		/* Verify that filter is working or not */

		if (Qiss_Company_details_function.filter()) {
			System.out.println("Data filtered with Company name succesfully");
			sh1.getRow(98).createCell(3).setCellValue("PASS"); 
			fout = new FileOutputStream(file_location); wb.write(fout);
			
		} else {
			System.out.println("Error in filtering data with Old value");
			sh1.getRow(98).createCell(3).setCellValue("FAIL"); 
			fout = new FileOutputStream(file_location); wb.write(fout);
		}

		/* Verify that able to clear data from filter */

		if (Qiss_Company_details_function.clear()) {
			System.out.println("Data cleared successfuly");

		} else {
			System.out.println("Error is clearing data");

		}

		/* Verify that paging is working or not */

		if (Qiss_Company_details_function.paging()) {
			System.out.println("Paging worked succesfully");
			sh1.getRow(99).createCell(3).setCellValue("PASS"); 
			fout = new FileOutputStream(file_location); wb.write(fout);
			
		} else {
			System.out.println("Error is paging data");
			sh1.getRow(99).createCell(3).setCellValue("FAIL"); 
			fout = new FileOutputStream(file_location); wb.write(fout);
		}

		/* Verify that Item per page is working or not */

		if (Qiss_Company_details_function.item_page()) {
			System.out.println("Navigating item per page succesfully");
			sh1.getRow(100).createCell(3).setCellValue("PASS"); 
			fout = new FileOutputStream(file_location); wb.write(fout);
			
		} else {
			System.out.println("Error is navigating item per page");
			sh1.getRow(100).createCell(3).setCellValue("FAIL"); 
			fout = new FileOutputStream(file_location); wb.write(fout);
		}
		(Start_Qiss.driver).navigate().refresh();
		System.out.println("TEST ONNNNNNNNN");

	}

	/*
	 * Verify the keeping Mandatory fields blank display validation error
	 * message
	 */

	public static void  Vehicle() throws Exception

	{
		waitForPageLoaded();
		Qiss_Company_details_locators.active(Start_Qiss.driver).click();
		Thread.sleep(2000);
		Qiss_Company_details_locators.filter_icon(Start_Qiss.driver).click();
		Qiss_Company_details_locators.filter_data(Start_Qiss.driver).sendKeys("Insigno Quipment");
		Qiss_Company_details_locators.filter_btn(Start_Qiss.driver).click();
		waitForPageLoaded();
		Qiss_Company_details_locators.navigation_arrow(Start_Qiss.driver).click();

		Thread.sleep(5000);

		/* Clicking on New Vehicle button and clearing all mandatory fields */

		try {
			
			Qiss_Company_details_locators.New_vehicle_btn(Start_Qiss.driver).click();
			
			sh1.getRow(101).createCell(3).setCellValue("PASS"); 
			fout = new FileOutputStream(file_location); wb.write(fout);
		} catch (Exception e) {
			
			e.printStackTrace();
			sh1.getRow(101).createCell(3).setCellValue("FAIL"); 
			fout = new FileOutputStream(file_location); wb.write(fout);
		}
		
		
		Qiss_Company_details_locators.Ping_timeout(Start_Qiss.driver).clear();
		Qiss_Company_details_locators.Ping_retries(Start_Qiss.driver).clear();
		Qiss_Company_details_locators.Radius(Start_Qiss.driver).clear();
		Qiss_Company_details_locators.Stat_time(Start_Qiss.driver).clear();

		/* Clicking on "Confirm" button display validation error message */
		waitForPageLoaded();
		Qiss_Company_details_locators.Confirm_btn(Start_Qiss.driver).click();
		waitForPageLoaded();

		if (Qiss_Company_details_locators.Vehicle_no_error(Start_Qiss.driver).getText()
				.contentEquals("Vehicle number is required.")
				&& Qiss_Company_details_locators.Ping_timeout_error(Start_Qiss.driver).getText()
						.contentEquals("Ping Timeout (seconds) is required.")
				&& Qiss_Company_details_locators.Ping_retries_error(Start_Qiss.driver).getText()
						.contentEquals("Ping Retries is required.")
				&& Qiss_Company_details_locators.radius_error(Start_Qiss.driver).getText()
						.contentEquals("Radius (meters) is required.")
				&& Qiss_Company_details_locators.stat_time_error(Start_Qiss.driver).getText()
						.contentEquals("Stationary time (seconds) is required."))

		{
			System.out.println("Validation messages are shown");
			sh1.getRow(102).createCell(3).setCellValue("PASS"); 
			fout = new FileOutputStream(file_location); wb.write(fout);

		}

		else {
			System.out.println("Validation messages are not shown");
			sh1.getRow(102).createCell(3).setCellValue("FAIL"); 
			fout = new FileOutputStream(file_location); wb.write(fout);
		}
		Qiss_Company_details_locators.back_btn(Start_Qiss.driver).click();

	}

	/* Verify the Overall Items are shown for Product in Product items page */

	public static void Product() throws Exception

	{
		Thread.sleep(2000);
		waitForPageLoaded();
		Qiss_Company_details_locators.product(Start_Qiss.driver).click();

		if (Qiss_Company_details_locators.count(Start_Qiss.driver).getText().contentEquals("No items to display")) {
			System.out.println("No Product data available to display.!");
			sh1.getRow(103).createCell(3).setCellValue("PASS"); 
			fout = new FileOutputStream(file_location); wb.write(fout);
		}

		else {
			System.out.println("Product items are shown successfully.!");
			sh1.getRow(103).createCell(3).setCellValue("PASS"); 
			fout = new FileOutputStream(file_location); wb.write(fout);
		}
	}

	/* Verify Qupido router functionlaity */

	public static void QupidoRouter() throws Exception

	{
		waitForPageLoaded();
		try {
			
			Qiss_Company_details_locators.QupidoRouter(Start_Qiss.driver).click();
			
			sh1.getRow(104).createCell(3).setCellValue("PASS"); 
			fout = new FileOutputStream(file_location); wb.write(fout);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			sh1.getRow(104).createCell(3).setCellValue("PASS"); 
			fout = new FileOutputStream(file_location); wb.write(fout);
		}
		Thread.sleep(5000);

		/* Verify default records for qupido router is avilable or not */

		if (Qiss_Company_details_locators.count(Start_Qiss.driver).getText().contentEquals("No items to display")) {
			System.out.println("No records found for qupido router");
		}

		else {
			System.out.println("Records found for Qupido router");
		}

		/*
		 * Verfiy that clearing mandatory fields and clicking on confirmed buton
		 * must show validation message
		 */

		Qiss_Company_details_locators.New_QupidoRouter_btn(Start_Qiss.driver).click();
		
		if (Start_Qiss.driver.findElement(By.xpath("//*[@id='updatePanel']/div/div[1]")).getText().contentEquals("Maintain qupido router"))
		{
			System.out.println("Successfully Navigated to Maintain Quipdo Router Page");
			sh1.getRow(105).createCell(3).setCellValue("PASS"); 
			fout = new FileOutputStream(file_location); wb.write(fout);
		}
		
		else
		{
			System.out.println("Error in Navigating to Maintain Quipdo Router Page");
			sh1.getRow(105).createCell(3).setCellValue("FAIL"); 
			fout = new FileOutputStream(file_location); wb.write(fout);
		}
		
		Qiss_Company_details_locators.Username(Start_Qiss.driver).clear();
		Qiss_Company_details_locators.Password(Start_Qiss.driver).clear();
		Qiss_Company_details_locators.filepath(Start_Qiss.driver).clear();
		Qiss_Company_details_locators.confirmQupidoRouter_btn(Start_Qiss.driver).click();

		if (Qiss_Company_details_locators.routername_error(Start_Qiss.driver).getText().contentEquals("Router name is required.")
				&& Qiss_Company_details_locators.IPaddress_error(Start_Qiss.driver).getText()
						.contentEquals("IP address is required.")
				&& Qiss_Company_details_locators.Username_error(Start_Qiss.driver).getText()
						.contentEquals("User name is required.")
				&& Qiss_Company_details_locators.password_error(Start_Qiss.driver).getText().contentEquals("Password is required.")
				&& Qiss_Company_details_locators.filepath_error(Start_Qiss.driver).getText()
						.contentEquals("File Path is required."))

		{
			System.out.println("Validation messages are shown");
			sh1.getRow(106).createCell(3).setCellValue("PASS"); 
			fout = new FileOutputStream(file_location); wb.write(fout);

		}

		else {
			System.out.println("Validation messages are not shown");
			sh1.getRow(106).createCell(3).setCellValue("FAIL"); 
			fout = new FileOutputStream(file_location); wb.write(fout);
		}

		Qiss_Company_details_locators.router_name(Start_Qiss.driver).sendKeys("Testing");
		Qiss_Company_details_locators.IPaddress(Start_Qiss.driver).sendKeys("100.99.100.99");
		Qiss_Company_details_locators.Port(Start_Qiss.driver).sendKeys("9999");
		Qiss_Company_details_locators.Username(Start_Qiss.driver).sendKeys("Ritesh");
		Qiss_Company_details_locators.Password(Start_Qiss.driver).sendKeys("Ritesh");
		Qiss_Company_details_locators.filepath(Start_Qiss.driver).sendKeys("\\QuipmentVAL\\qupido");
		Qiss_Company_details_locators.confirmQupidoRouter_btn(Start_Qiss.driver).click();
		waitForPageLoaded();

		if (Qiss_Company_details_locators.count(Start_Qiss.driver).getText().contentEquals("1 - 1 of 1 items")) {
			System.out.println("Record added for qupido router");
			sh1.getRow(107).createCell(3).setCellValue("PASS"); 
			fout = new FileOutputStream(file_location); wb.write(fout);
		}

		else {
			System.out.println("Error in adding record for Qupido router");
			sh1.getRow(107).createCell(3).setCellValue("FAIL"); 
			fout = new FileOutputStream(file_location); wb.write(fout);
		}

		Qiss_Company_details_locators.navigation_arrow(Start_Qiss.driver).click();
		waitForPageLoaded();

		Qiss_Company_details_locators.remove_qupido_router_btn(Start_Qiss.driver).click();
		Qiss_Company_details_locators.yes_btn_qupido_router_popup(Start_Qiss.driver).click();

		if (Qiss_Company_details_locators.count(Start_Qiss.driver).getText().contentEquals("No items to display")) {
			System.out.println("Records removed from qupido router");
			sh1.getRow(108).createCell(3).setCellValue("PASS"); 
			fout = new FileOutputStream(file_location); wb.write(fout);
		}

		else {
			System.out.println("Error in deleting record for Qupido router");
			sh1.getRow(108).createCell(3).setCellValue("FAIL"); 
			fout = new FileOutputStream(file_location); wb.write(fout);
		}

	}

	public static void Dispatcher() throws Exception

	{
		/* Verify that navigation is performed at dispatcher page or not */

		Thread.sleep(2000);
		waitForPageLoaded();
		
		try {
			Qiss_Company_details_locators.dispatcher(Start_Qiss.driver).click();
		} catch (Exception e) {
			
			e.printStackTrace();
		}

		if (Qiss_Company_details_locators.dispatcher(Start_Qiss.driver).getAttribute("class").contentEquals("active")) {
			System.out.println("Successfuly navigated to Dispatcher page");
			sh1.getRow(109).createCell(3).setCellValue("PASS"); 
			fout = new FileOutputStream(file_location); wb.write(fout);
			
		} else {
			System.out.println("Error in clicking button");
			sh1.getRow(109).createCell(3).setCellValue("FAIL"); 
			fout = new FileOutputStream(file_location); wb.write(fout);
		}

		if (Qiss_Company_details_locators.count(Start_Qiss.driver).getText().contentEquals("No items to display")) {
			System.out.println("No dispatcher data available to display or Error is showing dispatcher data");
		}

		else {
			System.out.println("Dispatcher data are shown successfully.!");
		}
	}

	public static void Subscription() throws Exception

	{
		/* Verify that navigation is performed at subscription page or not */

		Thread.sleep(2000);
		waitForPageLoaded();
		Qiss_Company_details_locators.subscription(Start_Qiss.driver).click();

		if (Qiss_Company_details_locators.subscription(Start_Qiss.driver).getAttribute("class").contentEquals("active")) {
			System.out.println("Successfuly navigated to Subscription page");
			sh1.getRow(110).createCell(3).setCellValue("PASS"); 
			fout = new FileOutputStream(file_location); wb.write(fout);
			
		} else {
			System.out.println("Error in clicking button");
			sh1.getRow(110).createCell(3).setCellValue("FAIL"); 
			fout = new FileOutputStream(file_location); wb.write(fout);
		}

		if (Qiss_Company_details_locators.count(Start_Qiss.driver).getText().contentEquals("No items to display")) {
			System.out.println("No Subscription data available to display or Error is showing Subscription data");
		}

		else {
			System.out.println("Subscription data are shown successfully.!");
		}
	}

	public static void Configuration() throws Exception

	{
		/* Verify that navigation is performed at configuration page or not */
		
		Qiss_Company_details_locators.configuration(Start_Qiss.driver).click();
		
		Thread.sleep(5000);

		if (Qiss_Company_details_locators.configuration(Start_Qiss.driver).getAttribute("class").contentEquals("active")) {
			System.out.println("Successfuly navigated to Configuration page");
			sh1.getRow(111).createCell(3).setCellValue("PASS"); 
			fout = new FileOutputStream(file_location); wb.write(fout);
			
		} else {
			System.out.println("Error in clicking button");
			sh1.getRow(111).createCell(3).setCellValue("FAIL"); 
			fout = new FileOutputStream(file_location); wb.write(fout);
		}
		
		Thread.sleep(5000);
		Qiss_Company_details_locators.trip_sorting_dropdownlist_arrow(Start_Qiss.driver).click();
		Thread.sleep(2000);

		/* Verify that trip sorting option button is working or not */

		List<WebElement> elem = Start_Qiss.driver.findElements(By.cssSelector("#QrisConfiguration_TripSortingStyle_listbox li"));

		for (WebElement loop1 : elem) {
			if (loop1.getAttribute("class").contentEquals("k-item k-state-selected k-state-focused")) {

				/* Printing current trip sort option */

				System.out.println("Current trip sorting selected is - " + loop1.getAttribute("innerHTML"));
			} else {
				/* Selecting and Printing trip sort selected option */

				loop1.click();
				Thread.sleep(2000);
				System.out.println("Selected trip sorting option is - " + loop1.getAttribute("innerHTML"));
				sh1.getRow(112).createCell(3).setCellValue("PASS"); 
				fout = new FileOutputStream(file_location); wb.write(fout);
				break;
			}
		}
		Thread.sleep(2000);

		List<WebElement> list = Start_Qiss.driver.findElements(By.xpath("//*[@id='CompanyMemoTable']/tbody/tr/td/input"));
		//int count_element = list.size();
		//System.out.println(count_element);

		/* Verify that break permitted option button is working or not */

		System.out.println("Current break configuration is - " + Start_Qiss.driver
				.findElement(By.xpath("//span[@aria-owns = 'QrisConfiguration_BreakPermitted_listbox']/span/span"))
				.getAttribute("innerHTML"));
		Start_Qiss.driver.findElement(By.xpath("//*[@aria-owns = 'QrisConfiguration_BreakPermitted_listbox']/span/span/span"))
				.click();
		
		List<WebElement> break_list = Start_Qiss.driver
				.findElements(By.cssSelector("#QrisConfiguration_BreakPermitted_listbox li"));
		Thread.sleep(3000);
		for (WebElement loop3 : break_list) {
			System.out.println(loop3.getAttribute("innerHTML"));
			if (!loop3.getAttribute("class").contentEquals("k-item k-state-selected k-state-focused")) {
				loop3.click();
				/* Selecting and Printing break configuration selected option */
				System.out.println("Break configuration is selected to - " + loop3.getAttribute("innerHTML"));
				sh1.getRow(113).createCell(3).setCellValue("PASS"); 
				fout = new FileOutputStream(file_location); wb.write(fout);
				break;
			}
		}

		/* Verify the save and generate functionlaity is working or not */

		Qiss_Company_details_locators.save_btn(Start_Qiss.driver).click();
		waitForPageLoaded();
		Thread.sleep(5000);

		/* Verify that saved popup is shown or not */

		if (Qiss_Company_details_locators.config_label(Start_Qiss.driver).getAttribute("innerHTML")
				.contentEquals("Configuration")) {
			System.out.println("Data saved succesfully.!");
			sh1.getRow(114).createCell(3).setCellValue("PASS"); 
			fout = new FileOutputStream(file_location); wb.write(fout);
			
		} else {
			System.out.println("Issue in Data saving.!");
			sh1.getRow(114).createCell(3).setCellValue("FAIL"); 
			fout = new FileOutputStream(file_location); wb.write(fout);
		}

		Qiss_Company_details_locators.OK_btn(Start_Qiss.driver).click();
		Thread.sleep(3000);
		
		/*Clicking on generate config button*/
		
		Qiss_Company_details_locators.generateconfig(Start_Qiss.driver).click();
		Thread.sleep(3000);

		/* Verify that generate popup is shown or not */

		if (Qiss_Company_details_locators.config_label(Start_Qiss.driver).getAttribute("innerHTML")
				.contentEquals("Generate configuration")) {
			System.out.println("Generate popup is shown.!");
		} else {
			System.out.println("Generate popup not shown.!");
		}

		Qiss_Company_details_locators.yes_btn_gen_config(Start_Qiss.driver).click();
		Thread.sleep(3000);

		/*
		 * Verify that after clicking on YES button config popup is shown or not
		 */

		if (Qiss_Company_details_locators.config_label(Start_Qiss.driver).getAttribute("innerHTML")
				.contentEquals("Maintain company")) {
			System.out.println("Configuration generated successfully");
			sh1.getRow(115).createCell(3).setCellValue("PASS"); 
			fout = new FileOutputStream(file_location); wb.write(fout);
			
		} else {
			System.out.println("Error in Generating config.");
			sh1.getRow(115).createCell(3).setCellValue("FAIL");
			fout = new FileOutputStream(file_location); wb.write(fout);
		}

		Qiss_Company_details_locators.ok_btn_maintain_company(Start_Qiss.driver).click();
	}

	
	public static void Taximeter_tariff() throws Exception

	{

		/*
		 * Verify that navigation is performed at Tariffset tariff page or not
		 */

		Thread.sleep(5000);
		/*driver.navigate().to("https://qiss-test.quipment.nl/Company/MaintainCompany/700?selectTab=6");
		Thread.sleep(5000);*/
		Qiss_Company_details_locators.Tariffset_tariff(Start_Qiss.driver).click();
		
		Thread.sleep(2000);

		if (Qiss_Company_details_locators.Tariffset_tariff(Start_Qiss.driver).getAttribute("class").contentEquals("active")) {
			System.out.println("Successfuly navigated to Tariffset tariff page..");
			sh1.getRow(116).createCell(3).setCellValue("PASS");
			fout = new FileOutputStream(file_location); wb.write(fout);
			
		} else {
			System.out.println("Error in clicking button");
			sh1.getRow(116).createCell(3).setCellValue("FAIL");
			fout = new FileOutputStream(file_location); wb.write(fout);
		}

		/*
		 * Verfiy that clearing mandatory fields and clicking on save buton must
		 * show validation message
		 */

		Qiss_Company_details_locators.Tariffset(Start_Qiss.driver).clear();
		Qiss_Company_details_locators.Max_total_amount(Start_Qiss.driver).clear();
		Qiss_Company_details_locators.supplement_amount(Start_Qiss.driver).clear();

		Qiss_Company_details_locators.Save_btn_taximetertariff(Start_Qiss.driver).click();

		if (Qiss_Company_details_locators.tariffset_error_msg(Start_Qiss.driver).getText().contentEquals("Tariffset is required.")
				&& Qiss_Company_details_locators.maxtotal_error_msg(Start_Qiss.driver).getText()
						.contentEquals("Max total amount is required.")
				&& Qiss_Company_details_locators.amount_error_msg(Start_Qiss.driver).getText()
						.contentEquals("Amount is required."))

		{
			System.out.println("Validation messages are shown");
			sh1.getRow(117).createCell(3).setCellValue("PASS");
			fout = new FileOutputStream(file_location); wb.write(fout);
		}

		else {
			System.out.println("Validation messages are not shown");
			sh1.getRow(117).createCell(3).setCellValue("FAIL");
			fout = new FileOutputStream(file_location); wb.write(fout);

		}

		/*---Verify adding, editing and deleting tarriffset---*/

		Start_Qiss.driver.navigate().refresh();
		Thread.sleep(2000);
		Qiss_Company_details_locators.New_tarriffset_btn(Start_Qiss.driver).click();
		Thread.sleep(1000);

		Qiss_Company_details_function.select_date();
		Thread.sleep(2000);

		Qiss_Company_details_locators.Save_btn_taximetertariff(Start_Qiss.driver).click();
		Thread.sleep(2000);

		/*--Verify that clicking on save button directly without entering data, must show validation message--*/

		if (Qiss_Company_details_locators.tariffset_error_msg(Start_Qiss.driver).getText().contentEquals("Tariffset is required.")
				&& Qiss_Company_details_locators.tariffset_period_error_msg(Start_Qiss.driver).getText()
						.contentEquals("Please provide atleast one tariff for a tariffset period"))

		{
			System.out.println("Validation messages are shown..");
			sh1.getRow(118).createCell(3).setCellValue("PASS");
			fout = new FileOutputStream(file_location); wb.write(fout);
		}

		else {
			System.out.println("Validation messages are not shown");
			sh1.getRow(118).createCell(3).setCellValue("FAIL");
			fout = new FileOutputStream(file_location); wb.write(fout);
		}

		System.out.println(
				"Test 1 Pass - Verify that clicking on save button directly without entering data, must show validation message ");

		/*---Verify that adding valid tariff set, must save Tariff set successfully---*/

		Start_Qiss.driver.navigate().refresh();
		Thread.sleep(2000);
		Qiss_Company_details_locators.New_tarriffset_btn(Start_Qiss.driver).click();
		Thread.sleep(3000);
		Qiss_Company_details_locators.tariffset_textbox(Start_Qiss.driver).sendKeys("Test Automation");
		Thread.sleep(3000);
		Qiss_Company_details_function.select_date();
		Thread.sleep(2000);
		Qiss_Company_details_locators.Add_tariffs(Start_Qiss.driver).click();
		Thread.sleep(2000);

		/*
		 * Verify that clicking on Confirm button directly without entering data
		 * in maintain tariff popup, must show validation message
		 */

		Qiss_Company_details_locators.confirm_btn_maintain(Start_Qiss.driver).click();

		if (Qiss_Company_details_locators.maintain_tariff_name_tariff_error_message(Start_Qiss.driver).getText()
				.contentEquals("Name of tariff is required.")
				&& Qiss_Company_details_locators.maintain_tariff_desc_tariff_error_message(Start_Qiss.driver).getText()
						.contentEquals("Description of tariff is required.")
				&& Qiss_Company_details_locators.maintain_tariff_waiting_time_error_message(Start_Qiss.driver).getText()
						.contentEquals("Waiting time fee/hr of tariff is required.")
				&& Qiss_Company_details_locators.maintain_tariff_initial_fee_error_message(Start_Qiss.driver).getText()
						.contentEquals("Initial fee is required.")
				&& Qiss_Company_details_locators.maintain_tariff_distance_fee_error_message(Start_Qiss.driver).getText()
						.contentEquals("Distance fee/km is required.")
				&& Qiss_Company_details_locators.maintain_tariff_time_fee_error_message(Start_Qiss.driver).getText()
						.contentEquals("Time fee/hr is required."))

		{
			System.out.println("Validation messages are shown..");
			System.out.println(
					"Test 2 Pass - Verify that clicking on Confirm button directly without entering data in maintain tariff popup, must show validation message");
			sh1.getRow(119).createCell(3).setCellValue("PASS");
			fout = new FileOutputStream(file_location); wb.write(fout);

		}

		else {
			System.out.println("Validation messages are not shown");
			sh1.getRow(119).createCell(3).setCellValue("FAIL");
			fout = new FileOutputStream(file_location); wb.write(fout);
		}

		Qiss_Company_details_locators.maintain_tarif_name(Start_Qiss.driver).sendKeys("Test_Tariff");
		Qiss_Company_details_locators.maintain_tarif_descp(Start_Qiss.driver).sendKeys("Descp Test_Tariff");
		Qiss_Company_details_locators.maintain_waiting(Start_Qiss.driver).sendKeys("7777");
		Qiss_Company_details_locators.maintain_initial(Start_Qiss.driver).sendKeys("7");
		Qiss_Company_details_locators.maintain_time(Start_Qiss.driver).sendKeys("4777");
		Qiss_Company_details_locators.maintain_distance(Start_Qiss.driver).sendKeys("9777");
		Thread.sleep(3000);
		Qiss_Company_details_locators.confirm_btn_maintain(Start_Qiss.driver).click();
		Thread.sleep(3000);
		Qiss_Company_details_locators.Save_btn_taximetertariff(Start_Qiss.driver).click();
		Thread.sleep(3000);
		
		if (Qiss_Company_details_locators.taximeter_confirm_popup(Start_Qiss.driver).getText().contentEquals("Taxi meter tariff"))
			
		{
			System.out.println("New Tariffset added succesfully..");
			System.out.println("Test 3 Pass - Verify that adding valid tariff set, must save Tariff set successfully");
			sh1.getRow(120).createCell(3).setCellValue("PASS");
			fout = new FileOutputStream(file_location); wb.write(fout);
		}
		
		else 
		{
			System.out.println("---->>> Error in adding New Tariffset..<<<----");
			sh1.getRow(120).createCell(3).setCellValue("FAIL");
			fout = new FileOutputStream(file_location); wb.write(fout);
		}

		Start_Qiss.driver.findElement(By.xpath("/html/body/div[14]/div[3]/div/button")).click();
		Start_Qiss.driver.navigate().refresh();
		Thread.sleep(2000);
		
		gettariffname();

		/*List<WebElement> tariff_list = driver.findElements(By.xpath("//*[@class='viewtaximetertariff_option']/div"));

		for (WebElement loop3 : tariff_list) {
			System.out.println(loop3.getText());
			if (loop3.getText().contentEquals("Test Automation")) {
				loop3.click();
				 Selecting and Printing break configuration selected option 
				System.out.println("Navigated to Test Automation tariff set succesfully");
				break;
			}
		}*/

		
		
		/* Verify that maintain tariff details are editable */

		Thread.sleep(2000);
		Qiss_Company_details_locators.tariff_edit_btn(Start_Qiss.driver).click();
		System.out.println("Maintain popup opened succesfully..");
		Qiss_Company_details_locators.maintain_tarif_name(Start_Qiss.driver).sendKeys(" New");
		Qiss_Company_details_locators.confirm_btn_maintain(Start_Qiss.driver).click();

		if (Start_Qiss.driver.findElement(By.xpath("//*[@id='TMTariffTable']/tbody/tr/td[3]/label"))
				.getText() != "Test_Tariff New") {
			System.out.println("Tariff edited succesfully..");
			System.out.println("Test 4 Pass - Verify that maintain tariff details are editable");
			
			sh1.getRow(121).createCell(3).setCellValue("PASS");
			fout = new FileOutputStream(file_location); wb.write(fout);

		} else {
			System.out.println("Error in editing Tariff..");
			sh1.getRow(121).createCell(3).setCellValue("FAIL");
			fout = new FileOutputStream(file_location); wb.write(fout);
		}

		/* Verify that copy tariff functionality is working fine */

		Thread.sleep(2000);
		Qiss_Company_details_locators.tariff_copy_btn(Start_Qiss.driver).click();

		Qiss_Company_details_function.dropdown_maintain_tariff();

		Qiss_Company_details_locators.maintain_tarif_name(Start_Qiss.driver).sendKeys(" Copy");

		tariffBox("divNightTimeTariffContainer", "NightTimeTariff");
		tariffBox("divWeekendDayTimeTariffContainer", "WeekendDayTimeTariff");
		tariffBox("divWeekendNightTimeTariffContainer", "WeekendNightTimeTariff");
		
		Qiss_Company_details_locators.confirm_btn_maintain(Start_Qiss.driver).click();
		
		if (Start_Qiss.driver.findElement(By.xpath("//label[contains(text(),'Test_Tariff New Copy')]")).getText().contentEquals("Test_Tariff New Copy"))
		{
			System.out.println("Tariff copied successfully");
			sh1.getRow(122).createCell(3).setCellValue("PASS");
			fout = new FileOutputStream(file_location); wb.write(fout);
		}
		else
		{
			System.out.println("Error in copying tariff");
			sh1.getRow(122).createCell(3).setCellValue("FAIL");
			fout = new FileOutputStream(file_location); wb.write(fout);
		}
		
		Thread.sleep(2000);
		Qiss_Company_details_function.tariff_remove();
		
		Qiss_Company_details_locators.Save_btn_taximetertariff(Start_Qiss.driver).click();
		
		/*Verify that all tariff deleted or not*/
		
		if (Start_Qiss.driver.findElement(By.xpath("//li[contains(text(),'Please provide atleast one tariff for a tariffset period')]")).getText().contentEquals("Please provide atleast one tariff for a tariffset period"))
		{
		
			System.out.println("Successfully deleted all tariffs");
			sh1.getRow(123).createCell(3).setCellValue("PASS");
			fout = new FileOutputStream(file_location); wb.write(fout);
		}
		
		else
		{
			System.out.println("Error in deleting all tariffs");
			sh1.getRow(123).createCell(3).setCellValue("FAIL");
			fout = new FileOutputStream(file_location); wb.write(fout);
		}
		
		/*Verify that "Test Automation" tariff removed or not*/
		
		Qiss_Company_details_locators.remove_tariffset(Start_Qiss.driver).click();
		
		(Start_Qiss.driver).findElement(By.xpath("//button[contains(text(),'Yes')]")).click();
		
		gettariffname_details();
		Thread.sleep(2000);
		System.out.println("Navigating Receipt page");
		
		
	}
	
	public static void gettariffname()
	{
		List<WebElement> tariff_list = Start_Qiss.driver.findElements(By.xpath("//*[@class='viewtaximetertariff_option']/div"));

		for (WebElement loop3 : tariff_list) {
			System.out.println(loop3.getText());
			if (loop3.getText().contentEquals("Test Automation")) {
				loop3.click();
				/* Selecting and Printing break configuration selected option */
				System.out.println("Navigated to Test Automation tariff set succesfully");
				break;
			}
		}
	}

	public static void gettariffname_details() throws InterruptedException
	{
		List<WebElement> tariff_list = Start_Qiss.driver.findElements(By.xpath("//*[@class='viewtaximetertariff_option']/div"));

		for (WebElement loop3 : tariff_list) {
			
			if (loop3.getText().contentEquals("Test Automation")) 
			{
				
				
				System.out.println("Tariff set not removed");
			}
				else 
				{
					System.out.println("Tariffset Removed succesfully");
					Thread.sleep(2000);
					Qiss_Company_details_locators.ok_button(Start_Qiss.driver).click();
				}
				break;
			}
		}
	
	
	/**
	 * This function is used for fill values in tariff
	 * 
	 * @param idTariffName
	 *            - Parent tariff
	 * @param subTariff
	 *            - Sub tariff values
	 */
	public  static void tariffBox(String idTariffName, String subTariff)
	
	{
		List<WebElement> tariffs = Start_Qiss.driver.findElements(By.xpath("//*[@id='" + idTariffName
				+ "']//following::input[contains(@name,'CurrentTariffSetPeriod.TariffList[1]." + subTariff
				+ "')][@type='text']"));

		for (WebElement loop3 : tariffs) {
			loop3.sendKeys("07");

		}
	}
	
	public static void reciept () throws Exception
	{
		Thread.sleep(3000);
		
		/*driver.get("https://qiss-test.quipment.nl/Company/MaintainCompany/700?selectTab=7");
		Thread.sleep(3000);*/
		Qiss_Company_details_locators.Receipt_tab(Start_Qiss.driver).click();
		
		Thread.sleep(2000);
		
		/*Verify to navigate receipt page*/
		
		if (Qiss_Company_details_locators.Receipt_tab(Start_Qiss.driver).getAttribute("class").contentEquals("active")) {
			System.out.println("Successfully navigated to Receipt page..");
			sh1.getRow(124).createCell(3).setCellValue("PASS");
			fout = new FileOutputStream(file_location); wb.write(fout);
			
		} else {
			System.out.println("Error in clicking button");
			sh1.getRow(124).createCell(3).setCellValue("FAIL");
			fout = new FileOutputStream(file_location); wb.write(fout);}
		
		Thread.sleep(3000);
		
		/* Verify to Navigate to Receipt tab*/
		Qiss_Company_details_locators.Receipt(Start_Qiss.driver).click();
		
		if (Qiss_Company_details_locators.Receipt(Start_Qiss.driver).getAttribute("class").contentEquals("selected"))
		{
			System.out.println("Successfully Navigate to Receipt tab");
			sh1.getRow(125).createCell(3).setCellValue("PASS");
			fout = new FileOutputStream(file_location); wb.write(fout);
		}
		else
		{
			System.out.println("Error in Navigate to Receipt tab");
			sh1.getRow(125).createCell(3).setCellValue("FAIL");
			fout = new FileOutputStream(file_location); wb.write(fout);
		}
		
		Thread.sleep(3000);
		
		/*Verify that 4 tabs are shown in receipt page */
		Qiss_Company_details_function.receipt_tabs();
		
		Thread.sleep(3000);
		
		/*Verify that Header are shown in Receipt tab */
		Qiss_Company_details_function.title_verify("Quipment receipt", (Qiss_Company_details_locators.quip_receipt_element(Start_Qiss.driver)));
		Qiss_Company_details_function.title_verify("Company receipt", (Qiss_Company_details_locators.company_receipt_element(Start_Qiss.driver)));
		
		/*Verify that user is able to add header in Header tab*/
		Qiss_Company_details_function.header_function("TmHeader");
		
		Thread.sleep(3000);
		/*Verify that user is able to add in Footer tab*/
		Qiss_Company_details_function.header_function("TmFooter"); 
		
		Thread.sleep(3000);
		/*Navigate to Receipt tab*/
		Qiss_Company_details_locators.Receipt(Start_Qiss.driver).click();
		
		/*Adding new created header and footer in receipt tab for receipt no 6 */
		String receipt_no = "6";
		
		/*Finding receipt no 6 locator from list of locators */
		List<WebElement> receipts_locators = Start_Qiss.driver.findElements(By.xpath("//*[@id='TmReceiptsTable']/tbody/tr[6]/td/input"));
		for (WebElement loop:receipts_locators)
		{
			
			if (loop.getAttribute("value").contentEquals(receipt_no))
			{
				System.out.println("Receipt number found - " + loop.getAttribute("value"));
				
				/*Finding dropdown arrows locators from Header and footer drop down control */
				List<WebElement>  drop_down_locators = Start_Qiss.driver.findElements(By.xpath("//*[@id='TmReceiptsTable']/tbody/tr[6]/td/span/span/span/span"));
				
				for (WebElement arrow:drop_down_locators)
				{
					int abc = drop_down_locators.size();
					System.out.println("Locators found are - " +abc);
					Thread.sleep(2000);
					/*Clicking on dropdown arrow locator */
					arrow.click();
					Thread.sleep(2000);
					
					/*Finding locators for options list from dropdown control  */
					List<WebElement>  options_list_locators = Start_Qiss.driver.findElements(By.xpath("//*[@class='k-animation-container']/div/div[2]/ul/li"));
					
						for(WebElement list : options_list_locators)
						{
							/*Check Header/Footer list drop down list contains "Header_name_test_auto", click on it*/
							if (list.getText().contentEquals("Header_name_test_auto"))
							{
								list.click();
								Thread.sleep(2000);
								break;
							}
						
						}
				}
				break;
			}
			else
			{
			System.out.println("Searching Receipt Number");
			}
		}
		
		Qiss_Company_details_locators.save_button_receipt(Start_Qiss.driver).click();
		Thread.sleep(2000);
		Qiss_Company_details_locators.ok_button(Start_Qiss.driver).click();
		
		/*Verifying the header/footer dropdown control contains option "Header_name_test_auto" or not */
		
		Thread.sleep(2000);
		List<WebElement>  locators = Start_Qiss.driver.findElements(By.xpath("//*[@id='TmReceiptsTable']/tbody/tr[6]/td/following::span[contains (text(),'Header_name_test_auto')]"));
		for(WebElement verify : locators)
		{
		 	if (verify.getText().contentEquals("Header_name_test_auto"))
		 		{
		 			System.out.println("Option successfully selected from drop down list");
		 		}
		 	else
		 		{
		 		System.out.println("Error in selecting option from drop down list");
		 		}
	  }
	
	/*	Verify that user is able to delete header in Header tab
		Qiss_Company_details_function.header_delete_function("TmHeader");
		
		Thread.sleep(3000);
		
		Verify that user is able to delete header in Header tab
		Qiss_Company_details_function.header_delete_function("TmFooter");*/
	}
		
	
	
}
