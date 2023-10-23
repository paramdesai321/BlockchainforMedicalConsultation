
import java.security.spec.ECGenParameterSpec;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

import java.util.List;
import java.util.ArrayList;

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
    
    
    public List<Block> addBlock(Block newBlock) throws InvalidKeySpecException {
        try {
            // Generate key pair for the new block
            try {
				newBlock.keyPair = ECDSADemo.generateKeyPair(newBlock.data, this.BlockHash);
			} catch (InvalidAlgorithmParameterException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

            // Sign the data of the new block
            byte[] signature = ECDSADemo.sign(newBlock.data, this.keyPair.getPrivate());

            // Verify the signature of the previous block
            if (!this.verifyBlock()) {
                System.out.println("Error: Previous block's signature verification failed.");
                return null;
            }

            // Verify the signature of the new block
            if (!ECDSADemo.verify(newBlock.data, signature, newBlock.keyPair.getPublic())) {
                System.out.println("Error: New block's signature verification failed.");
                return null;
            }

            // Add the new block to the blockchain
            // ... (add your logic here)

        } catch (NoSuchAlgorithmException | InvalidKeyException | SignatureException e) {
            e.printStackTrace();
        }
        return null;
    }


    
    
   
    public boolean verifyBlock() {
        try {
            // Verify the signature using the public key
            PublicKey publicKey = ECDSADemo.getPublicKeyFromBytes(this.keyPair.getPublic().getEncoded());
            byte[] signature = ECDSADemo.sign(Block.data, Block.keyPair.getPrivate());
            return ECDSADemo.verify(this.data, signature, publicKey);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    
   
    

  

   

    public static void main(String[] args) {
         String[] data = FileIO.getData(); // Implement this method in FileIO

        // Create an empty list to store blocks (your blockchain)
        List<Block> blockchain = new ArrayList<>();

        // Create the genesis block using the messages
        Block genesisBlock = new Block(null, data);
        blockchain.add(genesisBlock);

        // Create and add additional blocks to the blockchain (if needed)

        // Verify and print the blockchain
        for (int i = 0; i < blockchain.size(); i++) {
            Block currentBlock = blockchain.get(i);
            System.out.println("Block #" + i);
            System.out.println("Previous Hash: " + currentBlock.PreviousHash);
            System.out.println("Block Hash: " + currentBlock.BlockHash);
            System.out.println("Data: " + String.join(", ", currentBlock.data));
            System.out.println("Is Valid: " + currentBlock.verifyBlock());
            System.out.println();
        }
    }
}
