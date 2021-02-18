package Test;

import org.testng.annotations.Test;

import AppBase.ObjectSource;

public class LoginTest {
	
	@Test
	public void SuccessfulLogin() {
		ObjectSource source = new ObjectSource();
		source.getDriverFactory().startBrowser("chrome");
		source.getSeleniumHelper().goToUrl("http://go2faire.com/index.php");
		source.getStartUpPage().clickLogIn();
		source.getStartUpPage().enterUsername();
		source.getStartUpPage().enterPassword();
		source.getStartUpPage().clickRedLogin();
		source.getSeleniumHelper().quitBrowser();
	}
		
			
		
	
		
		
		
		
		

		
	}
	
	


	