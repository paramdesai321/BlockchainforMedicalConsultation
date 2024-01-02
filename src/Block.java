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

    Block Block14 = new Block(Block13.BlockHash, FileIO.getDoctorMessagenext6());
    blockchain.add(Block14);
    PrintBlockchain(Block14);

    Block Block15 = new Block(Block14.BlockHash, FileIO.getPatientMessagenext6());
    blockchain.add(Block15);
    PrintBlockchain(Block15);

    Block Block16 = new Block(Block15.BlockHash, FileIO.getDoctorMessagenext7());
    blockchain.add(Block16);
    PrintBlockchain(Block16);

    Block Block17 = new Block(Block16.BlockHash, FileIO.getPatientMessagenext7());
    blockchain.add(Block17);
    PrintBlockchain(Block17);

    Block Block18 = new Block(Block17.BlockHash, FileIO.getDoctorMessagenext8());
    blockchain.add(Block18);
    PrintBlockchain(Block18);

    Block Block19 = new Block(Block18.BlockHash, FileIO.getPatientMessagenext8());
    blockchain.add(Block19);
    PrintBlockchain(Block19);

    Block Block20 = new Block(Block19.BlockHash, FileIO.getDoctorMessagenext9());
    blockchain.add(Block20);
    PrintBlockchain(Block20);

    Block Block21 = new Block(Block20.BlockHash, FileIO.getPatientMessagenext9());
    blockchain.add(Block21);
    PrintBlockchain(Block21);

    Block Block22 = new Block(Block21.BlockHash, FileIO.getDoctorMessagenext10());
    blockchain.add(Block22);
    PrintBlockchain(Block22);

    Block Block23 = new Block(Block22.BlockHash, FileIO.getPatientMessagenext10());
    blockchain.add(Block23);
    PrintBlockchain(Block23);
    System.out.println("<--NOTE:The last 4 message fields of the last 2 blocks were null because the conversation was ended-->\n");
    System.out.println("<--Further Blocks will contain data from a different conversation stored in file CAR002.txt-->\n");

    Block Block24 = new Block(Block23.BlockHash, FileIO.getDoctorMessagenext11());
    blockchain.add(Block24); 
    PrintBlockchain(Block24);

    Block Block25 = new Block(Block24.BlockHash, FileIO.getPatientMessagenext11());
    blockchain.add(Block25);
    PrintBlockchain(Block25);


    Block Block26 = new Block(Block25.BlockHash, FileIO.getDoctorMessagenext12());
    blockchain.add(Block26);
    PrintBlockchain(Block26);

    Block Block27 = new Block(Block26.BlockHash, FileIO.getPatientMessagenext12());
    blockchain.add(Block27);
    PrintBlockchain(Block27);

    Block Block28 = new Block(Block27.BlockHash, FileIO.getDoctorMessagenext12());
    blockchain.add(Block28);
    PrintBlockchain(Block28);

    Block Block29 = new Block(Block28.BlockHash, FileIO.getDoctorMessagenext13());
    blockchain.add(Block29);
    PrintBlockchain(Block29);

    Block Block30 = new Block(Block29.BlockHash, FileIO.getPatientMessagenext13());
    blockchain.add(Block30);
    PrintBlockchain(Block30);  
    
    
}
}
