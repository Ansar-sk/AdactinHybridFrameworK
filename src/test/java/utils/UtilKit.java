package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.ss.formula.functions.Rows;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UtilKit {
static FileInputStream fis;

	public static HashMap<String, String> getExcelData(String testcase){
		try {
			fis =new FileInputStream("src\\test\\resources\\testdata\\excels\\MasterTestData.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFWorkbook wb=null;
		try {
			  wb=new XSSFWorkbook(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFSheet ws =wb.getSheet("regression");
		
		ArrayList<Row> testcaserows = getTestCaseRows(ws,testcase);
		HashMap<String, String> testdatamap= new HashMap<String,String>();
		
		for(int i =0;i<testcaserows.size();i++) 
		{
			int numofcells = testcaserows.get(i).getLastCellNum();
			
			for(int j=1;j<numofcells;j++) 
			{
				testdatamap.put(testcaserows.get(0).getCell(j).getStringCellValue(), 
						        testcaserows.get(1).getCell(j).getStringCellValue());
			}
		}
		
		return testdatamap;
		
	}
	//To get the all the required test case rows which are not empty
	private static ArrayList<Row> getTestCaseRows(XSSFSheet ws, String testcase) {
		ArrayList<Row> allrows =new ArrayList<Row>();
		for(int i=0;i<=ws.getLastRowNum();i++) {
			if(ws.getRow(i)!=null) {
				allrows.add(ws.getRow(i));
			}
		}
		//To add the row values to testcaserow array if testcase value match the first cell value
		ArrayList<Row> testcaserow =new ArrayList<Row>();
		for(int i=0;i<allrows.size();i++) {
			if(allrows.get(i).getCell(0).getStringCellValue().equalsIgnoreCase(testcase)) {
				testcaserow.add(allrows.get(i));
			}
		}
		
		return testcaserow;
	}
}
