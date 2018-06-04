package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EnquiryPageObject {
	
	WebDriver driver;
	WebDriverWait wait;
	
	// Explicit wait until Heading of vehicle detail page is located
	public void waitUntilPageLoad()
	{
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("heading-large")));
	}
	
	public String getHeading()
	{
		waitUntilPageLoad();
		return driver.findElement(By.className("heading-large")).getText();
	}
	
	public void inputRegDetails(String regNumber)
	{
		waitUntilPageLoad();
		driver.findElement(By.xpath("//*[@class='form-control form-control-1-4 input-upper']")).sendKeys(regNumber);
		driver.findElement(By.className("button")).click();
	}
	
	// Constructor initialises the state of the driver
	public EnquiryPageObject(WebDriver driver)
	{
		this.driver = driver;
	}
	

}
