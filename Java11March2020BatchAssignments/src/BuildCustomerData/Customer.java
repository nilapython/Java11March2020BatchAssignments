package BuildCustomerData;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Customer implements Serializable{
	
	private String custId;
	private String custName;
    private String custEmail;
    
    public Customer() {
    	
    }
	public Customer(String custId, String custName, String custEmail) {
		//super();
		this.custId = custId;
		this.custName = custName;
		this.custEmail = custEmail;
	}
	
	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public boolean validateCustId() {
		try {
			int i = Integer.parseInt(this.getCustId());
			return true;
		} catch (Exception e) {
			return false;
		}	
	}
	
	
	public boolean validateCustName() {
		String str = this.getCustName();
		
		if ( (str == "") ||
				(str == null) 
			)
			return false;
		//(?<=\s|^)[a-zA-Z]*(?=[.,;:]?\s|$)
	     //String regex = "^[a-zA-Z\\.]+$";
	    String regex = "^[a-zA-Z]+\\.?$";
		Pattern pattern = Pattern.compile(regex);
		
		String[] names = str.split(" "); //[ ]+
		for (String name : names)
		{
		  Matcher matcher = pattern.matcher(name);
		  //System.out.println(name+" "+ matcher.matches());
		  if (!(matcher.matches())) 
			  return false;
		}
		    
		    return true;
		  }
	
	public boolean validateCustEmail() {
		String str = this.getCustEmail();
		
		if ( (str == "") ||
				(str == null)
			)
			return false;
		
		//String regex = "^(.+)@(.+)$"; --Simplest
		String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
		/*
		user@domain.com :           true
		user@domain.co.in :         true
		user1@domain.com :          true
		user.name@domain.com :      true
		user_name@domain.co.in :    true
		user-name@domain.co.in :    true
		user@domaincom :            true
		 
		@yahoo.com :                false
       */
 
		//String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$"; --RFC 5322
		/*
		  user@domain.com :           true
           user@domain.co.in :         true
           user.name@domain.com :      true
           user?name@domain.co.in :    true
           user'name@domain.co.in :    true
           @yahoo.com :                false
		 */
		//String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
		/*
		 user@domain.com :           true
         user@domain.co.in :         true
         user.name@domain.com :      true
         user'name@domain.co.in :    true
 
         .username@yahoo.com :       false
         username@yahoo.com. :       false
         username@yahoo..com :       false
		 */
		
		//String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        /*
		user@domain.com :               true
		user@domain.co.in :             true
		user.name@domain.com :          true
		user_name@domain.com :          true
		username@yahoo.corporate.in :   true
		 
		.username@yahoo.com :           false
		username@yahoo.com. :           false
		username@yahoo..com :           false
		username@yahoo.c :              false
		username@yahoo.corporate :      false
		*/
		Pattern pattern = Pattern.compile(regex);
		
		  Matcher matcher = pattern.matcher(str);
		  //System.out.println(name+" "+ matcher.matches());
		  if (!(matcher.matches())) 
			  return false;
			return true;
		
	}
	
}
