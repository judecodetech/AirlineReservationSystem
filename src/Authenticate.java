/**
 * @(#)Authenticate.java
 *
 *
 * @author 
 * @version 1.00 2014/9/27
 */


public class Authenticate 
{
	// instance variables
	String adminPassword = "admin";   // set admin password to "admin"
	private String adminNewPassword;  
	private String adminReEnteredPassword;
	private String adminPasskey = "cput";   // set passkey to cput
	private String customerEmail;
	private String customeReEnterEmail;
	private String customerPhoneNumber;
	
    public Authenticate() 
    {
    	
    }
    
    public boolean isAdminAuthenticated(String adminPasswordEntered)
	{
		// do admin password validation
		if(adminPasswordEntered.equalsIgnoreCase(adminPassword))
		{
		    return true;
		}
		else
		{
			return false;
		}	
	}
	
	// do customer authentication
	public boolean isCustomerAuthenticated(String customerEmailEntered, String customeReEnterEmail)
	{
		if(customerEmailEntered.equalsIgnoreCase(customerEmailEntered) && customerPhoneNumber.startsWith ("+"))
		{
		    return true;  	
		}
		else
		{
			return false;
		}	
	}

	public void setAdminNewPassword (String adminNewPassword)
	{
		this.adminNewPassword = adminNewPassword; 
	}

	public void setAdminReEnteredPassword (String adminReEnteredPassword)
	{
		this.adminReEnteredPassword = adminReEnteredPassword; 
	}

	public void setAdminPasskey (String adminPasskey)
	{
		this.adminPasskey = adminPasskey; 
	}

	public void setCustomerEmail (String customerEmail)
	{
		this.customerEmail = customerEmail; 
	}

	public void setCustomeReEnterEmail (String customeReEnterEmail)
	{
		this.customeReEnterEmail = customeReEnterEmail; 
	}

	public void setCustomerPhoneNumber (String customerPhoneNumber)
	{
		this.customerPhoneNumber = customerPhoneNumber; 
	}

	public String getAdminNewPassword ()
	{
		return (this.adminNewPassword); 
	}

	public String getAdminReEnteredPassword ()
	{
		return (this.adminReEnteredPassword); 
	}

	public String getAdminPasskey ()
	{
		return (this.adminPasskey); 
	}

	public String getCustomerEmail ()
	{
		return (this.customerEmail); 
	}

	public String getCustomeReEnterEmail ()
	{
		return (this.customeReEnterEmail); 
	}

	public String getCustomerPhoneNumber ()
	{
		return (this.customerPhoneNumber); 
	}
    
    
    
}