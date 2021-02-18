package Test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import AppBase.ObjectSource;

public class UserRegistrationTest {


	@Test
	public void RegistrationTitleCheck() {

		ObjectSource source = new ObjectSource();
		String actual;
		String expected;

		source.getDriverFactory().startBrowser("chrome");
		source.getSeleniumHelper().goToUrl("http://www.go2faire.com/");
		
		expected = "User Registration";
		actual = source	.getStartUpPage()
						.clickLogIn()
						.clickSignUp()
						.readTitle();
		source.getSeleniumHelper().quitBrowser();
		assertEquals(actual, expected);
	}
}
