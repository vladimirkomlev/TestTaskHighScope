package highball;

import highball.encryption.EncryptPassword;

/**
 * Created by programmer on 31.01.17.
 */
public class MainTest {

    public static void main(String[] args){
        EncryptPassword encryptPassword=new EncryptPassword();
        String pass="1234";
        String res=encryptPassword.getHashPassword(pass);
        System.out.println(res);
    }
}
