import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class Val {

	public static WebDriver driver;
	public static WebDriverWait wait;
	
	static public void sample() throws InterruptedException {
		
		Thread.sleep(5000);
		System.out.println("YOoooo...");
		WebElement pg_time = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("PingTimeout")));
		pg_time.clear();
		
		System.out.println("YOoooo...111");
		
		WebElement pg_rt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("PingRetries")));
		pg_rt.clear();

		System.out.println("YOoooo...222");
		
		WebElement rad = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("DesignatedAreaRadius")));
		rad.clear();

		System.out.println("YOoooo...333");
		
		WebElement Stationarytime = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("DesignatedAreaStationaryTime")));
		Stationarytime.clear();

		System.out.println("YOoooo...444");
		
		WebElement retry_time = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("FirewallRetry")));
		retry_time.clear();

		System.out.println("YOoooo...555");
		
		WebElement confirm_button = driver.findElement(By.name("confirmVehicle"));
		confirm_button.click();

		String Ping = "Ping Timeout (seconds) is required.";
		String Ping_retries = "Ping Retries is required.";
		String Radius = "Radius (meters) is required.";
		String stat_time = "Stationary time (seconds) is required.";
		String retry = "The Retry field is required.";
		if (wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@class = 'qiss_validation_error validation-summary-errors']/ul/li[1]"))).getText()
				.contentEquals(Ping)) {
			System.out.println("Validation message - Ping");
		} else {
			System.out.println("Validation message is missing");
		}

		if (wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@class = 'qiss_validation_error validation-summary-errors']/ul/li[2]"))).getText()
				.contentEquals(Ping_retries)) {
			System.out.println("Validation message - Ping Retries");
		} else {
			System.out.println("Validation message is missing");
		}

		if (wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@class = 'qiss_validation_error validation-summary-errors']/ul/li[3]"))).getText()
				.contentEquals(Radius)) {
			System.out.println("Validation message - Radius");
		} else {
			System.out.println("Validation message is missing");
		}

		if (wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@class = 'qiss_validation_error validation-summary-errors']/ul/li[4]"))).getText()
				.contentEquals(stat_time)) {
			System.out.println("Validation message - Stationary time");
		} else {
			System.out.println("Validation message is missing");
		}
		if (wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//*[@class = 'qiss_validation_error validation-summary-errors']/ul/li[5]"))).getText()
				.contentEquals(retry)) {
			System.out.println("Validation message - Retry time");
		} else {
			System.out.println("Validation message is missing");
		}

	}
		
		static  void test() throws InterruptedException 
		{
				
			sample();
			
		}

}

