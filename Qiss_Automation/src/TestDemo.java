

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestDemo {

	
	@BeforeTest
	public void beforeTest()
	{
		try {
			
			Start_Qiss.initialise_driver();
			Start_Qiss.login_adfs();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void Test_Case_1_Company_details()
	{
		Qiss_Company_details_locators.company(Start_Qiss.driver).click();
		try {
			
			Qiss_Company_details_feature.Active();
			Qiss_Company_details_feature.Inactive();
			Qiss_Company_details_feature.All();
			Qiss_Company_details_feature.Product();
			Qiss_Company_details_feature.QupidoRouter();
			Qiss_Company_details_feature.Dispatcher();
			Qiss_Company_details_feature.Subscription();
			Qiss_Company_details_feature.Configuration();
			Qiss_Company_details_feature.Taximeter_tariff();
			Qiss_Company_details_feature.reciept();
			
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@AfterTest
	public void afterTest()
	{
		try {
			Start_Qiss.driver.quit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
