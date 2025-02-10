package testscripts.regression;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import utils.UtilKit;

public class ValidateLoginWithExcelDataTc2 extends BaseTest {
	
@Test(dataProvider="getTestData")
public void validatetc2(HashMap<String, String> testdatamap)//parameter to get store data as hashmap since the data is being returned in key value pair from below
{
driver.findElement(By.xpath("//input[@name='username']")).sendKeys(testdatamap.get("username"));
driver.findElement(By.xpath("//input[@name='password']")).sendKeys(testdatamap.get("password"));
driver.findElement(By.xpath("//input[@name='login']")).click();
Assert.assertEquals(driver.getTitle(), testdatamap.get("expected Title"));
new Select(driver.findElement(By.xpath("//select[@name='location']"))).selectByVisibleText(testdatamap.get("location"));
new Select(driver.findElement(By.xpath("//select[@name='hotels']"))).selectByVisibleText(testdatamap.get("hotel"));
new Select(driver.findElement(By.xpath("//select[@name='room_type']"))).selectByVisibleText(testdatamap.get("Room Type"));
new Select(driver.findElement(By.xpath("//select[@name='room_nos']"))).selectByVisibleText(testdatamap.get("No of rooms"));
driver.findElement(By.xpath("//input[@name='datepick_in']")).clear();
driver.findElement(By.xpath("//input[@name='datepick_in']")).sendKeys(testdatamap.get("Check In Date"));
driver.findElement(By.xpath("//input[@name='datepick_out']")).clear();
driver.findElement(By.xpath("//input[@name='datepick_out']")).sendKeys(testdatamap.get("Check out Date"));
driver.findElement(By.xpath("//input[@name='Submit']")).click();
Assert.assertEquals(driver.findElement(By.xpath("//span[@id='checkin_span']")).getText(), "Check-In Date shall be before than Check-Out Date");

}
@DataProvider
public Object[][] getTestData(){
	 Object[][] data=new Object[1][1];
	 data[0][0]=UtilKit.getExcelData("TC-114");
	return data; //This will holds the data of the given testcase and will be returned to top method
	
}

}
