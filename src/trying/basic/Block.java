//package trying.basic;
import java.security.spec.ECGenParameterSpec;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//import trying.FileIO;
public class Block {
  
    public  String PreviousHash;
    public String BlockHash;
    public static String[] data;
   public static KeyPair keyPair;
    public FileIO dataset;
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
       
        if(PreviousHash == null) System.out.println("This is not a Gensis Block, the previous hash should not be null");
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

    public static void toString(String[] args){
        for(int i=0;i<args.length;i++){
            System.out.println(args[i]);
        }
    }
  

   


    public static void main(String[] args) {
    // Your code from the HEAD branch
        String[] messages = FileIO.printDoctorAndPatientMessages();

    // Create an empty list to store blocks (your blockchain)
    List<Block> blockchain = new ArrayList<>();

    // Create the genesis block using the messages
    Block genesisBlock = new Block(FileIO.getPatientMessagenext());
    blockchain.add(genesisBlock);
    toString(blockchain.get(0).data);

    Block Block1 = new Block(genesisBlock.BlockHash, FileIO.getDoctorMessagenext());
    blockchain.add(Block1);
    System.out.println("control is here");
    toString(blockchain.get(1).data);

    Block Block2 = new Block(Block1.BlockHash, FileIO.getDoctorMessagenext());
    blockchain.add(Block2);
    toString(blockchain.get(1).data);
    Block Block3 = new Block(Block2.BlockHash, FileIO.getPatientMessagenext1());
    blockchain.add(Block3);

    Block Block4 = new Block(Block3.BlockHash, FileIO.getDoctorMessagenext1());
    blockchain.add(Block4);


    
        // Create and add additional blocks to the blockchain (if needed)

        //Verify and print the blockchain
    System.out.println("pritning using loop");
        for (int i = 0; i < blockchain.size(); i++) {
            Block currentBlock = blockchain.get(i);
            System.out.println("Block #" + i);
            System.out.println("Previous Hash: " + currentBlock.PreviousHash);
            System.out.println("Block Hash: " + currentBlock.BlockHash);
            System.out.println("Data: \n" + String.join("\n", Block.data));
            System.out.println("Block Verification: " + currentBlock.verifyBlock());
            System.out.println();
        }
        }
    }

