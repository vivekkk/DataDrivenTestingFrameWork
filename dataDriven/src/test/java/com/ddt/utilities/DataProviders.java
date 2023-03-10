package com.ddt.utilities;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Hashtable;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.annotations.DataProvider;

import com.ddt.base.Base;
import com.ddt.rough.TestProperties;

public class DataProviders extends TestProperties {

	@DataProvider(name = "exceldp")
	public Object[][] addCustomer(Method m) throws Throwable // java lang reflect is the method;
	{
		System.out.println(m.getName());
		ExcelReading ex = new ExcelReading(configprop.getProperty("CustDataExcelPath"));
		XSSFSheet sheet1 = ex.getSheet(m.getName());
		ex.sheet = sheet1;
		String sheetname = sheet1.getSheetName();
		System.out.println("SheetName is : " + ex.sheet.getSheetName());
		// Base.test.log(null, sheet1.getSheetName());
		int rownum = ex.getTotalrowNumb(sheet1);
		int colnum = ex.getTotalcolNum(sheet1);
		Object[][] dataobj = new Object[rownum][1];
		Hashtable<String, String> table = null;
		for (int i = 0; i < rownum; i++) {
			table = new Hashtable<String, String>();
			for (int j = 0; j <= colnum - 1; j++) {
				table.put(ex.getData(sheetname, 0, j), ex.getData(sheetname, i+1, j));
				//System.out.println(i + " and " + j);
				dataobj[i][0] = table;

			}
			
		}
		/*
		 * int rownum=ex.getTotalrowNumb(sheet1); int colnum=ex.getTotalcolNum(sheet1);
		 * 
		 * Object[][] dataobj= new Object[rownum-1][colnum]; for 
		 * (int i = 1; i <= rownum - 1; i++)
		 *  { 
		 *  for (int j = 0; j <= colnum-1; j++) {
dataobj[i-1][j] = ex.getData(sheetname, i, j); System.out.println(dataobj[i-1][j]);
		 * 
		 * } }
		 */

		/*
		 * This is old code which was working on default first sheet of the excel
		 * ExcelReading ex=new
		 * ExcelReading(configprop.getProperty("CustDataExcelPath"));
		 * 
		 * int colnum=ex.getTotalcolNum(); int rownum=ex.getTotalrowNumb();
		 * System.out.println(rownum + " " + colnum);
		 * 
		 * Object[][] dataobj= new Object[rownum-1][colnum]; for (int i = 1; i <= rownum
		 * - 1; i++) { for (int j = 0; j <= colnum-1; j++) { dataobj[i-1][j] =
		 * ex.getData(0, i, j);
		 */
		// System.out.println(dataobj[i-1][j]);

		// }
		// }

		return dataobj;

	}
	/*
	 * @DataProvider(name="exceldpOpenAccount") public Object[][] openAccount()
	 * throws Throwable { ExcelReading ex=new
	 * ExcelReading(configprop.getProperty("CustDataExcelPath")); int
	 * colnum=ex.getTotalcolNum(); int rownum=ex.getTotalrowNumb();
	 * System.out.println(rownum + " " + colnum);
	 * 
	 * Object[][] dataobj= new Object[rownum-1][colnum]; for (int i = 1; i <= rownum
	 * - 1; i++) { for (int j = 0; j <= colnum-1; j++) { dataobj[i-1][j] =
	 * ex.getData(0, i, j); // System.out.println(dataobj[i-1][j]);
	 * 
	 * } }
	 * 
	 * 
	 * return dataobj;
	 * 
	 * }
	 */
}
