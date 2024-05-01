package CASOutreach;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PomOneCognizant {
	
	WebDriver driver;
	TakesScreenshot ss;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	public PomOneCognizant(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
//	search
	@FindBy(className = "searchTopBar") WebElement searchButton;
	@FindBy(id = "oneCSearchTop") WebElement searchSpace;
	@FindBy(xpath = "//div[@class='appsResultText' and text()='Outreach']") WebElement outReachButton;
	
	public void getSerachButton() {
		wait.until(ExpectedConditions.visibilityOf(searchButton));
		searchButton.click();
		searchSpace.sendKeys("Outreach");
		outReachButton.click();
	}
	
	public void takeScreenshot(String name) throws IOException {
		ss= (TakesScreenshot) driver;
		File source =  ss.getScreenshotAs(OutputType.FILE);
		File target = new File("C:\\Users\\2317322\\Selenium_Udemy\\Selenium_CAS_Project\\Screenshots\\OneCognizant\\"+name+".png");
		FileHandler.copy(source, target);
	}

}
