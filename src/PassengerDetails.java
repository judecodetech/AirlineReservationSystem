/**
 * @(#)PassengerDetails.java
 *
 *
 * @author 
 * @version 1.00 2014/10/19
 */
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
import javax.swing.UIManager;
import javax.swing.JInternalFrame;
import javax.swing.JTable; 
import javax.swing.JScrollPane;
import java.sql.SQLException;

public class PassengerDetails extends JInternalFrame
{
	
    static final String DATABASE_URL = "jdbc:mysql://localhost/ars";   // database URL
   	static final String USERNAME = "ars";    // database username
   	static final String PASSWORD = "ars";    // database password
   	
   	// database query to execute
/*    static String DEFAULT_QUERY = String.format("SELECT customer.cust_id, customer.cust_title," +
												"customer.cust_fname,customer.cust_title, customer.cust_surname," + 
												"customer.nationality, customer.passport_no," + 
												"customer_contact.contact_fname, customer_contact.contact_surname," +
												"customer_contact.contact_email, customer_contact.contact_phone," +
												"booking.booking_id, booking.class, booking.status, flight.flight_no," +
												"flight.source, flight.destination, flight.depart, flight.depart_time," +
												"flight.airline, payment.payment_id, payment.payment_method," +
												"payment.name_of_card_holder, payment.card_number, payment.payment_date," +
												"payment.payment_amount from customer INNER JOIN customer_booking " +
												"ON customer.cust_id = customer_booking.cust_id INNER JOIN customer_contact " +
												"ON customer.contact_id = customer_contact.contact_id INNER JOIN booking " +
												"ON booking.booking_id = customer_booking.booking_id INNER JOIN flight " +
												"ON booking.flight_no = flight.flight_no INNER JOIN payment ON " +
												"booking.booking_id = payment.booking_id ");   */
										
      	// database query to execute
    static String DEFAULT_QUERY = String.format("SELECT customer.cust_fname, customer.cust_surname," + 
												"customer.nationality," +
												"customer_contact.contact_email," +
												"booking.booking_id, booking.class, booking.status, flight.flight_no," +
												"flight.source, flight.destination, flight.depart_time," +
												"flight.airline, payment.payment_method," +
												"payment.payment_amount from customer INNER JOIN customer_booking " +
												"ON customer.cust_id = customer_booking.cust_id INNER JOIN customer_contact " +
												"ON customer.contact_id = customer_contact.contact_id INNER JOIN booking " +
												"ON booking.booking_id = customer_booking.booking_id INNER JOIN flight " +
												"ON booking.flight_no = flight.flight_no INNER JOIN payment ON " +
												"booking.booking_id = payment.booking_id ");
  
  
   
    ResultSetTableModel tableModel;                // create an instance to table model class
   	JTable resultTable = new JTable(tableModel);   // create table and add table model to it
   	
   	JScrollPane scrollPane;   // scroll pane variable
    
    public PassengerDetails() 
    {
    	setTitle("Airline Reserrvation System                                              					All Passengers"); 
    	setSize(1350, 500);     // set size of internal frame
    	setClosable( true );    // make frame closable
    	setIconifiable( true ); // make frame minimizable
    	
    	try
        {
           UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());           // change look of all buttons
           UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");  // Set all buttons to nimbus look
        }
        catch(Exception e)
        {}
        
        try
    	{	
    		// instantiate table model and pass necessary information via the constructor
    	     tableModel = new ResultSetTableModel( DATABASE_URL,
    			USERNAME, PASSWORD, DEFAULT_QUERY );
    	}
    	catch( SQLException sqlException )
    	{
    			JOptionPane.showMessageDialog( null, sqlException.getMessage(),
            "Database connection error", JOptionPane.ERROR_MESSAGE );
    	}
    	 
    	resultTable.setModel(tableModel);    // add table model to table
    	resultTable.setShowGrid( true );     
        scrollPane = new JScrollPane( resultTable );   // add table to scroll pane 
    	//scrollPane.setBounds(0, 20, 840, 145);
    	scrollPane.setVisible( true );      // make scroll pane visible
        
        add(scrollPane);   // add scroll pane to internal frame
    	  
    }
}