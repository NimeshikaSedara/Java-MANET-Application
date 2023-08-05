import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;

public class AESKeyGenerator {

    public static SecretKey generateAESKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128); // You can choose 128, 192, or 256 as the key size for AES
        SecretKey secretKey = keyGen.generateKey();
        return secretKey;
    }

    public static void main(String[] args) {
        try {
            SecretKey aesKey = generateAESKey();
            System.out.println("Generated AES Secret Key: " + bytesToHex(aesKey.getEncoded()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    // Helper method to convert bytes to hexadecimal representation
    public static String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(String.format("%02X", b));
        }
        return result.toString();
    }
}
