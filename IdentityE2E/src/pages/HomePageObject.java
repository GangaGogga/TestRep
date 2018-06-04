package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageObject {
	
	WebDriver driver;
	
	public void clickStartButton()
	{
		driver.findElement(By.xpath("//*[@class='gem-c-button gem-c-button--start']")).click();
	}
	
	public String getHeading()
	{
		return driver.findElement(By.xpath("pub-c-title__text ")).getText();
	}
	
	// Constructor initialises the state of the driver
	public HomePageObject(WebDriver driver)
	{
		this.driver = driver;
	}

}
