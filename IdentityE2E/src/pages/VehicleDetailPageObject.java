package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class VehicleDetailPageObject {
	
	WebDriver driver;
	WebDriverWait wait;
	
	// Explicit wait until Heading of vehicle detail page is located
	public void waitUntilPageLoad()
	{
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='heading-large']")));
	}
	
	public String getHeading()
	{
		waitUntilPageLoad();
		return driver.findElement(By.xpath("//*[@class='heading-large']")).getText();
	}
	
	public List<WebElement> getSpanList()
	{
		waitUntilPageLoad();
		return driver.findElements(By.xpath("//span"));
	}
	
	// Constructor initialises the state of the driver
	public VehicleDetailPageObject(WebDriver driver)
	{
		this.driver = driver;
	}

}
