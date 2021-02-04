package AppBase;

import org.openqa.selenium.WebDriver;

public class SeleniumHelper {
	//Instantiating this class driver with driver from Driver factory so the instance of the driver is always the same
	WebDriver driver = DriverFactory.getDriver();

	//Will sleep for given amount of sec
	public SeleniumHelper sleep(int sec) {
		try {
			Thread.sleep(sec * 100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}

	//Will quit all browser associated with current driver
	public SeleniumHelper quitBrowser() {
		driver.quit();
		return this;
	}

	//Will close current window only associated with current driver
	public SeleniumHelper closeBrowser() {
		driver.close();
		return this;
	}

	//Will go to a given Url
	public SeleniumHelper goToUrl(String url) {
		driver.get(url);
		return this;
	}

	//Will navigate to given url
	public SeleniumHelper navigateToUrl(String url) {
		driver.navigate().to(url);
		return this;
	}

	//Will navigate to previous page
	public SeleniumHelper navigateBack() {
		driver.navigate().back();
		return this;
	}

	//Will navigate forward
	public SeleniumHelper navigateForward() {
		driver.navigate().forward();
		return this;
	}

	//Will refresh page
	public SeleniumHelper refreshPage() {
		driver.navigate().refresh();
		return this;
	}
}
