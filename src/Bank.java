/**
 * @(#)Bank.java
 *
 *
 * @author 
 * @version 1.00 2014/9/24
 */

@SuppressWarnings("unchecked")
public abstract class Bank 
{
	// instance variables
	private String nameOfBank;
	private String accountHolderName;
	private String accountNumber;
	private String branchCode;
	private String amountToBePaid;
	
    public Bank() 
    {
    	
    }

	public void setNameOfBank (String nameOfBank)
	{
		this.nameOfBank = nameOfBank; 
	}

	public void setAccountHolderName (String accountHolderName)
	{
		this.accountHolderName = accountHolderName; 
	}

	public void setAccountNumber (String accountNumber)
	{
		this.accountNumber = accountNumber; 
	}

	public void setBranchCode (String branchCode)
	{
		this.branchCode = branchCode; 
	}

	public void setAmountToBePaid (String amountToBePaid)
	{
		this.amountToBePaid = amountToBePaid; 
	}

	public String getNameOfBank ()
	{
		return (this.nameOfBank); 
	}

	public String getAccountHolderName ()
	{
		return (this.accountHolderName); 
	}

	public String getAccountNumber ()
	{
		return (this.accountNumber); 
	}

	public String getBranchCode ()
	{
		return (this.branchCode); 
	}

	public String getAmountToBePaid ()
	{
		return (this.amountToBePaid); 
	}
	
    public abstract String bankDetails();
    
}