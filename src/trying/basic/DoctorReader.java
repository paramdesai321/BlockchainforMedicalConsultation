import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DoctorReader {

    public static String[][] docs = new String[15][5];

    public static String[][] getDoctorMessages() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("CAR0001.txt"));
            String line;
            char firstChar;
            int d = 0, i = 0, j = 0, k = 0;

            while ((line = reader.readLine()) != null) {
                if (!line.isEmpty()) {
                    firstChar = line.charAt(0);

                    if (firstChar == 'D') {
                        if (d >= 5 && d < 80) {
                            if (d % 5 == 0 && d != 0) {
                                k++;
                                j = 0;
                            }
                            if (k < 15 && j < 5) { // Ensure indices are within bounds
                                docs[k][j] = line;
                                j++;
                                d++;
                            } else {
                                break;
                            }
                        } else {
                            if (d < 15 && i < 5) { // Ensure indices are within bounds
                                docs[d][i] = line;
                                i++;
                                d++;
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return docs;
    }

    
    public static void main(String[] args) {
        String[][] result = getDoctorMessages();

        // Do something with the result if needed
        for (String[] doctorArray : result) {
            for (String message : doctorArray) {
                if (message != null) {
                    System.out.println(message);
                }
            }
        }
    }
}
