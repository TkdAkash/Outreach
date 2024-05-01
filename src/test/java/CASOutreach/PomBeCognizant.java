package CASOutreach;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PomBeCognizant {

	WebDriver driver;
	TakesScreenshot ss;
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	JavascriptExecutor js = (JavascriptExecutor) driver;

	public PomBeCognizant(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//	Beocognizant
	@FindBy(className = "_8ZYZKvxC8bvw1xgQGSkvvA==")
	WebElement profileButton;
	@FindBy(xpath = "//div[@id='mectrl_currentAccount_primary']")
	WebElement txt_username;
	@FindBy(id = "mectrl_currentAccount_secondary")
	WebElement txt_email;
	
//	oneCognizant
	@FindBy(xpath = "//div[text()='OneCognizant']") WebElement oncognizant;

	public void getProfileDetails() throws InterruptedException {
		
		wait.until(ExpectedConditions.visibilityOf(profileButton));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", profileButton);
		
		System.out.println("User Information:");
		Thread.sleep(4000);
		System.out.println(txt_username.getText());
		System.out.println(txt_email.getText());
	}
	
	void getOnconzinat() {
		oncognizant.click();
	}
	
	public String getWindows() {
		Set<String> windows = driver.getWindowHandles();
		List<String> listWindows = new ArrayList<String>(windows);
//		String parent = listWindows.get(0);
		String child = listWindows.get(1);
		return child;
	}
	//Screenshot
	
	public void takeScreenshot(String name) throws IOException {
		ss= (TakesScreenshot) driver;
		File source =  ss.getScreenshotAs(OutputType.FILE);
		File target = new File("C:\\Users\\2317322\\Selenium_Udemy\\Selenium_CAS_Project\\Screenshots\\BeCognizant\\"+name+".png");
		FileHandler.copy(source, target);
	}
	
}
