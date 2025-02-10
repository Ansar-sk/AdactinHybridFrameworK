package testscripts.regression;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import utils.UtilKit;

public class ValidateLoginWithExcelDataTc4 extends BaseTest {
	
@Test(dataProvider="getTestData")
public void validatetc2(HashMap<String, String> testdatamap)//parameter to get store data as hashmap since the data is being returned in key value pair from below
{
driver.findElement(By.xpath("//input[@name='username']")).sendKeys(testdatamap.get("username"));
driver.findElement(By.xpath("//input[@name='password']")).sendKeys(testdatamap.get("password"));
Assert.assertEquals(driver.getTitle(), testdatamap.get("Login page title"));

driver.findElement(By.xpath("//input[@name='login']")).click();
Assert.assertEquals(driver.getTitle(), testdatamap.get("Hotel search title"));

new Select(driver.findElement(By.xpath("//select[@name='location']"))).selectByVisibleText(testdatamap.get("location"));
new Select(driver.findElement(By.xpath("//select[@name='hotels']"))).selectByVisibleText(testdatamap.get("hotel"));
new Select(driver.findElement(By.xpath("//select[@name='room_type']"))).selectByVisibleText(testdatamap.get("Room Type"));
new Select(driver.findElement(By.xpath("//select[@name='room_nos']"))).selectByVisibleText(testdatamap.get("No of rooms"));
driver.findElement(By.xpath("//input[@name='datepick_in']")).clear();
driver.findElement(By.xpath("//input[@name='datepick_in']")).sendKeys(testdatamap.get("Check In Date"));
driver.findElement(By.xpath("//input[@name='datepick_out']")).clear();
driver.findElement(By.xpath("//input[@name='datepick_out']")).sendKeys(testdatamap.get("Check out Date"));
new Select(driver.findElement(By.xpath("//select[@name='adult_room']"))).selectByVisibleText(testdatamap.get("Adults per Room"));
new Select(driver.findElement(By.xpath("//select[@name='child_room']"))).selectByVisibleText(testdatamap.get("Children per Room  "));
driver.findElement(By.xpath("//input[@name='Submit']")).click();

Assert.assertEquals(driver.getTitle(), testdatamap.get("Select page title"));

driver.findElement(By.xpath("//input[@name='radiobutton_0']")).click();
driver.findElement(By.xpath("//input[@name='continue']")).click();
Assert.assertEquals(driver.getTitle(), testdatamap.get("Booking page title"));

driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys(testdatamap.get("First Name"));
driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys(testdatamap.get("LastName"));
driver.findElement(By.xpath("//textarea[@name='address']")).sendKeys(testdatamap.get("Address"));
driver.findElement(By.xpath("//input[@name='cc_num']")).sendKeys(testdatamap.get("Credit num"));

new Select(driver.findElement(By.xpath("//select[@name='cc_type']"))).selectByVisibleText(testdatamap.get("Card type"));
new Select(driver.findElement(By.xpath("//select[@name='cc_exp_month']"))).selectByVisibleText(testdatamap.get("Expiry month"));
new Select(driver.findElement(By.xpath("//select[@name='cc_exp_year']"))).selectByVisibleText(testdatamap.get("Expiry year"));
driver.findElement(By.xpath("//input[@name='cc_cvv']")).sendKeys(testdatamap.get("CVV number"));
driver.findElement(By.xpath("//input[@name='book_now']")).click();
WebDriverWait mywait =new WebDriverWait(driver,Duration.ofSeconds(10));
mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='my_itinerary']")));

String orderid = driver.findElement(By.xpath("//input[@name='order_no']")).getAttribute("value");
driver.findElement(By.xpath("//input[@name='my_itinerary']")).click();
driver.findElement(By.xpath("//input[@name='order_id_text']")).sendKeys(orderid);
driver.findElement(By.xpath("//input[@name='search_hotel_id']")).click();

Assert.assertEquals(driver.findElement(By.xpath("//input[@name='cancelall']")).getAttribute("value"), testdatamap.get("message"));

Assert.assertEquals(driver.findElement(By.xpath("//input[@value='Hotel Creek']")).getAttribute("value"), testdatamap.get("hotel"));
Assert.assertEquals(driver.findElement(By.xpath("//input[@value='Sydney']")).getAttribute("value"), testdatamap.get("location"));
Assert.assertEquals(driver.findElement(By.xpath("//input[@value='Test']")).getAttribute("value"), testdatamap.get("First Name"));
Assert.assertEquals(driver.findElement(By.xpath("//input[@value='Data']")).getAttribute("value"), testdatamap.get("LastName"));
Assert.assertEquals(driver.findElement(By.xpath("//input[@value='19/01/2025']")).getAttribute("value"), testdatamap.get("Check In Date"));
Assert.assertEquals(driver.findElement(By.xpath("//input[@value='20/01/2025']")).getAttribute("value"), testdatamap.get("Check out Date"));


}
@DataProvider
public Object[][] getTestData(){
	 Object[][] data=new Object[1][1];
	 data[0][0]=UtilKit.getExcelData("TC-116");
	return data; //This will holds the data of the given testcase and will be returned to top method
	
}

}
