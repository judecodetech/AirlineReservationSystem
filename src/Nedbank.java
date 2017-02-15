/**
 * @(#)Nedbank.java
 *
 *
 * @author 
 * @version 1.00 2014/9/24
 */

@SuppressWarnings("unchecked")
public class Nedbank extends Bank
{

    public Nedbank() 
    {
    	setNameOfBank ("Nedbank");   // set the name of the bank to Nedbank
		setAccountHolderName ("Airline Resservation System");  // Set the account holder name
		setAccountNumber("1231145734");   // Set the account number of the holder
		setBranchCode ("123209");    // Set the branch code of the bank
	    setAmountToBePaid ("R 8500.50");    // Set default amount to 0 rand
    }
    
    /* This method was used for the  purpose of testing. 
       It is not adding any functionality to the program  */
    @Override
    public String bankDetails()
    {
      return "";
    }
    
    
}