package utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import base.BaseTest;

public class ExtentManager extends BaseTest{

	

	public static ExtentReports getreports() {
		String reportsfolderpath =System.getProperty("user.dir")+"\\reports";
		if(reports==null) {
			reports=new ExtentReports();
			TimeZone timeZone = TimeZone.getTimeZone("Asia/Kolkata");
			String pattern = "yyyy-MM-dd HH:mm:ss";
			SimpleDateFormat simpledateformat = new SimpleDateFormat(pattern);
			String date = simpledateformat.format(new Date());
			
			date=date.replace(":", "-");
			System.out.println(date);
			File reportsfile =new File(reportsfolderpath+"\\"+date+".html");
			ExtentSparkReporter reporter =new ExtentSparkReporter(reportsfile);
			
			reporter.config().setDocumentTitle("Adactin QA regression results");
			reporter.config().setReportName("Regression report");
			reports.attachReporter(reporter);
		
	}
		return reports;
	}
}
