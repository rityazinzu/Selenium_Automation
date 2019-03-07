import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Qiss_Company_details_locators {
	
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
	
	public static WebElement company (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='All / Search companies']")));
		return element;
	}
	
	public static WebElement active (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("label[for = 'inputRadioActive']")));
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
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@data-bind = 'value:filters[0].value']")));
		return element;
	}

	public static WebElement filter_btn (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
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
		element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > div.k-animation-container > div > div.k-list-scroller > ul > li:nth-child(3)")));
		return element;
	}
	
	public static WebElement inactive (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("label[for = 'inputRadioInactive']")));
		return element;
	}

	public static WebElement refresh (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class = 'k-icon k-i-refresh']")));
		return element;
	}
	
	public static WebElement all (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("label[for = 'inputRadioAll']")));
		return element;
	}
	
	public static WebElement navigation_arrow (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.className("maintainLink")));
		return element;
	}
	
	
	public static WebElement New_vehicle_btn (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.id("MaintainVehicle")));
		return element;
	}
	
	public static WebElement Ping_timeout (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.id("PingTimeout")));
		return element;
	}
	
	public static WebElement Ping_retries (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.id("PingRetries")));
		return element;
	}
	
	public static WebElement Radius (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.id("DesignatedAreaRadius")));
		return element;
	}
	
	public static WebElement Stat_time (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.id("DesignatedAreaStationaryTime")));
		return element;
	}
	
	public static WebElement Confirm_btn (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.id("confirmVehicle")));
		return element;
	}
	
	public static WebElement Vehicle_no_error (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.qiss_validation_error.validation-summary-errors > ul > li:nth-child(1)")));
		return element;
	}
	
	public static WebElement Ping_timeout_error (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.qiss_validation_error.validation-summary-errors > ul > li:nth-child(2)")));
		return element;
	}
	
	public static WebElement Ping_retries_error (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.qiss_validation_error.validation-summary-errors > ul > li:nth-child(3)")));
		return element;
	}
	
	public static WebElement radius_error (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.qiss_validation_error.validation-summary-errors > ul > li:nth-child(4)")));
		return element;
	}
	
	public static WebElement stat_time_error (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.qiss_validation_error.validation-summary-errors > ul > li:nth-child(5)")));
		return element;
	}
	
	public static WebElement back_btn (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.name("cancelVehicle")));
		return element;
	}
	
	public static WebElement product (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.id("ProductLink")));
		return element;
	}
	
	public static WebElement QupidoRouter (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.id("QupidoRouterLink")));
		return element;
	}
	
	public static WebElement New_QupidoRouter_btn (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.id("newQupidoRouter")));
		return element;
	}
	
	public static WebElement router_name (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.id("RouterName")));
		return element;
	}
	
	public static WebElement IPaddress (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.id("IPAddress")));
		return element;
	}
	
	public static WebElement Port (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.id("Port")));
		return element;
	}
	
	public static WebElement Username (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.id("UserName")));
		return element;
	}
	
	public static WebElement Password (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.id("Password")));
		return element;
	}
	
	public static WebElement filepath (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.id("FilePath")));
		return element;
	}
	
	public static WebElement confirmQupidoRouter_btn (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.id("confirmQupidoRouter")));
		return element;
	}
	
	public static WebElement routername_error (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.qiss_validation_error.validation-summary-errors > ul > li:nth-child(1)")));
		return element;
	}
	
	public static WebElement IPaddress_error (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.qiss_validation_error.validation-summary-errors > ul > li:nth-child(2)")));
		return element;
	}
	
	public static WebElement Username_error (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.qiss_validation_error.validation-summary-errors > ul > li:nth-child(3)")));
		return element;
	}
	
	public static WebElement password_error (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.qiss_validation_error.validation-summary-errors > ul > li:nth-child(4)")));
		return element;
	}
	
	public static WebElement filepath_error (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.qiss_validation_error.validation-summary-errors > ul > li:nth-child(5)")));
		return element;
	}
	
	public static WebElement back_btn_qupido_router (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.id("cancelQupidoRouter")));
		return element;
	}
	
	public static WebElement remove_qupido_router_btn (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.id("removeQupidoRouter")));
		return element;
	}
	
	public static WebElement yes_btn_qupido_router_popup (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.ui-dialog-buttonset button")));
		return element;
	}
	
	public static WebElement dispatcher (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.id("DispatcherLink")));
		return element;
	}
	
	public static WebElement subscription (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.id("SubscriptionLink")));
		return element;
	}
	
	public static WebElement configuration (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.id("ConfigurationLink")));
		return element;
	}

	public static WebElement trip_sorting_dropdownlist_arrow (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@aria-owns = 'QrisConfiguration_TripSortingStyle_listbox']/span/span/span")));
		return element;
	}
	
	public static WebElement add_memo_btn (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.id("AddMemoButton")));
		return element;
	}
	
	public static WebElement save_btn (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.id("confirmConfiguration")));
		return element;
	}
	
	public static WebElement OK_btn (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ui-dialog-buttonpane ui-widget-content ui-helper-clearfix']/div/button")));
		return element;
	}
	
	public static WebElement config_label (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-describedby='popup_alter_dialog_box']//span[@class='ui-dialog-title']")));
		return element;
	}
	
	public static WebElement generateconfig (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.id("generateCompanyConfiguration")));
		return element;
	}
	
	public static WebElement yes_btn_gen_config (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ui-dialog-buttonset']/button[1]")));
		return element;
	}
	
	public static WebElement ok_btn_maintain_company (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ui-dialog-buttonset']/button[1]")));
		return element;
	}
	
	public static WebElement Tariffset_tariff (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.id("TaxiMeterTariffLink")));
		return element;
	}
	
	public static WebElement Tariffset (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.id("Name")));
		return element;
	}
	
	public static WebElement Max_total_amount (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.id("SupplementMaxAmount")));
		return element;
	}
	
	public static WebElement supplement_amount (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.id("SupplementAmount")));
		return element;
	}
	
	public static WebElement Save_btn_taximetertariff (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.id("confirmTaxiMeterTariffSet")));
		return element;
	}
	
	public static WebElement tariffset_error_msg (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id ='MainPageValidation']/ul/li[1]")));
		return element;
	}
	
	public static WebElement maxtotal_error_msg (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id ='MainPageValidation']/ul/li[2]")));
		return element;
	}
	
	public static WebElement amount_error_msg (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id ='MainPageValidation']/ul/li[3]")));
		return element;
	}
	
	public static WebElement New_tarriffset_btn (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.id("AddNewTaxiMeterTariff")));
		return element;
	}
	
	public static WebElement Add_btn_tariff (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#divAddPeriodButton div label")));
		return element;
	}
	
	public static WebElement tariffset_period_error_msg (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id ='MainPageValidation']/ul/li[2]")));
		return element;
	}
	
	public static WebElement cancel_btn (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='divNewPeriod']/div/span/span/span/span")));
		return element;
	}
	
	public static WebElement tariffset_textbox (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.id("Name")));
		return element;
	}
	
	public static WebElement Add_tariffs (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.id("AddTariffSetLable")));
		return element;
	}
	
	public static WebElement maintain_tariff_name_tariff_error_message (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='TariffChildValidation']/ul/li[1]")));
		return element;
	}
	
	public static WebElement maintain_tariff_desc_tariff_error_message (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='TariffChildValidation']/ul/li[2]")));
		return element;
	}
	
	public static WebElement maintain_tariff_waiting_time_error_message (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='TariffChildValidation']/ul/li[3]")));
		return element;
	}
	
	public static WebElement maintain_tariff_initial_fee_error_message (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='TariffChildValidation']/ul/li[4]")));
		return element;
	}
	
	public static WebElement maintain_tariff_distance_fee_error_message (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='TariffChildValidation']/ul/li[5]")));
		return element;
	}
	
	public static WebElement maintain_tariff_time_fee_error_message (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='TariffChildValidation']/ul/li[6]")));
		return element;
	}
	
	public static WebElement maintain_name (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='divTimeTariff']/div[3]/input")));
		return element;
	}
	
	public static WebElement maintain_descp (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='divTimeTariff']/div[3]/input")));
		return element;
	}
	
	public static WebElement maintain_weekend (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='divTimeTariff']/div[3]/input")));
		return element;
	}
	
	public static WebElement confirm_btn_maintain (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='divTimeTariff']/div[3]/input")));
		return element;
	}

	public static WebElement maintain_tarif_name (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='divTimeTariff']/div[5]/span[1]/input[1]")));
		return element;
	}
	
	public static WebElement maintain_tarif_descp (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='divTimeTariff']/div[5]/span[2]/input[1]")));
		return element;
	}
	
	public static WebElement maintain_waiting (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='divTimeTariff']/div[5]/span[4]/input[1]")));
		return element;
	}
	
	public static WebElement maintain_initial (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.id("CurrentTariffSetPeriod_TariffList_0__DayTimeTariff_InitialFeeValue")));
		return element;
	}
	
	public static WebElement maintain_time (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.id("CurrentTariffSetPeriod_TariffList_0__DayTimeTariff_InitialTimeFeeValue")));
		return element;
	}
	
	public static WebElement maintain_distance (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.id("CurrentTariffSetPeriod_TariffList_0__DayTimeTariff_InitialDistanceFeeValue")));
		return element;
	}
	
	public static WebElement taximeter_confirm_popup (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-describedby='popup_alter_dialog_box']/div/span")));
		return element;
	}//*[@id="EditTariffImg"]
	
	public static WebElement tariff_edit_btn (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.id("EditTariffImg")));
		return element;
	}
	
	public static WebElement tariff_copy_btn (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.id("CopyTariffImg")));
		return element;
	}
	
	public static WebElement remove_tariffset (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.id("removeTaxiMeterTariffSet")));
		return element;
	}
	
	public static WebElement Receipt_tab (WebDriver driver)
	
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.id("TmLink")));
		return element;
	}
	
	
	public static WebElement Receipt (WebDriver driver)
	
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.id("TmReceiptanc")));
		return element;
	}
	
	public static WebElement add_header (WebDriver driver)

	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.className("add_vehicle_btn")));
		return element;
	}
	//*[@id="Name"]
	public static WebElement add_header_line (WebDriver driver)

	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.id("AddHeaderFooter")));
		return element;
	}
	
	public static WebElement header_name (WebDriver driver)

	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.id("Name")));
		return element;
	}
	
	public static WebElement header_description (WebDriver driver)

	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.name("Description")));
		return element;
	}
	
	public static WebElement quip_receipt_element (WebDriver driver)

	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class = 'receipt_title'][contains(text(),'Quipment receipt')]")));
		return element;
	}
	
	public static WebElement company_receipt_element (WebDriver driver)

	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class = 'receipt_title'][contains(text(),'Company receipt')]")));
		return element;
	}
	
	public static WebElement company_logo (WebDriver driver)

	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Logo image')]")));
		return element;
	}
	
	public static WebElement ok_button (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@type='button'][contains(text(),'Ok')]")));
		return element;
	}
	
	public static WebElement save_button_receipt (WebDriver driver)
	{
		wait = new WebDriverWait(driver, 15);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.name("saveTmReceipt")));
		return element;
	}
}
