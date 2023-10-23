
import java.security.spec.ECGenParameterSpec;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;


import java.util.Arrays;

public class Block {

    private String PreviousHash;
    public String BlockHash;
    public static String[] data;
   public static KeyPair keyPair;
    private FileIO dataset;
     ECDSADemo encryption = new ECDSADemo();
     
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
        
    	 this.BlockHash = ECDSADemo.bytesToHex(keyPair.getPrivate().getEncoded());;
    	 
    	 
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
    
    
    public void addBlock(Block newBlock) throws InvalidKeySpecException {
        try {
            // Generate key pair for the new block
            try {
				newBlock.keyPair = ECDSADemo.generateKeyPair(newBlock.data, this.BlockHash);
			} catch (InvalidAlgorithmParameterException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

            // Sign the data of the new block
            byte[] signature = ECDSADemo.sign(newBlock.getDataString(), this.keyPair.getPrivate());

            // Verify the signature of the previous block
            if (!this.verifyBlock()) {
                System.out.println("Error: Previous block's signature verification failed.");
                return;
            }

            // Verify the signature of the new block
            if (!ECDSADemo.verify(newBlock.getDataString(), signature, newBlock.keyPair.getPublic())) {
                System.out.println("Error: New block's signature verification failed.");
                return;
            }

            // Add the new block to the blockchain
            // ... (add your logic here)

        } catch (NoSuchAlgorithmException | InvalidKeyException | SignatureException e) {
            e.printStackTrace();
        }
    }


    
    
    private String getDataString() {
        // Combine the data array into a single string
        StringBuilder dataString = new StringBuilder(this.PreviousHash);
        for (String data : this.data) {
            dataString.append(data);
        }
        return dataString.toString();
    }
    
    public boolean verifyBlock() {
        try {
            // Verify the signature using the public key
            PublicKey publicKey = ECDSADemo.getPublicKeyFromBytes(this.keyPair.getPublic().getEncoded());
            byte[] signature = ECDSADemo.sign(this.getDataString(), this.keyPair.getPrivate());
            return ECDSADemo.verify(this.getDataString(), signature, publicKey);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
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
