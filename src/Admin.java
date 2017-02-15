/**
 * @(#)Admin.java
 *
 *
 * @author 
 * @version 1.00 2014/9/25
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
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JDesktopPane;
import java.awt.GraphicsEnvironment;

@SuppressWarnings("unchecked")
public class Admin extends JFrame
{
	// instance variables
	private JMenuBar menuBar;          
	private JMenu addFlightDetails;   // JMenu for adding flight details
	private JMenu editFlightDetails;  // JMenu for editing flight details
	private JMenu passengerDetails;   // JMenu for viewing passenger details
	private JMenu about;				// JMenu to give  details of the application
	private JMenu exit;					// JMenu to exit to main menu
	private JDesktopPane mainFrame;     // desktop pane to old menu bar
	
    public Admin() 
    {
    	setTitle("Airline Reserrvation System                                        							       Admin"); 
    	GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();  // set graphics of frame
    	setSize( 800, 600 );   // set size of frame
    	setMaximizedBounds( environment.getMaximumWindowBounds() );  // make frame fill up the screen
    	setExtendedState( getExtendedState() | MAXIMIZED_BOTH );  
    	setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );   // close frame when closed
    	setLocationRelativeTo( null );  
    	setVisible( true ); 	 // make frame visible
    		
    	// create JDesktopPane and add it to the JFrame
    	mainFrame = new JDesktopPane();
    	mainFrame.setBackground( Color.gray );
    	mainFrame.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
        	
    	try
        {
           UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());           // change look of all buttons
           UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");  // Set all buttons to nimbus look
        }
        catch(Exception e)
        {}
    	
    	
    	menuBar = new JMenuBar();
    	setJMenuBar( menuBar );   // set menu bar
    	
    	addFlightDetails = new JMenu("Add flight details");

    	editFlightDetails = new JMenu("Edit flight details");
    	
    	passengerDetails = new JMenu("Passenger details");
    	
    	about = new JMenu("About");
    	
    	exit = new JMenu("Main menu");
    	
    	// add menus to menu bar
    	menuBar.add(addFlightDetails);
    	menuBar.add(editFlightDetails);
    	menuBar.add(passengerDetails);
    	menuBar.add(about);
    	menuBar.add(exit);
    	
    	// add desktop pane to frame	
    	add(mainFrame);
    		
    	// instantiate and add components to handler interface
    	MenuButtonHandler handler = new MenuButtonHandler();
   		addFlightDetails.addItemListener(handler);	
    	editFlightDetails.addItemListener(handler);
    	passengerDetails.addItemListener(handler);	
    	about.addItemListener(handler);
    	exit.addItemListener(handler);	
    	
    }
    
   private class MenuButtonHandler implements ItemListener
   {

		public void itemStateChanged(ItemEvent event)
    	{
    		try
    		{		    		
    			if(addFlightDetails.isSelected ())
    			{
    				// Create application frame.
      			    AddFlightDetails addFlight = new AddFlightDetails();
      			  
    				// sizes to determine the starting point of the internal frame
    				int size1 = ( Admin.this.getWidth() - 650 ) / 2;
    				int size2 = ( Admin.this.getHeight() - 520 ) / 2;   
    					
      			    addFlight.setLocation( size1, size2 );  // set the starting point of the internal frame  				
    				addFlight.setVisible( true );	// set the internal frame visible
    				mainFrame.add( addFlight );	// add the internal frame to the desktop pane
    				addFlight.toFront();  
      			    
    			}
    		}
    		catch(Exception e)
    		{
    			JOptionPane.showMessageDialog(null, "An Error has occured\nThe internal frame could not be opened", "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
    		}
    		
    		try
    		{
    			if(editFlightDetails.isSelected ())
    			{
    			    // Create application frame.
      				EditFlightDetails editFlight = new EditFlightDetails();
      				
      				// sizes to determine the starting point of the internal frame
    				int size1 = ( Admin.this.getWidth() - 650 ) / 2;
    				int size2 = ( Admin.this.getHeight() - 700 ) / 2;   
    					
      			    editFlight.setLocation( size1, size2 );  // set the starting point of the internal frame  				
    				editFlight.setVisible( true );	// set the internal frame visible
    				mainFrame.add( editFlight );	// add the internal frame to the desktop pane
    				editFlight.toFront();  
    			}
    		}
    		catch(Exception e)
    		{	
    			JOptionPane.showMessageDialog(null, "An Error has occured\nThe internal frame could not be opened", "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
    		}
    		
    		try
    		{
    			if(passengerDetails.isSelected ())
    			{
    			    // Create application frame.
      				PassengerDetails passengerDetailz = new PassengerDetails();
      				 
      				// sizes to determine the starting point of the internal frame
    				int size1 = ( Admin.this.getWidth() - 1360 ) / 2;
    				int size2 = ( Admin.this.getHeight() - 600 ) / 2;   
    					
      			    passengerDetailz.setLocation( size1, size2 );  // set the starting point of the internal frame  				
    				passengerDetailz.setVisible( true );	// set the internal frame visible
    				mainFrame.add( passengerDetailz );	// add the internal frame to the desktop pane
    				passengerDetailz.toFront();  
    					
    				
    			}
    		}
    		catch(Exception e)
    		{
				JOptionPane.showMessageDialog(null, "Oops something went wrong.", "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
    		}
    		
    	 /*	try
    		{
    			if(changePassword.isSelected ())
    			{
    				ChangeAdminPassword changeAdminPassword = new ChangeAdminPassword();

    			    // sizes to determine the starting point of the internal frame
    				int size1 = ( Admin.this.getWidth() - 650 ) / 2;
    				int size2 = ( Admin.this.getHeight() - 520 ) / 2;   
    					
      			    changeAdminPassword.setLocation( size1, size2 );  // set the starting point of the internal frame  				
    				changeAdminPassword.setVisible( true );	// set the internal frame visible
    				changeAdminPassword.setSize(420, 250);
    				mainFrame.add( changeAdminPassword );	// add the internal frame to the desktop pane
					changeAdminPassword.toFront();  
    			}
    		}
    		catch(Exception e)
    		{
				JOptionPane.showMessageDialog(null, "Oops something went wrong. Please close the frame", "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
    		}   */
    		
    		try
    		{
    			if(exit.isSelected ())
    			{
    				// Create application frame.
      				MainMenu mainMenu = new MainMenu();
    				setVisible(false);
    			}
    		}
    		catch(Exception e)
    		{
				JOptionPane.showMessageDialog(null, "Please select a card option. Visa Card or Master Card", "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
    		}
    		
    	    try
    		{
    			if(about.isSelected ())
    			{
    			    // Create application frame.
      				AboutTheApp aboutTheApp = new AboutTheApp();
      				
      				// sizes to determine the starting point of the internal frame
    				int size1 = ( Admin.this.getWidth() - 650 ) / 2;
    				int size2 = ( Admin.this.getHeight() - 700 ) / 2;   
    					
      			    aboutTheApp.setLocation( size1, size2 );  // set the starting point of the internal frame  				
    				aboutTheApp.setVisible( true );	// set the internal frame visible
    				mainFrame.add( aboutTheApp );	// add the internal frame to the desktop pane
    				aboutTheApp.toFront();  
    			}
    		}
    		catch(Exception e)
    		{	
    			JOptionPane.showMessageDialog(null, "An Error has occured\nThe internal frame could not be opened", "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
    		}
    	}
    }
    
    
}