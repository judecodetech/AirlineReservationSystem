/*
 * @(#)AddFlightDetails.java
 *
 *
 * @author 
 * @version 1.00 2014/9/26
 */
//package com.deitel.ch17; // packaged for reuse

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
import java.util.Date;
import java.text.SimpleDateFormat;
import java.sql.*;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.toedter.calendar.*;

@SuppressWarnings("unchecked")
public class AddFlightDetails extends JInternalFrame
{
	// instanace variables
	private JTextField flightNoField;	   
	private JTextField airlineField;
	private JTextField sourceField;
	private JTextField destinationField;
	private JTextField departureTimeField;
	private JTextField arrivalTimeField;
	private JTextField fareField;
	
	private JButton addFlight;
	private JButton backToAdminMenu;
	
	private JPanel addFlightPanel;
	
	JDateChooser chooser1 = new JDateChooser();   // jcalendar
	JDateChooser chooser2 = new JDateChooser();   // jcalendar
	
   	static  String query = "";    // query variable

   	private DataBaseNoTableModel connectDBandAddFlight;   /// database connection variable
	
    public AddFlightDetails() 
    {
    	setTitle("Airline Reserrvation System                                              					Add Flight Details"); 
    	setSize(800, 500);   // set size of internal frame
    	setClosable( true ); // make frame closable
    	setIconifiable( true ); // make frame minimizable  
    		
    	FlightDetails flight = new FlightDetails();    // instantiate parent class
   		
    	try
        {
           UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());           // change look of all buttons
           UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");  // Set all buttons to nimbus look
        }
        catch(Exception e)
        {}

		// Format Panel
    	addFlightPanel = new JPanel();
    	addFlightPanel.setLayout(null);
    	addFlightPanel.setBorder(BorderFactory.createTitledBorder(null, "Add details here", 0, 0, new Font("Tahoma", 1, 25)));
    	addFlightPanel.setBounds(30, 20, 500, 200);
    	
    	// Format Label
    	flight.flightNoLabel = new JLabel();
    	flight.flightNoLabel.setFont(new Font("Tahoma", 0, 16)); // set font
        flight.flightNoLabel.setForeground(new Color(0, 0, 0));
        flight.flightNoLabel.setText("Flight No");
    	flight.flightNoLabel.setBounds(50, 70, 200, 40);  
    	 	
    	flightNoField = new JTextField(20);
    	flightNoField.setFont(new Font("Tahoma", 0, 16)); // set font
    	flightNoField.setBounds(170, 80, 150, 30);
    	
    	// Format Label
    	flight.airline = new JLabel();
    	flight.airline.setFont(new Font("Tahoma", 0, 16)); // set font
        flight.airline.setForeground(new Color(0, 0, 0));
        flight.airline.setText("Airline");
    	flight.airline.setBounds(430, 70, 200, 40);
    	
    	airlineField = new JTextField(20);
    	airlineField.setFont(new Font("Tahoma", 0, 16)); // set font
    	airlineField.setBounds(550, 80, 150, 30);
    	
    	// Format Label
    	flight.source = new JLabel();
    	flight.source.setFont(new Font("Tahoma", 0, 16)); // set font
        flight.source.setForeground(new Color(0, 0, 0));
        flight.source.setText("Source");
    	flight.source.setBounds(50, 150, 200, 40);
    	
    	sourceField = new JTextField(20);
    	sourceField.setFont(new Font("Tahoma", 0, 16)); // set font
    	sourceField.setBounds(170, 160, 150, 30);
    	
    	// Format Label
    	flight.destination = new JLabel();
    	flight.destination.setFont(new Font("Tahoma", 0, 16)); // set font
        flight.destination.setForeground(new Color(0, 0, 0));
        flight.destination.setText("Destination");
    	flight.destination.setBounds(430, 150, 200, 40);
    	
    	destinationField = new JTextField(20);
    	destinationField.setFont(new Font("Tahoma", 0, 16)); // set font
    	destinationField.setBounds(550, 160, 150, 30);
    	
    	// Format Label
    	flight.departureTime = new JLabel();
    	flight.departureTime.setFont(new Font("Tahoma", 0, 16)); // set font
        flight.departureTime.setForeground(new Color(0, 0, 0));
        flight.departureTime.setText("Departure Time");
    	flight.departureTime.setBounds(50, 230, 200, 40);
    	
