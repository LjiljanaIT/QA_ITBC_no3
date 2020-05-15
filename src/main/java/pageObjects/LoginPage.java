package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public static String logIn(WebDriver driver, String username, String password) {
		Resources.waitFOR(2000);

		WebElement username_field = driver.findElement(Resources.getBy("login_form_input_username"));
		username_field.click();
		username_field.sendKeys(username);

		WebElement password_field = driver.findElement(Resources.getBy("login_form_input_password"));
		password_field.click();
		password_field.sendKeys(password);
		
		WebElement login = driver.findElement(Resources.getBy("login_form_input_blue"));
		login.click();
		return driver.getCurrentUrl();
	}
}
