package BuildCustomerData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ReadCustomerData implements Serializable  {
	
	static List<Customer> lstValid = new ArrayList<Customer>();
	static List<String> lstInvalid = new ArrayList<String>();
	//static Customer cust = null;
	
	public static void main(String[] args)  {
		
		String filePath = "/H2K/";
		String inputfilename = "CustomerData.txt";
		String outfilename = "InvalidCustData.txt";
		String objfilename = "CustObjectFile";
		
		ReadCustomerData validRead = new ReadCustomerData();
		
	    try (BufferedReader br = new BufferedReader(new FileReader(filePath+inputfilename))) 
	    {
			
	        String sCurrentLine = null;
	        while ((sCurrentLine = br.readLine()) != null) 
	        {
	        	System.out.println(sCurrentLine);
	        	validRead.validateCustomerData(sCurrentLine);
	        }
	        
	        if ((lstInvalid.size() > 0))
	        {
	        	GenerateFile.WriteToFile(filePath+outfilename,lstInvalid);
	        }
			
			 if ((lstValid.size() > 0)) 
			 { 
				 GenerateObjFile.WriteToObjFile(filePath+objfilename, lstValid);
			  
			  } 
	        
	    } 
	    catch (IOException e) 
	    {
	        e.printStackTrace();
	    }
	    
	    System.out.println("No. of valid Customer : "+lstValid.size());
	    System.out.println("No. of Invalid Customer : "+lstInvalid.size());
	    	
	}
	
	public void validateCustomerData(String custLine) {
		boolean validCustFlag = true;
		boolean ans = false;
		String lstString = custLine;
		Customer cust = null;
		String[] arrOfStr = custLine.split(",");
		if (arrOfStr.length < 3 || arrOfStr.length > 3 )
		{
			lstString = lstString.concat("**Incorrect amount of data**");
		    validCustFlag = false;
		}
		else
		{
			cust = new Customer(arrOfStr[0],arrOfStr[1],arrOfStr[2]);
	
			ans = cust.validateCustId();
			if (!ans)
			{
				lstString = lstString.concat("**Invalid Customer Id**");
				validCustFlag = ans;
			}

			ans = cust.validateCustName();
			if (!ans)
			{
				lstString = lstString.concat("**Invalid Customer Name**");
				validCustFlag = ans;
			}

			ans = cust.validateCustEmail();
			if (!ans)
			{
				lstString = lstString.concat("**Invalid Customer Email**");
				validCustFlag = ans;
			}

		}
    	if (validCustFlag)
    	{
    		lstValid.add(cust);
    	}
    	else
        	lstInvalid.add(lstString);
    	
    	System.out.println(lstString);
    	
    }

}
