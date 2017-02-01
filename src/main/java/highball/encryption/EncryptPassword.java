package highball.encryption;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptPassword {

    public String getHashPassword(String password) {
        String hashPassword = null;
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-1");
            byte[] byteData = md.digest(password.getBytes());
            StringBuilder hexResult = new StringBuilder();
            for (byte elementData : byteData) {
                hexResult.append(Integer.toString((elementData & 0xff) + 0x100, 16).substring(1));
            }
            hashPassword = hexResult.toString();
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Encrypt method getHashPassword(). " + e.getMessage());
        }
        return hashPassword;
    }
}
