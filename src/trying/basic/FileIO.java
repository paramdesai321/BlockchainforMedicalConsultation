//package trying;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

//import trying.basic.Block;

public class FileIO {
 
           // 10 more if statments by tommorrow
   
public static String[] patient = new String[5];
public static  String[] patient1 = new String[5];
public static  String[] patient2 = new String[5];
public static String[]  patient3 = new String[5];
public static String[] patient4 = new String[5];
public static String[] patient5 = new String[5];
public static String[] patient6 = new String[5];

public static String[] doc = new String[5];
public static String[] doc1 = new String[5];
public static String[] doc2 = new String[5];
public static String[] doc3 = new String[5];
public static String[] doc4 = new String[5];
public static String[] doc5 = new String[5];
public static String[] doc6 = new String[5];
public static String[] doc7 = new String[5];
public static String[] doc8 = new String[5];
public static String[] doc9 = new String[5];
public static String[] doc10 = new String[5];
public static String[] doc11 = new String[5];


    
    public  static String[] getPatientMessage() {
      
        try {
            BufferedReader reader = new BufferedReader(new FileReader("CAR0001.txt"));

       

            String line;
            char firstChar;

    
            int p=0, i=0, j=0, k=0, l=0, m=0, n=0, o=0, q=0, r=0, s=0;


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
                        else if (p>= 15 && p<20){
                           
                            patient3[k] = line;
                          //  System.out.println(patient3[k]);
                            k++;
                            p++;
                        }

                        else if(p>=20 && p< 25){
                           patient4[l] = line;
                         
                           l++;
                           p++;     

                        }else if(p>=25 && p<30){
                              patient5[m] = line;
                         
                           m++;
                           p++;  

                        }
                        else if(p>=30 && p<35){
                            patient6[n] = line;

                            n++;
                            p++;
                            }                       

                        else{
                            if(p== 35) break;
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

          int d=0, i=0, j=0, k=0, l=0, m=0, n=0, o=0, p=0, q=0;
         

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
                         else if(d>=15&&d<=20){
                            
                            doc4[k] = line;
                            k++;
                            d++;

                        }
                        else if(d>=20&&d<=25){
                            
                            doc5[k] = line;
                            k++;
                            d++;

                        }
                        else if(d>=25&&d<=30){
                            
                            doc6[n] = line;
                            k++;
                            d++;

                        }
                        else if(d>=30&&d<=35){
                            return null;

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


         public static String[] getPatientMessagenext3() {
               
                getPatientMessage();
                
                    return patient4;
       
                }


         public static String[] getPatientMessagenext4() {
               
                getPatientMessage();
                
                    return patient5;
       
                }





    public static void printarr(String[] arr){

        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }

    }



    public static void main(String[] args) {
        // Example usage
       getDoctorMessage (); 
       getPatientMessage();


        String result []  = patient5;
        printarr(patient5);
                }

}

