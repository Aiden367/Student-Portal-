
package studentreportapplication;

//import com.sun.jdi.connect.spi.Connection;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.Connection;
public class menu extends JFrame implements ActionListener
{
//------------------------start of declerations-------------------------------//
    
   private JButton addStudent,studentAlreadyInDataBase,exit;
   private JLabel title;
   
//----------------------end of declerations-----------------------------------//
    menu()
    {

//------------------start of JLabels------------------------------------------//
        
        //Creation of a title for the menu saying "Student Portal"
        title = new JLabel("Student Portal");
        title.setBounds(170, 0, 350, 100);
        title.setFont(new Font("gotham", Font.BOLD, 20));
        
        
//------------------end of JLabels--------------------------------------------//
        
//------------------start of JButtons-----------------------------------------//
        
        //Creation of button that displays add student JFRAME
        addStudent = new JButton("Add Student");
        addStudent.addActionListener(this);
        addStudent.setBounds(110, 100, 250, 60);
        
        //Creation of button the Displays the JFRame with the students details
        studentAlreadyInDataBase = new JButton("Existing Student");
        studentAlreadyInDataBase.addActionListener(this);
        studentAlreadyInDataBase.setBounds(110, 190, 250, 60);
        
        //Creation of button that exits the user from the program
        exit = new JButton("Exit");
        exit.addActionListener(this);
        exit.setBounds(110, 280, 250, 60);
        
        
//-----------------end of JButtons--------------------------------------------//    
        
//--------------------start of JFRAME-----------------------------------------//
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(500, 500);
        this.setVisible(true);
        this.add(addStudent);
        this.add(studentAlreadyInDataBase);
        this.add(exit);
        this.add(title);
                
//----------------end of JFRAME-----------------------------------------------//    
        
        
    }
    
//--------------------start of action listener--------------------------------//
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()  == exit && JOptionPane.showConfirmDialog(exit, "Are you sure "
                + " you want to quit", "Student Portal",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        {
            System.exit(0);
        }
        
        if(e.getSource() == addStudent)
        {
            new firstDisplay();
            this.setVisible(false);
        }
    }
//---------------------end of action listener---------------------------------//    
}
