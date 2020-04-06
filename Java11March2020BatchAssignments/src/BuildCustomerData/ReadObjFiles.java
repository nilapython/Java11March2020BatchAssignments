package BuildCustomerData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ReadObjFiles {

	public static void main(String[] args) {
		
		ObjectInputStream objIn = null;
		//ObjectOutputStream objOut = null;
		//FileOutputStream fout = null;
		FileInputStream fin = null;
		
		String filePath = "/H2K/";
		File dir = new File(filePath);
		if(dir.isDirectory()) {
			System.out.println(dir.getName() + " is a directory");
		}
		File[] allFilesFromDir = dir.listFiles();
		
		for(File eachFile : allFilesFromDir) {
			String filename = eachFile.getName();
			
			if ( (filename.contains(".obj")) && (filename.contains("Cust"))) 
			{
				System.out.println(filename);
				try {
	        		System.out.println("Reading obj file : "+filename);
					fin = new FileInputStream(filePath+filename);
					objIn = new ObjectInputStream(fin);
					Object object  = objIn.readObject();
					
					if(object instanceof Customer) {
						Customer cust =  (Customer) object;
						System.out.println(cust.getCustId());
						System.out.println(cust.getCustName());
						System.out.println(cust.getCustEmail());
					}
				}catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}catch(IOException ioEx) {
					ioEx.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
	    		
	    	} //if	
				
		} //for	
	}
}

