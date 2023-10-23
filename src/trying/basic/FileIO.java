
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
public class FileIO {
	
	public static String[] doc = new String[5];
    public static String[] patient = new String[5];
    public static void main(String[] args) {
        
    
   }
   public static String[] getMessage(){
   try {
            //String filePath = "C:/Users/pd681898/Downloads/Data.zip/Data/Clean Transcripts/CAR0001.txt";
            BufferedReader reader = new BufferedReader(new FileReader("CAR0001.txt"));
            
            String[] doc = new String[6];
            String[] patient = new String[6];
            
            String line;
            char firstChar;
            
            int d=0;
            int p=0;

           
            while ((line = reader.readLine()) != null) {
                if (!line.isEmpty()) {  // Check for empty lines
                    firstChar = line.charAt(0);

                    if (firstChar == 'P') {
                       patient[p] = line ;
                       System.out.println(line);
                       if(p >= 4) break;
                       p++;
                       
                                              // Exit the loop if 'P' is found
                    }
                    
                    else {
                        
                        doc[d] = line;
                        System.out.println(line);
                        if(d >= 5) break;
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
}