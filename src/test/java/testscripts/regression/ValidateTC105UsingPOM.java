package testscripts.regression;

import java.util.HashMap;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.SearchPageTitle;
import pages.SelectHotelPage;
import pages.loginpage;
import utils.UtilKit;

public class ValidateTC105UsingPOM extends BaseTest {
	@Test(dataProvider = "datafromexcel")
	// To validate incorrect checkout date
	public void Validatesearchpage(HashMap<String, String> testdatamap) {
		loginpage lp = PageFactory.initElements(driver, loginpage.class);
		lp.usernametextfield(testdatamap.get("username"));
		lp.passwordtextfield(testdatamap.get("password"));
		lp.loginbuttonfield();
		lp.verifypagetitle(testdatamap.get("Hotel search title"));

		SearchPageTitle sp = PageFactory.initElements(driver, SearchPageTitle.class);
		sp.locationfield(testdatamap.get("location"));
		sp.hotelField(testdatamap.get("hotel"));
		sp.roomTypeField(testdatamap.get("Room Type"));
		sp.numOfRoomsField(testdatamap.get("No of rooms"));
		sp.adultsperRoom(testdatamap.get("Adults per Room"));
		sp.childrenPerRoom(testdatamap.get("Children per Room  "));
		sp.indateclear();
		sp.outdateclear();
		
		sp.checkIn(testdatamap.get("Check In Date"));
		sp.checkOut(testdatamap.get("Check out Date"));
		
		sp.searchbutton();
        
		sp.verifypagetitle(testdatamap.get("Hotel select title"));
		SelectHotelPage sh= PageFactory.initElements(driver, SelectHotelPage.class);
		
		sh.selectradio();
		sh.selectcontinue();
	}

	@DataProvider
	public Object[][] datafromexcel() {
		Object[][] data = new Object[1][1];
		data[0][0] = UtilKit.getExcelData("TC-105");
		return data;
	}

}
