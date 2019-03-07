import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test_Automate {

	public static void main(String[] args) throws InterruptedException {
		// set drivers path
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\ritesh.jhaveri\\Documents\\Ritesh\\geckodriver.exe");
		
		//To open FF browser
		WebDriver driver = new FirefoxDriver();
		driver.get("https://adfs.quipment.nl/adfs/ls/?wa=wsignin1.0&wtrealm=https%3a%2f%2fqiss-test.quipment.nl%2f&wctx=rm%3d0%26id%3dpassive%26ru%3d%252fhome&wct=2018-03-14T10%3a34%3a04Z");
		
		 //To Maximize Browser Window
		 driver.manage().window().maximize();
		
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		WebElement username=driver.findElement(By.id("userNameInput"));
		WebElement passwordname=driver.findElement(By.id("passwordInput"));
		WebElement submitButton=driver.findElement(By.id("submitButton"));
		
		WebElement label=driver.findElement(By.id("header"));
		String abc = label.getText();
		System.out.println(abc);	
		username.sendKeys("abc");
		passwordname.sendKeys("abc");
		submitButton.click();
		
		WebElement error=driver.findElement(By.id("errorText"));
		System.out.println(error.getText());
		
		username.clear();
		passwordname.clear();
		username.sendKeys("ritesh.jhaveri@quipment.nl");
		passwordname.sendKeys("R!tesh@1989");
		submitButton.click();
		
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		
		/*Search for vehicle number 9898 */ 
		
		WebElement search=driver.findElement(By.id("SearchText"));
		search.sendKeys("9898");
//		WebElement vehicle=driver.findElement(By.className("button_link"));
		WebElement vehicle=driver.findElement(By.cssSelector("a.button_link:nth-child(8)"));
		vehicle.click();
		System.out.println(driver.getCurrentUrl());
		
		/*Click arrow to visit vehicle maintain page */	
		Thread.sleep(6000);
	//	WebElement arrow=driver.findElement(By.cssSelector(".maintainLink"));
		WebElement arrow=driver.findElement(By.className("maintainLink"));
		arrow.click();
		Thread.sleep(6000);
		System.out.println(driver.getCurrentUrl()); 
		System.out.println("PASS");
	
		/*Get maintain vehicle page data */
		WebElement vehicleowner=driver.findElement(By.id("companyHyperLink"));
		System.out.println("Vehicle Owner - " + vehicleowner.getText());
		
		WebElement vehiclenumber=driver.findElement(By.id("voertuignummer"));
		System.out.println("Vehicle Number - " + vehiclenumber.getAttribute("value"));
		
		WebElement chasssino=driver.findElement(By.id("chassisnummer"));
		System.out.println("Chassis Number - " + chasssino.getAttribute("value"));
		
		WebElement Licenseplate=driver.findElement(By.id("kenteken"));
		System.out.println("License Plate - " + Licenseplate.getAttribute("value"));
				
		WebElement soft=driver.findElement(By.cssSelector("div.table:nth-child(1) > div:nth-child(1) > div:nth-child(5) > div:nth-child(2) > span:nth-child(1) > span:nth-child(1) > span:nth-child(1)"));
		System.out.println("Soft Type - " + soft.getText());
		
		WebElement payment=driver.findElement(By.cssSelector("div.table:nth-child(1) > div:nth-child(1) > div:nth-child(9) > div:nth-child(2) > span:nth-child(1) > span:nth-child(1) > span:nth-child(1)"));
		System.out.println("Payment Type - " + payment.getText());
		
		WebElement odo=driver.findElement(By.cssSelector("div.table:nth-child(1) > div:nth-child(1) > div:nth-child(10) > div:nth-child(2) > span:nth-child(1) > span:nth-child(1) > span:nth-child(1)"));
		System.out.println("Dash Odo - " + odo.getText());
		
		WebElement Stationarytime=driver.findElement(By.id("DesignatedAreaStationaryTime"));
		System.out.println("Stationary time - " + Stationarytime.getAttribute("value"));
		
		WebElement printercheck=driver.findElement(By.cssSelector("div.table:nth-child(1) > div:nth-child(1) > div:nth-child(15) > div:nth-child(2) > span:nth-child(1) > span:nth-child(3) > span:nth-child(1) > span:nth-child(2)"));
		System.out.println("Printer Check - " + printercheck.getText());
		
		WebElement print_change=driver.findElement(By.cssSelector("div.table:nth-child(1) > div:nth-child(1) > div:nth-child(15) > div:nth-child(2) > span:nth-child(1) > span:nth-child(3) > span:nth-child(1) > span:nth-child(2)"));
		print_change.click();
		
		WebElement printerchange=driver.findElement(By.cssSelector("div.table:nth-child(1) > div:nth-child(1) > div:nth-child(15) > div:nth-child(2) > span:nth-child(1) > span:nth-child(3) > span:nth-child(1) > span:nth-child(1)"));
		System.out.println("Printer Check - " + printerchange.getText());
		
		/*Get Connected dispatcher info */
		
		WebElement dispname=driver.findElement(By.cssSelector(".k-grid-content > table:nth-child(1) > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(1) > label:nth-child(1)"));
		System.out.println("Dispatcher Name - " + dispname.getText());
		
		WebElement qgateid=driver.findElement(By.id("QGateMobileId65"));
		System.out.println("Qgate ID - " + qgateid.getAttribute("value"));
	}
	
}  
