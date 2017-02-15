/**
 * @(#)CreditCardPayment.java
 *
 *
 * @author 
 * @version 1.00 2014/9/24
 */

//import packages
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
import java.util.Random;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.sql.ResultSet;

import com.toedter.calendar.*;

@SuppressWarnings("unchecked")
public class CreditCardPayment extends JFrame
{
	// instance variables
    private JRadioButton visaCard;
    private JRadioButton masterCard;
    
    private JLabel billingInfoLabel;
    private JLabel nameOfCardHolder;
    private JLabel cardNumber;
    private JLabel expirationDate;
    private JLabel address;
    private JLabel country;
    private JLabel postalCode;
    private JLabel cvcNumber;
    	
    private JTextField nameOfCardHolderField;
    private JTextField cardNumberField;
    private JTextField expirationDateField;
    private JTextField addressField;
    private JTextField countryField;
    private JTextField postalCodeField;
    private JTextField cvcNumberField;


    private JButton cancelPayment;
    private JButton resetFieldsButton;
    private JButton payButton;
    
    private ButtonGroup radioGroup;
    
    int paymentID;
    private int bookingID;
	private double totalPaymentAmount;
	
	static final String DATABASE_URL = "jdbc:mysql://localhost/ars";
   	static final String USERNAME = "ars";
   	static final String PASSWORD = "cput";
   	static  String query = "";
   	
   	private DataBaseNoTableModel connectDBandPay;

   	Random randomNumbers = new Random();
   	
   	JDateChooser chooser = new JDateChooser();
     
    public CreditCardPayment(int bookingID, double totalPaymentAmount) 
    {
    	setTitle("Airline Reserrvation System                                               Card Details");
    	setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);   // close frame when frame is closed
    	setSize(650, 610);   // set size of frame
    	setResizable(false);  // make frame non-resizable
    	setVisible(true);     // set visibility of frame to false
    	setLocationRelativeTo(null);  // make frame appear at the centre of the screen
    	setLayout(null);    // set internal layout manager to null

