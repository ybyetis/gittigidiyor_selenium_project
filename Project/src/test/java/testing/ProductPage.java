package testing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class ProductPage extends BasePage {
	String discountPriceId = "sp-price-discountPrice";
	String lowPriceId = "sp-price-lowPrice";
	String highPriceId = "sp-price-highPrice";

	void addToBasket() throws InterruptedException {
		By discountPrice = By.id(discountPriceId);
		By lowPrice = By.id(lowPriceId);
		By highPrice = By.id(highPriceId);
		if (!driver.findElement(discountPrice).getText().isEmpty()) {
			productPrice = driver.findElement(discountPrice).getText().strip();
		} else {
			if (!driver.findElement(lowPrice).getText().isEmpty()) {
				productPrice = driver.findElement(lowPrice).getText().strip();
			} else
				productPrice = driver.findElement(highPrice).getText().strip();
		}
		writeLog("Product's price has been recorded");
		Thread.sleep(1000);
		By addBasket = By.id("add-to-basket");
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				driver.findElement(addBasket));
		Thread.sleep(1000);
		driver.findElement(addBasket).click();
		writeLog("Product added to cart");
		Thread.sleep(1000);
	}
}
