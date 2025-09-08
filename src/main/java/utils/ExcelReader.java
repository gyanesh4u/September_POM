package utils;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {

	public static final String TEST_DATA_SHEET_PATH = "";
	static Workbook book;
	static Sheet sheet;

	@SuppressWarnings("null")
	public static Object[][] getDataFromSheet(String sheetName) {
		Object data[][] = null;

		try {
			FileInputStream fis = new FileInputStream(TEST_DATA_SHEET_PATH);
			book = WorkbookFactory.create(fis);
			sheet = book.getSheet(sheetName);
			for (int i = 0; i < sheet.getLastRowNum(); i++) {
				for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
					data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

}
