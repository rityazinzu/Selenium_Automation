
public class Qiss_dispatcher_main {

	public static void main(String[] args) throws Exception 
	
	{
	
		Qiss_dispatcher_feature F1 = new Qiss_dispatcher_feature();
		
		
		Qiss_dispatcher_feature.login();
		Qiss_dispatcher_feature.disp_login_adfs();
		Qiss_dispatcher_feature.view_dis();
		Qiss_dispatcher_feature.filter();
		Qiss_dispatcher_feature.paging();
		Qiss_dispatcher_feature.maintain_dispathcher_validation();
		Qiss_dispatcher_feature.maintain_dispathcher_data();
		Qiss_dispatcher_feature.maintain_conn();
		//Qiss_dispatcher_feature Q1 = new Qiss_dispatcher_feature();
		Qiss_dispatcher_feature.disp_view_his();
		
	}

}