    	departureTimeField = new JTextField(20);
    	departureTimeField.setFont(new Font("Tahoma", 0, 16)); // set font
    	departureTimeField.setBounds(170, 240, 150, 30);
    	
    	// Format Label
    	flight.arrivalTime = new JLabel();
    	flight.arrivalTime.setFont(new Font("Tahoma", 0, 16)); // set font
        flight.arrivalTime.setForeground(new Color(0, 0, 0));
        flight.arrivalTime.setText("Arrival Time");
    	flight.arrivalTime.setBounds(430, 230, 200, 40);
    	
    	arrivalTimeField = new JTextField(20);
    	arrivalTimeField.setFont(new Font("Tahoma", 0, 16)); // set font
    	arrivalTimeField.setBounds(550, 240, 150, 30);
    	
    	// Format Label
    	flight.departureDate = new JLabel();
    	flight.departureDate.setFont(new Font("Tahoma", 0, 16)); // set font
        flight.departureDate.setForeground(new Color(0, 0, 0));
        flight.departureDate.setText("Departure Date");
    	flight.departureDate.setBounds(50, 310, 200, 40);
    	chooser1.setBounds(170, 320, 150, 30);
    	
    	// Format Label
    	flight.arrivalDate = new JLabel();
    	flight.arrivalDate.setFont(new Font("Tahoma", 0, 16)); // set font
        flight.arrivalDate.setForeground(new Color(0, 0, 0));
        flight.arrivalDate.setText("Arrival Date");
    	flight.arrivalDate.setBounds(430, 310, 200, 40);
    	chooser2.setBounds(550, 320, 150, 30);
    	
    	// Format Label
    	flight.fare = new JLabel();
    	flight.fare.setFont(new Font("Tahoma", 0, 16)); // set font
        flight.fare.setForeground(new Color(0, 0, 0));
        flight.fare.setText("Fare");
    	flight.fare.setBounds(50, 380, 200, 40);
    	
    	fareField = new JTextField(20);
    	fareField.setFont(new Font("Tahoma", 0, 16)); // set font
    	fareField.setBounds(170, 390, 150, 30);
    	
    	// Format Label
    	addFlight = new JButton();
    	addFlight.setFont(new Font("Tahoma", 0, 16)); // set font
        addFlight.setForeground(new Color(0, 0, 0));
        addFlight.setText("add Flight");
    	addFlight.setBounds(550, 400, 150, 40);
    	
    	backToAdminMenu = new JButton();
    	backToAdminMenu.setFont(new Font("Tahoma", 0, 16)); // set font
        backToAdminMenu.setForeground(new Color(0, 0, 0));
        backToAdminMenu.setText("Back to Admin Menu");
    	backToAdminMenu.setBounds(200, 400, 200, 40);
    	
    	// add components to panel
    	addFlightPanel.add(flight.flightNoLabel);
    	addFlightPanel.add(flightNoField);
    	addFlightPanel.add(flight.airline);
    	addFlightPanel.add(airlineField);
    	addFlightPanel.add(flight.source);
    	addFlightPanel.add(sourceField);
    	addFlightPanel.add(flight.destination);
    	addFlightPanel.add(destinationField);
    	addFlightPanel.add(flight.departureTime);
    	addFlightPanel.add(departureTimeField);
    	addFlightPanel.add(flight.arrivalTime);
    	addFlightPanel.add(arrivalTimeField);
    	addFlightPanel.add(flight.departureDate);
   		addFlightPanel.add(flight.arrivalDate);
   		addFlightPanel.add(chooser1);
    	addFlightPanel.add(chooser2);
    	addFlightPanel.add(flight.fare);
    	addFlightPanel.add(fareField);
    	addFlightPanel.add(addFlight);
    	
    	add(addFlightPanel);   // add panel to frame
    	
    	ButtonHandler buttonHandler = new ButtonHandler();
    
