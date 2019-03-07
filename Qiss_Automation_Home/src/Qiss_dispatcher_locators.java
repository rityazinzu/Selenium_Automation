import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Qiss_dispatcher_locators 
	{
	
		private static WebElement element = null;
		private static WebDriverWait wait;
		
		public static WebElement uname (WebDriver driver)
		{
			element = driver.findElement((By.id("userNameInput")));
			return element;
		}
	
		public static WebElement pass (WebDriver driver)
		{
			element = driver.findElement((By.id("passwordInput")));
			return element;
		}
		
		public static WebElement submit (WebDriver driver)
		{
			element = driver.findElement(By.cssSelector("#submitButton"));
			return element;
		}
		
		public static WebElement dispatcher (WebDriver driver)
		{
			wait = new WebDriverWait(driver, 15);
			element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[title= 'All / Search dispatchers']")));
			return element;
		}
		
		public static WebElement count (WebDriver driver) throws Exception
		{
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[class^='k-pager-info k-label']")));
			Thread.sleep(3000);
			return element;
		}
		
		public static WebElement filter_icon (WebDriver driver)
		{
			wait = new WebDriverWait(driver, 15);
			element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.k-grid-filter")));
			return element;
		}
		
		public static WebElement filter_data (WebDriver driver)
		{
			wait = new WebDriverWait(driver, 15);
			element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[data-bind='value:filters[0].value']")));
			return element;
		}

		public static WebElement filter_btn (WebDriver driver)
		{
			wait = new WebDriverWait(driver, 15);
			element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
			return element;
		}
		
		public static WebElement navigate (WebDriver driver)
		{
			wait = new WebDriverWait(driver, 15);
			element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ViewDispatcherGrid']//tr[9]/td/a")));
			return element;
		}
		
		public static WebElement clear (WebDriver driver)
		{
			wait = new WebDriverWait(driver, 15);
			element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='reset']")));
			return element;
		}
		
		public static WebElement page_3 (WebDriver driver)
		{
			wait = new WebDriverWait(driver, 15);
			element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-page = '3']")));
			return element;
		}	
		
		public static WebElement scrol_btn (WebDriver driver)
		{
			wait = new WebDriverWait(driver, 15);
			element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span.k-pager-sizes.k-label span span span.k-select")));
			return element;
		}	
		
		public static WebElement click_30 (WebDriver driver)
		{
			wait = new WebDriverWait(driver, 15);
			element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li[data-offset-index='2']")));
			return element;
		}	
		
		public static WebElement disp_name (WebDriver driver)
		{
			wait = new WebDriverWait(driver, 15);
			element = wait.until(ExpectedConditions.elementToBeClickable(By.id("DispatcherName")));
			return element;
		}
		
		public static WebElement qgate_id (WebDriver driver)
		{
			wait = new WebDriverWait(driver, 15);
			element = wait.until(ExpectedConditions.elementToBeClickable(By.id("QGateDispatcher_Id")));
			return element;
		}
		
		public static WebElement dname_error (WebDriver driver)
		{
			wait = new WebDriverWait(driver, 15);
			element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.qiss_validation_error.validation-summary-errors > ul > li:nth-child(1)")));
			return element;
		}
		
		public static WebElement qgate_id_error (WebDriver driver)
		{
			wait = new WebDriverWait(driver, 15);
			element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.qiss_validation_error.validation-summary-errors > ul > li:nth-child(2)")));
			return element;
		}
		
		public static WebElement disp_email_error (WebDriver driver)
		{
			wait = new WebDriverWait(driver, 15);
			element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.qiss_validation_error.validation-summary-errors > ul > li:nth-child(3)")));
			return element;
		}
		
		public static WebElement disp_rsa_exp_error (WebDriver driver)
		{
			wait = new WebDriverWait(driver, 15);
			element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.qiss_validation_error.validation-summary-errors > ul > li:nth-child(4)")));
			return element;
		}
		
		public static WebElement disp_rsa_mod_error (WebDriver driver)
		{
			wait = new WebDriverWait(driver, 15);
			element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.qiss_validation_error.validation-summary-errors > ul > li:nth-child(5)")));
			return element;
		}
		
		
		public static WebElement confirm_btn (WebDriver driver)
		{
			wait = new WebDriverWait(driver, 15);
			element = wait.until(ExpectedConditions.elementToBeClickable(By.id("confirmDispatcher")));
			return element;
		}
		
		public static WebElement disp_email (WebDriver driver)
		{
			wait = new WebDriverWait(driver, 15);
			element = wait.until(ExpectedConditions.elementToBeClickable(By.id("DispatcherNotificationEmail")));
			
			return element;
		}
		
		public static WebElement maintain_conn (WebDriver driver)
		{
			wait = new WebDriverWait(driver, 15);
			element = wait.until(ExpectedConditions.elementToBeClickable(By.className("maintain_vehicle_btn")));
			
			return element;
		}
		
		public static WebElement ava_veh (WebDriver driver)
		{
			wait = new WebDriverWait(driver, 15);
			element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='AvailableVehicleList']/option[1]")));
			
			return element;
		}
		
		public static WebElement add_btn (WebDriver driver)
		{
			wait = new WebDriverWait(driver, 15);
			element = wait.until(ExpectedConditions.elementToBeClickable(By.id("AddCompany")));
			
			return element;
		}
		
		
		public static WebElement confirm (WebDriver driver)
		{
			wait = new WebDriverWait(driver, 15);
			element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.maintain_dispatcher_popup_label input")));
			
			return element;
		}
		
		public static WebElement conn_veh (WebDriver driver)
		{
			wait = new WebDriverWait(driver, 15);
			element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ConnectedVehicleList']/option[2]")));
			
			return element;
		}
		
		public static WebElement remove_btn (WebDriver driver)
		{
			wait = new WebDriverWait(driver, 15);
			element = wait.until(ExpectedConditions.elementToBeClickable(By.id("RemoveCompany")));
			
			return element;
		}
		
		public static WebElement disp_his (WebDriver driver)
		{
			wait = new WebDriverWait(driver, 15);
			element = wait.until(ExpectedConditions.elementToBeClickable(By.id("viewDispatcherConnectionHistory")));
			return element;
		}
		
		public static WebElement dv_filter_icon (WebDriver driver)
		{
			wait = new WebDriverWait(driver, 15);
			element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div > table > thead > tr > th:nth-child(7) > a")));
			return element;
		}
		
		public static WebElement dv_filter_data (WebDriver driver)
		{
			wait = new WebDriverWait(driver, 15);
			element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@data-bind = 'value:filters[0].value']")));
			return element;
		}

		public static WebElement dv_filter_btn (WebDriver driver)
		{
			wait = new WebDriverWait(driver, 15);
			element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
			return element;
		}
		
		public static WebElement dv_clear (WebDriver driver)
		{
			wait = new WebDriverWait(driver, 15);
			element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='reset']")));
			return element;
		}
		
		public static WebElement dv_click_10 (WebDriver driver)
		{
			wait = new WebDriverWait(driver, 15);
			element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[13]/div/div[2]/ul/li[1]")));
			return element;
		}
	}

