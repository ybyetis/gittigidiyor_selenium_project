package testing;

import java.util.Random;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BasePage {
	static WebDriver driver;
	static LoginPage loginPage;
	static SearchPage searchPage;
	static ProductPage productPage;
	static BasketPage basketPage;
	static String email = "";
	static String password = "";
	static int randomPageIndex = -1;
	static String productPrice = "";
	private static LogHelper logHelper;

	@Test
	@Order(1)
	public void initDriver() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\YBY\\eclipse-workspace\\Project\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		writeLog("Chrome browser opened");
		Thread.sleep(500);
		driver.get("https://www.gittigidiyor.com/");
		Thread.sleep(1000);
		writeLog("Gittigidiyor Main Page opened");

	}

	@Test
	@Order(2)
	public void initPages() {
		loginPage = new LoginPage();
		searchPage = new SearchPage();
		productPage = new ProductPage();
		basketPage = new BasketPage();
		writeLog("Pages initted.");
	}

	@Test
	@Order(3)
	public void loginTest() throws InterruptedException {
		loginPage.loginUp(email, password);
	}

	@Test
	@Order(4)
	public void searchTest() throws InterruptedException {
		searchPage.initViews();
		searchPage.search(getRandomPageIndex());
	}

	@Test
	@Order(5)
	public void productTest() throws InterruptedException {
		productPage.addToBasket();
	}

	@Test
	@Order(6)
	public void basketTest() throws InterruptedException {
		if (basketPage.comparePrices()) {

			basketPage.increaseAmountOfProduct();
			basketPage.deleteAllProducts();
		} else {
			writeLog("Prices aren't equal.");
		}
	}

	private int getRandomPageIndex() {
		return new Random().nextInt(48) + 1;
	}

	static void writeLog(String logMessage) {
		LogHelper.info(logMessage);
	}
}
