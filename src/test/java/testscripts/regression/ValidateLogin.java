package testscripts.regression;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;

public class ValidateLogin extends BaseTest {
	
@Test(dataProvider="getTestData")
public void validate1(String username, String password, String exptitle) {
driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
driver.findElement(By.xpath("//input[@name='login']")).click();
Assert.assertEquals(driver.getTitle(), exptitle);
}

@DataProvider
public Object[][] getTestData(){
	 Object[][] data=new Object[4][3];
	 data[0][0]="reyaz0806";
	 data[0][1]="reyaz123";
	 data[0][2]="Adactin.com - Search Hotel";
	 
	 data[1][0]="reyaz0808";
	 data[1][1]="reyaz123";
	 data[1][2]="Adactin.com - Hotel Reservation System";
	 
	 data[2][0]="reyaz0806";
	 data[2][1]="reyaz084";
	 data[2][2]="Adactin.com - Hotel Reservation System";
	 
	 data[3][0]="reyaz0891";
	 data[3][1]="reyaz1212";
	 data[3][2]="Adactin.com - Hotel Reservation System";
	return data;
	
}

}
