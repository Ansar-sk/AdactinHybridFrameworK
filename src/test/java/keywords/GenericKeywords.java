package keywords;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openxmlformats.schemas.presentationml.x2006.main.CTTLShapeTargetElement;

import com.aventstack.extentreports.Status;

import base.BaseTest;

public class GenericKeywords extends BaseTest {
	public void startbrowser() {
		String browser = (configprop.getProperty("browser"));
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		if (browser.equalsIgnoreCase("edge")) {
			driver = new ChromeDriver();
		}
		if (browser.equalsIgnoreCase("firefox")) {
			driver = new ChromeDriver();
		}
	}

	public void launchapp() {
		driver.get(configprop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts()
				.implicitlyWait(Duration.ofSeconds(Long.parseLong(configprop.getProperty("implicitwait"))));
	
	}

	public void type(String locatorkey, String text) {
		// driver.findElement(By.xpath(locatorsprop.getProperty(locatorkey))).sendKeys(text);
		getElement(locatorkey).sendKeys(text);
		
	}
	//click method
	public void click(String locatorkey) {
		getElement(locatorkey).click();
	}
	
	//To select item from dropdown
	public void selectItemFromDropdown(String Locator, String text) {
		new Select(getElement(Locator)).selectByVisibleText(text);
	}
	
	//Get text method
	public String gettext(String Locator) {
		return getElement(Locator).getText();
	}
	//Method to gettitle
	public String getTitle() {
		return driver.getTitle();
		}
	
//This method is to get the webelement
	public WebElement getElement(String locatorkey) {
		WebElement element = null;
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
	//	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locatorkey)));
		wait.until(ExpectedConditions.presenceOfElementLocated(getlocator(locatorkey)));
		element=driver.findElement(getlocator(locatorkey));
		return element;
		

	}
// this is for the by method like by.class, by.xpath etc...
//The method getlocator() is declared with By as the return type, which means it will return a By object.
public By getlocator(String locatorkey) {
	
	 By by = null;
	if(locatorkey.endsWith("_id")) {
		by=By.id(locatorsprop.getProperty(locatorkey));
	}
	else if(locatorkey.endsWith("_name")) {
		by=By.name(locatorsprop.getProperty(locatorkey));
	}
	else if(locatorkey.endsWith("_className")) {
		by=By.className(locatorsprop.getProperty(locatorkey));
	}
	else if(locatorkey.endsWith("_xpath")) {
		by=By.xpath(locatorsprop.getProperty(locatorkey));
	}
	else {
		by=By.xpath(locatorsprop.getProperty(locatorkey));
	}
	return by;
}
//To get attributes
public String getattribute(String locator,String text) {
	String value =getElement(locator).getAttribute(text);
	return value;
	
}
	
}
