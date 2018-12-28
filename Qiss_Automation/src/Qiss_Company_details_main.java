
public class Qiss_Company_details_main {

	public static void main(String[] args) throws Exception {
		
		Qiss_Company_details_feature  C1  = new Qiss_Company_details_feature();
		
		
		C1.login();
		C1.login_adfs();
		/*C1.Active();
		C1.Inactive();
		C1.All();
		C1.Vehicle();
		C1.Product();
		C1.QupidoRouter();
		C1.Dispatcher();
		C1.Subscription();
		C1.Configuration();
		C1.Taximeter_tariff();*/
		C1.reciept();
	}
}
