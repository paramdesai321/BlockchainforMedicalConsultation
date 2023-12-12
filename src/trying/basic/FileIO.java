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
public static String[] patient7 = new String[5];
public static String[] patient8 = new String[5];
public static String[] patient9 = new String[5];
public static String[] patient10 = new String[5];
public static String[] patient11 = new String[5];
public static String[] patient12 = new String[5];
public static String[] patient13 = new String[5];
public static String[] patient14 = new String[5];


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
public static String[] doc12 = new String[5];
public static String[] doc13 = new String[5];
public static String[] doc14 = new String[5];



public  static String[] getPatientMessage() {
      
        try {
            BufferedReader reader = new BufferedReader(new FileReader("CAR0001.txt"));

       

            String line;
            char firstChar;

    
            int p=0, i=0, j=0, k=0, l=0, m=0, n=0, o=0, q=0, r=0, s=0,t=0,u=0,v=0,w=0,x=0,y=0,z=0;


            while ((line = reader.readLine()) != null) {
                if (!line.isEmpty()) {
                    firstChar = line.charAt(0);

                    
                    
                    if (firstChar == 'P') {
                        
                        if (p >= 5 && p<10) {
                          //  if (p == 10) break;
                            patient1[i] = line;
                            i++;
                            p++;
                        }
                        else if(p>=10 && p<15) {
                            //if(p==15) break;
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
                        else if(p>=35 && p<40){
                            patient7[o] = line;

                            o++;
                            p++;
                            } 
                        else if(p>=40&&p<45){
                            patient8[q] = line;

                            q++;
                            p++;
                            } 
                        else if(p>=45 && p<50){
                            patient9[r] = line;

                            r++;
                            p++;
                            }
                        else if(p>=50 && p<55) {

                            patient10[s] = line;
                            s++;
                            p++;    
                        } 
                        else if(p>=55 && p<60) {

                            patient10[t] = line;
                            t++;
                            p++;    
                        } 
                        else if(p>=60 && p<65) {

                            patient11[w] = line;
                            w++;
                            p++;    
                        } 
                        else if(p>=65 && p<70) {

                            patient12[x] = line;
                            x++;
                            p++;    
                        } 
                        else if(p>=70 && p<75) {

                            patient13[y] = line;
                            y++;
                            p++;    
                        } 
                        else if(p>=75 && p<80) {

                            patient14[z] = line;
                            z++;
                            p++;    
                        } 
                        else{
                            if(p==80) break;
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
    


public  static String[] getDoctorMessage() {
      
        try {
            BufferedReader reader = new BufferedReader(new FileReader("CAR0001.txt"));

       

            String line;
            char firstChar;

    
            int p=0, i=0, j=0, k=0, l=0, m=0, n=0, o=0, q=0, r=0, s=0,t=0,u=0,v=0,w=0,x=0,y=0,z=0;


            while ((line = reader.readLine()) != null) {
                if (!line.isEmpty()) {
                    firstChar = line.charAt(0);

                    
                    
                    if (firstChar == 'D') {
                        
                        if (p >= 5 && p<10) {
                          //  if (p == 10) break;
                            doc1[i] = line;
                            i++;
                            p++;
                        }
                        else if(p>=10 && p<15) {
                            //if(p==15) break;
                            doc2[j] = line;                         
                            j++;
                            p++;
                        }
                        else if (p>= 15 && p<20){
                           
                            doc3[k] = line;
                          //  System.out.println(doc3[k]);
                            k++;
                            p++;
                        }

                        else if(p>=20 && p< 25){
                           doc4[l] = line;
                         
                           l++;
                           p++;     

                        }else if(p>=25 && p<30){
                              doc5[m] = line;
                         
                           m++;
                           p++;  

                        }
                        else if(p>=30 && p<35){
                            doc6[n] = line;

                            n++;
                            p++;
                            } 
                        else if(p>=35 && p<40){
                            doc7[o] = line;

                            o++;
                            p++;
                            } 
                        else if(p>=40&&p<45){
                            doc8[q] = line;

                            q++;
                            p++;
                            } 
                        else if(p>=45 && p<50){
                            doc9[r] = line;

                            r++;
                            p++;
                            }
                        else if(p>=50 && p<55) {

                            doc10[s] = line;
                            s++;
                            p++;    
                        } 
                        else if(p>=55 && p<60) {

                            doc10[t] = line;
                            t++;
                            p++;    
                        } 
                        else if(p>=60 && p<65) {

                            doc11[w] = line;
                            w++;
                            p++;    
                        } 
                        else if(p>=65 && p<70) {

                            doc12[x] = line;
                            x++;
                            p++;    
                        } 
                        else if(p>=70 && p<75) {

                            doc13[y] = line;
                            y++;
                            p++;    
                        } 
                        else if(p>=75 && p<80) {

                            doc14[z] = line;
                            z++;
                            p++;    
                        } 
                        else{
                            if(p==80) break;
                            doc[p] = line;                      
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

        return doc;
    }
    
   public static String[] getDoctorMessagenext() {
	   
	   getDoctorMessage();
	   return doc1;
   }
		   
		 

        public static String[] getDoctorMessagenext1(){

            getDoctorMessage();
            return doc2;
        }

             public static String[] getDoctorMessagenext2(){

                getDoctorMessage();
                return doc3;
            }
         public static String[] getDoctorMessagenext3(){

                getDoctorMessage();
                return doc4;
            }
         public static String[] getDoctorMessagenext4(){

                getDoctorMessage();
                return doc5;
            }

         public static String[] getDoctorMessagenext5(){

                getDoctorMessage();
                return doc6;
            }
         public static String[] getDoctorMessagenext6(){

                getDoctorMessage();
                return doc7;
            }
         public static String[] getDoctorMessagenext7(){

                getDoctorMessage();
                return doc8;
            }
         public static String[] getDoctorMessagenext8(){

                getDoctorMessage();
                return doc9;
            }
         public static String[] getDoctorMessagenext9(){

                getDoctorMessage();
                return doc10;
            }

         public static String[] getDoctorMessagenext10(){

                getDoctorMessage();
                return doc11;
            }


        public static String[] getPatientMessagenext() {
       
        getPatientMessage();
        
            return patient1;
        }
         
         public static String[] getPatientMessagenext1() {
               
                getPatientMessage();
                
                    return patient2;
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

        public static String[] getPatientMessagenext5() {
               
                getPatientMessage();
                
                    return patient6;
       
                }
        public static String[] getPatientMessagenext6() {
               
                getPatientMessage();
                
                    return patient7;
       
                }
        public static String[] getPatientMessagenext7() {
               
                getPatientMessage();
                
                    return patient8;
       
                }
        public static String[] getPatientMessagenext8() {
               
                getPatientMessage();
                
                    return patient9;
       

            }
    public static String[] getPatientMessagenext9() {
               
                getPatientMessage();
                
                    return patient10;
       
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


        String result []  = patient14;
        printarr(patient12);
           }

}

