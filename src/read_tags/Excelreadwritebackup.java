/*package read_tags;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import Configration_Files.ReadXclData;
import Configration_Files.XLUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelreadwritebackup{
	
	 XLUtilities xx= new XLUtilities();

    @Test
    public void loginTest() throws IOException, InterruptedException {
        // Specify the path to the Excel file
        File file = new File("/Users/ishaanvashist/Downloads/Get_Tags/Datafiles/collectdataDemo.xlsx");

        // Create a FileInputStream to read the Excel file
        FileInputStream fis = new FileInputStream(file);

        // Create a Workbook object
        Workbook workbook = WorkbookFactory.create(fis);

        // Get the first sheet from the workbook
        Sheet sheet = workbook.getSheetAt(0);

        // Iterate through rows
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            // Get cell data from the row
            Row row = sheet.getRow(i);
            String username = row.getCell(0).getStringCellValue();
            String password = row.getCell(1).getStringCellValue();

            // Execute your Selenium WebDriver test with the data
            performLogin(username, password);
            Thread.sleep(5000);
            
            
            
            
            XLUtilities.writereportxlsxMain(5, 5, "Just testing");
            

        }

        // Close the workbook and FileInputStream
      

      workbook.close();
       fis.close();
        

        //xx.writereportt(3, 3, "Testing");
        
        
        
        
    }

    private void performLogin(String username, String password) {
        // Initialize WebDriver (assuming ChromeDriver for this example)
        System.setProperty("webdriver.chrome.driver", "/Users/ishaanvashist/Downloads/Get_Tags/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();

        // Open the login page
        driver.get("https://github.com/login");
        driver.manage().window().maximize();


        WebElement usernameInput = driver.findElement(By.id("login_field"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.xpath("//input[@name='commit']"));

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();

        // Perform assertions or additional steps as needed

        // Close the browser
        driver.quit();
    }
    
    
    
    public static void writereportxlsx(int a, int b, String text) {
        try {
            //File file = new File("Datafiles");
            File excelFile = new File("/Users/ishaanvashist/Downloads/Get_Tags/Datafiles/collectdataDemo.xlsx");
            System.out.println(excelFile);

            Workbook existingBook = null;
            Sheet sheet;

            if (!excelFile.exists()) {
                // Create a new workbook and sheet
                Workbook book = new XSSFWorkbook();
                sheet = book.createSheet("Records");
            } else {
                // Read existing workbook and sheet
                existingBook = WorkbookFactory.create(new FileInputStream(excelFile));
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
    
    
    
    
    
    
    
    
    

}*/
