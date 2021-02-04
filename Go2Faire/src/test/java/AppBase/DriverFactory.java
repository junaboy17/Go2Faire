package AppBase;

import java.util.concurrent.TimeUnit;

import org.apache.tools.ant.taskdefs.WaitFor.Unit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	private static WebDriver driver;

	public static WebDriver getDriver() {
		return driver;
	}
	
	public void startBrowser(String browser) {
		
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			System.setProperty("webdriver.chrome.silentOutput", "true");
			driver = new ChromeDriver(options);
			System.out.println("----------------------------Openning Up Chrome Browser-------------------------");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.get("https://www.google.com/");
		}
		
		else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		else if (browser.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		
		else {
			System.out.println("Incorrect driver.  Please choose a proper driver. Ex. Chrome, Firefox, IE");
		}
		
	}
	
}
