package Factories;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Dataprovider {

public static String ReadExcel(String sheetname, int row, int col)
{
	XSSFSheet sh = null;  
	try {
			sh=new XSSFWorkbook(new FileInputStream(new File(BaseClass.syspath+"\\testData\\orangehrm.xlsx"))).getSheet(sheetname);
		
		
			System.out.println(sh.getRow(row).getCell(col));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	return sh.getRow(row).getCell(col).getStringCellValue();

}
public static String ReadProperties(String Key)
{
	  Properties  pr= new Properties();
	  try {
		
		pr.load( new FileInputStream(new File(BaseClass.syspath+"\\testdata\\config.properties")));
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
return (String) pr.get(Key);
}
}