    	try
        {
           UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());           // change look of all buttons
           UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");  // Set all buttons to nimbus look
        }
        catch(Exception e)
        {}
    	
    	//instantiate  billingInfoLabel, change its font and color and set bounds for the button
    	billingInfoLabel = new JLabel();
    	billingInfoLabel.setFont(new Font("Tahoma", 1, 25)); // set font
        billingInfoLabel.setForeground(new Color(0, 0, 0));
        billingInfoLabel.setText("Billing Information");
    	billingInfoLabel.setBounds(30, 30, 500, 40);
    	
    	//set admin button, change its font and color and set bounds for the button
    	visaCard = new JRadioButton("Visa Card", false);
    	visaCard.setFont(new Font("Arial", Font.PLAIN, 20));
    	visaCard.setForeground(Color.BLACK);
    	visaCard.setBounds(30, 100, 200, 30);
    	
    	//set admin button, change its font and color and set bounds for the button
    	masterCard = new JRadioButton("Master Card", false);
    	masterCard.setFont(new Font("Arial", Font.PLAIN, 20));
    	masterCard.setForeground(Color.BLACK);
    	masterCard.setBounds(350, 100, 150, 30);
    	
    	//create logical relationship between JRadioButtons
		radioGroup = new ButtonGroup(); // create ButtonGroup
		radioGroup.add(visaCard); // add admin to group
		radioGroup.add(masterCard); // add customer to group
		
		//instantiate  nameOfCardHolder, change its font and color and set bounds for the button
		nameOfCardHolder = new JLabel();
    	nameOfCardHolder.setFont(new Font("Tahoma", 0, 20)); // set font
        nameOfCardHolder.setForeground(new Color(0, 0, 0));
        nameOfCardHolder.setText("Name of card holder");
    	nameOfCardHolder.setBounds(30, 150, 200, 40);
    	
    	//instantiate  nameOfCardHolderField, change its font and color and set bounds for the button
    	nameOfCardHolderField = new JTextField(20);
    	nameOfCardHolderField.setFont(new Font("Tahoma", 0, 16)); // set font
        nameOfCardHolderField.setForeground(new Color(0, 0, 0));
    	nameOfCardHolderField.setBounds(30, 190, 250, 30);
    	
    	//instantiate  cardNumber, change its font and color and set bounds for the button
    	cardNumber = new JLabel();
    	cardNumber.setFont(new Font("Tahoma", 0, 20)); // set font
        cardNumber.setForeground(new Color(0, 0, 0));
        cardNumber.setText("Card number");
    	cardNumber.setBounds(350, 150, 200, 40);
    	
    	//instantiate  cardNumberField, change its font and color and set bounds for the button
    	cardNumberField = new JTextField(20);
    	cardNumberField.setFont(new Font("Tahoma", 0, 16)); // set font
        cardNumberField.setForeground(new Color(0, 0, 0));
    	cardNumberField.setBounds(350, 190, 250, 30);
    	
    	//instantiate  expirationDate, change its font and color and set bounds for the button
    	expirationDate = new JLabel();
    	expirationDate.setFont(new Font("Tahoma", 0, 20)); // set font
        expirationDate.setForeground(new Color(0, 0, 0));
        expirationDate.setText("Expiration Date");
    	expirationDate.setBounds(30, 230, 200, 40);

    	chooser.setBounds(30, 270, 150, 30);    // set bounds for calendar
    	
    	//instantiate  cvcNumber, change its font and color and set bounds for the button
    	cvcNumber = new JLabel();
    	cvcNumber.setFont(new Font("Tahoma", 0, 20)); // set font
        cvcNumber.setForeground(new Color(0, 0, 0));
        cvcNumber.setText("CVC number");
    	cvcNumber.setBounds(350, 230, 200, 40);
    	
    	//instantiate  cvcNumberField, change its font and color and set bounds for the button
    	cvcNumberField = new JTextField(20);
    	cvcNumberField.setFont(new Font("Tahoma", 0, 16)); // set font
        cvcNumberField.setForeground(new Color(0, 0, 0));
    	cvcNumberField.setBounds(350, 270, 250, 30);
    	
    	//instantiate  address, change its font and color and set bounds for the button
    	address = new JLabel();
    	address.setFont(new Font("Tahoma", 0, 20)); // set font
        address.setForeground(new Color(0, 0, 0));
        address.setText("Address");
    	address.setBounds(30, 310, 200, 40);
    	
    	//instantiate  addressField, change its font and color and set bounds for the button
    	addressField = new JTextField(20);
    	addressField.setFont(new Font("Tahoma", 0, 16)); // set font
        addressField.setForeground(new Color(0, 0, 0));
    	addressField.setBounds(30, 350, 570, 30);
    	
    	//instantiate  country, change its font and color and set bounds for the button
    	country = new JLabel();
    	country.setFont(new Font("Tahoma", 0, 20)); // set font
        country.setForeground(new Color(0, 0, 0));
        country.setText("Country");
    	country.setBounds(30, 390, 200, 40);
    	
    	//instantiate  countryField, change its font and color and set bounds for the button
    	countryField = new JTextField(20);
    	countryField.setFont(new Font("Tahoma", 0, 16)); // set font
        countryField.setForeground(new Color(0, 0, 0));
    	countryField.setBounds(30, 430, 250, 30);
    	
    	//instantiate  postalCode, change its font and color and set bounds for the button
    	postalCode = new JLabel();
    	postalCode.setFont(new Font("Tahoma", 0, 20)); // set font
        postalCode.setForeground(new Color(0, 0, 0));
        postalCode.setText("Postal Code");
    	postalCode.setBounds(350, 390, 200, 40);
    	
    	//instantiate  postalCodeField, change its font and color and set bounds for the button
    	postalCodeField = new JTextField(20);
    	postalCodeField.setFont(new Font("Tahoma", 0, 16)); // set font
        postalCodeField.setForeground(new Color(0, 0, 0));
    	postalCodeField.setBounds(350, 430, 250, 30);
    	
    	//instantiate  cancelPayment, change its font and color and set bounds for the button
    	cancelPayment = new JButton();
    	cancelPayment.setFont(new Font("Tahoma", 0, 16)); // set font
        cancelPayment.setForeground(new Color(0, 0, 0));
        cancelPayment.setText("Cancel Payment");
    	cancelPayment.setBounds(90, 500, 150, 40);
    	
    	//instantiate  resetFieldsButton, change its font and color and set bounds for the button
    	resetFieldsButton = new JButton();
    	resetFieldsButton.setFont(new Font("Tahoma", 0, 16)); // set font
        resetFieldsButton.setForeground(new Color(0, 0, 0));
        resetFieldsButton.setText("Reset Fields");
    	resetFieldsButton.setBounds(270, 500, 150, 40);
    	
    	//instantiate  payButton, change its font and color and set bounds for the button
    	payButton = new JButton();
    	payButton.setFont(new Font("Tahoma", 0, 16)); // set font
        payButton.setForeground(new Color(0, 0, 0));
        payButton.setText("PAY NOW");
    	payButton.setBounds(450, 500, 150, 40);
    	
    	// add components to frame
    	add(billingInfoLabel);
    	add(visaCard);
    	add(masterCard);
    	add(nameOfCardHolder);
    	add(nameOfCardHolderField);
    	add(cardNumber);
    	add(cardNumberField);
    	add(expirationDate);
    	add(chooser);
    	add(cvcNumber);
    	add(cvcNumberField);
		add(address);
    	add(addressField);
    	add(country);
    	add(countryField);
    	add(postalCode);
    	add(postalCodeField);
    	add(cancelPayment);
    	add(resetFieldsButton);
    	add(payButton);
    	
    	// instantiate and add components to handler interface
    	ButtonHandler buttonHandler = new ButtonHandler();
    	cancelPayment.addActionListener(buttonHandler);
    	resetFieldsButton.addActionListener(buttonHandler);
    	payButton.addActionListener(buttonHandler);	
    		
    	setTotalPaymentAmount(totalPaymentAmount);
    	setBookingID(bookingID);
    		
    } 
    	
    private class ButtonHandler implements ActionListener
    {

		public void actionPerformed(ActionEvent event)
    	{   
    		Date date = chooser.getDate();   // get dat from calendar


    		try
    		{
    			// make sure customer does not pay without choosing a payment option 
    			if(masterCard.isSelected() == false && visaCard.isSelected () == false && payButton == event.getSource())
    			{
    				JOptionPane.showMessageDialog(null, "Please select a card option. Visa Card or Master Card", "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
    			} 
    		}
    		catch(Exception e)
    		{
				JOptionPane.showMessageDialog(null, "Please select a card option. Visa Card or Master Card", "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
    		}
    		try
    		{
    			if(event.getSource() == cancelPayment)
    			{
    			   CustomerFlightSearch customerFlightSearch = new CustomerFlightSearch();
    			   setVisible(false);
    			}
    		}
    		catch(Exception e)
    		{
    		
    		}
    		
    		try
    		{
    			if(event.getSource() == resetFieldsButton)
    			{
    				resetFields();
    			}
    		}
    		catch(Exception e)
    		{
    		
    		}
    		
    		try
    		{
    			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd");   // date format
    			
    			// check if payButton is clicked and visa card is selected
    			if(event.getSource() == payButton && visaCard.isSelected())
    			{
    				String expDate = "";  
    		        try
    		        {
    		            expDate = sdf.format(date.getTime());   // get formatted date
    		        }
    		        catch(Exception e)
    		        {}
    				
    				// making sure any payment field is not empty
    				if( nameOfCardHolderField.getText().isEmpty() || expDate.isEmpty() || cvcNumberField.getText().isEmpty() ||	
    					addressField.getText().isEmpty() || countryField.getText().isEmpty() || postalCodeField.getText().isEmpty())
    				{   
    					JOptionPane.showMessageDialog( null, "Please you must complete all fields to proceed.", 
                           "INFORMATION MESSAGE", JOptionPane.INFORMATION_MESSAGE );	
    				}
    				else
    				{   
    					ValidateInput validate = new ValidateInput();   // instantiate validate class
    					
    					// validate card number
                    	if(!validate.validateVisaCard(cardNumberField.getText()))
                    	{
                    		JOptionPane.showMessageDialog( null,"Sorry invalid card number.\n\n"+
                    			"Must be 16 digits for new visa cards and 13 digits for old visa cards, and must start with digit 4",
                				"Invalid card number",JOptionPane.ERROR_MESSAGE);
                    	}
                    	
                    	// validate cvc number
                    	if(!validate.validateCVC(cvcNumberField.getText()) || !cvcNumberField.getText().equals(cardNumberField.getText().substring(13,16)))
                    	{
                    		JOptionPane.showMessageDialog( null,"Sorry invalid cvc number. Must be last three digits of card number",
                				"Invalid cvc number",JOptionPane.ERROR_MESSAGE);
                    	}
                    	// validate address
                    	if(!validate.validateAddress(addressField.getText()))
                    	{
                    		JOptionPane.showMessageDialog( null,"Sorry invalid address.\n"+ 
                    			"Example: Number space Street Name space City Name\n\n"+
                    		    "123 Beach Road Cape Town. Please adhere to the specified format.",
                				"Invalid address",JOptionPane.ERROR_MESSAGE);
                    	}
                    	
                    	// validate country  
                    	if(!validate.validateCountryOfIssue(countryField.getText()))
                    	{
                    		JOptionPane.showMessageDialog( null,"Sorry invalid country",
                				"Invalid country",JOptionPane.ERROR_MESSAGE);
                    	}
                    	
                    	// validate postal code
                    	if(!validate.validateZip(postalCodeField.getText()))
                    	{
                    		JOptionPane.showMessageDialog( null,"Sorry invalid postal code. Must be five digits",
                				"Invalid postal code",JOptionPane.ERROR_MESSAGE);
                    	}

                    	try
                    	{         
                    		ResultSet resultSet = null; // manages results
    					
    				    	connect();   // connect to database
    				
    				    	query = String.format("SELECT * from payment");  // set query message
    					
    						paymentID = 25001 + randomNumbers.nextInt( 30000 - 25001 );  // generate payment id
    					
    				    	connectDBandPay.setQuery(query);   // set query
				   	    	connectDBandPay.execute();    // execute query
				   	 
    				    	resultSet = connectDBandPay.getResultSet();    // get result of query from database
				   	      
				   	        // loop through query result
				   	    	while(resultSet.next())
				   	    	{
				   	    		// check if payment id is found in database
                       	   	    if(paymentID == resultSet.getInt(1))
                       	   		{
                       	   			// generate a new payment id if the generated payment id was found in the database
           	                  		paymentID = 25001 + randomNumbers.nextInt( 30000 - 25001 );
           	                  		break; 
                       	   		} 	
                        	}
                    	}
                    	catch(Exception e)
                    	{
                    
                    	}
                    
                    	// checking to make sure all values have been validated
                    	if(validate.validateNameOfCardHolder(nameOfCardHolderField.getText()) && expDate != null &&
                    		 validate.validateVisaCard(cardNumberField.getText()) && validate.validateCVC(cvcNumberField.getText()) &&
                    		 validate.validateAddress(addressField.getText()) && validate.validateCountryOfIssue(countryField.getText())
                    		 && validate.validateZip(postalCodeField.getText()))
                    	{ 
                    		connect();  // connect to database
                    		
    						paymentID = 25001 + randomNumbers.nextInt( 30000 - 25001 );
    				   	 	String  paymentMethod = "Visa Card";   // set payment method
    				    
    				    	int postCode = Integer.parseInt(postalCodeField.getText());  // change post code from string to integer
    				    	int cvc = Integer.parseInt(cvcNumberField.getText());         // change cvc numbere from string to integer
    				    	long cardNo = Long.parseLong(cardNumberField.getText());   // change card number from string to long
    				    
    				        // set query message
    			       		query = String.format("insert into payment(payment_id , booking_id , payment_method , name_of_card_holder , card_number, cvc_number, c_exp_date, holder_address, country , postal_code , payment_date, payment_amount)" + 
                          		"VALUES (%d, %d, '%s', '%s', %d%n, %d, '%s',  '%s', '%s', %d, CURDATE(), %f)", paymentID, getBookingID(), paymentMethod, 
                          		nameOfCardHolderField.getText(), cardNo,  cvc, expDate, addressField.getText(), countryField.getText(), postCode, getTotalPaymentAmount());

                        	connectDBandPay.setQuery(query);  // set query 
             		    	connectDBandPay.executeUpdate();  // execute query
             		    
             		        // set query message
             		    	query = String.format("UPDATE booking SET status = 'booked' WHERE booking_id = %d", getBookingID());
             		    
             		    	connectDBandPay.setQuery(query);   // set query
             		    	connectDBandPay.executeUpdate();   // execute query
             		    
             		    	connectDBandPay.setQuery("commit"); // commit queries 
             		    	connectDBandPay.executeUpdate();    // execute commit
             		    
             		    	resetFields();    // reset fields
             		    	setVisible(false);  // set frame visibility to false
             		      
             		      	// format JOptionPane message
             		    	String message = String.format("Thank you for using this application.\n\nYour booking is complete.\n\nYou paid the sum of R%.2f, tax inclusive",  getTotalPaymentAmount());
    				    	JLabel dataLabel = new JLabel(message);
    				    	dataLabel.setFont(new Font("Tahoma", 1, 20)); // NOI18N
        			    	dataLabel.setForeground(new Color(0, 0, 0));
             		    
             		    	JOptionPane.showMessageDialog( null, dataLabel, 
                           		"INFORMATION MESSAGE", JOptionPane.INFORMATION_MESSAGE );
                        
                        	MainMenu mainMenu = new MainMenu();   //  create main menu frame
                    	}
    				
    				}
    			
    			}
    			
    			if(event.getSource() == payButton && masterCard.isSelected())
    			{
    				String expDate = "";
    		        try
    		        {
    		            expDate = sdf.format(date.getTime());
    		        }
    		        catch(Exception e)
    		        {}
    				
    			    // making sure any payment field is not empty
    				if( nameOfCardHolderField.getText().isEmpty() || expDate.isEmpty() || cvcNumberField.getText().isEmpty() ||	
    					addressField.getText().isEmpty() || countryField.getText().isEmpty() || postalCodeField.getText().isEmpty())
    				{   
    					JOptionPane.showMessageDialog( null, "Please you must complete all fields to proceed.", 
                           "INFORMATION MESSAGE", JOptionPane.INFORMATION_MESSAGE );	
    				}
    				else
    				{   
    					ValidateInput validate = new ValidateInput();   // instantiate validation class
    					
                        // validate card number               	
                    	if(!validate.validateMasterCard(cardNumberField.getText()))
                    	{
                    		JOptionPane.showMessageDialog( null,"Sorry invalid card number.\n\n"+
                    			"Must be 16 digits for Master Card, and must start with digits 51 or 52 or 53 or 54 or 55",
                				"Invalid card number",JOptionPane.ERROR_MESSAGE);
                    	}
                    	
                    	// validate cvc number
                    	if(!validate.validateCVC(cvcNumberField.getText()) || !cvcNumberField.getText().equals(cardNumberField.getText().substring(13,16)))
                    	{
                    		JOptionPane.showMessageDialog( null,"Sorry invalid cvc number. Must be last three numbers of card number",
                				"Invalid cvc number",JOptionPane.ERROR_MESSAGE);
                    	}
                    	
                    	// validate address
                    	if(!validate.validateAddress(addressField.getText()))
                    	{
                    		JOptionPane.showMessageDialog( null,"Sorry invalid address.\n"+ 
                    			"Example: Number space Street Name space City Name\n\n"+
                    		    "123 Beach Road Cape Town. Please adhere to the specified format.",
                				"Invalid address",JOptionPane.ERROR_MESSAGE);
                    	} 
                    		
                    	// validate country of issue
                    	if(!validate.validateCountryOfIssue(countryField.getText()))
                    	{
                    		JOptionPane.showMessageDialog( null,"Sorry invalid country",
                				"Invalid country",JOptionPane.ERROR_MESSAGE);
                    	}
                    	
                    	// validate postal code
                    	if(!validate.validateZip(postalCodeField.getText()))
                    	{
                    		JOptionPane.showMessageDialog( null,"Sorry invalid postal code. Must be five numerics",
                				"Invalid postal code",JOptionPane.ERROR_MESSAGE);
                    	}
                    	
                    	// checking to make sure all values have been validated
                    	if(validate.validateNameOfCardHolder(nameOfCardHolderField.getText()) && expDate != null &&
                    		 validate.validateMasterCard(cardNumberField.getText()) && validate.validateCVC(cvcNumberField.getText()) &&
                    		 validate.validateAddress(addressField.getText()) && validate.validateCountryOfIssue(countryField.getText())
                    		 && validate.validateZip(postalCodeField.getText()))
                    	{ 
                    		connect();   // connect to database
                    		
    						paymentID = 25001 + randomNumbers.nextInt( 30000 - 25001 );
    				   	 	String  paymentMethod = "Master Card";   // set payment method
    				    
    				    	int postCode = Integer.parseInt(postalCodeField.getText());  // change post code from string to integer
    				    	int cvc = Integer.parseInt(cvcNumberField.getText());         // change cvc numbere from string to integer
    				    	long cardNo = Long.parseLong(cardNumberField.getText());   // change card number from string to long
							
							// set query message
    			       		query = String.format("insert into payment(payment_id , booking_id , payment_method , name_of_card_holder , card_number, cvc_number, c_exp_date, holder_address, country , postal_code , payment_date, payment_amount)" + 
                          		"VALUES (%d, %d, '%s', '%s', %d%n, %d, '%s',  '%s', '%s', %d, CURDATE(), %f)", paymentID, getBookingID(), paymentMethod, 
                          		nameOfCardHolderField.getText(), cardNo,  cvc, expDate, addressField.getText(), countryField.getText(), postCode, getTotalPaymentAmount());

                        	connectDBandPay.setQuery(query);  // set query
             		    	connectDBandPay.executeUpdate();  // execute query
             		    
             		    	// set query message
             		    	query = String.format("UPDATE booking SET status = 'booked' WHERE booking_id = %d", getBookingID());
             		    
             		    	connectDBandPay.setQuery(query);   // set query
             		    	connectDBandPay.executeUpdate();   // execute query
             		    
             		    	connectDBandPay.setQuery("commit"); // commit queries 
             		    	connectDBandPay.executeUpdate();    // execute commit
             		    
             		    	resetFields();     // reset all fields
             		    	setVisible(false);
             		      
             		        // Format JOptionPane message
             		    	String message = String.format("Thank you for using this application.\n\nYour booking is complete.\n\nYou paid the sum of R%.2f, tax inclusive",  getTotalPaymentAmount());
    				    	JLabel dataLabel = new JLabel(message);
    				    	dataLabel.setFont(new Font("Tahoma", 1, 20)); // NOI18N
        			    	dataLabel.setForeground(new Color(0, 0, 0));
             		    
             		    	JOptionPane.showMessageDialog( null, dataLabel, 
                           		"INFORMATION MESSAGE", JOptionPane.INFORMATION_MESSAGE );
                        
                        	MainMenu mainMenu = new MainMenu();   // create main menu frame
                    	} 
    				}
    			}
    		}
    		catch(Exception e)
    		{
    		    //JOptionPane.showMessageDialog( null, "Please enter all values", 
                           //"INFORMATION MESSAGE", JOptionPane.INFORMATION_MESSAGE );
    		}
    		finally
    		{
    			try
    			{
    				connectDBandPay.close();
    			}
    			catch(Exception e)
    	    	{
    	    		
    	    	}
    		}	
    	}
    }
    
    public void resetFields()
    {
    	nameOfCardHolderField.setText(null);
    	cardNumberField.setText(null);
    	chooser.setCalendar(null);
    	cvcNumberField.setText(null);
    	addressField.setText(null);
    	countryField.setText(null);
    	postalCodeField.setText(null);
        visaCard.setSelected(false);
        masterCard.setSelected(false);
        radioGroup.clearSelection();
    }
    
    public void connect()
    {
    	try
    	{
    		connectDBandPay = new DataBaseNoTableModel();
    	}
    	catch ( Exception sqlException )
      	{
         	JOptionPane.showMessageDialog( null, sqlException.getMessage(),
            "Database connection error", JOptionPane.ERROR_MESSAGE );
            
         	connectDBandPay.close();     // ensure database connection is closed
      	} // end catch
    }
    
    public void setBookingID(int bookingID) 
    {
		this.bookingID = bookingID; 
	}

	public int getBookingID() 
	{
		return (this.bookingID); 
	}

	public void setTotalPaymentAmount(double totalPaymentAmount) 
	{
		this.totalPaymentAmount = totalPaymentAmount; 
	}

	public double getTotalPaymentAmount() 
	{
		return (this.totalPaymentAmount); 
	}
    
}