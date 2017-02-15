/**
 * @(#)ABSA.java
 *
 *
 * @author 
 * @version 1.00 2014/9/24
 */

@SuppressWarnings("unchecked")
public class ABSA extends Bank
{

    public ABSA() 
    {
    	setNameOfBank ("ABSA");			// set the name of the bank to ABSA
		setAccountHolderName ("Airline Resservation System");   // Set the account holder name
		setAccountNumber("40328393233");    // Set the account number of the holder
		setBranchCode ("50385");    // Set the branch code of the bank
	    setAmountToBePaid ("R0.00");   // Set default amount to 0 rand
    }
    
    /* This method was used for the  purpose of testing. 
       It is not adding any functionality to the program  */
    @Override
    public String bankDetails()
    {
      return "";
    }
    
}