package testscripts.regression;

import java.util.HashMap;import org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import keywords.ApplicationKeywords;
import utils.UtilKit;
//To validate the total price of the hotel including gst
public class ValidateTc110UsingHybrid extends BaseTest {
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
	
	//change url to adactin build2 url, then this testcase will be passed, in build 1 it is a defect
	Assert.assertEquals(app.ValidateTotalPrice("numberofrooms","value", "totaldays", "value", "pricepernight", "value"), app.extractNumber(app.getElement("final_price").getAttribute("value"))); 
			
	
	
	
	 
	
}
//new Object[1][1] initializes a 2D array with 1 row and 1 column.
//This means there is only one test data set (the row count is 1)
//and one data point (the column count is 1) in that test set.
//data[0][0] means "the first (and only) row's first (and only) column", 
//so you're assigning the value from UtilKit.getExcelData("TC-114") to this position.
@DataProvider
public Object[][] exceldata() {
	Object[][] data =new Object[1][1];
data[0][0]=UtilKit.getExcelData("TC-110");
	return data;
	
}
}
