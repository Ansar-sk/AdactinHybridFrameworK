package testscripts.regression;

import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import keywords.ApplicationKeywords;
import utils.UtilKit;

public class ValidateTcUsingHybrid extends BaseTest {
@Test(dataProvider = "exceldata")
public void validateDates(HashMap<String, String> testdatamap) {
	ApplicationKeywords app = new ApplicationKeywords();
	app.startbrowser();
	app.launchapp();
	app.type("username_textbox", testdatamap.get("username"));
	app.type("password_textbox", testdatamap.get("password"));
	app.click("login_button");
	app.selectItemFromDropdown("location", testdatamap.get("location"));
	app.selectItemFromDropdown("number_of_rooms", testdatamap.get("No of rooms"));
	app.getElement("check_in_date").clear();
	app.type("check_in_date", testdatamap.get("Check In Date"));
	
	app.getElement("check_out_date").clear();
	app.type("check_out_date", testdatamap.get("Check out Date"));
	app.click("Search_button");
	app.ValidateText("error_message", "Check-In Date shall be before than Check-Out Date");
	
	
	
	 
	
}
//new Object[1][1] initializes a 2D array with 1 row and 1 column.
//This means there is only one test data set (the row count is 1)
//and one data point (the column count is 1) in that test set.
//data[0][0] means "the first (and only) row's first (and only) column", 
//so you're assigning the value from UtilKit.getExcelData("TC-114") to this position.
@DataProvider
public Object[][] exceldata() {
	Object[][] data =new Object[1][1];
data[0][0]=UtilKit.getExcelData("TC-114");
	return data;
	
}
}
