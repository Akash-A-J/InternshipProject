package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	static FileInputStream fis;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	public static String readExcel(int rowC,int colC) throws IOException {
		fis=new FileInputStream("C:\\SDET\\Internship\\Automation\\Project\\src\\test\\resources\\Login.xlsx");
		workbook=new XSSFWorkbook(fis);
		sheet=workbook.getSheetAt(0);
		return sheet.getRow(rowC).getCell(colC).getStringCellValue();
		
	}
	
}
