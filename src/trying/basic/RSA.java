import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Arrays;

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

    // Encrypt concatenated string
    public BigInteger encryptConcatenatedString(String concatenatedString) {
        byte[] bytes = concatenatedString.getBytes(StandardCharsets.UTF_8);
        return new BigInteger(bytes).modPow(publicKey, modulus);
    }

    // Decrypt single ciphertext to a string
    public String decryptAndSplit(BigInteger concatenatedCiphertext) {
        byte[] decryptedBytes = concatenatedCiphertext.modPow(privateKey, modulus).toByteArray();
        return new String(decryptedBytes, StandardCharsets.UTF_8);
    }

    public static void main(String[] args) {
        RSA rsa = new RSA();

        // Generate key pair with 2048-bit length
        rsa.generateKeyPair(2048);

        // Example usage with array of strings
        String[] messages = {"Hello", "World", "RSA is better than ECDSA"};
        System.out.println("Original messages: " + Arrays.toString(messages));

        // Concatenate strings
        String concatenatedString = String.join("", messages);

        // Encryption
        BigInteger encryptedConcatenatedString = rsa.encryptConcatenatedString(concatenatedString);
        System.out.println("Encrypted and concatenated message: " + encryptedConcatenatedString);

        // Decryption
        String decryptedMessage = rsa.decryptAndSplit(encryptedConcatenatedString);
        System.out.println("Decrypted message: " + decryptedMessage);
    }
}
