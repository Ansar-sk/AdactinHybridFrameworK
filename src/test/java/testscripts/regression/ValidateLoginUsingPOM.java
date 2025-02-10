package testscripts.regression;

import java.util.HashMap;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.SearchPageTitle;
import pages.loginpage;
import utils.UtilKit;
@Test
public class ValidateLoginUsingPOM extends BaseTest {
	@Test(dataProvider = "dataFromExcel")
	public void validatelogin(HashMap<String, String> testdatamap) {
   loginpage lp = PageFactory.initElements(driver, loginpage.class);
   lp.usernametextfield(testdatamap.get("username"));
   lp.passwordtextfield(testdatamap.get("password"));
   lp.loginbuttonfield();
   lp.verifypagetitle(testdatamap.get("Hotel search title"));
   
   SearchPageTitle sp =PageFactory.initElements(driver, SearchPageTitle.class);
   sp.locationfield("Sydney");
   sp.hotelField("Hotel Creek");
   sp.roomTypeField("Standard");
   sp.numOfRoomsField("3 - Three");  
   sp.checkIn("27/01/2025");
   sp.checkOut("28/01/2025");
   sp.adultsperRoom("2 - Two");
   sp.childrenPerRoom("2 - Two");
   sp.searchbutton();
   sp.verifypagetitle("Adactin.com - Select Hotel");
}
	@DataProvider
	public Object[][] dataFromExcel(){
		Object[][] data=new Object[1][1];
		data[0][0]=UtilKit.getExcelData("TC-119");
		return data;
	}
}
