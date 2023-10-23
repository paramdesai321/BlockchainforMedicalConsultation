

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;



public class FileIO {

    public static String[] doc = new String[5];
    public static String[] patient = new String[5];
 
    public static String[] getPatientMessage() {
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader("CAR0001.txt"));

       

            String line;
            char firstChar;

            int d = 0;
            int p = 0;

            while ((line = reader.readLine()) != null) {
                if (!line.isEmpty()) {
                    firstChar = line.charAt(0);

                    if (firstChar == 'P') {
                        if (p ==5) break;
                        patient[p] = line;
                       // System.out.println(line);
                        patient[p] = line;  // Update temp_patient
                        p++;
                    } else {
                        if (d ==5) break;
                        doc[d] = line;
                       // System.out.println(line);
                        d++;
                    }
                }
            }

          
            reader.close();

            

         
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }

        return patient;

    }


    public static String[] getDoctorMessage(){
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader("CAR0001.txt"));

       

            String line;
            char firstChar;

            int d = 0;
            int p = 0;

            while ((line = reader.readLine()) != null) {
                if (!line.isEmpty()) {
                    firstChar = line.charAt(0);

                    if (firstChar == 'P') {
                        if (p ==5) break;
                        patient[p] = line;
                       // System.out.println(line);
                        patient[p] = line;  // Update temp_patient
                        p++;
                    } else {
                        if (d ==5) break;
                        doc[d] = line;
                       // System.out.println(line);
                        d++;
                    }
                }
            }

          
            reader.close();

           

         
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }

        return doc;

    }

    

    public static void main(String[] args) {
        // Example usage
      
    	String[] result = getPatientMessage();
    	
    	for(int i=0;i<result.length;i++) {
    		
    		
    		System.out.println(result[i]);
    	}
         // Use the result as needed
    }
}
