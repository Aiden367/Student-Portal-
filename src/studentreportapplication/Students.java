package studentreportapplication;

import java.awt.Component;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.sql.*;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Students
{

    DatabaseConnection dataBaseConnection = new DatabaseConnection();

    private String lastName, firstName, studentClass, studentLocation;
    private int studentGrade, studentAge, studentContactInformation;
    private Object[][] studentData;
    private JTable myTable, table;
    DefaultTableModel tblModel;
    JTextField setLastName;
    JTextField setFirstName;
    JTextField setStudentAge;
    JTextField setStudentClass;
    JTextField setStudentGrade;
    JTextField setStudentLocation;
    JTextField setStudentContactInformation;

//----------------------Start of Getters and Setters--------------------------//
    public void setTable(JTable value)
    {
        this.myTable = value;
    }

    public JTable getMyTable()
    {
        return myTable;
    }

    public void setStudentData(Object[][] learnerData)
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

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(populateTable);

            while (rs.next())
            {
                String userFirstName = rs.getString("LastName");
                String userLastName = rs.getString("FirstName");
                String userClass = rs.getString("StudentsClass");
                String userGrade = rs.getString("StudentsGrade");
                String userAge = rs.getString("StudentsLocation");
                String userContactInformation = rs.getString("ContactInformation");

                String tbData[] =
                {
                    userFirstName, userLastName, userClass, userGrade, userAge, userContactInformation
                };

                table = new JTable();

                DefaultTableModel model = new DefaultTableModel();

                table.setModel(model);

                model.addRow(tbData);

            }
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Could not populate Table");
        }
    }
//-----------------------------End of Method----------------------------------//

    public TableModel popultingGrid() throws SQLException
    {
        String populateTable = "SELECT * FROM StudentInformation ";
        Connection con = null;

        con = DatabaseConnection.getConnection();

        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery(populateTable);

        int numCols = rs.getMetaData().getColumnCount();

        tblModel = new DefaultTableModel();

//         table = new JTable(tblModel);
        for (int col = 1; col <= numCols; col++)
        {
            tblModel.addColumn(rs.getMetaData().getColumnLabel(col));
        }

        int row = 0;
        while (rs != null && rs.next())
        {
            tblModel.addRow(new Object[0]);
            tblModel.setValueAt(rs.getString("LastName"), row, 2);
            tblModel.setValueAt(rs.getString("FirstName"), row, 3);
            tblModel.setValueAt(rs.getString("StudentsClass"), row, 4);
            tblModel.setValueAt(rs.getString("StudentsGrade"), row, 5);
            tblModel.setValueAt(rs.getString("StudentsLocation"), row, 6);
            tblModel.setValueAt(rs.getString("StudentsAge"), row, 7);
            tblModel.setValueAt(rs.getString("ContactInformation"), row, 8);
            row++;
        }
        return tblModel;
    }

//----------------------------Start of method---------------------------------//
    public void removeRowFromDataBase() throws SQLException
    {

//        String sql = "delete FROM StudentInformation where StudentInformation.Id = ?";
//        Connection conn =  DatabaseConnection.getConnection();
//    try {
//     PreparedStatement pst = conn.prepareStatement(sql);
//       pst.setString(1,);
//       ((DefaultTableModel)getMyTable().getModel()).removeRow(getMyTable().getSelectedRow());
//        pst.execute();
//    JOptionPane.showMessageDialog(null, "Deleted");
//
//
//   } catch (Exception e) {
//      e.printStackTrace();
//      JOptionPane.showMessageDialog(null, e);
//     }
        Connection conn = DatabaseConnection.getConnection();

        int a = JOptionPane.showConfirmDialog((Component) null, "Do you want to delete the selected "
                + "row ?", "DELETE", JOptionPane.YES_NO_OPTION);

        if (a == 0)
        {
//            DefaultTableModel model = (DefaultTableModel) getMyTable().getModel();
            int getRows = getMyTable().getModel().getRowCount();

//            System.out.print(getRows);
            int rows = getMyTable().getSelectedRow();

            String cell = getMyTable().getModel().getValueAt(rows, 2).toString();
//            System.out.println(cell);

            String sql2 = "DELETE  FROM StudentInformation where FirstName = '" + cell + "'";

            try
            {
                PreparedStatement stmt = conn.prepareStatement(sql2);
                stmt.executeQuery();
//                stmt.executeQuery();

//                Statement st =  conn.createStatement();
//            Statement   pst = conn.prepareStatement(sql); 
//               rs.execute(sql);
                JOptionPane.showMessageDialog(null, "Row Successfully Deleted");

            } catch (Exception b)
            {
                b.printStackTrace();
                System.err.print(b);
                JOptionPane.showMessageDialog(null, "Could not delete row");
            }
        }
    }

    // TO DO Must be able to click on row and appears in textfields!!!!!!!!!
    //Hide id
    //Updates based  on student id because it is unique

    public void showingTextInTextField() throws SQLException
    {
        int row = getMyTable().getSelectedRow();

        String tblClick = getMyTable().getModel().getValueAt(row, 4).toString();
        try
        {
            Connection conn = DatabaseConnection.getConnection();

            String sql = "select * from StudentInformation where FirstName = '" + tblClick + "'";

            PreparedStatement pst = conn.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            if (rs.next())
            {
                String learnerFirstName = String.valueOf(rs.getString("FirstName"));
                setFirstName(learnerFirstName);
                System.out.println(learnerFirstName);

                String learnerLastName = String.valueOf(rs.getString("LastName"));
                setLastName(learnerLastName);

                String learnersClass = String.valueOf(rs.getString("StudentsClass"));
                setStudentClass(learnerFirstName);

                String learnerGrade = String.valueOf(rs.getInt("StudentsGrade"));
                int grade = Integer.parseInt(learnerGrade);
                setStudentGrade(grade);

                String learnersAge = String.valueOf(rs.getInt("StudentsAge"));
                int age = Integer.parseInt(learnersAge);
                setStudentAge(age);

                String learnersLocation = String.valueOf(rs.getString("StudentsLocation"));
                setFirstName(learnersLocation);

                String learnerContactInformation = String.valueOf(rs.getInt("ContactInformation"));
                int contactInfo = Integer.parseInt(learnerContactInformation);
                setStudentContactInformation(contactInfo);

            }
        } catch (Exception f)
        {
            System.err.print(f);
            JOptionPane.showMessageDialog(null, "Error loading data");
        }
    }

//--------------------------End of method-------------------------------------//
}
