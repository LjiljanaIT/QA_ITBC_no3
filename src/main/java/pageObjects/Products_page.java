package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Products_page {
	
	public static String getProductName(WebDriver driver) {
		WebElement name_field = driver.findElement(Resources.getBy("product_form_input_name"));
		name_field.click();
		return name_field.getAttribute("value");
	}

	public static void ClickAddProduct(WebDriver driver) {
		WebElement add_btn = driver.findElement(Resources.getBy("product_link_addNewProduct"));
		add_btn.click();
	}
}
