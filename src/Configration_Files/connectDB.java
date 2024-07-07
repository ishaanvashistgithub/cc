
package Configration_Files;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
public class connectDB {
	String res;
	public String getQuery(String DataSource,String DatabaseName,String query) throws ClassNotFoundException, SQLException {
	 try {
		 Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");

		    Connection m_Connection = DriverManager.getConnection("jdbc:microsoft:sqlserver://"+DataSource+";databaseName="+DatabaseName+"", "onguard", "beschuit");

		    Statement m_Statement = m_Connection.createStatement();
		    ResultSet m_ResultSet =m_Statement.executeQuery(query);
		    
			while (m_ResultSet.next()) {
		      res=m_ResultSet.getString(1);
		      System.out.println(res);
		    }
		     m_Connection.close();
			
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	 return res;
	   
	  }
}
