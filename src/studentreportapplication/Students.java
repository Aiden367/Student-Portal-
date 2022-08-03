package studentreportapplication;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.sql.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class Students
{

    DatabaseConnection dataBaseConnection = new DatabaseConnection();
    private String lastName, firstName, studentClass, studentLocation;
    private int studentGrade, studentAge, studentContactInformation;
    private Object [][] studentData;
    
    JTextField setLastName;
    JTextField setFirstName;
    JTextField setStudentAge;
    JTextField setStudentClass;
    JTextField setStudentGrade;
    JTextField setStudentLocation;
    JTextField setStudentContactInformation;
    
//    firstDisplay firstDisplay = new firstDisplay();

//----------------------Start of Getters and Setters--------------------------//
    
    
    public void setStudentData(Object [][] learnerData)
    {
        this.studentData = learnerData;
    }
    
    public Object[][] getStudentData()
    {
        return studentData;
    }
    
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

//-------------------------End of getters and Setters-------------------------// 
    

    
//-------------------------Start of method------------------------------------//
    
    public void addStudent()
    {

        //String used to insert the information into the database when the user pressed save details
        String sql = "INSERT INTO StudentInformation (LastName,FirstName,StudentsClass"
                + ",StudentsGrade,StudentsAge,StudentsLocation,ContactInformation)" + "VALUES (?,?,?,?,?,?,?)";
        
        Connection con = null;
        
        try
        {

            con = DatabaseConnection.getConnection();

            PreparedStatement statement = con.prepareStatement(sql);

            statement.setString(1, getLastName());
            statement.setString(2, getFirstName());
            statement.setString(3, getStudentClass());
            statement.setInt(4, getStudentGrade());
            statement.setInt(5, getStudentAge());
            statement.setString(6, getStudentLocation());
            statement.setInt(7, getStudentContactInformation());

            int rows = statement.executeUpdate();

            if (rows > 0)
            {
                JOptionPane.showMessageDialog(null, "Row has been inserted");
            }

//          connection.close();
        } catch (Exception e)
        {
            System.err.print(e);
            JOptionPane.showMessageDialog(null, "an error occured adding your data");
        }

    }
//---------------------------End of method------------------------------------//
    
//----------------------------Start of Method---------------------------------//
public void addingInformationToTable()
{
    String populateTable = "select * from StudentInformation";
    Connection con = null;
    try
    {
       con = DatabaseConnection.getConnection();
       
//       PreparedStatement statement = con.prepareStatement(populateTable);
       Statement st =  con.createStatement();
       ResultSet rs =st.executeQuery(populateTable);
       
       while(rs.next())
       {
           String userFirstName = rs.getString("LastName");
           String userLastName = rs.getString("FirstName");
           String userClass = rs.getString("StudentsClass");
           String userGrade = rs.getString("StudentsGrade");
           String userAge = rs.getString("StudentsLocation");
           String userContactInformation = rs.getString("ContactInformation");
           
           String tbData[] = {userFirstName,userLastName,userClass,userGrade,userAge,userContactInformation};
           
           JTable table = new JTable();
           
         DefaultTableModel  model = new DefaultTableModel();
//         model.setColumnIdentifiers();
          table.setModel(model);
          
          model.addRow(tbData);
          
       }
    }catch(Exception e)
    {
       JOptionPane.showMessageDialog(null,"Could not populate Table");
    }
}    
//-----------------------------End of Method----------------------------------//
}
