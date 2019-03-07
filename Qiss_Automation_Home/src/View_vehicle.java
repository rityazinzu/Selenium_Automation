
public class View_vehicle {

public static void main(String[] args) throws Exception 
	{
			
		View_vehicle_functions obj = new View_vehicle_functions();
		
		/*---Load excel file and calling URl---*/ 
		obj.driver_login();
		
		/*---Logging Qiss portal---*/
		obj.login_ADFS();
		
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

}