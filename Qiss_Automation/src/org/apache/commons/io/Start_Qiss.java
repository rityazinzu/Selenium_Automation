package org.apache.commons.io;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Start_Qiss  {
	
	

	public static WebDriver driver;
	public static WebDriverWait wait;
	public static File src;
	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static XSSFSheet sh1;
	public static XSSFWorkbook wb;
	public static String file_location = "C:\\Users\\ritesh.jhaveri\\Documents\\Ritesh\\Qiss_Automation_Checklist.xlsx";
	public static String URL = "https://qiss-test.quipment.nl/home";

	public static void initialise_driver() throws Exception {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ritesh.jhaveri\\Documents\\Ritesh\\chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 30);
		driver.get(URL);

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		src = new File(file_location);
		fis = new FileInputStream(src);
		wb = new XSSFWorkbook(fis);
		sh1 = wb.getSheetAt(0);

	}
	
	
}
