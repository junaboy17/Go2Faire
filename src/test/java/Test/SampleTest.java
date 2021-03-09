package Test;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.StaleElementReferenceException;
import org.testng.annotations.Test;

import AppBase.ObjectSource;

public class SampleTest {

	@Test
	public void sample() {
		
		ObjectSource source = new ObjectSource();
		
//		source.getDriverFactory().startBrowser("chrome");
//		
//		source.getSeleniumHelper().goToUrl("http://www.go2faire.com/");
//		source.getStartUpPage().clickLogIn();
//		source.getSeleniumHelper().sleep(3).quitBrowser();
//		StackTraceElement s = new StackTraceElement();
		//StaleElementReferenceException e = new StaleElementReferenceException(null);
		//e.printStackTrace();
		
		try {
			//int a = 2/0;
			assertTrue(false);
		}catch(AssertionError e) {
			StackTraceElement[] s = e.getStackTrace();
			System.out.println(s[0]);
			System.out.println(s[1]);
			assertTrue(false);
		}catch(ArithmeticException a) {
//			StackTraceElement[] s = a.getStackTrace();
//			System.out.println(s[0]);
//			System.out.println(s[1]);
			ArithmeticException f = new ArithmeticException("This is a message");
			AssertionError e = new AssertionError();
			e.printStackTrace();
			//f.printStackTrace();
		}
		
	
	}
	
}
