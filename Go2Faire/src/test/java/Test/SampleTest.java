package Test;

import org.testng.annotations.Test;

import AppBase.ObjectSource;

public class SampleTest {

	@Test
	public void sample() {
		
		ObjectSource source = new ObjectSource();
		
		source.getDriverFactory().startBrowser("chrome");
		
		source.getSeleniumHelper().goToUrl("http://www.go2faire.com/");
		source.getStartUpPage().clickLogIn();
		source.getSeleniumHelper().sleep(3).quitBrowser();
	
		
	}
	
}
