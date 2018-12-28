import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test {
public static void main(String[] args) {
	System.out.println("RJ");
	System.setProperty("webdriver.gecko.driver","C:\\Users\\ritesh.jhaveri\\Documents\\Ritesh\\geckodriver.exe");
	WebDriver driver = new FirefoxDriver();
	driver.get("http://www.google.com");
}
}
