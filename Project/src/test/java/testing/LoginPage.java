package testing;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {
	String profileId = "div[data-cy='header-user-menu";
	String loginButtonId = "a[data-cy='header-login-button']";
	String userNameTextInputId = "L-UserNameField";
	String passwordTextInputId = "L-PasswordField";
	String loginEnterButtonId = "gg-login-enter";
	String myOrders = "Sipariþlerim";

	public void loginUp(String email, String password) throws InterruptedException {
		driver.findElement(By.cssSelector(profileId)).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(loginButtonId)).click();
		Thread.sleep(1000);
		driver.findElement(By.id(userNameTextInputId)).sendKeys(email);
		Thread.sleep(1000);
		driver.findElement(By.id(passwordTextInputId)).sendKeys(password);
		Thread.sleep(1000);
		driver.findElement(By.id(loginEnterButtonId)).click();
		assertTrue(driver.getPageSource().contains(myOrders));
		writeLog("Logged In");
	}
}
