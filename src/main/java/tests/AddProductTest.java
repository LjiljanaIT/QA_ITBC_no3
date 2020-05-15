package tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.*;


public class AddProductTest {
	public static WebDriver driver; // = new ChromeDriver();
	private static SoftAssert sa = new SoftAssert();
	private static Resources resources = Resources.getInstance();

	@BeforeClass
	public static void setUp() {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		//driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to(Resources.get("URL_LOGIN"));
		//Resources.waitFOR(2000);
		LoginPage.logIn(driver, Resources.get("username"), Resources.get("password"));
		//Resources.waitFOR(2000);
	}

	@AfterClass
	public static void tearDown() {
		// loguot
		driver.close();
	}

	@Test
	public static void test01_addProduct() throws FileNotFoundException, IOException {
		Products product;
		String productsURL, current_name, expected_name;
		// n=number of products you want to create. 1 is default.
		int n = 1;
		for (int i = 1; i <= n; i++) {
			// go to products page + click "Add Product"
			driver.navigate().to(Resources.get("URL_PRODUCTS"));
			Products_page.ClickAddProduct(driver);

			product = ProductsObjectsFromData.writeRowIntoProduct(i); // create object "products" of Products
			expected_name = product.getName();// keep name property of "product" for asserting
			productsURL = AddProduct.createProduct(driver, product);// create new product, returns URL after saving
																	// product
			driver.navigate().to(productsURL); // go to returned URL
			current_name = Products_page.getProductName(driver);// get name of the product on that URL
			sa.assertEquals(current_name, expected_name);// assert by name
		}

	}

}
