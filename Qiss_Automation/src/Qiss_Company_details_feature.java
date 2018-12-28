import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Qiss_Company_details_feature {

	public static WebDriver driver = null;
	public static WebDriverWait wait;

	public static File src;
	public static FileInputStream fis;
	public static XSSFWorkbook wb;
	public static XSSFSheet sh1;
	public static FileOutputStream fout;
	public static String file_location = "C:\\Users\\ritesh.jhaveri\\Documents\\Ritesh\\Qiss_Automation_Checklist.xlsx";
	public static String Count, record_count, comp_count;
	public Actions action;

	public void login() throws Exception

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

		wait = new WebDriverWait(driver, 60);

	}

	/* Waiting for page load */

	public static void waitForPageLoaded() {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};
		try {
			Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(expectation);
		} catch (Throwable error) {
			System.out.println("Timeout waiting for Page Load Request complete.");
		}
	}

	/* Login Qiss portal with ADFS */

	public void login_adfs() throws Exception

	{

		Qiss_Company_details_locators.uname(driver).sendKeys("ritesh.jhaveri@quipment.nl");
		Qiss_Company_details_locators.pass(driver).sendKeys("R!tesh@1989");
		Qiss_Company_details_locators.submit(driver).click();
		waitForPageLoaded();
		Qiss_Company_details_locators.company(driver).click();

	}

	/* Verify the Filter, Paging and Item per page for "Active" Companies */

	public void Active() throws Exception

	{
		if (Qiss_Company_details_locators.active(driver).getText().contentEquals("Active")) {
			System.out.println("Active records loaded successfully");
		}

		else {
			System.out.println("Error in loading Active records");
		}

		/* Verify that filter is working or not */

		if (Qiss_Company_details_function.filter()) {
			System.out.println("Data filtered with Company name succesfully");
			/*
			 * sh1.getRow(83).createCell(3).setCellValue("PASS"); fout = new
			 * FileOutputStream(file_location); wb.write(fout);
			 */
		} else {
			System.out.println("Error in filtering data with Old value");
			/*
			 * sh1.getRow(83).createCell(3).setCellValue("FAIL"); fout = new
			 * FileOutputStream(file_location); wb.write(fout);
			 */
		}

		/* Verify that able to clear data from filter */

		if (Qiss_Company_details_function.clear()) {
			System.out.println("Data cleared successfuly");
			/*
			 * sh1.getRow(84).createCell(3).setCellValue("PASS"); fout = new
			 * FileOutputStream(file_location); wb.write(fout);
			 */
		} else {
			System.out.println("Error is clearing data");
			/*
			 * sh1.getRow(84).createCell(3).setCellValue("FAIL"); fout = new
			 * FileOutputStream(file_location); wb.write(fout);
			 */
		}

		/* Verify that paging is working or not */

		if (Qiss_Company_details_function.paging()) {
			System.out.println("Paging worked succesfully");
			/*
			 * sh1.getRow(85).createCell(3).setCellValue("PASS"); fout = new
			 * FileOutputStream(file_location); wb.write(fout);
			 */
		} else {
			System.out.println("Error is paging data");
			/*
			 * sh1.getRow(85).createCell(3).setCellValue("FAIL"); fout = new
			 * FileOutputStream(file_location); wb.write(fout);
			 */
		}

		/* Verify that Item per page is working or not */

		if (Qiss_Company_details_function.item_page()) {
			System.out.println("Navigating item per page succesfully");
			/*
			 * sh1.getRow(86).createCell(3).setCellValue("PASS"); fout = new
			 * FileOutputStream(file_location); wb.write(fout);
			 */
		} else {
			System.out.println("Error is navigating item per page");
			/*
			 * sh1.getRow(86).createCell(3).setCellValue("FAIL"); fout = new
			 * FileOutputStream(file_location); wb.write(fout);
			 */
		}

		driver.navigate().refresh();
	}

	/* Verify the Filter, Paging and Item per page for "InActive" Companies */

	public void Inactive() throws Exception

	{

		waitForPageLoaded();
		Thread.sleep(2000);
		Qiss_Company_details_locators.inactive(driver).click();
		waitForPageLoaded();

		if (Qiss_Company_details_locators.inactive(driver).getText().contentEquals("Inactive")) {
			System.out.println("Inactive records loaded successfully");
		}

		else {
			System.out.println("Error in loading Inactive records");
		}

		/* Verify that filter is working or not */

		if (Qiss_Company_details_function.filter()) {
			System.out.println("Data filtered with Company name succesfully");
			/*
			 * sh1.getRow(83).createCell(3).setCellValue("PASS"); fout = new
			 * FileOutputStream(file_location); wb.write(fout);
			 */
		} else {
			System.out.println("Error in filtering data with Old value");
			/*
			 * sh1.getRow(83).createCell(3).setCellValue("FAIL"); fout = new
			 * FileOutputStream(file_location); wb.write(fout);
			 */
		}

		/* Verify that able to clear data from filter */

		if (Qiss_Company_details_function.clear()) {
			System.out.println("Data cleared successfuly");
			/*
			 * sh1.getRow(84).createCell(3).setCellValue("PASS"); fout = new
			 * FileOutputStream(file_location); wb.write(fout);
			 */
		} else {
			System.out.println("Error is clearing data");
			/*
			 * sh1.getRow(84).createCell(3).setCellValue("FAIL"); fout = new
			 * FileOutputStream(file_location); wb.write(fout);
			 */
		}

		/* Verify that paging is working or not */

		if (Qiss_Company_details_function.paging()) {
			System.out.println("Paging worked succesfully");
			/*
			 * sh1.getRow(85).createCell(3).setCellValue("PASS"); fout = new
			 * FileOutputStream(file_location); wb.write(fout);
			 */
		} else {
			System.out.println("Error is paging data");
			/*
			 * sh1.getRow(85).createCell(3).setCellValue("FAIL"); fout = new
			 * FileOutputStream(file_location); wb.write(fout);
			 */
		}

		/* Verify that Item per page is working or not */

		if (Qiss_Company_details_function.item_page()) {
			System.out.println("Navigating item per page succesfully");
			/*
			 * sh1.getRow(86).createCell(3).setCellValue("PASS"); fout = new
			 * FileOutputStream(file_location); wb.write(fout);
			 */
		} else {
			System.out.println("Error is navigating item per page");
			/*
			 * sh1.getRow(86).createCell(3).setCellValue("FAIL"); fout = new
			 * FileOutputStream(file_location); wb.write(fout);
			 */
		}

		driver.navigate().refresh();
	}

	/* Verify the Filter, Paging and Item per page for "ALL" Companies */

	public void All() throws Exception

	{

		waitForPageLoaded();
		Thread.sleep(2000);
		Qiss_Company_details_locators.all(driver).click();
		waitForPageLoaded();

		if (Qiss_Company_details_locators.all(driver).getText().contentEquals("All")) {
			System.out.println("All records loaded successfully");
		}

		else {
			System.out.println("Error in loading All records");
		}

		/* Verify that filter is working or not */

		if (Qiss_Company_details_function.filter()) {
			System.out.println("Data filtered with Company name succesfully");
			/*
			 * sh1.getRow(83).createCell(3).setCellValue("PASS"); fout = new
			 * FileOutputStream(file_location); wb.write(fout);
			 */
		} else {
			System.out.println("Error in filtering data with Old value");
			/*
			 * sh1.getRow(83).createCell(3).setCellValue("FAIL"); fout = new
			 * FileOutputStream(file_location); wb.write(fout);
			 */
		}

		/* Verify that able to clear data from filter */

		if (Qiss_Company_details_function.clear()) {
			System.out.println("Data cleared successfuly");
			/*
			 * sh1.getRow(84).createCell(3).setCellValue("PASS"); fout = new
			 * FileOutputStream(file_location); wb.write(fout);
			 */
		} else {
			System.out.println("Error is clearing data");
			/*
			 * sh1.getRow(84).createCell(3).setCellValue("FAIL"); fout = new
			 * FileOutputStream(file_location); wb.write(fout);
			 */
		}

		/* Verify that paging is working or not */

		if (Qiss_Company_details_function.paging()) {
			System.out.println("Paging worked succesfully");
			/*
			 * sh1.getRow(85).createCell(3).setCellValue("PASS"); fout = new
			 * FileOutputStream(file_location); wb.write(fout);
			 */
		} else {
			System.out.println("Error is paging data");
			/*
			 * sh1.getRow(85).createCell(3).setCellValue("FAIL"); fout = new
			 * FileOutputStream(file_location); wb.write(fout);
			 */
		}

		/* Verify that Item per page is working or not */

		if (Qiss_Company_details_function.item_page()) {
			System.out.println("Navigating item per page succesfully");
			/*
			 * sh1.getRow(86).createCell(3).setCellValue("PASS"); fout = new
			 * FileOutputStream(file_location); wb.write(fout);
			 */
		} else {
			System.out.println("Error is navigating item per page");
			/*
			 * sh1.getRow(86).createCell(3).setCellValue("FAIL"); fout = new
			 * FileOutputStream(file_location); wb.write(fout);
			 */
		}
		driver.navigate().refresh();

	}

	/*
	 * Verify the keeping Mandatory fields blank display validation error
	 * message
	 */

	public void Vehicle() throws Exception

	{
		waitForPageLoaded();
		Qiss_Company_details_locators.active(driver).click();
		Thread.sleep(2000);
		Qiss_Company_details_locators.filter_icon(driver).click();
		Qiss_Company_details_locators.filter_data(driver).sendKeys("Insigno");
		Qiss_Company_details_locators.filter_btn(driver).click();
		waitForPageLoaded();
		Qiss_Company_details_locators.navigation_arrow(driver).click();

		Thread.sleep(5000);

		/* Clicking on New Vehicle button and clearing all mandatory fields */

		Qiss_Company_details_locators.New_vehicle_btn(driver).click();
		Qiss_Company_details_locators.Ping_timeout(driver).clear();
		Qiss_Company_details_locators.Ping_retries(driver).clear();
		Qiss_Company_details_locators.Radius(driver).clear();
		Qiss_Company_details_locators.Stat_time(driver).clear();

		/* Clicking on "Confirm" button display validation error message */

		Qiss_Company_details_locators.Confirm_btn(driver).click();
		waitForPageLoaded();

		if (Qiss_Company_details_locators.Vehicle_no_error(driver).getText()
				.contentEquals("Vehicle number is required.")
				&& Qiss_Company_details_locators.Ping_timeout_error(driver).getText()
						.contentEquals("Ping Timeout (seconds) is required.")
				&& Qiss_Company_details_locators.Ping_retries_error(driver).getText()
						.contentEquals("Ping Retries is required.")
				&& Qiss_Company_details_locators.radius_error(driver).getText()
						.contentEquals("Radius (meters) is required.")
				&& Qiss_Company_details_locators.stat_time_error(driver).getText()
						.contentEquals("Stationary time (seconds) is required."))

		{
			System.out.println("Validation messages are shown");
			/*
			 * sh1.getRow(75).createCell(3).setCellValue("PASS"); fout = new
			 * FileOutputStream(file_location); wb.write(fout);
			 */

		}

		else {
			System.out.println("Validation messages are not shown");
			/*
			 * sh1.getRow(75).createCell(3).setCellValue("FAIL"); fout = new
			 * FileOutputStream(file_location); wb.write(fout);
			 */
		}
		Qiss_Company_details_locators.back_btn(driver).click();

	}

	/* Verify the Overall Items are shown for Product in Product items page */

	public void Product() throws Exception

	{
		Thread.sleep(2000);
		waitForPageLoaded();
		Qiss_Company_details_locators.product(driver).click();

		if (Qiss_Company_details_locators.count(driver).getText().contentEquals("No items to display")) {
			System.out.println("No Product data available to display or Error is showing product data");
		}

		else {
			System.out.println("Product items are shown successfully.!");
		}
	}

	/* Verify Qupido router functionlaity */

	public void QupidoRouter() throws Exception

	{
		waitForPageLoaded();
		Qiss_Company_details_locators.QupidoRouter(driver).click();
		Thread.sleep(5000);

		/* Verify default records for qupido router is avilable or not */

		if (Qiss_Company_details_locators.count(driver).getText().contentEquals("No items to display")) {
			System.out.println("No records found for qupido router");
		}

		else {
			System.out.println("Records found for Qupido router");
		}

		/*
		 * Verfiy that clearing mandatory fields and clicking on confirmed buton
		 * must show validation message
		 */

		Qiss_Company_details_locators.New_QupidoRouter_btn(driver).click();
		Qiss_Company_details_locators.Username(driver).clear();
		Qiss_Company_details_locators.Password(driver).clear();
		Qiss_Company_details_locators.filepath(driver).clear();
		Qiss_Company_details_locators.confirmQupidoRouter_btn(driver).click();

		if (Qiss_Company_details_locators.routername_error(driver).getText().contentEquals("Router name is required.")
				&& Qiss_Company_details_locators.IPaddress_error(driver).getText()
						.contentEquals("IP address is required.")
				&& Qiss_Company_details_locators.Username_error(driver).getText()
						.contentEquals("User name is required.")
				&& Qiss_Company_details_locators.password_error(driver).getText().contentEquals("Password is required.")
				&& Qiss_Company_details_locators.filepath_error(driver).getText()
						.contentEquals("File Path is required."))

		{
			System.out.println("Validation messages are shown");
			/*
			 * sh1.getRow(75).createCell(3).setCellValue("PASS"); fout = new
			 * FileOutputStream(file_location); wb.write(fout);
			 */

		}

		else {
			System.out.println("Validation messages are not shown");
			/*
			 * sh1.getRow(75).createCell(3).setCellValue("FAIL"); fout = new
			 * FileOutputStream(file_location); wb.write(fout);
			 */
		}

		Qiss_Company_details_locators.router_name(driver).sendKeys("Testing");
		Qiss_Company_details_locators.IPaddress(driver).sendKeys("100.99.100.99");
		Qiss_Company_details_locators.Port(driver).sendKeys("9999");
		Qiss_Company_details_locators.Username(driver).sendKeys("Ritesh");
		Qiss_Company_details_locators.Password(driver).sendKeys("Ritesh");
		Qiss_Company_details_locators.filepath(driver).sendKeys("\\QuipmentVAL\\qupido");
		Qiss_Company_details_locators.confirmQupidoRouter_btn(driver).click();
		waitForPageLoaded();

		if (Qiss_Company_details_locators.count(driver).getText().contentEquals("1 - 1 of 1 items")) {
			System.out.println("Record added for qupido router");
		}

		else {
			System.out.println("Error in adding record for Qupido router");
		}

		Qiss_Company_details_locators.navigation_arrow(driver).click();
		waitForPageLoaded();

		Qiss_Company_details_locators.remove_qupido_router_btn(driver).click();
		Qiss_Company_details_locators.yes_btn_qupido_router_popup(driver).click();

		if (Qiss_Company_details_locators.count(driver).getText().contentEquals("No items to display")) {
			System.out.println("Records removed from qupido router");
		}

		else {
			System.out.println("Error in deleting record for Qupido router");
		}

	}

	public void Dispatcher() throws Exception

	{
		/* Verify that navigation is performed at dispatcher page or not */

		Thread.sleep(2000);
		waitForPageLoaded();
		Qiss_Company_details_locators.dispatcher(driver).click();

		if (Qiss_Company_details_locators.dispatcher(driver).getAttribute("class").contentEquals("active")) {
			System.out.println("Successfuly navigated to Dispatcher page");
		} else {
			System.out.println("Error in clicking button");
		}

		if (Qiss_Company_details_locators.count(driver).getText().contentEquals("No items to display")) {
			System.out.println("No dispatcher data available to display or Error is showing dispatcher data");
		}

		else {
			System.out.println("Dispatcher data are shown successfully.!");
		}
	}

	public void Subscription() throws Exception

	{
		/* Verify that navigation is performed at subscription page or not */

		Thread.sleep(2000);
		waitForPageLoaded();
		Qiss_Company_details_locators.subscription(driver).click();

		if (Qiss_Company_details_locators.subscription(driver).getAttribute("class").contentEquals("active")) {
			System.out.println("Successfuly navigated to Subscription page");
		} else {
			System.out.println("Error in clicking button");
		}

		if (Qiss_Company_details_locators.count(driver).getText().contentEquals("No items to display")) {
			System.out.println("No Subscription data available to display or Error is showing Subscription data");
		}

		else {
			System.out.println("Subscription data are shown successfully.!");
		}
	}

	public void Configuration() throws Exception

	{
		/* Verify that navigation is performed at configuration page or not */

		Thread.sleep(5000);

		Qiss_Company_details_locators.configuration(driver).click();

		if (Qiss_Company_details_locators.configuration(driver).getAttribute("class").contentEquals("active")) {
			System.out.println("Successfuly navigated to Configuration page");
		} else {
			System.out.println("Error in clicking button");
		}
		Thread.sleep(5000);
		Qiss_Company_details_locators.trip_sorting_dropdownlist_arrow(driver).click();
		Thread.sleep(2000);

		/* Verify that trip sorting option button is working or not */

		List<WebElement> elem = driver.findElements(By.cssSelector("#QrisConfiguration_TripSortingStyle_listbox li"));

		for (WebElement loop1 : elem) {
			if (loop1.getAttribute("class").contentEquals("k-item k-state-selected k-state-focused")) {

				/* Printing current trip sort option */

				System.out.println("Current trip sorting selected is - " + loop1.getAttribute("innerHTML"));
			} else {
				/* Selecting and Printing trip sort selected option */

				loop1.click();
				Thread.sleep(2000);
				System.out.println("Selected trip sorting option is - " + loop1.getAttribute("innerHTML"));
				break;
			}
		}
		Thread.sleep(2000);

		List<WebElement> list = driver.findElements(By.xpath("//*[@id='CompanyMemoTable']/tbody/tr/td/input"));
		int count_element = list.size();
		System.out.println(count_element);

		/* Verify that break permitted option button is working or not */

		System.out.println("Current break configuration is - " + driver
				.findElement(By.xpath("//span[@aria-owns = 'QrisConfiguration_BreakPermitted_listbox']/span/span"))
				.getAttribute("innerHTML"));
		driver.findElement(By.xpath("//*[@aria-owns = 'QrisConfiguration_BreakPermitted_listbox']/span/span/span"))
				.click();
		
		List<WebElement> break_list = driver
				.findElements(By.cssSelector("#QrisConfiguration_BreakPermitted_listbox li"));
		Thread.sleep(3000);
		for (WebElement loop3 : break_list) {
			System.out.println(loop3.getAttribute("innerHTML"));
			if (!loop3.getAttribute("class").contentEquals("k-item k-state-selected k-state-focused")) {
				loop3.click();
				/* Selecting and Printing break configuration selected option */
				System.out.println("Break configuration is selected to - " + loop3.getAttribute("innerHTML"));
				break;
			}
		}

		/* Verify the save and generate functionlaity is working or not */

		Qiss_Company_details_locators.save_btn(driver).click();
		waitForPageLoaded();
		Thread.sleep(5000);

		/* Verify that saved popup is shown or not */

		if (Qiss_Company_details_locators.config_label(driver).getAttribute("innerHTML")
				.contentEquals("Configuration")) {
			System.out.println("Data saved succesfully.!");
		} else {
			System.out.println("Issue in Data saving.!");
		}

		Qiss_Company_details_locators.OK_btn(driver).click();
		Thread.sleep(3000);
		Qiss_Company_details_locators.generateconfig(driver).click();
		Thread.sleep(3000);

		/* Verify that generate popup is shown or not */

		if (Qiss_Company_details_locators.config_label(driver).getAttribute("innerHTML")
				.contentEquals("Generate configuration")) {
			System.out.println("Generate popup is shown.!");
		} else {
			System.out.println("Generate popup not shown.!");
		}

		Qiss_Company_details_locators.yes_btn_gen_config(driver).click();
		Thread.sleep(3000);

		/*
		 * Verify that after clicking on YES button config popup is shown or not
		 */

		if (Qiss_Company_details_locators.config_label(driver).getAttribute("innerHTML")
				.contentEquals("Maintain company")) {
			System.out.println("Configuration generated successfully");
		} else {
			System.out.println("Error in Generating config.");
		}

		Qiss_Company_details_locators.ok_btn_maintain_company(driver).click();
	}

	
	public void Taximeter_tariff() throws Exception

	{

		/*
		 * Verify that navigation is performed at Tariffset tariff page or not
		 */

		Thread.sleep(5000);
		driver.navigate().to("https://qiss-test.quipment.nl/Company/MaintainCompany/700?selectTab=6");

		// Qiss_Company_details_locators.Tariffset_tariff(driver).click();

		if (Qiss_Company_details_locators.Tariffset_tariff(driver).getAttribute("class").contentEquals("active")) {
			System.out.println("Successfuly navigated to Tariffset tariff page..");
		} else {
			System.out.println("Error in clicking button");
		}

		/*
		 * Verfiy that clearing mandatory fields and clicking on save buton must
		 * show validation message
		 */

		Qiss_Company_details_locators.Tariffset(driver).clear();
		Qiss_Company_details_locators.Max_total_amount(driver).clear();
		Qiss_Company_details_locators.supplement_amount(driver).clear();

		Qiss_Company_details_locators.Save_btn_taximetertariff(driver).click();

		if (Qiss_Company_details_locators.tariffset_error_msg(driver).getText().contentEquals("Tariffset is required.")
				&& Qiss_Company_details_locators.maxtotal_error_msg(driver).getText()
						.contentEquals("Max total amount is required.")
				&& Qiss_Company_details_locators.amount_error_msg(driver).getText()
						.contentEquals("Amount is required."))

		{
			System.out.println("Validation messages are shown");
			/*
			 * sh1.getRow(75).createCell(3).setCellValue("PASS"); fout = new
			 * FileOutputStream(file_location); wb.write(fout);
			 */

		}

		else {
			System.out.println("Validation messages are not shown");
			/*
			 * sh1.getRow(75).createCell(3).setCellValue("FAIL"); fout = new
			 * FileOutputStream(file_location); wb.write(fout);
			 */
		}

		/*---Verify adding, editing and deleting tarriffset---*/

		driver.navigate().refresh();
		Thread.sleep(2000);
		Qiss_Company_details_locators.New_tarriffset_btn(driver).click();
		Thread.sleep(1000);

		Qiss_Company_details_function.select_date();
		Thread.sleep(2000);

		Qiss_Company_details_locators.Save_btn_taximetertariff(driver).click();
		Thread.sleep(2000);

		/*--Verify that clicking on save button directly without entering data, must show validation message--*/

		if (Qiss_Company_details_locators.tariffset_error_msg(driver).getText().contentEquals("Tariffset is required.")
				&& Qiss_Company_details_locators.tariffset_period_error_msg(driver).getText()
						.contentEquals("Please provide atleast one tariff for a tariffset period"))

		{
			System.out.println("Validation messages are shown..");
			/*
			 * sh1.getRow(75).createCell(3).setCellValue("PASS"); fout = new
			 * FileOutputStream(file_location); wb.write(fout);
			 */

		}

		else {
			System.out.println("Validation messages are not shown");
			/*
			 * sh1.getRow(75).createCell(3).setCellValue("FAIL"); fout = new
			 * FileOutputStream(file_location); wb.write(fout);
			 */
		}

		System.out.println(
				"Test 1 Pass - Verify that clicking on save button directly without entering data, must show validation message ");

		/*---Verify that adding valid tariff set, must save Tariff set successfully---*/

		driver.navigate().refresh();
		Thread.sleep(2000);
		Qiss_Company_details_locators.New_tarriffset_btn(driver).click();
		Thread.sleep(3000);
		Qiss_Company_details_locators.tariffset_textbox(driver).sendKeys("Test Automation");
		Thread.sleep(3000);
		Qiss_Company_details_function.select_date();
		Thread.sleep(2000);
		Qiss_Company_details_locators.Add_tariffs(driver).click();
		Thread.sleep(2000);

		/*
		 * Verify that clicking on Confirm button directly without entering data
		 * in maintain tariff popup, must show validation message
		 */

		Qiss_Company_details_locators.confirm_btn_maintain(driver).click();

		if (Qiss_Company_details_locators.maintain_tariff_name_tariff_error_message(driver).getText()
				.contentEquals("Name of tariff is required.")
				&& Qiss_Company_details_locators.maintain_tariff_desc_tariff_error_message(driver).getText()
						.contentEquals("Description of tariff is required.")
				&& Qiss_Company_details_locators.maintain_tariff_waiting_time_error_message(driver).getText()
						.contentEquals("Waiting time fee/hr of tariff is required.")
				&& Qiss_Company_details_locators.maintain_tariff_initial_fee_error_message(driver).getText()
						.contentEquals("Initial fee is required.")
				&& Qiss_Company_details_locators.maintain_tariff_distance_fee_error_message(driver).getText()
						.contentEquals("Distance fee/km is required.")
				&& Qiss_Company_details_locators.maintain_tariff_time_fee_error_message(driver).getText()
						.contentEquals("Time fee/hr is required."))

		{
			System.out.println("Validation messages are shown..");
			System.out.println(
					"Test 2 Pass - Verify that clicking on Confirm button directly without entering data in maintain tariff popup, must show validation message");
			/*
			 * sh1.getRow(75).createCell(3).setCellValue("PASS"); fout = new
			 * FileOutputStream(file_location); wb.write(fout);
			 */

		}

		else {
			System.out.println("Validation messages are not shown");
			/*
			 * sh1.getRow(75).createCell(3).setCellValue("FAIL"); fout = new
			 * FileOutputStream(file_location); wb.write(fout);
			 */
		}

		Qiss_Company_details_locators.maintain_tarif_name(driver).sendKeys("Test_Tariff");
		Qiss_Company_details_locators.maintain_tarif_descp(driver).sendKeys("Descp Test_Tariff");
		Qiss_Company_details_locators.maintain_waiting(driver).sendKeys("7777");
		Qiss_Company_details_locators.maintain_initial(driver).sendKeys("7");
		Qiss_Company_details_locators.maintain_time(driver).sendKeys("4777");
		Qiss_Company_details_locators.maintain_distance(driver).sendKeys("9777");
		Thread.sleep(1000);
		Qiss_Company_details_locators.confirm_btn_maintain(driver).click();
		Thread.sleep(1000);
		Qiss_Company_details_locators.Save_btn_taximetertariff(driver).click();
		Thread.sleep(1000);
		if (Qiss_Company_details_locators.taximeter_confirm_popup(driver).getText() == "Taxi meter tariff")
			;
		{
			System.out.println("New Tariffset added succesfully..");
			System.out.println("Test 3 Pass - Verify that adding valid tariff set, must save Tariff set successfully");
		}

		driver.findElement(By.xpath("/html/body/div[14]/div[3]/div/button")).click();
		driver.navigate().refresh();
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
		Qiss_Company_details_locators.tariff_edit_btn(driver).click();
		System.out.println("Maintain popup opened succesfully..");
		Qiss_Company_details_locators.maintain_tarif_name(driver).sendKeys(" New");
		Qiss_Company_details_locators.confirm_btn_maintain(driver).click();

		if (driver.findElement(By.xpath("//*[@id='TMTariffTable']/tbody/tr/td[3]/label"))
				.getText() != "Test_Tariff New") {
			System.out.println("Tariff edited succesfully..");
			System.out.println("Test 4 Pass - Verify that maintain tariff details are editable");

		} else {
			System.out.println("Error in editing Tariff..");
		}

		/* Verify that copy tariff functionality is working fine */

		Thread.sleep(2000);
		Qiss_Company_details_locators.tariff_copy_btn(driver).click();

		Qiss_Company_details_function.dropdown_maintain_tariff();

		Qiss_Company_details_locators.maintain_tarif_name(driver).sendKeys(" Copy");

		tariffBox("divNightTimeTariffContainer", "NightTimeTariff");
		tariffBox("divWeekendDayTimeTariffContainer", "WeekendDayTimeTariff");
		tariffBox("divWeekendNightTimeTariffContainer", "WeekendNightTimeTariff");
		
		Qiss_Company_details_locators.confirm_btn_maintain(driver).click();
		
		if (driver.findElement(By.xpath("//label[contains(text(),'Test_Tariff New Copy')]")).getText().contentEquals("Test_Tariff New Copy"))
		{
			System.out.println("Tariff copied successfully");
		}
		else
		{
			System.out.println("Error in copying tariff");
		}
		
		Thread.sleep(2000);
		Qiss_Company_details_function.tariff_remove();
		
		Qiss_Company_details_locators.Save_btn_taximetertariff(driver).click();
		
		/*Verify that all tariff deleted or not*/
		
		if (driver.findElement(By.xpath("//li[contains(text(),'Please provide atleast one tariff for a tariffset period')]")).getText().contentEquals("Please provide atleast one tariff for a tariffset period"))
		{
		
			System.out.println("Successfully deleted all tariffs");
		}
		
		else
		{
			System.out.println("Error in deleting all tariffs");
		}
		
		/*Verify that "Test Automation" tariff removed or not*/
		
		Qiss_Company_details_locators.remove_tariffset(driver).click();
		
		(Qiss_Company_details_feature.driver).findElement(By.xpath("//button[contains(text(),'Yes')]")).click();
		
		gettariffname_details();
		
		System.out.println("SUCCESS.!!!");
		
		
	}
	
	public void gettariffname()
	{
		List<WebElement> tariff_list = driver.findElements(By.xpath("//*[@class='viewtaximetertariff_option']/div"));

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

	public void gettariffname_details()
	{
		List<WebElement> tariff_list = driver.findElements(By.xpath("//*[@class='viewtaximetertariff_option']/div"));

		for (WebElement loop3 : tariff_list) {
			
			if (loop3.getText().contentEquals("Test Automation")) 
			{
				
				
				System.out.println("Tariff set not removed");
			}
				else 
				{
					System.out.println("Tariffset Removed succesfully");
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
	public void tariffBox(String idTariffName, String subTariff)
	
	{
		List<WebElement> tariffs = driver.findElements(By.xpath("//*[@id='" + idTariffName
				+ "']//following::input[contains(@name,'CurrentTariffSetPeriod.TariffList[1]." + subTariff
				+ "')][@type='text']"));

		for (WebElement loop3 : tariffs) {
			loop3.sendKeys("07");

		}
	}
	
	public void reciept () throws Exception
	{
		
		driver.navigate().to("https://qiss-test.quipment.nl/Company/MaintainCompany/700");
		
		Thread.sleep(3000);
		
		/*Navigate to Receipt tab*/
		Qiss_Company_details_locators.Receipt(driver).click();
		
		Thread.sleep(3000);
		/*Verify that 4 tabs are shown in receipt page */
		Qiss_Company_details_function.receipt_tabs();
		
		Thread.sleep(3000);
		
		/*Verify that Header are shown in Receipt tab */
		Qiss_Company_details_function.title_verify("Quipment receipt", (Qiss_Company_details_locators.quip_receipt_element(driver)));
		Qiss_Company_details_function.title_verify("Company receipt", (Qiss_Company_details_locators.company_receipt_element(driver)));
		
		/*Verify that user is able to add/edit/delete header in Header tab*/
		Qiss_Company_details_function.header_function("TmHeader");
		
		Thread.sleep(3000);
		/*Verify that user is able to add/edit/delete in Footer tab*/
		Qiss_Company_details_function.header_function("TmFooter");
		
	}
		
	
	
}