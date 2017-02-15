/**
 * @(#)AdminLogin.java
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

@SuppressWarnings("unchecked")
public class AdminLogin extends JFrame
{
	// instance variables
	private JButton forgotPasswordButton;
	private JButton logOnButton;
	private JButton passkeyButton;
	private JButton setPassword;
	private JButton exitToMainMenu;
	
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JTextField passkeyField;
	private JTextField newPasswordField;
	private JTextField reEnterNewPasswordField;
	
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JLabel passkeyLabel;
	private JLabel enterNewPasswordLabel;
	private JLabel reEnterNewPasswordLabel;
	
	protected JPanel authenticationPanel;
	protected JPanel forgotPanel;
	protected JPanel newPasswordPanel;

    public AdminLogin() 
    {
    	setTitle("Airline Reservation System");   // set title of frame
    	setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);   // close frame when closed
    	setSize(530, 290);    // set size of frame
    	setResizable(false);  // make frame non-resizable
    	setVisible(true);     // set the visibility of frame to false
    	setLocationRelativeTo(null);  // make frame appear at the middle of the screen
    	
    	try
        {
           UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());           // change look of all buttons
           UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");  // Set all buttons to nimbus look
        }
        catch(Exception e)
        {} 
    	
    	// instantiate all panels
    	authenticationPanel = new JPanel();
	    forgotPanel = new JPanel();
	    newPasswordPanel = new JPanel();
	    
	    // set internal layout manager of panels to null
	    authenticationPanel.setLayout(null);
	    forgotPanel.setLayout(null);
	    newPasswordPanel.setLayout(null);
	    
	    // sset background colour of all panels to black
	    authenticationPanel.setBackground(Color.BLACK);
	    forgotPanel.setBackground(Color.BLACK);
	    newPasswordPanel.setBackground(Color.BLACK);
	    
    	// Format label
    	usernameLabel = new JLabel();
    	usernameLabel.setFont(new Font("Tahoma", 1, 14));  // set font
        usernameLabel.setForeground(Color.YELLOW);
        usernameLabel.setText("Username");
    	usernameLabel.setBounds(50, 30, 100, 40);
    	
    	usernameField = new JTextField(15);
    	usernameField.setFont(new Font("Tahoma", 1, 14)); // set font
    	usernameField.setText("admin");
    	usernameField.setEditable(false);
    	usernameField.setBounds(160, 40, 200, 30);
    	
    	// Format label
    	passwordLabel = new JLabel();
    	passwordLabel.setFont(new Font("Tahoma", 1, 14)); // set font
        passwordLabel.setForeground(Color.YELLOW);
        passwordLabel.setText("Password");
    	passwordLabel.setBounds(50, 70, 100, 40);
    	
    	passwordField = new JPasswordField(15);
    	passwordField.setFont(new Font("Tahoma", 1, 14)); // set font
    	passwordField.setBounds(160, 80, 200, 30);
    	
    	// Format label
    	passkeyLabel = new JLabel();
    	passkeyLabel.setFont(new Font("Tahoma", 0, 25)); // set font
        passkeyLabel.setForeground(Color.YELLOW);
        passkeyLabel.setText("Enter Admin pass key");
    	passkeyLabel.setBounds(20, 20, 300, 40);
    	
    	passkeyField = new JTextField(13);
    	passkeyField.setFont(new Font("Tahoma", 1, 14)); // set font
    	passkeyField.setBounds(20, 60, 300, 30);
    	
    	// Format label
    	enterNewPasswordLabel = new JLabel();
    	enterNewPasswordLabel.setFont(new Font("Tahoma", 1, 14)); // set font
        enterNewPasswordLabel.setForeground(Color.YELLOW);
        enterNewPasswordLabel.setText("Enter new password");
    	enterNewPasswordLabel.setBounds(30, 30, 150, 40);
    	
    	newPasswordField = new JTextField(13);
    	newPasswordField.setFont(new Font("Tahoma", 1, 12)); // set font
    	newPasswordField.setBounds(200, 40, 170, 30);
    	
    	// Format label
    	reEnterNewPasswordLabel = new JLabel();
    	reEnterNewPasswordLabel.setFont(new Font("Tahoma", 1, 14)); // set font
        reEnterNewPasswordLabel.setForeground(Color.YELLOW);
        reEnterNewPasswordLabel.setText("Re-enter password");
    	reEnterNewPasswordLabel.setBounds(30, 80, 140, 40);
    	
    	reEnterNewPasswordField = new JTextField(13);
    	reEnterNewPasswordField.setFont(new Font("Tahoma", 1, 12)); // set font
    	reEnterNewPasswordField.setBounds(200, 90, 170, 30);
		
		// Format JButton
    	forgotPasswordButton = new JButton();
    	forgotPasswordButton.setFont(new Font("Tahoma", 1, 12)); // set font
        forgotPasswordButton.setForeground(Color.BLACK);
        forgotPasswordButton.setText("Forgot Password ?");
    	forgotPasswordButton.setBounds(50, 150, 170, 30);
		
		// Format JButton
    	logOnButton = new JButton();
    	logOnButton.setFont(new Font("Tahoma", 1, 12)); // set font
        logOnButton.setForeground(Color.BLACK);
        logOnButton.setText("Log on");
    	logOnButton.setBounds(300, 150, 170, 30);
    	
    	// Format JButton
    	exitToMainMenu = new JButton();
    	exitToMainMenu.setFont(new Font("Tahoma", 1, 14)); // set font
        exitToMainMenu.setForeground(Color.BLACK);
        exitToMainMenu.setText("Main Menu");
    	exitToMainMenu.setBounds(170, 200, 170, 30);
    	
    	// Format JButton
    	passkeyButton = new JButton();
    	passkeyButton.setFont(new Font("Tahoma", 1, 14)); // set font
        passkeyButton.setForeground(Color.BLACK);
        passkeyButton.setText("Click after entering the pass key to set a new password");
    	passkeyButton.setBounds(20, 110, 450, 40);
    	
    	// Format JButton	
    	setPassword = new JButton();
    	setPassword.setFont(new Font("Tahoma", 1, 14)); // set font
        setPassword.setForeground(Color.BLACK);
        setPassword.setText("Set Password");
    	setPassword.setBounds(220, 140, 150, 40);
    	
    	// add components to panel
    	authenticationPanel.add(usernameLabel);
    	authenticationPanel.add(usernameField);
    	authenticationPanel.add(passwordLabel);
    	authenticationPanel.add(passwordField);
    	authenticationPanel.add(forgotPasswordButton);
    	authenticationPanel.add(logOnButton);
    	authenticationPanel.add(exitToMainMenu);
    	
    	// add components to panel
    	forgotPanel.add(passkeyLabel);
    	forgotPanel.add(passkeyField);
    	forgotPanel.add(passkeyButton);
    	
    	// add components to panel
    	newPasswordPanel.add(enterNewPasswordLabel);
    	newPasswordPanel.add(newPasswordField);
    	newPasswordPanel.add(reEnterNewPasswordLabel);
    	newPasswordPanel.add(reEnterNewPasswordField);
    	newPasswordPanel.add(setPassword);
    	
    	// add panel to frame
    	add(authenticationPanel);

		// instantiate and add components to handler interface
    	ButtonHandler buttonHandler = new ButtonHandler();
    	forgotPasswordButton.addActionListener(buttonHandler);
    	logOnButton.addActionListener(buttonHandler);
    	exitToMainMenu.addActionListener(buttonHandler);
    	passkeyButton.addActionListener(buttonHandler);
    	setPassword.addActionListener(buttonHandler);	
    	
    }
    
     private class ButtonHandler implements ActionListener
    {

		public void actionPerformed(ActionEvent event)
    	{
    		try
    		{
    			if(event.getSource() == forgotPasswordButton)
    			{
    			   JOptionPane.showMessageDialog(null, "Sorry!!!, this option is not available at this time", "Message", JOptionPane.INFORMATION_MESSAGE);
    			}
    		}
    		catch(Exception e)
    		{
    		    JOptionPane.showMessageDialog(null, "Sorry!!!, this option is not available at this time", "Message", JOptionPane.INFORMATION_MESSAGE); 
    		}
    		
    		try
    		{
    			if(event.getSource() == logOnButton)
    			{
    				Authenticate authenticate = new Authenticate();	//instantiate authentication class
    				char[] pass = passwordField.getPassword();	// assign password to character array
		     		String passString = new String(pass);		// change character array to a string
		     	    boolean isCleared = authenticate.isAdminAuthenticated(passString);   // check if password is correct

		     	    if(isCleared == true)
		     	    {		
    					// Create application frame.
       					Admin frame = new Admin();					    		
       					setVisible(false);
		     	    }
		     	    else
		     	    {
		     	       //display messages to the user on  a JOptionPane if the user fails to login
		     	    	JOptionPane.showMessageDialog(null, "Your credentials are incorrect", "Message", JOptionPane.INFORMATION_MESSAGE);
		     	    	JOptionPane.showMessageDialog(null, "Please enter the correct admin Password", "Message", JOptionPane.INFORMATION_MESSAGE);
		     	    }
		     	    			
    				
    			
    			}
    		}
    		catch(Exception e)
    		{
    		
    		}
    		
    		try
    		{
    			if(event.getSource() == passkeyButton)
    			{
    			   forgotPanel.setVisible(false);   // set this panel to false
    			   setSize(420, 250);   // change size of frame
    			   setTitle("Enter New Password");   // set title
    			   add(newPasswordPanel);   // add this panel to frame
    			}
    		}
    		catch(Exception e)
    		{
    		
    		}
    		
    		try
    		{
    			if(event.getSource() == setPassword)
    			{
    				//display messages to the user on  a JOptionPane 
		     	    JOptionPane.showMessageDialog(null, "Thank you, the admin password has been changed. Please log on with the new password on your next login", "Message", JOptionPane.INFORMATION_MESSAGE);
		     	    
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
    			if(event.getSource() == exitToMainMenu)
    			{
    			   MainMenu mainMenu = new MainMenu();  // create main menu frame
    			   setVisible(false);  // set AdminLogin frame to false
    			}
    		}
    		catch(Exception e)
    		{
    		
    		}
    	}
    	
    }

}