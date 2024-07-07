package Configration_Files;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Common {
	String webElementXPath;
	public String getElementName(String webElementKey){
	Properties props=null;
	FileInputStream fin =null;
	try{
		File f = new File("src");
		
	    fin = new FileInputStream(f.getAbsolutePath()+"/object.properties");
	    props = new Properties();
	    props.load(fin);
	    webElementXPath = props.getProperty(webElementKey);
	   }catch(Exception e){
		   System.out.println(e.getMessage());
	   } 
	return webElementXPath;
	
	

	}
	