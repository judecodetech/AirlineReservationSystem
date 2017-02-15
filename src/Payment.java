/**
 * @(#)Payment.java
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

@SuppressWarnings("unchecked")
public class Payment extends JFrame
{
	private JLabel completePayment;
	private JButton creditCard;
	private JButton cashPayment;
	private JButton cancelPaymentProcess;
	
	private int bookingID;
	private double totalPaymentAmount;
	
    public Payment(int bookingID, double totalPaymentAmount) 
    {
    	setTitle("Airline Reserrvation System                                               Payment Option");
    	setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    	setSize(710, 350);
    	setResizable(false);
    	setVisible(true);
    	setLocationRelativeTo(null);  
    	setLayout(null);   
    	
    	try
        {
           UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());           // change look of all buttons
           UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");  // Set all buttons to nimbus look
        }
        catch(Exception e)
        {}
    	
    	completePayment = new JLabel();
    	completePayment.setFont(new Font("Tahoma", 1, 35)); // NOI18N
        completePayment.setForeground(new Color(0, 0, 0));
        completePayment.setText("Please Choose your Payment Option");
    	completePayment.setBounds(30, 30, 900, 40);
    	
    	creditCard = new JButton();
    	creditCard.setFont(new Font("Tahoma", 1, 25)); // NOI18N
        creditCard.setForeground(new Color(0, 0, 0));
        creditCard.setText("Credit Card");
    	creditCard.setBounds(30, 140, 250, 40);
    	
    	cashPayment = new JButton();
    	cashPayment.setFont(new Font("Tahoma", 1, 25)); // NOI18N
        cashPayment.setForeground(new Color(0, 0, 0));
        cashPayment.setText("Cash Payment");
    	cashPayment.setBounds(440, 140, 230, 40);
    	
    	cancelPaymentProcess = new JButton();
    	cancelPaymentProcess.setFont(new Font("Tahoma", 1, 25)); // NOI18N
        cancelPaymentProcess.setForeground(new Color(0, 0, 0));
        cancelPaymentProcess.setText("Cancel Payment Process");
    	cancelPaymentProcess.setBounds(30, 230, 640, 40);
    	
    	add(completePayment);
    	add(creditCard);
    	add(cashPayment);
    	add(cancelPaymentProcess);
    	
    	ButtonHandler buttonHandler = new ButtonHandler();
    	creditCard.addActionListener(buttonHandler);
    	cashPayment.addActionListener(buttonHandler);
    	cancelPaymentProcess.addActionListener(buttonHandler);
    	
    	setTotalPaymentAmount(totalPaymentAmount);
    	setBookingID(bookingID);
    	
    }
    
    private class ButtonHandler implements ActionListener
    {
		
		public void actionPerformed(ActionEvent event)
    	{   
    		
    		try
    		{
    			if(event.getSource() == creditCard)
    			{
    			    // Create application frame.
       				CreditCardPayment creditCardPayment = new CreditCardPayment(getBookingID(), getTotalPaymentAmount());
    			  	setVisible(false);
    			}
    		}
    		catch(Exception e)
    		{
    		
    		}
    		
    		try
    		{
    			if(event.getSource() == cashPayment)
    			{
    				CashPayment cashPayment = new CashPayment(getBookingID(), getTotalPaymentAmount());
    				setVisible(false);
    			}
    		}
    		catch(Exception e)
    		{
    		
    		}
    		
    		try
    		{
    			if(event.getSource() == cancelPaymentProcess)
    			{
    				
    			}
    		}
    		catch(Exception e)
    		{
    		
    		}

    	}
    }
    
	public void setBookingID(int bookingID) {
		this.bookingID = bookingID; 
	}

	public int getBookingID() {
		return (this.bookingID); 
	}

	
	public void setTotalPaymentAmount(double totalPaymentAmount) {
		this.totalPaymentAmount = totalPaymentAmount; 
	}

	public double getTotalPaymentAmount() {
		return (this.totalPaymentAmount); 
	}
  
}