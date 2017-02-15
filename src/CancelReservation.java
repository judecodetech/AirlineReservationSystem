/**
 * @(#)CancelBooking.java
 *
 *
 * @author 
 * @version 1.00 2014/10/21
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
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Date;
import java.text.SimpleDateFormat;

public class CancelReservation extends JFrame
{
	//Instance Variables
    private JLabel cancelBookingLabel;		   // message label to the user to cancel a flight
    private JTextField cancelBookingField;     // text field that allows users to enter their booking id for cancellation
    private JButton mainMenu;				   // button that returns a user to the main menu when clicked
	private JButton clickToCancelBooking;      // button that causes bookind to be cancelled when clicked
	
	static final String DATABASE_URL = "jdbc:mysql://localhost/ars";
   	static final String USERNAME = "ars";
   	static final String PASSWORD = "cput";
   	static  String query = "";	 // variable to store database queries

	private DataBaseNoTableModel connectDBandCancelBooking;   // database connection variable
	
    public CancelReservation() 
    {
    	
    	setTitle("Airline Reserrvation System                                               Cancel Reservation");  // set title of frame
    	setSize(700, 250);        		// Set the size of the frame
    	setVisible(true);        		// Make the frame visible
    	setResizable(false);     		// Make the frame non-resizable
    	setLocationRelativeTo(null);   // Make the frame appear at the centre of the screen
    
    	setLayout(null);    // set default layout manager to null
    	
        try
        {
           UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());           // change look of all buttons
           UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");  // Set all buttons to nimbus look
        }
        catch(Exception e)
        {}
        
    	cancelBookingLabel = new JLabel();                       
    	cancelBookingLabel.setFont(new Font("Tahoma", 1, 20)); // set font for this componenet
        cancelBookingLabel.setForeground(new Color(0, 0, 0));  // set color for this componenet
        cancelBookingLabel.setText("Please enter your booking ID in the field below.");  // set text for this componenet
    	cancelBookingLabel.setBounds(50, 30, 700, 40);   // set the bounds of this component
    	
    	cancelBookingField = new JTextField(15);    
    	cancelBookingField.setFont(new Font("Tahoma", 1, 12));  // set font for this componenet
    	cancelBookingField.setBounds(50, 70, 110, 30);     // set the bounds of this component
    	
    	clickToCancelBooking = new JButton();
        clickToCancelBooking.setText("Click to cancel booking after entering your booking ID");  // set text for this componenet
        clickToCancelBooking.setFont(new Font("Tahoma", 1, 14)); // set font for this componenet
    	clickToCancelBooking.setBounds(50, 120, 400, 40);         // set the bounds of this component

    	mainMenu = new JButton();
        mainMenu.setText("Main Menu");     // set text for this componenet
        mainMenu.setFont(new Font("Tahoma", 1, 14)); // set font for this componenet
    	mainMenu.setBounds(500, 120, 130, 40);       // set the bounds of this component
    	
    	add(cancelBookingLabel);    // add label to frame
    	add(cancelBookingField);    // add text field to frame
    	add(clickToCancelBooking);  // add button to frame
    	add(mainMenu);      // add main menu dbutton to frame
    	
    	ButtonHandler buttonHandler = new ButtonHandler();    // instantiate button handler
    	clickToCancelBooking.addActionListener(buttonHandler); // add cancelBooking button to handler
    	mainMenu.addActionListener(buttonHandler);   // add main menu button to handler
    	
    }
    
    private class ButtonHandler implements ActionListener
    {
		public void actionPerformed(ActionEvent event)
    	{
    		try
    		{   
    			// Check if mainMenu buton is clicked
    		    if(event.getSource() == mainMenu)
    			{  
    		        MainMenu mainM = new MainMenu();   // instantiate main menu frame  
    		        setVisible(false);    // set cancel reservation frame to false
    			}
    		}
    		catch(Exception e)
    		{
    		
    		}
    		
    		try
    		{
    		    if(event.getSource() == clickToCancelBooking)
    			{
    		       connect();    // connect to database
    		       
    		       //get booking id from text field and change it to an integer
    		       int bookingID =  Integer.parseInt(cancelBookingField.getText());   
    		       
    		       if(bookingID < 20001 || bookingID > 25000)
    		       {
    		       	   // display JOptionPane message if booking ID meets the if condition statement
    		           JOptionPane.showMessageDialog( null,"Sorry invalid booking ID.\nMust be between 20001 and 25000, and must be numeric",
           	              "Invalid booking ID ",JOptionPane.ERROR_MESSAGE);
    		       }
    		       else
    		       {
    		       	   ResultSet resultSet = null; // manages results
    		       
    		           query = String.format("Select * from booking");   // set query message
				       connectDBandCancelBooking.setQuery(query);        // set query message to be sent to database
    		           connectDBandCancelBooking.execute();  // execute query
    		       
    		           resultSet = connectDBandCancelBooking.getResultSet();   // get result of sent query
           
				       while(resultSet.next())
				       {
				       	  // check if there is a match between the entered booking ID and any booking ID in the database
				   	      if(bookingID == resultSet.getInt(1))
				   	      {
				   	          query = String.format("UPDATE booking SET status = 'Cancelled' WHERE booking_id = %d", bookingID); 
				   	          connectDBandCancelBooking.setQuery(query);
    		                  connectDBandCancelBooking.executeUpdate();
								
							  // format JOptionPane message
    		                  String message = String.format("Booking number %d have been cancelled.",  bookingID);
    				          JLabel dataLabel = new JLabel(message);
    				          dataLabel.setFont(new Font("Tahoma", 0, 20));
        			          dataLabel.setForeground(new Color(0, 0, 0)); 
    		               
    		                  cancelBookingField.setText(null);    // set booking id text field to null
    		                  
    		                  // print successsful cancellation of booking message to JOptionPane
				   	          JOptionPane.showMessageDialog( null, dataLabel, "SUCCESSFUL CANCELLATION", JOptionPane.INFORMATION_MESSAGE );  
				   	          
				   	          break;   //break out of the while loop if booking id was cancelled
				   	      }
				   	      
				   	      // Print out error message if booking id was not found and the last row of result set is reached
				   	      if(resultSet.isLast() == true && bookingID != resultSet.getInt(1))
				   	      {
				   	          JOptionPane.showMessageDialog( null, "Please check your booking ID and re-enter it.\n\nThe booking ID you entered is not valid for any reservation.", "ERROR", JOptionPane.ERROR_MESSAGE );
				   	      } 
				      }   
    		       }
    			}
    		}
    		catch(Exception e)
    		{
    		
    		}
    		
    		// Check if cancel booking tet field is empty and a user tries to click the cancel booking
    		if(event.getSource() == clickToCancelBooking && cancelBookingField.getText().isEmpty())
    		{
    			// format booking id message
    			String message = String.format("Please enter a booking ID. The booking ID field is empty");
    		    JLabel dataLabel = new JLabel(message);
    		    dataLabel.setFont(new Font("Tahoma", 0, 20)); // NOI18N
        		dataLabel.setForeground(new Color(0, 0, 0)); 
        		
        		// pass formatted message to JOptionPane
    			JOptionPane.showMessageDialog( null, dataLabel, "EMPTY FIELD", JOptionPane.ERROR_MESSAGE );
    		}
    	
    	}
    }
    
    public void connect()
    {
    	try 
    	{
    		connectDBandCancelBooking = new DataBaseNoTableModel();   // instantiate database connection
    	}
    	catch ( Exception sqlException )
      	{
      		// Print appropriate message to JOptionPane if database connection fails
         	JOptionPane.showMessageDialog( null, sqlException.getMessage(),
            "Database connection error", JOptionPane.ERROR_MESSAGE );

         	// ensure database connection is closed
         	connectDBandCancelBooking.close();
         	
      	} // end catch
    }
}