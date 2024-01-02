
public class datatesting{
	
	public static PatientReader read;


	public static void main(String[] args){
		String[] result = read.getPatientArray2();

		for(int i=0;i<result.length;i++){
			System.out.println(result[i]);
		}

	}
}