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

public class XXX{
     WebDriver driver;

	 
	 XLUtilities xx= new XLUtilities();

    @Test
    public void loginTest() throws IOException, InterruptedException {
    	
    	
    	System.setProperty("webdriver.chrome.driver", "/Users/ishaanvashist/Downloads/Get_Tags/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();

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
            Thread.sleep(4000);
            
            WebElement verificationelement= driver.findElement(By.cssSelector("div[data-target='loading-context.details'] span[class='Button-label']"));
            
            if(verificationelement.isDisplayed()) {
            	
            	
            	
            	System.out.println("Login passed");     	
                XLUtilities.writereportxlsxworkbookpresent(2, i, "Login passed");

            	
            }
            
            
            else {
 	
            	
            	System.out.println("Login Failed");
                XLUtilities.writereportxlsxworkbookpresent(2, i, "LoginFailed");

            	
            }
            
            
            
            

        }

        // Close the workbook and FileInputStream
      

      workbook.close();
       fis.close();
        

        //xx.writereportt(3, 3, "Testing");
        
        
        
        
    }

    private void performLogin(String username, String password) {
        // Initialize WebDriver (assuming ChromeDriver for this example)
        //System.setProperty("webdriver.chrome.driver", "/Users/ishaanvashist/Downloads/Get_Tags/drivers/chromedriver");
        //WebDriver driver = new ChromeDriver();

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
    
    
    
    
    
    

}*/
