import org.openqa.selenium.support.ui.Wait;

public class Qiss_dispatcher_function {
	
	/*Verify that filter is working or not */
	public static boolean filter() throws Exception
	
	{
		
		Qiss_dispatcher_feature.dv_count = Qiss_dispatcher_locators.count(Start_Qiss.driver).getText();
		System.out.println(Qiss_dispatcher_feature.dv_count);
		Qiss_dispatcher_locators.dv_filter_icon(Start_Qiss.driver).click();
		Qiss_dispatcher_locators.dv_filter_data(Start_Qiss.driver).sendKeys("rj9777");
		Qiss_dispatcher_locators.dv_filter_btn(Start_Qiss.driver).click();
		Qiss_dispatcher_feature.waitForPageLoaded();
		
		if (Qiss_dispatcher_locators.count(Start_Qiss.driver).getText() != Qiss_dispatcher_feature.dv_count)
		
		{
			System.out.println("Data filter working");
			System.out.println(Qiss_dispatcher_locators.count(Start_Qiss.driver).getText());
			return true;
		}
		
		else
		{
			System.out.println("Not working");
			System.out.println(Qiss_dispatcher_locators.count(Start_Qiss.driver).getText());	
			return false;
		}
		
	}

	/*Verify that able to clear data from filter*/
	public static boolean clear() throws Exception
		
	{
		Qiss_dispatcher_locators.dv_filter_icon(Start_Qiss.driver).click();
		Thread.sleep(2000);
		Qiss_dispatcher_locators.dv_clear(Start_Qiss.driver).click();
		Qiss_dispatcher_feature.waitForPageLoaded();
		
		if (Qiss_dispatcher_locators.count(Start_Qiss.driver).getText().contentEquals(Qiss_dispatcher_feature.dv_count))
		{
			System.out.println("Data clear succesfully from filter");
			System.out.println(Qiss_dispatcher_locators.count(Start_Qiss.driver).getText());
			return true;
		}
		
		else
		{
			System.out.println("Error in clearing data from filter");
			System.out.println(Qiss_dispatcher_locators.count(Start_Qiss.driver).getText());
			return false;
		}
			
	}	
	
	/*Verify that paging is working or not*/
	
	public static boolean paging() throws Exception
	
	{
	
		Qiss_dispatcher_locators.page_3(Start_Qiss.driver).click();
		
		if (Qiss_dispatcher_locators.count(Start_Qiss.driver).getText() != Qiss_dispatcher_feature.dv_count)
		{
			System.out.println("Paging works succefully");
			System.out.println(Qiss_dispatcher_locators.count(Start_Qiss.driver).getText());
			return true;
		}
		
		else
		{
			System.out.println("Paging Not working");
			System.out.println(Qiss_dispatcher_locators.count(Start_Qiss.driver).getText());
			return true;
			
		}
	
	}
	
	/*Verify that Item per page is working or not*/
	public static boolean item_page() throws Exception
	
	{
		Qiss_dispatcher_locators.scrol_btn(Start_Qiss.driver).click();
		Qiss_dispatcher_feature.waitForPageLoaded();
		Qiss_dispatcher_locators.dv_click_10(Start_Qiss.driver).click();
		
		if (Qiss_dispatcher_locators.count(Start_Qiss.driver).getText() != Qiss_dispatcher_feature.dv_count)
		{
			System.out.println("Item per page works succesfully");
			System.out.println(Qiss_dispatcher_locators.count(Start_Qiss.driver).getText());
			return true;
		}
		
		else
		{
			System.out.println("Item per page not working");
			System.out.println(Qiss_dispatcher_locators.count(Start_Qiss.driver).getText());
			return false;
		}
	}
	
	
	
}







