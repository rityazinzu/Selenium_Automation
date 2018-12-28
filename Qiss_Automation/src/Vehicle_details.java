import java.io.IOException;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

/*Make sure before running this script on Qiss test environment, USN -"01-000016A8D3CF", PB - 7c669d536c4b is installed and activated.
 * Also  display printer checked is disbaled, Remove nat and TM is enabled in enabled in Maintain vehicle page for vehicle 9898
 */
public class Vehicle_details {
	
	Vehicle v1= new Vehicle();
	
	@BeforeMethod
	public void execute () throws InterruptedException, IOException {
		 
		v1.call_driver();
		/*v1.URL();
		v1.login();
		v1.search();
		v1.data();
		v1.dis_info();
		v1.uninstall();
		v1.navigate();
		v1.install();
		v1.verify();
		v1.navigate();
		v1.Validation();*/
	}	
	
	@Test (priority = 1)
	public void Test_1_Vehicle_maintain_page() throws InterruptedException, IOException 
	{
	System.out.println("Executing Test case: Vehicle_maintain_page");	
	v1.URL();
	v1.login();
	v1.search();
	v1.data();
	v1.dis_info();
	v1.uninstall();
	v1.navigate();
	v1.install();
	v1.verify();
	v1.navigate();
	v1.Validation();
	v1.buttons();
	v1.Qalibrate();
	v1.NMI();
	}
}

	
