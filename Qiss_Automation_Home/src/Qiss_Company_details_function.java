import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Qiss_Company_details_function {
	
	/*Verify that filter is working or not */
	public static boolean filter() throws Exception
	
	{
		
		Qiss_Company_details_feature.comp_count = Qiss_Company_details_locators.count(Start_Qiss.driver).getText();
		System.out.println(Qiss_Company_details_feature.comp_count);
		Qiss_Company_details_locators.filter_icon(Start_Qiss.driver).click();
		Qiss_Company_details_locators.filter_data(Start_Qiss.driver).sendKeys("Insigno Quipment");
		Qiss_Company_details_locators.filter_btn(Start_Qiss.driver).click();
		Qiss_Company_details_feature.waitForPageLoaded();
		
		if (Qiss_Company_details_locators.count(Start_Qiss.driver).getText() != Qiss_Company_details_feature.comp_count)
		
		{
			System.out.println("Data filter working");
			System.out.println(Qiss_Company_details_locators.count(Start_Qiss.driver).getText());
			return true;
		}
		
		else
		{
			System.out.println("Not working");
			System.out.println(Qiss_Company_details_locators.count(Start_Qiss.driver).getText());	
			return false;
		}
		
	}

	/*Verify that able to clear data from filter*/
	public static boolean clear() throws Exception
		
	{
		Qiss_Company_details_locators.filter_icon(Start_Qiss.driver).click();
		Thread.sleep(2000);
		Qiss_Company_details_locators.clear(Start_Qiss.driver).click();
		Qiss_Company_details_feature.waitForPageLoaded();
		
		if (Qiss_Company_details_locators.count(Start_Qiss.driver).getText().contentEquals(Qiss_Company_details_feature.comp_count))
		{
			System.out.println("Data clear succesfully from filter");
			System.out.println(Qiss_Company_details_locators.count(Start_Qiss.driver).getText());
			return true;
		}
		
		else
		{
			System.out.println("Error in clearing data from filter");
			System.out.println(Qiss_Company_details_locators.count(Start_Qiss.driver).getText());
			return false;
		}
			
	}	
	
	/*Verify that paging is working or not*/
	
	public static boolean paging() throws Exception
	
	{
	
		Qiss_Company_details_locators.page_3(Start_Qiss.driver).click();
		
		if (Qiss_Company_details_locators.count(Start_Qiss.driver).getText() != Qiss_Company_details_feature.comp_count)
		{
			System.out.println("Paging works succefully");
			System.out.println(Qiss_Company_details_locators.count(Start_Qiss.driver).getText());
			return true;
		}
		
		else
		{
			System.out.println("Paging Not working");
			System.out.println(Qiss_Company_details_locators.count(Start_Qiss.driver).getText());
			return true;
		}
	
	}
	
	/*Verify that Item per page is working or not*/
	public static boolean item_page() throws Exception
	
	{
		Qiss_Company_details_locators.scrol_btn(Start_Qiss.driver).click();
		Qiss_Company_details_feature.waitForPageLoaded();
		Qiss_Company_details_locators.click_30(Start_Qiss.driver).click();
		
		if (Qiss_Company_details_locators.count(Start_Qiss.driver).getText() != Qiss_Company_details_feature.comp_count)
		{
			System.out.println("Item per page works succesfully");
			System.out.println(Qiss_Company_details_locators.count(Start_Qiss.driver).getText());
			return true;
		}
		
		else
		{
			System.out.println("Item per page not working");
			System.out.println(Qiss_Company_details_locators.count(Start_Qiss.driver).getText());
			return false;
		}
	}
	
	public static boolean tariff_set() throws Exception
	
	{
		/*Click on new tariff set button*/
		
		Qiss_Company_details_locators.New_tarriffset_btn(Start_Qiss.driver).click();
		Thread.sleep(2000);
		Qiss_Company_details_locators.tariffset_textbox(Start_Qiss.driver).sendKeys("Test_Automation");
		Thread.sleep(3000);
		
		/*Click on Add button to select current date*/
		Qiss_Company_details_locators.Add_btn_tariff(Start_Qiss.driver).click();
		Thread.sleep(2000);
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date date = new Date();
		System.out.println("Current date is : " + formatter.format(date));
		Thread.sleep(2000);
		(Start_Qiss.driver).findElement(By.id("AddTariffSetPeriod")).sendKeys(formatter.format(date));
		Thread.sleep(2000);
		//(Start_Qiss.driver).findElement(By.xpath("//*[@id='divNewPeriod']/div/span/span/span/span")).sendKeys(Keys.ENTER);
		System.out.println("Current date is : " + formatter.format(date));
		//Qiss_Company_details_locators.cancel_btn(Start_Qiss.driver).click();
		return false;
	}
	
	public static boolean select_date() throws Exception
	
	{
		Qiss_Company_details_locators.Add_btn_tariff(Start_Qiss.driver).click();
		WebElement subElement = (Start_Qiss.driver).findElement(By.xpath("//*[@id='divNewPeriod']/div/span/span/span"));
		
		System.out.println("Selecting date");
		
		Actions action = new Actions((Start_Qiss.driver));
		Thread.sleep(2000);
		
	    action.moveToElement(subElement).click().perform();
	    Thread.sleep(2000);
	    
	    System.out.println("Date selected succesfully..");
	    
	    return false;	
	}	
	
	
	
	
	/*public static void test1 (String abc) throws Exception
	
	{
		System.out.println("Out");
		WebElement night_time_tariff_checkbox = (Start_Qiss.driver).findElement(By.id(abc));
		System.out.println(night_time_tariff_checkbox.getAttribute("id"));
		System.out.println("In");
		
		night_time_tariff_checkbox = (Start_Qiss.driver).findElement(By.id(abc));
		Thread.sleep(3000);
		
		JavascriptExecutor executor = (JavascriptExecutor)Start_Qiss.driver;
		System.out.println("In -1");
		Thread.sleep(3000);
		System.out.println("In -2");
		executor.executeScript("arguments[0].click();", night_time_tariff_checkbox);
	}*/
	
	public static boolean dropdown_maintain_tariff() throws Exception
	
	{
		//test1 ("CheckBoxIsNightTimeTariff");
		
    Thread.sleep(4000);
    
    /*(Start_Qiss.driver).findElement(By.xpath(" //span[@id='expandCollapsableNightTimeTariff']")).click();
    Thread.sleep(2000);
    (Start_Qiss.driver).findElement(By.xpath(" //span[@id='expandCollapsableWeekendDayTimeTariff']")).click();
    Thread.sleep(2000);
    (Start_Qiss.driver).findElement(By.xpath(" //span[@id='expandCollapsableWeekendNightTimeTariff']")).click();
    Thread.sleep(2000);*/
    
    WebElement night_time_tariff_checkbox = (Start_Qiss.driver).findElement(By.id("CheckBoxIsNightTimeTariff"));
	WebElement weekend_day_time_tariff_checkbox = (Start_Qiss.driver).findElement(By.id("CheckBoxIsWeekendDayTimeTariff"));
	WebElement weekend_night_time_tariff_checkbox = (Start_Qiss.driver).findElement(By.id("CheckBoxIsWeekendNightTimeTariff"));

	JavascriptExecutor executor = (JavascriptExecutor)Start_Qiss.driver;
	executor.executeScript("arguments[0].click();", night_time_tariff_checkbox);
	
	Thread.sleep(2000);
	executor.executeScript("arguments[0].click();", weekend_day_time_tariff_checkbox);
	
	Thread.sleep(2000);
	executor.executeScript("arguments[0].click();", weekend_night_time_tariff_checkbox);
	
	return false;
	
	}	
	
	public static boolean tariff_remove() throws Exception
	{
		//(Start_Qiss.driver).findElement(By.xpath("//div[@class='browse_content_edit']/div[@id='TMTariffGridRemoveButton']")).click();
		System.out.println("PASS");
		List<WebElement> delete_locators = (Start_Qiss.driver).findElements(By.xpath("//div[@class='browse_content_edit']/div[@id='TMTariffGridRemoveButton']"));
		
		for (WebElement action : delete_locators)
		{
			action.click();
			Thread.sleep(2000);
			(Start_Qiss.driver).findElement(By.xpath("//button[contains(text(),'Yes')]")).click();
		}
		
		return false;
		
	}
	
	public static void receipt_tabs() throws IOException
	{
		List<WebElement> test = (Start_Qiss.driver).findElements(By.xpath("//div[@class ='cell']/div/a"));
		for (WebElement iterate : test)
		{
			if (iterate.getText().contentEquals("Receipt"))
			{
				System.out.println("Receipt tab is shown");
				
				Qiss_Company_details_feature.sh1.getRow(126).createCell(3).setCellValue("PASS");
				Start_Qiss.fout = new FileOutputStream(Qiss_Company_details_feature.file_location); 
				Qiss_Company_details_feature.wb.write(Qiss_Company_details_feature.fout);
			}
			else if (iterate.getText().contentEquals("Header"))
			{
				System.out.println("Header tab is shown");
				
				Qiss_Company_details_feature.sh1.getRow(127).createCell(3).setCellValue("PASS");
				Qiss_Company_details_feature.fout = new FileOutputStream(Qiss_Company_details_feature.file_location); 
				Qiss_Company_details_feature.wb.write(Qiss_Company_details_feature.fout);
			}
			else if (iterate.getText().contentEquals("Footer"))
			{
				System.out.println("Footer tab is shown");
				
				Qiss_Company_details_feature.sh1.getRow(128).createCell(3).setCellValue("PASS");
				Qiss_Company_details_feature.fout = new FileOutputStream(Qiss_Company_details_feature.file_location); 
				Qiss_Company_details_feature.wb.write(Qiss_Company_details_feature.fout);
			}
			else if (iterate.getText().contentEquals("Company logo"))
			{
				System.out.println("Company tab is shown");
				
				Qiss_Company_details_feature.sh1.getRow(129).createCell(3).setCellValue("PASS");
				Qiss_Company_details_feature.fout = new FileOutputStream(Qiss_Company_details_feature.file_location); 
				Qiss_Company_details_feature.wb.write(Qiss_Company_details_feature.fout);
			}
			else
			{
				System.out.println("Tabs are missing in receipt page");				
			}
			
		}
		
	}
	
	public static void header_function (String id_value) throws Exception
	
	{
		WebElement header_footer_link = (Start_Qiss.driver).findElement(By.id(id_value));
		header_footer_link.click();
		Thread.sleep(5000);
		WebElement header = (Start_Qiss.driver).findElement(By.xpath("//div[@class='receipt_title']"));
		
		if (header.getText().contentEquals("Header"))
		{
			System.out.println("Header label is shown");
		}
		else if (header.getText().contentEquals("Footer"))
		{
			System.out.println("Footer label is shown");
		}
		else 
		{
			System.out.println("--> Header is not shown <--");
		}
		
		/*---> Function will pass string for adding header name and header description and also add two headers and save headers <---*/
		add_header_footer("Header_name_test_auto", "Header_description_test_auto");
	}
			
	public static void add_header_footer (String Header_name, String Header_description) throws Exception
	{
		/*Click on "+Add header button"*/
		Qiss_Company_details_locators.add_header(Start_Qiss.driver).click();
		Thread.sleep(2000);
		
		/*Enter the name and description*/
		Qiss_Company_details_locators.header_name(Start_Qiss.driver).sendKeys(Header_name);
		Qiss_Company_details_locators.header_description(Start_Qiss.driver).sendKeys(Header_description);
		Thread.sleep(2000);
		
		/*Click on "+Add header line" button twcie to add the header line*/
		Qiss_Company_details_locators.add_header_line(Start_Qiss.driver).click();
		Qiss_Company_details_locators.add_header_line(Start_Qiss.driver).click();
		Thread.sleep(2000);
		
		/*Getting locators for drop down box arrow for both headers*/
		List<WebElement> dropdown_arrow = (Start_Qiss.driver).findElements(By.xpath("//*[@id='HfReceiptsTable']/tr/td[1]/span/span/span[2]"));
		
			for (WebElement loop: dropdown_arrow)
			{
			
			/*Clicking on dropdown arrow */	
			loop.click();
			System.out.println("Clicked the arrow button from dropdown button");
			
			/*Getting locators from drop down list for left and center options*/
			List<WebElement> dropdown_list = (Start_Qiss.driver).findElements(By.xpath("//*[@id='ddlAlign_listbox']/li"));
					
				for (WebElement loop1: dropdown_list)
					{
						/*Checks the options from drop down list and click on one of them */
						if (loop1.getText().contentEquals("Left"))
							{
								loop1.click();
								Thread.sleep(2000);
							}
						else if (loop1.getText().contentEquals("Center"))
							{
								loop1.click();
								Thread.sleep(2000);
							}
					}
			}
		
		/*Getting locators for description text boxes for both headers*/
		List<WebElement> descp = (Start_Qiss.driver).findElements(By.xpath("//*[@id='HfReceiptsTable']/tr/td[2]/input"));
		
		/*Entering the text for both description text box*/
		for (WebElement loop3: descp)
		{
			loop3.sendKeys("Test_Auto");
			Thread.sleep(1000);
		}
		
		/*Click on save button*/
		try {
			WebElement save_btn = (Start_Qiss.driver).findElement(By.id("saveHeaderFooterLines"));
			save_btn.click();
			System.out.println("Headers/Footer added successfully.!");
			
			Thread.sleep(1000);
		} catch (Exception e) {
			
			System.out.println("---> Error in adding headers <----");
			e.printStackTrace();
		}
		
		/*Click on ok button*/
		Qiss_Company_details_locators.ok_button(Start_Qiss.driver).click();
		/*WebElement ok_btn = (Start_Qiss.driver).findElement(By.xpath("//*[@type='button'][contains(text(),'Ok')]"));
		ok_btn.click();*/
		Thread.sleep(1000);
	}
	
	
	/*Verify that Header are shown in Receipt tab */
	public static boolean title_verify (String header_title, WebElement element)
	{
		boolean flag = false;
		element.click();
		WebElement headerlocator = (Start_Qiss.driver).findElement(By.xpath("//*[@class = 'receipt_title'][contains(text(),'"+header_title+"')]"));
		if (headerlocator.getText().contentEquals(header_title))
		{
		 System.out.println(header_title +" header is shown");	
		 flag = true;
		}
		else 
		{
			System.out.println("Header is missing");	
		}
		return flag;
	}
	
	public static boolean header_delete_function(String id_value) throws InterruptedException
	{
		WebElement header_footer_link = (Start_Qiss.driver).findElement(By.id(id_value));
		header_footer_link.click();
		Thread.sleep(2000);
		
		System.out.println((Start_Qiss.driver).findElement(By.xpath("//*[@id='TmReceiptsTable']/tbody/tr/following::input[@value='Header_name_test_auto']")).getAttribute("value").contentEquals("Header_name_test_auto"));
		if ((Start_Qiss.driver).findElement(By.xpath("//*[@id='TmReceiptsTable']/tbody/tr/following::input[@value='Header_name_test_auto']")).getAttribute("value").contentEquals("Header_name_test_auto"))
		{
			Start_Qiss.driver.findElement(By.xpath("//*[@id='TmReceiptsTable']/tbody/tr[2]/td[4]/div/div[2]")).click();
			Thread.sleep(1000);
			Start_Qiss.driver.findElement(By.xpath("//div[@class='ui-dialog-buttonset']/button[contains(text(),'Yes')]")).click();
			Thread.sleep(1000);
			
			/*if((Start_Qiss.driver).findElement(By.id("AlterMessage")).getText().contentEquals("Could not delete footer as it is being referenced by receipt."));*/
			
			Qiss_Company_details_locators.ok_button(Start_Qiss.driver).click();
			System.out.println("Header/Footer deleted successfully.");
		}
		else
		{
			System.out.println("Error in deleting the Header/Footer");
		}
		return false;
	}
}
	


