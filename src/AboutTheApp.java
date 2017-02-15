/**
 * @(#)AboutTheApp.java
 *
 *
 * @author 
 * @version 1.00 2014/10/31
 */


//import packages
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import javax.swing.ButtonGroup;
import javax.swing.UIManager;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox; 
import javax.swing.BorderFactory; ;
import javax.swing.JPanel;
import javax.swing.JInternalFrame;

public class AboutTheApp extends JInternalFrame
{

    public AboutTheApp() 
    {
    	setTitle("About the Application"); 
    	setSize(350, 330);   // set size of internal frame
    	setClosable( true ); // make frame closable
    	setIconifiable( true ); // make frame minimizable  
    	setLayout(null);
    	
    	try
        {
           UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());           // change look of all buttons
           UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");  // Set all buttons to nimbus look
        }
        catch(Exception e)
        {}
        
            	
    	// Format Label
    	JLabel designedBY = new JLabel();
    	designedBY.setFont(new Font("Tahoma", 0, 16)); // set font
        designedBY.setForeground(new Color(0, 0, 0));
        designedBY.setText("Designed and Programmed by: ");
    	designedBY.setBounds(30, 20, 300, 40);  
            	
    	// Format Label
    	JLabel nameOfAuthor = new JLabel();
    	nameOfAuthor.setFont(new Font("Tahoma", 0, 16)); // set font
        nameOfAuthor.setForeground(new Color(0, 0, 0));
        nameOfAuthor.setText("JUDE UGBEFU");
    	nameOfAuthor.setBounds(30, 50, 200, 40);  

    	    	// Format Label
    	JLabel studentNumber = new JLabel();
    	studentNumber.setFont(new Font("Tahoma", 0, 16)); // set font
        studentNumber.setForeground(new Color(0, 0, 0));
        studentNumber.setText("Student Number: 212136100");
    	studentNumber.setBounds(30, 70, 300, 40);  
    	
        // Format Label
    	JLabel email = new JLabel();
    	email.setFont(new Font("Tahoma", 0, 16)); // set font
        email.setForeground(new Color(0, 0, 0));
        email.setText("jude2flexwith@gmail.com");
    	email.setBounds(30, 90, 300, 40);  
    		
    	// Format Label
    	JLabel emailOption2 = new JLabel();
    	emailOption2.setFont(new Font("Tahoma", 0, 16)); // set font
        emailOption2.setForeground(new Color(0, 0, 0));
        emailOption2.setText("judeconnectionz@gmail.com");
    	emailOption2.setBounds(30, 110, 300, 40);  
    		
    	// Format Label
    	JLabel version = new JLabel();
    	version.setFont(new Font("Tahoma", 0, 16)); // set font
        version.setForeground(new Color(0, 0, 0));
        version.setText("Version: 3.0");
    	version.setBounds(30, 140, 200, 40);  
    		
    		// Format Label
    	JLabel programmedUsing = new JLabel();
    	programmedUsing.setFont(new Font("Tahoma", 0, 16)); // set font
        programmedUsing.setForeground(new Color(0, 0, 0));
        programmedUsing.setText("Programmed using:");
    	programmedUsing.setBounds(30, 170, 200, 40);  
    		
    			// Format Label
    	JLabel environment = new JLabel();
    	environment.setFont(new Font("Tahoma", 0, 16)); // set font
        environment.setForeground(new Color(0, 0, 0));
        environment.setText("JCreator 4.5 Pro");
    	environment.setBounds(30, 190, 200, 40); 
    	
    				// Format Label
    	JLabel database = new JLabel();
    	database.setFont(new Font("Tahoma", 0, 16)); // set font
        database.setForeground(new Color(0, 0, 0));
        database.setText("Database: MySQL 5.6 ");
        database.setBounds(30, 220, 200, 40); 

    	add(nameOfAuthor);
    	add(studentNumber);
    	add(version);
    	add(programmedUsing);
    	add(database);
    	add(environment);
    	add(designedBY);
    	add(email);
    	add(emailOption2);
    }
    
}