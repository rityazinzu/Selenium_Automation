

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestDemo {

	View_vehicle_functions Cobj = new View_vehicle_functions();
	@BeforeTest
	public void beforeTest()
	{
		try {
			Cobj.driver_login();
			Cobj.login_ADFS();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@AfterTest
	public void afterTest()
	{
		try {
			Qiss_Company_details_feature.driver.quit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
