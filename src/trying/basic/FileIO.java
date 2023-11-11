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
    public static String[] doc2 = new String[5];
    public static String[]  patient3 = new String[5];
    public static String[] doc3 = new String[5];

    
    public  static String[] getPatientMessage() {
      
        try {
            BufferedReader reader = new BufferedReader(new FileReader("CAR0001.txt"));

       

            String line;
            char firstChar;

    
            int p = 0;
            int i=0;
            int j=0;
            int k=0;

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
                        else if(p>=10 && p<15) {
                        	if(p==15) break;
                        	patient2[j] = line;                        	
                        	j++;
                        	p++;
                        }
                        else if (p>= 15){
                            if(p==20) break;
                            patient3[k] = line;
                          //  System.out.println(patient3[k]);
                            k++;
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
            int i=0;
            int j=0;
            int k=0;
         

            while ((line = reader.readLine()) != null) {
                if (!line.isEmpty()) {
                    firstChar = line.charAt(0);

                    if (firstChar == 'D') {
                         if (d >= 5 && d<10) {
                            if (d == 10) break;
                            doc1[i] = line;
                            i++;
                            d++;                                                                	  
                        }
                        else if(d>=10 && d<15){
                            if(d==15) break;
                            doc2[j] = line;
                            
                            j++;
                            d++;
                        } 
                        else if(d>=15){
                            if(d==20) break;
                            doc3[k] = line;
                         //   System.out.println(doc3[k]);
                            k++;
                            d++;

                        }
                        else {
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
            return doc2;
        }

         public static String[] getDoctorMessagenext2(){

            getDoctorMessage();
            return doc3;
        }

         public static String[] getPatientMessagenext2() {
               
                getPatientMessage();
                
                    return patient3;
                }



    



    public static void main(String[] args) {
        // Example usage
       getDoctorMessage (); 
       getPatientMessage();
}

}