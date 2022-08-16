package helpers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelHelper {

	public static String pathToExcelfile = ".\\src\\test\\resources\\testData\\Data.xlsx";

	public static Workbook book;
	public static Sheet sheet;

	public static void main(String[] args) {
		Object[][] x = getExcelData("info");
		for (Object[] objects : x) {
			for (Object objects2 : objects) {
				System.out.print(objects2 + " ");
			}
			System.out.println();
		}
	}
	
	
	public static Object[][] getExcelData(String sheetName) {

		try {
			FileInputStream file = new FileInputStream(pathToExcelfile);
			book = WorkbookFactory.create(file);
			sheet = book.getSheet(sheetName);

			int rowSize = sheet.getLastRowNum(), colSize = sheet.getRow(0).getLastCellNum();

			Object data[][] = new Object[rowSize][colSize];
			for (int row = 0; row < rowSize; row++) {
				for (int col = 0; col < colSize; col++) {
					data[row][col] = sheet.getRow(row).getCell(col).getStringCellValue();
				}

			}
			return data;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;

	}

}
