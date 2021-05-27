package testing;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;

public class SearchPage extends BasePage {
	static String inputName = "k";
	static String findButtonPath = "//*[@id=\"main-header\"]/div[3]/div/div/div/div[2]/form/div/div[2]/button";

	void initViews() {
		driver.findElement(By.name(inputName)).click();
		driver.findElement(By.name(inputName)).sendKeys("bilgisayar");
		driver.findElement(By.xpath(findButtonPath)).click();
	}

	void search(int pageIndex) throws InterruptedException {
		Thread.sleep(1000);
		writeLog("Searched the 'bilgisayar' ");
		driver.get(driver.getCurrentUrl() + "&sf=" + "2");
		assertEquals(driver.getCurrentUrl(), "https://www.gittigidiyor.com/arama/?k=bilgisayar&sf=2");
		Thread.sleep(1000);
		writeLog("Page 2 opened");
		driver.findElement(By.cssSelector(".products-container>li:nth-of-type(" + pageIndex + ")")).click();
		writeLog("Random product selected");
		Thread.sleep(1000);
	}

}
