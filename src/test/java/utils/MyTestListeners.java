package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import base.BaseTest;

public class MyTestListeners extends BaseTest implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testname =result.getMethod().getMethodName();
		TimeZone timeZone = TimeZone.getTimeZone("Asia/Kolkata");
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat simpledateformat = new SimpleDateFormat(pattern);
		String date = simpledateformat.format(new Date());
		date=date.replace(":", "-");
		System.out.println(date);
		File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\screenshots\\"+testname+date+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(Status.PASS, testname+"is passed");
	}
	@Override
	public void onTestFailure(ITestResult result) {
		String testname =result.getMethod().getMethodName();
		TimeZone timeZone = TimeZone.getTimeZone("Asia/Kolkata");
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat simpledateformat = new SimpleDateFormat(pattern);
		String date = simpledateformat.format(new Date());
		date=date.replace(":", "-");
		System.out.println(date);
		File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\screenshots\\"+testname+date+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Test started");
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}

}
