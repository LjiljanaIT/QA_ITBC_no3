package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddProduct {

	public static String createProduct(WebDriver driver, Products add) {

		Resources.waitFOR(2000);

		WebElement name_field = driver.findElement(Resources.getBy("product_form_input_name"));
		name_field.click();
		name_field.sendKeys(add.name);

		WebElement id_field = driver.findElement(Resources.getBy("product_form_input_vendorProductId"));
		id_field.click();
		id_field.sendKeys(add.id);

		WebElement description_field = driver.findElement(Resources.getBy("product_form_input_description"));
		description_field.click();
		description_field.sendKeys(add.description);

		WebElement long_field = driver.findElement(Resources.getBy("product_form_input_longDescription"));
		long_field.click();
		long_field.sendKeys(add.long_description);

		if (add.tangible) {
			WebElement yes_btn = driver.findElement(Resources.getBy("product_form_input_tangible"));
			yes_btn.click();

			WebElement weight_field = driver.findElement(Resources.getBy("product_form_input_weight"));
			weight_field.click();
			weight_field.sendKeys(String.valueOf(add.weight));

			WebElement handeling_field = driver.findElement(Resources.getBy("product_form_input_handling"));
			handeling_field.click();
			handeling_field.sendKeys(String.valueOf(add.handling));
		}

		WebElement price = driver.findElement(Resources.getBy("product_form_input_price"));
		price.click();
		price.sendKeys(String.valueOf(add.price));
		

		WebElement save = driver.findElement(Resources.getBy("product_form_input_submit"));
		save.click();

		return driver.getCurrentUrl();

	}

}
