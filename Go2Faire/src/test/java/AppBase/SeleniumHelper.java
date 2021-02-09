package AppBase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumHelper {
	//Instantiating this class driver with driver from Driver factory so the instance of the driver is always the same
	WebDriver driver = DriverFactory.getDriver();

	//Will sleep for given amount of sec
	public SeleniumHelper sleep(int sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return this;
	}

	//Will sleep for given amount of milli sec
	public SeleniumHelper sleepMili(int sec) {
		try {
			Thread.sleep(sec * 100);
		} catch (InterruptedException e) {
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

	//Will give current date & time
	public Date date() {
		return new Date();
	}

	//Will give current date
	public String dateOnly() {
		DateFormat format = new SimpleDateFormat("MM/dd/yyy");
		Date date = new Date();
		String date1= format.format(date);
		return date1;
	}

	//Wait function to wait until page or dom loads defaulted to 3 sec
	public void waitForLoad() {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver input) {
				return ((JavascriptExecutor)driver).executeScript("return document.readyState").toString().equals("complete");
			}
		};

		try {
			sleepMili(5);
			WebDriverWait wait = new WebDriverWait(driver, 3);
			wait.until(expectation);
		}catch(Throwable error) {
			System.out.println("Timedout waiting for page load request to complete");
		}	
	}

	//Wait function to wait until page or dom loads for given amount sec
	public void waitForLoad(int sec) {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver input) {
				return ((JavascriptExecutor)driver).executeScript("return document.readyState").toString().equals("complete");
			}
		};

		try {
			sleepMili(5);
			WebDriverWait wait = new WebDriverWait(driver, sec);
			wait.until(expectation);
		}catch(Throwable error) {
			System.out.println("Timedout waiting for page load request to complete");
		}	
	}

	//Will wait for element to be present - Explicit wait
	public boolean ifWebElementExists(WebElement element) {
		boolean isPresent;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			isPresent = wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
			return isPresent;
		}catch(Exception e) {
			return false;
		}
	}
	
	//Will find element by Xpath
	public WebElement findElement(String xpath) {
		return driver.findElement(By.xpath(xpath));
	}

	//Highlight Element
	public WebElement highLightElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='3px solid red'", element);
		sleep(1);
		return element;
	}

	//Un-Highlight Element
	public WebElement unHighLightElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='0px solid white'", element);
		sleep(1);
		return element;
	}


	//Find an element with 3 attempts with page included
	public WebElement getWebElement(WebElement element) {
		waitForLoad();
		int attempts = 0;

		while(attempts <3) {
			try {
				if(ifWebElementExists(element)==true) {
					highLightElement(element);
					unHighLightElement(element);
					return element;
				}
			}catch(ElementNotVisibleException e) {
				waitForLoad();
				attempts++;
			}
		}
		return null;
	}


}
