package testscripts.regression;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import utils.UtilKit;

public class ValidateLoginWithExcelData extends BaseTest {
	
@Test(dataProvider="getTestData")
public void validate1(HashMap<String, String> testdatamap)//parameter to get store data as hashmap since the data is being returned in key value pair from below
{
driver.findElement(By.xpath("//input[@name='username']")).sendKeys(testdatamap.get("username"));
driver.findElement(By.xpath("//input[@name='password']")).sendKeys(testdatamap.get("password"));
driver.findElement(By.xpath("//input[@name='login']")).click();
Assert.assertEquals(driver.getTitle(), testdatamap.get("expected Title"));
}

@DataProvider
public Object[][] getTestData(){
	 Object[][] data=new Object[1][1];
	 data[0][0]=UtilKit.getExcelData("TC- 101");
	return data; //This will holds the data of the given testcase and will be returned to top method
	
}

}
