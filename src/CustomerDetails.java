/**
 * @(#)CustomerDetails.java
 *
 *
 * @author 
 * @version 1.00 2014/10/13
 */


public class CustomerDetails 
{
	// instance variables
    String title;
    String name;
    String middleName;
    String surname;
    String nationality;
    String passport;
    String countryOfIssue;
    String expirationDate;
	int customerID;
	
    public CustomerDetails() 
    {
    	
    }
	
	public void setTitle(String title) 
	{
		this.title = title; 
	}

	public void setName(String name) 
	{
		this.name = name; 
	}

	public void setMiddleName(String middleName) 
	{
		this.middleName = middleName; 
	}

	public void setSurname(String surname) 
	{
		this.surname = surname; 
	}

	public void setNationality(String nationality) 
	{
		this.nationality = nationality; 
	}

	public void setPassport(String passport) 
	{
		this.passport = passport; 
	}

	public void setCountryOfIssue(String countryOfIssue) 
	{
		this.countryOfIssue = countryOfIssue; 
	}

	public void setExpirationDate(String expirationDate) 
	{
		this.expirationDate = expirationDate; 
	}

	public String getTitle() 
	{
		return (this.title); 
	}

	public String getName() 
	{
		return (this.name); 
	}

	public String getMiddleName() 
	{
		return (this.middleName); 
	}

	public String getSurname() 
	{
		return (this.surname); 
	}

	public String getNationality() 
	{
		return (this.nationality); 
	}

	public String getPassport() 
	{
		return (this.passport); 
	}

	public String getCountryOfIssue() 
	{
		return (this.countryOfIssue); 
	}

	public String getExpirationDate() 
	{
		return (this.expirationDate); 
	}

	public void setCustomerID(int customerID) 
	{
		this.customerID = customerID; 
	}

	public int getCustomerID() 
	{
		return (this.customerID); 
	}   
}