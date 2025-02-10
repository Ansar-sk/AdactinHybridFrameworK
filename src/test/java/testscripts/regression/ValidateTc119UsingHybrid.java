package testscripts.regression;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import keywords.ApplicationKeywords;
import utils.UtilKit;

public class ValidateTc119UsingHybrid extends BaseTest {
@Test(dataProvider = "exceldata")
public void validateDates(HashMap<String, String> testdatamap) {
	ApplicationKeywords app = new ApplicationKeywords();
	app.startbrowser();
	app.launchapp();
	app.type("username_textbox", testdatamap.get("username"));
	app.type("password_textbox", testdatamap.get("password"));
	app.click("login_button");
	app.selectItemFromDropdown("location", testdatamap.get("location"));//location
	app.selectItemFromDropdown("number_of_rooms", testdatamap.get("No of rooms"));//num of rooms
	app.selectItemFromDropdown("hotel_dropdown", testdatamap.get("hotel"));//hotel
	app.selectItemFromDropdown("room_type_id", testdatamap.get("Room Type"));
	
	app.getElement("check_in_date").clear();
	app.type("check_in_date", testdatamap.get("Check In Date"));//in date
	
	app.getElement("check_out_date").clear();
	app.type("check_out_date", testdatamap.get("Check out Date"));//out date
	
	app.selectItemFromDropdown("adult_room_id", testdatamap.get("Adults per Room"));
	app.click("Search_button");
	app.Validateattributes("Compare_hotel", "value", testdatamap.get("hotel"));
	app.click("hotel_radio_button_id");
	app.click("continue_button");
	
	
	//app.type("last_name", testdatamap.get("First Name"));
	app.type("first_name_textbox", testdatamap.get("First Name"));
	app.type("last_name_textbox", testdatamap.get("LastName"));
	app.type("address", testdatamap.get("Address"));
	app.type("credit_number", testdatamap.get("Credit num"));
	app.selectItemFromDropdown("card_type", testdatamap.get("Card type"));
	app.selectItemFromDropdown("expiry_month", testdatamap.get("Expiry month"));
	app.selectItemFromDropdown("expiry_year", testdatamap.get("Expiry year"));
	app.type("cvv", testdatamap.get("CVV number"));
	app.click("booknow_button");
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	WebElement itenary= app.getElement("my_iternary");
	wait.until(ExpectedConditions.visibilityOf(itenary)); 
	String ordernumber = app.getattribute("order_num", "value");
	app.click("my_iternary");
	app.type("order_textbox", ordernumber);
	app.click("go_button");
	app.click("order_checkbox");
	app.click("cancel_order");
	driver.switchTo().alert().accept();
	app.type("order_textbox", ordernumber);
	app.click("go_button");
	
	app.ValidateText("zero_results_found","0 result(s) found. Show all");
	
	
	 
	
}
//new Object[1][1] initializes a 2D array with 1 row and 1 column.
//This means there is only one test data set (the row count is 1)
//and one data point (the column count is 1) in that test set.
//data[0][0] means "the first (and only) row's first (and only) column", 
//so you're assigning the value from UtilKit.getExcelData("TC-114") to this position.
@DataProvider
public Object[][] exceldata() {
	Object[][] data =new Object[1][1];
data[0][0]=UtilKit.getExcelData("TC-119");
	return data;
	
}
}
