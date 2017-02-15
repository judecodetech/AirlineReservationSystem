/**
 * @(#)CustomerAuthenticationGui.java
 *
 *
 * @Jude Ugbefu
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

@SuppressWarnings("unchecked")
public class Customer extends JFrame
{
	// instance variables
	private JLabel email;      
	private JLabel reEnterEmail;
	private JLabel phoneNumber;      
	private JLabel agreementMessage1;
	private JLabel agreementMessage2;
	private JTextField emailField;
	private JTextField reEnterEmailField;
	private JTextField phoneNumberField;
	private JCheckBox termsAndConditions;
	private Icon continueIcon;
	private JButton continueButton;
	private Icon mainMenuIcon;
	private JButton mainMenuButtton;
	private Icon mainMenuIcon2;
	private JRadioButton cancelBooking;
	private JRadioButton searchOrBook;
	private ButtonGroup groupRadioButtons;

	JPanel emptyPanel = new JPanel();
	JButton mainMenuButtton2 = new JButton();
	DesignedPanel customerAuthenticationPanel = new DesignedPanel("customerAuthent.jpg");
    	
    public Customer() 
    {
		setTitle("Airline Reserrvation System                                               Customer Authentication");
    	setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    	setSize(730, 570);   // set size
    	setResizable(false);  // make frame non-resizable
    	setVisible(true);     // set frame visibility to true
    	setLocationRelativeTo(null);  
    	
    	// set layout of panels to null	
    	customerAuthenticationPanel.setLayout(null);
    	emptyPanel.setLayout(null);
    	
    	try
        {
           UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());           // change look of all buttons
           UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");  // Set all buttons to nimbus look
        }
        catch(Exception e)
        {}
        
        // format label
        email = new JLabel("Email");
        email.setFont(new Font("Arial", Font.PLAIN, 23));
    	email.setForeground(Color.BLACK);
    	email.setBounds(50, 120, 100, 40);
    	
    	// format JTextField
    	emailField = new JTextField(15);
        emailField.setFont(new Font("Arial", Font.PLAIN, 16));
    	emailField.setForeground(Color.BLACK);
    	emailField.setBounds(240, 120, 400, 40);
    	
    	// format label
    	reEnterEmail = new JLabel("Re-enter Email");
        reEnterEmail.setFont(new Font("Arial", Font.PLAIN, 23));
    	reEnterEmail.setForeground(Color.BLACK);
    	reEnterEmail.setBounds(50, 190, 400, 40);
    	
    	// format JTextField
    	reEnterEmailField = new JTextField(15);
        reEnterEmailField.setFont(new Font("Arial", Font.PLAIN, 16));
    	reEnterEmailField.setForeground(Color.BLACK);
    	reEnterEmailField.setBounds(240, 190, 400, 40);
    	
    	// format label
    	phoneNumber = new JLabel("Phone Number");
        phoneNumber.setFont(new Font("Arial", Font.PLAIN, 23));
    	phoneNumber.setForeground(Color.BLACK);
    	phoneNumber.setBounds(50, 260, 400, 40);
    	
    	// format JTextField
    	phoneNumberField = new JTextField(10);
        phoneNumberField.setFont(new Font("Arial", Font.PLAIN, 16));
    	phoneNumberField.setForeground(Color.BLACK);
    	phoneNumberField.setText(null);
    	phoneNumberField.setBounds(240, 260, 400, 40);
    	
    	// format label
    	agreementMessage1 = new JLabel("We require your email and phone number to continue. Please enter");
        agreementMessage1.setFont(new Font("Arial", Font.PLAIN, 18));
    	agreementMessage1.setForeground(Color.BLACK);
    	agreementMessage1.setBounds(50, 350, 1000, 30);
    	
    	// format label
    	agreementMessage2 = new JLabel("your phone number only, if you do not have an email address.");
        agreementMessage2.setFont(new Font("Arial", Font.PLAIN, 18));
    	agreementMessage2.setForeground(Color.BLACK);
    	agreementMessage2.setBounds(50, 370, 1000, 30);
		
		// format JCheckBox
    	termsAndConditions = new JCheckBox("I have agreed to the terms and conditions");
        termsAndConditions.setFont(new Font("Arial", Font.PLAIN, 18));
    	termsAndConditions.setForeground(Color.BLACK);
    	termsAndConditions.setBounds(50, 410, 500, 30);
    	
    	// format button
    	mainMenuButtton = new JButton();
    	mainMenuIcon = new ImageIcon(getClass().getResource("menuButton.png"));
    	mainMenuButtton.setIcon(mainMenuIcon);
    	mainMenuButtton.setBounds(50, 470, 230, 50);
    	
    	// format button
    	continueButton = new JButton();
    	continueIcon = new ImageIcon(getClass().getResource("continue-button.jpg"));
    	continueButton.setIcon(continueIcon);
    	continueButton.setBounds(500, 470, 200, 50);
    	
    	//set admin button, change its font and color and set bounds for the button
    	cancelBooking = new JRadioButton("Cancel Booking", false);
    	cancelBooking.setFont(new Font("Arial", Font.BOLD, 20));
    	cancelBooking.setForeground(Color.BLACK);
    	cancelBooking.setBounds(70, 50, 500, 30);
    	
    	
    	//set admin button, change its font and color and set bounds for the button
    	searchOrBook = new JRadioButton("Search for flights to do booking", false);
    	searchOrBook.setFont(new Font("Arial", Font.BOLD, 20));
    	searchOrBook.setForeground(Color.BLACK);
    	searchOrBook.setBounds(330, 50, 500, 30);
    	
    	//create logical relationship between JRadioButtons
		groupRadioButtons = new ButtonGroup(); // create ButtonGroup
		groupRadioButtons.add(cancelBooking); // add admin to group
		groupRadioButtons.add(searchOrBook); // add customer to group
		
		// format icon
    	mainMenuIcon2 = new ImageIcon(getClass().getResource("menuButton.png"));  // set picture to icon
    	mainMenuButtton2.setIcon(mainMenuIcon2);    // set button to icon
    	mainMenuButtton2.setBounds(240, 130, 230, 50);
    	
    	// add components to panel
    	customerAuthenticationPanel.add(email);
    	customerAuthenticationPanel.add(emailField);
    	customerAuthenticationPanel.add(reEnterEmail);
    	customerAuthenticationPanel.add(reEnterEmailField);
    	customerAuthenticationPanel.add(phoneNumber);
    	customerAuthenticationPanel.add(phoneNumberField);
    	customerAuthenticationPanel.add(agreementMessage1);
    	customerAuthenticationPanel.add(agreementMessage2);
    	customerAuthenticationPanel.add(termsAndConditions);
    	customerAuthenticationPanel.add(continueButton);
    	customerAuthenticationPanel.add(mainMenuButtton);
    	
    	// add components to panel
    	emptyPanel.add(searchOrBook);
    	emptyPanel.add(cancelBooking);
    	
    	// add panel to frame
    	add(customerAuthenticationPanel);

        // instantiate and add components to handler interface
    	RadioButtonHandler handler = new RadioButtonHandler();
   		termsAndConditions.addItemListener(handler);
   		cancelBooking.addItemListener(handler);
   		searchOrBook.addItemListener(handler);	
    	
    	// instantiate and add components to handler interface
    	ButtonHandler buttonHandler = new ButtonHandler();
    	mainMenuButtton.addActionListener(buttonHandler);
    	continueButton.addActionListener(buttonHandler);
    	mainMenuButtton2.addActionListener(buttonHandler);
    }
    
   private class RadioButtonHandler implements ItemListener
   {

		public void itemStateChanged(ItemEvent event)
    	{	
    		try
    		{
    			if(searchOrBook.isSelected ())
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
    			if(cancelBooking.isSelected ())
    			{
    				CancelReservation cancel = new CancelReservation();
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
    			// verify that fields are not empty before displaying next panel
    			if(termsAndConditions.isSelected() && emailField.getText().isEmpty() && 
    				 reEnterEmailField.getText().isEmpty() && !phoneNumberField.getText().isEmpty() && event.getSource() == continueButton)
    			{	
    				ValidateInput validate = new ValidateInput();
    				
    			    if(validate.validatePhone(phoneNumberField.getText()) == true || (validate.validateIntlPhone(phoneNumberField.getText())))   // checking if phone number is validated
    			    {
    			    	// change information on frame
    			       	setTitle("Airline Reservation System               						Customer Option");
    			        setSize(730, 270);  
    			        customerAuthenticationPanel.setVisible(false);
    			        emptyPanel.add(mainMenuButtton2);
    			   	    add(emptyPanel);
    			    }
    			    else
    			    {
    			       	JOptionPane.showMessageDialog(null, "Please enter a valid phone number.\n\nLocal format 061-271-5092. Intl format: +2776-127-15092", 
    			   	        "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
    			    }
    			          
    			}
    		}
    		catch(Exception e)
    		{
    		    JOptionPane.showMessageDialog(null, "Please enter your email or correct phone number\notherwise you are violating the terms and conditions"
    		      + "\n\nLocal format 061-271-5092. Intl format: +2776-127-15092.  Email: xxxxxxxxx@hmail.com",
    		    	"ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
    		}
    		
    		try
    		{
    			if(event.getSource() == mainMenuButtton || event.getSource() == mainMenuButtton2)
    			{
    			 	 // Create application frame.
       				MainMenu frame = new MainMenu();
    			  	setVisible(false);
    			}
    			
    			ValidateInput validate = new ValidateInput();
    			
    			// check if any fields are empty
    			if( !termsAndConditions.isSelected() && emailField.getText().isEmpty() && 
    			   reEnterEmailField.getText().isEmpty() && phoneNumberField.getText().length() == 0 
    			   && !validate.validateEmail(emailField.getText()) && !validate.validateEmail(reEnterEmailField.getText()) && event.getSource() == continueButton)
    			{
    			    JOptionPane.showMessageDialog(null, "Please complete some fields before you continue", 
    			   	     "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
    			}
    			
    			if(!termsAndConditions.isSelected() && phoneNumberField.getText().length() > 0 && event.getSource() == continueButton)
    			{
    			    JOptionPane.showMessageDialog(null, "Please make sure you agree to the terms and conditions.", 
    			   	     "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
    			}
    		}
    		catch(Exception e)
    		{
    			
    		}
    		
    		try
    		{
    			// making sure some fields are not empty before continuing to search for flight
    			if(event.getSource() == continueButton && emailField.getText().equalsIgnoreCase(reEnterEmailField.getText())
    				&& emailField.getText().length() > 0 && reEnterEmailField.getText().length() > 0) 
    			{
    				ValidateInput validate = new ValidateInput();
    				
    				// checking if emails are invalid
                    if(validate.validateEmail(emailField.getText()) == false || validate.validateEmail(reEnterEmailField.getText()) == false)
                    {
                        JOptionPane.showMessageDialog( null,"Sorry invalid email address. Example: xxxxxx@gmail.com",
                			"Invalid Email",JOptionPane.ERROR_MESSAGE);
                    }
                    
                    // change panel if emails are valid
                    if(validate.validateEmail(emailField.getText()) == true && validate.validateEmail(reEnterEmailField.getText()) == true
                    	&& phoneNumberField.getText().length() == 0)
                    {
                        if(termsAndConditions.isSelected() && emailField.getText() != "")
    			    	{
    				    	setTitle("Airline Reservation System               						Customer Option");
    			       	 	setSize(730, 270);
    			        	customerAuthenticationPanel.setVisible(false);
    			      		emptyPanel.add(mainMenuButtton2);
    			       		add(emptyPanel);
    			       		
    			       		termsAndConditions.setSelected(false);
    				    }
    					else
    					{
    				   		JOptionPane.showMessageDialog(null, "Please make sure you agree to the terms and conditions.", "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
    					}
                    }   
                    
                    // change panel if emails are valid
                    if( validate.validateEmail(emailField.getText()) == true && validate.validateEmail(reEnterEmailField.getText()) == true
                    	&& (validate.validatePhone(phoneNumberField.getText()) || validate.validateIntlPhone(phoneNumberField.getText())) )
                    {
                        if(termsAndConditions.isSelected() && emailField.getText() != "")
    			    	{
    				    	setTitle("Airline Reservation System               						Customer Option");
    			       	 	setSize(730, 270);
    			        	customerAuthenticationPanel.setVisible(false);
    			      		emptyPanel.add(mainMenuButtton2);
    			       		add(emptyPanel);
    			       		
    			       		termsAndConditions.setSelected(false);
    				    }
    					else
    					{
    				   	//	JOptionPane.showMessageDialog(null, "Please make sure you agree to the terms and conditions.", "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
    					}
                    }
                    
                /*    ValidateInput valid = new ValidateInput();
                    // change panel if emails are valid
                    if( event.getSource() == continueButton && valid.validateEmail(emailField.getText()) == true && valid.validateEmail(reEnterEmailField.getText()) == true
                    	&& (!valid.validatePhone(phoneNumberField.getText()) || !valid.validateIntlPhone(phoneNumberField.getText())) 
                    	&& termsAndConditions.isSelected() && emailField.getText() != "" && phoneNumberField.getText().length() > 0)
                    {
				   	   JOptionPane.showMessageDialog(null, "Please check your phone number.\n\nLocal format 061-271-5092. Intl format: +234-803-234-574/6543", "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
                    }  */
    			}
    			else if(event.getSource() != mainMenuButtton)
    			{
    				if(event.getSource() != mainMenuButtton2 && emailField.getText().compareToIgnoreCase(reEnterEmailField.getText()) != 0 
    				  && emailField.getText().length() > 0 && reEnterEmailField.getText().length() > 0)
    				{
    					JOptionPane.showMessageDialog(null, "You are seeing this message because either you have not completed the email fields, or your entered emails do not match. Please fix this issues", "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
    				}
    			     
    			}
    			     ValidateInput valid= new ValidateInput();
    			  // change panel if emails are valid
                    if( event.getSource() == continueButton && valid.validateEmail(emailField.getText()) == true && valid.validateEmail(reEnterEmailField.getText()) == true
                    	&& (!valid.validatePhone(phoneNumberField.getText()) || !valid.validateIntlPhone(phoneNumberField.getText())) 
                    	&& termsAndConditions.isSelected() && emailField.getText() != "" && phoneNumberField.getText().length() > 0 )
                    {
                    	if(!valid.validatePhone(phoneNumberField.getText()) || !valid.validateIntlPhone(phoneNumberField.getText()) && termsAndConditions.isSelected())
                    	{
                    	    JOptionPane.showMessageDialog(null, "Please check your phone number.\n\nLocal format 061-271-5092. Intl format: +2776-127-15092", "ERROR MESSAGE", JOptionPane.ERROR_MESSAGE);
                    	}
				   	  
                    }  
    			
    		}
    		catch(Exception e)
    		{
    		
    		}

    	}
    }
    
}