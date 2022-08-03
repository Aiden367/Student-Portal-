
package studentreportapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Students
{
 DatabaseConnection dataBaseConnection = new DatabaseConnection();
   private String lastName,firstName,studentClass,studentLocation;
   private int studentGrade,studentAge,studentContactInformation;
    JTextField setLastName;
    JTextField setFirstName;
    JTextField setStudentAge;
    JTextField setStudentClass;
    JTextField setStudentGrade;
    JTextField setStudentLocation;
    JTextField setStudentContactInformation;
   firstDisplay firstDisplay = new firstDisplay();
   
    public String getLastName()
    {
        return lastName;
    }
    
    public void setLastName(String learnerLastName)
    {
        this.lastName = learnerLastName;
    }
    
    public String getFirstName()
    {
       return firstName;
    }
    
    public void setFirstName(String learnerFirstName)
    {
        this.firstName = learnerFirstName;
    }
    
    public String getStudentClass()
    {
        return studentClass;
    }
    
    public void setStudentClass(String learnerClass)
    {
        this.studentClass = learnerClass;
    }
    public String getStudentLocation()
    {
        return studentLocation;
    }
    
    public void setStudentLocation(String learnerLocation)
    {
        this.studentLocation = learnerLocation;
    }
    public int getStudentGrade()
    {
        return studentGrade;
    }
    
    public void setStudentGrade(int learnerGrade)
    {
        this.studentGrade = learnerGrade;
    }
    public int getStudentContactInformation()
    {
        return studentContactInformation;
    }
    
    public void setStudentContactInformation(int learnerContactInformation)
    {
        this.studentContactInformation = learnerContactInformation;
    }
    public int getStudentAge()
    {
        return studentAge;
    }
    
    public void setStudentAge(int learnerAge)
    {
        this.studentAge = learnerAge;
    }
    
   
    
    
    
    
    
        public void addStudent()
    {

        
        //String used to insert the information into the database when the user pressed save details
          String sql = "INSERT INTO StudentInformation (LastName,FirstName,StudentsClass"
                  + ",StudentsGrade,StudentsAge,StudentsLocation,ContactInformation)" + "VALUES (?,?,?,?,?,?,?)";
          Connection con = null;
          try{

               con = DatabaseConnection.getConnection();


            PreparedStatement statement = con.prepareStatement(sql);

          
          statement.setString(1,getLastName());
          statement.setString(2,getFirstName());
          statement.setString(3,getStudentClass());
          statement.setInt(4,getStudentGrade());
          statement.setInt(5,getStudentAge());
          statement.setString(6,getStudentLocation());
          statement.setInt(7,getStudentContactInformation());
          

          int rows = statement.executeUpdate();
          
          
          if(rows>0)
         {
              JOptionPane.showMessageDialog(null,"Row has been inserted");
          }
          
//          connection.close();
          }catch(Exception e)
          {
             System.err.print(e);
              JOptionPane.showMessageDialog(null,"an error occured adding your data");
          }
          
    }

//    private  void writeData()
//    {
//        try{
//            
////        Connection con = DatabaseConnection.getConnection();
//         Connection connection = DriverManager.getConnection(dataBaseConnection.dataBaseConnectionString);
//         
//        String sql = "INSERT INTO StudentInformation (LastName,FirstName,StudentsClass"
//                  + ",StudentsGrade,StudentsAge,StudentsLocation,ContactInformation)" + "VALUES (?,?,?,?,?,?,?)";
//        
//        int rows = connection.executeUpdate();
//        }catch(Exception e)
//        {
//            JOptionPane.showMessageDialog(null,"Cannot Connect");
//        }
//    }
}
