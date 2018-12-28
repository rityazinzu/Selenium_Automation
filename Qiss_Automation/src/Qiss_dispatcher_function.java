
public class Qiss_dispatcher_function {
	
	/*Verify that filter is working or not */
	public static boolean filter() throws Exception
	
	{
		
		Qiss_dispatcher_feature.dv_count = Qiss_dispatcher_locators.count(Qiss_dispatcher_feature.driver).getText();
		System.out.println(Qiss_dispatcher_feature.dv_count);
		Qiss_dispatcher_locators.dv_filter_icon(Qiss_dispatcher_feature.driver).click();
		Qiss_dispatcher_locators.dv_filter_data(Qiss_dispatcher_feature.driver).sendKeys("rj9999");
		Qiss_dispatcher_locators.dv_filter_btn(Qiss_dispatcher_feature.driver).click();
		Qiss_dispatcher_feature.waitForPageLoaded();
		
		if (Qiss_dispatcher_locators.count(Qiss_dispatcher_feature.driver).getText() != Qiss_dispatcher_feature.dv_count)
		
		{
			System.out.println("Data filter working");
			System.out.println(Qiss_dispatcher_locators.count(Qiss_dispatcher_feature.driver).getText());
			return true;
		}
		
		else
		{
			System.out.println("Not working");
			System.out.println(Qiss_dispatcher_locators.count(Qiss_dispatcher_feature.driver).getText());	
			return false;
		}
		
	}

	/*Verify that able to clear data from filter*/
	public static boolean clear() throws Exception
		
	{
		Qiss_dispatcher_locators.dv_filter_icon(Qiss_dispatcher_feature.driver).click();
		Thread.sleep(2000);
		Qiss_dispatcher_locators.dv_clear(Qiss_dispatcher_feature.driver).click();
		Qiss_dispatcher_feature.waitForPageLoaded();
		
		if (Qiss_dispatcher_locators.count(Qiss_dispatcher_feature.driver).getText().contentEquals(Qiss_dispatcher_feature.dv_count))
		{
			System.out.println("Data clear succesfully from filter");
			System.out.println(Qiss_dispatcher_locators.count(Qiss_dispatcher_feature.driver).getText());
			return true;
		}
		
		else
		{
			System.out.println("Error in clearing data from filter");
			System.out.println(Qiss_dispatcher_locators.count(Qiss_dispatcher_feature.driver).getText());
			return false;
		}
			
	}	
	
	/*Verify that paging is working or not*/
	
	public static boolean paging() throws Exception
	
	{
	
		Qiss_dispatcher_locators.page_3(Qiss_dispatcher_feature.driver).click();
		
		if (Qiss_dispatcher_locators.count(Qiss_dispatcher_feature.driver).getText() != Qiss_dispatcher_feature.dv_count)
		{
			System.out.println("Paging works succefully");
			System.out.println(Qiss_dispatcher_locators.count(Qiss_dispatcher_feature.driver).getText());
			return true;
		}
		
		else
		{
			System.out.println("Paging Not working");
			System.out.println(Qiss_dispatcher_locators.count(Qiss_dispatcher_feature.driver).getText());
			return true;
		}
	
	}
	
	/*Verify that Item per page is working or not*/
	public static boolean item_page() throws Exception
	
	{
		Qiss_dispatcher_locators.scrol_btn(Qiss_dispatcher_feature.driver).click();
		Qiss_dispatcher_feature.waitForPageLoaded();
		Qiss_dispatcher_locators.dv_click_30(Qiss_dispatcher_feature.driver).click();
		
		if (Qiss_dispatcher_locators.count(Qiss_dispatcher_feature.driver).getText() != Qiss_dispatcher_feature.dv_count)
		{
			System.out.println("Item per page works succesfully");
			System.out.println(Qiss_dispatcher_locators.count(Qiss_dispatcher_feature.driver).getText());
			return true;
		}
		
		else
		{
			System.out.println("Item per page not working");
			System.out.println(Qiss_dispatcher_locators.count(Qiss_dispatcher_feature.driver).getText());
			return false;
		}
	}
	
	
	
}







