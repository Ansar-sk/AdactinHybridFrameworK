package pages;

import java.time.Duration;

import javax.lang.model.element.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import base.BaseTest;

public class basepage extends BaseTest {

	public void type(WebElement element, String text) {
		element.sendKeys(text);
		test.log(Status.INFO, "User entered" + text + "into element" + element);
	}

	public void click(WebElement element) {
		element.click();
		test.log(Status.INFO, "user clicked on the element " + element);
	}

	public void selectdropdown(WebElement element, String text) {
		new Select(element).selectByVisibleText(text);
	}
 public String getattribute(WebElement element) {
	 
	 WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
	 wait.until(ExpectedConditions.visibilityOf(element));
	
	return element.getAttribute("value");
 }
	public void verifytitle(String exptitle) {
		Assert.assertEquals(gettitle(), exptitle);
		test.log(Status.PASS, "Both titles matched");
	}

	public void validatetext(WebElement element, String exptext) {

		String value = element.getText();
		Assert.assertEquals(value, exptext);
	}
	
	public void cleartext(WebElement element) {
		element.clear();
	}
public void validateattributes(WebElement element, String exptext) {
	Assert.assertEquals(element.getAttribute("value"), exptext);
}
	private String gettitle() {
		return driver.getTitle();
	}

}
