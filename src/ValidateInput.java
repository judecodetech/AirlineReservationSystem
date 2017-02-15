// Fig. 16.20: ValidateInput.java
// Validate user information using regular expressions.

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ValidateInput  
{
	
   // validate first name
   public static boolean validateFirstName( String firstName )
   {
      return firstName.matches( "[A-Z][a-zA-Z]*" );
   } // end method validateFirstName
   
    // validate last name
   public static boolean validateLastName( String lastName )
   {
      return lastName.matches( "[a-zA-z]+([ '-][a-zA-Z]+)*" );
   } // end method validateLastName
   
    // validate card holder name
   public static boolean validateNameOfCardHolder( String nameOfCardHolder )
   {
      return nameOfCardHolder.matches( "[a-zA-z]+([ '-][a-zA-Z]+)*" );
   } // end method validateNameOfCardHolder
   
   // validate visa card number
   public static boolean validateVisaCard( String visaCard )
   {  
   	  // All visa card numbers start with 4. New cards have 16 digits. Old cards have 13
      return visaCard.matches( "^4[0-9]{12}(?:[0-9]{3})?$" );
   } // end method validateVisaCard
   
   // validate master card number
   public static boolean validateMasterCard( String masterCard )
   {
   	  // All master card number must start with the numbers 51 through 55. All have 16 digits
      return masterCard.matches( "^5[1-5][0-9]{14}$" );  
   } // end method validateMasterCard
      
   // validate cvc number
   public static boolean validateCVC( String cvc )
   {
      return cvc.matches( "\\d{3}" );
   } // end method validateCVC
   
   // validate postal code
   public static boolean validateZip( String zip )
   {
      return zip.matches( "\\d{4}" );
   } // end method validateZip

   // validate middle name
   public static boolean validateMiddleName( String middleName )
   {
      return middleName.matches( "[a-zA-z]+([ '-][a-zA-Z]+)*" );
   } // end method validateMiddleName
   
   // validate source
   public static boolean validateSource( String source )
   {
      return source.matches( "[A-Z][ a-zA-Z]*" );
   } // end method validateSource
   
   // validate destination
   public static boolean validateDestination( String destination )
   {
      return destination.matches( "[A-Z][ a-zA-Z]*" );
   } // end method validateDestination
   
   // validate nationality
   public static boolean validateNationality( String nationality )
   {
      return nationality.matches( "[A-Z][ a-zA-Z]*" );
   } // end method validateNationality
   
   // validate country of issue
   public static boolean validateCountryOfIssue( String countryOfIssue )
   {
      return countryOfIssue.matches( "[A-Z][ a-zA-Z]*" );
   } // end method validateCountryOfIssue

   // validate passport number or ID
   public static boolean validatePassportNoOrID( String passportNoOrID )
   {
      return passportNoOrID.matches( "\\d{13}" );
   } // end method validateZip
   
   // validate airline name
   public static boolean validateAirline( String airline )
   {
      return airline.matches( "[ 1-9 a-zA-z]+([ '-][ a-zA-Z])*" );
   } // end method validateAirline

   // validate address
   public static boolean validateAddress( String address )
   {
      return address.matches(
		"\\d+\\s+([a-zA-Z]+|([a-zA-Z]+\\s[a-zA-Z])+([a-zA-Z]+\\s[a-zA-Z]+)*)" );
   } // end method validateAddress

   // validate city
   public static boolean validateCity( String city )
   {
      return city.matches( "([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)" );
   } // end method validateCity

   // validate state
   public static boolean validateState( String state )
   {
      return state.matches( "([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)" ) ;
   } // end method validateState
   
   // validate phone
   public static boolean validatePhone( String phone )
   {
      return phone.matches( "[0-9]\\d{2}-[1-9]\\d{2}-\\d{4}" );
   } // end method validatePhone
   
   // validate phone
   public static boolean validateIntlPhone( String intlPhone )
   {
      return intlPhone.matches( "^[ +]+\\d{4}+[ -]+\\d{3}+[ -]+\\d{4}$" );
   } // end method validatePhone
   
   // validate email
   public static boolean validateEmail( String email )
   {
   	    boolean isValid = false;
      // return email.matches( "[1-9]\\d{2}-[1-9]\\d{2}-\\d{4}" );
        //Initialize reg ex for email.  
	  String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";  
	  CharSequence inputStr = email;  
	  	
      //Make the comparison case-insensitive.  
      Pattern pattern = Pattern.compile(expression,Pattern.CASE_INSENSITIVE);  
      Matcher matcher = pattern.matcher(inputStr);  
      	
      if(matcher.matches())
      {  
         return isValid = true;  
      }  
      return isValid;  
   } // end method validateEmail
   
   /*
	* Validate time in 12 hours format with regular expression
	* @param time time address for validation
	* @return true valid time fromat, false invalid time format   */
   public static boolean Time12HoursValidator(String time)
   {
	  boolean isValid = false;
 
	 String TIME12HOURS_PATTERN = "(1[012]|[1-9]):[0-5][0-9](\\s)?(?i)(am|pm)";
 
      //Make the comparison case-insensitive. 
      Pattern pattern = Pattern.compile(TIME12HOURS_PATTERN, Pattern.CASE_INSENSITIVE);
 	  Matcher matcher = pattern.matcher(time);
 	  
 	  if(matcher.matches())
      {  
         return isValid = true;  
      }  
      return isValid;  	    
    }
   
} // end class ValidateInput
