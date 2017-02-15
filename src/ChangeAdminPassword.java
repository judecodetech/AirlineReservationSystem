/**
 * @(#)ChangeAdminPassword.java
 *
 *
 * @author 
 * @version 1.00 2014/9/28
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
import javax.swing.JPasswordField;
import javax.swing.JInternalFrame;

/* 
 *This classes functionality have been left dormant at this time.
 *This class will be fully implemented when the FORGOT PASSWORD OPTION is made functional.
 */
@SuppressWarnings("unchecked")
public class ChangeAdminPassword extends JInternalFrame
{
	private JButton setPassword;
	private JTextField newPasswordField;
	private JTextField reEnterNewPasswordField;
	
	private JLabel enterNewPasswordLabel;
	private JLabel reEnterNewPasswordLabel;

	private JPanel newPasswordPanel;
	
    public ChangeAdminPassword() 
    {
    	setTitle("Enter New Password");		
    	setSize(420, 250);
    	setClosable( true ); // make frame closable
    	setIconifiable( true ); // make frame minimizable  
    	
    		
    	try
        {
           UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());           // change look of all buttons
           UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");  // Set all buttons to nimbus look
        }
        catch(Exception e)
        {} 
        	
	    newPasswordPanel = new JPanel();
	    newPasswordPanel.setLayout(null);
	    newPasswordPanel.setBackground(Color.BLACK);
	    
    	enterNewPasswordLabel = new JLabel();
    	enterNewPasswordLabel.setFont(new Font("Tahoma", 1, 14)); // NOI18N
        enterNewPasswordLabel.setForeground(Color.YELLOW);
        enterNewPasswordLabel.setText("Enter new password");
    	enterNewPasswordLabel.setBounds(30, 30, 150, 40);
    	
    	newPasswordField = new JTextField(13);
    	newPasswordField.setFont(new Font("Tahoma", 1, 12)); // NOI18N
    	newPasswordField.setBounds(200, 40, 170, 30);
    	
    	reEnterNewPasswordLabel = new JLabel();
    	reEnterNewPasswordLabel.setFont(new Font("Tahoma", 1, 14)); // NOI18N
        reEnterNewPasswordLabel.setForeground(Color.YELLOW);
        reEnterNewPasswordLabel.setText("Re-enter password");
    	reEnterNewPasswordLabel.setBounds(30, 80, 140, 40);
    	
    	reEnterNewPasswordField = new JTextField(13);
    	reEnterNewPasswordField.setFont(new Font("Tahoma", 1, 12)); // NOI18N
    	reEnterNewPasswordField.setBounds(200, 90, 170, 30);
    	
    	setPassword = new JButton();
    	setPassword.setFont(new Font("Tahoma", 1, 14)); // NOI18N
        setPassword.setForeground(Color.BLACK);
        setPassword.setText("Set Password");
    	setPassword.setBounds(220, 140, 150, 40);
    	
    	newPasswordPanel.add(enterNewPasswordLabel);
    	newPasswordPanel.add(newPasswordField);
    	newPasswordPanel.add(reEnterNewPasswordLabel);
    	newPasswordPanel.add(reEnterNewPasswordField);
    	newPasswordPanel.add(setPassword);
    	
    	add(newPasswordPanel);
    }
    
    
}