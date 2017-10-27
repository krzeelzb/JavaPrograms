package Zad4;

public class Polibiusz implements Algorithm {

    private String  alphabet="abcdefghijklmnopqrstuvwxyz";
    int [] num={11,12,13,14,15,
            21,22,23,23,24,25,
            31,32,33,34,35,
            41,42,43,44,45,
            51,52,53,54,55};

    @Override
    public String crypt(String tocrypt_) {
        tocrypt_=tocrypt_.toLowerCase();
        String toreturn="";
        for(int i=0;i<tocrypt_.length();i++){
            if (tocrypt_.charAt(i)==' '){
                i++;
            }
            int index=alphabet.indexOf(tocrypt_.charAt(i));
            toreturn+=Integer.toString(num[index])+" ";
        }
        return toreturn;
    }

    @Override
    public String decrypt(String todecrypt_) {
        String toreturn="";
        for(int i=0;i<todecrypt_.length()-1;i++){
            if (todecrypt_.charAt(i)==' '){
                i++;
            }
           String numberstr= Character.toString(todecrypt_.charAt(i))+Character.toString(todecrypt_.charAt(i+1));
           int  numberint=Integer.parseInt(numberstr);
           int index=0;
           for(int j=0;j<num.length;j++){
               if(num[j]==numberint){
                   index=j;
                   toreturn+=alphabet.charAt(index);
               }
           }
           i++;
        }

        return toreturn;
    }
}
