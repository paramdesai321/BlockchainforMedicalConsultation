//package trying;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

//import trying.basic.Block;

public class FileIO {
 
    public static String[] doc = new String[5];
    public static String[] patient = new String[5];
    public static  String[] patient1 = new String[5];
    public static  String[] patient2 = new String[5];
    public static String[] doc1 = new String[5];   
  
    public  static String[] getPatientMessage() {
      
        try {
            BufferedReader reader = new BufferedReader(new FileReader("CAR0001.txt"));

       

            String line;
            char firstChar;

    
            int p = 0;
            int i=0;
            int j=0;

            while ((line = reader.readLine()) != null) {
                if (!line.isEmpty()) {
                    firstChar = line.charAt(0);
                    
                    
                    if (firstChar == 'P') {
                    	
                        if (p >= 5 && p<10) {
                            if (p == 10) break;
                            patient1[i] = line;
                            i++;
                            p++;
                        }
                        else if(p>=10) {
                        	if(p==15) break;
                        	patient2[j] = line;
                        	
                        	j++;
                        	p++;
                        }
                        else {
                            patient[p] = line;                      
                            p++;
                        }
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
    
    

    
    public static  String[] getDoctorMessage() {
      
        try {
            BufferedReader reader = new BufferedReader(new FileReader("CAR0001.txt"));
            
       

            String line;
            char firstChar;

            int d = 0;
            int j=0;
         

            while ((line = reader.readLine()) != null) {
                if (!line.isEmpty()) {
                    firstChar = line.charAt(0);

                    if (firstChar == 'D') {
                         if (d >= 5) {
                            if (d == 10) break;
                            doc1[j] = line;
                            j++;
                            d++;
                                                                	  
                        } else {
                            doc[d] = line;
                            d++;
                        }
                    }
            
                }
            }
                    
            reader.close();
        }        
                
            


         catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }

        return doc;
    }
    
   public static String[] getDoctorMessagenext() {
	   
	   getDoctorMessage();
	   return doc1;
   }
		   
		 public static String[] getPatientMessagenext() {
       
    	getPatientMessage();
    	
    	    return patient1;
    	}
		 
		 public static String[] getPatientMessagenext1() {
		       
		    	getPatientMessage();
		    	
		    	    return patient2;
		    	}

        public static String[] getDoctorMessagenext1(){

            getDoctorMessage();
            return doc1;
        }
    

 public static String[] printDoctorAndPatientMessages() {
    String[] doctorMessages = FileIO.getDoctorMessage();
    String[] patientMessages = FileIO.getPatientMessage();
    int totalMessages = doctorMessages.length + patientMessages.length;
    String[] allMessages = new String[totalMessages];

    int doctorCounter = 0;
    int patientCounter = 0;

    for (int i = 0; i < totalMessages; i++) {
        if (i % 2 == 0 && doctorCounter < doctorMessages.length) {
            allMessages[i] = doctorMessages[doctorCounter];
            doctorCounter++;
        } else if (patientCounter < patientMessages.length) {
            allMessages[i] = patientMessages[patientCounter];
            patientCounter++;
        }
    }

    return allMessages;
}

    public static void main(String[] args) {
        // Example usage
        String[] arr = printDoctorAndPatientMessages();
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
