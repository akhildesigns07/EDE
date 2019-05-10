package util;

import java.io.File;

import base.TestBase;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;


public abstract class TestUtility extends TestBase {
	
	static String TestData = prop.getProperty("testdata_path");
	// static String TestData ="./TestData.xls";
	
	private static String DATA_FILE = TestData;
	private static  String DATA_SHEET ;

	public static String[][] getDataFromExcelFile(String tableName, String sheetName) {
		String[][] tabArray = null;
		DATA_SHEET=sheetName;
		
		try {
			System.out.println("Hello");

			Workbook workbook = Workbook.getWorkbook(new File(DATA_FILE));
			Sheet sheet = workbook.getSheet(DATA_SHEET);
			
			int startRow, startCol, endRow, endCol, ci, cj;
			Cell tableStart = null;
			if (sheet != null) {
				tableStart = sheet.findCell(tableName);
				if (tableStart != null) {
					startRow = tableStart.getRow();

					startCol = tableStart.getColumn();

					endCol = startCol + 1;
					endRow = startRow + 1;
					for (int i = startCol + 1;; i++) {
						String content = getData(sheet, i, startRow);
						if (content.isEmpty()) {
							endCol = i;
							for (int j = startRow + 1;; j++) {
								String contentAgain = getData(sheet, endCol - 1, j);
								if (contentAgain.isEmpty()) {
									endRow = j;
									break;
								}
							}
							break;
						}
					}
					tabArray = new String[endRow - startRow - 1][endCol - startCol - 1];
					ci = 0;
					for (int i = startRow + 1; i < endRow; i++, ci++) {
						cj = 0;
						for (int j = startCol + 1; j < endCol; j++, cj++) {
							tabArray[ci][cj] = getData(sheet, j, i);
						}
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Exception in getting file contents" + e.getMessage());
			e.printStackTrace();
		}
		return tabArray;
	}

	// Method to get the data from excel sheet
	public static String getData(Sheet sheet, int row, int col) {
		try {
			return sheet.getCell(row, col).getContents().trim();
		} catch (ArrayIndexOutOfBoundsException e) {
			return "";
		}
	}
}
