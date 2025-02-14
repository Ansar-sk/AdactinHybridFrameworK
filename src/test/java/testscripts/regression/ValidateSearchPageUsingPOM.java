package testscripts.regression;

import java.util.HashMap;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.SearchPageTitle;
import pages.loginpage;
import utils.UtilKit;

public class ValidateSearchPageUsingPOM extends BaseTest {
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
		sp.indateclear();
		sp.outdateclear();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sp.checkIn(testdatamap.get("Check In Date"));
		sp.checkOut(testdatamap.get("Check out Date"));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sp.searchbutton();
		sp.verifycheckout(testdatamap.get("Checkouterror"));
        
		sp.verifypagetitle(testdatamap.get("Hotel search title"));
	}

	@DataProvider
	public Object[][] datafromexcel() {
		Object[][] data = new Object[1][1];
		data[0][0] = UtilKit.getExcelData("TC-104");
		return data;
	}

}
