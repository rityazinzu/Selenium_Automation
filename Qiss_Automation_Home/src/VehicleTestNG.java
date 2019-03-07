import java.io.IOException;

import org.testng.annotations.Test;

public class VehicleTestNG extends View_Vehicle_Dispatcher_Company {


			
		View_vehicle_functions obj = new View_vehicle_functions();
		
		@Test
		public void allVehcileMethod()
		{
			/*---Load excel file and calling URl---*/ 
			try {
			
				
				/*---Verify radio buttons working or not---*/
				obj.verify_radio_data();
				
				/*---Verify "Active" section feature working or not---*/
				obj.Active();
				
				/*---Verify "With Products" section feature working or not---*/
				obj.WP();
				
				/*---Verify "Without Products" section feature working or not---*/
				obj.WOP();
				
				/*---Verify "Delete Vehicles" section feature working or not---*/
				obj.DV();
				
			} 
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
		
	
	
	
}