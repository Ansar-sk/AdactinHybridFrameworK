package testscripts.regression;

import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import keywords.ApplicationKeywords;
import utils.UtilKit;

public class ValidateLoginUsingKeywords extends BaseTest {
@Test(dataProvider = "getTestData")
public void login(HashMap<String, String> testdatamap) {
	ApplicationKeywords app = new ApplicationKeywords();
	app.startbrowser();
	app.launchapp(); 
	app.type("username_textbox",testdatamap.get("username"));
	app.type("password_textbox", "password");
	app.click("login_button");
	app.ValidateTitle(locatorsprop.getProperty("title"));
}
@DataProvider
public Object[][] getTestData(){
	 Object[][] data=new Object[1][1];
	 data[0][0]=UtilKit.getExcelData("TC-113");
	return data; //This will holds the data of the given testcase and will be returned to top method
	
}
}
