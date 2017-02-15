/**
 * @(#)CustomerFlightSearch.java
 *
 *
 * @author 
 * @version 1.00 2014/9/18
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
import javax.swing.JTable; 
import java.sql.SQLException;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.ScrollPaneConstants;
import java.lang.String;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

import com.toedter.calendar.*;

@SuppressWarnings("unchecked")
public class CustomerFlightSearch extends JFrame
{
	// instance variables
	private JLabel origin;
	private JLabel destination;
	private JLabel adults;
	private JLabel children;
	private JLabel selectAirline;
	private JLabel selectClass;
	private JLabel depart;
	private JLabel arrive;
	private JLabel flightNo;
	private JLabel departureTime;
	private JLabel arrivalTime;
	private JLabel fare;
	private JLabel instructions;
	private JLabel instruction1;
	private JLabel instruction2;
	private JLabel instruction3;
	private JLabel subMenuTitle;
	private JRadioButton returnOption;
	private JRadioButton oneWay;
	private JButton findFlight;
	private JButton bookFlight;
	private JButton clearFields;
	private JButton exitToMainMenu;
	private JComboBox originBox;
	private JComboBox destinationBox;
	private JComboBox adultBox;
	private JComboBox childrenBox;
	private JComboBox airlineBox;
	private JComboBox classBox;
	private JComboBox departBox;
	private JComboBox arriveBox;
	private JTextField adultField;
    private JLabel arrowLabel;
    private JPanel availableFlightPanel;
    private JTextField childrenField;
    private JLabel classLabel;
    private JLabel dateOfFlight;
    private ButtonGroup groupRadioButtons;
    
    private JLabel message1;
    private JLabel message2;
    
    private JPanel searchFlightPanel;
	private JLabel pictureLabel;
	private Icon pictureIcon;
	
	DesignedPanel searchPanel = new DesignedPanel("");
	DesignedPanel detailsPanel = new DesignedPanel("");
	DesignedPanel generalPanel = new DesignedPanel("");
	
    static final String DATABASE_URL = "jdbc:mysql://localhost/ars";
   	static final String USERNAME = "ars";
   	static final String PASSWORD = "ars";
   	static  String query = "";
   	
    static String DEFAULT_QUERY = "SELECT * FROM flight";

    ResultSetTableModel tableModel;
   
    JTable resultTable = new JTable(tableModel);    // instantiate JTable
    private DataBaseNoTableModel connectDBandSearch;
   	
   	JScrollPane scrollPane;
   	
    ArrayList<String> originData = new ArrayList<String>();       // origin data arrayList
    ArrayList<String> destinationData = new ArrayList<String>();  //destination data arrayList
   	ArrayList<String> airlineData = new ArrayList<String>();      //airline data arrayList
   	String[] departData = { "----Select departure date----"};	  
    String[] arriveData = { "----Select departure date----"};   
    	
    JDateChooser chooser1 = new JDateChooser();

    public CustomerFlightSearch() 
    {
     	setTitle("Airline Reserrvation System                                               Flight Search");  // set title
    	setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);   
    	setSize(900, 630);   // set size of frame
    	setResizable(false);    // make frame non-resizable
    	setVisible(true);       // set visbility of frame to false
    	setLocationRelativeTo(null);   // make the frame apear at the centre of the screen

        // instantiate all components
        destination = new JLabel();
        origin = new JLabel();
        adults = new JLabel();
        children = new JLabel();
        returnOption = new JRadioButton();
        oneWay = new JRadioButton();
        arrowLabel = new JLabel();
        adultField = new JTextField();
        childrenField = new JTextField();
        selectAirline = new JLabel();
        depart = new JLabel();
        arrive = new JLabel();
        findFlight = new JButton();
        availableFlightPanel = new JPanel();
        flightNo = new JLabel();
        dateOfFlight = new JLabel();
        departureTime = new JLabel();
        arrivalTime = new JLabel();
        classLabel = new JLabel();
        fare = new JLabel();
        clearFields = new JButton();
        exitToMainMenu = new JButton();
        instructions = new JLabel();
        message1 = new JLabel();
        message2 = new JLabel();
        groupRadioButtons =  new ButtonGroup();
        bookFlight = new JButton();
        exitToMainMenu = new JButton();
        clearFields = new JButton();
		
		// set internal layout manager to null			
    	searchPanel.setLayout(null);
    	detailsPanel.setLayout(null);
    	generalPanel.setLayout(null);
    	
    	try
        {
           UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());           // change look of all buttons
           UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");  // Set all buttons to nimbus look
        }
        catch(Exception e)
        {}
		
		// make all panels titled border panels
    	searchPanel.setBorder(BorderFactory.createTitledBorder(null, "Search Flights", 0, 0, new Font("Tahoma", 1, 18))); 
    	detailsPanel.setBorder(BorderFactory.createTitledBorder(null, "Available Flights", 0, 0, new Font("Tahoma", 1, 18))); 
    	generalPanel.setBorder(BorderFactory.createTitledBorder(""));
    	
    	try
    	{	//create tale model
    	    tableModel = new ResultSetTableModel( DATABASE_URL,
    		   USERNAME, PASSWORD, DEFAULT_QUERY );
    	}
    	catch( SQLException sqlException )
    	{
    	    JOptionPane.showMessageDialog( null, sqlException.getMessage(),
                "Database connection error", JOptionPane.ERROR_MESSAGE );
    	}
    	catch( Exception sqlException )
    	{
    		sqlException.printStackTrace();
    	} 
    	finally
    	{
    	   
    	} 
    		 
        resultTable.setModel(tableModel);   // pass table model to table
    	resultTable.setShowGrid( true );  
        scrollPane = new JScrollPane( resultTable );  // add table to scroll pane	   	
    	scrollPane.setBounds(0, 20, 840, 145);   // set bounds for scroll pane
    	scrollPane.setVisible( true );	    // set visibility of scroll pane to true
    
    	// add initial data to arrayList
    	originData.add("----Select City----");	
    	destinationData.add("----Select City----");	
    	airlineData.add("----Select Airline---");		
    		
    	for(int count = 0; count < resultTable.getRowCount(); count++)
    	{
    		Object origData = resultTable.getValueAt(count, 1);   // get source from table
    		Object destData = resultTable.getValueAt(count, 2);   // get destination from table
    		Object airData = resultTable.getValueAt(count, 7);    // get airline name from table

    		originData.add(origData.toString());  // add source to arrayList
    		destinationData.add(destData.toString());  // add destination to arrayList
    		airlineData.add(airData.toString());   // add airline name to array list
    	}  
		
		// format label
		subMenuTitle = new JLabel();
    	subMenuTitle.setFont(new Font("Tahoma", 0, 24));      //set font
        subMenuTitle.setForeground(new Color(204, 102, 0));
        subMenuTitle.setText("Passenger Flight Search");
    	subMenuTitle.setBounds(300, 15, 500, 40);
    	
    	// format label
        origin.setFont(new Font("Tahoma", 1, 14)); // set font
        origin.setForeground(new Color(102, 153, 0));
        origin.setText("Origin");
    	origin.setBounds(30, 40, 100, 40);

        originBox = new JComboBox(originData.toArray());
  		originBox.setEditable(false);
    	originBox.setBounds(30, 70, 130, 30);
    	
    	// format label
    	arrowLabel.setFont(new Font("Tahoma", 1, 14));  // set font
        arrowLabel.setForeground(new Color(102, 153, 0));
        arrowLabel.setText(">>>>");
    	arrowLabel.setBounds(160, 40, 100, 40);
    	
    	// format label
        destination.setFont(new Font("Tahoma", 1, 14));   // set font
        destination.setForeground(new Color(102, 153, 0));
        destination.setText("Destination");
    	destination.setBounds(220, 40, 100, 40);
    	
    	destinationBox = new JComboBox(destinationData.toArray());
 		destinationBox.setEditable(false);
    	destinationBox.setBounds(220, 70, 130, 30);
    
    	// format label
        adults.setFont(new Font("Tahoma", 1, 14));   // set font
        adults.setForeground(new Color(102, 153, 0));
        adults.setText("Adult(s)");
    	adults.setBounds(390, 40, 100, 40);
		
		// format label
    	adultField.setBounds(390, 70, 60, 30);
    	adultField.setFont(new Font("Tahoma", 1, 14)); // set font
    	adultField.setText("1");
		
		// format label
    	children.setFont(new Font("Tahoma", 1, 14));   // set font
        children.setForeground(new Color(102, 153, 0));
        children.setText("Children");
        children.setBounds(500, 40, 100, 40);
        
        // format label
        childrenField.setBounds(500, 70, 60, 30);
        childrenField.setFont(new Font("Tahoma", 1, 14)); // set font
        childrenField.setText("0");
        
        // format radio button
        returnOption.setFont(new Font("Tahoma", 1, 14));   // set font
        returnOption.setForeground(new Color(102, 153, 0));
        returnOption.setText("return");
        returnOption.setBounds(640, 50, 80, 40);
        
        // format radio button
        oneWay.setFont(new Font("Tahoma", 1, 14));   // set font
        oneWay.setForeground(new Color(102, 153, 0));
        oneWay.setText("One way");
        oneWay.setBounds(730, 50, 100, 40);
        
        // format label
        selectAirline.setFont(new Font("Tahoma", 1, 14));    // set font
        selectAirline.setForeground(new Color(120, 153, 0));
        selectAirline.setText("Select Airline:");
        selectAirline.setBounds(30, 110, 100, 40);
		
		// format combo box
        airlineBox = new JComboBox(airlineData.toArray());
        airlineBox.setEditable(false);
    	airlineBox.setBounds(140, 130, 130, 30);
    	
    	// format label
        classLabel.setFont(new Font("Tahoma", 1, 14)); // set font
        classLabel.setForeground(new Color(120, 153, 0));
        classLabel.setText("Class:");
        classLabel.setBounds(350, 110, 100, 40);
        
        // format combo box
        String[] classData = { "Economy", "Executive", "Business"};
        classBox = new JComboBox(classData);
        classBox.setEditable(false);
    	classBox.setBounds(410, 120, 130, 30);
    	
    	// format label
        depart.setFont(new Font("Tahoma", 1, 14)); // set font
        depart.setForeground(new Color(120, 153, 0));
        depart.setText("Depart:");
        depart.setBounds(30, 170, 100, 40);
        chooser1.setBounds(140, 180, 150, 30);
    	
    	// format button
        findFlight.setText("Find Flights");
        findFlight.setBounds(670, 160, 100, 40);

		// format label
        flightNo.setFont(new Font("Tahoma", 1, 14)); // set font
        flightNo.setText("Flight No");
		
		// format label
        dateOfFlight.setFont(new Font("Tahoma", 1, 14)); // set font
        dateOfFlight.setText("Date");
		
		// format label
        departureTime.setFont(new Font("Tahoma", 1, 14)); // set font
        departureTime.setText("Departure Time");
		
		// format label
        arrivalTime.setFont(new Font("Tahoma", 1, 14)); // set font
        arrivalTime.setText("Arrival Time");
		
		// format label
        fare.setFont(new Font("Tahoma", 1, 14)); // set font
        fare.setText("Fare");

		// format label
        instructions.setFont(new Font("Tahoma", 1, 12)); // set font
        instructions.setForeground(new Color(255, 51, 0));
        instructions.setText("Instructions");
        instructions.setBounds(30, 460, 100, 40);

		// format label
        message1.setFont(new Font("Tahoma", 1, 11)); // set font
        message1.setText("1. Full charges will be applicable for children more than 2 years old.");
        message1.setBounds(30, 490, 500, 40);

		// format label
        message2.setFont(new Font("Tahoma", 1, 11)); // set font
        message2.setText("2. Present proof of payment for children  less than or equal to 2 years old on the day of departure.");
    	message2.setBounds(30, 510, 700, 40);
    	
    	// format button
	    bookFlight.setText("Book Flight");
	    bookFlight.setBounds(720, 470, 140, 30);
		
		// format button
        clearFields.setText("Clear Fields");
		clearFields.setBounds(720, 510, 140, 30);
		
		// format button
        exitToMainMenu.setText("Exit to Main Menu");
    	exitToMainMenu.setBounds(720, 550, 140, 30);
    	  
        searchFlightPanel = new JPanel();
		
		// Format panel
        searchFlightPanel.setBorder(BorderFactory.createTitledBorder(null, "Search Flights", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        searchFlightPanel.setForeground(new Color(120, 153, 0));
		
		// add radio buttons to group
        groupRadioButtons.add(returnOption);
        groupRadioButtons.add(oneWay);
		
		// set bounds for panels
		searchPanel.setBounds(20, 50, 840, 240);
		detailsPanel.setBounds(20, 300, 840, 170);
		generalPanel.setBounds(10, 300, 200, 100);
    	
    	// add components to panel
    	searchPanel.add(origin);
    	searchPanel.add(originBox);
    	searchPanel.add(arrowLabel);
    	searchPanel.add(destination);
    	searchPanel.add(destinationBox);
    	searchPanel.add(adults);
    	searchPanel.add(adultField);
    	searchPanel.add(children);
    	searchPanel.add(childrenField);
    	searchPanel.add(returnOption);
    	searchPanel.add(oneWay);
    	searchPanel.add(selectAirline);
    	searchPanel.add(airlineBox);
    	searchPanel.add(classLabel);
    	searchPanel.add(classBox);
    	searchPanel.add(depart);
    	searchPanel.add(chooser1);
    	searchPanel.add(findFlight);
    	searchPanel.add(origin);
    	
    	// add components to panel
    	detailsPanel.add( scrollPane );
    	
    	// add components to panel
    	generalPanel.add(subMenuTitle);
    	generalPanel.add(instructions);
    	generalPanel.add(message1);
    	generalPanel.add(message2);
    	generalPanel.add(bookFlight);
    	generalPanel.add(clearFields);
    	generalPanel.add(exitToMainMenu);
    	
    	// add panels to frame
    	add(searchPanel);
    	add(detailsPanel);
    	add(generalPanel);
    	
    	// instantiate and add components to handler interface
    	ButtonHandler handler = new ButtonHandler();
    	findFlight.addActionListener(handler);
   		bookFlight.addActionListener(handler);
   		clearFields.addActionListener(handler);
   		exitToMainMenu.addActionListener(handler);
   		originBox.addActionListener(handler);
   		destinationBox.addActionListener(handler);
    }
    
    private class ButtonHandler implements ActionListener
    {
    	// private instance variables
		String selectedFNo;
		String selectedAirline;
		String selectedSource;
		String selectedDest;
		String selectedDepDate;
		String selectedArrDate;
		String selectedDepTime;
		String selectedArrTime;
		String selectedFare;
		
		int adultNoChoosen;  
		int childNoChoosen;
		
		boolean valid;
		

		public void actionPerformed(ActionEvent event)
    	{   
    		boolean isFlightFound = false;
    		
    		String classChoosen = classBox.getSelectedItem().toString();
    		    		
    		try
    		{   
    			valid = true;
    			
    			if(event.getSource() == exitToMainMenu)
    			{
   					// Create application frame.
      				MainMenu mainMenu = new MainMenu(); 
    				setVisible(false); 
    			}
    		}
    		catch(Exception e)
    		{
    		
    		}
    		
    		try
    		{
    			if(event.getSource() == findFlight)
    			{   
    			   try
    			   {
    			   	    tableModel.setQuery(DEFAULT_QUERY);
    			   }
    			   catch(SQLException e)
    			   {
    			   	    JOptionPane.showMessageDialog( null,
					       e.getMessage(), "Database error", JOptionPane.ERROR_MESSAGE );
    			   }
    			
    			   for(int count = 0; count < resultTable.getRowCount(); count++)
    			   {
    				   Object origData = resultTable.getValueAt(count, 1);  // get source in object format
    				   String origDataString = origData.toString();    		// convert source from object to string
    				   
    				   Object destData = resultTable.getValueAt(count, 2);  // get destination in object format
    				   String destDataString = destData.toString();         // convert destination from object to string
						
					   // checking if the selected source and destination match
    				   if(originBox.getSelectedItem().toString().equalsIgnoreCase(origDataString) 
    				   	     && destinationBox.getSelectedItem().toString().equalsIgnoreCase(destDataString))
    				   {
    				     	isFlightFound = true;
    				   	  // set query message
    				   	  String query = String.format("SELECT * FROM flight where source = '%s' AND destination = '%s'",
    				   	      originBox.getSelectedItem().toString(), destinationBox.getSelectedItem().toString());
    				      
    				   	  try
    				   	  {
    				   	  	   tableModel.setQuery(query);
    				   	  }
    				   	  catch( SQLException sqlException )
    				   	  {
    				   	  	  JOptionPane.showMessageDialog( null,
								 sqlException.getMessage(), "Database error", JOptionPane.ERROR_MESSAGE );
						      
    				   	       // try to recover from invalid user query 
                    		   // by executing default query
                    		  try 
                    		  {
                       			 tableModel.setQuery( DEFAULT_QUERY );
                     		  } // end try
                              catch ( SQLException sqlException2 ) 
                              {
                                 JOptionPane.showMessageDialog( null, 
                                    sqlException2.getMessage(), "Database error", 
                                         JOptionPane.ERROR_MESSAGE );
         
                                  // ensure database connection is closed
                                  tableModel.disconnectFromDatabase();
         
                                  System.exit( 1 ); // terminate application
                               } // end inner catch    
    		
    				       }  // end outer catch  
    			       }
    			   }
    			   for(int count = 0; count < resultTable.getRowCount(); count++)
    			   {
    				   Object origData = resultTable.getValueAt(count, 1);  // get source in object format
    				   String origDataString = origData.toString();			// convert source from object to string
    				   
    				   Object destData = resultTable.getValueAt(count, 2);  // get destination in object format
    				   String destDataString = destData.toString();			// convert destination from object to string
    				   
    				   // checking if the selected source and destination  does not match
    				   if(originBox.getSelectedItem().toString() != origDataString && isFlightFound == false
    				   	     && destinationBox.getSelectedItem().toString() != destDataString)
    				   {   
    				   	
    				   	    JOptionPane.showMessageDialog( null, "There is no flight available for your selected cities at the moment.", 
                              "NO AVAILABLE FLIGHT", JOptionPane.ERROR_MESSAGE );
                              break;
    				   }   
    			   }
    			   // checking if no source or destination is selected  
    			   if(originBox.getSelectedIndex() == 0 || destinationBox.getSelectedIndex() == 0)
    			   {
    				    JOptionPane.showMessageDialog( null, "Please select a source and a destination", 
                            "AN ERROR HAS OCCURED", JOptionPane.ERROR_MESSAGE );
    			   }
    		    }    
    		}
    		catch(Exception e)
    		{
    		
    		}
    		
    		if(event.getSource() == bookFlight)
    		{
    			
    			try
                { 
					adultNoChoosen = Integer.parseInt(adultField.getText());  // get the number of adults choosen for a particaular flight
		            childNoChoosen= Integer.parseInt(childrenField.getText()); // get the number of children choosen for a particaular flight
		            
					valid = true; // set valid to true if a digit is entered
               	}
                catch(NumberFormatException e)
      			{
                    JOptionPane.showMessageDialog( null,"Alphabets cannot be entered in the adult and children field. Must be numeric..\n\n e.g 1, 2, 5 etc.",
                	    "Invalid flight number",JOptionPane.ERROR_MESSAGE);
                	    
                	valid = false; // set valid to false if an alphabet is entered
      			}
    		}
    		
      		try
    	    {	
    	    	// checkig if entered the customer selected a flight before proceeding to book to pay for a flight	
    			if( valid == true && resultTable.getSelectedRow() > -1 && event.getSource() == bookFlight)
    			{
    				// get selected flight information from database
					selectedFNo = resultTable.getValueAt(resultTable.getSelectedRow(), 0).toString();
					selectedAirline = resultTable.getValueAt(resultTable.getSelectedRow(), 1).toString();
					selectedSource = resultTable.getValueAt(resultTable.getSelectedRow(), 2).toString();
					selectedDest = resultTable.getValueAt(resultTable.getSelectedRow(), 3).toString();
					selectedDepDate = resultTable.getValueAt(resultTable.getSelectedRow(), 4).toString();
					selectedArrDate = resultTable.getValueAt(resultTable.getSelectedRow(), 5).toString();
					selectedDepTime = resultTable.getValueAt(resultTable.getSelectedRow(), 6).toString();
					selectedArrTime = resultTable.getValueAt(resultTable.getSelectedRow(), 7).toString();
					selectedFare = resultTable.getValueAt(resultTable.getSelectedRow(), 8).toString();
						
					double newFare = Double.parseDouble(selectedFare);  // change the fare from string to a double
						
					if(returnOption.isSelected())
					{
						newFare = (newFare / 3) + newFare;  // divide fare by 3 and add it to the previous fare 
															// if return option is selected								
					}
					if(classBox.getSelectedItem().toString().equalsIgnoreCase("Business"))
					{
					    newFare = (newFare * 0.4) + newFare; //add forty percent of fare to original fare if its a business class
					}
					if(classBox.getSelectedItem().toString().equalsIgnoreCase("Executive"))
					{
						newFare = (newFare * 0.3) + newFare;  //add thirty percent of fare to original fare if its a business class
					}
						
		            int selectedFNumber= Integer.parseInt(selectedFNo);
		               
		            // check how many adults were choosen and multiply by fare 
		            if(adultNoChoosen > 0)
		            {
		                newFare = newFare * adultNoChoosen; 
		            }  
		            // check how many children where choosen and multiply by fare 	
		            if(childNoChoosen > 0)
		            {
		                newFare = newFare * childNoChoosen;
		            }
    				
    				// pass flight information to customer reservation details class	
    				CustomerReservationDetails customerReservationDetails = new CustomerReservationDetails(selectedFNumber, selectedAirline, selectedSource,
    		        selectedDest, selectedDepDate, selectedArrDate, selectedDepTime, selectedArrTime, newFare, adultNoChoosen, childNoChoosen, classChoosen);      
    				setVisible(false);  
    			}
    			// checking if a flight is not selected and a customer wants to proceed to booking section
    			if( valid == true && resultTable.getSelectedRow() < 0 && event.getSource() == bookFlight)
    			{
    				JOptionPane.showMessageDialog( null, "Please select a flight before proceeding to booking section", 
                       "INFORMATION MESSAGE", JOptionPane.INFORMATION_MESSAGE );
    			}

    		}
    	    catch(Exception e)
    		{
    			
    			JOptionPane.showMessageDialog( null, "Please select a flight before proceeding to booking section", 
                           "INFORMATION MESSAGE", JOptionPane.INFORMATION_MESSAGE );
    		}
    		
    		try
    		{
    			if(event.getSource() == clearFields)
    			{
    			    
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
    		connectDBandSearch = new DataBaseNoTableModel();
    	}
    	catch ( Exception sqlException )
      	{
         	JOptionPane.showMessageDialog( null, sqlException.getMessage(),
            "Database connection error", JOptionPane.ERROR_MESSAGE );

         	// ensure database connection is closed
         	connectDBandSearch.close();
      	} // end catch  

    }   
 
}
   