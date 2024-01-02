import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PatientReader {

    public static String[][] patient = new String[15][5];

    public static String[][] getPatientMessages() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("CAR0001.txt"));
            String line;
            char firstChar;
            int p= 0, i = 0, j = 0, k = 0;

            while ((line = reader.readLine()) != null) {
                if (!line.isEmpty()) {
                    firstChar = line.charAt(0);

                    if (firstChar == 'P') {
                        if (p >= 5 && p < 80) {
                            if (p % 5 == 0 && p != 0) {
                                k++;
                                j = 0;
                            }
                            if (k < 15 && j < 5) { // Ensure indices are within bounds
                                patient[k][j] = line;
                                j++;
                                p++;
                            } else {
                                break;
                            }
                        } else {
                            if (p < 15 && i < 5) { // Ensure indices are within bounds
                                patient[p][i] = line;
                                i++;
                                p++;
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return patient;
    }
    public static String[] getPatientArray(int index) {
    	getPatientMessages();
        if (index >= 0 && index < patient.length) {
                   return patient[index];
        }
        return null; // or handle the out-of-bounds case appropriately
    }




   public static String[] getPatientArray1() {
   	getPatientMessages();

   		return patient[1];
            }

    public String[] getPatientArray2() {
        	getPatientMessages();
        	return patient[2];

    }



    public static void main(String[] args) {
        
           String result[][] = getPatientMessages();

        // Do something with the result if needed
        for (String[] PatientArray : result) {
            for (String message : PatientArray) {
                if (message != null) {
                    System.out.println(message);
                }
            }
        }
        
    }
}
