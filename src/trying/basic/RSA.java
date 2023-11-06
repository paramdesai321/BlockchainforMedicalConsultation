import java.math.BigInteger;
import java.security.SecureRandom;

public class RSA {
    private BigInteger privateKey;
    private BigInteger publicKey;
    private BigInteger modulus;

    // Generate key pair
    public void generateKeyPair(int bitLength) {
        SecureRandom random = new SecureRandom();
        BigInteger p = new BigInteger(bitLength / 2, 100, random);
        BigInteger q = new BigInteger(bitLength / 2, 100, random);
        modulus = p.multiply(q);

        BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        publicKey = new BigInteger("65537"); // Commonly used public exponent
        privateKey = publicKey.modInverse(phi);
    }

    // Encrypt plaintext
    public BigInteger encrypt(BigInteger message) {
        return message.modPow(publicKey, modulus);
    }

    // Decrypt ciphertext
    public BigInteger decrypt(BigInteger ciphertext) {
        return ciphertext.modPow(privateKey, modulus);
    }

    public static void main(String[] args) {
        RSA rsa = new RSA();

        // Generate key pair with 2048-bit length
        rsa.generateKeyPair(2048);

        // Example usage
        BigInteger message = new BigInteger("48");
        System.out.println("Original message: " + message);

        // Encryption
        BigInteger encryptedMessage = rsa.encrypt(message);
        System.out.println("Encrypted message: " + encryptedMessage);

        // Decryption
        BigInteger decryptedMessage = rsa.decrypt(encryptedMessage);
        System.out.println("Decrypted message: " + decryptedMessage);
    }
}