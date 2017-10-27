package Zad4;

public class ROT11 implements Algorithm {

    //final static String  alphabet="abcdefghijklmnopqrstuvwxyz";
    final static String  alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
     String output="NOPQRSTUVWXYZABCDEFGHIJKLMnopqrstuvwxyzabcdefghijklm";

    @Override
    public String crypt(String tocrypt_) {
        String toreturn="";
        for (int i=0;i<tocrypt_.length();i++){
            toreturn+=output.charAt(alphabet.indexOf(tocrypt_.charAt(i)));
        }
        return toreturn;
    }

    @Override
    public String decrypt(String todecrypt_) {
        String toreturn="";
        for (int i=0;i<todecrypt_.length();i++){
            toreturn+=alphabet.charAt(output.indexOf(todecrypt_.charAt(i)));
        }

        return toreturn;
    }
}
