import java.math.BigInteger;

public class Cell {

    public BigInteger previousHash;
    public BigInteger cellHash;
    public String message;
    RSA rsa = new RSA();

    public Cell(String message) {
        this.message = message;
        this.previousHash = null;
        this.cellHash = hash(message);
        System.out.println(cellHash);
    }

    private BigInteger hash(String input) {
        byte[] bytes = input.getBytes();
        BigInteger hashedBigInt = new BigInteger(bytes).modPow(rsa.publicKey, rsa.modulus);
        return hashedBigInt;
    }

    public static void main(String[] args) {
        Cell cell = new Cell("something");
    }
}
