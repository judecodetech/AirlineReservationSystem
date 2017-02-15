/**
 * @(#)FNB.java
 *
 *
 * @author 
 * @version 1.00 2014/9/24
 */

@SuppressWarnings("unchecked")
public class FNB extends Bank
{

    public FNB() 
    { 
    	setNameOfBank ("FNB");    // set the name of the bank to FNB
		setAccountHolderName ("Airline Resservation System");   // Set the account holder name
		setAccountNumber("602394678443");    // Set the account number of the holder
		setBranchCode ("401234");    // Set the branch code of the bank
	    setAmountToBePaid ("R0.00");  // Set default amount to 0 rand
    }
    
    /* This method was used for the  purpose of testing. 
       It is not adding any functionality to the program  */
    @Override
    public String bankDetails()
    {
      return "";
    }

}