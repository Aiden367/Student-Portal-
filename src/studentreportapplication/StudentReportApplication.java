
package studentreportapplication;


public class StudentReportApplication
{

   
    public static void main(String[] args)
    {
        DatabaseConnection DatabaseConnection = new DatabaseConnection();
        
        DatabaseConnection.openConnectionToDatabase();
        
        new menu();
        
    }
    
}
