import java.security.spec.ECGenParameterSpec;
import java.security.*;
import java.util.Arrays;
public class Block {

    private String PreviousHash;
    public String BlockHash;
    private String[] data;
    private KeyPair keyPair;
    private FileIO dataset;
    private ECDSADemo encryption; 
     
     public Block(String[] data) {
    	 
    	 // code for genesis block
    	 
    	 this.PreviousHash = null;
    	 this.data = data;
    	 
    	 try {
 			keyPair = ECDSADemo.generateKeyPair(data,PreviousHash);
 		} catch (NoSuchAlgorithmException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		} catch (InvalidAlgorithmParameterException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
        
    	 
    	 
    	 
     }
    public Block(String PreviousHash, String[] data) {
        this.PreviousHash = PreviousHash;
        this.data= data;
        
        
        
        try {
			keyPair = ECDSADemo.generateKeyPair(data,PreviousHash);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidAlgorithmParameterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
        
        this.BlockHash = ECDSADemo.bytesToHex(keyPair.getPrivate().getEncoded());;
               
       
    }
    
    
    
    
    
    
    

  

   

    public static void main(String[] args) {
        String[] list1 = {"Paris", "France"};
        String[] list2 = {"Berlin", "Germany"};

        // Create blocks
        
        
        
       
        

        // Verify blocks
        /*
        System.out.println("Block 1 verification: " + block1.verifyBlock());
        System.out.println("Block 2 verification: " + block2.verifyBlock());
        */
    }
}
