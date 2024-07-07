/*package Configration_Files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

//from here 
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

//till here 

public class XLUtilities {

	public static FileInputStream fi;
	public static FileOutputStream fos;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle cs;

	public static int getRowCount(String xlfile, String xlsheet) throws Exception {
		int rowcount;

		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);

		rowcount = ws.getLastRowNum();

		wb.close();
		fi.close();

		return rowcount;
	}

	public static int getCellCount(String xlfile, String xlsheet, int rownum) throws Exception {

		int cellCount;

		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);

		row = ws.getRow(rownum);

		cellCount = row.getLastCellNum();

		wb.close();
		fi.close();

		return cellCount;

	}

	public static String getCellData(String xlfile, String xlsheet, int rownum, int cellNumber) throws Exception {

		String data;

		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		cell = row.getCell(cellNumber);

		try {
			data = cell.getStringCellValue();
			return data;
		}

		catch (Exception e) {
			data = "";
			return data;

		}
	}

	public static void SetCellData(String xlfile, String xlsheet, int rownum, int column, String data) throws IOException {

		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		cell = row.createCell(column);
		cell.setCellValue(data);
		fos = new FileOutputStream(xlfile);

		wb.write(fos);
		wb.close();
		fi.close();
		fos.close();

	}

	public void fillGreenColor(String xlfile, String sheetName, int rownum, int colnum) throws IOException {
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheetName);

		row = ws.getRow(rownum);
		cell = row.getCell(colnum);

		cs = wb.createCellStyle();

		cs.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		cs.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		cell.setCellStyle(cs);
		wb.write(fos);
		wb.close();
		fi.close();
		fos.close();
	}

	public void fillRedColor(String xlfile, String sheetName, int rownum, int colnum) throws IOException {
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(sheetName);
		row = ws.getRow(rownum);
		cell = row.getCell(colnum);

		cs = wb.createCellStyle();

		cs.setFillForegroundColor(IndexedColors.RED.getIndex());
		cs.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		cell.setCellStyle(cs);
		wb.write(fos);
		wb.close();
		fi.close();
		fos.close();
	}
	
	
	public static void writereport(int a, int b, String text) {
	    try {
	    	File file = new File("Data");
	        File excelFile = new File(file.getAbsolutePath()+"/CollectData/collectdataDemo.xlsx");
	        System.out.println(excelFile);
	        WritableWorkbook book;
	        WritableSheet sheet;
	        Workbook existingBook = null;
	        if (!excelFile.exists()) {
	            book = Workbook.createWorkbook(excelFile);
	            sheet = book.createSheet("Records", 0);
	        } else {
	            existingBook = Workbook.getWorkbook(excelFile);
	            book = Workbook.createWorkbook(excelFile, existingBook);
	            sheet = book.getSheet("Records");
	        }
	        Label i = new Label(a, b, text);
	        sheet.addCell(i);
	        book.write();
	        book.close();
	        if (existingBook != null)
	            existingBook.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	        
	    }
	}
	
	

    public static void writereportxlsxx(int a, int b, String text) {
        try {
            File excelFile = new File("/Users/ishaanvashist/Downloads/Get_Tags/Datafiles/collectdataDemo.xlsx");
            System.out.println(excelFile);

            XSSFWorkbook existingBook = null;
            XSSFSheet sheet;

            if (!excelFile.exists()) {
                // Create a new workbook and sheet
                XSSFWorkbook book = new XSSFWorkbook();
                sheet = book.createSheet("Records");
            } else {
                // Read existing workbook and sheet
                existingBook = new XSSFWorkbook(new FileInputStream(excelFile));
                sheet = existingBook.getSheet("Records");
            }

            // Create a new row and cell, then set the cell value
            Row row = sheet.createRow(b);
            Cell cell = row.createCell(a);
            cell.setCellValue(text);

            // Save the changes to the Excel file
            try (FileOutputStream fos = new FileOutputStream(excelFile)) {
                if (existingBook != null) {
                    existingBook.close();
                }
                sheet.getWorkbook().write(fos);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
    public static void writereportxlsx(int a, int b, String text) {
        try {
            File excelFile = new File("/Users/ishaanvashist/Downloads/Get_Tags/Datafiles/collectdataDemo.xlsx");
            System.out.println(excelFile);

            XSSFWorkbook existingBook = null;
            XSSFSheet sheet = null;  // Initialize sheet to null

            if (!excelFile.exists()) {
                // Create a new workbook and sheet
                XSSFWorkbook book = new XSSFWorkbook();
                sheet = book.createSheet("Sheet1");
            } else {
                // Read existing workbook and sheet
                existingBook = new XSSFWorkbook(new FileInputStream(excelFile));
                sheet = existingBook.getSheet("Sheet1");
                if (sheet == null) {
                    // If sheet is null, create a new one
                    sheet = existingBook.createSheet("Sheet1");
                }
            }

            // Create a new row and cell, then set the cell value
            Row row = sheet.createRow(b);
            Cell cell = row.createCell(a);
            cell.setCellValue(text);

            // Save the changes to the Excel file
            try (FileOutputStream fos = new FileOutputStream(excelFile)) {
                if (existingBook != null) {
                    existingBook.write(fos);
                    existingBook.close();
                } else {
                    // If existingBook is null, write the new workbook
                    sheet.getWorkbook().write(fos);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	
    public static void writereportxlsxMain(int a, int b, String text) {
        try {
            File excelFile = new File("/Users/ishaanvashist/Downloads/Get_Tags/Datafiles/collectdataDemo.xlsx");
            System.out.println(excelFile);

            XSSFWorkbook existingBook = null;
            XSSFSheet sheet = null;  // Initialize sheet to null

            if (!excelFile.exists()) {
                // Create a new workbook and sheet
                XSSFWorkbook book = new XSSFWorkbook();
                sheet = book.createSheet("Sheet1");
            } else {
                // Read existing workbook
                existingBook = new XSSFWorkbook(new FileInputStream(excelFile));
                // Try to get the sheet
                sheet = existingBook.getSheet("Sheet1");
                if (sheet == null) {
                    // If sheet is null, create a new one
                    sheet = existingBook.createSheet("Sheet1");
                }
            }

            // Create a new row and cell, then set the cell value
            Row row = sheet.createRow(b);
            Cell cell = row.createCell(a);
            cell.setCellValue(text);

            // Save the changes to the Excel file
            try (FileOutputStream fos = new FileOutputStream(excelFile)) {
                if (existingBook != null) {
                    existingBook.write(fos);
                } else {
                    // If existingBook is null, write the new workbook
                    sheet.getWorkbook().write(fos);
                }
            }

            // Close the existing workbook if it was opened
            if (existingBook != null) {
                existingBook.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public static void readexcelMain() throws IOException, InterruptedException {
        // Specify the path to the Excel file
        File file = new File("/Users/ishaanvashist/Downloads/Get_Tags/Datafiles/collectdataDemo.xlsx");

        // Create a FileInputStream to read the Excel file
        FileInputStream fis = new FileInputStream(file);

        // Create a Workbook object
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        // Get the first sheet from the workbook
        XSSFSheet sheet = workbook.getSheetAt(0);

        // Iterate through rows
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            // Get cell data from the row
            XSSFRow row = sheet.getRow(i);
            String username = row.getCell(0).getStringCellValue();
            String password = row.getCell(1).getStringCellValue();

           
            Thread.sleep(5000);
        }

        // Close the workbook and FileInputStream
        workbook.close();
        fis.close();
    }
    
    
    
    
    public static void writereportxlsxworkbookpresent(int a, int b, String text) {
        try {
            File excelFile = new File("/Users/ishaanvashist/Downloads/Get_Tags/Datafiles/Modi.xlsx");
            System.out.println(excelFile);

            XSSFWorkbook existingBook = null;
            XSSFSheet sheet = null;  // Initialize sheet to null

            if (!excelFile.exists()) {
                // Create a new workbook and sheet
                XSSFWorkbook book = new XSSFWorkbook();
                sheet = book.createSheet("Sheet1");
            } else {
                // Read existing workbook
                existingBook = new XSSFWorkbook(new FileInputStream(excelFile));
                // Try to get the sheet
                sheet = existingBook.getSheet("Sheet1");
                if (sheet == null) {
                    // If sheet is null, create a new one
                    sheet = existingBook.createSheet("Sheet1");
                }
            }

            // Check if the row exists
            Row row = sheet.getRow(b);
            if (row == null) {
                // If the row doesn't exist, create a new one
                row = sheet.createRow(b);
            }

            // Check if the cell exists
            Cell cell = row.getCell(a);
            if (cell == null) {
                // If the cell doesn't exist, create a new one
                cell = row.createCell(a);
            }

            // Set the cell value
            cell.setCellValue(text);

            // Save the changes to the Excel file
            try (FileOutputStream fos = new FileOutputStream(excelFile)) {
                if (existingBook != null) {
                    existingBook.write(fos);
                } else {
                    // If existingBook is null, write the new workbook
                    sheet.getWorkbook().write(fos);
                }
            }

            // Close the existing workbook if it was opened
            if (existingBook != null) {
                existingBook.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    


}
*/