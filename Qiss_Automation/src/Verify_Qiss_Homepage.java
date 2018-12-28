import java.io.IOException;

public class Verify_Qiss_Homepage {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		Qiss_Homepage.call_driver_url();
		Qiss_Homepage.login();
		Qiss_Homepage.qiss_homepage_verify();
		Qiss_Homepage.language_check();
		
	}

}
