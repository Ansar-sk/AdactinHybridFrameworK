package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import base.BaseTest;

public class basepage extends BaseTest{

	public void type(WebElement element, String text) {
		element.sendKeys(text);
		test.log(Status.INFO, "User entered"+ text +"into element"+element);
	}
	
	public void click(WebElement element) {
		element.click();
		test.log(Status.INFO, "user clicked on the element "+ element);
	}
	
	public void selectdropdown(WebElement element, String text) {
		new Select(element).selectByVisibleText(text);
	}
	public void verifytitle( String exptitle) {
		Assert.assertEquals(gettitle(), exptitle);	
		test.log(Status.PASS,"Both titles matched");
	}

	private String gettitle() {	
		return driver.getTitle();
	}
}
