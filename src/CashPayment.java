/**
 * @(#)CashPayment.java
 *
 *
 * @author 
 * @version 1.00 2014/9/24
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
import java.util.Random;
import java.sql.ResultSet;

@SuppressWarnings("unchecked")
public class CashPayment extends JFrame
{
	// instance variables
    private JLabel chooseBank;     
    private JLabel bankName;
    private JLabel accountHolder;
    private JLabel accountNumber;
    private JLabel branchCode;
    private JLabel paymentAmount;
    private JLabel reference;
    
    private JLabel nameOfBank;
    private JLabel accountHolderName;
    private JLabel accountNumberOfHolder;
    private JLabel branchCodeOfHolder;
    private JLabel amountToBePayed;

    private JButton nedbank;
    private JButton fnb;
    private JButton standardBank;
    private JButton absa;
    private JButton done;
    
    private int bookingID;
	private double totalPaymentAmount;
	private int paymentID;

   	static  String query = "";
   	
   	private DataBaseNoTableModel connectDBandPayByCash;

   	Random randomNumbers = new Random();
    
    public CashPayment(int bookingID, double totalPaymentAmount) 
    {
    	setTitle("Airline Reserrvation System                                              					 Cash Payment");
    	setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);   // close frame when closed
    	setSize(830, 510);	   // set size of frame
    	setResizable(false);   // make frame non-resizable
    	setVisible(true);	   // set visibility of frame to false
    	setLocationRelativeTo(null);   // make frame appear at the middle of the screen
    	setLayout(null);  // set internal layout manager to false
    	
    	try
        {
           UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());           // change look of all buttons
           UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");  // Set all buttons to nimbus look
        }
        catch(Exception e)
        {}
    	
    	// Format label
    	chooseBank = new JLabel();
    	chooseBank.setFont(new Font("Tahoma", 1, 35)); // set font
        chooseBank.setForeground(new Color(0, 0, 0));
        chooseBank.setText("Choose your Bank");
    	chooseBank.setBounds(30, 30, 600, 40);
    	
    	// Format button
    	nedbank = new JButton();
    	nedbank.setFont(new Font("Tahoma", 1, 15)); // set font
        nedbank.setForeground(new Color(0, 0, 0));
        nedbank.setText("Nedbank");
    	nedbank.setBounds(30, 110, 150, 40);
    	
    	// Format button
    	fnb = new JButton();
    	fnb.setFont(new Font("Tahoma", 1, 15)); // set font
        fnb.setForeground(new Color(0, 0, 0));
        fnb.setText("FNB");
    	fnb.setBounds(230, 110, 150, 40);
    	
    	// Format button
    	standardBank = new JButton();
    	standardBank.setFont(new Font("Tahoma", 1, 15)); // set font
        standardBank.setForeground(new Color(0, 0, 0));
        standardBank.setText("Standard Bank");
    	standardBank.setBounds(430, 110, 150, 40);
    	
    	// Format button
    	absa = new JButton();
    	absa.setFont(new Font("Tahoma", 1, 15)); // set font
        absa.setForeground(new Color(0, 0, 0));
        absa.setText("ABSA");
    	absa.setBounds(630, 110, 150, 40);
    	
    	// Format button
    	done = new JButton();
    	done.setFont(new Font("Tahoma", 1, 15)); // set font
        done.setForeground(new Color(0, 0, 0));
        done.setText("DONE");
    	done.setBounds(630, 400, 150, 40);
    	
    	// Format label
    	bankName = new JLabel();
    	bankName.setFont(new Font("Tahoma", 1, 20)); // set font
        bankName.setForeground(new Color(0, 0, 0));
        bankName.setText("Bank name is:");
    	bankName.setBounds(30, 200, 600, 40);
		
		// Format label
    	nameOfBank = new JLabel();
    	nameOfBank.setFont(new Font("Tahoma", 1, 20)); // set font
        nameOfBank.setForeground(Color.BLUE);
        nameOfBank.setText("");
    	nameOfBank.setBounds(350, 200, 600, 40);
    	
    	// Format label
    	accountHolder = new JLabel();
    	accountHolder.setFont(new Font("Tahoma", 1, 20)); // set font
        accountHolder.setForeground(new Color(0, 0, 0));
        accountHolder.setText("Account holder name:");
    	accountHolder.setBounds(30, 230, 600, 40);
		
		// Format label
    	accountHolderName = new JLabel();
    	accountHolderName.setFont(new Font("Tahoma", 1, 20)); // set font
        accountHolderName.setForeground(Color.BLUE);
        accountHolderName.setText("");
    	accountHolderName.setBounds(350, 230, 600, 40);
    	
    	// Format label
    	accountNumber = new JLabel();
    	accountNumber.setFont(new Font("Tahoma", 1, 20)); // set font
        accountNumber.setForeground(new Color(0, 0, 0));
        accountNumber.setText("Our account number:");
    	accountNumber.setBounds(30, 260, 600, 40);
    	
    	// Format label
    	accountNumberOfHolder = new JLabel();
    	accountNumberOfHolder.setFont(new Font("Tahoma", 1, 20)); // set font
        accountNumberOfHolder.setForeground(Color.BLUE);
        accountNumberOfHolder.setText("");
    	accountNumberOfHolder.setBounds(350, 260, 600, 40);
    	
    	// Format label
    	branchCode = new JLabel();
    	branchCode.setFont(new Font("Tahoma", 1, 20)); // set font
        branchCode.setForeground(new Color(0, 0, 0));
        branchCode.setText("Branch code:");
    	branchCode.setBounds(30, 290, 600, 40);
    	
    	// Format label
    	branchCodeOfHolder = new JLabel();
    	branchCodeOfHolder.setFont(new Font("Tahoma", 1, 20)); // set font
        branchCodeOfHolder.setForeground(Color.BLUE);
        branchCodeOfHolder.setText("");
    	branchCodeOfHolder.setBounds(350, 290, 600, 40);
    	
    	// Format label
    	paymentAmount = new JLabel();
    	paymentAmount.setFont(new Font("Tahoma", 1, 20)); // set font
        paymentAmount.setForeground(new Color(0, 0, 0));
        paymentAmount.setText("Payment amount:");
    	paymentAmount.setBounds(30, 320, 600, 40);
    	
    	// Format label
    	amountToBePayed = new JLabel();
    	amountToBePayed.setFont(new Font("Tahoma", 1, 20)); // set font
        amountToBePayed.setForeground(Color.BLUE);
        amountToBePayed.setText("");
    	amountToBePayed.setBounds(350, 320, 600, 40);
    	
    	// Format label
    	reference = new JLabel();
    	reference.setFont(new Font("Tahoma", 1, 20)); // set font
        reference.setForeground(new Color(0, 0, 0));
        String referenceMessage = String.format("Please use ZA5463748 as your reference at the bank");
        reference.setText(referenceMessage);
    	reference.setBounds(30, 400, 800, 40);
    	
    	// add components to frame
    	add(chooseBank);
    	add(nedbank);
    	add(fnb);
    	add(standardBank);
    	add(absa);
    	add(done);
    	add(bankName);
    	add(accountHolder);
    	add(accountNumber);
    	add(branchCode);
    	add(paymentAmount);
    	add(reference);
    	add(nameOfBank);
    	add(accountHolderName);
    	add(accountNumberOfHolder);
    	add(branchCodeOfHolder);
    	add(amountToBePayed);
    
    	// instantiate handler class and add all buttons to handler class
    	ButtonHandler buttonHandler = new ButtonHandler();
    	nedbank.addActionListener(buttonHandler);
    	fnb.addActionListener(buttonHandler);
    	standardBank.addActionListener(buttonHandler);
    	absa.addActionListener(buttonHandler);
    	done.addActionListener(buttonHandler);
    	
    	setTotalPaymentAmount(totalPaymentAmount);  // set amount from constructor
    	setBookingID(bookingID);    // set booking ID
    }
    
    private class ButtonHandler implements ActionListener
    {
		public void actionPerformed(ActionEvent event)
    	{
    		int paymentID = 0; 
    			
    		try
    		{
    			// set nebank details if nedbank button is clicked
    			if(event.getSource() == nedbank)
    			{
					Nedbank nedBank = new Nedbank();
					nameOfBank.setText(nedBank.getNameOfBank());
					accountHolderName.setText (nedBank.getAccountHolderName());
					accountNumberOfHolder.setText(nedBank.getAccountNumber());
					branchCodeOfHolder.setText(nedBank.getBranchCode());
					amountToBePayed.setText("R" + (String.format("%.2f", getTotalPaymentAmount())));
    			}
    		
    		}
    		catch(Exception e)
    		{
    		
    		}
    		
    		try
    		{
    			// set fnb details if fnb button is clicked
    			if(event.getSource() == fnb)
    			{
					FNB firstNationalBank = new FNB();
					nameOfBank.setText(firstNationalBank.getNameOfBank());
					accountHolderName.setText (firstNationalBank.getAccountHolderName());
					accountNumberOfHolder.setText(firstNationalBank.getAccountNumber());
					branchCodeOfHolder.setText(firstNationalBank.getBranchCode());
					amountToBePayed.setText("R" + (String.format("%.2f", getTotalPaymentAmount())));
    			}
    		}
    		catch(Exception e)
    		{
    		
    		}
    		
    		try
    		{
    			// set nebstandardBankank details if standardBank button is clicked
    			if(event.getSource() == standardBank)
    			{
    				StandardBank standardBANK = new StandardBank();
					nameOfBank.setText(standardBANK.getNameOfBank());
					accountHolderName.setText (standardBANK.getAccountHolderName());
					accountNumberOfHolder.setText(standardBANK.getAccountNumber());
					branchCodeOfHolder.setText(standardBANK.getBranchCode());
					amountToBePayed.setText("R" + (String.format("%.2f", getTotalPaymentAmount())));
    			}
    		
    		}
    		catch(Exception e)
    		{
    		
    		}
    		
    		try
    		{
    			// set absa details if absa button is clicked
    			if(event.getSource() == absa)
    			{
    				ABSA absaBank = new ABSA();
					nameOfBank.setText(absaBank.getNameOfBank());
					accountHolderName.setText (absaBank.getAccountHolderName());
					accountNumberOfHolder.setText(absaBank.getAccountNumber());
					branchCodeOfHolder.setText(absaBank.getBranchCode());
					amountToBePayed.setText("R" + (String.format("%.2f", getTotalPaymentAmount())));
    			}
    		
    		}
    		catch(Exception e)
    		{
    		
    		}
    		
    		try
    		{
    			if(event.getSource() == done)
    			{
    				
    				String  paymentMethod = "Payed by Acc";   // set method of payment
    				
    				try
                    {         
                    	ResultSet resultSet = null; // manages results
    					
    				    connect();   // connect to database
    				
    				    query = String.format("SELECT * from payment");   // set query message
    					
    					paymentID = 25001 + randomNumbers.nextInt( 30000 - 25001 );  // generate payment id
    					
    				    connectDBandPayByCash.setQuery(query);    // pass query message to database
				   	    connectDBandPayByCash.execute();          // execute query
				   	 
    				    resultSet = connectDBandPayByCash.getResultSet();  // get reults of query from database

				   	    while(resultSet.next())  // loop through result of query
				   	    {
                       	   if(paymentID == resultSet.getInt(1))   // check if the payment ID already exists in the database
                       	   {
                       	   	  // generate another payment ID if the above if condition is true
           	                  paymentID = 25001 + randomNumbers.nextInt( 30000 - 25001 ); 
           	                  break; 
                       	   }  // end if	
                        }    // end while
                    }
                    catch(Exception e)
                    {
                    
                    }
    			    paymentID = 25001 + randomNumbers.nextInt( 30000 - 25001 );	  
    				setPaymentID(paymentID);  // set payment id
    				 
    				// set query message   
    			    query = String.format("insert into payment(payment_id , booking_id , payment_method , name_of_card_holder , card_number, cvc_number, c_exp_date, holder_address, country , postal_code , payment_date, payment_amount)" + 
                      "VALUES (%d, %d, '%s', NULL, NULL, NULL, NULL,  NULL, NULL, NULL, CURDATE(), %f)", 
                      	paymentID, getBookingID(), paymentMethod, getTotalPaymentAmount());  
                              
                    connectDBandPayByCash.setQuery(query);    // set query
             		connectDBandPayByCash.executeUpdate();	  // execute query
             		
             		// set query message
             		query = String.format("UPDATE booking SET status = 'booked' WHERE booking_id = %d", getBookingID());
             		    
             		connectDBandPayByCash.setQuery(query);   // set query
             		connectDBandPayByCash.executeUpdate();   // execute query
             		    
             		connectDBandPayByCash.setQuery("commit");   // set query
             		connectDBandPayByCash.executeUpdate();      // execute query
             		  
             		// Format JOptionPane message   		
    				String data = String.format("Thank you for using this application. Your booking will be complete after payment has been made");
    				JLabel dataLabel = new JLabel(data);
    				dataLabel.setFont(new Font("Tahoma", 0, 20)); 
        			dataLabel.setForeground(new Color(0, 0, 0));
        			setVisible(false);  // set visibility of cashPayment frame to false
        			
    				JOptionPane.showMessageDialog(null, dataLabel, "INFORMATION MESSAGE", JOptionPane.INFORMATION_MESSAGE);
    				MainMenu mainMenu = new MainMenu();   // instantiate main menu frame
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
    		connectDBandPayByCash = new DataBaseNoTableModel();  // create an instance to database connection class
    	}
    	catch ( Exception sqlException )
      	{
         	JOptionPane.showMessageDialog( null, sqlException.getMessage(),
            "Database connection error", JOptionPane.ERROR_MESSAGE );

         	// ensure database connection is closed
         	connectDBandPayByCash.close();
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
	
	
	public void setPaymentID(int paymentID) 
	{
		this.paymentID = paymentID; 
	}

	public int getPaymentID() 
	{
		return (this.paymentID); 
	} 
     
}