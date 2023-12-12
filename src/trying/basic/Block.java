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
     public static int counter=0;
     
     
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

    public static void printarr(String[] args){
        for(int i=0;i<args.length;i++){
            System.out.println(args[i]);
        }
    }




 
    public static void PrintBlockchain(Block block){

        String[] arr = block.data;
        System.out.println("Block #:"+ counter);
        System.out.println("Block Hash: "+ block.BlockHash);
        System.out.println("Previous Hash: "+block.PreviousHash);
        System.out.println("Data: ");
        printarr(arr);
        System.out.println("Block Verification: " + block.verifyBlock());
        counter ++;
    }
  

   


    public static void main(String[] args) {
    // Your code from the HEAD branch
    

    // Create an empty list to store blocks (your blockchain)
    List<Block> blockchain = new ArrayList<>();

    // Create the genesis block using the messages
    Block genesisBlock = new Block(FileIO.getDoctorMessage());
    blockchain.add(genesisBlock);
    PrintBlockchain(genesisBlock);
  //  System.out.println("control is here");
    Block Block1 = new Block(genesisBlock.BlockHash, FileIO.getPatientMessage());
    blockchain.add(Block1);
   
    PrintBlockchain(Block1);
        
    

    Block Block2 = new Block(Block1.BlockHash, FileIO.getDoctorMessagenext());
    blockchain.add(Block2);
    PrintBlockchain(Block2);
     
    Block Block3 = new Block(Block2.BlockHash, FileIO.getPatientMessagenext());
    blockchain.add(Block3);
    PrintBlockchain(Block3);
          

    Block Block4 = new Block(Block3.BlockHash, FileIO.getDoctorMessagenext1());
    blockchain.add(Block4);

    PrintBlockchain(Block4);


  
    Block Block5 = new Block(Block4.BlockHash, FileIO.getPatientMessagenext1());
    blockchain.add(Block5);
    PrintBlockchain(Block5);

    Block Block6 = new Block(Block5.BlockHash, FileIO.getDoctorMessagenext2());
    blockchain.add(Block6);
    PrintBlockchain(Block6);

    Block Block7 = new Block(Block6.BlockHash, FileIO.getPatientMessagenext2());
    blockchain.add(Block7);
    PrintBlockchain(Block7);

    Block Block8 = new Block(Block7.BlockHash, FileIO.getDoctorMessagenext3());
    blockchain.add(Block8);
    PrintBlockchain(Block8);

    Block Block9 = new Block(Block8.BlockHash, FileIO.getPatientMessagenext3());
    blockchain.add(Block9);
    PrintBlockchain(Block9);

     Block Block10 = new Block(Block9.BlockHash, FileIO.getDoctorMessagenext4());
    blockchain.add(Block10);
    PrintBlockchain(Block10);

     Block Block11 = new Block(Block10.BlockHash, FileIO.getPatientMessagenext4());
    blockchain.add(Block11);
    PrintBlockchain(Block11);

    Block Block12 = new Block(Block11.BlockHash, FileIO.getDoctorMessagenext5());
    blockchain.add(Block12);
    PrintBlockchain(Block12);

    Block Block13 = new Block(Block12.BlockHash, FileIO.getPatientMessagenext5());
    blockchain.add(Block13);
    PrintBlockchain(Block13);













     


      
    
    
}
}
