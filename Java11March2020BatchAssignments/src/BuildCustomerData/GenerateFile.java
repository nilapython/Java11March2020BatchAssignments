package BuildCustomerData;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GenerateFile {
	
	public static void WriteToFile(String filename, List<String> lstCust) throws IOException {
	
		FileWriter fWrite1 = null;
		BufferedWriter writer = null;
		try {
			fWrite1 = new FileWriter(filename);
			writer = new BufferedWriter(fWrite1);
			
			for (String str : lstCust) {
				
				writer.write(str);
				writer.newLine();
				
			}
			writer.flush();
		} catch(IOException ioEx) {
			ioEx.printStackTrace();
		}finally {
			if(fWrite1 != null) fWrite1.close();
		}
		
		
		
	}

}
