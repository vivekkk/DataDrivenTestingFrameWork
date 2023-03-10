package com.ddt.base;

import java.util.Hashtable;
import java.util.Iterator;

import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import com.ddt.rough.TestProperties;


import com.ddt.utilities.ExcelReading;

public class TotestLogic {

	
	public void testLogic() throws Throwable
	{
		
		ExcelReading ex = new ExcelReading("D:\\dataDrivenTestingProject\\dataDriven\\src\\test\\resources\\customerdata.xlsx");
		XSSFSheet sheet1 = ex.getSheet("openAccount");
		ex.sheet = sheet1;
		String sheetname = sheet1.getSheetName();
		System.out.println("SheetName is : " + ex.sheet.getSheetName());
		// Base.test.log(null, sheet1.getSheetName());
		int rownum = ex.getTotalrowNumb(sheet1);
		int rownum2 = sheet1.getLastRowNum();
		int colnum = ex.getTotalcolNum(sheet1);
		int colnum2 = sheet1.getRow(0).getLastCellNum();
		System.out.println("rownum: "+rownum+"rownum2: "+ rownum2 );
		System.out.println("colnum: "+colnum+"colnum2: "+ colnum2 );
		Object[][] dataobj = new Object[rownum+1][1];
		Hashtable<String, String> table = null;
		for (int i = 0; i < rownum; i++) {
			table = new Hashtable<String, String>();
			for (int j = 0; j <= colnum - 1; j++) {
				String value=ex.getData(sheetname, 0, j);
				String value2=ex.getData(sheetname, i+1, j);
				System.out.println("column: "+value);
				
				System.out.println("Values: "+value2);
				
	
				table.put(value, value2);
				//System.out.println(i + " and " + j);
				dataobj[i][0] = table;

			}
			
		}
		

	}

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		TotestLogic t = new TotestLogic();
              t.testLogic();		
	}



}
