package lib.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteData {

	public static void writeData(String sheetName, int column, int rows, String text) {
		Workbook wb1 = null; Sheet sheet; Cell cell; Row row;
		String fileName = "./data/IBPSData.xlsx";
		FileInputStream fileInputStream;
		try {
			fileInputStream = new FileInputStream(fileName);
		String fileExtensionName = fileName.substring(fileName.lastIndexOf("."));
		if (fileExtensionName.equals(".xlsx")) {
			wb1 = new XSSFWorkbook(fileInputStream);
			XSSFFormulaEvaluator.evaluateAllFormulaCells(wb1);
		}
		else if (fileExtensionName.equals(".xls")) {
			wb1 = new HSSFWorkbook(fileInputStream);
			HSSFFormulaEvaluator.evaluateAllFormulaCells(wb1);
		}
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		sheet = wb1.getSheet(sheetName);
		row = sheet.getRow(rows);
		if (row == null) {
			row = sheet.createRow(rows);
		}

		cell = row.getCell(column);
		if (cell == null)
			cell = row.createCell(column);
		cell.setCellValue(text);

		FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream("./data/IBPSData.xlsx");
			wb1.write(fileOut);
			fileOut.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		

	}
	
}







