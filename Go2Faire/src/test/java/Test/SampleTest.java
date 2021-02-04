package Test;

import org.testng.annotations.Test;

import AppBase.DriverFactory;
import AppBase.SeleniumHelper;

public class SampleTest {

	@Test
	public void sample() {
		
		DriverFactory factory = new DriverFactory();
		factory.startBrowser("chrome");
		SeleniumHelper helper = new SeleniumHelper();
		
		helper.goToUrl("http://www.go2faire.com/")
		.refreshPage()
		.sleep(3)
		.quitBrowser();
		
	}
	
}
