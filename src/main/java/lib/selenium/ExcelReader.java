package lib.selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellAddress;

import com.google.common.io.Files;

public class ExcelReader {

	private HSSFWorkbook workbook = null;
	static String xlsname;
	
	public ExcelReader(String xlsName) {
		try {
			FileInputStream file = new FileInputStream(new File(xlsName));
			xlsname = xlsName;
			workbook = new HSSFWorkbook(file);
			} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public HSSFSheet getSheet(String sheetName) {
		return workbook.getSheet(sheetName);
	}

	@SuppressWarnings("unused")
	public int getSheetRows(String sheetName) {
		Iterator<Row> rowIter = workbook.getSheet(sheetName).iterator();
		int rows = 0;
		while (rowIter.hasNext()) {
			HSSFRow row = (HSSFRow) rowIter.next();
			rows++;
		}
		return rows;
	}

	public Map<Integer, String> getRowAsMap(String sheetName, int rowIndex) {
		Iterator<Row> rowIter = workbook.getSheet(sheetName).iterator();
		Map<Integer, String> rowMap = new HashMap<Integer, String>();

		while (rowIter.hasNext()) {
			Row row = rowIter.next();
			if (rowIndex == (row.getRowNum() + 1)) {
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					String value;

					/*switch (cell.getCellType()) {
					case Cell
						value = String.valueOf(cell.getBooleanCellValue());
						if (value != null && !value.isEmpty())
							rowMap.put(cell.getColumnIndex() + 1, value);
						break;
					case Cell.CELL_TYPE_NUMERIC:
						value = String.valueOf(cell.getNumericCellValue());
						if (value != null && !value.isEmpty())
							rowMap.put(cell.getColumnIndex() + 1, value);
						break;
					case Cell.CELL_TYPE_STRING:
						value = cell.getStringCellValue();
						if (value != null && !value.isEmpty())
							rowMap.put(cell.getColumnIndex() + 1, value);
						break;
					}*/
				}
			}
		}
		return rowMap;
	}

