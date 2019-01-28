import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import java.util.concurrent.TimeUnit;

public class test_qisss {

	public static void main(String[] args) throws InterruptedException {
		// set drivers path
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ritesh.jhaveri\\Documents\\Ritesh\\chromedriver.exe");		
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		
		//To open Chrome browser
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://adfs.quipment.nl/adfs/ls/?wa=wsignin1.0&wtrealm=https%3a%2f%2fqiss-test.quipment.nl%2f&wctx=rm%3d0%26id%3dpassive%26ru%3d%252fhome&wct=2018-03-14T10%3a34%3a04Z");
		
		// Specify implicit wait of 30 seconds                                   
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Set Firefox Headless mode as TRUE
		//ChromeOptions options = new ChromeOptions();
		//options.setHeadless(true);
		
		//To Maximize Browser Window
		 driver.manage().window().maximize();
		
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		WebElement username=driver.findElement(By.id("userNameInput"));
		WebElement passwordname=driver.findElement(By.id("passwordInput"));
		username.clear();
		passwordname.clear();
		username.sendKeys("ritesh.jhaveri@quipment.nl");
		passwordname.sendKeys("R!tesh@1989");
		
		Thread.sleep(15000);
		System.out.println("A");
		driver.navigate().to("https://qiss-test.quipment.nl/Vehicle/MaintainVehicle/12691");
		//driver.navigate().to("https://google.co.in");
		System.out.println("B");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		// This  will scroll down the page by  1000 pixel vertical		
        js.executeScript("window.scrollBy(0,2000)");
        Thread.sleep(2000);
		//WebElement check=driver.findElement(By.xpath("//label[@for='vehicle0']"));
		//check.click();
		System.out.println("C");
		WebElement install_product=driver.findElement(By.className("add_vehicle_btn"));
		install_product.click();
		Thread.sleep(2000);
		
		WebElement filtericon_click=driver.findElement(By.xpath("//*[@id='ViewSelectProductList']/div[1]/div/table/thead/tr/th[3]/a[1]/span"));
		filtericon_click.click();
		Thread.sleep(2000);
		System.out.println("D");
		
		WebElement type_usn=driver.findElement(By.xpath("//*[@title = 'Value']"));
		type_usn.sendKeys("01-000016A8D3CF");
		Thread.sleep(3000);
		System.out.println("type done");
		
		WebElement filterbutton_click=driver.findElement(By.xpath("//*[@class='k-button k-primary']"));
		filterbutton_click.click();
		Thread.sleep(3000);
		
		Actions action = new Actions(driver);
		WebElement double_click=driver.findElement(By.xpath("//*[@id='ViewSelectProductList']/div[2]/div/table/tbody/tr/td[3]"));
		System.out.println("found");
		Thread.sleep(5000);
		
		//Double click
		action.doubleClick(double_click).perform();
		System.out.println("double click");
		Thread.sleep(5000);
		
		/*Tick the checkboxs for activation*/
		
		//Thread.sleep(5000);
		
		//WebDriverWait wait = new WebDriverWait(driver, 30);
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[id='ViewInstallProductsList'] table tbody tr td[class='gridTextCenter']")));
		
		action.moveToElement(driver.findElement(By.cssSelector("div[id='ViewInstallProductsList'] table tbody tr td[class='gridTextCenter']"))).click();
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[id='ViewInstallProductsList'] table tbody tr td[class='gridTextCenter']"))).click();
		
		WebElement confirm_button_1=driver.findElement(By.name("confirmVehicle"));
		confirm_button_1.click();
		Thread.sleep(5000);
		System.out.println("SUCCESS.!");
	}
	
}
