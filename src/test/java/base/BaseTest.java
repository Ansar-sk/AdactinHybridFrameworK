package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.opentelemetry.context.Context;
import utils.ExtentManager;

public class BaseTest {

	public static WebDriver driver;
	public static FileInputStream fis;
	public static Properties configprop;
	public static FileInputStream fis2;
	public static Properties locatorsprop;
	public static ExtentReports reports;
	public static ExtentTest test;
	

	@BeforeTest
	public void filereadset()
	{
		try {
			fis = new FileInputStream("src/test/resources/properties/config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		configprop = new Properties();
		try {
			configprop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			try {
				fis2 = new FileInputStream("src\\test\\resources\\properties\\locators.properties");
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			locatorsprop = new Properties();
			try {
				locatorsprop.load(fis2);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			reports = ExtentManager.getreports();
	}
	
	
	
	@BeforeMethod
	public void setup(Method method) {
		
		test = reports.createTest(method.getName());
		String browser = (configprop.getProperty("browser"));
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			test.log(Status.INFO, browser+"Browser is started...");
		}
		else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		driver.get(configprop.getProperty("url"));
	}

	@AfterMethod
	public void teardown() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}
	@AfterTest
	public void flushreports() {
		reports.flush();
	}
}
