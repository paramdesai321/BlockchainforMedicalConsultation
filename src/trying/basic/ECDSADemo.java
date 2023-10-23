

import java.security.*;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.X509EncodedKeySpec;

public class ECDSADemo {

	static String privatekey; 
 	static String publickey;
 	
    public static void main(String[] args) {
    	
    	/*
        try {
            // Generate key pair
        	
            KeyPair keyPair = generateKeyPair();
            privatekey =  bytesToHex(keyPair.getPrivate().getEncoded());
            publickey = bytesToHex(keyPair.getPrivate().getEncoded());

            // Print public and private keys
            System.out.println("Public Key: " + bytesToHex(keyPair.getPublic().getEncoded()));
            System.out.println("Private Key: " + bytesToHex(keyPair.getPrivate().getEncoded()));

            // Message to be signed
            String message = "Hey Jackson";

            // Sign the message
            byte[] signature = sign(message, keyPair.getPrivate());

            // Verify the signature
            boolean isVerified = verify(message, signature, keyPair.getPublic());

            System.out.println("Signature verification result: " + isVerified);
        } catch (NoSuchAlgorithmException | InvalidAlgorithmParameterException | SignatureException | InvalidKeyException e) {
            e.printStackTrace();
        }
        */
        
    }

    // Generate ECDSA key pair

    public static KeyPair generateKeyPair(String[] dataArray, String previousHash) throws NoSuchAlgorithmException, InvalidAlgorithmParameterException {
        // Combine all strings in the array 
        StringBuilder combinedDataBuilder = new StringBuilder(previousHash);
        for (String data : dataArray) {
            combinedDataBuilder.append(data);
        }
        String combinedData = combinedDataBuilder.toString();

        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("EC");
        ECGenParameterSpec ecGenParameterSpec = new ECGenParameterSpec("secp256r1");
        keyPairGenerator.initialize(ecGenParameterSpec);

        // Pass combined data as additional input
        SecureRandom secureRandom = new SecureRandom(combinedData.getBytes());
        keyPairGenerator.initialize(ecGenParameterSpec, secureRandom);
        

        return keyPairGenerator.generateKeyPair();
        
    }
    // Sign a message using the private key
    public static byte[] sign(String[] messages, PrivateKey privateKey)
            throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        Signature ecdsaSignature = Signature.getInstance("SHA256withECDSA");
        ecdsaSignature.initSign(privateKey);
        
        for (String message : messages) {
            ecdsaSignature.update(message.getBytes());
        }
        
        return ecdsaSignature.sign();
    }

    //  som

    // Verify the signature using the public key
 // Verify the signature using the public key
    public static boolean verify(String[] messages, byte[] signature, PublicKey publicKey)
            throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        Signature ecdsaSignature = Signature.getInstance("SHA256withECDSA");
        ecdsaSignature.initVerify(publicKey);
        
        for (String message : messages) {
            ecdsaSignature.update(message.getBytes());
        }
        
        return ecdsaSignature.verify(signature);
    }

    
    public static PublicKey getPublicKeyFromBytes(byte[] keyBytes) throws Exception {
        KeyFactory keyFactory = KeyFactory.getInstance("EC");
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        return keyFactory.generatePublic(keySpec);
    }

   
    // Convert bytes to hexadecimal string
    public static String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(String.format("%02X", b));
        }
        return result.toString();
    }
}
