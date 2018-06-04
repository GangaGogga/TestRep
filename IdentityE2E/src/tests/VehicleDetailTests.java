package tests;

import java.io.File;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;

import junit.framework.Assert;
import pages.HomePageObject;
import pages.EnquiryPageObject;
import pages.VehicleDetailPageObject;
import part1.ReadFiles;


@RunWith(value = Parameterized.class)
public class VehicleDetailTests {
	
	WebDriver driver;
	String webUrl = "https://www.gov.uk/get-vehicle-information-from-dvla";
	String errorMessage = "";
	
	String regNumber;
	String make;
	String colour;
	
	HomePageObject homePage;
	EnquiryPageObject enquiryPage;
	VehicleDetailPageObject vehicleDetailPage;
	
	@Test
	public void assertVehicleDetails() throws Exception
	{
		System.out.println("CSV RECORD: " + regNumber + " " + make + " " + colour);
		// Enter the start now button in dvla home page
		homePage.clickStartButton();
		
		// Read the reg number value from csv file and input in enquiry details page
		enquiryPage = new EnquiryPageObject(driver);
		enquiryPage.inputRegDetails(regNumber);
		
		
		// Get the make and colour values for reg num from vehicle details page and validate it with values in csv file
		vehicleDetailPage = new VehicleDetailPageObject(driver);
		String actualMakeValue = vehicleDetailPage.getSpanList().get(4).getText().toLowerCase();
		String actualColourValue = vehicleDetailPage.getSpanList().get(6).getText().toLowerCase();
		System.out.println("Actual Make: " + actualMakeValue + " Actual Colour: " + actualColourValue);
		
		// Assert the values in csv with actual web page value
		Assert.assertEquals("The csv make value doesnt match with actual value for " + vehicleDetailPage.getSpanList().get(2).getText(),
				make.toLowerCase(), actualMakeValue);
		Assert.assertEquals("The csv colour value doesnt match with actual value for " + vehicleDetailPage.getSpanList().get(2).getText(),
				colour.toLowerCase(), actualColourValue);
	}

	
	// This annotated method is used to pass the parameters into the class via constructor
	@Parameters
	public static List<String[]> getData()
	{
		// Get the path of input file from part 1
		String path = ReadFiles.directoryLinuxMac;
		String filename = "/TestDet.csv";
		// Read the contents of CSV file
		return utilities.ReadCSVFile.get(path + filename);
	}
	
	// The constructor passes the parameters to the method
	public VehicleDetailTests(String regNumber, String make, String colour)
	{
		this.regNumber = regNumber;
		this.make = make;
		this.colour = colour;
	}
	
	@Before
	public void setUp()
	{
		driver = utilities.WebDriverFactory.Open("Chrome");
		driver.get(webUrl);
		homePage = new HomePageObject(driver);
	}
	
	@After
	public void tearDown()
	{
		driver.close();
	}
}
