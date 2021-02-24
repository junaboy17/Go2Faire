package Test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import AppBase.ObjectSource;
import AppBase.SeleniumHelper;
import Hooks.StartUpPageHook;

public class UserRegistrationTest extends StartUpPageHook{


	@Test
	public void RegistrationTitleCheck() {
		
		SeleniumHelper.log.info("Verifying registration page title");
		expected = "User Registration";
		actual = source	.getStartUpPage()
						.clickLogIn()
						.clickSignUp()
						.readTitle();
		assertEquals(actual, expected);
		
	}
}