    	// add buttons to listener
    	addFlight.addActionListener(buttonHandler);
    	backToAdminMenu.addActionListener(buttonHandler);
	
    }
    
    private class ButtonHandler implements ActionListener
    {
		public void actionPerformed(ActionEvent event)
    	{
    		// private instance variables
    		int flightNo = 0;
	 		String source;
 	  	    String dest;
	  		Date date1 = chooser1.getDate();
	  		Date date2 = chooser2.getDate();
	  		String	departDate;
	  	    String	arriveDate;
	        String	departTime;
	        String	arriveTime;
	        String	airline;
	        float fare = 0;
	        
	        boolean validFlightNo;   // variable to check if flight number is valid
	        boolean validFare;       // variable to check if fare is valid
	        
    		try
    		{	
    			// format dates	
    			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-M-dd"); 
 	    		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-M-dd");
 	    		
 	    		// get component information
 	    		departTime = departureTimeField.getText();
	   			arriveTime = arrivalTimeField.getText();
	   			source = sourceField.getText();	
	   			dest = destinationField.getText();
 	    		departDate = sdf1.format(date1.getTime());
	   			arriveDate = sdf2.format(date2.getTime());
	   			airline = airlineField.getText();
	   			
	   			boolean flightNumberIntegrityPassed = false;   // variable to check if flight number is already assisgned in the database
	   			
	   				
    			if(event.getSource() == addFlight)
    			{
                    ValidateInput validate = new ValidateInput();   // instantiate validation class
                    
                    // check if airline is valid
                    if(!validate.validateAirline(airlineField.getText()))
                    {
                        JOptionPane.showMessageDialog( null,"Sorry the entered airline is invalid",
                			"Invalid airline",JOptionPane.ERROR_MESSAGE);
                    }
                    
                    // check if time is valid
                    if(validate.Time12HoursValidator(departTime) == false || validate.Time12HoursValidator(arriveTime) == false)
                    {
                    	JOptionPane.showMessageDialog( null,"Sorry invalid time format.\n\n Time format 12hours. 1:00 PM or AM",
                			"Invalid time",JOptionPane.ERROR_MESSAGE);
                    }
                    
                    // check if source is valid
                    if(!validate.validateSource(source))
                    {
                        JOptionPane.showMessageDialog( null,"Sorry invalid source name",
                			"Invalid source",JOptionPane.ERROR_MESSAGE);
                    }
                    
                     // check if source is empty
                    if(departDate.isEmpty())
                    {
                        JOptionPane.showMessageDialog( null,"Please pick a date. Click the icon next to the date field",
                			"Invalid date",JOptionPane.ERROR_MESSAGE);
                    }
                    
                     // check if date is empty
                    if(arriveDate.isEmpty())
                    {
                        JOptionPane.showMessageDialog( null,"Please pick a date. Click the icon next to the date field",
                			"Invalid date",JOptionPane.ERROR_MESSAGE);
                    }
                    
                    // check if destination is valid
                    if(!validate.validateDestination(dest))
                    {
                        JOptionPane.showMessageDialog( null,"Sorry invalid destination name",
                			"Invalid destination",JOptionPane.ERROR_MESSAGE);
                    }
                    
                    try
                    {                   	
                       flightNo = Integer.parseInt(flightNoField.getText());   // parse flight number
                       
                       // making sure flight number does not go below 5001 or exceed 10000
                       if(flightNo < 5001 || flightNo > 10000)
                       {
                          JOptionPane.showMessageDialog( null,"Sorry invalid flight number.\nMust be between 5001 and 10000, and must be numeric",
           	                 "Invalid flight number",JOptionPane.ERROR_MESSAGE);
           	              validFlightNo = false;    // false means flight number us invalid 
                       }
                       validFlightNo = true;   // true means flight number is valid

				 	   ResultSet resultSet = null; // manages results
    					
    				   connect();  // connect to database
    				
    				   query = String.format("SELECT * from flight");  // set query message
    					     
    				   connectDBandAddFlight.setQuery(query);  // set query
				   	   connectDBandAddFlight.execute();  // execute query
				   	 
    				   resultSet = connectDBandAddFlight.getResultSet();  // get result of query from database
    				   	
    				   flightNumberIntegrityPassed = true;  // set varable to true 
				   	      
				   	   while(resultSet.next())
				   	   {
                       	  if(flightNo == resultSet.getInt(1))  // checek if flight number is found is in database
                       	  {
                       	     JOptionPane.showMessageDialog( null,"Sorry this flight number is already used by another flight. Please enter a new flight number",
           	                 "Invalid flight number",JOptionPane.ERROR_MESSAGE);
           	                 
           	                 flightNumberIntegrityPassed = false;  // set variable to false if flight number was found in database
           	                 
           	                 break;  // break out of the loop so that the flight number can be re-entered
                       	  } 

                       }
                       
                    }
                    catch(NumberFormatException e)
      				{
      				    validFlightNo = false;  // set varible to false if flight number was invalid
                        JOptionPane.showMessageDialog( null,"Sorry invalid flight number.\nMust be between 5001 and 10000, and must be numeric",
           	                 "Invalid flight number",JOptionPane.ERROR_MESSAGE);
      				}
      				   
      				try
                    { 
					    fare = Float.parseFloat(fareField.getText());   // parse fare
					    validFare = true;   // set variable to true
                    }
                    catch(NumberFormatException e)
      				{
                        JOptionPane.showMessageDialog( null,"Sorry invalid fare. Must be numeric or decimal.\n\n e.g 1000.00 or 2000",
                		"Invalid flight number",JOptionPane.ERROR_MESSAGE);
                	    validFare = false;   // set variable to false if the entered fare is invalid
      				}
      				
      				// check if all fields have been validated
                    if(validate.validateAirline(airlineField.getText()) && validate.Time12HoursValidator(departTime) == true && 
                    	validate.Time12HoursValidator(arriveTime) == true && validate.validateSource(source) && validFare == true &&
                    	validate.validateSource(dest) && validFlightNo == true && flightNumberIntegrityPassed == true && !departDate.isEmpty()
                    	&& !arriveDate.isEmpty())
                    {
                    	try
	 					{
				       		connect();   // connect to database
	 						
	 						// set query message
                        	String query = String.format("insert into flight(flight_no, source, destination, depart, arrive, depart_time, arrive_time, airline, fare)" + 
                           		"VALUES (%d, '%s', '%s', '%s', '%s', '%s', '%s', '%s', %.2f)", flightNo, 
                           	source, dest, departDate, arriveDate, departTime, arriveTime, airline, fare);

                			connectDBandAddFlight.setQuery(query);  // set query
                			connectDBandAddFlight.executeUpdate();  // execute query
                			connectDBandAddFlight.setQuery("commit");  // commit insert
                			connectDBandAddFlight.executeUpdate();   // execute commit
                		
                			JOptionPane.showMessageDialog( null,"A new flight has\nsuccessfully been added!",
                				" Update Complete",JOptionPane.PLAIN_MESSAGE);
	 					}
                		catch ( Exception sqlException )
      					{
         			    	JOptionPane.showMessageDialog( null, "Database error, Something went wrong", "ERROR", JOptionPane.ERROR_MESSAGE );
            			 		sqlException.printStackTrace();
      					} // end catch
      				
				  		finally
				   		{
				       		connectDBandAddFlight.close();   // make sure database is closed
				       		clearFieldsAfterFlightAdded();    // clear all text fields
				   		} 
                    }	
    			} 
    		}
    		catch(Exception e)
    		{
    		
    		}
    		
    		try
    		{
    			if(event.getSource() == backToAdminMenu)
    			{
				   	// Create application frame.
      			    Admin admin = new Admin();
      			    setVisible(false);
    			}
    		}
    		catch(Exception e)
    		{
    		
    		}
    	}
    }
    
    public void connect()
    {
    	try
    	{
    		connectDBandAddFlight = new DataBaseNoTableModel();
    	}
    	catch ( Exception sqlException )
      	{
         	JOptionPane.showMessageDialog( null, sqlException.getMessage(),
            "Database connection error", JOptionPane.ERROR_MESSAGE );

         	// ensure database connection is closed
         	connectDBandAddFlight.close();
      	} // end catch
    }
    
    public void clearFieldsAfterFlightAdded()
    {
        flightNoField.setText(null);
        airlineField.setText(null);
        sourceField.setText(null);
        destinationField.setText(null);
        departureTimeField.setText(null);
        arrivalTimeField.setText(null);
        chooser1.setCalendar(null);
        chooser2.setCalendar(null);
        fareField.setText(null);
    }
    
}