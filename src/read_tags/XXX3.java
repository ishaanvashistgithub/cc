package read_tags;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Configration_Files.WebDriverManager;
import Configration_Files.XLUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class XXX3 {
    WebDriver driver;

    @Test
    public void loginTest() throws IOException, InterruptedException {
     

    	
    	// Initialize WebDriver (assuming ChromeDriver for this example)
        System.setProperty("webdriver.chrome.driver", "/Users/ishaanvashist/Downloads/Get_Tags/drivers/chromedriver");
        driver = new ChromeDriver();
    	
		Thread.sleep(10000);
		//get collage name and iterate
		

        // Specify the path to the Excel file
        File file = new File("/Users/ishaanvashist/Downloads/Get_Tags/Datafiles/Modi.xlsx");

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
            String wordToMatch = row.getCell(0).getStringCellValue();


            // Execute your Selenium WebDriver test with the word
            matchWordOnWebPage(wordToMatch);
            Thread.sleep(4000);
        }

        // Close the workbook and FileInputStream
        workbook.close();
        fis.close();
    }
           

	

	       
       
        
  //b[normalize-space()='Narendra Damodardas Modi']
        
      

    private void matchWordOnWebPage(String wordToMatch) {
        // Open the web page where you want to match the word
        driver.get("https://en.wikipedia.org/wiki/Narendra_Modi");  // Replace with your actual URL
        driver.manage().window().maximize();

        // Find an element on the web page containing text
        WebElement contentElement = driver.findElement(By.xpath("//b[normalize-space()='Narendra Damodardas Modi']")); 
        String pageContent = contentElement.getText();

        // Match the word with the content on the web page
        if (pageContent.contains(wordToMatch)) {
            System.out.println("Word '" + wordToMatch + "' found on the web page.");
            // You can perform further actions/assertions here if needed
        } else {
            System.out.println("Word '" + wordToMatch + "' not found on the web page.");
            
            XLUtilities.writereportxlsxworkbookpresent(1, 2, "Word not present");
        }
    }

  
    

    }
    
    
    

