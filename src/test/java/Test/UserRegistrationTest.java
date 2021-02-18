package Test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import AppBase.ObjectSource;
import Hooks.StartUpPageHook;

public class UserRegistrationTest extends StartUpPageHook{


	@Test
	public void RegistrationTitleCheck() {
		
		expected = "User Registration";
		actual = source	.getStartUpPage()
						.clickLogIn()
						.clickSignUp()
						.readTitle();
		assertEquals(actual, expected);
		
	}
}
