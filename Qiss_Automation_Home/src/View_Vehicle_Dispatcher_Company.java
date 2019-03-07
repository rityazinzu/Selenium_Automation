/*Before running test case for company details - receipt(), 
* make sure to navigate link https://qiss-test.quipment.nl/Company/MaintainCompany/700?selectTab=7 and delete the 
* "Header_name_test_auto" named header/footer from header and footer section from mainatain receipt page
*/
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class View_Vehicle_Dispatcher_Company {

	
	@BeforeTest
	public void beforeTest()
	{
		try {
			
			Start_Qiss.initialise_driver();
			/*Start_Qiss.login_adfs();*/
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	@Test (priority = 1 )
	public void Test_Case_1_Company_details()
	{
		Qiss_Company_details_locators.company(Start_Qiss.driver).click();
		try {
			System.out.println("<--------------------Running Company Details test case------------------------------>");
			Qiss_Company_details_feature.Active();
			Qiss_Company_details_feature.Inactive();
			Qiss_Company_details_feature.All();
			Qiss_Company_details_feature.Vehicle();
			Qiss_Company_details_feature.Product();
			Qiss_Company_details_feature.QupidoRouter();
			Qiss_Company_details_feature.Dispatcher();
			Qiss_Company_details_feature.Subscription();
			Qiss_Company_details_feature.Configuration();
			Qiss_Company_details_feature.Taximeter_tariff();
			Qiss_Company_details_feature.reciept();
			
			} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	@Test (priority = 3 )
	
	public void Test_Case_2_Dispatcher_details()
	{
		Qiss_dispatcher_locators.dispatcher(Start_Qiss.driver).click();
		
		try {
			System.out.println("<--------------------Running Dispatcher Details test case------------------------------>");
			Qiss_dispatcher_feature.view_dis();
			Qiss_dispatcher_feature.filter();
			Qiss_dispatcher_feature.paging();
			Qiss_dispatcher_feature.maintain_dispathcher_validation();
			Qiss_dispatcher_feature.maintain_dispathcher_data();
			Qiss_dispatcher_feature.maintain_conn();
			Qiss_dispatcher_feature.disp_view_his();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		 
		
	}
	
	@Test (priority = 2)
	
	public void Test_Case_3_View_Vehicles_Page_()
	
	{
		try {
			System.out.println("<--------------------Running View Vehicles test case------------------------------>");
			View_vehicle_functions.verify_radio_data();
			View_vehicle_functions.Active();
			View_vehicle_functions.WP();
			View_vehicle_functions.WOP();
			View_vehicle_functions.DV();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	
	}
	
	
	@AfterTest
	public void close_browser()
	{
		try {
			Start_Qiss.driver.quit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
