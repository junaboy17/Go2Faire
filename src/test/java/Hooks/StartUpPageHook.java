package Hooks;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import AppBase.DataSource;
import AppBase.ObjectSource;

public class StartUpPageHook {
	protected ObjectSource source = new ObjectSource();
	protected String actual;
	protected String expected;
	

	@BeforeMethod
	public void testSetUp(ITestResult result) {
		System.out.println("Starting Test :" + result.getMethod().getMethodName());
		source.getDriverFactory().startBrowser(DataSource.browser.baseBrowser);
		source.getSeleniumHelper().goToUrl(DataSource.Url.baseUrl);
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		if(!result.isSuccess()) {
			source.getSeleniumHelper().takeScreenShot(result.getMethod().getMethodName());
		}
		source.getSeleniumHelper().sleep(2).quitBrowser();
	}
	
}
