
public class Qiss_dispatcher_main {

	public static void main(String[] args) throws Exception 
	
	{
	
		Qiss_dispatcher_feature F1 = new Qiss_dispatcher_feature();
		
		
		F1.login();
		F1.login_adfs();
		F1.view_dis();
		F1.filter();
		F1.paging();
		F1.maintain_dispathcher_validation();
		F1.maintain_dispathcher_data();
		F1.maintain_conn();
		Qiss_dispatcher_feature Q1 = new Qiss_dispatcher_feature();
		Q1.disp_view_his();
		
	}

}
