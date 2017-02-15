/**
 * @(#)MainMenu.java
 *
 *
 * @Jude Ugbefu
 * @version 1.00 2014/9/17
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
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import javax.swing.ButtonGroup;
import javax.swing.UIManager;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.util.Date;
import java.text.DateFormat;
import java.util.Locale;
import java.util.Calendar;
//import javax.swing.InterruptedException;
import java.util.Timer;

import java.text.SimpleDateFormat;

import com.toedter.calendar.*;   // import JCalendar package

@SuppressWarnings("unchecked")
public class MainMenu extends JFrame
{
	// instance variables
	private JRadioButton admin;      
	private JRadioButton customer;
	private JLabel welcomeMessage;
	private JLabel dateOnFrame;
	private ButtonGroup radioGroup; // buttongroup to hold radio buttons
	private JButton exitButton;
	private JButton iconLabel;
	private ImageIcon imageIcon;
	
    public MainMenu() 
    {
    	setTitle("Airline Reservation System");
    	setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    	setSize(600, 460);
    	setResizable(false);
    	setVisible(true);
    	setLocationRelativeTo(null);  
    	
    	DesignedPanel mainMenuPanel = new DesignedPanel("menuPicture.jpg"); // create wall paper panel
    	mainMenuPanel.setLayout(null);
    	
    	try
        {
           UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());           // change look of all buttons
           UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");  // Set all buttons to nimbus look
        }
        catch(Exception e)
        {}

        dateOnFrame = new JLabel("");
        dateOnFrame.setFont(new Font("Arial", Font.BOLD, 23));
    	dateOnFrame.setForeground(Color.WHITE);
    	dateOnFrame.setForeground(Color.BLACK);
    	dateOnFrame.setBounds(20, 400, 500, 30);
        
        welcomeMessage = new JLabel("Welcome to Airline Reservation System App");
        welcomeMessage.setFont(new Font("Arial", Font.BOLD, 23));
    	welcomeMessage.setForeground(Color.WHITE);
    	welcomeMessage.setBounds(50, 120, 500, 30);
    
    	//set admin button, change its font and color and set bounds for the button
    	admin = new JRadioButton("Admin", false);
    	admin.setFont(new Font("Arial", Font.BOLD, 20));
    	admin.setForeground(Color.WHITE);
    	admin.setBounds(130, 260, 150, 30);
    	
    	//set customer button, change its font and color and set bounds for the button
    	customer = new JRadioButton("Customer", false);
    	customer.setFont(new Font("Arial", Font.BOLD, 20));
    	customer.setForeground(Color.WHITE);
    	customer.setBounds(300, 260, 150, 30);
    
    	//create logical relationship between JRadioButtons
		radioGroup = new ButtonGroup(); // create ButtonGroup
		radioGroup.add(admin); // add admin to group
		radioGroup.add(customer); // add customer to group

		//set customer button, change its font and color and set bounds for the button
    	exitButton = new JButton();
    	exitButton.setFont(new Font("Arial", Font.BOLD, 20));
    	exitButton.setForeground(Color.BLACK);
    	exitButton.setBackground(Color.GRAY);
    	exitButton.setText("Exit Application");
    	exitButton.setBounds(130, 350, 290, 40);
    
    	// add components to panel
    	mainMenuPanel.add(dateOnFrame);
    	mainMenuPanel.add(welcomeMessage);
    	mainMenuPanel.add(admin);
    	mainMenuPanel.add(customer);
    	mainMenuPanel.add(exitButton);
    	
    	// add panel to frame
    	add(mainMenuPanel);
    	
    	ButtonHandler buttonHandler = new ButtonHandler();
    	exitButton.addActionListener(buttonHandler);
    	
    	// instantiate and add components to handler interface
    	RadioButtonHandler handler = new RadioButtonHandler();
   		admin.addItemListener(handler);	
    	customer.addItemListener(handler);	
   } 
   
   private class RadioButtonHandler implements ItemListener
   {

		public void itemStateChanged(ItemEvent event)
    	{
    		try
    		{		    		
    			if(customer.isSelected ())
    			{
    				Customer customerLogin = new Customer();  // create customer frame if cutomer is selected
    				setVisible(false);
    			}
    		}
    		catch(Exception e)
    		{
    		//	JOptionPane.showMessageDialog(null, "Unable to gain access. Please contact administration or TRY AGAIN!!!", "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
    		}
    		
    		try
    		{
    			if(admin.isSelected ())
    			{	
    				// Create application frame.
       			    AdminLogin adminLogin = new AdminLogin();  // cretae admin login frame if aadmin is selected
    				setVisible(false);
    			}
    		   	
    		}
    		catch(Exception e)
    		{
    		
    		}
    	}
    }
    
    private class ButtonHandler implements ActionListener
    {

		public void actionPerformed(ActionEvent event)
    	{
    		try
    		{
    			if(event.getSource() == exitButton)
    			{
    			   System.exit(0);  // exit application
    			}
    		}
    		catch(Exception e)
    		{
    			JOptionPane.showMessageDialog(null, "Sorry, an execption occured causing the program not to exit. Use the CLOSE BUTTON ICON on the right top end of the window to close the application", "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
    		}
    	}
    }
    
}

