import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class View_Vehicle_Feature {
	

	public boolean filter_vo() throws Exception
	{
		boolean result = false;
		Thread.sleep(5000);
		
		//Verfiy Data succesfully filter with Vehicle Owner or not 
		WebElement vo = View_vehicle_functions.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("th[data-field = 'bedrijfsnaam'] a span")));
		vo.click();
		
		WebElement data = View_vehicle_functions.wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input.k-textbox[type = 'text']")));
		data.sendKeys("Insigno Quipment");
		
		WebElement filter_btn = View_vehicle_functions.wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type = 'submit']")));
		filter_btn.click();
		
		Thread.sleep(2000);
		WebElement loadcount_act = View_vehicle_functions.wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span[class^='k-pager-info k-label']")));
		System.out.println(loadcount_act.getText());
		
		
		if (loadcount_act.getText()!= View_vehicle_functions.precnt)
		{
			System.out.println("Data succesfully filter with Vehicle Owner");
			result = true;
		}
		else
		{
			System.out.println("Not able to filter data");
			result = false;
		}
		
		vo.click();
		Thread.sleep(2000);
		WebElement clear = View_vehicle_functions.wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type= 'reset']")));
		clear.click();
		return result;
	}	
	
	
	public boolean filter_vno() throws Exception
	{
		boolean result = false;
		Thread.sleep(5000);
		
		//Verfiy Data succesfully filter with Vehicle Number or not
		WebElement vn = View_vehicle_functions.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("th[data-field = 'voertuignummer'] a span")));
		vn.click();
		
		WebElement data_vn = View_vehicle_functions.wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".k-state-border-up > div:nth-child(1) > input")));
		data_vn.sendKeys("009");
		
		WebElement filter_btn_vn = View_vehicle_functions.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type = 'submit']/following::button[2]")));
		filter_btn_vn.click();
		
		Thread.sleep(2000);
		WebElement loadcount_act_vn = View_vehicle_functions.wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span[class^='k-pager-info k-label']")));
		System.out.println(loadcount_act_vn.getText());
		
		
		if (loadcount_act_vn.getText()!=View_vehicle_functions.precnt)
		{
			System.out.println("Data succesfully filter with Vehicle Number");
			result = true;
		}
		else
		{
			System.out.println("Not able to filter data");
			result = false;
		}
		Thread.sleep(3000);
		vn.click();
		Thread.sleep(2000);
		WebElement clear_vn = View_vehicle_functions.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type= 'reset']/following::button[2]")));
		clear_vn.click();
		return result;		
	}

	
	public boolean page_nav() throws Exception
	{
		boolean result = false;
		Thread.sleep(3000);
		
		//Verfiy page navigation working or not
		
		//Click on rounded circle number - 9 and get text value
		WebElement oval = View_vehicle_functions.wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[data-page = '9']")));
		String no = oval.getText();
		System.out.println("Clicked on page no - " + oval.getText());
		oval.click();
		
		Thread.sleep(5000);
		WebElement count = View_vehicle_functions.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.k-state-selected")));
		System.out.println("Navigating page no - " + count.getText());
		
		//Verify the text value from "no" with "count"(recieved after clicking) 
		if (no.contentEquals(count.getText()))
		{
			System.out.println("Page navigation worked succesfully");
			result = true;
		}
		else
		{
			System.out.println("Failed in navigating the Page");
			result = false;
		}
		return result;	
	}
		
	
	public boolean scroll() throws Exception
	{
		boolean result = false;
		Thread.sleep(3000);
		
		//Click on scroll button to open drop down list of items per page
		WebElement scrol = View_vehicle_functions.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.k-pager-sizes.k-label span span span.k-select")));
		scrol.click();
		Thread.sleep(5000);
		
		//Click on "30" to view item per page
		WebElement select = View_vehicle_functions.wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body > div.k-animation-container > div > div.k-list-scroller > ul > li:nth-child(3)")));
		select.click();
		
		Thread.sleep(5000);
		WebElement loadcount_act_select = View_vehicle_functions.wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span[class^='k-pager-info k-label']")));
		System.out.println(loadcount_act_select.getText());
		System.out.println(View_vehicle_functions.precnt);
		
		//Compare the counts loadcount with precnt
		if (loadcount_act_select.getText()!=View_vehicle_functions.precnt)
		{
			System.out.println("Item per page loaded succesfully");
			result = true;
		}
		else
		{
			System.out.println("Not able to load data");
			result = false;
		}
		Thread.sleep(3000); 
		return result;
	}
	
	
}
