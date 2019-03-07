import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Verify_Qiss_Homepage {


		@BeforeTest
		public void calling_driver_login() throws Exception, IOException
		{
			Qiss_Homepage.call_driver_url();
			Qiss_Homepage.login();
		}
		
		@Test (priority = 1)
		public void verify_links() throws InterruptedException, IOException
		{
			Qiss_Homepage.qiss_homepage_verify();
		}
		
		@Test (priority = 2)
		public void verify_language() throws InterruptedException, IOException
		{
			Qiss_Homepage.language_check();
		}
		
		@AfterTest
		public void close_browser() throws Exception, IOException
		{
			Qiss_Homepage.driver.close();
		}
	}


