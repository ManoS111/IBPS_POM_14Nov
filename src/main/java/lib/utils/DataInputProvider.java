package lib.utils;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataInputProvider{
	//public static String location ="local";
	//public static String location ="linux"; 
	public static String location ="Eclipse";
	//public static Object[][] getSheet(String dataSheetName, String sheetName) {
	public static Object[][] getSheet(String dataSheetName, String sheetName) {
		Object[][] data = null ;
       // Workbook workbook = null;
		try {
			String userDir = System.getProperty("user.dir");
			/*FileInputStream fis = new FileInputStream(userDir+"\\data\\"+dataSheetName+".xlsx");
			//FileInputStream fis = new FileInputStream("D://Gayatri//workspace//IBPS//data//RBI_1.xlsx");
			//XSSFWorkbook workbook = new XSSFWorkbook(fis);
			String fileName = userDir+"\\data\\"+dataSheetName+".xlsx";
			// System.err.println("File path is : "+fileName);
			FileInputStream fileInputStream = new FileInputStream(fileName);
			String fileExtensionName = fileName.substring(fileName.indexOf("."));
			if (fileExtensionName.equals(".xlsx")) {
				workbook = new XSSFWorkbook(fileInputStream);
				XSSFFormulaEvaluator.evaluateAllFormulaCells(workbook);
			} else if (fileExtensionName.equals(".xls")) {
				workbook = new HSSFWorkbook(fileInputStream);
				HSSFFormulaEvaluator.evaluateAllFormulaCells(workbook);
			}
			System.out.println("WorkBook name: "+workbook);*/
			System.out.println("DateSheet name "+dataSheetName);
			System.out.println("sheetName "+sheetName);
			XSSFWorkbook workbook;
			Sheet sheet;
			if(location.equalsIgnoreCase("local")) {
				 workbook = new XSSFWorkbook(".\\classes\\data\\"+dataSheetName+".xlsx");
				 sheet = workbook.getSheet(sheetName);
			}else if(location.equalsIgnoreCase("linux")) {
				 workbook = new XSSFWorkbook(userDir+"/classes/data/"+dataSheetName+".xlsx");
				 sheet = workbook.getSheet(sheetName);
			}else {
			
			 workbook = new XSSFWorkbook(userDir+"\\data\\"+dataSheetName+".xlsx");
			 sheet = workbook.getSheet(sheetName);
			//XSSFSheet sheet = workbook.getSheetAt(0);	
			}
			// get the number of rows
			int rowCount = sheet.getLastRowNum();
				

			// get the number of columns
			int columnCount = sheet.getRow(0).getLastCellNum();
			System.out.println("Row count : "+rowCount+" Column count : "+columnCount); 
			data = new String[rowCount][columnCount];

			// loop through the rows
			for(int i=1; i <rowCount+1; i++){
				try {
					Row row = sheet.getRow(i);
					for(int j=0; j <columnCount; j++){ // loop through the columns
						try {
							String cellValue = "";
							long numValue ;
							try{
								CellType cellType = row.getCell(j).getCellType();
								if(cellType == CellType.STRING) {
								cellValue = row.getCell(j).getStringCellValue();
								data[i-1][j]  = cellValue; // add to the data array
								System.out.println(cellValue);
								} else if(cellType == CellType.NUMERIC) {
								numValue = (long) row.getCell(j).getNumericCellValue();
								data[i-1][j]  = numValue; // add to the data array
								//System.out.println(numValue); 
								}else if(cellType == CellType.FORMULA) {
									cellValue =  row.getCell(j).getCellFormula(); 
									data[i-1][j]  = cellValue; // add to the data array
									//System.out.println(cellValue);  
									}
							}catch(NullPointerException e){

							}

						} catch (Exception e) {
 							e.printStackTrace();
						}				
					}

				} catch (Exception e) {
 					e.printStackTrace();
				}
			}
			//fis.close();
			workbook.close();
		} catch (Exception e) {
 			e.printStackTrace();
		}
		
		return data;		

	}
}
