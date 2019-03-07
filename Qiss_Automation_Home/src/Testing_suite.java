import org.testng.annotations.Test;

public class Testing_suite {
	
	
  @Test (priority = 1)
  public void f() {
	  
	  System.out.println("Testing Now - 1");
  }
  
  @Test (priority = 2)
  public void f1() {
	  
	  System.out.println("Testing Now - 2");
  }
}
