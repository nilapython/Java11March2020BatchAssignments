package BuildCustomerData;

import java.util.List;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
//import java.io.Serializable;

public class GenerateObjFile {
	
	public static void WriteToObjFile(String filename, List<Customer> lstCust) 
	{
		
		ObjectOutputStream objOut = null;
		FileOutputStream fout = null;
				
		if ((lstCust.size() > 0))
        {
        	for (Customer custstr : lstCust) {
        		String outfile = filename+"_"+custstr.getCustId()+".obj";
        		System.out.println(outfile);
        		Customer newCust = (Customer) custstr;
        		try {
					fout = new FileOutputStream(outfile);
					objOut = new ObjectOutputStream(fout);
					
	        		objOut.writeObject(newCust);
	        		
	        		//objOut.close();
	        		if(fout != null) fout.close();
					if(objOut != null) objOut.close();
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}catch(IOException ioEx) {
					ioEx.printStackTrace();
				}catch(Exception Ex) {
					Ex.printStackTrace();
				}finally {
					
					if(fout != null)
						try {
							fout.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					if(objOut != null)
						try {
							objOut.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}	
			} //for
        } //if
	}
}
