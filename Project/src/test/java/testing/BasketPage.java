package testing;

import org.openqa.selenium.By;

public class BasketPage extends BasePage {
	String cartButtonId = "robot-header-iconContainer-cart";
	String newPriceId = "new-price";
	String addProductPath = "//select[@class='amount']";
	String pageIndex = "2";
	String deleteProductsPath = "//div[@class='text-box']//a[@title='Sil']";

	boolean comparePrices() throws InterruptedException {
		driver.findElement(By.className(cartButtonId)).click();
		writeLog("Opened to the basket");
		Thread.sleep(1000);
		String price_basket = driver.findElement(By.className(newPriceId)).getText().strip();
		writeLog("The price of the product in the basket has been recorded");
		writeLog("Prices compared");
		return productPrice.equals(price_basket);
	}

	void increaseAmountOfProduct() throws InterruptedException {
		Thread.sleep(1000);
		By addProduct = By.xpath(addProductPath);
		driver.findElement(addProduct).sendKeys(pageIndex);
		writeLog("The number of products has been increased to 2");
		Thread.sleep(1000);
	}

	void deleteAllProducts() throws InterruptedException {
		Thread.sleep(1000);
		By deleteProducts = By.xpath(deleteProductsPath);
		driver.findElement(deleteProducts).click();
		writeLog("Products has been deleted");
		Thread.sleep(1000);
	}

}
