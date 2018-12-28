
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Qiss_Homepage {
		
		public static ChromeOptions options;
		public static  WebDriver driver;
		public JavascriptExecutor js;
		public Actions action;
		public static WebDriverWait wait;
		public static File src;
		public static FileInputStream fis;
		public static XSSFSheet sh1;
		public static XSSFWorkbook wb;
		public static FileOutputStream fout;
		public static String file_location = "C:\\Users\\ritesh.jhaveri\\Documents\\Ritesh\\Qiss_Automation_Checklist.xlsx";
		


		//Call chrome driver
		public static void call_driver_url() throws InterruptedException, IOException 
			{
				
				//Specify the file path which you want to create or write
				 src = new File(file_location);
				// Load the file
				 fis = new FileInputStream(src);
				// load the workbook
				 wb = new XSSFWorkbook(fis);
				// get the sheet which you want to modify or create
				 sh1 = wb.getSheetAt(0);
		
				/*Set drivers path*/
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\ritesh.jhaveri\\Documents\\Ritesh\\chromedriver.exe");		
				
				options = new ChromeOptions();
				options.addArguments("disable-infobars");
				
				driver = new ChromeDriver(options);
				
				wait = new WebDriverWait(driver,30);
				driver.get("https://qiss-test.quipment.nl/home");
				
				/*Specify implicit wait of 30 seconds*/                                   
			    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				
				/*To Maximize Browser Window*/
				driver.manage().window().maximize();
				/*Set Firefox Headless mode as TRUE*/
				
				/*Getting current URL and title */
				System.out.println(driver.getCurrentUrl());
				if (driver.getTitle().contentEquals("Sign In"))
				{
					System.out.println("ADFS Login page is loaded succesfully.");
					sh1.getRow(2).createCell(3).setCellValue("PASS");
					// here we need to specify where you want to save file
					 fout = new FileOutputStream(file_location);
					// finally write content 
					wb.write(fout);
					
				}
				else
				{
					System.out.println("ADFS Login page is not loaded succesfully.");
					sh1.getRow(2).createCell(3).setCellValue("FAIL");
					// here we need to specify where you want to save file
					 fout = new FileOutputStream(file_location);
					// finally write content 
					wb.write(fout);
					
				}
			
			
			}

		//Login 
		public static void login() throws InterruptedException, IOException 
			{
				try {
					WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userNameInput")));
					WebElement passwordname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("passwordInput")));
					WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("submitButton")));
					
					
						/*Logging with valid credentials */
						username.sendKeys("ritesh.jhaveri@quipment.nl");
						passwordname.sendKeys("R!tesh@1989");
					
					
					submitButton.click();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}
				
				/*Getting current URL and title */
				try {
					System.out.println(driver.getCurrentUrl());
					System.out.println(driver.getTitle());
					if (driver.getTitle().contentEquals("QISS"))
					{
						System.out.println("Login succesfully.");
						sh1.getRow(3).createCell(3).setCellValue("PASS");
						// here we need to specify where you want to save file
						 fout = new FileOutputStream(file_location);
						// finally write content 
						wb.write(fout);
						
					}
					else
					{
						System.out.println("Login was not succesfully due to Invalid credentials.");
						sh1.getRow(3).createCell(3).setCellValue("FAIL");
						// here we need to specify where you want to save file
						 fout = new FileOutputStream(file_location);
						// finally write content 
						wb.write(fout);
						
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		//Verify home page links 
		public static void qiss_homepage_verify() throws InterruptedException, IOException 
			{
				
				try {
					WebElement link  = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='RightBar']/div[1]/div/ul/li/a/span")));
					link.click();
					WebElement bcnl = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul//ul//li/a[contains(text(),'Boordcomputer.nl')]")));
					System.out.println("BC Link "+ bcnl.getAttribute("href"));
					WebElement qgate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul//ul//li/a[contains(text(),'Qgate webportal')]")));
					System.out.println("Qgate Link "+ qgate.getAttribute("href"));
					WebElement qupido = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul//ul//li/a[contains(text(),'Qupido webportal')]")));
					System.out.println("Qupido Link "+ qupido.getAttribute("href"));
					WebElement qlog = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul//ul//li/a[contains(text(),'Qlog webportal')]")));
					System.out.println("Qlog Link "+ qlog.getAttribute("href"));
					Thread.sleep(2000);
					
					link.click();
					bcnl.click();
					Thread.sleep(5000);
					window_switch();
					
					link.click();
					qgate.click();
					Thread.sleep(5000);
					window_switch();
					Thread.sleep(2000);
					
					link.click();
					qupido.click();
					Thread.sleep(5000);
					window_switch();
					Thread.sleep(2000);
					
					link.click();
					qlog.click();
					Thread.sleep(5000);
					window_switch();
					Thread.sleep(2000);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		//Tab switching						
		public static void window_switch() throws InterruptedException, IOException
			{
				/*String bc = "https://boordcomputer.quipment.nl/";
				String qg = "http://qgateweb-test.quipment.nl/";
				String qt = "http://qupido-test.quipment.nl/";
				String ql = "http://qlog-test.quipment.nl/";*/
				
				
				String mainWindow = getMainWindowHandle(driver);
				Set<String> allWindowHandles = driver.getWindowHandles();
				for (String currentWindowHandle : allWindowHandles)
				{
					
					
						if (!currentWindowHandle.equals(mainWindow)) {
							driver.switchTo().window(currentWindowHandle);
							Thread.sleep(10000);
							String windowURL= getCurrentWindowTitle();
							System.out.println(windowURL + " Open Successfully");
							Thread.sleep(10000);
							//System.out.println(windowURL);
							switch(windowURL) 
							{  
								case "http://boordcomputer.quipment.nl/": boord_title_verify();break;  
								case "https://qgateweb-test.quipment.nl/": qgate_title_verify();break;
								case "https://qupido-test.quipment.nl/": qupido_title_verify();break;
								case "https://qlog-test.quipment.nl/": qlog_title_verify();break;  
							}  
							driver.close();
							driver.switchTo().window(mainWindow);
						}
					
					}
				}
				
			
		
		public static void boord_title_verify() throws InterruptedException, IOException
		{
			if (driver.getTitle().contentEquals("Boordcomputer.nl - Boordcomputer.nl login"))
			{
				System.out.println(driver.getTitle() + " Tab Closed sucessfuly");
				sh1.getRow(4).createCell(3).setCellValue("PASS");
			}
			else
			{
				sh1.getRow(4).createCell(3).setCellValue("FAIL");
			}
			
		}
		
		public static void qgate_title_verify() throws InterruptedException, IOException
		{
			if (driver.getTitle().contentEquals("QGate Web Portal")) 
			{
				System.out.println(driver.getTitle() + " Tab Closed sucessfuly");
				sh1.getRow(5).createCell(3).setCellValue("PASS");
			}
			else
			{
				sh1.getRow(5).createCell(3).setCellValue("FAIL");
			}
			
		}
		
		public static void qupido_title_verify() throws InterruptedException, IOException
		{
			if (driver.getTitle().contentEquals("Qupido Web Portal")) 
			{
				System.out.println(driver.getTitle() + " Tab Closed sucessfuly");
				sh1.getRow(6).createCell(3).setCellValue("PASS");
			}
			else
			{
				sh1.getRow(6).createCell(3).setCellValue("FAIL");
			}
			
		}
		
		public static void qlog_title_verify() throws InterruptedException, IOException
		{
			if (driver.getTitle().contentEquals("QLog - Search")) 
			{
				System.out.println(driver.getTitle() + " Tab Closed sucessfuly");
				sh1.getRow(7).createCell(3).setCellValue("PASS");
			}
			else
			{
				sh1.getRow(7).createCell(3).setCellValue("FAIL");
			}
			
		}
		
		
		
		public static void language_check() throws InterruptedException, IOException
			{
			
				try {
					/* Click other side */
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/div/div[contains(.,'TEST')]"))).click();

					WebElement check = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='RightBar']/div[3]/span")));
					String langu = check.getText();
					System.out.println("Current language is English");

					if (langu.contentEquals("Nederlands"))
					{
										System.out.println("Page is already loaded in Netherland language");
					}	
					
					else
					{
					try {
					WebElement lang = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span/span/span[contains(.,'English')]")));	
					lang.click();
					
					WebElement nl = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(.,'Nederlands')]")));
					nl.click();
					
					Thread.sleep(10000);
					WebElement yes_btn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(.,'Yes')]")));  
					yes_btn.click();
					
					sh1.getRow(8).createCell(3).setCellValue("PASS");
					// here we need to specify where you want to save file
					fout = new FileOutputStream(file_location);
					// finally write content 
					wb.write(fout);
					
					} catch (Exception e) {
					
					sh1.getRow(8).createCell(3).setCellValue("FAIL");
					// here we need to specify where you want to save file
					fout = new FileOutputStream(file_location);
					// finally write content 
					wb.write(fout);
					e.printStackTrace();
					
					}

					String nl_string = "Onderhoud";
					try {
					if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li/a[contains(.,'Onderhoud')]"))).getText().contentEquals(nl_string))
					{
						System.out.println("Page is loaded successfully in Netherland language");
						sh1.getRow(9).createCell(3).setCellValue("PASS");
						// here we need to specify where you want to save file
						fout = new FileOutputStream(file_location);
						// finally write content 
						wb.write(fout);
										}
					} catch (Exception e) {
					
					sh1.getRow(9).createCell(3).setCellValue("FAIL");
					// here we need to specify where you want to save file
					fout = new FileOutputStream(file_location);
					// finally write content 
					wb.write(fout);
					e.printStackTrace();
					}
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			
	}
			
			
		public static String getMainWindowHandle(WebDriver driver) {
			return driver.getWindowHandle();
		}
		
		public static String getCurrentWindowTitle() {
			String windowURL = driver.getCurrentUrl();
			return windowURL;
		}
			
	}
