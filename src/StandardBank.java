/**
 * @(#)StandardBank.java
 *
 *
 * @author 
 * @version 1.00 2014/9/24
 */

@SuppressWarnings("unchecked")
public class StandardBank extends Bank
{

    public StandardBank()
    {
    	setNameOfBank ("Standard Bank");      // set the name of the bank to StandardBank
		setAccountHolderName ("Airline Resservation System");  // Set the account holder name
		setAccountNumber("1110243743");   // Set the account number of the holder
		setBranchCode ("119230");      // Set the branch code of the bank
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