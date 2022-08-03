
package studentreportapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class DatabaseConnection
{
    public static String dataBaseConnectionString;
    public void openConnectionToDatabase()
    {
     dataBaseConnectionString = "jdbc:sqlserver://DESKTOP-87VQUG8:56410;databaseName=StudentPortal;"
              + "encrypt=true;trustServerCertificate=true;integratedSecurity=true";
//      Connection con = null;
      try
      {
         //Creation of connection to the database
         Connection  connection = DriverManager.getConnection(dataBaseConnectionString);
          
          JOptionPane.showMessageDialog(null,"Connnected To Microsoft SQL Server");
    }catch(Exception  e)
    {
        JOptionPane.showMessageDialog(null,"Failed to connect to the database");
    }
      
    }
    
    
    public static Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection(dataBaseConnectionString);
    }
}
