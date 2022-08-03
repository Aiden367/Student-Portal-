
package studentreportapplication;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

//Class for if the user wants to add a new student into the system
public class firstDisplay  extends JFrame implements ActionListener
{
   private JTextField studentFirstName,studentLastName,studentClass,studentGrade,studentAge,
           studentLocation,studentContactInformation;
   private JLabel textStudentFirstName,textStudentLastName,textStudentClass,textStudentGrade,
           textStudentAge,textStudentLocation,textStudentContactInformation;
   
   private JButton returnToMenu,saveDetails;
    
  firstDisplay()
  {

      
        
//-------------------Start of JButtons----------------------------------------//
 
 //Creation of a button that will save student details to the database
 saveDetails = new JButton("Save Details");
 saveDetails.addActionListener(this);
 saveDetails.setBounds(200, 400, 200, 100);
      
 //Creation of a menu that returns you back to the starting menu     
 returnToMenu = new JButton("Return to Menu");
 returnToMenu.addActionListener(this);
 returnToMenu.setBounds(500, 400, 200, 100);
      
//-------------------End of JButtons------------------------------------------//
      
//-------------------Start of TextFields--------------------------------------//
      
      //Creation of textfield for entering students first name
      studentFirstName = new JTextField();
      studentFirstName.setBounds(230, 75, 200, 25);
      
      //Creation of textfield for entering students last name
      studentLastName = new JTextField();
      studentLastName.setBounds(230, 115, 200, 25);
      
      //Creation of textfield for entering the students class
      studentClass = new JTextField();
      studentClass.setBounds(230, 155, 200, 25);
      
      //Creation of textfield for entering the students grade
      studentGrade = new JTextField();
      studentGrade.setBounds(970, 75, 200, 25);
      
      //Creation of textField for entering the students age
      studentAge = new JTextField();
      studentAge.setBounds(970, 115, 200, 25);
      
      //Creation of textField for entering the students location
      studentLocation = new JTextField();
      studentLocation.setBounds(970, 155, 200, 25);
      
      //Creation of textField for entering the students contact information
      studentContactInformation = new JTextField();
      studentContactInformation.setBounds(970,196, 200, 25);
      
      
//-----------------End of TextFields------------------------------------------//

//-----------------start of Labels--------------------------------------------//

        //Creation of a label to act as a Title that is "Detailed Time Report"
        JLabel textStudentInformation = new JLabel();
        textStudentInformation.setFont(new Font("gotham", Font.PLAIN, 20));
        textStudentInformation.setBounds(520, 0, 300, 50);
        textStudentInformation.setText("Student Information");
        
        //Creation of label to label students first name textfield
        textStudentFirstName = new JLabel();
        textStudentFirstName.setFont(new Font("gotham",Font.PLAIN,20));//Remove Bold
        textStudentFirstName.setBounds(120, 60, 200, 50);
        textStudentFirstName.setText("First Name:");
        textStudentFirstName.setAlignmentX(RIGHT_ALIGNMENT);
        
        //Creation of label that labels the lastname textfield as "Last Name"
        textStudentLastName = new JLabel();
        textStudentLastName.setFont(new Font("gotham", Font.PLAIN, 20));
        textStudentLastName.setBounds(120, 100, 140, 50);
        textStudentLastName.setText("Last Name:");
        
        
        //Creation of label that labels the studentClass textfield as "Student Class"
        textStudentClass = new JLabel();
        textStudentClass.setFont(new Font("gotham", Font.PLAIN, 20));
        textStudentClass.setBounds(82, 135, 160, 60);
        textStudentClass.setText("Students Class:");
        textStudentClass.setAlignmentX(Component.RIGHT_ALIGNMENT);
        
        //Creation of lable that labels the studentGrade textfield as "Grade"
        textStudentGrade = new JLabel();
        textStudentGrade.setFont(new Font("gotham", Font.PLAIN, 20));
        textStudentGrade.setBounds(820, 60, 300, 50);
        textStudentGrade.setText("Students Grade:");
        textStudentGrade.setAlignmentX(Component.RIGHT_ALIGNMENT);
        
        //Creation of label that labels the studentAge textfield as "Students Age"
        textStudentAge = new JLabel();
        textStudentAge.setFont(new Font("gotham", Font.PLAIN, 20));
        textStudentAge.setBounds(840, 100, 300, 50);
        textStudentAge.setText("Students Age:");
        textStudentAge.setAlignmentX(Component.RIGHT_ALIGNMENT);
        
        //Creation of label that labels the studentLocation textfield as "Students Location"
        textStudentLocation = new JLabel();
        textStudentLocation.setFont(new Font("gotham", Font.PLAIN, 20));
        textStudentLocation.setBounds(800, 140, 300, 50);
        textStudentLocation.setText("Students Location:");
        textStudentLocation.setAlignmentX(Component.RIGHT_ALIGNMENT);
        
        //Creation of label that labels the studentContactInformation textfield as "Contact Information"
        textStudentContactInformation = new JLabel();
        textStudentContactInformation.setFont(new Font("gotham", Font.PLAIN, 20));
        textStudentContactInformation.setBounds(784, 181, 300, 50);
        textStudentContactInformation.setText("Contact Information:");
        textStudentContactInformation.setAlignmentX(Component.RIGHT_ALIGNMENT);
        

//-------------------End of labels--------------------------------------------//
      
      
      
//----------------Start of JFRAME---------------------------------------------//

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(1400, 700);
        this.setVisible(true);
        this.add(studentFirstName);
        this.add(studentLastName);
        this.add(studentClass);
        this.add(studentGrade);
        this.add(studentAge);
        this.add(studentLocation);
        this.add(studentContactInformation);
        this.add(textStudentFirstName);
        this.add(textStudentLastName);
        this.add(textStudentClass);
        this.add(textStudentGrade);
        this.add(textStudentAge);
        this.add(textStudentLocation);
        this.add(textStudentContactInformation);
        this.add(textStudentInformation);
        this.add(returnToMenu);
        this.add(saveDetails);
        
//-----------------End of JFRAME----------------------------------------------//
  }
    
    
    
    
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
       if(e.getSource() == returnToMenu)
       {
           new menu();
           this.setVisible(false);
       }
       
