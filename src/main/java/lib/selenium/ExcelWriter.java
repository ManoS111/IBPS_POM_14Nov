package lib.selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ExcelWriter {
	
	private HSSFWorkbook workbook = null;
	
	public ExcelWriter(String xlsName) {
		FileInputStream fInStream = null;
		try {
			fInStream = new FileInputStream(new File(xlsName));
			workbook = new HSSFWorkbook(fInStream);
			System.out.println("File name: "+fInStream);  
			} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				HSSFFormulaEvaluator.evaluateAllFormulaCells(workbook);
				fInStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void refresh() {
		HSSFFormulaEvaluator.evaluateAllFormulaCells(workbook);
	}

	@SuppressWarnings("unused")
	public int getRows(String sheetName) {
		Iterator<Row> rowIter = workbook.getSheet(sheetName).iterator();
		int rows = 0;
		while (rowIter.hasNext()) {
			HSSFRow row = (HSSFRow) rowIter.next();
			rows++;
		}
		return rows;
	}

	public void writeExcel(Map<Integer, String> resultMap, String writeXlsName, String worksheetName) {
		HSSFSheet worksheet = workbook.getSheet(worksheetName);
		Iterator<Map.Entry<Integer, String>> iterResult = resultMap.entrySet()
				.iterator();
		
		while (iterResult.hasNext()) {
			Map.Entry<Integer, String> mapEntry = (Map.Entry<Integer, String>) iterResult
					.next();
			Cell cell = worksheet.getRow(mapEntry.getKey() - 1).getCell(3, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
			cell.setCellValue(mapEntry.getValue());
						
		}

		try {
			FileOutputStream foutStream = new FileOutputStream(new File(
					writeXlsName));
			workbook.write(foutStream);
			foutStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void writeExcelAtColumnWithResult1(int rowNo, int ColNo,
			String sResult, String writeXlsName, String sSheetName) throws Exception {
		HSSFSheet worksheet = workbook.getSheet(sSheetName);
		Cell cell = worksheet.getRow(rowNo).getCell(ColNo,
				Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
		cell.setCellValue(sResult);

		try {
			FileOutputStream foutStream = new FileOutputStream(new File(
					writeXlsName));
			workbook.write(foutStream);
			workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
			workbook.setForceFormulaRecalculation(true);
			foutStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			//Controller.testlog.log(LogStatus.ERROR, "Save & close the respective excel sheet", e);
			} catch (IOException e) {
			e.printStackTrace();
			//Controller.testlog.log(LogStatus.ERROR, "Save & close the respective excel sheet", e);
			}
	}



	public void writeExcelAtColumnWithResult(int rowNo, int ColNo,
			String sResult, String writeXlsName, String sSheetName) {
		HSSFSheet worksheet = workbook.getSheet(sSheetName);
		Cell cell = worksheet.getRow(rowNo).getCell(ColNo,
				Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
		cell.setCellValue(sResult);

		try {
			FileOutputStream foutStream = new FileOutputStream(new File(System.getProperty("user.dir") + 
					writeXlsName));
			workbook.write(foutStream);
			//HSSFFormulaEvaluator.evaluateAllFormulaCells(workbook);
			workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
			workbook.setForceFormulaRecalculation(true);
			foutStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
