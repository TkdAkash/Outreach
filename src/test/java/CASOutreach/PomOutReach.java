package CASOutreach;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class PomOutReach {
	
	WebDriver driver;
	TakesScreenshot ss;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	JavascriptExecutor js = (JavascriptExecutor) driver;

	public PomOutReach(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//	menu
	@FindBy(id = "appFrame") WebElement iframeEl;
	@FindBy(xpath = "//ul[@class='navbar-nav paddingleft5']//li") List<WebElement> menuList;
	@FindBy(xpath = "//ul[@class='navbar-nav paddingleft5']//li[1]") WebElement eventMenu;

//	subMenu
	@FindBy(xpath = "//ul[@class='navbar-nav paddingleft5']//li[1]//div//a") List<WebElement> eventSubMenu;
	@FindBy(xpath = "//a[text()='Donate']") WebElement donateSubmenu;
	@FindBy(xpath = "//ul[@class='navbar-nav paddingleft5']//li[2]") WebElement myVolunteeringSubmenu;
	@FindBy(xpath = "//ul[@class='navbar-nav paddingleft5']//li[3]//div//a") List<WebElement> donateSubmenuList;
	@FindBy(xpath = "//ul[@class='navbar-nav paddingleft5']//li[4]") WebElement elploreMenu;
	@FindBy(xpath = "//ul[@class='navbar-nav paddingleft5']//li[4]//div//a") List<WebElement> exploreSubmenuList;
	@FindBy(xpath = "//ul[@class='navbar-nav paddingleft5']//li[5]") WebElement readmoreMenu;
	@FindBy(xpath = "//ul[@class='navbar-nav paddingleft5']//li[5]//div//a") List<WebElement> readmoreMenuList;
	@FindBy(xpath = "//div[@class='card_event marginleft0']") List<WebElement> interestCardList;
	@FindBy(xpath = "//span[@class='vieweventDrop']") WebElement serachFilterButton;
	@FindBy(xpath = "//button[@class='btn dropdown-toggle bs-placeholder btn-default btn-light']") WebElement eventTypeButton;
	@FindBy(xpath = "//span[text()=' Passion ']")	WebElement eventTypeEducationButton;
	@FindBy(xpath = "//button[@data-id='jsonWeekType']") WebElement weekendButton;
	@FindBy(xpath = "//div[@class='btn-group bootstrap-select custom-searchdropdown show']//a[2]") WebElement weekendOption;

//	Fromdate
	@FindBy(id = "fromDate") WebElement fromDateButton;
	@FindBy(xpath = "//div[@class='datepicker-days']//thead//tr[2]//th[2]") WebElement fomDate;
	@FindBy(xpath = "//div[@class='datepicker-days']//thead//tr[2]//th[2]")	WebElement datepickerDay;
	@FindBy(xpath = "//div[@class='datepicker-months']//thead//tr[2]//th[2]") WebElement datepickerMonths;
	@FindBy(xpath = "//div[@class='datepicker-months']//thead//tr[2]//th[3]") WebElement nextButton;
	@FindBy(xpath = "//div[@class='datepicker-months']//tbody//tr//span[contains(@class,'month')]") List<WebElement> monthsList;
	@FindBy(xpath = "//div[@class='datepicker-days']//tbody//tr//td[starts-with(@class,'day')]") List<WebElement> daysList;

//	ToDate
	@FindBy(id = "toDate") WebElement toDate;
	@FindBy(xpath = "//div[@class='datepicker-days']//thead//tr[2]//th[2]") WebElement toDatepicker;
	@FindBy(xpath = "//div[@class='datepicker-months']//thead//tr[2]//th[2]") WebElement toDatepickerMonth;
	@FindBy(xpath = "//div[@class='datepicker-months']//thead//tr[2]//th[3]") WebElement nextMonth;
	@FindBy(xpath = "//div[@class='datepicker-months']//tbody//tr//span[contains(@class,'month')]") List<WebElement> toMonthList;
	@FindBy(xpath = "//div[@class='datepicker-days']//tbody//tr//td[starts-with(@class,'day')]") List<WebElement> toDaysList;

//	click search button
	@FindBy(id = "eventsHomeSearchBtn") WebElement filterSearchButton;
	@FindBy(xpath = "//div[@id='divsearchevents']//div[@class='title_event']") List<WebElement> serachResultDisplay;
	@FindBy(xpath = "//div[@class='container outind-app']") WebElement OneCognizantPage;
	
//	Volunteering button
	@FindBy(xpath = "//a[text()='My Volunteering']") WebElement myVolunteerButton;
	@FindBy(id = "divvolteer") WebElement volunteerAroundMe; 
	@FindBy(className = "profilevoltext") List<WebElement> listOfVolunteerAroundMe;
	
//	Get all menus are visible while mouse over cursor.
	public List<WebElement> getMenu() {
		driver.switchTo().frame(iframeEl);
		return menuList;
	}

	void helperLoop(List<WebElement> list) {
		for (WebElement el : list) {
			System.out.println(el.getText());
		}
	}

//	Get all submenus are visible while mouse over cursor.
	void getSubMenu() {
		Actions action = new Actions(driver);
		action.moveToElement(eventMenu).perform();

		System.out.println("SubMenu: -----------> ");
		System.out.print("Event: ");
//		System.out.println(eventSubMenu.getText());
		helperLoop(eventSubMenu);

		action.moveToElement(donateSubmenu).perform();
		System.out.print("Donate: ");
		helperLoop(donateSubmenuList);

		action.moveToElement(elploreMenu).perform();
		System.out.print("Explore: ");
		helperLoop(exploreSubmenuList);

		action.moveToElement(readmoreMenu).perform();
		System.out.print("ReadMore: ");
		helperLoop(readmoreMenuList);

		action.moveToElement(myVolunteeringSubmenu).perform();
	}

//	Print Event details based on interest is visible in Outreach.
	public List<WebElement> getInterestCardList() {
		return interestCardList;
	}

//	Validate Search event filter option based on Location, Event type, Weekend/Weekdays, From date and To date and print the search results.
	public void clickSerachFilterButton() {
		serachFilterButton.click();
		eventTypeButton.click();
		eventTypeEducationButton.click();
		weekendButton.click();
		weekendOption.click();
	}

//	Selcting from date

	void helperLoopClick(List<WebElement> element, String data) {
		for (WebElement el : monthsList) {
			if (el.getText().equals(data)) {
				el.click();
				break;
			}
		}
	}

	void fromDateBButton() {
		fromDateButton.click();
//		String[] fromDatePicker = fromDateButton.split(" ");
//		String month = datePickerArr[0];
//		String year = datePickerArr[1];

		String fomrYear = "2024";
		String fromMonth = "May";
		String fromDay = "14";

		datepickerDay.click();
//		selecting year
		while (true) {

			String yr = datepickerMonths.getText();

			if (yr.equals(fomrYear)) {
				break;
			}
			nextButton.click();
		}

//		selecting months
//		helperLoopClick(monthsList, fromMonth);
		for (WebElement el : monthsList) {
			if (el.getText().equals(fromMonth)) {
				el.click();
				break;
			}
		}

//		Selecting day
//		helperLoopClick(daysList, fromDay);
		for (WebElement el : daysList) {
			if (el.getText().equals(fromDay)) {
				el.click();
				break;
			}
		}
	}

//	selecting toDate
	void getToDate() {
		toDate.click();
		toDatepicker.click();

		String toYear = "2024";
		String toMonth = "May";
		String toDay = "14";

//		selecting year
		while (true) {
			String yrs = toDatepickerMonth.getText();
			if (yrs.equals(toYear)) {
				break;
			}
			nextMonth.click();
		}

		for (WebElement el : toMonthList) {
			if (el.getText().equals(toMonth)) {
				el.click();
				break;
			}
		}

		for (WebElement el : toDaysList) {
			if (el.getText().equals(toDay)) {
				el.click();
				break;
			}
		}
	}
	
	void clickFilterSearchButton() throws IOException {
		File scrOneCognizantPage = OneCognizantPage.getScreenshotAs(OutputType.FILE);
		File targetOneCognizantPage = new File("C:\\Users\\2317322\\Selenium_Udemy\\Selenium_CAS_Project\\Screenshots\\OutReach\\SS5.png");
		FileUtils.copyFile(scrOneCognizantPage, targetOneCognizantPage);
		filterSearchButton.click();
		
		
	}
	
	void displaySearchResult() {
		try {
			WebElement displayEvent = driver.findElement(By.xpath("//div[@class='card_eventscroll marginleft0']"));
			boolean status = displayEvent.isDisplayed();
			SoftAssert sa = new SoftAssert();
			System.out.println(status);
			sa.assertEquals(status, true);
			System.out.print("Event based on filters: ");
			for(WebElement el:serachResultDisplay) {
				System.out.println(el.getText());
			}
		}
		catch (Exception e) {
			System.out.println("No event to display");
		}
	}
	
	void myVolunteerOption() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", myVolunteerButton);
//		myVolumteerButton.click();
		volunteerAroundMe.click();
		System.out.println("Volunteers around me: -->>");
		for(WebElement el:listOfVolunteerAroundMe) {
			System.out.println(el.getText());
		}
	}
	
	public void takeScreenshot(String name) throws IOException {
		ss= (TakesScreenshot) driver;
		File source =  ss.getScreenshotAs(OutputType.FILE);
		File target = new File("C:\\Users\\2317322\\Selenium_Udemy\\Selenium_CAS_Project\\Screenshots\\OutReach\\"+name+".png");
		FileHandler.copy(source, target);
	}

}