       if(e.getSource() == saveDetails)
       {
           int learnersAge = Integer.parseInt(studentAge.getText());
           
           int learnersGrade = Integer.parseInt(studentGrade.getText());
          
           int learnersContactInformation = Integer.parseInt(studentContactInformation.getText());
//           addingToDataBase();
             Students students = new Students();
             students.setLastName(studentLastName.getText());
             students.setFirstName(studentFirstName.getText());
             students.setStudentAge(learnersAge);
             students.setStudentClass(studentClass.getText());
             students.setStudentLocation(studentLocation.getText());
             students.setStudentContactInformation(learnersContactInformation);
             students.setStudentGrade(learnersGrade);
             
             students.addStudent();
             
            
       }
    }
    
    
    
//--------------------------Start of method-----------------------------------//
    
//public void addingToDataBase()
//{
    
//    String dataBaseURL = "jdbc:sqlserver://DESKTOP-87VQUG8:56410;databaseName=StudentPortal;"
//              + "encrypt=true;trustServerCertificate=true;integratedSecurity=true";
      
//      try
//      {
         //Creation of connection to the database
//          Connection connection = DriverManager.getConnection(dataBaseURL);
          

          
          //String used to insert the information into the database when the user pressed save details
//          String sql = "INSERT INTO StudentInformation (LastName,FirstName,StudentsClass"
//                  + ",StudentsGrade,StudentsAge,StudentsLocation,ContactInformation)" + "VALUES (?,?,?,?,?,?,?)";
//          
//          
//          PreparedStatement statement = connection.prepareStatement(sql);
//          
//          statement.setString(1,studentLastName.getText());
//          statement.setString(2,studentFirstName.getText());
//          statement.setString(3,studentClass.getText());
//          statement.setString(4,studentGrade.getText());
//          statement.setString(5,studentAge.getText());
//          statement.setString(6,studentLocation.getText());
//          statement.setString(7,studentContactInformation.getText());
//          
//          
//          int rows = statement.executeUpdate();
//          
//          if(rows>0)
//          {
//              JOptionPane.showMessageDialog(null,"Row has been inserted");
//          }
//          
//          connection.close();
//          
//      }catch(Exception e)
//      {
//        JOptionPane.showMessageDialog(null,"Connection Failed");
//        e.printStackTrace();
//      }
//}
 
//--------------------------End of method-------------------------------------//
}