	public Map<Integer, Map<Integer, String>> getRowsAsMap(String sheetName) {
		Iterator<Row> rowIter = workbook.getSheet(sheetName).iterator();
		Map<Integer, Map<Integer, String>> rowMap = new HashMap<Integer, Map<Integer, String>>();

		while (rowIter.hasNext()) {
			Row row = rowIter.next();
			Iterator<Cell> cellIterator = row.cellIterator();
			Map<Integer, String> columnMap = new HashMap<Integer, String>();
			;
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				String value;

				/*switch (cell.getCellType()) {
				case Cell.CELL_TYPE_BOOLEAN:
					value = String.valueOf(cell.getBooleanCellValue());
					if (value != null && !value.isEmpty())
						columnMap.put(cell.getColumnIndex() + 1, value);
					break;
				case Cell.CELL_TYPE_NUMERIC:
					value = String.valueOf(cell.getNumericCellValue());
					if (value != null && !value.isEmpty())
						columnMap.put(cell.getColumnIndex() + 1, value);
					break;
				case Cell.CELL_TYPE_STRING:
					value = cell.getStringCellValue();
					if (value != null && !value.isEmpty())
						columnMap.put(cell.getColumnIndex() + 1, value);
					break;
				}*/
			}
			rowMap.put(row.getRowNum() + 1, columnMap);
		}
		return rowMap;
	}

	public Map<String, String> getRowsAsMapwithHeader(String sheetName) {
		Map<Integer, String> dataRowMap = getRowAsMap(sheetName, 1);

		int rowIndex = 2;

		Iterator<Row> rowIter = workbook.getSheet(sheetName).iterator();
		Map<String, String> rowMap = new HashMap<String, String>();

		FormulaEvaluator evaluator = workbook.getCreationHelper()
				.createFormulaEvaluator();

		while (rowIter.hasNext()) {
			Row row = rowIter.next();
			if (rowIndex == (row.getRowNum() + 1)) {
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					String value;

					/*switch (evaluator.evaluateInCell(cell).getCellType()) {

					case Cell.CELL_TYPE_BOOLEAN:
						value = String.valueOf(cell.getBooleanCellValue());
						if (value != null && !value.isEmpty())
							rowMap.put(
									dataRowMap.get(cell.getColumnIndex() + 1),
									value);
						break;
					case Cell.CELL_TYPE_NUMERIC:
						value = String.valueOf(Math.round(cell
								.getNumericCellValue()));
						if (value != null && !value.isEmpty())
							rowMap.put(
									dataRowMap.get(cell.getColumnIndex() + 1),
									value);
						break;
					case Cell.CELL_TYPE_STRING:
						value = cell.getStringCellValue();
						if (value != null && !value.isEmpty())
							rowMap.put(
									dataRowMap.get(cell.getColumnIndex() + 1),
									value);
						break;
					}
*/				}
			}
		}
		return rowMap;
	}

	@SuppressWarnings({ "unused" })
	public ArrayList<Map<String, String>> getAllRowsAsMap(String sheetName) {
		Map<Integer, String> dataRowMap = getRowAsMap(sheetName, 1);
		int rowIndex = 2;
		Iterator<Row> rowIter = workbook.getSheet(sheetName).iterator();
		FormulaEvaluator evaluator = workbook.getCreationHelper()
				.createFormulaEvaluator();
		ArrayList<Map<String, String>> lstRowMap = new ArrayList<Map<String, String>>();
		
		while (rowIter.hasNext()) {
			Row row = rowIter.next();
			Map<String, String> rowMap = new HashMap<String, String>();
			Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					String value = null;
					
					/*switch (evaluator.evaluateInCell(cell).getCellType()) {
				
					case Cell.CELL_TYPE_BOOLEAN:
						value = String.valueOf(cell.getBooleanCellValue());break;
					case Cell.CELL_TYPE_NUMERIC:
						if (DateUtil.isCellDateFormatted(cell)) {
							SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
							value = dateFormat.format(cell.getDateCellValue());				            
				        } else {
				        	value = String.valueOf(Math.round(cell.getNumericCellValue()));
				        }
						break;
					case Cell.CELL_TYPE_STRING:
						value = cell.getStringCellValue();break;
					}*/
					if (value != null && !value.isEmpty())
						rowMap.put(dataRowMap.get(cell.getColumnIndex() + 1), value);
					}
				lstRowMap.add(rowMap);
				}
		return lstRowMap;
	}
	
	public CellAddress getcolnum(String sheetName, String string) throws IOException{
		 
		Iterator<Row> iterator = workbook.getSheet(sheetName).iterator();
        CellAddress columnNumber=null;
        
        Row nextRow = iterator.next();
        Iterator<Cell> cellIterator = nextRow.cellIterator();
        while (cellIterator.hasNext()) {
        	Cell cell = cellIterator.next();
        	if(cell.getCellType()==CellType.STRING){
        		String text = cell.getStringCellValue();
        		if (string.equals(text)) {
        			columnNumber=cell.getAddress();
        			break;
        		}
        	}
        }
        workbook.close();
        return columnNumber;
        
	}

	public void backupcurrentsheet(Boolean multiplecopy) {
		// TODO To get a copy of current sheet
		//System.err.println("Entered into BackupMethod :: "+xlsname);
		File src = new File(xlsname);
		//System.err.println("src :: "+src);
		String filename = src.getName();
		//System.err.println("FileName :: "+filename);
		String sheetextension = filename.substring(filename.lastIndexOf("."));
		//System.err.println("sheetextension :: "+sheetextension);
		String sheetname = filename.substring(0, filename.lastIndexOf(sheetextension));
		//System.err.println("sheetname :: "+sheetname);
		File des = new File(System.getProperty("user.dir") + "\\Outputs\\" + filename);
	
		if (multiplecopy) {
			if (des.exists()) {
				SimpleDateFormat sdf1 = new SimpleDateFormat("ddMMMyyyy_HHmm");
				String time = sdf1.format(new Date());
				try {
					Files.copy(src, new File(System.getProperty("user.dir") + "\\Outputs\\" + sheetname + time + sheetextension));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return;
			}
		} 
			try {
				Files.copy(src, des);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
}
