/**
 * @(#)CustomerDetails.java
 *
 *
 * @author 
 * @version 1.00 2014/9/22
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
import java.util.Date;
import java.text.SimpleDateFormat;
import java.lang.String;
import java.util.ArrayList;
import java.awt.List;
import java.util.Random;
import java.util.Calendar;
import java.sql.ResultSet;

import com.toedter.calendar.*;   // import JCalendar package

@SuppressWarnings("unchecked")
public class CustomerReservationDetails extends JFrame
{
	// instance viariables
    private JLabel subMenuTitle;    		// subTitle label
    private JLabel departFrom;				// departure label
    private JLabel arriveIn;				// arrival label
   	private JLabel returnFrom;				// returnFrom label
   	private JLabel returnTo;				// returnTO label
    private JLabel adults;					// adults label
    private JLabel child;					// children label
    private JLabel title;					// title label
    private JLabel firstName;				// adult first name label
    private JLabel childFirstName;			// child first name label
    private JLabel middleName;				// adult middle name label
    private JLabel childMiddleName;			// child middle name label
    private JLabel lastName;				// adult last name label
    private JLabel childLastName;			// child last name label
    private JLabel childNationality;		// child nationality label
    private JLabel nationality;				// adult nationality label
    private JLabel passportNo;				// adult passport number
    private JLabel childPassportNo;			// child passport number
    private JLabel countryOfIssue;			// country of issue of passport for adult (label)
    private JLabel childCountryOfIssue;     // country of issue of passport for children (label)
    private JLabel dateOfExpiration;		// date of expiration of passport for adult (label)
    private JLabel childDateOfExpiration;	// date of expiration of passport for children (label)
    private JLabel mobileNumber;			// contact mobile number label
    private JLabel email;					// contact email label
    private JLabel toLabel1;
    private JLabel paymentAmount;
    private JLabel paymentLabel;					
    private JLabel toLabel2;
    private JLabel lineLabel1;
    private JLabel lineLabel2;
    private JLabel durationLabel1;			// duration label
    private JLabel durationLabel2;			// duration label
    private JLabel duration1;				// duration 
    private JLabel duration2;				// duration 
    private JLabel adultTitle;				// adullt title label
    private JLabel childrenTitle;		    // child title label
    
    private JLabel contactTitle;				// contact title label
    private JLabel contactFirstName;			// contact first name
    private JTextField contactFirstNameField;   // contact first name field
    private JLabel contactSurname;				// contact surname label
    private JTextField contactSurnameField;		// contact surname field  
    	
    private JTextField firstNameField;			// adult first name field
    private JTextField middleNameField;			// adult middle name field
    private JTextField lastNameField;			// adult last name field
    private JTextField nationalityField;		// adult nationality field
    private JTextField passportNoField;			// adult passport field
    private JTextField countryOfIssueField;		// adult country of issue field
    private JTextField emailField;				// adult email field
    private JTextField mobileNumberField;		// mobile number field
    
    private JTextField childFirstNameField;		 // child first name field
    private JTextField childMiddleNameField;	 // child middle name field
    private JTextField childLastNameField; 		 // child last name field
    private JTextField childNationalityField;    // child natinality field
    private JTextField childPassportNoField;     // child passport no field
    private JTextField childCountryOfIssueField;   // child country of issue field
    
    // button instant variables
    private JButton backButton;
    private JButton resetButton;
    private JButton continueToPaymentButton;
    private JButton captureAdultInfo;
    private JButton captureChildInfo;
    
    // combobox instance variables	
    private JComboBox titleComboBox;
    private JComboBox contactTitleBox;
    private JComboBox adultDayBox;
    private JComboBox adultMonthBox;
    private JComboBox adultYearBox;
    private JComboBox childDayBox;
    private JComboBox childMonthBox;
    private JComboBox childYearBox;
    
    // panels instance variables	
    private JPanel flightDetails;
    private JPanel contactDetails;
    private JPanel adultChildrenPanel;
    private JPanel generalPanel;
    
    // integer instance variables 
    private int NoOfAdult;
    private int NoOfChildren;
    private int bookingIdentification;
    private int bookingFlightNo;
    
    // string instance variables
    private String bookingSource;
    private String bookingDestination;
    private String bookingDepartDate;
    private String bookingArriveDate;
    private String bookingDepartTime;
    private String bookingArriveTime;
    private String bookingAirline;
    private double flightFare;
    private String classChoosen;
   	static  String query = "";
   	
   	private DataBaseNoTableModel connectDBandBook;	// database connection variable
   	
   	Random randomNumbers = new Random();     // random number generator
   	
   	JDateChooser chooser1 = new JDateChooser();   // use jCalendar's date chooser
	JDateChooser chooser2 = new JDateChooser();   // use jCalendar's date chooser
	
	int custID;      // varible to hold customer ID
    int contactID;   // varible to hold contact ID
    int bookingID;   // varible to hold booking ID
    int idTable;	 // varible to hold value to identify customer_booking table in databaase

    public CustomerReservationDetails(int bFlightNo, String bSource, String bDestination, String bDepartDate,
    String bArriveDate, String bDepartTime, String bArriveTime, String bAirline, double fFare, int bAdultNo, int bChildNo, String classChoosen)
    {
    	setTitle("Airline Reserrvation System");           // Set frame title
    	setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);   // Make the frame exit when its closed
    	setSize(990, 700);     // Set the size of the frame
    	setResizable(false);   // Make the frame non-resizable
    	setVisible(true);      // Make the frame visible
    	setLocationRelativeTo(null);  // Make the frame appear at the centre of the screen
    	
    	try
        {
           UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());           // change look of all buttons
           UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");  // Set all buttons to nimbus look
        }
        catch(Exception e)
        {}  
      	
      	// Create new instance of each panel
    	flightDetails = new JPanel();		// panel containing flight details	 
    	contactDetails = new JPanel();		// panel contacing conatc details
    	adultChildrenPanel = new JPanel();	// panel containg adult and child components
    	generalPanel = new JPanel();		// panel containg all other panels
     	
     	// Make all panels type titled border
    	flightDetails.setBorder(BorderFactory.createTitledBorder("Flight Details"));
    	adultChildrenPanel.setBorder(BorderFactory.createTitledBorder("Enter Passenger(s) Details"));
    	contactDetails.setBorder(BorderFactory.createTitledBorder("Contact Details"));
    	generalPanel.setBorder(BorderFactory.createTitledBorder(""));
 	
 		// set layout of defalut manager to null
    	flightDetails.setLayout (null);
    	contactDetails.setLayout(null);
    	adultChildrenPanel.setLayout (null);
    	generalPanel.setLayout (null);
 		
 		// Format label
    	subMenuTitle = new JLabel();
    	subMenuTitle.setFont(new Font("Tahoma", 0, 26)); // set font
        subMenuTitle.setForeground(new Color(204, 102, 0));
        subMenuTitle.setText("Passenger Details"); 
    	subMenuTitle.setBounds(380, 10, 500, 50);      // set bounds
    	
    	// Format label
    	departFrom = new JLabel();
    	departFrom.setFont(new Font("Tahoma", 1, 14));  // set font
        departFrom.setForeground(new Color(102, 153, 0));
        departFrom.setText(bSource);
    	departFrom.setBounds(30, 20, 100, 40);   		// set bounds
    	
    	// Format label
    	toLabel1 = new JLabel();
    	toLabel1.setFont(new Font("Tahoma", 1, 14));     // set font
        toLabel1.setForeground(new Color(102, 153, 0));
        toLabel1.setText("to");
    	toLabel1.setBounds(150, 20, 30, 40);     // set bounds
    	
    	// Format label
    	arriveIn = new JLabel();
    	arriveIn.setFont(new Font("Tahoma", 1, 14));     // set font
        arriveIn.setForeground(new Color(102, 153, 0));
        arriveIn.setText(bDestination);
    	arriveIn.setBounds(210, 20, 100, 40);    // set bounds
    	
    	// Format label
    	lineLabel1 = new JLabel();	
    	lineLabel1.setFont(new Font("Tahoma", 1, 14));     // set font
        lineLabel1.setForeground(new Color(102, 153, 0));
        lineLabel1.setText("--------------------------");
    	lineLabel1.setBounds(330, 20, 200, 40);     // set bounds
    	
    	// Format label
    	lineLabel2 = new JLabel();
    	lineLabel2.setFont(new Font("Tahoma", 1, 14));    // set font
        lineLabel2.setForeground(new Color(102, 153, 0));
        lineLabel2.setText("---------------------------");
    	lineLabel2.setBounds(330, 50, 200, 40);    // set bounds
    	
    	// Format label
    	durationLabel1 = new JLabel();
    	durationLabel1.setFont(new Font("Tahoma", 1, 14));     // set font
        durationLabel1.setForeground(new Color(102, 153, 0));
        durationLabel1.setText("Departure Time:");
    	durationLabel1.setBounds(530, 20, 200, 40);     // set bounds
    	
    	// Format label
    	duration1 = new JLabel();
    	duration1.setFont(new Font("Tahoma", 1, 14));     // set font
        duration1.setForeground(new Color(102, 153, 0));
        duration1.setText(bDepartTime);
    	duration1.setBounds(670, 20, 70, 40);     // set bounds
    	
    	// Format label
    	returnFrom  = new JLabel();
    	returnFrom.setFont(new Font("Tahoma", 1, 14));    // set font
        returnFrom.setForeground(new Color(102, 153, 0));
        returnFrom.setText(bDestination);
    	returnFrom.setBounds(30, 50, 100, 40);    // set bounds
    	
    	// Format label
    	toLabel2 = new JLabel();
    	toLabel2.setFont(new Font("Tahoma", 1, 14));   // set font
        toLabel2.setForeground(new Color(102, 153, 0));
        toLabel2.setText("to");
    	toLabel2.setBounds(100, 50, 30, 40);     // set bounds
    	
    	// Format label
    	returnTo = new JLabel();
    	returnTo.setFont(new Font("Tahoma", 1, 14));     // set font
        returnTo.setForeground(new Color(102, 153, 0));
        returnTo.setText(bSource);
    	returnTo.setBounds(160, 50, 100, 40);     // set bounds
    	
    	// Format label
    	durationLabel2 = new JLabel();
    	durationLabel2.setFont(new Font("Tahoma", 1, 14));     // set font
        durationLabel2.setForeground(new Color(102, 153, 0));
        durationLabel2.setText("Departure Time:");
    	durationLabel2.setBounds(530, 50, 200, 40);   // set bounds
    	
    	// Format label
    	duration2 = new JLabel();
    	duration2.setFont(new Font("Tahoma", 1, 14));     // set font
        duration2.setForeground(new Color(102, 153, 0));
        duration2.setText(bDepartTime);
    	duration2.setBounds(670, 50, 70, 40);     // set bounds    	
    		
    	// Format label
    	paymentLabel = new JLabel();
    	paymentLabel.setFont(new Font("Tahoma", 1, 14));     // set font
        paymentLabel.setForeground(new Color(102, 153, 0));
        paymentLabel.setText("Fare:");
    	paymentLabel.setBounds(780, 35, 70, 40);     // set bounds
	
    	// Format label
    	paymentAmount = new JLabel();
    	paymentAmount.setFont(new Font("Tahoma", 1, 14));     // set font
        paymentAmount.setForeground(new Color(102, 153, 0));
        String amount = String.format("R%.2f", fFare);
        paymentAmount.setText(amount);
    	paymentAmount.setBounds(830, 35, 150, 40);     // set bounds
     	
     	// Format label
    	adultTitle = new JLabel();
    	adultTitle.setFont(new Font("Tahoma", 1, 14));    // set font
        adultTitle.setForeground(new Color(0, 0, 0));
        adultTitle.setText("Adult(s)                   Please enter the details for the number of adults chosen when searching for flight, one at a time.");
    	adultTitle.setBounds(10, 10, 850, 40);   // set bounds
    	
    	// Format label
       	title = new JLabel();
    	title.setFont(new Font("Tahoma", 1, 14));   // set font
        title.setForeground(new Color(102, 153, 0));
        title.setText("Title");
    	title.setBounds(10, 40, 50, 40);    // set bounds
    	
    	// Format comboBox
    	titleComboBox = new JComboBox();
    	titleComboBox.setFont(new Font("Tahoma", 1, 14));   // set font
        titleComboBox.setForeground(new Color(102, 153, 0));
        titleComboBox.setModel(new DefaultComboBoxModel(new String[] {"Mr", "Mrs", "Ms"}));
    	titleComboBox.setBounds(10, 70, 60, 30);   // set bounds
    	
    	// Format label
    	firstName = new JLabel();
    	firstName.setFont(new Font("Tahoma", 1, 14));   // set font
        firstName.setForeground(new Color(102, 153, 0));
        firstName.setText("First Name");
    	firstName.setBounds(70, 40, 80, 40);    // set bounds
    	
    	firstNameField = new JTextField(13);
    	firstNameField.setFont(new Font("Tahoma", 1, 12));   // set font
    	firstNameField.setBounds(70, 70, 110, 30);     // set bounds
    	
    	// Format label
    	middleName = new JLabel();
    	middleName.setFont(new Font("Tahoma", 1, 14));   // set font
        middleName.setForeground(new Color(102, 153, 0));
        middleName.setText("Middle Name");  
    	middleName.setBounds(180, 40, 110, 40);     // set bounds
    	
    	middleNameField = new JTextField(13);
    	middleNameField.setFont(new Font("Tahoma", 1, 12));   // set font
    	middleNameField.setBounds(180, 70, 110, 30);    // set bounds
    	
    	// Format label
    	lastName = new JLabel();
    	lastName.setFont(new Font("Tahoma", 1, 14));   // set font
        lastName.setForeground(new Color(102, 153, 0));
        lastName.setText("Surname");
    	lastName.setBounds(290, 40, 110, 40);     // set bounds
    	
    	lastNameField = new JTextField(13);
    	lastNameField.setFont(new Font("Tahoma", 1, 12)); // set font
    	lastNameField.setBounds(290, 70, 110, 30);   // set bounds
    	
    	// Format label
    	nationality = new JLabel();
    	nationality.setFont(new Font("Tahoma", 1, 14));   // set font
        nationality.setForeground(new Color(102, 153, 0));
        nationality.setText("Nationality");
    	nationality.setBounds(400, 40, 110, 40);   // set bounds
    	
    	nationalityField = new JTextField(13);
    	nationalityField.setFont(new Font("Tahoma", 1, 12));    // set font
    	nationalityField.setBounds(400, 70, 110, 30);   // set bounds
    	
    	// Format label
    	passportNo = new JLabel();
    	passportNo.setFont(new Font("Tahoma", 1, 14));   // set font
        passportNo.setForeground(new Color(102, 153, 0));
        passportNo.setText("Passport No");
    	passportNo.setBounds(510, 40, 110, 40);   // set bounds
    	
    	passportNoField = new JTextField(13);
    	passportNoField.setFont(new Font("Tahoma", 1, 12));   // set font
    	passportNoField.setBounds(510, 70, 110, 30);   // set bounds
    	
    	// Format label
    	countryOfIssue = new JLabel();
    	countryOfIssue.setFont(new Font("Tahoma", 1, 14));    // set font
        countryOfIssue.setForeground(new Color(102, 153, 0));
        countryOfIssue.setText("Country of Issue");
    	countryOfIssue.setBounds(620, 40, 130, 40);   // set bounds
    	
    	countryOfIssueField= new JTextField(13);
    	countryOfIssueField.setFont(new Font("Tahoma", 1, 12));   // set font
    	countryOfIssueField.setBounds(620, 70, 110, 30);    // set bounds
    	
    	// Format label
    	dateOfExpiration = new JLabel();
    	dateOfExpiration.setFont(new Font("Tahoma", 1, 14));   // set font
        dateOfExpiration.setForeground(new Color(102, 153, 0));
        dateOfExpiration.setText("Expiry Date");
    	dateOfExpiration.setBounds(750, 40, 110, 40);    // set bounds
    	
    	
    	chooser1.setBounds(750, 70, 150, 30);   // set bounds for calendar
    	chooser1.setFont(new Font("Tahoma", 1, 12)); // set font
    	
    	// Format button
    	captureAdultInfo = new JButton();
        captureAdultInfo.setText("Click to Capture Adult Info");
    	captureAdultInfo.setBounds(710, 100, 230, 30);    // set bounds
 		
 		// Format label
 		childrenTitle = new JLabel();
    	childrenTitle.setFont(new Font("Tahoma", 1, 14)); // set font
        childrenTitle.setForeground(new Color(0, 0, 0));
        childrenTitle.setText("Children                Please enter the details for the number of children chosen when searching for flight, one at a time.");
    	childrenTitle.setBounds(10, 140, 850, 40);     // set bounds
    	
    	// Format label
    	childFirstName = new JLabel();
    	childFirstName.setFont(new Font("Tahoma", 1, 14));   // set font
        childFirstName.setForeground(new Color(102, 153, 0));
        childFirstName.setText("First Name");
    	childFirstName.setBounds(70, 170, 80, 40);     // set bounds
    	
    	childFirstNameField = new JTextField(13);
    	childFirstNameField.setFont(new Font("Tahoma", 1, 12));  // set font
    	childFirstNameField.setBounds(70, 200, 110, 30);    // set bounds
    	
    	// Format label
    	childMiddleName = new JLabel();
    	childMiddleName.setFont(new Font("Tahoma", 1, 14));    // set font
        childMiddleName.setForeground(new Color(102, 153, 0));
        childMiddleName.setText("Middle Name");
    	childMiddleName.setBounds(180, 170, 110, 40);     // set bounds
    	
    	childMiddleNameField = new JTextField(13);
    	childMiddleNameField.setFont(new Font("Tahoma", 1, 12));   // set font
    	childMiddleNameField.setBounds(180, 200, 110, 30);    // set bounds 
    	
    	// Format label
    	childLastName = new JLabel();
    	childLastName.setFont(new Font("Tahoma", 1, 14));   // set font
        childLastName.setForeground(new Color(102, 153, 0));
        childLastName.setText("Surname");
    	childLastName.setBounds(290, 170, 110, 40);    // set bounds
    	
    	childLastNameField = new JTextField(13);
    	childLastNameField.setFont(new Font("Tahoma", 1, 12));   // set font
    	childLastNameField.setBounds(290, 200, 110, 30);   // set bounds
    	
    	// Format label
    	childNationality = new JLabel();
    	childNationality.setFont(new Font("Tahoma", 1, 14));   // set font
        childNationality.setForeground(new Color(102, 153, 0));
        childNationality.setText("Nationality");
    	childNationality.setBounds(400, 170, 110, 40);    // set bounds
    	
    	childNationalityField = new JTextField(13);  
    	childNationalityField.setFont(new Font("Tahoma", 1, 12));  // set font
    	childNationalityField.setBounds(400, 200, 110, 30);    // set bounds
    	
    	// Format label
        childPassportNo = new JLabel();
    	childPassportNo.setFont(new Font("Tahoma", 1, 14));   // set font
        childPassportNo.setForeground(new Color(102, 153, 0));
        childPassportNo.setText("Passport No");
    	childPassportNo.setBounds(510, 170, 110, 40);   // set bounds
    	
    	childPassportNoField = new JTextField(13);
    	childPassportNoField.setFont(new Font("Tahoma", 1, 12));   // set font
    	childPassportNoField.setBounds(510, 200, 110, 30);   // set bounds
    	
    	// Format label
    	childCountryOfIssue = new JLabel();
    	childCountryOfIssue.setFont(new Font("Tahoma", 1, 14));   // set font
        childCountryOfIssue.setForeground(new Color(102, 153, 0));
        childCountryOfIssue.setText("Country of Issue");
    	childCountryOfIssue.setBounds(620, 170, 130, 40);    // set bounds
    	
    	childCountryOfIssueField= new JTextField(13);
    	childCountryOfIssueField.setFont(new Font("Tahoma", 1, 12)); // set font
    	childCountryOfIssueField.setBounds(620, 200, 110, 30);   // set bounds
    	
    	// Format label
    	childDateOfExpiration= new JLabel();
    	childDateOfExpiration.setFont(new Font("Tahoma", 1, 14));   // set font
        childDateOfExpiration.setForeground(new Color(102, 153, 0));
        childDateOfExpiration.setText("Expiry Date");
    	childDateOfExpiration.setBounds(750, 170, 110, 40);   // set bounds
    
    	chooser2.setFont(new Font("Tahoma", 1, 12)); // set font
    	chooser2.setBounds(750, 200, 150, 30);    // set bounds
    	
    	// Format button
    	captureChildInfo = new JButton();
        captureChildInfo.setText("Click to Capture Child Info");
    	captureChildInfo.setBounds(710, 230, 230, 30);    // set bounds
		
		// Format label
 		contactTitle = new JLabel();
    	contactTitle.setFont(new Font("Tahoma", 1, 14));   // set font
        contactTitle.setForeground(new Color(102, 153, 0));
        contactTitle.setText("Title");
    	contactTitle.setBounds(30, 30, 60, 40);   // set bounds
    	
    	contactTitleBox = new JComboBox();
    	contactTitleBox.setFont(new Font("Tahoma", 1, 14));   // set font
        contactTitleBox.setForeground(new Color(102, 153, 0));
        contactTitleBox.setModel(new DefaultComboBoxModel(new String[] { "Select",  "Mr", "Mrs", "Ms"}));
    	contactTitleBox.setBounds(30, 60, 80, 30);    // set bounds
    	
    	// Format label
    	contactFirstName = new JLabel();
    	contactFirstName.setFont(new Font("Tahoma", 1, 14));   // set font
        contactFirstName.setForeground(new Color(102, 153, 0));
        contactFirstName.setText("First Name");
    	contactFirstName.setBounds(110, 30, 80, 40);   // set bounds
    	
    	contactFirstNameField = new JTextField(13);
    	contactFirstNameField.setFont(new Font("Tahoma", 1, 12)); // set font
    	contactFirstNameField.setBounds(110, 60, 110, 30);    // set bounds
    	
    	// Format label
    	contactSurname = new JLabel();
    	contactSurname.setFont(new Font("Tahoma", 1, 14)); // set font
        contactSurname.setForeground(new Color(102, 153, 0));
        contactSurname.setText("Surname");
    	contactSurname.setBounds(220, 30, 80, 40);   // set bounds
    	
    	contactSurnameField = new JTextField(13);
    	contactSurnameField.setFont(new Font("Tahoma", 1, 12)); // set font
    	contactSurnameField.setBounds(220, 60, 110, 30);    // set bounds
    	
    	// Format label
    	email = new JLabel();
    	email.setFont(new Font("Tahoma", 1, 14)); // set bounds
        email.setForeground(new Color(102, 153, 0));
        email.setText("Email(example: *********@gmail.com)");
    	email.setBounds(330, 30, 400, 40);   // set bounds
    	
    	emailField = new JTextField(13);
    	emailField.setFont(new Font("Tahoma", 1, 12));  // set font
    	emailField.setBounds(330, 60, 300, 30);     // set bounds
    	
    	// Format label
    	mobileNumber = new JLabel();
    	mobileNumber.setFont(new Font("Tahoma", 1, 14));  // set font
        mobileNumber.setForeground(new Color(102, 153, 0));
        mobileNumber.setText("Mobile number (e.g 061-271-5092)");
    	mobileNumber.setBounds(30, 90, 500, 40);    // set bounds
    	
    	mobileNumberField = new JTextField(13);
    	mobileNumberField.setFont(new Font("Tahoma", 1, 12)); // set font
    	mobileNumberField.setBounds(30, 120, 200, 30);      // set bounds
 		
 		// Format button
 		backButton = new JButton("back");
    	backButton.setFont(new Font("Tahoma", 1, 12)); // set font
    	backButton.setBounds(450, 630, 100, 30);  // set bounds
 		
 		// Format button
 		resetButton = new JButton("Reset Fields");
    	resetButton.setFont(new Font("Tahoma", 1, 12));  // set font
    	resetButton.setBounds(570, 630, 100, 30);    // set bounds
    	
    	// Format button
    	continueToPaymentButton = new JButton("Continue to Payment section");
    	continueToPaymentButton.setFont(new Font("Tahoma", 1, 12));     // set font
    	continueToPaymentButton.setBounds(690, 630, 220, 30);    // set bounds
 
 		// set bounds for all panels
    	flightDetails.setBounds(10, 60, 950, 100);
    	adultChildrenPanel.setBounds(10, 170, 950, 280);
    	contactDetails.setBounds(10, 460, 760, 170);
    	generalPanel.setBounds(10, 30, 140, 50); 	
    	
    	// add flight details components to flightDetails panel
    	flightDetails.add(departFrom);
    	flightDetails.add(toLabel1);
    	flightDetails.add(arriveIn);
    	flightDetails.add(lineLabel1);
    	flightDetails.add(durationLabel1);
    	flightDetails.add(duration1);
    	flightDetails.add(returnFrom);
    	flightDetails.add(toLabel2);
    	flightDetails.add(returnTo);
    	flightDetails.add(lineLabel2);
    	flightDetails.add(durationLabel2);
    	flightDetails.add(duration2);
    	flightDetails.add(paymentLabel);
    	flightDetails.add(paymentAmount);
 		
 		// add adult and children components to adultChildrenPanel panel
 		adultChildrenPanel.add(title);
 		adultChildrenPanel.add(titleComboBox);
 		adultChildrenPanel.add(firstName);
 		adultChildrenPanel.add(firstNameField);
  		adultChildrenPanel.add(middleName);
 		adultChildrenPanel.add(middleNameField);
 		adultChildrenPanel.add(lastName);
 		adultChildrenPanel.add(lastNameField);
 		adultChildrenPanel.add(nationality);
 		adultChildrenPanel.add(nationalityField);
 		adultChildrenPanel.add(passportNo);
 		adultChildrenPanel.add(passportNoField);
 		adultChildrenPanel.add(countryOfIssue);
 		adultChildrenPanel.add(countryOfIssueField);
 		adultChildrenPanel.add(dateOfExpiration);
 		adultChildrenPanel.add(chooser1);
 		adultChildrenPanel.add(adultTitle);
 		adultChildrenPanel.add(captureAdultInfo);
 		adultChildrenPanel.add(childrenTitle);
 		adultChildrenPanel.add(childFirstName);
 		adultChildrenPanel.add(childMiddleName);
 		adultChildrenPanel.add(childLastName);
 		adultChildrenPanel.add(childNationality);
 		adultChildrenPanel.add(childPassportNo);
 		adultChildrenPanel.add(childCountryOfIssue);
 		adultChildrenPanel.add(childDateOfExpiration);
 		adultChildrenPanel.add(childFirstNameField);
 		adultChildrenPanel.add(childMiddleNameField);
 		adultChildrenPanel.add(childLastNameField);
 		adultChildrenPanel.add(childNationalityField);
 		adultChildrenPanel.add(childPassportNoField);
 		adultChildrenPanel.add(childCountryOfIssueField);
 		adultChildrenPanel.add(chooser2);
 		adultChildrenPanel.add(captureChildInfo);
        
        // add contact components to contactDetails panel
        contactDetails.add(contactTitle);
        contactDetails.add(contactTitleBox);
        contactDetails.add(contactFirstName);
        contactDetails.add(contactFirstNameField);
        contactDetails.add(contactSurname);
        contactDetails.add(contactSurnameField);
        contactDetails.add(email);
        contactDetails.add(emailField);
        contactDetails.add(mobileNumber);
        contactDetails.add(mobileNumberField);   
  	
  		// add components to the general panel
    	generalPanel.add(subMenuTitle);
    	generalPanel.add(backButton);
    	generalPanel.add(resetButton);
    	generalPanel.add(continueToPaymentButton);    	
    	
    	// add all panels to the frame
    	add(flightDetails);
    	add(adultChildrenPanel);
    	add(contactDetails);
    	add(generalPanel);
	
    	ButtonHandler buttonHandler = new ButtonHandler(); 	// instantiate button handler
    	
    	// add buttons to listener
    	captureAdultInfo.addActionListener(buttonHandler);  
    	captureChildInfo.addActionListener(buttonHandler);
    	backButton.addActionListener(buttonHandler);
    	resetButton.addActionListener(buttonHandler);
    	continueToPaymentButton.addActionListener(buttonHandler);
    	
	  	
	  	// set items gotten from constructor	
    	setBookingFlightNo(bFlightNo);
    	setBookingAirline(bookingAirline);
    	setBookingSource(bSource);
    	setBookingDestination(bDestination);
    	setBookingDepartDate(bDepartDate);
    	setBookingArriveDate(bArriveDate);
    	setBookingDepartTime(bDepartTime);
        setBookingArriveTime(bArriveTime);
        setFlightFare(fFare);
    	setNoOfAdult(bAdultNo);	
    	setNoOfChildren(bChildNo);
    	setClassChoosen(classChoosen); 
    } 
    	
    private class ButtonHandler implements ActionListener
    {
        int adultCount;   // count number of adults 
        int childCount;   // count number of children
        
        ArrayList<Adult> adultData = new ArrayList<Adult>();        // arralList to hold adult information
 	    ArrayList<Children> childData = new ArrayList<Children>();  // arralList to hold children information
   
		public void actionPerformed(ActionEvent event)
    	{
    		boolean custNumberIntegrityPassed = false;    // variable to check if generated primary key is found in the database
    		
    		Adult adult = new Adult();			// create an instance of adult class
    	    Children children = new Children(); // create an instance of children class
    	    
    	    Date date1 = chooser1.getDate();    // get date from JCalendar
	  		Date date2 = chooser2.getDate();    // get date from JCalendar
    	    
            String adultExpDate;    // adult passport expiration date
            String childExpDate;    // children passport expiration date
            
    		try
    		{  
    		    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-M-dd");   // format date
 	    	
 	    		// check if the number of adults specified during flight search is exceeded
    			if(event.getSource() == captureAdultInfo && adultCount < getNoOfAdult())
    			{
    				adultExpDate = sdf1.format(date1.getTime());  // get formatted date
    				
    				ValidateInput validate = new ValidateInput();   // instantiate validation class
                    
                    // check if first name is valid
                    if(!validate.validateFirstName(firstNameField.getText()))
                    {
                        JOptionPane.showMessageDialog( null,"Sorry invalid first name. Must be alphabets",
                		    "Invalid first name",JOptionPane.ERROR_MESSAGE);
                    }
                    
                    // check if last name name is valid
                    if(!validate.validateLastName(lastNameField.getText()))
                    {
                    	JOptionPane.showMessageDialog( null,"Sorry invalid last name. Must be alphabets",
                			"Invalid last name",JOptionPane.ERROR_MESSAGE);
                    }
                       
                    // check if date is empty
                    if(adultExpDate.isEmpty())
                    {
                        JOptionPane.showMessageDialog( null,"Please pick a date. Click the icon next to the date field",
                			"Invalid date",JOptionPane.ERROR_MESSAGE);
                    }
                    
                    // check if middle name is valid
                    if(!validate.validateMiddleName(middleNameField.getText()))
                    {
                        JOptionPane.showMessageDialog( null,"Sorry invalid middle name. Must be alphabets",
                			"Invalid middle name",JOptionPane.ERROR_MESSAGE);
                    }
                    
                    // check if nationality is valid
                    if(!validate.validateNationality(nationalityField.getText()))
                    {
                        JOptionPane.showMessageDialog( null,"Sorry invalid nationality",
                			"Invalid nationality",JOptionPane.ERROR_MESSAGE);
                    }
                    
                    // check if country is valid
                    if(!validate.validateCountryOfIssue(countryOfIssueField.getText()))
                    {
                        JOptionPane.showMessageDialog( null,"Sorry invalid country of issue",
                			"Invalid country of issue",JOptionPane.ERROR_MESSAGE);
                    }
                    
                    // check if passport no is valid
                    if(!validate.validatePassportNoOrID(passportNoField.getText()))
                    {
                        JOptionPane.showMessageDialog( null,"Sorry invalid passport number or ID.\nMust be 16 digits for ID.\n"
                           + "Must start with an alphabet for passport no",
                			"Invalid passport no or id",JOptionPane.ERROR_MESSAGE);
                    }
                    
                    try
                    {         
                    	ResultSet resultSet = null; // manages results
    					
    				    connect();   // connect to database
    				
    				    query = String.format("SELECT * from customer");   // set query message
    					
    					custID =  15001 + randomNumbers.nextInt( 20000 - 15001 );   // generate customer ID
    					
    				    connectDBandBook.setQuery(query);    // pass query message to database
				   	    connectDBandBook.execute();          // execute query
				   	 
    				    resultSet = connectDBandBook.getResultSet();  // get reults of query from database
				   	    
				   	      
				   	    while(resultSet.next())  // loop through result of query
				   	    {
                       	   if(custID == resultSet.getInt(1))   // check if the customer ID already exists in the database
                       	   {
                       	   	  // generate another customer ID if the above if condition is true
           	                  custID =  15001 + randomNumbers.nextInt( 20000 - 15001 );   
                       	   }  // end if	
                        }    // end while
                    }
                    catch(Exception e)
                    {
                    
                    }
        		
    				// check to make sure all validations have been successful
    				if(validate.validateFirstName(firstNameField.getText()) && validate.validateLastName(lastNameField.getText()) &&
                    	validate.validateMiddleName(middleNameField.getText()) && validate.validateNationality(nationalityField.getText()) && 
                    	validate.validateCountryOfIssue(countryOfIssueField.getText()) && validate.validatePassportNoOrID(passportNoField.getText())
                    	&& !adultExpDate.isEmpty())
                    {
                    	// set all adult items
    			    	adult.setCustomerID(custID);   // set customer ID
    			   		adult.setTitle(titleComboBox.getSelectedItem().toString());   // set title
    			    	adult.setName(firstNameField.getText());   // set first name
    			    	adult.setMiddleName(middleNameField.getText());   // set middle name
    			   	 	adult.setSurname(lastNameField.getText());		  // set last name
    			    	adult.setNationality(nationalityField.getText());  // set nationality
    			    	adult.setPassport(passportNoField.getText());		// set passport number
    			    	adult.setCountryOfIssue(countryOfIssueField.getText());  // set country where passport was issued
    			    	adult.setExpirationDate(adultExpDate);    // set passport number
    			    	
    			     
    		     		/*   for(int count = 0; count < 5000; count ++)
    			    		 {
    			        		int custID =  15001 + randomNumbers.nextInt( 20001 - 15001 );
    			        		System.out.print("  " + custID);
    			        		if(custID == 20000)
    			        		{
    			           			System.out.print("Cust id is   " + custID);
    			           			break;
    			        		}
    			        		if(count % 30 == 0)
    			        				System.out.println("");
							 }
    			 		   System.out.printf("\n\nDate is %s\n\n", adultExpDate);
    					   System.out.print("  " + custID);   */
    					   
    			    	adultData.add(adult);  // add adult items to arrayList
						
						// advice user to enter number adult information
    			    	JOptionPane.showMessageDialog( null, "Please enter the next adult information", 
                          "INFORMATION MESSAGE", JOptionPane.INFORMATION_MESSAGE );
                           
    			    	resetAdultFields();  // reset all fields 
    			    	adultCount++;   // increment the number of adults that have been entered
                    }
    			    
    			 }
    			 // check if the number of entered adults is equal to the specified number of adults entered during flight search
    			 // and check if the user wants to capture again when they have reached met the first condition
    			 else if(adultCount == getNoOfAdult() && event.getSource() == captureAdultInfo)
    			 {
    				 JOptionPane.showMessageDialog( null, "You have entered the number of adults you specified\nduring your search process. Please continue to other inputs", 
                          "INFORMATION MESSAGE", JOptionPane.INFORMATION_MESSAGE );
                     resetAdultFields();
    			 }
    		}
    		catch(Exception e)
    		{
    		   e.printStackTrace();
    		}
    		
    		try
    		{
    		    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-M-dd");   // format date
    			
    			// check if the number of children specified during flight search is exceeded	
    			if(event.getSource() == captureChildInfo && childCount < getNoOfChildren())
    			{
    				
	   				childExpDate = sdf2.format(date2.getTime());  // get formatted date
	   				
	   				ValidateInput validate = new ValidateInput();  // instantiate validation class
                    
                    // check if first name is validated
                    if(!validate.validateFirstName(childFirstNameField.getText()))
                    {
                        JOptionPane.showMessageDialog( null,"Sorry invalid first name. Must be alphabets",
                		    "Invalid first name",JOptionPane.ERROR_MESSAGE);
                    }
                    
                    // check if last name is validated
                    if(!validate.validateLastName(childLastNameField.getText()))
                    {
                    	JOptionPane.showMessageDialog( null,"Sorry invalid last name. Must be alphabets",
                			"Invalid last name",JOptionPane.ERROR_MESSAGE);
                    }
                    
                    // check if middle name is validated
                    if(!validate.validateMiddleName(childMiddleNameField.getText()))
                    {
                        JOptionPane.showMessageDialog( null,"Sorry invalid middle name. Must be alphabets",
                			"Invalid middle name",JOptionPane.ERROR_MESSAGE);
                    }
                    
                      // check if date is empty
                    if(childExpDate.isEmpty())
                    {
                        JOptionPane.showMessageDialog( null,"Please pick a date. Click the icon next to the date field",
                			"Invalid date",JOptionPane.ERROR_MESSAGE);
                    }
                    
                    // check if nationality is validated
                    if(!validate.validateNationality(childNationalityField.getText()))
                    {
                        JOptionPane.showMessageDialog( null,"Sorry invalid nationality",
                			"Invalid nationality",JOptionPane.ERROR_MESSAGE);
                    }
                    
                    // check if country is validated
                    if(!validate.validateCountryOfIssue(childCountryOfIssueField.getText()))
                    {
                        JOptionPane.showMessageDialog( null,"Sorry invalid country of issue",
                			"Invalid country of issue",JOptionPane.ERROR_MESSAGE);
                    }
                    
                    // check if first name is validated
                    if(!validate.validatePassportNoOrID(childPassportNoField.getText()))
                    {
                        JOptionPane.showMessageDialog( null,"Sorry invalid passport number or ID.\nMust be 13 digits for ID.\n"
                           + "Must start with an alphabet for passport no",
                			"Invalid passport no or id",JOptionPane.ERROR_MESSAGE);
                    }
                    
                    try
                    {         
                    	ResultSet resultSet = null; // manages results
    					
    				    connect();    // connect to database
    				
    				    query = String.format("SELECT * from customer");   // set query for database
    					
    					custID =  15001 + randomNumbers.nextInt( 20000 - 15001 );   // generate customer ID
    					
    				    connectDBandBook.setQuery(query);   // pass query to database
				   	    connectDBandBook.execute();         // execute query
				   	 
    				    resultSet = connectDBandBook.getResultSet();   // get result of query
				   	    
				   	    // loop through result of query 
				   	    while(resultSet.next())
				   	    {
				   	       // check if cust ID is found in database
                       	   if(custID == resultSet.getInt(1))  
                       	   {
                       	   	  // generate new customer ID if the customer ID is found in database
           	                  custID =  15001 + randomNumbers.nextInt( 20000 - 15001 );  
                       	   } 	
                       	
                        }
                    }
                    catch(Exception e)
                    {
                    
                    }
                    
                    // check if all validations were successful
                    if(validate.validateFirstName(childFirstNameField.getText()) && validate.validateLastName(childLastNameField.getText()) && 
                    	validate.validateMiddleName(childMiddleNameField.getText()) && validate.validateNationality(childNationalityField.getText()) && 
                    	validate.validateCountryOfIssue(childCountryOfIssueField.getText()) && validate.validatePassportNoOrID(childPassportNoField.getText())
                    	&& childExpDate.isEmpty())
                    { 
                    	// set all child information
    					children.setTitle("Child");
    			    	children.setCustomerID(custID);
    			    	children.setName(childFirstNameField.getText());
    			    	children.setMiddleName(childMiddleNameField.getText());
    			   	 	children.setSurname(childLastNameField.getText());
    			    	children.setNationality(childNationalityField.getText());
    			    	children.setPassport(childPassportNoField.getText());
    			    	children.setCountryOfIssue(childCountryOfIssueField.getText());
    			    	children.setExpirationDate(childExpDate);
    			     
    			    	childData.add(children);  // add children information to arrayList
    			     
    			    	JOptionPane.showMessageDialog( null, "Please enter the next child information", 
                          "INFORMATION MESSAGE", JOptionPane.INFORMATION_MESSAGE );
                        
    			    	resetChildFields();  // reset all fields
    			    	childCount++;       // increment the number of children that have been entered
                    }
    			}
    			// check if the number of entered children is equal to the specified number of children entered during flight search
    			// and check if the user wants to capture again when they have reached met the first condition
    			else if(event.getSource() == captureChildInfo && childCount == getNoOfChildren())
    			{
    				JOptionPane.showMessageDialog( null, "Either you have entered the number of children you "
    				  +	"specified\nduring your search process OR you have reach your entry limit. Please continue to other inputs", 
                           "INFORMATION MESSAGE", JOptionPane.INFORMATION_MESSAGE );
                   
                    resetChildFields();
    			}
    		}
    		catch(Exception e)
    		{

    		}
    		
    		try
    		{
    			if(event.getSource() == backButton)
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
    			// reseet all fields if  resetButton is clicked
    			if(event.getSource() == resetButton)
    			{
    				resetFields();
    			}
    		}
    		catch(Exception e)
    		{
    		
    		}
    		
    		try
    		{  
    			if(event.getSource() == continueToPaymentButton)
    			{
    				// making sure the user enters a contact ID before proceeding to payment
    				if(contactTitle.getText().isEmpty() || contactFirstNameField.getText().isEmpty() ||contactSurnameField.getText().isEmpty()
    					    ||  emailField.getText().isEmpty() ||  mobileNumberField.getText().isEmpty())
    			    {
    			    	JOptionPane.showMessageDialog( null, "Please complete the fields labelled with * before you proceed", 
                           "INFORMATION MESSAGE", JOptionPane.INFORMATION_MESSAGE );
                        
                        if(adultData.isEmpty())  // check if the arrayList is empty which indicated that no customer info was entered
                        {
                           JOptionPane.showMessageDialog( null, "You have not entered any customer data.\nPlease enter atleast one adult data", 
                            "INFORMATION MESSAGE", JOptionPane.INFORMATION_MESSAGE );
                        }
    			    }
    			    else
    			    {
    			    	try
    			    	{
    			    		 
    			    	/*	System.out.printf("%d, '%s', '%s', '%s', '%s', %s", contactID,  contactTitleBox.getSelectedItem().toString(), contactFirstNameField.getText(), 
                               	contactSurnameField.getText(), emailField.getText(), mobileNumberField.getText());   */

	   						 ValidateInput validate = new ValidateInput();  // instantiate validation class
                    		 
                    		 // check if first name is valid
                   			 if(!validate.validateFirstName(contactFirstNameField.getText()))
                    		 {
                        		JOptionPane.showMessageDialog( null,"Sorry invalid first name. Must be alphabets",
                		    	     "Invalid first name",JOptionPane.ERROR_MESSAGE);
                    		 }
                    		 
                    		 // check if last name is valid
                    		 if(!validate.validateLastName(contactSurnameField.getText()))
                    		 {
                    			JOptionPane.showMessageDialog( null,"Sorry invalid last name. Must be alphabets",
                					"Invalid last name",JOptionPane.ERROR_MESSAGE);
                    		 }
                    		 
                    		 // check if email is valid
                    		 if(!validate.validateEmail(emailField.getText()))
                    		 {
                    			JOptionPane.showMessageDialog( null,"Sorry invalid email.\n\nExample: xxxxxx@gmail.com",
                					"Invalid email",JOptionPane.ERROR_MESSAGE);
                    		 }
                    		 
                    		 // check if phone number is valid
                    		 if(!validate.validatePhone(mobileNumberField.getText()))
                    		 {
                    	    	JOptionPane.showMessageDialog(null, "Please check your phone number.\n\nLocal format 061-271-5092.", "Invalid phone number", JOptionPane.ERROR_MESSAGE);
                    		 }
                    		 
                    		 // check if user selected a title
                    		 if(contactTitleBox.getSelectedIndex() == 0)
                    		 {
                    			JOptionPane.showMessageDialog( null,"Invalid title. Choose a title",
                					"Invalid title",JOptionPane.ERROR_MESSAGE);
                    		 }
                    		 
                    		 try
                    		 {         
                    			ResultSet resultSet = null; // manages results
    					
    				    		connect();  // connect to databse
    				
    				    		query = String.format("SELECT * from customer_contact");  // set query message
    					
    							contactID = 10001 + randomNumbers.nextInt( 15000 - 10001 ); // generate contact ID
    							
    				    		connectDBandBook.setQuery(query);     // set query
				   	    		connectDBandBook.execute();			  // execute query
				   	 
    				    		resultSet = connectDBandBook.getResultSet();  // get result from database
				   	      
				   	            // loop through results from database
				   	    		while(resultSet.next())
				   	    		{
                       	   			if(contactID == resultSet.getInt(1)) // check if generated contact ID is found in database
                       	   			{
                       	   				// generate a new contact ID if the previously generated one is found in the database
           	                  			contactID = 10001 + randomNumbers.nextInt( 15000 - 10001 );
                       	   			} 	
                        		}
                        		
    				    		query = String.format("SELECT * from booking");  // set query message
    					
    							bookingID = 20001 + randomNumbers.nextInt( 25000 - 20001 );  // generate booking ID
    					
    				    		connectDBandBook.setQuery(query);   // set query
				   	    		connectDBandBook.execute();         // execute query
				   	 
    				    		resultSet = connectDBandBook.getResultSet();   // get result from database
				   	      		
				   	      		// loop through results from database
				   	    		while(resultSet.next())
				   	    		{
                       	   			if(bookingID == resultSet.getInt(1))   // check if generated booking ID is found in database
                       	   			{
                       	   				// generate a new booking ID if the previously generated one is found in the database
           	                  		    bookingID = 20001 + randomNumbers.nextInt( 25000 - 20001 );
                       	   			} 	
                        		}
                    		 }
                    		 catch(Exception e)
                    		 {
                    
                    		 }
                    		 
                    		 // check to make sure all contact information is valid
                    		 if(validate.validateFirstName(contactFirstNameField.getText()) && validate.validateLastName(contactSurnameField.getText()) && 
                    		    validate.validateEmail(emailField.getText()) && validate.validatePhone(mobileNumberField.getText()) && contactTitleBox.getSelectedIndex() > 0)
                    		 { 
                    		    connect();    // connect to database
    			    	     
    			    	     	// set query message
    			    	     	query = String.format("insert into customer_contact(contact_id, contact_title, contact_fname, contact_surname, contact_email, contact_phone)" + 
                               		"VALUES (%d, '%s', '%s', '%s', '%s', '%s')", contactID,  contactTitleBox.getSelectedItem().toString(), contactFirstNameField.getText(), 
                               		contactSurnameField.getText(), emailField.getText(), mobileNumberField.getText()); 

                             	connectDBandBook.setQuery(query);   // set query
                				connectDBandBook.executeUpdate();   // execute query
                			 
                			 	// populate customer table with information from arrayList
                		     	for(int count = 0; count < adultData.size(); count++)
                	         	{
                	         	   // set query message
                			       query = String.format("insert into customer(cust_id, contact_id, cust_fname, cust_mname, cust_surname, cust_title, nationality, passport_no, country_of_issue , p_exp_date)" + 
                                   "VALUES (%d, %d, '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')", adultData.get(count).getCustomerID(), contactID, adultData.get(count).getName(), 
                                  	 adultData.get(count).getMiddleName(), adultData.get(count).getSurname(),  adultData.get(count).getTitle(), adultData.get(count).getNationality(), adultData.get(count).getPassport(),
                                  	 adultData.get(count).getCountryOfIssue(), adultData.get(count).getExpirationDate());
                             
                                   connectDBandBook.setQuery(query);   // set query
                			       connectDBandBook.executeUpdate();   // execute query
                			 	}
                			 	
                			    // populate customer table with information from arrayList
                		     	for(int count = 0; count < childData.size(); count++)
                			 	{
                			 		// set query message
                			    	query = String.format("insert into customer(cust_id, contact_id, cust_fname, cust_mname, cust_surname, cust_title, nationality, passport_no, country_of_issue , p_exp_date )" + 
                                  	  "VALUES (%d, %d, '%s', '%s', '%s', 'Child', '%s', '%s', '%s', '%s')", childData.get(count).getCustomerID(), contactID, childData.get(count).getName(), 
                                  	childData.get(count).getMiddleName(), childData.get(count).getSurname(), childData.get(count).getNationality(), childData.get(count).getPassport(),
                                  	childData.get(count).getCountryOfIssue(), childData.get(count).getExpirationDate());
                             
                                 	connectDBandBook.setQuery(query);  // set query
                			     	connectDBandBook.executeUpdate();  // execute query
                			 	}
                			 
                			    
							 	String stat = "not booked";   // set booking status
							 	
							 	// set query message
                			 	query = String.format("insert into booking(booking_id, flight_no, class, status)" + 
                               		"VALUES (%d, %d, '%s', '%s')", bookingID,  getBookingFlightNo(), getClassChoosen(), stat);  
      						
      						 	connectDBandBook.setQuery(query);   // set query
                			 	connectDBandBook.executeUpdate();   // execute query
                			 
                			 	setBookingID(bookingID);   // set booking ID

                			  	for(int count = 0; count < adultData.size(); count++)
                			  	{
                			  	    try
                    		        {         
                    					ResultSet resultSet = null; // manages results
    					
    				    				connect();   // connect to database
    				
    				    				query = String.format("SELECT * from customer_booking");  // set query message
    					
    									idTable = 1 + randomNumbers.nextInt( 5000 );  // generate customer_booking table primary key
    					
    				    				connectDBandBook.setQuery(query);    // set query
				   	    				connectDBandBook.execute();		     // execute query
				   	 
    				    				resultSet = connectDBandBook.getResultSet();  // get result of query from database
				   	      				
				   	      				// loop through query result
				   	    				while(resultSet.next())
				   	    				{
                       	   					if(idTable == resultSet.getInt(1))  // check if generated idTable is found in database
                       	   					{
                       	   						// generate a new idTable if the previously generated one is found in the database
           	                  				    idTable = 1 + randomNumbers.nextInt( 5000 );  
                       	   					} 	
                        				}
                    		        }
                    		        catch(Exception e)
                    		 		{
                    
                    		 		}
                        			
                        			// set query message
                			        query = String.format("insert into customer_booking(id_table, cust_id , booking_id)" + 
                                     "VALUES (%d, %d, %d)",idTable, adultData.get(count).getCustomerID(), bookingID);
                             
                                    connectDBandBook.setQuery(query);    // set query
                			        connectDBandBook.executeUpdate();	 // execute query
                			    }

                			    for(int count = 0; count < childData.size(); count++)
                			    {
                			       try
                    		        {         
                    					ResultSet resultSet = null; // manages results
    					
    				    				connect();   // connect to database
    									
    				    				query = String.format("SELECT * from customer_booking"); // set query message
    					
    									idTable = 1 + randomNumbers.nextInt( 5000 );  // generate customer_booking table primary key
    					
    				    				connectDBandBook.setQuery(query);   // set query
				   	    				connectDBandBook.execute();   		// execute query
				   	 
    				    				resultSet = connectDBandBook.getResultSet();   // get result of query from database
				   	      				
				   	      				// loop through query result
				   	    				while(resultSet.next())
				   	    				{
                       	   					if(idTable == resultSet.getInt(1)) // check if generated idTable is found in database
                       	   					{
                       	   						// generate a new idTable if the previously generated one is found in the database
           	                  				    idTable = 1 + randomNumbers.nextInt( 5000 );
                       	   					} 	
                        				}
                    		        }
                    		        catch(Exception e)
                    		 		{
                    
                    		 		}
									
									// set query message to insert information into database                        
                			        query = String.format("insert into customer_booking(id_table, cust_id , booking_id)" + 
                                     "VALUES (%d, %d, %d)", idTable, childData.get(count).getCustomerID(), bookingID);

                                    connectDBandBook.setQuery(query);   // set query
                			        connectDBandBook.executeUpdate();	// execute query
                			    }   
                			    	
                			  	connectDBandBook.setQuery("commit");     // write all information to disk to make them permanent
                			  	connectDBandBook.execute();				 // execute query
                			 
                			  	JOptionPane.showMessageDialog( null,"Your details have been added added to the database\nYou will now be forwarded to the payment section",
                			   		"Details Entered", JOptionPane.PLAIN_MESSAGE);
                			   	
                			   	// instantiate payment class
    			        		Payment payment = new Payment(getBookingID(), getFlightFare());
    				    		setVisible(false);   // set customer reservation class frame visibility to false
                    		 }
    			    	    
    			    	}
    			    	catch ( Exception sqlException )
      					{
         			    	JOptionPane.showMessageDialog( null, "Database error, Something went wrong", "ERROR", JOptionPane.ERROR_MESSAGE );
            			 		sqlException.printStackTrace();
      					} // end catch
      					finally
				   		{
				           connectDBandBook.close();
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
    		connectDBandBook = new DataBaseNoTableModel();
    	}
    	catch ( Exception sqlException )
      	{
         	JOptionPane.showMessageDialog( null, sqlException.getMessage(),
            "Database connection error", JOptionPane.ERROR_MESSAGE );

         	// ensure database connection is closed
         	connectDBandBook.close();
      	} // end catch
    }
    
    public void resetFields()
    {
    	firstNameField.setText(null);
    	middleNameField.setText(null);
    	lastNameField.setText(null);
    	nationalityField.setText(null);
    	passportNoField.setText(null);
    	countryOfIssueField.setText(null);
    	childFirstNameField.setText(null);
    	childMiddleNameField.setText(null);
    	childLastNameField.setText(null);
    	childNationalityField.setText(null);
    	childPassportNoField.setText(null);
    	childCountryOfIssueField.setText(null);
    	contactFirstNameField.setText(null);
    	contactSurnameField.setText(null);
    	emailField.setText(null);
    	mobileNumberField.setText(null);
    }
    
    public void resetAdultFields()
    {
    	firstNameField.setText(null);
    	middleNameField.setText(null);
    	lastNameField.setText(null);
    	nationalityField.setText(null);
    	passportNoField.setText(null);
    	countryOfIssueField.setText(null);
    	titleComboBox.setSelectedIndex(0);
        chooser1.setCalendar(null);
    }
    
    public void resetChildFields()
    {
        childFirstNameField.setText(null);
    	childMiddleNameField.setText(null);
    	childLastNameField.setText(null);
    	childNationalityField.setText(null);
    	childPassportNoField.setText(null);
    	childCountryOfIssueField.setText(null);
    	chooser2.setCalendar(null);
    }

	public void setBookingFlightNo(int bookingFlightNo) 
	{
		this.bookingFlightNo = bookingFlightNo; 
	}
	
	public int getBookingFlightNo() 
	{
		return (this.bookingFlightNo); 
	}
	
	public void setBookingSource(String bookingSource) 
	{
		this.bookingSource = bookingSource; 
	}
	
	public String getBookingSource() 
	{
		return (this.bookingSource); 
	}
	
	public void setBookingDepartTime(String bookingDepartTime) 
	{
		this.bookingDepartTime = bookingDepartTime; 
	}
	
	public String getBookingDepartTime() 
	{
		return (this.bookingDepartTime); 
	}

	public void setBookingDepartDate(String bookingDepartDate) 
	{
		this.bookingDepartDate = bookingDepartDate; 		
	}
	
	public String getBookingDepartDate() 
	{
		return (this.bookingDepartDate); 
	}
	
	public void setBookingArriveTime(String bookingArriveTime) 
	{
		this.bookingArriveTime = bookingArriveTime; 
	}
	
	public String getBookingArriveTime() 
	{
		return (this.bookingArriveTime); 
	}

	public void setBookingArriveDate(String bookingArriveDate) 
	{
		this.bookingArriveDate = bookingArriveDate; 
	}
	
	public String getBookingArriveDate() 
	{
		return (this.bookingArriveDate); 
	}
	
	public void setBookingAirline(String bookingAirline) 
	{
		this.bookingAirline = bookingAirline; 
	}
	
	public String getBookingAirline() 
	{
		return (this.bookingAirline); 
	}

	public void setBookingDestination(String bookingDestination) 
	{
		this.bookingDestination = bookingDestination; 
	}

	public String getBookingDestination() 
	{
		return (this.bookingDestination); 
	}

	public void setFlightFare(double flightFare) 
	{
		this.flightFare = flightFare; 
	}

	public double getFlightFare() 
	{
		return (this.flightFare); 
	}

	
	public void setNoOfChildren(int NoOfChildren) 
	{
		this.NoOfChildren = NoOfChildren; 
	}

	public int getNoOfChildren() 
	{
		return (this.NoOfChildren); 
	}

	
	public void setNoOfAdult(int NoOfAdult) 
	{
		this.NoOfAdult = NoOfAdult; 
	}

	public int getNoOfAdult() 
	{
		return (this.NoOfAdult); 
	}

	public void setClassChoosen(String classChoosen) 
	{
		this.classChoosen = classChoosen; 
	}

	public String getClassChoosen() 
	{
		return (this.classChoosen); 
	}
	
	public void setBookingID(int bookingIdentification) 
	{
		this.bookingIdentification = bookingIdentification; 
	}
	
	public int getBookingID() 
	{
		return (this.bookingIdentification); 
	}
}