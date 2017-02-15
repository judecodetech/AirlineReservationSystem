/**
 * @(#)EditFlightDetails.java
 *
 *
 * @author 
 * @version 1.00 2014/9/26
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
import javax.swing.BorderFactory; 
import javax.swing.DefaultComboBoxModel; 
import javax.swing.JInternalFrame;
import java.text.SimpleDateFormat;
import java.lang.String;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.toedter.calendar.*;

@SuppressWarnings("unchecked")
public class EditFlightDetails extends JInternalFrame
{
	// instance variables
	private JTextField flightNoTextField;
	private JTextField airlineTextField;
	private JTextField sourceTextField;
	private JTextField destinationTextField;
	private JTextField departureTimeTextField;
	private JTextField arrivalTimeTextField;
	private JTextField dateTextField;
	private JTextField fareTextField;

	// instance variables
	private JComboBox flightNumberBox;
	private JComboBox sourceBox;
	private JComboBox destinationBox;
	
	// instance variables
	private JLabel flightLabel;
	private JLabel sourceLabel;
	private JLabel destinationLabel;
	
	// instance variables
	private JPanel editFlightPanel;
	private JPanel searchFlightToEditPanel;
	private JPanel emptyPanel;
    
    // instance variables
    private JButton refresh;
	private JButton update;
	private JButton searchBySourceDest;
	private JButton searchByFlightNumber;
	private JButton findFlight;
	private JButton backToAdminMenu;
	
	// instance variables
	JDateChooser chooser1 = new JDateChooser();
	JDateChooser chooser2 = new JDateChooser();

	static final String DATABASE_URL = "jdbc:mysql://localhost/ars";
   	static final String USERNAME = "ars";
   	static final String PASSWORD = "ars";
   	
   	static String query = "";
   	
   	private DataBaseNoTableModel connectDBandEditFlight;
	
	// instance variables
	int trackFlightNo = 0;
	int trackSource = 0;
    int trackDest = 0;

    public EditFlightDetails() 
    {
    	setTitle("Airline Reserrvation System                                              					Edit Flight Details");		
    	setSize(850, 610);
    	setClosable( true ); // make frame closable
    	setIconifiable( true ); // make frame minimizable   
    	
    	try
        {
           UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());           // change look of all buttons
           UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");  // Set all buttons to nimbus look
        }
        catch(Exception e)
        {}
    	
		FlightDetails flightDetail = new FlightDetails();
		
		// format panel
		searchFlightToEditPanel = new JPanel();
    	searchFlightToEditPanel.setLayout(null);
    	searchFlightToEditPanel.setBorder(BorderFactory.createTitledBorder(null, "Search using", 0, 0, new Font("Tahoma", 1, 20)));
    	searchFlightToEditPanel.setBounds(30, 30, 770, 190);
    	
    	// format panel
    	editFlightPanel = new JPanel();
    	editFlightPanel.setLayout(null);
    	editFlightPanel.setBorder(BorderFactory.createTitledBorder(null, "Edit details here", 0, 0, new Font("Tahoma", 1, 20)));
    	editFlightPanel.setBounds(30, 240, 770, 250);
    	
    	// format panel
    	emptyPanel = new JPanel();
    	emptyPanel.setLayout(null);
    	emptyPanel.setBorder(BorderFactory.createTitledBorder(null, "", 0, 0, new Font("Tahoma", 1, 25)));
    	emptyPanel.setBounds(30, 300, 500, 200);
    	
    	// format button
    	searchByFlightNumber = new JButton();
    	searchByFlightNumber.setFont(new Font("Tahoma", 0, 16)); 
        searchByFlightNumber.setForeground(new Color(0, 0, 0));
        searchByFlightNumber.setText("Flight Number");
    	searchByFlightNumber.setBounds(30, 50, 150, 30);
    	
    	// format button
    	searchBySourceDest = new JButton();
    	searchBySourceDest.setFont(new Font("Tahoma", 0, 16)); 
        searchBySourceDest.setForeground(new Color(0, 0, 0));
        searchBySourceDest.setText("Source and Destination");
    	searchBySourceDest.setBounds(200, 50, 350, 30);
    	
    	// format button    	    	
    	findFlight = new JButton();
    	findFlight.setFont(new Font("Tahoma", 0, 16)); 
        findFlight.setForeground(new Color(0, 0, 0));
        findFlight.setText("Find Flights to edit");
    	findFlight.setBounds(550, 130, 200, 30);
		
		// format label
	 	flightLabel = new JLabel();
    	flightLabel.setFont(new Font("Tahoma", 1, 14)); 
        flightLabel.setForeground(new Color(102, 153, 0));
        flightLabel.setText("Flight Number");
    	flightLabel.setBounds(30, 100, 100, 40);
    	
    	// format label
    	flightNumberBox = new JComboBox();
    	flightNumberBox.setModel(new DefaultComboBoxModel(new String[] { "--Select Flight No--"}));
 		flightNumberBox.setEditable(false);
    	flightNumberBox.setBounds(30, 130, 130, 30);
    	
    	// format label
    	sourceLabel = new JLabel();
    	sourceLabel.setFont(new Font("Tahoma", 1, 14)); 
        sourceLabel.setForeground(new Color(102, 153, 0));
        sourceLabel.setText("Source");
    	sourceLabel.setBounds(200, 100, 100, 40);
    	
    	// format Combo Box
    	sourceBox = new JComboBox();
    	sourceBox.setModel(new DefaultComboBoxModel(new String[] { "----Select City----"}));
 		sourceBox.setEditable(false);
    	sourceBox.setBounds(200, 130, 130, 30);
    	
    	// format label
    	destinationLabel = new JLabel();
    	destinationLabel.setFont(new Font("Tahoma", 1, 14));
        destinationLabel.setForeground(new Color(102, 153, 0));
        destinationLabel.setText("Destination");
    	destinationLabel.setBounds(370, 100, 100, 40);
    	
    	// format Combo Box
    	destinationBox = new JComboBox();
    	destinationBox.setModel(new DefaultComboBoxModel(new String[] { "----Select City----"}));
 		destinationBox.setEditable(false);
    	destinationBox.setBounds(370, 130, 130, 30);
		
		// format label
    	flightDetail.flightNoLabel = new JLabel();
    	flightDetail.flightNoLabel.setFont(new Font("Tahoma", 0, 14)); 
        flightDetail.flightNoLabel.setForeground(new Color(0, 0, 0));
        flightDetail.flightNoLabel.setText("Flight No");
    	flightDetail.flightNoLabel.setBounds(100, 50, 200, 40);
    	 	
    	flightNoTextField = new JTextField(20);
    	flightNoTextField.setFont(new Font("Tahoma", 0, 16)); 
    	flightNoTextField.setEditable(false);
    	flightNoTextField.setBounds(200, 60, 150, 30);
    	
    	// format label
    	flightDetail.airline = new JLabel();
    	flightDetail.airline.setFont(new Font("Tahoma", 0, 14));
        flightDetail.airline.setForeground(new Color(0, 0, 0));
        flightDetail.airline.setText("Airline");
    	flightDetail.airline.setBounds(400, 50, 200, 40);
    	
    	airlineTextField = new JTextField(20);
    	airlineTextField.setFont(new Font("Tahoma", 0, 16));
    	airlineTextField.setBounds(500, 60, 150, 30);
    	
    	// format label
    	flightDetail.source = new JLabel();
    	flightDetail.source.setFont(new Font("Tahoma", 0, 14)); 
        flightDetail.source.setForeground(new Color(0, 0, 0));
        flightDetail.source.setText("Source");
    	flightDetail.source.setBounds(100, 80, 200, 40);
    	
    	sourceTextField = new JTextField(20);
    	sourceTextField.setFont(new Font("Tahoma", 0, 16)); 
    	sourceTextField.setBounds(200, 90, 150, 30);
    	
    	// format label
    	flightDetail.destination = new JLabel();
    	flightDetail.destination.setFont(new Font("Tahoma", 0, 14)); 
        flightDetail.destination.setForeground(new Color(0, 0, 0));
        flightDetail.destination.setText("Destination");
    	flightDetail.destination.setBounds(400, 80, 200, 40);
    	
    	destinationTextField = new JTextField(20);
    	destinationTextField.setFont(new Font("Tahoma", 0, 16)); 
    	destinationTextField.setBounds(500, 90, 150, 30);
    	
    	// format label
    	flightDetail.departureTime = new JLabel();
    	flightDetail.departureTime.setFont(new Font("Tahoma", 0, 14)); 
        flightDetail.departureTime.setForeground(new Color(0, 0, 0));
        flightDetail.departureTime.setText("Departure Time");
    	flightDetail.departureTime.setBounds(100, 110, 200, 40);
    	
    	departureTimeTextField = new JTextField(20);
    	departureTimeTextField.setFont(new Font("Tahoma", 0, 16)); 
    	departureTimeTextField.setBounds(200, 120, 150, 30);
    	
    	// format label
    	flightDetail.arrivalTime = new JLabel();
    	flightDetail.arrivalTime.setFont(new Font("Tahoma", 0, 14)); 
        flightDetail.arrivalTime.setForeground(new Color(0, 0, 0));
        flightDetail.arrivalTime.setText("Arrival Time");
    	flightDetail.arrivalTime.setBounds(400, 110, 200, 40);
    	
    	arrivalTimeTextField = new JTextField(20);
    	arrivalTimeTextField.setFont(new Font("Tahoma", 0, 16)); 
    	arrivalTimeTextField.setBounds(500, 120, 150, 30);
    	
    	// format label
    	flightDetail.departureDate = new JLabel();
    	flightDetail.departureDate.setFont(new Font("Tahoma", 0, 14)); 
        flightDetail.departureDate.setForeground(new Color(0, 0, 0));
        flightDetail.departureDate.setText("Departure Date");
    	flightDetail.departureDate.setBounds(100, 140, 200, 40);
    	chooser1.setBounds(200, 150, 150, 30);
    	chooser1.setFont(new Font("Tahoma", 0, 14)); 
    	
    	// format label
    	flightDetail.arrivalDate = new JLabel();
    	flightDetail.arrivalDate.setFont(new Font("Tahoma", 0, 14)); 
        flightDetail.arrivalDate.setForeground(new Color(0, 0, 0));
        flightDetail.arrivalDate.setText("Arrival Date");
    	flightDetail.arrivalDate.setBounds(400, 140, 200, 40);
    	chooser2.setBounds(500, 150, 150, 30);
    	chooser2.setFont(new Font("Tahoma", 0, 14)); 
    	
    	// format label
    	flightDetail.fare = new JLabel();
    	flightDetail.fare.setFont(new Font("Tahoma", 0, 14)); 
        flightDetail.fare.setForeground(new Color(0, 0, 0));
        flightDetail.fare.setText("Fare");
    	flightDetail.fare.setBounds(100, 170, 200, 40);
    	
    	fareTextField = new JTextField(20);
    	fareTextField.setFont(new Font("Tahoma", 0, 16)); 
    	fareTextField.setBounds(200, 180, 150, 30);
    	
    	// format button
    	backToAdminMenu = new JButton();
    	backToAdminMenu.setFont(new Font("Tahoma", 0, 16)); 
        backToAdminMenu.setForeground(new Color(0, 0, 0));
        backToAdminMenu.setText("Back to Admin Menu");
    	backToAdminMenu.setBounds(190, 530, 200, 40);
    	
    	// format button
    	refresh = new JButton();
    	refresh.setFont(new Font("Tahoma", 0, 16)); 
        refresh.setForeground(new Color(0, 0, 0));
        refresh.setText("Refresh");
    	refresh.setBounds(450, 510, 150, 40);
    	
    	// format button
    	update = new JButton();
    	update.setFont(new Font("Tahoma", 0, 16)); 
        update.setForeground(new Color(0, 0, 0));
        update.setText("Update");
    	update.setBounds(650, 510, 150, 40);
    	
    	// add components to panel
    	searchFlightToEditPanel.add(searchByFlightNumber);
    	searchFlightToEditPanel.add(searchBySourceDest);
    	searchFlightToEditPanel.add(findFlight);
    	searchFlightToEditPanel.add(flightLabel);
    	searchFlightToEditPanel.add(flightNumberBox);
    	searchFlightToEditPanel.add(sourceLabel);
    	searchFlightToEditPanel.add(sourceBox);
    	searchFlightToEditPanel.add(destinationLabel);
    	searchFlightToEditPanel.add(destinationBox);
    	
    	// add components to panel
    	editFlightPanel.add(flightDetail.flightNoLabel);
    	editFlightPanel.add(flightNoTextField);
    	editFlightPanel.add(flightDetail.airline);
    	editFlightPanel.add(airlineTextField);
    	editFlightPanel.add(flightDetail.source);
    	editFlightPanel.add(sourceTextField);
    	editFlightPanel.add(flightDetail.destination);
    	editFlightPanel.add(destinationTextField);
    	editFlightPanel.add(flightDetail.departureTime);
    	editFlightPanel.add(departureTimeTextField);
    	editFlightPanel.add(flightDetail.arrivalTime);
    	editFlightPanel.add(arrivalTimeTextField);
    	editFlightPanel.add(flightDetail.departureDate);
    	editFlightPanel.add(flightDetail.arrivalDate);
    	editFlightPanel.add(chooser1);
    	editFlightPanel.add(chooser2);
    	editFlightPanel.add(flightDetail.fare);
    	editFlightPanel.add(fareTextField);
    	
        destinationBox.setVisible(false);
		sourceBox.setVisible(false);
		flightNumberBox.setVisible(false);
    	
    	// add components to panel
    	emptyPanel.add(refresh);
    	emptyPanel.add(update);
    	
    	// add panels to frame
    	add(searchFlightToEditPanel);
    	add(editFlightPanel);
    	add(emptyPanel);
    	
    	ButtonHandler buttonHandler = new ButtonHandler();
    	refresh.addActionListener(buttonHandler);
    	backToAdminMenu.addActionListener(buttonHandler);
    	update.addActionListener(buttonHandler);
    	findFlight.addActionListener(buttonHandler);
    	flightNumberBox.addActionListener(buttonHandler);
    	searchByFlightNumber.addActionListener(buttonHandler);
    	searchBySourceDest.addActionListener(buttonHandler);
    	 	
    }
    
    private class ButtonHandler implements ActionListener
    {

		public void actionPerformed(ActionEvent event)
    	{
    		// instance variables
    	    Date date1 = chooser1.getDate();
	  		Date date2 = chooser2.getDate();
	  		String	departDate;
	  	    String	arriveDate;
	  	    float fare = 0;
	        boolean validFlightNo;
	        boolean validFare;
	  		
    		try
    		{
    			if(event.getSource() == searchByFlightNumber)
    			{
    				resetAllFields();				
					destinationBox.setVisible(false); // set destination box to false
					sourceBox.setVisible(false);	  // set source box to false
					flightNumberBox.setVisible(true); // set flight number box to true
					sourceBox.setSelectedIndex(0);        
					destinationBox.setSelectedIndex(0);
					
					
					//int selectedFlightNo = Integer.parseInt(flightNumberBox.getSelectedItem().toString());
				    ArrayList<Integer> myColumnValues = new ArrayList<Integer>();
				   	ResultSet resultSet = null; // manages results
				   	   
				    try
				   	{  
				   	    int count = 0;
				   	      
				   	    connect();  // connect to database
				   	    	
				   	    connectDBandEditFlight.setQuery("SELECT * from flight");  // set query
				   	    connectDBandEditFlight.execute();		// execute query
				   	      
				   	    resultSet = connectDBandEditFlight.getResultSet();  // get result of query
				   	    
				   	    // loop through query result  
				   	    while(resultSet.next())
				   	    {
				   	       myColumnValues.add(resultSet.getInt(1));  // add information to array list
				   	    }
				   	    for(count = 0; count < myColumnValues.size(); count++)
				   	    {
				   	       if(trackFlightNo == myColumnValues.size())
				   	       {
				   	      	  break;  // break out of loop if the number of information in database have been reached
				   	       }  
				   	       	
				   	       Object flightNo = myColumnValues.get(count);  // get flight number
				   	       flightNumberBox.addItem(flightNo.toString());
				   	       
				   	       trackFlightNo++;  // keep track of the number of rows in the databaase
				   	    }
				   	      
					}
				   	catch ( Exception exception )
      				{
         			    JOptionPane.showMessageDialog( null, "Database error, Something went wrong", "ERROR", JOptionPane.ERROR_MESSAGE );
            			exception.printStackTrace();
      				} // end catch
    			}
    		
    		}
    		catch(Exception e)
    		{
    		
    		}
    		
    		try
    		{
    			if(event.getSource() == searchBySourceDest)
    			{	
    				resetAllFields();
					destinationBox.setVisible(true); // set destination box to false
					sourceBox.setVisible(true);	  // set source box to false
					flightNumberBox.setVisible(false); // set flight number box to true
					flightNumberBox.setSelectedIndex(0);
				
				    ArrayList<String> mySource = new ArrayList<String>();
				    ArrayList<String> myDest = new ArrayList<String>();
				    
				   	ResultSet resultSet = null; // manages results
				   	   
				   	try
				   	{  
				   	      int count = 0;
				   	     
				   	      connect();  // connect to database
				   	      
				   	      connectDBandEditFlight.setQuery("SELECT * from flight");  // set query 
				   	      connectDBandEditFlight.execute();	   // execute query
				   	      
				   	      resultSet = connectDBandEditFlight.getResultSet();  // get query result from database
				   	      
				   	      // loop through query result
				   	      while(resultSet.next())
				   	      {
				   	         mySource.add(resultSet.getString(2)); // add sources from database to array list
				   	         myDest.add(resultSet.getString(3));   // add destinations from database to array list
				   	      }
				   	      for(count = 0; count < mySource.size(); count++)
				   	      {
				   	      	 if(trackSource == mySource.size())
				   	      	 {
				   	             break;    // break out of loop if the number of information in database have been reached
				   	      	 }  
				   	      	 Object source  = mySource.get(count);  // get source
				   	         sourceBox.addItem(source.toString());
				   	         trackSource++;  // keep track of the number of sources in the database
				   	         
				   	      }
				   	      for(count = 0; count < myDest.size(); count++)
				   	      {
				   	      	 if(trackDest == myDest.size())
				   	      	 {
				   	      	    break;   // break out of loop if the number of information in database have been reached
				   	      	 }
				   	      	 Object dest = myDest.get(count);  // get destination
				   	         destinationBox.addItem(dest.toString());  
				   	         trackDest++;  // keep track of the number of destinations in the database
				   	      }
				   	      
				   	   }
				   	   catch ( Exception exception )
      				   {
         			    JOptionPane.showMessageDialog( null, "Database error, Something went wrong", "ERROR", JOptionPane.ERROR_MESSAGE );
            			 exception.printStackTrace();
      				   } // end catch
    			}
    		}
    		catch(Exception e)
    		{
    		
    		}
    		
    		try
    		{
    	    	boolean found = false;  // set found to false
    	    		
    			if(event.getSource() == findFlight && flightNumberBox.getSelectedIndex() > 0)
    			{
    				found = true;  // set found to true if a flight number was selected for editing
    				
    				int selectedFlightNo = Integer.parseInt(flightNumberBox.getSelectedItem().toString());
    				ResultSet resultSet = null; // manages results
    					
    				connect();   // connect to database
    				
    				// set query message
    				query = String.format("SELECT * from flight where flight_no = %d", selectedFlightNo);
    				connectDBandEditFlight.setQuery(query);
				   	connectDBandEditFlight.execute();
				   	      
    				resultSet = connectDBandEditFlight.getResultSet();  // get query result from database
				   	
				   	// loop through query result      
				   	while(resultSet.next())
				   	{
				   		// populate text fields with selected flight number and its corresponding information
				   	    flightNoTextField.setText( String.valueOf(resultSet.getInt(1)) );
				   	    sourceTextField.setText( resultSet.getString(2) );
				   	   	destinationTextField.setText( resultSet.getString(3) ); 
				   	   	chooser1.setDate( resultSet.getDate(4) );
				   	  	chooser2.setDate( resultSet.getDate(5) );
				   	  	departureTimeTextField.setText( resultSet.getString(6) );
				   	   	arrivalTimeTextField.setText( resultSet.getString(7) );
				   	   	airlineTextField.setText( resultSet.getString(8) );
				   	   	fareTextField.setText( String.valueOf(resultSet.getDouble(9)) );
				   	}				 
				   	   
    			}
    		
    		}
    		catch(Exception e)
    		{
    		
    		}
    		
    		try
    		{
    		    if(event.getSource() == findFlight && sourceBox.getSelectedIndex() > 0 && destinationBox.getSelectedIndex() > 0)
    			{
    				String selectedSource = sourceBox.getSelectedItem().toString();   
    				String selectedDest= destinationBox.getSelectedItem().toString();
    				
    				ResultSet resultSet = null; // manages results
    					
    				connect();  // connect to database
    				
    				// set query message
    				query = String.format("SELECT * from flight where source = '%s' AND destination = '%s'", 
    					     selectedSource, selectedDest);
    					     
    				connectDBandEditFlight.setQuery(query);  // set query
				   	connectDBandEditFlight.execute();   // execute query
				   	      
    				resultSet = connectDBandEditFlight.getResultSet();  // get query result from database
				   	
				   	// loop through query result      
				   	while(resultSet.next())
				   	{
				   	   // checking if selected source and destination match is founds in database
				   	   if(resultSet.getString(2).equalsIgnoreCase(selectedSource) && resultSet.getString(3).equalsIgnoreCase(selectedDest))
				   	   {
				   	   	   // populate text fields with selected source and destination and their corresponding information
				   	       flightNoTextField.setText( String.valueOf(resultSet.getInt(1)) );
				   	   	   sourceTextField.setText( resultSet.getString(2) );
				   	   	   destinationTextField.setText( resultSet.getString(3) ); 
				   	   	   chooser1.setDate( resultSet.getDate(4) );
				   	  	   chooser2.setDate( resultSet.getDate(5) );
				   	  	   departureTimeTextField.setText( resultSet.getString(6) );
				   	   	   arrivalTimeTextField.setText( resultSet.getString(7) );
				   	   	   airlineTextField.setText( resultSet.getString(8) );
				   	   	   fareTextField.setText( String.valueOf(resultSet.getDouble(9)) );
				   	   }

				   	}
				   	// check if a matching source and destination information was not found   
				   	if(resultSet.getString(2).compareToIgnoreCase(selectedSource) != 0 && resultSet.getString(3).compareToIgnoreCase(selectedDest) != 0)
				   	{
				   	       JOptionPane.showMessageDialog( null, "The selected source and destination combination is not available.", 
				   	       	   "ERROR", JOptionPane.ERROR_MESSAGE );
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
    		
    		try
    		{
    			if(event.getSource() == refresh)
    			{
				    resetAllFields();
    			}
    		
    		}
    		catch(Exception e)
    		{
    		
    		}
    		
    		try
    		{   
    			// date formats
    			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-M-dd");  
 	    		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-M-dd");
 	    		
    			if(event.getSource() == update && flightNumberBox.getSelectedIndex() > 0)
    			{
    				departDate = sdf1.format(date1.getTime());  // get formatted date
	   				arriveDate = sdf2.format(date2.getTime());  // get formatted date
	   				
                    ValidateInput validate = new ValidateInput();
                    
                    // validate airline
                    if(!validate.validateAirline(airlineTextField.getText()))
                    {
                        JOptionPane.showMessageDialog( null,"Sorry the entered airline is invalid",
                			"Invalid airline",JOptionPane.ERROR_MESSAGE);
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
                    
                    // validate time
                    if(validate.Time12HoursValidator(departureTimeTextField.getText()) == false || validate.Time12HoursValidator(arrivalTimeTextField.getText()) == false)
                    {
                    	JOptionPane.showMessageDialog( null,"Sorry invalid time format.\n\n Time format 12hours. 1:00 PM or AM",
                			"Invalid time",JOptionPane.ERROR_MESSAGE);
                    }
                    
                    // validate source
                    if(!validate.validateSource(sourceTextField.getText()))
                    {
                        JOptionPane.showMessageDialog( null,"Sorry invalid source name",
                			"Invalid source",JOptionPane.ERROR_MESSAGE);
                    }
                    
                    // validate destination
                    if(!validate.validateDestination(destinationTextField.getText()))
                    {
                        JOptionPane.showMessageDialog( null,"Sorry invalid destination name",
                			"Invalid destination",JOptionPane.ERROR_MESSAGE);
                    }
                    
      				try
                    { 
					   fare = Float.parseFloat(fareTextField.getText());
					   validFare = true;
                    }
                    catch(NumberFormatException e)
      				{
                       JOptionPane.showMessageDialog( null,"Sorry invalid fare. Must be numeric or decimal.\n\n e.g 1000.00 or 2000",
                		   "Invalid flight number",JOptionPane.ERROR_MESSAGE);
                	   validFare = false; // set valid fare to false if the entered fare is not numeric
      				}
	   				
	   				// checking if all data are valid
	   				if(validate.validateAirline(airlineTextField.getText()) && validate.Time12HoursValidator(departureTimeTextField.getText()) == true && 
                        validate.Time12HoursValidator(arrivalTimeTextField.getText()) == true && validate.validateSource(sourceTextField.getText()) && 
                    	   validate.validateSource(destinationTextField.getText()) && validFare == true && !arriveDate.isEmpty() &&
                    	   	!departDate.isEmpty())
                    {
                        try
	 					{
                            connect();  // connect to database
				    		
				    		// set query message
				    		query = String.format( "UPDATE flight SET source = '%s', destination = '%s', depart = '%s',arrive = '%s'," + 
				    			"depart_time = '%s', arrive_time = '%s', airline = '%s', fare = %f WHERE flight_no = %d", 
				    			sourceTextField.getText(), destinationTextField.getText(), departDate, arriveDate,
				        		departureTimeTextField.getText(), arrivalTimeTextField.getText(), airlineTextField.getText(), 
				        		Double.parseDouble(fareTextField.getText()), Integer.parseInt(flightNoTextField.getText()) );
				    
				    		connectDBandEditFlight.setQuery(query);  // set query 
				    		connectDBandEditFlight.executeUpdate();   // execute query
				    		connectDBandEditFlight.setQuery("commit");  // commit 
				    		connectDBandEditFlight.execute();  // execute commit command
				    
				    		JOptionPane.showMessageDialog( null,"Your update has been successfully completed",
                				"Update Complete",JOptionPane.INFORMATION_MESSAGE);
	 					}
                		catch ( Exception sqlException )
      					{
         			    	JOptionPane.showMessageDialog( null, "Database error, Something went wrong", "ERROR", JOptionPane.ERROR_MESSAGE );
            			 		sqlException.printStackTrace();
      					} // end catch
      				
				  		finally
				   		{
				       		connectDBandEditFlight.close();  // close database
				       		resetAllFields();
				   		} 
                    }
				  

    			}
    		
    		}
    		catch(Exception e)
    		{
    		
    		}
    		
    		try
    		{   
    			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-M-dd");  // date format
 	    		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-M-dd");  // date format
 	    		
 	    		
    			if(event.getSource() == update && sourceBox.getSelectedIndex() > 0 && destinationBox.getSelectedIndex() > 0)
    			{
    				departDate = sdf1.format(date1.getTime());  // get formatted date
	   				arriveDate = sdf2.format(date2.getTime());  // get formatted date
	   				
                    ValidateInput validate = new ValidateInput();
                    
                    // validate airline
                    if(!validate.validateAirline(airlineTextField.getText()))
                    {
                        JOptionPane.showMessageDialog( null,"Sorry the entered airline is invalid",
                			"Invalid airline",JOptionPane.ERROR_MESSAGE);
                    }
                    
                    // validate time
                    else if(validate.Time12HoursValidator(departureTimeTextField.getText()) == false || validate.Time12HoursValidator(arrivalTimeTextField.getText()) == false)
                    {
                    	JOptionPane.showMessageDialog( null,"Sorry invalid time format.\n\n Time format 12hours. 1:00 PM or AM",
                			"Invalid time",JOptionPane.ERROR_MESSAGE);
                    }
                    
                    // validate source
                    if(!validate.validateSource(sourceTextField.getText()))
                    {
                        JOptionPane.showMessageDialog( null,"Sorry invalid source name",
                			"Invalid source",JOptionPane.ERROR_MESSAGE);
                    }
                    
                    // validate destination
                    if(!validate.validateDestination(destinationTextField.getText()))
                    {
                        JOptionPane.showMessageDialog( null,"Sorry invalid destination name",
                			"Invalid destination",JOptionPane.ERROR_MESSAGE);
                    }
                    
      				try
                    { 
					   fare = Float.parseFloat(fareTextField.getText());
					   validFare = true;
                    }
                    catch(NumberFormatException e)
      				{
                       JOptionPane.showMessageDialog( null,"Sorry invalid fare. Must be numeric or decimal.\n\n e.g 1000.00 or 2000",
                		   "Invalid flight number",JOptionPane.ERROR_MESSAGE);
                	   validFare = false;  // set valid fare to false if the entered fare is not numeric
      				}
      				
      				// checking to make sure all data has are valid
      				if(validate.validateAirline(airlineTextField.getText()) && validate.Time12HoursValidator(departureTimeTextField.getText()) == true && 
                        validate.Time12HoursValidator(arrivalTimeTextField.getText()) == true && validate.validateSource(sourceTextField.getText()) && 
                    	   validate.validateSource(destinationTextField.getText()) && validFare == true )
                    {
                        try
	 					{
                            connect();  // connect to database
				    	
				    		// set query message
				    		query = String.format( "UPDATE flight SET source = '%s', destination = '%s', depart = '%s',arrive = '%s'," + 
				    			"depart_time = '%s', arrive_time = '%s', airline = '%s', fare = %f WHERE source = '%s' AND destination = '%s'", 
				    			sourceTextField.getText(), destinationTextField.getText(), departDate, arriveDate,
				        		departureTimeTextField.getText(), arrivalTimeTextField.getText(), airlineTextField.getText(), 
				        		Double.parseDouble(fareTextField.getText()), sourceBox.getSelectedItem().toString(), destinationBox.getSelectedItem().toString());
				     
				    		connectDBandEditFlight.setQuery(query);  // set query
				    		connectDBandEditFlight.executeUpdate();  // execute update
				    		connectDBandEditFlight.setQuery("commit");  // commit data
				    		connectDBandEditFlight.execute();   // execute commit
				    
				    		JOptionPane.showMessageDialog( null,"Your update has been successfully completed",
                				"Update Complete",JOptionPane.INFORMATION_MESSAGE);
                    
	 					}
                		catch ( Exception sqlException )
      					{
         			    	JOptionPane.showMessageDialog( null, "Database error, Something went wrong", "ERROR", JOptionPane.ERROR_MESSAGE );
            			 		sqlException.printStackTrace();
      					} // end catch
      				
				  		finally
				   		{
				       		connectDBandEditFlight.close();
				       		resetAllFields();
				   		} 
                    }
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
    		connectDBandEditFlight = new DataBaseNoTableModel();
    	}
    	catch ( Exception sqlException )
      	{
         	JOptionPane.showMessageDialog( null, sqlException.getMessage(),
            "Database connection error", JOptionPane.ERROR_MESSAGE );

         	// ensure database connection is closed
         	connectDBandEditFlight.close();
      	} // end catch
    }
    public void resetAllFields()
    {
    	flightNoTextField.setText(null);
        sourceTextField.setText(null);
        destinationTextField.setText(null);
        airlineTextField.setText(null);
        departureTimeTextField.setText(null);
        arrivalTimeTextField.setText(null);
        fareTextField.setText(null);
        chooser1.setCalendar(null);
        chooser2.setCalendar(null);
        flightNumberBox.setSelectedIndex(0);
        sourceBox.setSelectedIndex(0);  
        destinationBox.setSelectedIndex(0);  
    }
    
}